package com.medici.arang.board.artist.domain;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class Artwork {
	private long wid;
	private long artistId;
	private String artworkName;
	private String artworkImg;
	private String description;
	private String artworkCategory;
	
	public Artwork() {
		super();
	}
}
