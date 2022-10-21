package com.medici.arang.user.controller;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import com.medici.arang.user.command.EmailProvider;
import com.medici.arang.user.command.GalleristCommend;
import com.medici.arang.user.service.GalleristServiceImpl;

@MultipartConfig(
		fileSizeThreshold = 1024*1024,	
		maxFileSize = 1024*1024*100, 		//1024메가
		maxRequestSize = 1024*1024*1024*10) 	// 1024메가 5개까지
@Controller("galleristInsertController")
public class GalleristInsertController {
	private GalleristServiceImpl galleristServiceImpl;
	
	@Autowired
	public GalleristInsertController(GalleristServiceImpl galleristServiceImpl) {
		this.galleristServiceImpl = galleristServiceImpl;
	}	
	
	@GetMapping("gallery/join_gallerist")
	public String insertGallery(Model model, GalleristCommend galleristCommend) {
		model.addAttribute("galleristCommend", galleristCommend);
		return "gallery/join_gallerist";
	}
	
	//회원가입폼 이메일 데이터 제공
		@ModelAttribute("emailProviderList")
		public List<EmailProvider> getEmailProviderList() {
			List<EmailProvider> list = new ArrayList<EmailProvider>();
//			EX)list.add(new EmailProvider("EX)NAME", "EX)VALUE"));
			list.add(new EmailProvider("gmail.com", "gmail.com"));
			list.add(new EmailProvider("naver.com", "naver.com"));
			list.add(new EmailProvider("kakao.com", "kakao.com"));
			list.add(new EmailProvider("yahoo.com", "yahoo.com"));			
			return list;
		}
	
	//이미지 저장될 경로
	private static final String SAVE_DIR = "C:\\Java_geunmi\\java_workspace\\arang\\src\\main\\webapp\\resources\\img\\";
	private static final String PATH_DIR = "/upload_img/";
	


	@PostMapping("gallery/join_gallerist")
	public String insertGalleryForm(@ModelAttribute("galleristCommend")
			GalleristCommend galleristCommend, HttpServletRequest request,
			Model model, @RequestParam("imgName1") List<MultipartFile> multiFileList
			) throws Exception {

		File fileCheck = new File(SAVE_DIR);
		//해당 폴더가 없으면 생성하는거
		if(!fileCheck.exists()) fileCheck.mkdirs();
		
		List<Map<String, String>> fileList = new ArrayList<>();
		List<String> imgList = new ArrayList<String>();
		
		for(int i = 0; i < multiFileList.size(); i++) {
			//실제 파일 이름
			String originFile = multiFileList.get(i).getOriginalFilename();
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
		/**
		 * 배열에 담기위해 배열을 스트링 타입으로 바꿔서 다시 담는곳.
		 * 각각의 값을 ; 로 구분함
		 */
		String imgPathList = "";		
		for (String string : imgList) {
			imgPathList += string;
		}
		System.out.println(imgPathList);
		
		//파일 실제 저장 하는 곳
		try {
			for(int i = 0; i < multiFileList.size(); i++) {
				File uploadFile = new File(SAVE_DIR + "gallerist\\" + fileList.get(i).get("changeFile"));
				multiFileList.get(i).transferTo(uploadFile);
			}
		} catch (IllegalStateException | IOException e) {
			// 업로드 실패시 파일 삭제
			for(int i = 0; i < multiFileList.size(); i++) {
				new File(SAVE_DIR + "gallerist\\" + fileList.get(i).get("changeFile")).delete();
			}
			e.printStackTrace();
		}
		
		/**
		 * DB 처리 하는곳
		 * 이미지 경로의 경우 폼 그대로의 값을 넣지 않기 때문에 경로값 설정후 DB처리
		 */
		galleristCommend.setImgPath(PATH_DIR + "gallerist\\" + imgPathList);
		String imgName = galleristCommend.getImgPath();
		System.out.println(imgName);
		
		
		
				
		String email = galleristCommend.getEmail1()+"@"+galleristCommend.getEmail2();
		galleristCommend.setEmail(email);
		
		System.out.println(galleristCommend.getEmail());
		System.out.println(galleristCommend.getImgPath());
		
		List<String> errorMsgs = new ArrayList<>();
		if(galleristCommend.getEmail() == null || galleristCommend.getEmail().length() == 0) {
			errorMsgs.add("이메일은 필수입력 정보입니다.");
		}if(galleristCommend.getPasswd() == null || galleristCommend.getPasswd().length() == 0) {
			errorMsgs.add("비밀번호는 필수입력 정보입니다.");
		}if(galleristCommend.getName() == null || galleristCommend.getName().length() == 0) {
			errorMsgs.add("이름은 필수입력 정보입니다.");
		}if(galleristCommend.getSsn() == null || galleristCommend.getSsn().length() == 0) {
			errorMsgs.add("주민등록번호는 필수입력 정보입니다.");
		}if(galleristCommend.getPhone() == null || galleristCommend.getPhone().length() == 0) {
			errorMsgs.add("전화번호는 필수입력 정보입니다.");	
		}if(galleristCommend.getPhone() == null || galleristCommend.getPhone().length() == 0) {
			errorMsgs.add("전화번호는 필수입력 정보입니다.");	
		}if(galleristCommend.getPhone() == null || galleristCommend.getPhone().length() == 0) {
			errorMsgs.add("전화번호는 필수입력 정보입니다.");	
		if(errorMsgs.size() > 0) {
			model.addAttribute("msg", errorMsgs);
			model.addAttribute("url", "add_artist");
			return "alert";
			}
		}	
		
		
		galleristServiceImpl.insertGallerist(galleristCommend);
		
		return "redirect:/login";
	}
	
	
}
