package com.medici.arang.user.domain;

import java.util.Date;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class Artist {	
	private long aid;
	private String email;
	private String passwd;
	private String name;
	private String ssn;
	private String phone;
	private String genre;
	private String career;
	private String imgPath;
	private Date regDate;
	
	public Artist() {}
	
	public Artist(long aid) {
		this.aid = aid;
	}
}