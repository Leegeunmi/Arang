package com.medici.arang.board.notice.domain;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.medici.arang.board.notice.command.NoticeCommand;

public class NoticeRowMapper implements RowMapper<NoticeCommand>{

	@Override
	public NoticeCommand mapRow(ResultSet rs, int rowNum) throws SQLException {
		
		NoticeCommand command = new NoticeCommand();
		command.setNum(rs.getLong("num"));
		command.setTitle(rs.getString("title"));
		command.setWriter(rs.getString("writer"));
		command.setContent(rs.getString("content"));
		command.setReadCnt(rs.getInt("readCnt"));
//		command.setImgPath(rs.getString("imgPath"));
		command.setRegDate(rs.getTimestamp("regDate"));
		return command;
	}
}
