package com.medici.arang.board.artist.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.medici.arang.board.artist.command.ArtistInfoCommand;
import com.medici.arang.board.artist.command.FindArtistInfoCommand;
import com.medici.arang.board.artist.dao.ArtistInfoDao;
import com.medici.arang.user.command.ArtistPageCommand;

public class ArtistInfoServiceImpl {
	
	@Autowired
	ArtistInfoDao artistInfoDao;
	
	public void addArtistInfo(ArtistInfoCommand artistInfoCommand) {
		artistInfoDao.addArtistInfo(artistInfoCommand);
	}
	
	public FindArtistInfoCommand findArtistInfo(long id) {
		return artistInfoDao.findArtistInfo(id);
	}
	
	public List<FindArtistInfoCommand> findArtist() {
		return artistInfoDao.findArtist();
	}
	
	public long getArtistCount() {
		return artistInfoDao.getArtistCount();
	}
	
	
}
