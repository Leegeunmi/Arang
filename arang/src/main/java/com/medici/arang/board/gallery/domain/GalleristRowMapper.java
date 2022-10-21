package com.medici.arang.board.gallery.domain;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.medici.arang.user.command.GalleristCommend;

public class GalleristRowMapper implements RowMapper<GalleristCommend> {

	@Override
	public GalleristCommend mapRow(ResultSet rs, int rowNum) throws SQLException {
		GalleristCommend vo = new GalleristCommend();
		vo.setEmail(rs.getString("email"));
		vo.setPasswd(rs.getString("passwd"));
		vo.setName(rs.getString("name"));
		vo.setSsn(rs.getString("ssn"));
		vo.setPhone(rs.getString("phone"));
		vo.setImgPath(rs.getString("imgPath"));
		return vo;
	}

}
