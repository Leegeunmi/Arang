package com.medici.arang.board.artist.command;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class ArtworkInfoCommand {
	private long cid;
	private long artworkId;
	private String mainTitle;
	private String subTitle;
	private String workInfoImgPath;
	
	public ArtworkInfoCommand() {
		
	}
}
