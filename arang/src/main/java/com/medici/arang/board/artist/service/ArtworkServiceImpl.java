package com.medici.arang.board.artist.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.medici.arang.board.artist.command.ArtworkCommand;
import com.medici.arang.board.artist.command.ArtworkInfoCommand;
import com.medici.arang.board.artist.dao.ArtworkDao;
import com.medici.arang.user.command.ArtistPageCommand;

public class ArtworkServiceImpl implements ArtworkService {
	
	@Autowired
	ArtworkDao artworkDao;
	
	@Override
	public void addArtwork(ArtworkCommand artworkCommand) {
		artworkDao.addArtwork(artworkCommand);
	}
	
	@Override
	public ArtworkCommand findArtwork(long id) {
		return artworkDao.findArtwork(id);
	}
	
	@Override
	public void updateArtwork(ArtworkCommand artwork) {
		artworkDao.updateArtwork(artwork);
	}
	
	@Override
	public void deleteArtwork(long id) {
		artworkDao.deleteArtwork(id);
	}
	
	@Override
	public List<ArtworkCommand> allfindArtwork(long artistId) {
		return artworkDao.allfindArtwork(artistId);
	}
	
	public List<ArtworkCommand> allFindArtwork() {
		return artworkDao.allFindArtwork();
	}
	
	public List<ArtworkCommand> findArtworkByArtist(long id) {
		return artworkDao.findArtworkByArtist(id);
	}
	
	public ArtworkCommand findArtworkByImg(String imgName) {
		return artworkDao.findArtworkByImg(imgName);
	}

}
