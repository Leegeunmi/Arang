package com.medici.arang.shop.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.medici.arang.shop.domain.ShopCategory;
import com.medici.arang.shop.service.ShopCategoryServiceImpl;

@Controller("controller.shopcategoryController2")
@RequestMapping("/admin_page/add_category2")
public class ShopCategoryController2 {
	@Autowired
	ShopCategoryServiceImpl shopCategoryService;
	
	@GetMapping
	public String addCategoryForm(HttpServletRequest request, Model model) {
		model.addAttribute("shopCategory", new ShopCategory());
		List<ShopCategory> shopCategoryList = shopCategoryService.getAllCategory();
		request.setAttribute("shopCategoryList", shopCategoryList);
		
		return "admin_page/add_category2";
	}
	
	@PostMapping
	public String addCategory(@ModelAttribute("shopCategory")
		ShopCategory shopCategory, Model model) {
		
		shopCategoryService.addShopCategory(shopCategory);
		
		model.addAttribute("shopCategory", shopCategory);
		
		return "admin_page/admin_main";
	}
}
