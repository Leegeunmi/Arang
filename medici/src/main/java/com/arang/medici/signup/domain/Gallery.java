package com.arang.medici.signup.domain;

import java.io.Serializable;
import java.util.List;

public class Gallery implements Serializable {
	private static final long serialVersionUID = 1L;
	private String galleryId;
	private String passwd;
	private String galleryName;
	private String galleryScale;
	private String galleryAddr;
	private String galleryNumber;
	private String galleryEmail;
	private String gallerySns;
	private List<Gallery> GalleryList;
	
	public Gallery() {}

	public String getGalleryId() {
		return galleryId;
	}

	public void setGalleryId(String galleryId) {
		this.galleryId = galleryId;
	}

	public String getPasswd() {
		return passwd;
	}

	public void setPasswd(String passwd) {
		this.passwd = passwd;
	}

	public String getGalleryName() {
		return galleryName;
	}

	public void setGalleryName(String galleryName) {
		this.galleryName = galleryName;
	}

	public String getGalleryScale() {
		return galleryScale;
	}

	public void setGalleryScale(String galleryScale) {
		this.galleryScale = galleryScale;
	}

	public String getGalleryAddr() {
		return galleryAddr;
	}

	public void setGalleryAddr(String galleryAddr) {
		this.galleryAddr = galleryAddr;
	}

	public String getGalleryNumber() {
		return galleryNumber;
	}

	public void setGalleryNumber(String galleryNumber) {
		this.galleryNumber = galleryNumber;
	}

	public String getGalleryEmail() {
		return galleryEmail;
	}

	public void setGalleryEmail(String galleryEmail) {
		this.galleryEmail = galleryEmail;
	}

	public String getGallerySns() {
		return gallerySns;
	}

	public void setGallerySns(String gallerySns) {
		this.gallerySns = gallerySns;
	}

	public List<Gallery> getGalleryList() {
		return GalleryList;
	}

	public void setGalleryList(List<Gallery> galleryList) {
		GalleryList = galleryList;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	
	
	
}
