package com.medici.arang.storage.domain;

import java.sql.Date;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class Storage {
	
	private long sid;
	private String artistId;
	private String myAddress;
	private String storagePeriodStart;
	private String storagePeriodEnd;
	private String artworkType;
	private String artworkSize;
	private String artworkWeight;
	private String locationArea;
	private int	charge;
	private Boolean transport;
	private String approvalStatus;
	private Date regDate;
	
	public Storage() {
	}
}
