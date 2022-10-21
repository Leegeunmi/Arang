package com.medici.arang.board.contact.service;

import java.util.List;

import com.medici.arang.board.contact.command.ContactCommand;
import com.medici.arang.board.contact.command.FindContactArtistCommand;
import com.medici.arang.board.contact.command.FindContactCommend;
import com.medici.arang.board.contact.command.FindContactGalleryCommand;
import com.medici.arang.board.contact.command.FindContactingArtistCommand;

public interface ContactService {
	void contactGallery(ContactCommand contactCommand);
	public List<ContactCommand> findContactList(long code);
	List<FindContactCommend> findArtistkById(long id);
	void acceptTpye(String accept, long id);
	void contactArtist(ContactCommand contactCommand);
	List<FindContactGalleryCommand> findGalleryByEmail(long id);
	List<FindContactGalleryCommand> findGalleryContacting(long id);
	List<FindContactArtistCommand> findArtistkList(String email);
	List<FindContactingArtistCommand> findArtistList(String email);
}
