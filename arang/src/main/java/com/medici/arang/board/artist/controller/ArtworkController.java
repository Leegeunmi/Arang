package com.medici.arang.board.artist.controller;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.UUID;

import javax.servlet.annotation.MultipartConfig;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import com.medici.arang.board.artist.command.ArtistInfoCommand;
import com.medici.arang.board.artist.command.ArtworkCommand;
import com.medici.arang.board.artist.command.ArtworkInfoCommand;
import com.medici.arang.board.artist.command.FindArtistInfoCommand;
import com.medici.arang.board.artist.service.ArtistInfoServiceImpl;
import com.medici.arang.board.artist.service.ArtworkInfoServiceImpl;
import com.medici.arang.board.artist.service.ArtworkServiceImpl;
import com.medici.arang.user.command.ArtistCommand;
import com.medici.arang.user.command.ArtistPageCommand;
import com.medici.arang.user.service.ArtistServiceImpl;

@MultipartConfig(
	    fileSizeThreshold = 1024*1024,
	    maxFileSize = 1024*1024*50, 		//50메가
	    maxRequestSize = 1024*1024*50*5) 	// 50메가 5개까지
@Controller
public class ArtworkController {
	
	@Autowired
	public ArtworkServiceImpl artworkService;
	
	@Autowired
	public ArtistServiceImpl artistservice;
	
	@Autowired
	public ArtistInfoServiceImpl artistInfoService;
	
	@Autowired
	public ArtworkInfoServiceImpl artworkInfoService;
	
	//	작품추가 페이지FORM
	@GetMapping("/pages/add_artwork")
	public String artworkForm(Model model, HttpServletRequest request) {
		HttpSession session = request.getSession();
		Object loginEmail = session.getAttribute("email");
		if (loginEmail == null) {
			return "main";
		}
		String loginEmail1 = (String) session.getAttribute("email");
		ArtistCommand artist = artistservice.getArtistByEmail(loginEmail1);
		FindArtistInfoCommand artistInfo = artistInfoService.findArtistInfo(artist.getAid());
		model.addAttribute("artist", artistInfo);
		model.addAttribute("artwork", new ArtworkCommand());
		return "pages/add_artwork";
	}
	
	// 카테고리 Select FORM
	@ModelAttribute("categoryProvicerList")
	public List<String> getCategoryList(){
		List<String> list = new ArrayList<String>();
		list.add("Sculptor");
		list.add("Painter");
		list.add("OrientalPainter");
		list.add("DrawingArtist");
		list.add("Illustator");
		list.add("DigitalArtist");
		list.add("Photographer");
		
		return list;
	}
	
	// 작품카테고리 Select FORM
	@ModelAttribute("artCategoryProvicerList")
	public List<String> getArtCategoryList(){
		List<String> list = new ArrayList<String>();
		list.add("Sculpture");
		list.add("Paint");
		list.add("OrientalPaint");
		list.add("Drawing");
		list.add("Illustration");
		list.add("DigtalArt");
		list.add("Photo");
		
		return list;
	}
	
	private static final String SAVE_DIR = "C:\\Java_geunmi\\java_workspace\\arang\\src\\main\\webapp\\resources\\img\\artist";
	private static final String PATH_DIR = "/upload_img/";
	
	//	작품추가 기능
	@PostMapping("/pages/add_artwork")
	public String addArtwork(@ModelAttribute("artwork") ArtworkCommand artwork, 
						Model model, @RequestParam("imgFile") List<MultipartFile> multiFileList,
						HttpServletRequest request,
						ArtworkInfoCommand artworkInfo) {
		HttpSession session = request.getSession();
		String loginEmail = (String) session.getAttribute("email");
		ArtistCommand artist = artistservice.getArtistByEmail(loginEmail);
		
		System.out.println("-----------");
		List<Map<String, String>> fileList = new ArrayList<>();
		List<String> imgList = new ArrayList<String>();
		
		for(int i = 0; i < multiFileList.size(); i++) {
			//실제 파일 이름
			String originFile = multiFileList.get(i).getOriginalFilename();  //파일명을 얻어낼 수 있는 메서드
			System.out.println("파일명 : "  + originFile);
			//실제 파일 확장자
			String ext = originFile.substring(originFile.lastIndexOf("."));
			//UUID 가짜 이름 + 확장자
			UUID uuid = UUID.randomUUID();
			String[] uuids = uuid.toString().split("-");			
			String changeFile = uuids[0] + ext;
			imgList.add(changeFile);
			
			Map<String, String> map = new HashMap<>();
			map.put("originFile", originFile);
			map.put("changeFile", changeFile);
			fileList.add(map);
		}
		System.out.println(imgList);
		String artworkImg = imgList.get(0);
		imgList.remove(0);
		String imgPathList = "";
		for (String string : imgList) {
			imgPathList += PATH_DIR;
			imgPathList += "\\artwork\\";
			imgPathList += string;
			imgPathList += ";";
		}
		System.out.println(imgPathList);
		//파일 실제 저장 하는 곳
				try {
					for(int i = 0; i < multiFileList.size(); i++) {
						File uploadFile = new File(SAVE_DIR + "\\artwork\\" + fileList.get(i).get("changeFile"));
						multiFileList.get(i).transferTo(uploadFile);
					}
				} catch (IllegalStateException | IOException e) {
					// 업로드 실패시 파일 삭제
					for(int i = 0; i < multiFileList.size(); i++) {
						new File(SAVE_DIR + "\\artwork\\" + fileList.get(i).get("changeFile")).delete();
					}
					e.printStackTrace();
				}
		
		artwork.setArtworkImgPath(PATH_DIR + "\\artwork\\" + artworkImg);
		artworkInfo.setWorkInfoImgPath(imgPathList);
		String imgName = artwork.getArtworkImgPath();
		System.out.println(imgName);
		artwork.setArtistId(artist.getAid());
		/* workInfoImgPath */
		
		System.out.println(artwork.getArtworkImgPath());
		System.out.println(artworkInfo.getWorkInfoImgPath());
		artworkService.addArtwork(artwork);
		ArtworkCommand findArtwork = artworkService.findArtworkByImg(imgName);

		System.out.println(findArtwork.getWid());
		artworkInfo.setArtworkId(findArtwork.getWid());
		artworkInfoService.addArtworkInfo(artworkInfo);
		model.addAttribute("artist", artist);
		model.addAttribute("artwork", artwork);
		model.addAttribute("artworkInfo", artworkInfo);
		model.addAttribute("imgName", imgName);
		return "pages/success_add_artwork";
	}
	
	
	// 작품수정 Form
	@GetMapping("/pages/update_artwork")
	public String updateArtworkForm(@RequestParam("id") long id,Model model) {
		model.addAttribute("artwork", new ArtworkCommand());
		String email = "test@naver.com";
		
		ArtworkCommand artworkCommand = artworkService.findArtwork(id);
		
		model.addAttribute("artworkCommand", artworkCommand);
		return "pages/update_artwork";
	}
	
	// 작품수정 기능
	@PostMapping("/pages/update_artwork")
	public String updateMenu(@ModelAttribute("artwork") ArtworkCommand artwork,
					Model model, @RequestParam("imgFile") MultipartFile file) {
		
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
		
		File saveFile = new File(SAVE_DIR+"\\"+uniqueName + fileExtension);  // 적용 후
		try {
			file.transferTo(saveFile); // 실제 파일 저장메서드(filewriter 작업을 손쉽게 한방에 처리해준다.)
		} catch (IllegalStateException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		artwork.setArtworkImgPath(PATH_DIR+uniqueName+fileExtension);
		String imgName = artwork.getArtworkImgPath();
		System.out.println(imgName);
		model.addAttribute("imgName", imgName);
		model.addAttribute("artwork", artwork);

		artworkService.updateArtwork(artwork);
		
		return "pages/update_artwork";
	}
	
	// 작품조회 Form
	@GetMapping("/pages/find_artwork")
	public String findArtworkForm(HttpServletRequest request) {
		long artistId = 1001;
		List<ArtworkCommand> findArtworkList = artworkService.allfindArtwork(artistId);
		request.setAttribute("findArtworkList", findArtworkList);
		return "pages/find_artwork";
	}
	
	
	// 작품삭제 기능
	@PostMapping("/pages/find_artwork")
	public String deleteArtwork(HttpServletRequest request) {
		String StringId = request.getParameter("id");
		long id = Long.parseLong(StringId);
		artworkService.deleteArtwork(id);
		long artistId = 101;
		List<ArtworkCommand> findArtworkList = artworkService.allfindArtwork(artistId);
		request.setAttribute("findArtworkList", findArtworkList);
		return "pages/find_artwork";
	}
	
	
	// 작품전체 조회 Form ( 일반유저페이지 )
	@GetMapping("/pages/all_find_artwork")
	public String allFindArtworkForm(HttpServletRequest request) {
		List<ArtworkCommand> findArtworkList = artworkService.allFindArtwork();
		request.setAttribute("findArtworkList", findArtworkList);
		return "pages/all_find_artwork";
	}
	

}
