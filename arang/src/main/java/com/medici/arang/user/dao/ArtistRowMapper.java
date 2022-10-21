package com.medici.arang.user.dao;

import java.sql.ResultSet;
import java.sql.SQLException;

import javax.xml.transform.Result;

import org.springframework.jdbc.core.RowMapper;

import com.medici.arang.user.command.ArtistCommand;

public class ArtistRowMapper implements RowMapper<ArtistCommand> {
		
	@Override
	public ArtistCommand mapRow(ResultSet rs, int rowNum) 
			throws SQLException {
		
		ArtistCommand artistCommand = new ArtistCommand();
		artistCommand.setAid(rs.getLong("aid"));
		artistCommand.setEmail(rs.getString("email"));
		artistCommand.setPasswd(rs.getString("passwd"));
		artistCommand.setName_kor(rs.getString("name_kor"));
		artistCommand.setName_eng(rs.getString("name_eng"));
		artistCommand.setSsn(rs.getString("ssn"));
		artistCommand.setPhone(rs.getString("phone"));
		artistCommand.setGenre(rs.getString("genre"));
		artistCommand.setCareer(rs.getString("career"));
		artistCommand.setImgPath(rs.getString("imgPath"));
		artistCommand.setRegDate(rs.getDate("regDate"));
		
		return artistCommand;
	}
	
}