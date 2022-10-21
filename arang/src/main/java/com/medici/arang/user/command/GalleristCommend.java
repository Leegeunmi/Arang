package com.medici.arang.user.command;

import java.sql.Timestamp;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter @Setter
@NoArgsConstructor
public class GalleristCommend {
	private String email;
	private String email1;
	private String email2;
	private String passwd;
	private String name;
	private String ssn;
	private String phone;
	private String imgPath;
}