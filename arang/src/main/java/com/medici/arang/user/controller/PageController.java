package com.medici.arang.user.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import com.medici.arang.board.artist.command.ArtworkCommand;
import com.medici.arang.board.artist.command.FindArtistInfoCommand;
import com.medici.arang.board.artist.service.ArtistInfoServiceImpl;
import com.medici.arang.board.artist.service.ArtworkServiceImpl;
import com.medici.arang.board.gallery.command.GalleryPageCommand;
import com.medici.arang.board.gallery.service.GalleryInfoServiceImpl;
import com.medici.arang.user.service.ArtistServiceImpl;
import com.medici.arang.user.service.GalleristServiceImpl;

@Controller("controller.pageController")
public class PageController {
	
	@Autowired
	ArtistServiceImpl artistService;
	
	@Autowired
	GalleristServiceImpl galleristService;
	
	@Autowired
	ArtistInfoServiceImpl artistInfoService;
	
	@Autowired
	ArtworkServiceImpl artworkService;
	
	@Autowired
	GalleryInfoServiceImpl galleryInfoService;
	
	@GetMapping("/main")
	public String mainForm(Model model) {
		List<FindArtistInfoCommand> artistList1 = artistInfoService.findArtist();
		List<ArtworkCommand> arkworkList = artworkService.allFindArtwork();
		model.addAttribute("artworkList", arkworkList);
		model.addAttribute("artistList1", artistList1);
		
		List<GalleryPageCommand> galleryList = galleryInfoService.allFindGallery();
		model.addAttribute("galleryList", galleryList);
		return "main";
	}
	
	@GetMapping("/login")
	public String loginForm() {
		return "login";
	}
	
	@PostMapping("login")
	public String Login(HttpServletRequest request, Model model) {
		HttpSession session = request.getSession();
		
		String email = request.getParameter("email");
		String passwd = request.getParameter("passwd");
		
		//유효성 검증
		if(!artistService.isValidUser(email, passwd)) {
			if(!galleristService.isValidUser(email, passwd)) {
				model.addAttribute("msg", "없는 아이디거나 틀린 비밀번호 입니다.");
				model.addAttribute("url", "login");
				return "alert";
			}
		}
		if( artistService.isValidUser(email, passwd) ) {
			session.setAttribute("artistLogin", "artistLogin");
		}else if ( galleristService.isValidUser(email, passwd) ) {
			session.setAttribute("galleristLogin", "galleristLogin");
		}
		session.setAttribute("email", email);
		//성공시 갈곳
		return "redirect:main";
	}
	
	@GetMapping("/user/logout")
	public String doLogout(HttpServletRequest request) {
		HttpSession session = request.getSession(false);

		session.invalidate();		
		return "redirect:/main";
	}
	
	@GetMapping("/user/select_user_type")
	public String selectUserTypeForm() {
		return "/user/select_user_type";				
	}
}
