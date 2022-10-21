package com.medici.arang.shop.controller;

import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.UUID;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import com.medici.arang.shop.domain.ShopItem;
import com.medici.arang.shop.service.ShopItemServiceImpl;

@Controller("controller.shopItemFindController")
public class ShopItemFindController {
	@Autowired
	ShopItemServiceImpl shopItemService;
	
	@GetMapping("/admin_page/find_all_shop_item")
	public String findAllItemForm(HttpServletRequest request) {
		
		return "admin_page/find_all_shop_item";
	}
	
	@PostMapping("/admin_page/find_all_shop_item")
	public String findAllItem(HttpServletRequest request, Model model) {
		
		List<ShopItem> shopItemList = shopItemService.getAllShopItem();
		request.setAttribute("shopItemList", shopItemList);
		
		return "admin_page/find_all_shop_item";
	}
	
	@GetMapping("/admin_page/update_shop_item")
	public String updateShopItemForm(@RequestParam("sid1") long sid, Model model) {
		
		model.addAttribute("shopItem", new ShopItem());
		
		List<ShopItem> updateList = shopItemService.findShopItemBySid(sid);
		
		model.addAttribute("updateList", updateList);
		
		return "admin_page/update_shop_item";
	}
	
	private static final String SAVE_DIR = "C:\\Java_geunmi\\java_workspace\\arang\\src\\main\\webapp\\resources\\img\\";
	
	@PostMapping("/admin_page/update_shop_item")
	public String updateShopItem(@ModelAttribute("shopItem") ShopItem shopItem,
			@RequestParam("sid1") long sid, @RequestParam("imgUpload") MultipartFile file, Model model) {
		
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
		
		shopItem.setItemImg(uniqueName+fileExtension);
		String imgName = shopItem.getItemImg();
		System.out.println(imgName);
		model.addAttribute("imgName", imgName);
		
		shopItemService.updateItem(shopItem, sid);
		
		return "admin_page/update_shop_item";
	}
	
//	@PostMapping("/admin_page/update_shop_item")
//	public String updateShopItem(@ModelAttribute("shopItem") ShopItem shopItem,
//			@RequestParam("sid1") long sid) {
//		
//		shopItemService.updateItem(shopItem, sid);
//		
//		return "admin_page/update_shop_item";	
//	}
	
	
	
	@GetMapping("/admin_page/delete_shop_itme")
	public String deleteShopItem(@RequestParam("sid1") long sid) {
		
		shopItemService.deleteItem(sid);
		
		return "admin_page/admin_main";
	}
}
