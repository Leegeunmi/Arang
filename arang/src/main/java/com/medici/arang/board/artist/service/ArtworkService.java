package com.medici.arang.board.artist.service;

import java.util.List;

import com.medici.arang.board.artist.command.ArtworkCommand;

public interface ArtworkService {
	void addArtwork(ArtworkCommand artworkCommand);
	ArtworkCommand findArtwork(long id);
	void updateArtwork(ArtworkCommand artwork);
	void deleteArtwork(long id);
	List<ArtworkCommand> allfindArtwork(long artistId);
	List<ArtworkCommand> allFindArtwork();
	List<ArtworkCommand> findArtworkByArtist(long id);
	ArtworkCommand findArtworkByImg(String imgName);
}
