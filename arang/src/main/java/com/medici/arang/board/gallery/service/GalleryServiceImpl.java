package com.medici.arang.board.gallery.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.medici.arang.board.contact.command.FindContactCommend;
import com.medici.arang.board.gallery.command.GalleryCommand;
import com.medici.arang.board.gallery.command.GalleryPageCommand;
import com.medici.arang.board.gallery.dao.GalleryDao;

public class GalleryServiceImpl implements GalleryService{
	
	@Autowired
	private GalleryDao galleryDao = new GalleryDao();

	@Override
	public void insertGallery(GalleryCommand galleryCommand) {
		galleryDao.insertGallery(galleryCommand);
	}
	
	public GalleryCommand findAllGalleryByRepresenterNum(String num) {
		return galleryDao.findAllGalleryByRepresenterNum(num);
	}
	
	public long getGalleryCount() {
		return galleryDao.getGalleryCount();
	}
	
	public GalleryCommand findGalleryByEmail(String email) {
		return galleryDao.findGalleryByEmail(email);
	}
	
	public List<GalleryCommand> findGalleryListByEmail(String email) {
		return galleryDao.findGalleryListByEmail(email);
	}
	
	public List<GalleryPageCommand> findMyGallery(String email) {
		return galleryDao.findMyGallery(email);
	}
}
