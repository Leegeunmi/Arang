package com.medici.arang.board.artist.service;

import org.springframework.beans.factory.annotation.Autowired;

import com.medici.arang.board.artist.command.ArtworkInfoCommand;
import com.medici.arang.board.artist.command.FindArtworkInfoCommand;
import com.medici.arang.board.artist.dao.ArtworkInfoDao;

public class ArtworkInfoServiceImpl implements ArtworkInfoService {
	
	@Autowired
	ArtworkInfoDao artworkInfoDao;
	
	public void addArtworkInfo(ArtworkInfoCommand artworkInfo) {
		artworkInfoDao.addArtworkInfo(artworkInfo);
	}
	
	public FindArtworkInfoCommand findArtworkInfo(long id) {
		return artworkInfoDao.findArtworkInfo(id);
	}
}
