package com.medici.arang.board.contact.command;

import java.sql.Date;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class FindContactGalleryCommand {
	private long contactId;
	private String accept;
	private Date regDate;
	private String galleryName_eng;
	private String galleryImgPath;
	private String startDate;
	private String endDate;
	private String exhibitionTitle;
	private String comment;
	private long galleryCode;
	private String sendingType;
	private String address;
	
	public FindContactGalleryCommand() {
		
	}
}
// 신청날짜 갤러리이름 갤러리프로필 전시날짜 전시명 코멘트 버튼
// contact, gallery