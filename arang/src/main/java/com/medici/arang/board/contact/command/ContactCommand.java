package com.medici.arang.board.contact.command;

import java.sql.Date;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class ContactCommand {
	private long contactId;
	private long galleryCode;
	private long artistId;
	private String comment;
	private String exhibitionTitle;
	private String startDate;
	private String endDate;
	private String accept;
	private String sendingType;
	private Date regDate;
	
	public ContactCommand() {
	}
}
