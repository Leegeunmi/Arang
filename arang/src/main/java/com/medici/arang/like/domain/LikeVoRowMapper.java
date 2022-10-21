package com.medici.arang.like.domain;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

public class LikeVoRowMapper implements RowMapper<LikeVo> {
	@Override
	public LikeVo mapRow(ResultSet rs, int rowNum) throws SQLException {
		LikeVo vo = new LikeVo();
		vo.setUserId(rs.getString("userId"));
		vo.setTargetValue(rs.getString("targetId"));
		vo.setLikeNum(rs.getInt("likeNum"));	
		return vo;
	}
}
