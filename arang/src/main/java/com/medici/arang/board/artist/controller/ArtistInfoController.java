package com.medici.arang.board.artist.controller;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.UUID;

import javax.servlet.annotation.MultipartConfig;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import com.medici.arang.board.artist.command.ArtistInfoCommand;
import com.medici.arang.board.artist.command.ArtworkCommand;
import com.medici.arang.board.artist.command.CategoryCommand;
import com.medici.arang.board.artist.command.FindArtistInfoCommand;
import com.medici.arang.board.artist.service.ArtistInfoServiceImpl;
import com.medici.arang.board.artist.service.ArtworkServiceImpl;
import com.medici.arang.like.domain.LikeVo;
import com.medici.arang.like.service.LikeServiceImpl;
import com.medici.arang.user.command.ArtistCommand;
import com.medici.arang.user.command.ArtistPageCommand;
import com.medici.arang.user.service.ArtistServiceImpl;

@MultipartConfig(
	    fileSizeThreshold = 1024*1024,
	    maxFileSize = 1024*1024*50, 		//50메가
	    maxRequestSize = 1024*1024*50*5) 	// 50메가 5개까지
@Controller
public class ArtistInfoController {
	
	@Autowired
	public ArtistInfoServiceImpl artistInfoService;
	
	@Autowired
	public ArtistServiceImpl artistservice;
	
	@Autowired
	public ArtworkServiceImpl artworkService;
	
	@Autowired
	LikeServiceImpl likeService;
	
	//	작품추가 페이지FORM
	@GetMapping("/mypage/add_artist_info")
	public String artworkForm(Model model, HttpServletRequest request) {
		HttpSession session = request.getSession();
		Object loginEmail = session.getAttribute("email");
		if (loginEmail == null) {
			return "main";
		}
		return "mypage/add_artist_info";
	}
	
	private static final String SAVE_DIR = "C:\\Java_geunmi\\java_workspace\\arang\\src\\main\\webapp\\resources\\img\\artist";
	private static final String PATH_DIR = "/upload_img/";
	
	//	작품추가 기능
	@PostMapping("/mypage/add_artist_info")
	public String addArtwork(@ModelAttribute("artistInfo")
						ArtistInfoCommand artistInfo, Model model, @RequestParam("imgFile") 
						MultipartFile file, HttpServletRequest request) {
		HttpSession session = request.getSession();
		String loginEmail = (String) session.getAttribute("email");
		
		ArtistCommand artist = artistservice.getArtistByEmail(loginEmail);
		
		
		System.out.println("-----------");
		String fileRealName = file.getOriginalFilename(); //파일명을 얻어낼 수 있는 메서드
		long size = file.getSize(); //파일 사이즈
		
		System.out.println("파일명 : "  + fileRealName);
		System.out.println("용량크기(byte) : " + size);
		
		String fileExtension = fileRealName.substring(fileRealName.lastIndexOf("."),fileRealName.length());
		
		UUID uuid = UUID.randomUUID();
		System.out.println(uuid.toString());
		String[] uuids = uuid.toString().split("-");
		
		String uniqueName = uuids[0];
		System.out.println("생성된 고유문자열" + uniqueName);
		System.out.println("확장자명" + fileExtension);
		
		File saveFile = new File(SAVE_DIR+"\\artistInfo\\"+uniqueName + fileExtension);  // 적용 후
		try {
			file.transferTo(saveFile); // 실제 파일 저장메서드(filewriter 작업을 손쉽게 한방에 처리해준다.)
		} catch (IllegalStateException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		artistInfo.setInfoImgPath(PATH_DIR+"\\artistInfo\\"+uniqueName+fileExtension);
		String imgName = artistInfo.getInfoImgPath();
		model.addAttribute("imgName", imgName);

		// 아티스트ID값을 외래키로 쓰지만 현재 ID값이 없어 임의값 입력
		artistInfo.setArtistId(artist.getAid());
		model.addAttribute("artistInfo", artistInfo);
		artistInfoService.addArtistInfo(artistInfo);
		
		request.setAttribute("artist", artist);
		
		return "mypage/artist_checkpage";
	}
	
	
	@GetMapping("/mypage/artist_checkpage")
	public String artistCheckpage(HttpServletRequest request) {
		return "mypage/artist_checkpage";
	}
	
	
	@GetMapping("/artist_board/artist_depth")
	public String findArtistDepthForm(@RequestParam("id") long id, Model model,
				HttpServletRequest request) {
		HttpSession session = request.getSession();
		String email = (String)session.getAttribute("email");
		
		FindArtistInfoCommand artistInfo = artistInfoService.findArtistInfo(id);
		List<ArtworkCommand> artworkList = artworkService.allfindArtwork(id);
		
		///작가id aid로 찾기
		LikeVo findLike = likeService.findLike(email, id);

		if(findLike != null) {
			model.addAttribute("likeNum", 2);
		}else {
			model.addAttribute("likeNum", 3);		
		}
		
		//아티스트 PK ID
		model.addAttribute("id", id);
		model.addAttribute("artistInfo", artistInfo);
		model.addAttribute("artworkList", artworkList);
		return "artist_board/artist_depth";
	}
	
	//	아티스트 page Form
	@GetMapping("/artist_board/artist_main")
	public String findArtistForm(Model model, HttpServletRequest request) {
		//page 요청 검사
		int page = 0;
		if(request.getParameter("page") != null) {
			page = Integer.parseInt(request.getParameter("page"));			
		}
		//페이징
		Pageable pageable = PageRequest.of(page, 9, Sort.Direction.DESC, "aid");
		Page<ArtistPageCommand> artistPagingList = artistservice.findAllPage(pageable);
		
		// ajax, 컨트롤러 처리 해야함
		
		//현재페이지
		int pageNumber = artistPagingList.getPageable().getPageNumber();
		//총 페이지수
		int totalPages = artistPagingList.getTotalPages();
		//블럭의 수
		int pageBlock = 5;
		//현재 페이지가 7이라면 1*5+1=6
		int startBlockPage = ((pageNumber)/pageBlock)*pageBlock+1;
		//6+5-1=10. 6,7,8,9,10해서 10.
		int endBlockPage = startBlockPage+pageBlock-1;
		endBlockPage= totalPages<endBlockPage? totalPages:endBlockPage;
		
		
		List<ArtworkCommand> arkworkList = artworkService.allFindArtwork();
		List<ArtistPageCommand> artworkPageList = artistservice.findAllArtistkByEmail();
		List<FindArtistInfoCommand> artistList1 = artistInfoService.findArtist();
		long artistCount = artistInfoService.getArtistCount();
		
		model.addAttribute("artistList1", artistList1);
		model.addAttribute("artworkList", arkworkList);
		model.addAttribute("artworkPageList", artworkPageList);
		model.addAttribute("artistCount", artistCount);
		
		//페이징 영역
		model.addAttribute("startBlockPage", startBlockPage);
		model.addAttribute("endBlockPage", endBlockPage);
		model.addAttribute("artistPagingList", artistPagingList);
		return "artist_board/artist_main";
	}
	
	@GetMapping("/artist_board/artist_main_ctg")
	public String findArtistCtgForm(Model model, @RequestParam("genre") String genre,
							HttpServletRequest request) {
		//page 요청 검사
		int page = 0;
		if(request.getParameter("page") != null) {
			page = Integer.parseInt(request.getParameter("page"));			
		}
		//페이징
		Pageable pageable = PageRequest.of(page, 9, Sort.Direction.DESC, "aid");
		Page<ArtistPageCommand> artistPagingList = 
				artistservice.findAllPageByGenre(pageable, genre);
		
		//현재페이지
		int pageNumber = artistPagingList.getPageable().getPageNumber();
		//총 페이지수
		int totalPages = artistPagingList.getTotalPages();
		//블럭의 수
		int pageBlock = 5;
		//현재 페이지가 7이라면 1*5+1=6
		int startBlockPage = ((pageNumber)/pageBlock)*pageBlock+1;
		//6+5-1=10. 6,7,8,9,10해서 10.
		int endBlockPage = startBlockPage+pageBlock-1;
		endBlockPage= totalPages<endBlockPage? totalPages:endBlockPage;
		
		List<ArtworkCommand> arkworkList = artworkService.allFindArtwork();
		List<ArtistPageCommand> artworkPageList = artistservice.findAllArtistkByEmail();
		List<FindArtistInfoCommand> artistList1 = artistInfoService.findArtist();
		long artistCount = artistInfoService.getArtistCount();
		
		model.addAttribute("artistList1", artistList1);
		model.addAttribute("artworkList", arkworkList);
		model.addAttribute("artworkPageList", artworkPageList);
		model.addAttribute("artistCount", artistCount);
		
		//페이징 영역
		model.addAttribute("startBlockPage", startBlockPage);
		model.addAttribute("endBlockPage", endBlockPage);
		model.addAttribute("artistPagingList", artistPagingList);
		return "artist_board/artist_main_ctg";
	}
	
	
	@ResponseBody
//	@PostMapping("/clickCategory")
	@RequestMapping(value = "/clickCategory", produces = "application/text; charset=utf8")
	public String clickCategoryBtn(@RequestBody CategoryCommand ctg, 
						HttpServletRequest request, HttpServletResponse response,
						Model model) {
		
		response.setCharacterEncoding("UTF-8");
		System.out.println("ajax 테스트 성공");
		System.out.println(ctg.getCategoryValue());
		String ctgValue = ctg.getCategoryValue();
		//page 요청 검사
		
		
		return ctgValue;
	}
	
}
