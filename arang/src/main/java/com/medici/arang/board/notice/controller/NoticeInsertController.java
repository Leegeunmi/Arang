package com.medici.arang.board.notice.controller;

import java.util.List;

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

import com.medici.arang.board.notice.command.NoticeCommand;
import com.medici.arang.board.notice.service.NoticeServiceImpl;

@MultipartConfig(
		fileSizeThreshold = 1024*1024,	
		maxFileSize = 1024*1024*100, 		//1024메가
		maxRequestSize = 1024*1024*1024*10) 	// 1024메가 5개까지
@Controller("noticeInsertController")
public class NoticeInsertController {
	private NoticeServiceImpl noticeServiceImpl;
	
	@Autowired
	public NoticeInsertController(NoticeServiceImpl noticeServiceImpl) {
		this.noticeServiceImpl = noticeServiceImpl;
	}
	
	@GetMapping("notice/insertNoticeForm")
	public String insertGet(@ModelAttribute NoticeCommand noticeCommand, Model model,
			HttpServletRequest request) {
		HttpSession session = request.getSession();
		String email = (String)session.getAttribute("email");
		System.out.println(email);
		noticeCommand.setWriter(email);
		
		model.addAttribute("noticeCommand", noticeCommand);
		return "notice/insertNoticeForm";
	}
	
	
//	// 파일업로드 경로 표시
//	private static final String SAVE_DIR = "C:\\JavaYoung\\";
//	private static final String PATH_DIR = "upload_img";
	
	@PostMapping("/notice/insertNoticeForm")
	public String insertPost(@ModelAttribute NoticeCommand noticeCommand,
			Model model) throws Exception {
		
		noticeServiceImpl.insertNotice(noticeCommand);
		model.addAttribute("noticeCommand", noticeCommand);
		return "redirect:notice";
	}
}
