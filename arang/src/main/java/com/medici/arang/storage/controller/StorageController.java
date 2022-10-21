package com.medici.arang.storage.controller;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.medici.arang.storage.domain.Storage;
import com.medici.arang.storage.service.StorageServiceImpl;

@Controller("controller.storageController")
public class StorageController {

	@Autowired
	StorageServiceImpl storageService;
	
	@GetMapping("/storage_page/storage_main")
	public String storageMainForm(HttpServletRequest request) {
		HttpSession session = request.getSession();
		String email = (String)session.getAttribute("email");
		session.setAttribute("email", email);
		return "storage_page/storage_main";
	}
	
	@PostMapping("/storage_page/storage_main")
	public String storageMain() {
		return "storage_page/storage_main";
	}
	
	@GetMapping("/storage_page/storage_add")
	public String addStorageForm(Model model, HttpServletRequest request) {
		HttpSession session = request.getSession();
		String email = (String)session.getAttribute("email");
		session.setAttribute("email", email);
		
		//신청 폼에 오늘 날짜 자동으로 넣어주는 역할
		Date today = new Date();
		SimpleDateFormat date = new SimpleDateFormat("yyyy-MM-dd");
		String myToday = date.format(today);
		model.addAttribute("myToday", myToday);
		
		//신청 INSERT
		model.addAttribute("storage", new Storage());
	
		return "storage_page/storage_add";
	}
	
	@PostMapping("/storage_page/storage_add")
	public String addStorage(@ModelAttribute("storage") Storage storage, Model model) {
		
		model.addAttribute("storage", storage);
		storageService.addStorage(storage);
		
		model.addAttribute("msg", "신청이 완료되었습니다.");
		model.addAttribute("url", "storage_main");
		return "alert";
	}
	
	@GetMapping("/storage_page/storage_admin")
	public String StrorageAdminForm(HttpServletRequest request) {
		
		List<Storage> storageList = storageService.getAllStorage();
		request.setAttribute("storageList", storageList);
		
		return "storage_page/storage_admin";
	}
	
	@PostMapping("/storage_page/storage_admin")
	public String StorageAdmin(HttpServletRequest request) {
		
		List<Storage> storageList = storageService.getAllStorage();
		request.setAttribute("storageList", storageList);
		
		return "storage_page/storage_admin";
	}
	
	@GetMapping("/storage_page/storage_update")
	public String StorageUpdateForm(@RequestParam("sid") long sid, Model model) {
		
		model.addAttribute("storage", new Storage());
		List<Storage> storageList = storageService.getStorageBySid(sid);
		model.addAttribute("storageList", storageList);
		
		return "storage_page/storage_update";
	}
	
	@PostMapping("/storage_page/storage_update")
	public ModelAndView StorageUpdate(
			@ModelAttribute("storage") Storage storage,
			@RequestParam("sid") long sid,
			Model model, HttpServletRequest request) {
		
		storageService.updateStorage(storage, sid);
		
		ModelAndView mav = new ModelAndView();
		mav.setViewName("redirect:/storage_page/storage_admin");
		return mav;
	}
	
	@GetMapping("/storage_page/storage_delete")
	public String StorageDelete(@RequestParam("sid") long sid,
			@RequestParam("approvalStatus") String approvalStatus,
			HttpServletRequest request, Model model) {
		
		if(approvalStatus.equals("승인완료")) {
			model.addAttribute("msg", "이미 승인되어 진행중인 신청이므로 취소가 불가능합니다.");
			model.addAttribute("url", "storage_main");
			return "alert";
		}
		
		storageService.cancelStorage(sid);
		
		model.addAttribute("msg", "취소가 완료되었습니다.");
		model.addAttribute("url", "storage_main");
		return "alert";
	}
	
	@GetMapping("/storage_page/storage_artist")
	public String StorageArtistMainForm() {
		
		return "storage_page/storage_artist";
	}
	
	@PostMapping("/storage_page/storage_artist")
	public String StorageArtistMain(HttpServletRequest request) {
		HttpSession session = request.getSession();
		String email = (String)session.getAttribute("email");
		session.setAttribute("email", email);
		
		List<Storage> myStorageList = storageService.getStorageByArtistId(email);
		request.setAttribute("myStorageList", myStorageList);
		
		return "storage_page/storage_artist";
	}
	
}
