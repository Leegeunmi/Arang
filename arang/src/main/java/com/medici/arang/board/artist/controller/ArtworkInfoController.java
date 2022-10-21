package com.medici.arang.board.artist.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.medici.arang.board.artist.command.ArtworkCommand;
import com.medici.arang.board.artist.command.FindArtistInfoCommand;
import com.medici.arang.board.artist.command.FindArtworkInfoCommand;
import com.medici.arang.board.artist.service.ArtistInfoServiceImpl;
import com.medici.arang.board.artist.service.ArtworkInfoServiceImpl;
import com.medici.arang.board.artist.service.ArtworkServiceImpl;
import com.medici.arang.board.contact.command.ContactCommand;
import com.medici.arang.board.contact.service.ContactServiceImpl;
import com.medici.arang.board.gallery.command.GalleryCommand;
import com.medici.arang.board.gallery.service.GalleryServiceImpl;
import com.medici.arang.like.domain.LikeVo;
import com.medici.arang.like.service.LikeServiceImpl;


@Controller
public class ArtworkInfoController {
	
	@Autowired
	ArtworkServiceImpl artworkService;
	
	@Autowired
	ArtistInfoServiceImpl artistInfoService;
	
	@Autowired
	ArtworkInfoServiceImpl artworkInfoService;
	
	@Autowired
	GalleryServiceImpl galleryService;
	
	@Autowired
	ContactServiceImpl contactService;
	
	@Autowired
	LikeServiceImpl likeService;
	
	@GetMapping("/artwork_board/artwork_info")
	public String artworkForm(@RequestParam("id") long id, 
								@RequestParam("wid") long wid, Model model,
								HttpServletRequest request) {
		
		HttpSession session = request.getSession();
		String email = (String)session.getAttribute("email");
		
		FindArtistInfoCommand artistInfo = artistInfoService.findArtistInfo(id);
		List<ArtworkCommand> artworkList = artworkService.allfindArtwork(id);
		FindArtworkInfoCommand artworkInfo = artworkInfoService.findArtworkInfo(wid);
		
		LikeVo findLike = likeService.findLike(email, wid);

		if(findLike != null) {
			model.addAttribute("likeNum", 0);
		}else {
			model.addAttribute("likeNum", 1);
		}
		
		model.addAttribute("wid", wid);
		model.addAttribute("artistInfo", artistInfo);
		model.addAttribute("artworkList", artworkList);
		model.addAttribute("artworkInfo", artworkInfo);
		
		return "artwork_board/artwork_info";
	}
	
	@GetMapping("/artwork_board/testbtn")
	public String ContactArtist(HttpServletRequest request, Model model) {
		HttpSession session = request.getSession();
		String galleristEmail = (String) session.getAttribute("email");
		System.out.println(galleristEmail);
		
		GalleryCommand gallery =  
				galleryService.findGalleryByEmail(galleristEmail);
		
		ContactCommand contactcommend = new ContactCommand();
		
		contactcommend.setGalleryCode(gallery.getCode());
		long id = Long.parseLong(request.getParameter("artistId"));
		contactcommend.setArtistId(id);
		session.setAttribute("contact", contactcommend);
		
		return "artwork_board/contact_artist";
	}
	
	@PostMapping("/artwork_board/contact_artist")
	public ModelAndView ContactArtist2(ContactCommand contactCommand, HttpServletRequest request) {
		HttpSession session = request.getSession();
		ContactCommand getCon = (ContactCommand) session.getAttribute("contact");
		System.out.println(getCon.getArtistId());
		System.out.println(getCon.getGalleryCode());
		contactCommand.setArtistId(getCon.getArtistId());
		contactCommand.setGalleryCode(getCon.getGalleryCode());
		contactCommand.setSendingType("G");
		
		contactService.contactArtist(contactCommand);
		
		session.removeAttribute("contact");
		ModelAndView mav = new ModelAndView();
		mav.setViewName("redirect:/artist_board/artist_main");
		return mav;
	}
	
}

