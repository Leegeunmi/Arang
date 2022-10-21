package com.medici.arang.user.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.medici.arang.user.command.ArtistCommand;
import com.medici.arang.user.command.ArtistPageCommand;
import com.medici.arang.user.dao.ArtistDao;


public class ArtistServiceImpl implements ArtistService {
	
	@Autowired
	ArtistDao artistDao;
	
	@Override
	public void addArtist(ArtistCommand artistCommand) {
		artistDao.addArtist(artistCommand);
	}
	@Override
	public boolean isValidUser(String email, String passwd) {
		return artistDao.isValidUser(email, passwd);
	}

	@Override
	public List<ArtistCommand> getAllArtist() {
		return artistDao.getAllArtist();
	}

	@Override
	public ArtistCommand getArtistByEmail(String email) {
		return artistDao.getArtistByEmail(email);
	}
	@Override
	public List<ArtistPageCommand> findAllArtistkByEmail() {
		return artistDao.findAllArtistkByEmail();
	}

	@Override
	public Page<ArtistPageCommand> findAllPage(Pageable pageable) {
		return artistDao.findAllPage(pageable);
	}
	@Override
	public Page<ArtistPageCommand> findPageByGenre(Pageable pageable, String ctg){
		return artistDao.findPageByGenre(pageable, ctg);
	}
	@Override
	public List<ArtistPageCommand> findAllArtistkByGenre(String ctg) {
		return artistDao.findAllArtistkByGenre(ctg);
	}
	@Override
	public void updateArtist(ArtistCommand artist) {
		artistDao.updateArtist(artist);
	}
	@Override
	public ArtistPageCommand findArtistkById(long id) {
		return artistDao.findArtistkById(id);
	}
	@Override
	public Page<ArtistPageCommand> findAllPageByGenre(Pageable pageable, String genre) {
		return artistDao.findAllPageByGenre(pageable, genre);
	}
}