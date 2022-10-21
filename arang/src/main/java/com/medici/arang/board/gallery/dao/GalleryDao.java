package com.medici.arang.board.gallery.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.apache.tomcat.jdbc.pool.DataSource;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import com.medici.arang.board.gallery.command.GalleryCommand;
import com.medici.arang.board.gallery.command.GalleryPageCommand;
import com.medici.arang.board.gallery.domain.GalleristRowMapper;
import com.medici.arang.board.gallery.domain.GalleryRowMapper;
import com.medici.arang.board.gallery.domain.GalleryVo;
import com.medici.arang.user.command.GalleristCommend;

import lombok.NoArgsConstructor;

@NoArgsConstructor
@Repository
public class GalleryDao {
	private JdbcTemplate jdbcTemplate;
	
	public GalleryDao(DataSource dataSource) {
		jdbcTemplate = new JdbcTemplate(dataSource);
	}
	
	//갤러리스트가 신규 갤러리 글 추가
	public void insertGallery(GalleryCommand galleryCommand) {
		String sql = "INSERT INTO Gallery (galleristEmail, galleryName_kor, galleryName_eng, "
				+" address, galleryEmail, galleryPhone, since, area, "
				+ " openClose, representer, representerNum, galleryImgPath) "
				+" VALUES(?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?) ";
		jdbcTemplate.update(sql,galleryCommand.getGalleristEmail() ,galleryCommand.getGalleryName_kor(),
				galleryCommand.getGalleryName_eng(), galleryCommand.getAddress(), 
				galleryCommand.getGalleryEmail(), galleryCommand.getGalleryPhone(), 
				galleryCommand.getSince(), galleryCommand.getArea(), 
				galleryCommand.getOpenClose(), galleryCommand.getRepresenter(), 
				galleryCommand.getRepresenterNum(), galleryCommand.getGalleryImgPath());
	}
	
	//등록된 갤러리 수정
	public void updateGallery(GalleryCommand galleryCommand, long code) {
		String sql = " UPDATE Gallery SET (galleryName_kor=?, galleryName_eng=?,"
				+ " address=?, galleryEmail=?, galleryPhone=?, since=?, area=?, "
				+ " openClose=?, representer=?, representerNum=?, galleryImgPath=?"
				+ " WHERE code=?";
		jdbcTemplate.update(sql,galleryCommand.getGalleristEmail() ,galleryCommand.getGalleryName_kor(),
				galleryCommand.getGalleryName_eng(), galleryCommand.getAddress(), 
				galleryCommand.getGalleryEmail(), galleryCommand.getGalleryPhone(), 
				galleryCommand.getSince(), galleryCommand.getArea(), 
				galleryCommand.getOpenClose(), galleryCommand.getRepresenter(), 
				galleryCommand.getRepresenterNum(), galleryCommand.getGalleryImgPath(),code);
	}
	
	//등록된 갤러리 삭제
	public void deleteGallery(long code) {
		String sql = "DELETE FROM Gallery WHERE code = ? ";
		jdbcTemplate.update(sql, code);
	}
	
	public GalleryCommand findAllGalleryByRepresenterNum(String num){
		String sql = "SELECT * FROM Gallery WHERE representerNum = ?";
		return jdbcTemplate.queryForObject(sql, new GalleryRowMapper(), num);
	}
	
	public long getGalleryCount() {
		String sql = "SELECT count(*) FROM Gallery";
		return jdbcTemplate.queryForObject(sql, Long.class);
	}

	public GalleryCommand findGalleryByEmail(String email) {
		String sql = "SELECT * FROM Gallery WHERE galleristEmail = ?";
		return jdbcTemplate.queryForObject(sql, new GalleryRowMapper(), email);
	}
	
	public List<GalleryCommand> findGalleryListByEmail(String email) {
		String sql = "SELECT * FROM Gallery WHERE galleristEmail = ?";
		return jdbcTemplate.query(sql, new GalleryRowMapper(), email);
	}
	
	
	public List<GalleryCommand> findAllGalleryInfo(){
		String sql = "SELECT * FROM Gallery";
		return jdbcTemplate.query(sql, new GalleryRowMapper());
	}
	public GalleristCommend GalleristbyEmail(String email){
		String sql = "select * from Gallerist where email = ?";
		return jdbcTemplate.queryForObject(sql, new GalleristRowMapper(), email);
	}
	
	public List<GalleryCommand> findImgPath(){
		String sql = "SELECT imgPath FROM Gallery";
		return jdbcTemplate.query(sql, new GalleryRowMapper());
	}
	
	//해당 코드의 갤러리 하나 찾기
	public GalleryCommand findOneGalleryInfo(long code){
		String sql = "SELECT * FROM Gallery where code = ?";
		return jdbcTemplate.queryForObject(sql, new GalleryRowMapper(), code);
	}
	
	public List<GalleryPageCommand> findMyGallery(String email){
		String sql = "SELECT a.code, a.galleristEmail, a.galleryName_kor, "
				+ "a.galleryName_eng, a.address, a.galleryEmail, "
				+ "a.galleryPhone, a.since, a.area, a.openClose, "
				+ "a.galleryImgPath, b.description, b.infoImgPath "
				+ "FROM GalleryInfo b LEFT JOIN Gallery a "
				+ "ON a.code = b.galleryCode WHERE a.galleristEmail = ?";
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
	
}
