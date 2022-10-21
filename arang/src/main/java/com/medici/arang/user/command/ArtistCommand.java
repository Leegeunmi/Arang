package com.medici.arang.user.command;

import java.sql.Date;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class ArtistCommand {
	private Long aid;
	private String email;
	private String email1;
	private String email2;
	private String passwd;
	private String phone;
	private String phone1;
	private String phone2;
	private String phone3;
	private String ssn;
	private String name_kor;
	private String name_eng;
	private int age;
	private String genre;
	private String career;
	private Date regDate;
	private String imgPath;
	
	public ArtistCommand () {
		
	}
}