package com.medici.arang.board.notice.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.medici.arang.board.notice.command.NoticeCommand;
import com.medici.arang.board.notice.service.NoticeServiceImpl;

@Controller("noticeDeleteController")
public class NoticeDeleteController {
	private NoticeServiceImpl noticeServiceImpl;
	
	@Autowired
	public NoticeDeleteController(NoticeServiceImpl noticeServiceImpl) {
		this.noticeServiceImpl = noticeServiceImpl;
	}
	
	@GetMapping("notice/deleteNoticeForm")
	public String deleteGet(@ModelAttribute NoticeCommand command, Model model) {
		model.addAttribute("command",command);
		return "notice/deleteNoticeForm";
	}
	
	@PostMapping("notice/deleteNoticeForm")
	public String deletePost(@ModelAttribute NoticeCommand command, Model model,
			HttpServletRequest request) {
		long getLong = command.getNum(); 
		long noticeDelete = noticeServiceImpl.deleteNotice(getLong);
		
		request.setAttribute("noticeDelete", noticeDelete);
		model.addAttribute("command", command);
		return "redirect:notice";
	}
}
