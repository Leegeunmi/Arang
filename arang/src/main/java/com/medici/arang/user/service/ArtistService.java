package com.medici.arang.user.service;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.medici.arang.user.command.ArtistCommand;
import com.medici.arang.user.command.ArtistPageCommand;

public interface ArtistService {
	public void addArtist(ArtistCommand artistCommand);
	boolean isValidUser(String email, String passwd);
	List<ArtistCommand> getAllArtist();
	ArtistCommand getArtistByEmail(String email);
	List<ArtistPageCommand> findAllArtistkByEmail();
	Page<ArtistPageCommand> findAllPage(Pageable pageable);
	Page<ArtistPageCommand> findPageByGenre(Pageable pageable, String ctg);
	List<ArtistPageCommand> findAllArtistkByGenre(String ctg);
	void updateArtist(ArtistCommand artist);
	ArtistPageCommand findArtistkById(long id);
	Page<ArtistPageCommand> findAllPageByGenre(Pageable pageable, String genre);
}