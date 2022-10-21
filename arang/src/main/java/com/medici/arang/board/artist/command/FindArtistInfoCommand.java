package com.medici.arang.board.artist.command;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class FindArtistInfoCommand {
	private String name_kor;
	private String name_eng;
	private String ssn;
	private String imgPath;
	private String genre;
	private String title;
	private String description;
	private String infoImgPath;
	private long aid;
	
	public FindArtistInfoCommand() {
		
	}
}
