package com.medici.arang.board.artist.command;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class ArtworkCommand {
	private long wid;
	private long artistId;
	private String name;
	private String genre;
	private String technique;
	private String size;
	private String publicationDate;
	private String description;
	private String artworkImgPath;
	
	public ArtworkCommand() {
		super();
	}
}
