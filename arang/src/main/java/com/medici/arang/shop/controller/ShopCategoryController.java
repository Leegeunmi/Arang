package com.medici.arang.shop.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.medici.arang.shop.domain.ShopCategory;
import com.medici.arang.shop.service.ShopCategoryServiceImpl;

@Controller("controller.shopcategoryController")
@RequestMapping("/admin_page/add_category")
public class ShopCategoryController {
	@Autowired
	ShopCategoryServiceImpl shopCategoryService;
	
	@GetMapping
	public String addCategoryForm(Model model) {
		model.addAttribute("shopCategory", new ShopCategory());
		return "admin_page/add_category";
	}
	
	@PostMapping
	public String addCategory(@ModelAttribute("shopCategory")
		ShopCategory shopCategory, Model model) {
		
		model.addAttribute("shopCategory", shopCategory);
		
		shopCategoryService.addShopCategory(shopCategory);
		
		return "admin_page/admin_main";
	}
	
//	@ModelAttribute("ShopItemProvider")
//	public List<ShopItemProvider> getProviderList() {
//		List<ShopItemProvider> list = new ArrayList<ShopItemProvider>();
//		list.add(new ShopItemProvider("돌", "100"));
//		list.add(new ShopItemProvider("그림", "200"));
//		list.add(new ShopItemProvider("목제", "300"));
//		list.add(new ShopItemProvider("철판", "400"));
//		return list;
//	}
}
