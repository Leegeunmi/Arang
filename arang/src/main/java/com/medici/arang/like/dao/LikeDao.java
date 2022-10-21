package com.medici.arang.like.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import javax.sql.DataSource;

import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import com.medici.arang.board.artist.command.ArtworkCommand;
import com.medici.arang.board.artist.command.FindArtistInfoCommand;
import com.medici.arang.board.gallery.command.GalleryPageCommand;
import com.medici.arang.like.domain.LikeVo;
import com.medici.arang.like.service.LikeRowMapper;
import com.medici.arang.user.command.ArtistPageCommand;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@Repository("likeDao")
public class LikeDao {
	private JdbcTemplate jdbcTemplate;
	
	public LikeDao(DataSource datasource) {
		jdbcTemplate = new JdbcTemplate(datasource);
	}
	
	public void likeUp(LikeVo likeVo) {
		String sql = " INSERT INTO LikeTable (userId, targetValue, likeNum)"
				+ " VALUES (?, ?, ?)";
		jdbcTemplate.update(sql, likeVo.getUserId(), likeVo.getTargetValue(),
				likeVo.getLikeNum());
	}
	
	public void likeDown(String userId, String targetValue) {
		String sql = "DELETE FROM LikeTable WHERE userId = ? AND targetValue = ?";
		jdbcTemplate.update(sql, userId, targetValue); 
	}
	
	//UPDATE
	public void updateLike(LikeVo likeVo, String userId, String targetValue) {
		String sql = "UPDATE LikeTable SET LikeNum = (SELECT COUNT(*) FROM Like)"				
				+ " WHERE userId = ? AND targetValue = ?";
		jdbcTemplate.update
				(sql, likeVo.getUserId(), likeVo.getTargetValue(),
						likeVo.getLikeNum(), userId, targetValue);
	}
	
	//COUNT
	public int getLike(String userId, String targetValue) {
		String sql = "SELECT Count(*) FROM LikeTable"
				+ " WHERE userId = ? AND targetValue = ?";
		return jdbcTemplate.queryForObject(sql, int.class, userId, targetValue);
	}
	
	//FIND by 아이디, 대상아이디(Ajax)
	public LikeVo findLike(String userId, String targetValue) {
		String sql = "SELECT * FROM LikeTable"
				+ " WHERE userId = ? AND targetValue = ?";
		try {
			return jdbcTemplate.queryForObject(sql, new LikeRowMapper(), userId, targetValue);			
		} catch (EmptyResultDataAccessException e) {
			return null;
		}
	}
	
	//FIND by 아이디, 대상아이디
	public LikeVo findLike(String userId, long targetValue) {
		String sql = "SELECT * FROM LikeTable"
				+ " WHERE userId = ? AND targetValue = ?";
		try {
			return jdbcTemplate.queryForObject(sql, new LikeRowMapper(), userId, targetValue);			
		} catch (EmptyResultDataAccessException e) {
			return null;
		}
	}
	
	//FIND ALL
	public List<LikeVo> findLike() {
		String sql = "SELECT * FROM LikeTable";
		return jdbcTemplate.query(sql, new LikeRowMapper());
	}
	
	//FIND by 아이디
	public List<LikeVo> findLike(String userId) {
		String sql = "SELECT * FROM LikeTable"
				+ " WHERE userId = ?";
			return jdbcTemplate.query(sql, new LikeRowMapper(), userId);			
	}
	
	public LikeVo findLikeByTargetId(long targetValue) {
		String sql = "SELECT * FROM LikeTable"
				+ " WHERE targetValue = ?";
		try {
			return jdbcTemplate.queryForObject(sql, new LikeRowMapper(), targetValue);			
		} catch (EmptyResultDataAccessException e) {
			return null;
		}
	}
	
	
	//4중조인후 유저 이메일 세션을 ?에 넣어서 찾아서 리스트뽑아주기
	public List<ArtistPageCommand> findArtistJoinLike(String email)	{
		String sql = "SELECT a.name_kor, a.name_eng, a.genre, a.imgPath,"
				+" b.artworkImgPath, a.aid, b.wid, c.title, d.userId"
				+" FROM Artist a LEFT JOIN Artwork b ON b.artistId = a.aid JOIN ArtistInfo c"
				+" ON c.artistId = b.artistId JOIN LikeTable d ON d.targetValue = c.artistId"
				+" WHERE d.userId=?"
				+" GROUP BY a.aid";
		return jdbcTemplate.query(sql, new RowMapper<ArtistPageCommand>() {
			
			public ArtistPageCommand mapRow(ResultSet rs, int rowNum) throws SQLException {
				ArtistPageCommand artistInfo = new ArtistPageCommand(
						rs.getString("name_kor"), rs.getString("name_eng"), 
						rs.getString("genre"), rs.getString("imgPath"), 
						rs.getString("artworkImgPath"), rs.getLong("aid"),
						rs.getLong("wid"), rs.getString("title"));
				return artistInfo;
			}
		}, email);
	}
	
	//작품과 좋아요 이중조인후 이메일세션으로 리스트 뽑
	public List<ArtworkCommand> findArtworkJoinLike(String email) {
		String sql = "SELECT a.wid, a.artistId, a.name, a.genre, a.technique, a.size,"
				+ " a.publicationDate, a.description, a.artworkImgPath"
				+ " FROM Artwork a INNER JOIN LikeTable b"
				+ " ON a.wid = b.targetValue WHERE b.userId=?";
		
		return jdbcTemplate.query(sql, new RowMapper<ArtworkCommand>() {
			
			public ArtworkCommand mapRow(ResultSet rs, int rowNum) throws SQLException {
				ArtworkCommand artworkCommand = new ArtworkCommand(rs.getLong("wid"),
						rs.getLong("artistId"), rs.getString("name"), 
						rs.getString("genre"), rs.getString("technique"), 
						rs.getString("size"), rs.getString("publicationDate"), 
						rs.getString("description"), rs.getString("artworkImgPath"));
				return artworkCommand;
			}
		}, email);
	}
	
	// 갤러리, 갤러리인포, 좋아요 삼중 조인후 세션 이메일로 리스트찾기
		public List<GalleryPageCommand> findGalleryJoinLike(String email){
			String sql = "SELECT a.code, a.galleristEmail, a.galleryName_kor, "
					+ " a.galleryName_eng, a.address, a.galleryEmail, "
					+ " a.galleryPhone, a.since, a.area, a.openClose, "
					+ " a.galleryImgPath, b.description, b.infoImgPath "
					+ " FROM GalleryInfo b LEFT JOIN Gallery a "
					+ " ON a.code = b.galleryCode INNER JOIN LikeTable c"
					+ " ON a.code = c.targetValue WHERE c.userId=?";
			return jdbcTemplate.query(sql, new RowMapper<GalleryPageCommand>() {
				public GalleryPageCommand mapRow(ResultSet rs, int rowNum) throws SQLException {
					GalleryPageCommand artistInfo = new GalleryPageCommand(
							rs.getLong("code"), rs.getString("galleristEmail"),
							rs.getString("galleryName_kor"), rs.getString("galleryName_eng"), 
							rs.getString("address"), rs.getString("galleryEmail"), 
							rs.getString("galleryPhone"), rs.getString("since"), 
							rs.getString("area"), rs.getString("openClose"),
							rs.getString("galleryImgPath"), rs.getString("description"),
							rs.getString("infoImgPath"));
					return artistInfo;
				}
			}, email);
		}
		
	public long getLikeArtistCount(String email) {
		String sql = "SELECT count(*) FROM ArtistInfo a INNER JOIN LikeTable b"
				+ " ON a.artistId = b.targetValue WHERE b.userId=?";
		return jdbcTemplate.queryForObject(sql, Long.class, email);
	}
}
