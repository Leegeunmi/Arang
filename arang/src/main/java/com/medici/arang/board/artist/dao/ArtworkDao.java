package com.medici.arang.board.artist.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.apache.tomcat.jdbc.pool.DataSource;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import com.medici.arang.board.artist.command.ArtworkCommand;

@Repository("artworkDao")
public class ArtworkDao {
	
	private JdbcTemplate jdbcTemplate;
	
	public ArtworkDao(DataSource dataSource) {
		jdbcTemplate = new JdbcTemplate(dataSource);
	}
	
	public void addArtwork(ArtworkCommand artworkCommand) {
		String sql = "INSERT INTO Artwork (artistId, name, genre, technique,"
				+ "size, publicationDate, description, artworkImgPath) "
				+ "VALUES (?, ?, ?, ?, ?, ? ,? ,?)";
		System.out.println("성공!!");
		jdbcTemplate.update(sql, artworkCommand.getArtistId(), 
				artworkCommand.getName(), artworkCommand.getGenre(),
				artworkCommand.getTechnique(), artworkCommand.getSize(), 
				artworkCommand.getPublicationDate(), artworkCommand.getDescription(), 
				artworkCommand.getArtworkImgPath());
	}
	
	
	public List<ArtworkCommand> allfindArtwork(long artistId) {
		String sql = "SELECT * FROM Artwork WHERE artistId = ?";
		
		return jdbcTemplate.query(sql, new RowMapper<ArtworkCommand>() {
			
			public ArtworkCommand mapRow(ResultSet rs, int rowNum) throws SQLException {
				ArtworkCommand artworkCommand = new ArtworkCommand(rs.getLong("wid"), 
						rs.getLong("artistId"), rs.getString("name"), 
						rs.getString("genre"), rs.getString("technique"), 
						rs.getString("size"), rs.getString("publicationDate"),
						rs.getString("description"), rs.getString("artworkImgPath"));
				return artworkCommand;
			}
		}, artistId);
	}
	
	
	public ArtworkCommand findArtwork(long id) {
		String sql = "SELECT * FROM Artist WHERE artistId = ?";
		
		return jdbcTemplate.queryForObject(sql, new RowMapper<ArtworkCommand>() {
			
			public ArtworkCommand mapRow(ResultSet rs, int rowNum) throws SQLException {
				ArtworkCommand artworkCommand = new ArtworkCommand(rs.getLong("wid"), 
						rs.getLong("artistId"), rs.getString("name"), 
						rs.getString("genre"), rs.getString("technique"), 
						rs.getString("size"), rs.getString("publicationDate"),
						rs.getString("description"), rs.getString("imgPath"));
				return artworkCommand;
			}
		}, id);
	}
	
	public ArtworkCommand findArtworkByImg(String imgName) {
		String sql = "SELECT * FROM Artwork WHERE artworkImgPath = ?";
		
		return jdbcTemplate.queryForObject(sql, new RowMapper<ArtworkCommand>() {
			
			public ArtworkCommand mapRow(ResultSet rs, int rowNum) throws SQLException {
				ArtworkCommand artworkCommand = new ArtworkCommand(rs.getLong("wid"), 
						rs.getLong("artistId"), rs.getString("name"), 
						rs.getString("genre"), rs.getString("technique"), 
						rs.getString("size"), rs.getString("publicationDate"),
						rs.getString("description"), rs.getString("artworkImgPath"));
				return artworkCommand;
			}
		}, imgName);
	}
	
	

	public void updateArtwork(ArtworkCommand artwork) {
		String sql = "UPDATE Artwork SET artistId = ?, name = ?, "
				+ "genre = ?, technique = ?, size = ?, publicationDate = ? "
				+ "description = ?, artworkImgPath = ? WHERE wid = ?";
		jdbcTemplate.update(sql, artwork.getArtistId(),	artwork.getName(), 
				artwork.getGenre(), artwork.getTechnique(), artwork.getSize(), 
				artwork.getPublicationDate(), artwork.getDescription(), 
				artwork.getArtworkImgPath(), artwork.getWid());
	}
	
	public void deleteArtwork(long id) {
		String sql = "DELETE FROM Artwork WHERE wid=?";
		jdbcTemplate.update(sql, id);
	}
	
	public List<ArtworkCommand> allFindArtwork() {
		String sql = "SELECT * FROM Artwork";
		
		return jdbcTemplate.query(sql, new RowMapper<ArtworkCommand>() {
			
			public ArtworkCommand mapRow(ResultSet rs, int rowNum) throws SQLException {
				ArtworkCommand artworkCommand = new ArtworkCommand(rs.getLong("wid"),
						rs.getLong("artistId"), rs.getString("name"), 
						rs.getString("genre"), rs.getString("technique"), 
						rs.getString("size"), rs.getString("publicationDate"), 
						rs.getString("description"), rs.getString("artworkImgPath"));
				return artworkCommand;
			}
		});
	}
	

	public List<ArtworkCommand> findArtworkByArtist(long id) {
		String sql = "SELECT * FROM Artwork WHERE artistId = ?";
		
		return jdbcTemplate.query(sql, new RowMapper<ArtworkCommand>() {
			
			public ArtworkCommand mapRow(ResultSet rs, int rowNum) throws SQLException {
				ArtworkCommand artworkCommand = new ArtworkCommand(rs.getLong("wid"),
						rs.getLong("artistId"), rs.getString("name"), 
						rs.getString("genre"), rs.getString("technique"), 
						rs.getString("size"), rs.getString("publicationDate"), 
						rs.getString("description"), rs.getString("artworkImgPath"));
				return artworkCommand;
			}
		}, id);
	}
	
	
}
