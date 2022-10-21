package com.medici.arang.board.contact.command;

import java.sql.Date;

import com.medici.arang.user.command.ArtistPageCommand;
import com.medici.arang.user.command.GalleristCommend;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class FindContactCommend {
	private long contactId;
	private String accept;
	private Date regDate;
	private String name_kor;
	private String genre;
	private String imgPath;
	private String name;
	private long artistId;
	private String sendingType;
	private String name_eng;
	
	public FindContactCommend() {
	}
}
