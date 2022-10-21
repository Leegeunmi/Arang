package com.medici.arang.board.gallery.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.medici.arang.board.gallery.command.GalleryInfoCommand;
import com.medici.arang.board.gallery.command.GalleryPageCommand;
import com.medici.arang.board.gallery.dao.GalleryInfoDao;

public class GalleryInfoServiceImpl {
	
	@Autowired
	private GalleryInfoDao galleryInfoDao;
	
	public void insertGalleryInfo(GalleryInfoCommand infoCommand) {
		galleryInfoDao.insertGalleryInfo(infoCommand);
	}
	
	public List<GalleryPageCommand> allFindGallery() {
		return galleryInfoDao.allFindGallery();
	}
	
	public GalleryPageCommand findGalleryByID(long code) {
		return galleryInfoDao.findGalleryByID(code);
	}
	
	//페이징 처리
	public Page<GalleryPageCommand> allFindGalleryPage(Pageable pageable) {
		return galleryInfoDao.allFindGalleryPage(pageable);
	}
}
