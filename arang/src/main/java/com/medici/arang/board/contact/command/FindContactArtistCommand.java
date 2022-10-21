package com.medici.arang.board.contact.command;

import java.sql.Timestamp;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class FindContactArtistCommand {
	private String accept;
	private Timestamp regdate;
	private String imgPath;
	private String name_kor;
	private String galleryImgPath;
	private String galleryName_eng;
	private String name_eng;
	private String genre;
	private long contactId;
	private long artistId;
}
