package com.medici.arang.user.controller;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import com.medici.arang.user.command.ArtistCommand;
import com.medici.arang.user.command.EmailProvider;
import com.medici.arang.user.service.ArtistServiceImpl;

@MultipartConfig(
		fileSizeThreshold = 1024*1024,
		maxFileSize = 1024*1024*100, 		//100메가
		maxRequestSize = 1024*1024*100*5) 	// 100메가 5개까지
@Controller("controller.addArtistController")
public class AddArtistController {
	
	@Autowired
	ArtistServiceImpl artistService;
	
	@GetMapping("/user/add_artist")
	public String addArtistForm(Model model) {
		model.addAttribute("artistCommand", new ArtistCommand());
		return "user/add_artist";
	}
	
	//이미지 저장될 경로
	private static final String SAVE_DIR = "C:\\Java_geunmi\\java_workspace\\arang\\src\\main\\webapp\\resources\\img\\";
	private static final String PATH_DIR = "/upload_img/";
	
	//유저 회원가입 처리 + 이미지 처리
	@PostMapping("user/add_artist")
	public String addArtist(@ModelAttribute("artistCommand")
			ArtistCommand artistCommand, Model model,
			HttpServletRequest request, @RequestParam("imgFile") MultipartFile file) {
//			HttpSession session = request.getSession();
		
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
		String forderName = artistCommand.getName_eng();
		
		String path = SAVE_DIR + "artist\\" + forderName; //폴더 경로
		File Folder = new File(path);
		
		System.out.println(path);
		// 해당 디렉토리가 없다면 디렉토리를 생성.
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
		
		
		
		File saveFile = new File(SAVE_DIR + "artist/" + forderName + "/" + uniqueName + fileExtension);  // 적용 후
		try {
			file.transferTo(saveFile); // 실제 파일 저장메서드(filewriter 작업을 손쉽게 한방에 처리해준다.)
		} catch (IllegalStateException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		artistCommand.setImgPath(PATH_DIR + "artist/" + forderName + "/" + uniqueName+fileExtension);
		String imgName = artistCommand.getImgPath();
				
		String email = artistCommand.getEmail1()+"@"+artistCommand.getEmail2();
		artistCommand.setEmail(email);
		
		
		String[] genreList = request.getParameterValues("selectGenre");
		String resultGenre = "";
		if ( genreList.length > 1 ) {
			for (String genre : genreList) {
				resultGenre += genre;
				resultGenre += ";";
				artistCommand.setGenre(resultGenre);
			}
			
		}else if ( genreList.length == 1 ) {
			for (String genre : genreList) {
				resultGenre += genre;
				artistCommand.setGenre(resultGenre);
			}
		}
		
		System.out.println(artistCommand.getGenre());
		
		
		String[] careerList = request.getParameterValues("inputCareer");
		String resultCareer = "";
		for (String career : careerList) {
			if( career != null ) {
				resultCareer += career;
				resultCareer += ";";
				artistCommand.setCareer(resultCareer);				
			}
		}
		
		System.out.println(artistCommand.getCareer());
		
		List<String> errorMsgs = new ArrayList<>();
		if(artistCommand.getEmail() == null || artistCommand.getEmail().length() == 0) {
			errorMsgs.add("이메일은 필수입력 정보입니다.");
		}if(artistCommand.getPasswd() == null || artistCommand.getPasswd().length() == 0) {
			errorMsgs.add("비밀번호는 필수입력 정보입니다.");
		}if(artistCommand.getName_kor() == null || artistCommand.getName_kor().length() == 0) {
			errorMsgs.add("이름은 필수입력 정보입니다.");
		}if(artistCommand.getName_eng() == null || artistCommand.getName_eng().length() == 0) {
			errorMsgs.add("이름은 필수입력 정보입니다.");
		}if(artistCommand.getSsn() == null || artistCommand.getSsn().length() == 0) {
			errorMsgs.add("주민등록번호는 필수입력 정보입니다.");
		}if(artistCommand.getPhone() == null || artistCommand.getPhone().length() == 0) {
			errorMsgs.add("전화번호는 필수입력 정보입니다.");	
		}if(artistCommand.getGenre() == null || artistCommand.getGenre().length() == 0) {
			errorMsgs.add("1개 이상의 장르를 선택해주세요.");
		}
		
		if(errorMsgs.size() > 0) {
			model.addAttribute("msg", errorMsgs);
			model.addAttribute("url", "add_artist");
			return "alert";
			}

		model.addAttribute("imgName", imgName);
		artistService.addArtist(artistCommand);
		return "redirect:/login";
	}
	
	//회원가입폼 이메일 데이터 제공
	@ModelAttribute("emailProviderList")
	public List<EmailProvider> getEmailProviderList() {
		List<EmailProvider> list = new ArrayList<EmailProvider>();
//		EX)list.add(new EmailProvider("EX)NAME", "EX)VALUE"));
		list.add(new EmailProvider("gmail.com", "gmail.com"));
		list.add(new EmailProvider("naver.com", "naver.com"));
		list.add(new EmailProvider("kakao.com", "kakao.com"));
		list.add(new EmailProvider("yahoo.com", "yahoo.com"));			
		return list;
	}
	
	//회원가입폼 번호 데이터 제공
	@ModelAttribute("phoneProviderList")
	public List<String> getPhoneProviderList() {
		List<String> list = new ArrayList<String>();
		list.add("010");
		list.add("011");
		list.add("02");
		list.add("053");
		list.add("076");
		return list;
	}
	
	@GetMapping("user/add_success")
	public String welcome() {
		return "user/add_success";
	}
	
	@PostMapping("user/add_success")
	public String goMain() {
		return "main";
		
	}

}