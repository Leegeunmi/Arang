package com.medici.arang.shop.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.medici.arang.shop.domain.ShopCategory;
import com.medici.arang.shop.service.ShopCategoryServiceImpl;

@Controller("controller.shopCategoryFindController")
@RequestMapping("/admin_page/find_all_category")
public class ShopCategoryFindController {
	
	@Autowired
	ShopCategoryServiceImpl shopCategoryService;
	
	@GetMapping
	public String findAllCategory1(HttpServletRequest request) {
		
		return "admin_page/find_all_category";
	}
	
	@PostMapping
	public String findAllCategory(HttpServletRequest request) {
		
		List<ShopCategory> shopCategoryList = shopCategoryService.getAllCategory();
		request.setAttribute("shopCategoryList", shopCategoryList);
		
		return "admin_page/find_all_category";
	}
	
	@GetMapping("/admin_page/update_shop_category")
	public String updateShopCategoryForm(String cateCodeRef, HttpServletRequest request) {
		
		List<ShopCategory> updateList = shopCategoryService.getCategoryByCateCodeRef(cateCodeRef);
		request.setAttribute("updateList", updateList);
		
		return "admin_page/update_shop_category";
	}
 
}
