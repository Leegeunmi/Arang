package com.medici.arang.board.notice.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

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

@Controller("noticeUpdateController")
public class NoticeUpdateController {
	private NoticeServiceImpl noticeServiceImpl;
	
	@Autowired
	public NoticeUpdateController(NoticeServiceImpl noticeServiceImpl) {
		this.noticeServiceImpl = noticeServiceImpl;
	}
	
//	// 파일업로드 경로 표시
//	private static final String SAVE_DIR = "C:\\JavaYoung\\JavaStudy\\eclipse-workspace\\arang\\src\\main\\webapp\\resources\\img\\";
//	private static final String PATH_DIR = "/upload_img/";
	
	@GetMapping("notice/updateNoticeForm")
	public String updateGet(@ModelAttribute NoticeCommand noticeCommand, Model model,
			HttpServletRequest request, @RequestParam long num) {
//		HttpSession session = request.getSession();
//		String getEmail = (String) session.getAttribute("email");
//		String adminIdentified = (String) session.getAttribute("writer");
//		command.setWriter(adminIdentified);
		List<NoticeCommand> noticeUpdate = noticeServiceImpl.findOneNotice(num);
		
		request.setAttribute("noticeCommand", noticeCommand);
		model.addAttribute("noticeUpdate", noticeUpdate);
		return "notice/updateNoticeForm";
	}
	@PostMapping("notice/updateNoticeForm")
	public String updatePost(@ModelAttribute NoticeCommand noticeCommand, Model model,
			HttpServletRequest request) {
//	
		long getLong = noticeCommand.getNum(); 
		long noticeUpdate = noticeServiceImpl.updateNotice(noticeCommand, getLong);

		request.setAttribute("noticeUpdate", noticeUpdate);
		model.addAttribute("noticeCommand", noticeCommand);
		return "redirect:notice";
	}
}
