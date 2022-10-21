package com.medici.arang.board.gallery.command;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class GalleryInfoCommand {
	private long galleryCode;
	private String description;
	private String infoImgPath;

}
