package com.medici.arang.user.dao;



import java.util.List;

import org.apache.tomcat.jdbc.pool.DataSource;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.medici.arang.board.gallery.domain.GalleristRowMapper;
import com.medici.arang.user.command.ArtistCommand;
import com.medici.arang.user.command.GalleristCommend;
import com.medici.arang.user.domain.GalleristVo;

import lombok.NoArgsConstructor;

@Repository
@NoArgsConstructor
public class GalleristDao {
	private JdbcTemplate jdbcTemplate;
	
	public GalleristDao(DataSource dataSource) {
		jdbcTemplate = new JdbcTemplate(dataSource);
	}
	
	public void insertGallerist(GalleristCommend commend) {
		String sql = "insert into gallerist (email, passwd, name, ssn, "
				+ "phone, imgPath) values (?,?,?,?,?,?)";
		jdbcTemplate.update(sql, commend.getEmail(), commend.getPasswd(),
				commend.getName(), commend.getSsn(), commend.getPhone(), 
				commend.getImgPath());
	}
	public long updateGallerist(GalleristCommend commend, long num) {
		String sql = "update gallerist set(email =?, passwd=?, name=?, ssn=?, phone=?, imgPath=?) where num=?";
		return jdbcTemplate.update(sql, commend.getEmail(), commend.getName(), commend.getPasswd(),
				commend.getSsn(), commend.getPhone(), commend.getImgPath(), num);
	}
	public long deleteGallerist(long num) {
		String sql = "delete from gallerist where num = ?";
		return jdbcTemplate.update(sql, num);
	}
	public List<GalleristCommend> findAllGallerist(){
		String sql = "SELECT * FROM gallerist";
		return jdbcTemplate.query(sql, new GalleristRowMapper());
	}
	public GalleristCommend findOneGallerist(long num) {
		String sql = "select * from gallerist where num = ?";
		return jdbcTemplate.queryForObject(sql, new GalleristRowMapper(), num);
	}
	
	public GalleristCommend findMyGallerist(String email) {
		String sql = "select * from Gallerist where email = ?";
		return jdbcTemplate.queryForObject(sql, new GalleristRowMapper(), email);
	}
	
	public void updateGalleristByEmail(GalleristCommend gallerist) {
		String sql = "UPDATE Gallerist SET passwd=?, phone=?, imgPath=? WHERE email = ?";
		
		jdbcTemplate.update(sql, gallerist.getPasswd(), gallerist.getPhone(), 
				gallerist.getImgPath(), gallerist.getEmail());
	}
	
	//로그인 유효성 검증용
	public boolean isValidUser(String email, String passwd) {
		String sql = "SELECT count(*) FROM Gallerist WHERE email=? AND passwd=?";
		boolean result = true;
		int ishere = jdbcTemplate.queryForObject(sql, Integer.class, email, passwd);
		if(ishere == 0 ) {
			result = false; 
		}
		return result;		
	}
}
