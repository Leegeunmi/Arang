package com.medici.arang.shop.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import com.medici.arang.shop.domain.ShopItem;
import com.medici.arang.shop.service.ShopItemServiceImpl;

@Controller("controller.shopPageController")
public class ShopPageController {
	
	@Autowired
	ShopItemServiceImpl shopItemService;
	
	@GetMapping("/customer_page/customer_main")
	public String customerMainForm(HttpServletRequest request) {
		List<ShopItem> shopItemList = shopItemService.getAllShopItem();
		request.setAttribute("shopItemList", shopItemList);
		return "customer_page/customer_main";
	}
	
	@PostMapping("/customer_page/customer_main")
	public String custoemrMain(HttpServletRequest request) {
		
		List<ShopItem> shopItemList = shopItemService.getAllShopItem();
		request.setAttribute("shopItemList", shopItemList);
		
		return "customer_page/customer_main";
	}
	
	@GetMapping("/admin_page/admin_main")
	public String adminMainForm() {
		return "admin_page/admin_main";
	}
	
	@PostMapping("/admin_page/admin_main")
	public String adminMain() {
		return "admin_page/admin_main";
	}
}
