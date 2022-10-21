package com.medici.arang.board.gallery.service;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.medici.arang.board.gallery.command.GalleryInfoCommand;
import com.medici.arang.board.gallery.command.GalleryPageCommand;

public interface GalleryInfoService {
	void insertGalleryInfo(GalleryInfoCommand infoCommand);
	List<GalleryPageCommand> allFindGallery();
	GalleryPageCommand findGalleryByID(long code);
	Page<GalleryPageCommand> allFindGalleryPage(Pageable pageable);
}
