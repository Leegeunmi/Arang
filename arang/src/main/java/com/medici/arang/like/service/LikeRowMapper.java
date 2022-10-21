package com.medici.arang.like.service;

import java.sql.ResultSet;
import java.sql.SQLException;

import javax.xml.transform.Result;

import org.springframework.jdbc.core.RowMapper;

import com.medici.arang.like.domain.LikeVo;
import com.medici.arang.user.command.ArtistCommand;

public class LikeRowMapper implements RowMapper<LikeVo> {
		
	@Override
	public LikeVo mapRow(ResultSet rs, int rowNum) 
			throws SQLException {
		
		LikeVo likeVo = new LikeVo();
		likeVo.setLikeNum(rs.getInt("likeNum"));
		likeVo.setUserId(rs.getString("userId"));
		likeVo.setTargetValue(rs.getString("targetValue"));
		
		return likeVo;
	}
	
}