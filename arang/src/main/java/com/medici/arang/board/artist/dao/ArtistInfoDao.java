package com.medici.arang.board.artist.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.apache.tomcat.jdbc.pool.DataSource;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import com.medici.arang.board.artist.command.ArtistInfoCommand;
import com.medici.arang.board.artist.command.FindArtistInfoCommand;

@Repository("artistInfoDao")
public class ArtistInfoDao {
	
	private JdbcTemplate jdbcTemplate;
	
	public ArtistInfoDao(DataSource dataSource) {
		jdbcTemplate = new JdbcTemplate(dataSource);
	}
	
	public void addArtistInfo(ArtistInfoCommand artistInfo) {
		String sql = "INSERT INTO ArtistInfo (artistId, title, description, "
				+ "infoImgPath) VALUES (?, ?, ?, ?)";
		System.out.println("성공!!");
		jdbcTemplate.update(sql, artistInfo.getArtistId(), 
				artistInfo.getTitle(), artistInfo.getDescription(),
				artistInfo.getInfoImgPath());
	}
	
	public FindArtistInfoCommand findArtistInfo(long id) {
		String sql = "SELECT a.name_kor, a.name_eng, a.ssn, a.imgPath, a.genre, b.title, "
				+ "b.infoImgPath, b.description, a.aid FROM ArtistInfo b LEFT JOIN Artist a "
				+ "ON a.aid = b.artistId WHERE a.aid = ?";
		try {
		return jdbcTemplate.queryForObject(sql, new RowMapper<FindArtistInfoCommand>() {
			public FindArtistInfoCommand mapRow(ResultSet rs, int rowNum) throws SQLException {
				FindArtistInfoCommand artistInfo = new FindArtistInfoCommand(rs.getString("name_kor"),
						rs.getString("name_eng"), rs.getString("ssn"), 
						rs.getString("imgPath"), rs.getString("genre"),
						rs.getString("title"), rs.getString("description"),
						rs.getString("infoImgPath"), rs.getLong("aid"));
				return artistInfo;
			}
		}, id);
		} catch (EmptyResultDataAccessException e) {
			return null;
		}
	}
	
	public List<FindArtistInfoCommand> findArtist() {
		String sql = "SELECT a.name_kor, a.name_eng, a.ssn, a.imgPath, a.genre, b.title, "
				+ "b.infoImgPath, b.description, a.aid FROM ArtistInfo b LEFT JOIN Artist a "
				+ "ON a.aid = b.artistId";
		return jdbcTemplate.query(sql, new RowMapper<FindArtistInfoCommand>() {
			
			public FindArtistInfoCommand mapRow(ResultSet rs, int rowNum) throws SQLException {
				FindArtistInfoCommand artistInfo = new FindArtistInfoCommand(rs.getString("name_kor"), 
						rs.getString("name_eng"), rs.getString("ssn"), 
						rs.getString("imgPath"), rs.getString("genre"),
						rs.getString("title"), rs.getString("description"),
						rs.getString("infoImgPath"), rs.getLong("aid"));
				return artistInfo;
			}
		});
	}
	
	public long getArtistCount() {
		String sql = "SELECT count(*) FROM ArtistInfo";
		return jdbcTemplate.queryForObject(sql, Long.class);
	}
}
