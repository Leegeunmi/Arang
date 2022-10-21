package com.medici.arang.board.gallery.command;

import java.sql.Timestamp;

import com.medici.arang.user.domain.GalleristVo;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter @Setter
@NoArgsConstructor
public class GalleryCommand {
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
	private String representer;
	private String representerNum; 
	private String galleryImgPath; 
}
