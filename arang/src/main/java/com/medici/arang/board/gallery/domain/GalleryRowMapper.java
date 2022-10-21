package com.medici.arang.board.gallery.domain;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.medici.arang.board.gallery.command.GalleryCommand;

public class GalleryRowMapper implements RowMapper<GalleryCommand>{

	@Override
	public GalleryCommand mapRow(ResultSet rs, int rowNum) throws SQLException {
		GalleryCommand vo = new GalleryCommand();
		
		vo.setCode(rs.getLong("code"));
		vo.setGalleristEmail(rs.getString("galleristEmail"));
		vo.setGalleryName_kor(rs.getString("galleryName_kor"));
		vo.setGalleryName_eng(rs.getString("galleryName_eng"));
		vo.setAddress(rs.getString("address"));
		vo.setGalleryEmail(rs.getString("galleryEmail"));
		vo.setGalleryPhone(rs.getString("galleryPhone"));
		vo.setSince(rs.getString("since"));
		vo.setArea(rs.getString("area"));
		vo.setOpenClose(rs.getString("openClose"));
		vo.setRepresenter(rs.getString("representer"));
		vo.setRepresenterNum(rs.getString("representerNum"));
		vo.setGalleryImgPath(rs.getString("galleryImgPath"));
		return vo;
	}
}	