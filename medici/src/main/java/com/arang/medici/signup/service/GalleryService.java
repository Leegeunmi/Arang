package com.arang.medici.signup.service;

import java.util.List;

import com.arang.medici.signup.dao.GalleryDao;
import com.arang.medici.signup.domain.Gallery;

public class GalleryService{
	private static GalleryService service = new GalleryService();
	public GalleryDao galleryDao;
	
	public GalleryService(GalleryDao galleryDao) {
		this.galleryDao = galleryDao;
	}
	
	public GalleryService() {
	}

	public void addGalley(Gallery gallery) {
		galleryDao.plusGallery(gallery);
	}
	
	public void updateGallery(Gallery gallery) {
		galleryDao.updateGallery(gallery);
	}
	
	public void deleteGalleryByGalleryId(Gallery gallery) {
		galleryDao.deleteGalleryByGalleryId(gallery);
	}
	
	public List<Gallery> findAllGallery() {
		return galleryDao.findAllGallery();
	}

	public static GalleryService getInstance() {
		return service;
	}
	
//	public void setUserDao(UserDao userDao) {
//		this.userDao = userDao;
//	}

	public boolean isValidUser(String galleryId, String passwd) {
		return galleryDao.isValidUser(galleryId, passwd);		
	}
	
	
}
