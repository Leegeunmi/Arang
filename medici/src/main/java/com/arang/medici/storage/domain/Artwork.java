package com.arang.medici.storage.domain;

import java.util.List;

public class Artwork {
	
	private String artworkNum;
	
	private String userId;
	private String storage;
	private String startPeriod;
	private String endPeriod;
	private String dbService;
	private List<Artwork> artWork;
	
	public Artwork() {
		
	}

	public String getArtworkNum() {
		return artworkNum;
	}

	public void setArtworkNum(String artworkNum) {
		this.artworkNum = artworkNum;
	}
	
	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public String getStorage() {
		return storage;
	}

	public void setStorage(String storage) {
		this.storage = storage;
	}
	
	public String getStartPeriod() {
		return startPeriod;
	}

	public void setStartPeriod(String startPeriod) {
		this.startPeriod = startPeriod;
	}

	public String getEndPeriod() {
		return endPeriod;
	}
	
	public void setEndPeriod(String endPeriod) {
		this.endPeriod = endPeriod;
	}

	public String getDbService() {
		return dbService;
	}

	public void setDbService(String dbService) {
		this.dbService = dbService;
	}

	public List<Artwork> getArtWork() {
		return artWork;
	}

	public void setArtWork(List<Artwork> artWork) {
		this.artWork = artWork;
	}
	
	
	
}
