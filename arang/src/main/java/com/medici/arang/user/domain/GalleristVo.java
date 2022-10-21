package com.medici.arang.user.domain;

import java.sql.Timestamp;

import org.springframework.stereotype.Component;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter @Setter
@NoArgsConstructor
@Component
public class GalleristVo {
	private String email;
	private String passwd;
	private String name;
	private String ssn;
	private String phone;
	private String imgPath;
}
