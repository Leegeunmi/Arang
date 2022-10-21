package com.medici.arang.board.contact.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.medici.arang.board.contact.command.ContactCommand;
import com.medici.arang.board.contact.command.FindContactArtistCommand;
import com.medici.arang.board.contact.command.FindContactCommend;
import com.medici.arang.board.contact.command.FindContactGalleryCommand;
import com.medici.arang.board.contact.command.FindContactingArtistCommand;
import com.medici.arang.board.contact.dao.ContactDao;
import com.medici.arang.user.command.ArtistPageCommand;

public class ContactServiceImpl implements ContactService {
	
	@Autowired
	private ContactDao contactDao;
	
	public void contactGallery(ContactCommand contactCommand) {
		contactDao.contactGallery(contactCommand);
	}
	
	public List<ContactCommand> findContactList(long code) {
		return contactDao.findContactList(code);
	}
	
	public List<FindContactCommend> findArtistkById(long id) {
		return contactDao.findArtistkById(id);
	}
	public void acceptTpye(String accept, long id) {
		contactDao.acceptTpye(accept, id);
	}
	
	public void contactArtist(ContactCommand contactCommand) {
		contactDao.contactArtist(contactCommand);
	}
	
	public List<FindContactGalleryCommand> findGalleryByEmail(long id) {
		return contactDao.findGalleryByEmail(id);
	}
	
	public List<FindContactGalleryCommand> findGalleryContacting(long id){
	      return contactDao.findGalleryContacting(id);
	}
	
	public List<FindContactArtistCommand> findArtistkList(String email) {
		return contactDao.findArtistkList(email);
	}
	
	public List<FindContactingArtistCommand> findArtistList(String email) {
		return contactDao.findArtistList(email);
	}
	
}
