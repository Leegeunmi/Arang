package com.medici.arang.like.domain;

import java.sql.Date;
import java.sql.Timestamp;

import org.springframework.stereotype.Repository;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter @Setter
@AllArgsConstructor
public class LikeVo {
	private String userId;
	private String targetValue;
	private int likeNum;
	
	public LikeVo() {
		
	}
}

//
//CREATE TABLE Like(
//		   lid			BIGINT				PRIMARY KEY  AUTO_INCREMENT,     
//		   userId		VARCHAR(50)			NOT NULL,
//		   targetId		VARCHAR(50)			NOT NULL,
//		   likeNum		int(10)				DEFAULT 0,
//		   regDate		TIMESTAMP			DEFAULT CURRENT_TIMESTAMP   
//		)AUTO_INCREMENT = 1;