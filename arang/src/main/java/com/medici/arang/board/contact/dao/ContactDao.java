package com.medici.arang.board.contact.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.apache.tomcat.jdbc.pool.DataSource;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import com.medici.arang.board.contact.command.ContactCommand;
import com.medici.arang.board.contact.command.FindContactArtistCommand;
import com.medici.arang.board.contact.command.FindContactCommend;
import com.medici.arang.board.contact.command.FindContactGalleryCommand;
import com.medici.arang.board.contact.command.FindContactingArtistCommand;

@Repository
public class ContactDao {
	private JdbcTemplate jdbcTemplate;
	
	public ContactDao(DataSource dataSource) {
		jdbcTemplate = new JdbcTemplate(dataSource);
	}
	
	// contact 처리
	public void contactGallery(ContactCommand contactCommand) {
		String sql = "INSERT INTO Contact (galleryCode, artistId, sendingType) "
				+ "VALUES(?, ?, ?)";
		jdbcTemplate.update(sql, contactCommand.getGalleryCode(), 
				contactCommand.getArtistId(), contactCommand.getSendingType());
	}
	
	public void contactArtist(ContactCommand contactCommand) {
		String sql = "INSERT INTO Contact (galleryCode, artistId, comment, "
				+ "exhibitionTitle, startDate, endDate, sendingType) "
				+ "VALUES(?, ?, ?, ?, ?, ?, ?)";
		jdbcTemplate.update(sql, contactCommand.getGalleryCode(), 
				contactCommand.getArtistId(), contactCommand.getComment(),
				contactCommand.getExhibitionTitle(), contactCommand.getStartDate(),
				contactCommand.getEndDate(), contactCommand.getSendingType());
	}
	
	public List<ContactCommand> findContactList(long code) {
		String sql = "SELECT * FROM Contact WHERE galleryCode = ?";
		
		return jdbcTemplate.query(sql, new RowMapper<ContactCommand>() {
			public ContactCommand mapRow(ResultSet rs, int rowNum) throws SQLException {
				ContactCommand contactCommand = new ContactCommand(
						rs.getLong("contactId"), rs.getLong("galleryCode"), 
						rs.getLong("artistId"), rs.getString("comment"), 
						rs.getString("exhibitionTitle"), rs.getString("startDate"),
						rs.getString("endDate"), rs.getString("accept"),
						rs.getString("sendingType"), rs.getDate("regDate"));
				return contactCommand;
			}
		}, code);
		 
	}
	
	// 승낙/거절 처리
	public void acceptTpye(String accept, long id) {
		String sql = " UPDATE Contact SET accept=? WHERE contactId=?";
		jdbcTemplate.update(sql, accept, id);
	}
	
	
	public List<FindContactCommend> findArtistkById(long id) {
		String sql = "SELECT a.contactId, a.accept, a.regDate, b.name_kor, b.genre, "
				+ "b.imgPath, c.name, a.artistId, a.sendingType, b.name_eng "
				+ "FROM Contact a LEFT JOIN Artist b "
				+ "ON b.aid = a.artistId JOIN Artwork c "
				+ "ON a.artistId = c.artistId "
				+ "WHERE a.galleryCode = ? AND a.sendingType = ? GROUP BY a.contactId";
		
		return jdbcTemplate.query(sql, new RowMapper<FindContactCommend>() {

			public FindContactCommend mapRow(ResultSet rs, int rowNum) throws SQLException {
				FindContactCommend artist = new FindContactCommend(rs.getLong("contactId"),
						rs.getString("accept"), rs.getDate("regDate"),
						rs.getString("name_kor"), rs.getString("genre"),
						rs.getString("imgPath"), rs.getString("name"),
						rs.getLong("artistId"), rs.getString("sendingType"),
						rs.getString("name_eng"));
				return artist;
			}
		}, id, "A");
	}
	
	public List<FindContactGalleryCommand> findGalleryContacting(long id) {
	      String sql = "SELECT a.contactId, a.accept, a.regDate, b.galleryName_eng, "
	            + "b.galleryImgPath, a.startDate, a.endDate, a.exhibitionTitle, "
	            + "a.comment, a.galleryCode, a.sendingType, b.address FROM Contact a LEFT JOIN Gallery b "
	            + "ON b.code = a.galleryCode WHERE a.artistId = ? "
	            + "AND a.sendingType = ? GROUP BY a.contactId";
	      
	      return jdbcTemplate.query(sql, new RowMapper<FindContactGalleryCommand>() {

	         public FindContactGalleryCommand mapRow(ResultSet rs, int rowNum) throws SQLException {
	            FindContactGalleryCommand gallery = new FindContactGalleryCommand(
	                  rs.getLong("contactId"), rs.getString("accept"), 
	                  rs.getDate("regDate"), rs.getString("galleryName_eng"),
	                  rs.getString("galleryImgPath"), rs.getString("startDate"),
	                  rs.getString("endDate"), rs.getString("exhibitionTitle"),
	                  rs.getString("comment"), rs.getLong("galleryCode"), 
	                  rs.getString("sendingType"), rs.getString("address"));
	            return gallery;
	         }
	      }, id, "A");
	   }
	
	
	
	public List<FindContactGalleryCommand> findGalleryByEmail(long id) {
		String sql = "SELECT a.contactId, a.accept, a.regDate, b.galleryName_eng, "
				+ "b.galleryImgPath, a.startDate, a.endDate, a.exhibitionTitle, "
				+ "a.comment, a.galleryCode, a.sendingType, b.address FROM Contact a LEFT JOIN Gallery b "
				+ "ON b.code = a.galleryCode WHERE a.artistId = ? "
				+ "AND a.sendingType = ? GROUP BY a.contactId";
		
		return jdbcTemplate.query(sql, new RowMapper<FindContactGalleryCommand>() {

			public FindContactGalleryCommand mapRow(ResultSet rs, int rowNum) throws SQLException {
				FindContactGalleryCommand gallery = new FindContactGalleryCommand(
						rs.getLong("contactId"), rs.getString("accept"), 
						rs.getDate("regDate"), rs.getString("galleryName_eng"),
						rs.getString("galleryImgPath"), rs.getString("startDate"),
						rs.getString("endDate"), rs.getString("exhibitionTitle"),
						rs.getString("comment"), rs.getLong("galleryCode"), 
						rs.getString("sendingType"), rs.getString("address"));
				return gallery;
			}
		}, id, "G");
	}
	
	public List<FindContactCommend> findArtistkById(String email) {
		String sql = "SELECT a.contactId, a.accept, a.regDate, b.name_kor, b.genre, "
				+ "b.imgPath, c.name, a.artistId, a.sendingType, b.name_eng "
				+ "FROM Contact a LEFT JOIN Artist b "
				+ "ON b.aid = a.artistId JOIN Artwork c "
				+ "ON a.artistId = c.artistId "
				+ "WHERE a.galleryCode = ? AND a.sendingType = ? GROUP BY a.contactId";
		
		return jdbcTemplate.query(sql, new RowMapper<FindContactCommend>() {

			public FindContactCommend mapRow(ResultSet rs, int rowNum) throws SQLException {
				FindContactCommend artist = new FindContactCommend(rs.getLong("contactId"),
						rs.getString("accept"), rs.getDate("regDate"),
						rs.getString("name_kor"), rs.getString("genre"),
						rs.getString("imgPath"), rs.getString("name"),
						rs.getLong("artistId"), rs.getString("sendingType"),
						rs.getString("name_eng"));
				return artist;
			}
		}, email, "G");
	}
	
	
	public List<FindContactArtistCommand> findArtistkList(String email) {
		String sql = "SELECT a.accept, a.regDate, d.imgPath, d.name_kor, "
				+ "b.galleryImgPath, b.galleryName_eng, d.name_eng, d.genre, "
				+ "a.contactId, a.artistId FROM Contact a LEFT JOIN Gallery b "
				+ "ON b.code = a.galleryCode JOIN Gallerist c "
				+ "ON b.galleristEmail = c.email JOIN Artist d "
				+ "ON d.aid = a.artistId WHERE c.email = ? AND a.sendingType = ?";
		
		return jdbcTemplate.query(sql, new RowMapper<FindContactArtistCommand>() {

			public FindContactArtistCommand mapRow(ResultSet rs, int rowNum) throws SQLException {
				FindContactArtistCommand artist = new FindContactArtistCommand(
						rs.getString("accept"), rs.getTimestamp("regDate"), 
						rs.getString("imgPath"), rs.getString("name_kor"), 
						rs.getString("galleryImgPath"), rs.getString("galleryName_eng"),
						rs.getString("name_eng"), rs.getString("genre"), 
						rs.getLong("contactId"), rs.getLong("artistId"));
				return artist;
			}
		}, email, "A");
	}
	
	public List<FindContactingArtistCommand> findArtistList(String email) {
		String sql = "SELECT a.accept, a.regDate, d.imgPath, d.name_kor, "
				+ "d.name_eng, a.exhibitionTitle, a.startDate, a.endDate,  "
				+ "a.sendingType, a.comment, a.artistId  "
				+ "FROM Contact a LEFT JOIN Gallery b "
				+ "ON b.code = a.galleryCode JOIN Gallerist c "
				+ "ON b.galleristEmail = c.email JOIN Artist d "
				+ "ON d.aid = a.artistId WHERE c.email = ? AND a.sendingType = ?";
		
		return jdbcTemplate.query(sql, new RowMapper<FindContactingArtistCommand>() {
			public FindContactingArtistCommand mapRow(ResultSet rs, int rowNum) throws SQLException {
				FindContactingArtistCommand artist = new FindContactingArtistCommand(
						rs.getString("accept"), rs.getString("regDate"), 
						rs.getString("imgPath"), rs.getString("name_kor"), 
						rs.getString("name_eng"), rs.getString("exhibitionTitle"),
						rs.getString("startDate"), rs.getString("endDate"), 
						rs.getString("sendingType"), rs.getString("comment"), 
						rs.getLong("artistId"));
				return artist;
			}
		}, email, "G");
	}
	
	
}
