package com.medici.arang.board.notice.domain;

import java.sql.Timestamp;

import org.springframework.stereotype.Component;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Component
@Getter @Setter
@NoArgsConstructor
public class NoticeVo {
	private long num;
	private String title;
	private String writer;
	private String content;
	private int readCnt;
//	private String imgPath;
	private Timestamp regDate;
}
