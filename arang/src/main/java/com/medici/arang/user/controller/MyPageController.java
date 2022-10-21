package com.medici.arang.user.controller;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.UUID;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import com.medici.arang.board.artist.command.ArtworkCommand;
import com.medici.arang.board.artist.command.FindArtistInfoCommand;
import com.medici.arang.board.artist.service.ArtistInfoServiceImpl;
import com.medici.arang.board.artist.service.ArtworkServiceImpl;
import com.medici.arang.board.contact.command.FindContactArtistCommand;
import com.medici.arang.board.contact.command.FindContactCommend;
import com.medici.arang.board.contact.command.FindContactGalleryCommand;
import com.medici.arang.board.contact.command.FindContactingArtistCommand;
import com.medici.arang.board.contact.service.ContactServiceImpl;
import com.medici.arang.board.gallery.command.GalleryCommand;
import com.medici.arang.board.gallery.command.GalleryPageCommand;
import com.medici.arang.board.gallery.service.GalleryInfoServiceImpl;
import com.medici.arang.board.gallery.service.GalleryServiceImpl;
import com.medici.arang.like.domain.LikeVo;
import com.medici.arang.like.service.LikeServiceImpl;
import com.medici.arang.user.command.ArtistCommand;
import com.medici.arang.user.command.ArtistPageCommand;
import com.medici.arang.user.command.GalleristCommend;
import com.medici.arang.user.service.ArtistServiceImpl;
import com.medici.arang.user.service.GalleristServiceImpl;

@Controller("controller.myPageController")
public class MyPageController {
	
	@Autowired
	ArtistServiceImpl artistService;
	@Autowired
	GalleristServiceImpl galleristService;
	@Autowired
	ContactServiceImpl contactService;
	@Autowired
	GalleryServiceImpl galleryService;
	@Autowired
	LikeServiceImpl likeService;
	@Autowired
	ArtworkServiceImpl artworkService;
	@Autowired
	ArtistInfoServiceImpl artistInfoService;
	@Autowired
	GalleryInfoServiceImpl galleryInfoService;
	
	private static final String SAVE_DIR = "C:\\Java_geunmi\\java_workspace\\arang\\src\\main\\webapp\\resources\\img\\";
	private static final String PATH_DIR = "/upload_img/";
	
	@GetMapping("/mypage/wish_list")
	public String myWishListPage(Model model, HttpServletRequest request) {
		HttpSession session = request.getSession();
		String email = (String)session.getAttribute("email");
		List<String> errorMsgs = new ArrayList<>();
		if(email == null) {
			errorMsgs.add("로그인 상태가 아닙니다.");
		}if(errorMsgs.size() > 0) {
			model.addAttribute("msg", errorMsgs);
			model.addAttribute("url", "/arang/login");
			return "alert";
		}
		
		//작가 영역
		List<ArtistPageCommand> artistList = likeService.findArtistJoinLike(email);
		long artistCount = likeService.getLikeArtistCount(email);
		model.addAttribute("artistCount", artistCount);
		model.addAttribute("artistList", artistList);
		
		//작품 영역
		List<ArtworkCommand> arkworkList = likeService.findArtworkJoinLike(email);
		model.addAttribute("artworkList", arkworkList);
		
		//갤러리 영역
		List<GalleryPageCommand> galleryList = likeService.findGalleryJoinLike(email);
		model.addAttribute("galleryList", galleryList);

		
		//좋아요 테이블 영역
		List<LikeVo> likeList = likeService.findLike();
		model.addAttribute("likeList", likeList);
		return "mypage/wish_list";
	}
	
	@GetMapping("/mypage/mypage_artist")
	public String artistMypageForm(HttpServletRequest request, Model model) {
		HttpSession session = request.getSession();
		String email = (String)session.getAttribute("email");
		List<String> errorMsgs = new ArrayList<>();
		if(email == null) {
			errorMsgs.add("로그인 상태가 아닙니다.");
		}if(errorMsgs.size() > 0) {
			model.addAttribute("msg", errorMsgs);
			model.addAttribute("url", "/arang/login");
			return "alert";
		}
		
		ArtistCommand artist = artistService.getArtistByEmail(email);
		request.setAttribute("artist", artist);
		
		List<FindContactGalleryCommand> contactList = 
				contactService.findGalleryByEmail(artist.getAid());
		
		request.setAttribute("contactList", contactList);
		
		
		if(artistInfoService.findArtistInfo(artist.getAid()) != null) {
			request.setAttribute("infoCheck", 1);
		}else {
			request.setAttribute("infoCheck", 0);
		}
		
		// 주민번호 처리 코드
		String ssn = artist.getSsn();
		String testone = ssn.substring(0, 8);
		System.out.println(testone);
		testone += "******";
		System.out.println(testone);
		request.setAttribute("ssn", testone);
		
		// 커리어 처리 코드
		String[] careerList = artist.getCareer().split(";");
		request.setAttribute("careerList", careerList);
		
				
		List<ArtworkCommand> artworkList = artworkService.allfindArtwork(artist.getAid());
		model.addAttribute("artworkList", artworkList);
		
		List<FindContactGalleryCommand> contactingList = 
	            contactService.findGalleryContacting(artist.getAid());
	      request.setAttribute("contactingList", contactingList);		
		
	     
		return "mypage/mypage_artist";
	}
	
	
	@GetMapping("/mypage/mypage_request_list2")
	public String requestPageForm2(HttpServletRequest request) {
		HttpSession session = request.getSession();
		String email = (String)session.getAttribute("email");
		ArtistCommand artist = artistService.getArtistByEmail(email);
		
		List<FindContactGalleryCommand> contactList = 
				contactService.findGalleryByEmail(artist.getAid());
		
		request.setAttribute("contactList", contactList);
		return "mypage/mypage_request_list2";
		
	}
	
	

	
	@GetMapping("/mypage/mypage_artist_modify")
	public String mypageUpdateForm(HttpServletRequest request) {
		HttpSession session = request.getSession();
		String email = (String)session.getAttribute("email");
		ArtistCommand artist = artistService.getArtistByEmail(email);
		request.setAttribute("artist", artist);
		
		// 주민번호 처리코드
		String ssn = artist.getSsn();
		String testone = ssn.substring(0, 8);
		System.out.println(testone);
		testone += "******";
		System.out.println(testone);
		request.setAttribute("ssn", testone);
		
		// 커리어 처리 코드
		String[] careerList = artist.getCareer().split(";");
		request.setAttribute("careerList", careerList);
		
		
		return "mypage/mypage_artist_modify";
	}
	
	
	
	@PostMapping("/mypage/uploadAjaxAction2")
	public String uploadAjaxPost2(@RequestParam("uploadFile") MultipartFile uploadFile, 
                        HttpServletRequest request) {
      HttpSession session = request.getSession();
      String email = (String)session.getAttribute("email");
      ArtistCommand artist = artistService.getArtistByEmail(email);
      
      
      // 주민번호 처리코드
      String ssn = artist.getSsn();
      String testone = ssn.substring(0, 8);
      System.out.println(testone);
      testone += "******";
      System.out.println(testone);
      request.setAttribute("ssn", testone);
      
      
      String fileRealName = uploadFile.getOriginalFilename(); //파일명을 얻어낼 수 있는 메서드
      long size = uploadFile.getSize(); //파일 사이즈
      
      System.out.println("파일명 : "  + fileRealName);
      System.out.println("용량크기(byte) : " + size);
      
      String fileExtension = fileRealName.substring(fileRealName.lastIndexOf("."),fileRealName.length());
      
      UUID uuid = UUID.randomUUID();
      System.out.println(uuid.toString());
      String[] uuids = uuid.toString().split("-");
      
      String uniqueName = uuids[0];
      System.out.println("생성된 고유문자열" + uniqueName);
      System.out.println("확장자명" + fileExtension);
      String forderName = artist.getName_eng();
      
      String path = SAVE_DIR + "gallerist\\" + forderName; //폴더 경로
      File Folder = new File(path);
      
      System.out.println(path);
      if (!Folder.exists()) {
         try{
             Folder.mkdir(); //폴더 생성합니다. ("새폴더"만 생성)
             System.out.println("폴더가 생성완료.");
              } 
              catch(Exception e){
             e.getStackTrace();
         }        
            }else {
         System.out.println("폴더가 이미 존재합니다..");
      }
      
      File saveFile = new File(SAVE_DIR + "gallerist/" + forderName + "/" + uniqueName + fileExtension);  // 적용 후
      try {
         uploadFile.transferTo(saveFile); // 실제 파일 저장메서드
      } catch (IllegalStateException e) {
         e.printStackTrace();
      } catch (IOException e) {
         e.printStackTrace();
      }
      
      artist.setImgPath(PATH_DIR + "gallerist/" + forderName + "/" + uniqueName+fileExtension);
      artistService.updateArtist(artist);
      request.setAttribute("artist", artist);
      
      return "/mypage/mypage_artist_modify";
   }
	
	
	
	
	
	@PostMapping("/mypage/uploadAjaxAction")
	public String uploadAjaxPost(@RequestParam("uploadFile") MultipartFile uploadFile, 
                        HttpServletRequest request) {
      HttpSession session = request.getSession();
      String email = (String)session.getAttribute("email");
      GalleristCommend gallerist = galleristService.findMyGallerist(email);
      
      
      // 주민번호 처리코드
      String ssn = gallerist.getSsn();
      String testone = ssn.substring(0, 8);
      System.out.println(testone);
      testone += "******";
      System.out.println(testone);
      request.setAttribute("ssn", testone);
      
      
      String fileRealName = uploadFile.getOriginalFilename(); //파일명을 얻어낼 수 있는 메서드
      long size = uploadFile.getSize(); //파일 사이즈
      
      System.out.println("파일명 : "  + fileRealName);
      System.out.println("용량크기(byte) : " + size);
      
      String fileExtension = fileRealName.substring(fileRealName.lastIndexOf("."),fileRealName.length());
      
      UUID uuid = UUID.randomUUID();
      System.out.println(uuid.toString());
      String[] uuids = uuid.toString().split("-");
      
      String uniqueName = uuids[0];
      System.out.println("생성된 고유문자열" + uniqueName);
      System.out.println("확장자명" + fileExtension);
      String forderName = gallerist.getName();
      
      String path = SAVE_DIR + "gallerist\\" + forderName; //폴더 경로
      File Folder = new File(path);
      
      System.out.println(path);
      if (!Folder.exists()) {
         try{
             Folder.mkdir(); //폴더 생성합니다. ("새폴더"만 생성)
             System.out.println("폴더가 생성완료.");
              } 
              catch(Exception e){
             e.getStackTrace();
         }        
            }else {
         System.out.println("폴더가 이미 존재합니다..");
      }
      
      File saveFile = new File(SAVE_DIR + "gallerist/" + forderName + "/" + uniqueName + fileExtension);  // 적용 후
      try {
         uploadFile.transferTo(saveFile); // 실제 파일 저장메서드
      } catch (IllegalStateException e) {
         e.printStackTrace();
      } catch (IOException e) {
         e.printStackTrace();
      }
      
      gallerist.setImgPath(PATH_DIR + "gallerist/" + forderName + "/" + uniqueName+fileExtension);
      galleristService.updateGalleristByEmail(gallerist);
      request.setAttribute("gallerist", gallerist);
      
      return "/mypage/mypage_gallerist_modify";
   }
	
	@PostMapping("/mypage/mypage_gallerist_modify")
	   public String galleristmypageUpdate(GalleristCommend inputGallerist,
	                        HttpServletRequest request, Model model) {
	      model.addAttribute("gallerist", inputGallerist);
	      String ssn = request.getParameter("ssn");
	      inputGallerist.setSsn(ssn);
	      model.addAttribute("ssn", ssn);
	      
	      galleristService.updateGalleristByEmail(inputGallerist);

	      return "mypage/mypage_gallerist";
	   }
	
	
	@GetMapping("/mypage/mypage_gallerist")
	public String galleristMypageForm(HttpServletRequest request, Model model) {
		HttpSession session = request.getSession();
		String email = (String)session.getAttribute("email");		
		GalleristCommend gallerist = galleristService.findMyGallerist(email);
		request.setAttribute("gallerist", gallerist);
		List<String> errorMsgs = new ArrayList<>();
		if(email == null) {
			errorMsgs.add("로그인 상태가 아닙니다.");
		}if(errorMsgs.size() > 0) {
			model.addAttribute("msg", errorMsgs);
			model.addAttribute("url", "/arang/login");
			return "alert";
		}
		
		
		// 주민번호 처리코드
		String ssn = gallerist.getSsn();
		String testone = ssn.substring(0, 8);
		System.out.println(testone);
		testone += "******";
		System.out.println(testone);
		request.setAttribute("ssn", testone);
		
		List<GalleryPageCommand> myGalleryList = 
				galleryService.findMyGallery(email);
		request.setAttribute("myGalleryList", myGalleryList);
		long galleryCount = galleryService.getGalleryCount();
		request.setAttribute("galleryCount", galleryCount);
		
		List<FindContactingArtistCommand> contactingList = 
				contactService.findArtistList(email);
		request.setAttribute("contactingList", contactingList);
		
		List<FindContactArtistCommand> artistList = 
				contactService.findArtistkList(email);
		request.setAttribute("artistList", artistList);
		
		return "mypage/mypage_gallerist";		
	}
	
	
	@GetMapping("/mypage/mypage_gallerist_modify")
	public String galleristmypageUpdateForm(HttpServletRequest request) {
		HttpSession session = request.getSession();
		String email = (String)session.getAttribute("email");
		GalleristCommend gallerist = galleristService.findMyGallerist(email);
		request.setAttribute("gallerist", gallerist);
		
		// 주민번호 처리코드
		String ssn = gallerist.getSsn();
		String testone = ssn.substring(0, 8);
		System.out.println(testone);
		testone += "******";
		System.out.println(testone);
		request.setAttribute("ssn", testone);
		
		return "mypage/mypage_gallerist_modify";
	}

	// contact 부분
	
	@GetMapping("/mypage/mypage_request_list")
	public String requestPageForm(HttpServletRequest request) {
		HttpSession session = request.getSession();
		String email = (String)session.getAttribute("email");
		GalleryCommand gallery = galleryService.findGalleryByEmail(email);
		
		List<FindContactCommend> contactList = 
				contactService.findArtistkById(gallery.getCode());
		
		request.setAttribute("contactList", contactList);
		return "mypage/mypage_request_list";
		
	}
	
	
	//컨택팅 영역
	@PostMapping("/mypage/yesga")
	   public String acceptBtnga(HttpServletRequest request) {
	      String yesBtn = request.getParameter("yesBtn");
	      long id = Long.parseLong(request.getParameter("contactId"));
	      System.out.println(yesBtn);
	      
	      contactService.acceptTpye(yesBtn, id);
	      
	      return "redirect:/mypage/mypage_artist";
	   }
	   
	@PostMapping("/mypage/nodga")
	  public String notBtnga(HttpServletRequest request) {
	     String noBtn = request.getParameter("noBtn");
	     long id = Long.parseLong(request.getParameter("contactId"));
	     System.out.println(noBtn);
	     
	     contactService.acceptTpye(noBtn, id);
	     
	     return "redirect:/mypage/mypage_artist";
	  }
	
	@PostMapping("/mypage/yesda")
	  public String acceptBtnda(HttpServletRequest request) {
	    String yesBtn = request.getParameter("yesBtn");
	    System.out.println(yesBtn);
	    long id = Long.parseLong(request.getParameter("contactId"));
	    System.out.println(id);
	    contactService.acceptTpye(yesBtn, id);
	     
	    return "redirect:/mypage/mypage_gallerist";
	    }
	   
	@PostMapping("/mypage/noda")
	  public String notBtn(HttpServletRequest request) {
	     String noBtn = request.getParameter("noBtn");
	     long id = Long.parseLong(request.getParameter("contactId"));
	     System.out.println(noBtn);
	     System.out.println(id);
	     contactService.acceptTpye(noBtn, id);
	      
	     return "redirect:/mypage/mypage_gallerist";
	   }
	
	
}
