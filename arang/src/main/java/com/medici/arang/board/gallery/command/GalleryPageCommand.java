package com.medici.arang.board.gallery.command;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class GalleryPageCommand {
	private long code; 
	private String galleristEmail;
	private String galleryName_kor; 
	private String galleryName_eng; 
	private String address; 
	private String galleryEmail;
	private String galleryPhone;
	private String since;
	private String area;
	private String openClose; 
	private String galleryImgPath;
	private String description;
	private String infoImgPath;
}
