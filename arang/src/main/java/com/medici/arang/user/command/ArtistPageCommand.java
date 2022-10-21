package com.medici.arang.user.command;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class ArtistPageCommand {
	private String name_kor;
	private String name_eng;
	private String genre;
	private String imgPath;
	private String artworkImgPath;
	private long aid;
	private long wid;
	private String title;
	
	public ArtistPageCommand() {
		super();
	}
}
