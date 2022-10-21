package com.medici.arang.board.artist.service;

import com.medici.arang.board.artist.command.ArtworkInfoCommand;
import com.medici.arang.board.artist.command.FindArtworkInfoCommand;

public interface ArtworkInfoService {
	void addArtworkInfo(ArtworkInfoCommand artworkInfo);
	FindArtworkInfoCommand findArtworkInfo(long id);
}
