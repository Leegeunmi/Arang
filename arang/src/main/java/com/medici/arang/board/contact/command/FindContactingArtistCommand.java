package com.medici.arang.board.contact.command;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class FindContactingArtistCommand {
	private String accept;
	private String regDate;
	private String imgPath;
	private String name_kor;
	private String name_eng;
	private String exhibitionTitle;
	private String startDate;
	private String endDate;
	private String sendingType;
	private String comment;
	private long artistId;
}
