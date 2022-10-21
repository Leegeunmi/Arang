package com.medici.arang.user.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import javax.servlet.annotation.MultipartConfig;

import org.apache.tomcat.jdbc.pool.DataSource;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort.Order;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;

import com.medici.arang.board.artist.command.ArtworkCommand;
import com.medici.arang.user.command.ArtistCommand;
import com.medici.arang.user.command.ArtistPageCommand;

public class ArtistDao {
	private JdbcTemplate jdbcTemplate;
	
	public ArtistDao(DataSource dataSource) {
		jdbcTemplate = new JdbcTemplate(dataSource);
	}
	
	//아티스트 유저 추가
	public void addArtist(ArtistCommand artistCommand) {
		String sql = "INSERT INTO Artist (email, passwd, name_kor, name_eng, "
				+ "ssn, phone, genre, career, imgPath)"
				+ " VALUES(?, ?, ?, ?, ?, ?, ?, ?, ?)";
		jdbcTemplate.update(sql,artistCommand.getEmail(), artistCommand.getPasswd(),
				artistCommand.getName_kor(), artistCommand.getName_eng(), 
				artistCommand.getSsn(), artistCommand.getPhone(),
				artistCommand.getGenre(), artistCommand.getCareer(), 
				artistCommand.getImgPath());
	}
			
	//로그인 유효성 검증용
	public boolean isValidUser(String email, String passwd) {
		String sql = "SELECT count(*) FROM Artist WHERE email=? AND passwd=?";
		boolean result = true;
		int ishere = jdbcTemplate.queryForObject(sql, Integer.class, email, passwd);
		if(ishere == 0 ) {
			result = false;
		}
		return result;
	}		
	
	//모든 아티스트 조회
	public List<ArtistCommand> getAllArtist() {
		String sql = "SELECT * FROM Artist";
		return jdbcTemplate.query(sql, new ArtistRowMapper());
	}
	
	//이메일로 해당 유저 찾기
	public ArtistCommand getArtistByEmail(String email) {
		String sql = "SELECT * FROM Artist WHERE email=?";
		return jdbcTemplate.queryForObject(sql, new ArtistRowMapper(), email);
	}
	
	public ArtistPageCommand findArtistkById(long id) {
		String sql = "SELECT a.name_kor, a.name_eng, a.genre, a.imgPath, "
				+ "b.artworkImgPath, a.aid, b.wid, c.title "
				+ "FROM Artist a INNER JOIN artwork b "
				+ "ON b.artistId = a.aid JOIN ArtistInfo c ON a.aid = c.artistId "
				+ "WHERE a.aid = ? GROUP BY b.artistId";
		
		return jdbcTemplate.queryForObject(sql, new RowMapper<ArtistPageCommand>() {
			
			@Override
			public ArtistPageCommand mapRow(ResultSet rs, int rowNum) throws SQLException {
				ArtistPageCommand artist = new ArtistPageCommand(
						rs.getString("name_kor"), rs.getString("name_eng"), 
						rs.getString("genre"), rs.getString("imgPath"), 
						rs.getString("artworkImgPath"), rs.getLong("aid"),
						rs.getLong("wid"), rs.getString("title"));
				return artist;
			}
		}, id);
	}
	
	public List<ArtistPageCommand> findAllArtistkByEmail() {
		String sql = "SELECT a.name_kor, a.name_eng, a.genre, a.imgPath, "
				+ "b.artworkImgPath, a.aid, b.wid, c.title "
				+ "FROM Artist a INNER JOIN artwork b "
				+ "ON b.artistId = a.aid JOIN ArtistInfo c ON a.aid = c.artistId "
				+ "GROUP BY b.artistId";
		
		return jdbcTemplate.query(sql, new RowMapper<ArtistPageCommand>() {
			
			@Override
			public ArtistPageCommand mapRow(ResultSet rs, int rowNum) throws SQLException {
				ArtistPageCommand artist = new ArtistPageCommand(
						rs.getString("name_kor"), rs.getString("name_eng"), 
						rs.getString("genre"), rs.getString("imgPath"), 
						rs.getString("artworkImgPath"), rs.getLong("aid"),
						rs.getLong("wid"), rs.getString("title"));
				return artist;
			}
		});
	}
	
	// 아티스트 업데이트
	public void updateArtist(ArtistCommand artist) {
		String sql = "UPDATE Artist SET passwd=?, phone=?, imgPath=? WHERE email = ?";
		
		jdbcTemplate.update(sql, artist.getPasswd(), artist.getPhone(), 
				artist.getImgPath(), artist.getEmail());
	}
	
	// 페이징 부분
	public Page<ArtistPageCommand> findAllPage(Pageable pageable){
		Order order = pageable.getSort().isEmpty()
				? Order.by("aid")
				: pageable.getSort().toList().get(0);
		String sql = "SELECT a.name_kor, a.name_eng, a.genre, a.imgPath, "
				+ "b.artworkImgPath, a.aid, b.wid, c.title FROM Artist a "
				+ "INNER JOIN artwork b ON b.artistId = a.aid JOIN ArtistInfo c "
				+ "ON a.aid = c.artistId GROUP BY b.artistId"
				+ " ORDER BY " + order.getProperty() + " " + order.getDirection().name()
				//MY SQL
				+ " LIMIT " + pageable.getPageSize()
				+ " OFFSET " + pageable.getOffset();
		return new PageImpl<ArtistPageCommand>(
				jdbcTemplate.query(sql, new RowMapper<ArtistPageCommand>() {
					@Override
					public ArtistPageCommand mapRow(ResultSet rs, int rowNum) throws SQLException {
						ArtistPageCommand artist = new ArtistPageCommand(
								rs.getString("name_kor"), rs.getString("name_eng"), 
								rs.getString("genre"), rs.getString("imgPath"), 
								rs.getString("artworkImgPath"), rs.getLong("aid"),
								rs.getLong("wid"), rs.getString("title"));
						return artist;
					}
				}),
				pageable, getCount());
		}
	
	public Page<ArtistPageCommand> findAllPageByGenre(Pageable pageable, String genre){
		Order order = pageable.getSort().isEmpty()
				? Order.by("aid")
				: pageable.getSort().toList().get(0);
		String sql = "SELECT a.name_kor, a.name_eng, a.genre, a.imgPath, "
				+ "b.artworkImgPath, a.aid, b.wid, c.title FROM Artist a "
				+ "INNER JOIN artwork b ON b.artistId = a.aid JOIN ArtistInfo c "
				+ "ON a.aid = c.artistId WHERE b.genre = ? GROUP BY b.artistId"
				+ " ORDER BY " + order.getProperty() + " " + order.getDirection().name()
				//MY SQL
				+ " LIMIT " + pageable.getPageSize()
				+ " OFFSET " + pageable.getOffset();
		return new PageImpl<ArtistPageCommand>(
				jdbcTemplate.query(sql, new RowMapper<ArtistPageCommand>() {
					@Override
					public ArtistPageCommand mapRow(ResultSet rs, int rowNum) throws SQLException {
						ArtistPageCommand artist = new ArtistPageCommand(
								rs.getString("name_kor"), rs.getString("name_eng"), 
								rs.getString("genre"), rs.getString("imgPath"), 
								rs.getString("artworkImgPath"), rs.getLong("aid"),
								rs.getLong("wid"), rs.getString("title"));
						return artist;
					}
				}, genre),
				pageable, getCount());
		}
	
	public List<ArtistPageCommand> findAllArtistkByGenre(String ctg) {
		String sql = "SELECT a.name_kor, a.name_eng, a.genre, a.imgPath, "
				+ "b.artworkImgPath, a.aid, b.wid, c.title "
				+ "FROM Artist a INNER JOIN artwork b "
				+ "ON b.artistId = a.aid JOIN ArtistInfo c ON a.aid = c.artistId "
				+ "WHERE a.genre = ? GROUP BY b.artistId";
		
		return jdbcTemplate.query(sql, new RowMapper<ArtistPageCommand>() {
			
			@Override
			public ArtistPageCommand mapRow(ResultSet rs, int rowNum) throws SQLException {
				ArtistPageCommand artist = new ArtistPageCommand(
						rs.getString("name_kor"), rs.getString("name_eng"), 
						rs.getString("genre"), rs.getString("imgPath"), 
						rs.getString("artworkImgPath"), rs.getLong("aid"),
						rs.getLong("wid"), rs.getString("title"));
				return artist;
			}
		}, ctg);
	}
	
	public List<ArtistPageCommand> findAllArtist() {
		String sql = "SELECT a.name_kor, a.name_eng, a.genre, a.imgPath, "
				+ "b.artworkImgPath, a.aid, b.wid, c.title "
				+ "FROM Artist a INNER JOIN artwork b "
				+ "ON b.artistId = a.aid JOIN ArtistInfo c ON a.aid = c.artistId "
				+ "WHERE a.genre = ? GROUP BY b.artistId";
		
		return jdbcTemplate.query(sql, new RowMapper<ArtistPageCommand>() {
			
			@Override
			public ArtistPageCommand mapRow(ResultSet rs, int rowNum) throws SQLException {
				ArtistPageCommand artist = new ArtistPageCommand(
						rs.getString("name_kor"), rs.getString("name_eng"), 
						rs.getString("genre"), rs.getString("imgPath"), 
						rs.getString("artworkImgPath"), rs.getLong("aid"),
						rs.getLong("wid"), rs.getString("title"));
				return artist;
			}
		});
	}
	
	public Page<ArtistPageCommand> findPageByGenre(Pageable pageable, String ctg){
		Order order = pageable.getSort().isEmpty()
				? Order.by("aid")
				: pageable.getSort().toList().get(0);
		String sql = "SELECT a.name_kor, a.name_eng, a.genre, a.imgPath, "
				+ "b.artworkImgPath, a.aid, b.wid, c.title "
				+ "FROM Artist a INNER JOIN artwork b "
				+ "ON b.artistId = a.aid JOIN ArtistInfo c ON a.aid = c.artistId "
				+ "WHERE a.genre = ? GROUP BY b.artistId"
				+ " ORDER BY " + order.getProperty() + " " + order.getDirection().name()
				//MY SQL
				+ " LIMIT " + pageable.getPageSize()
				+ " OFFSET " + pageable.getOffset();
		return new PageImpl<ArtistPageCommand>(
				jdbcTemplate.query(sql, new RowMapper<ArtistPageCommand>() {
					@Override
					public ArtistPageCommand mapRow(ResultSet rs, int rowNum) throws SQLException {
						ArtistPageCommand artist = new ArtistPageCommand(
								rs.getString("name_kor"), rs.getString("name_eng"), 
								rs.getString("genre"), rs.getString("imgPath"), 
								rs.getString("artworkImgPath"), rs.getLong("aid"),
								rs.getLong("wid"), rs.getString("title"));
						return artist;
					}
				}, ctg),
				pageable,
				getCount());
		}
	
	public long getCount() {
		String sql = "SELECT count(*) FROM Artist";
		return jdbcTemplate.queryForObject(sql, Long.class);
	}
}
