package com.medici.arang.board.artist.command;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class ArtistInfoCommand {
	private long bid;
	private long artistId;
	private String title;
	private String description;
	private String infoImgPath;
	
	public ArtistInfoCommand() {
		super();
	}
}
