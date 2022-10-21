package com.medici.arang.board.artist.dao;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.apache.tomcat.jdbc.pool.DataSource;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import com.medici.arang.board.artist.command.ArtworkInfoCommand;
import com.medici.arang.board.artist.command.FindArtworkInfoCommand;

@Repository("artworkInfoDao")
public class ArtworkInfoDao {
	
	private JdbcTemplate jdbcTemplate;
	
	public ArtworkInfoDao(DataSource dataSource) {
		jdbcTemplate = new JdbcTemplate(dataSource);
	}
	
	public void addArtworkInfo(ArtworkInfoCommand artworkInfo) {
		String sql = "INSERT INTO ArtworkInfo (artworkId, mainTitle, subTitle, "
				+ "workInfoImgPath) VALUES (?, ?, ?, ?)";
		System.out.println("성공!!");
		jdbcTemplate.update(sql, artworkInfo.getArtworkId(), 
				artworkInfo.getMainTitle(), artworkInfo.getSubTitle(),
				artworkInfo.getWorkInfoImgPath());
	}
	
	
	
	public FindArtworkInfoCommand findArtworkInfo(long id) {
		String sql = "SELECT a.name, a.genre, a.technique, a.size, "
				+ "a.publicationDate, a.description, a.artworkImgPath, "
				+ "b.mainTitle, b.subTitle, b.workInfoImgPath "
				+ "FROM Artwork a INNER JOIN ArtworkInfo b "
				+ "ON a.wid = b.artworkId WHERE a.wid = ?";
		
		return jdbcTemplate.queryForObject(sql, new RowMapper<FindArtworkInfoCommand>() {
			
			public FindArtworkInfoCommand mapRow(ResultSet rs, int rowNum) throws SQLException {
				FindArtworkInfoCommand artworkInfo = new FindArtworkInfoCommand(rs.getString("name"),
						rs.getString("genre"), rs.getString("technique"), 
						rs.getString("size"), rs.getString("publicationDate"),
						rs.getString("description"), rs.getString("artworkImgPath"),
						rs.getString("mainTitle"), rs.getString("subTitle"), 
						rs.getString("workInfoImgPath"));
				return artworkInfo;
			}
		}, id);
	}
	
}
