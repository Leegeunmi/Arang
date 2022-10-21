package com.medici.arang.board.gallery.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.medici.arang.board.gallery.command.GalleryCommand;
import com.medici.arang.board.gallery.command.GalleryPageCommand;

@Service
public interface GalleryService {
	public void insertGallery(GalleryCommand galleryCommand);
	GalleryCommand findAllGalleryByRepresenterNum(String num);
	long getGalleryCount();
	GalleryCommand findGalleryByEmail(String email);
	List<GalleryCommand> findGalleryListByEmail(String email);
	List<GalleryPageCommand> findMyGallery(String email);
}

