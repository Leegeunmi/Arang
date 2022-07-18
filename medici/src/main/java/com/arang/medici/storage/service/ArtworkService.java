package com.arang.medici.storage.service;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.arang.medici.storage.dao.ArtworkDao;
import com.arang.medici.storage.domain.Artwork;
import com.arang.medici.storage.domain.Wallet;

public class ArtworkService {
	private static ArtworkService service = new ArtworkService();
	public ArtworkDao artworkDao;
	
	public ArtworkService() {
		
	}
	
	public static ArtworkService getInstance() {
		return service;
	}
	
	public ArtworkService(ArtworkDao artworkDao) {
		this.artworkDao = artworkDao;
	}
	
	public void addArtwork(Artwork artwork) {
		artworkDao.addArtwork(artwork);
	}

	public List<Artwork> findArtwork() {
		return artworkDao.findArtwork();
	}

	public Wallet payment(Wallet wallet) {
		return artworkDao.payment(wallet);
		
	}


	
	
}

