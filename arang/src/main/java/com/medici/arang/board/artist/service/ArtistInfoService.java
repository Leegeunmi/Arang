package com.medici.arang.board.artist.service;

import java.util.List;

import com.medici.arang.board.artist.command.ArtistInfoCommand;
import com.medici.arang.board.artist.command.FindArtistInfoCommand;

public interface ArtistInfoService {
	void addArtistInfo(ArtistInfoCommand artistInfoCommand);
	FindArtistInfoCommand findArtistInfo(long id);
	List<FindArtistInfoCommand> findArtist();
	long getArtistCount();
}
