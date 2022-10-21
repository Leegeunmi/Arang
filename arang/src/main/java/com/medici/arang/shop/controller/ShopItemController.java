package com.medici.arang.shop.controller;

import java.io.File;
import java.io.IOException;
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

import com.medici.arang.shop.domain.ShopCategory;
import com.medici.arang.shop.domain.ShopItem;
import com.medici.arang.shop.service.ShopCategoryServiceImpl;
import com.medici.arang.shop.service.ShopItemServiceImpl;

@MultipartConfig(
		fileSizeThreshold = 1024*1024,
		maxFileSize = 1024*1024*50,
		maxRequestSize = 1024*1024*50*5
		)
@Controller("controller/shopItemController")
public class ShopItemController {
	@Autowired
	ShopItemServiceImpl shopItemService;
	
	@Autowired
	ShopCategoryServiceImpl shopCategoryService;
	
//	@GetMapping("/admin_page/add_item")
//	public String viewCategoryForm(HttpServletRequest request, Model model) {
//		model.addAttribute("shopCategory", new ShopCategory());
//		List<ShopCategory> shopCategoryList = shopCategoryService.getAllCategory();
//		request.setAttribute("shopCategoryList", shopCategoryList);
//		
//		return "admin_page/add_item";
//	}
//	
//	@PostMapping("/admin_page/add_item")
//	public String viewCategory(@ModelAttribute("shopCategory")
//		ShopCategory shopCategory, Model model) {
//		
//		shopCategoryService.addShopCategory(shopCategory);
//		
//		model.addAttribute("shopCategory", shopCategory);
//		
//		return "admin_page/add_item";
//	}
	
	@GetMapping("/admin_page/add_item")
	public String addItemForm(HttpServletRequest request, Model model) {
		model.addAttribute("shopCategory", new ShopCategory());
		List<ShopCategory> shopCategoryList = shopCategoryService.getAllCategory();
		request.setAttribute("shopCategoryList", shopCategoryList);
		
		model.addAttribute("item", new ShopItem());
		return "admin_page/add_item";
	}
	
	private static final String SAVE_DIR = "C:\\Java_geunmi\\java_workspace\\arang\\src\\main\\webapp\\resources\\img\\";
	
	// 상품 추가 폼
	@PostMapping("/admin_page/add_item")
	public String addItem(@ModelAttribute("item")
					ShopItem item, Model model,
					@RequestParam("imgUpload") MultipartFile file
					) {
		
		System.out.println("-----------");
		String fileRealName = file.getOriginalFilename(); // 파일명을 얻어낼 수 있는 메서드
		long size = file.getSize(); // 파일 사이즈  
		
		System.out.println("파일명 : "  + fileRealName);
		System.out.println("용량크기(byte) : " + size);
		
		String fileExtension = fileRealName.substring(fileRealName.lastIndexOf("."),fileRealName.length());
		
		UUID uuid = UUID.randomUUID();
		System.out.println(uuid.toString());
		String[] uuids = uuid.toString().split("-");
		
		String uniqueName = uuids[0];
		System.out.println("생성된 고유문자열" + uniqueName);
		System.out.println("확장자명" + fileExtension);
		
		File saveFile = new File(SAVE_DIR+"/"+uniqueName + fileExtension); // 적용후 
		try {
			file.transferTo(saveFile);
		} catch (IllegalStateException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		item.setItemImg(uniqueName+fileExtension);
		String imgName = item.getItemImg();
		System.out.println(imgName);
		model.addAttribute("imgName", imgName);
		shopItemService.addShopItem(item);
		
		return "admin_page/admin_main";
	}
}















































