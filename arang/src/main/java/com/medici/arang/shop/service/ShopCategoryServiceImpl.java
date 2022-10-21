package com.medici.arang.shop.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.medici.arang.shop.dao.ShopCategoryDao;
import com.medici.arang.shop.domain.ShopCategory;

public class ShopCategoryServiceImpl implements ShopCategoryService{
	
	@Autowired
	ShopCategoryDao shopCategoryDao;
	
	@Override
	public void addShopCategory(ShopCategory shopCategory) {
		shopCategoryDao.addShopCategory(shopCategory);
	}
	
	@Override
	public List<ShopCategory> getAllCategory() {
		return shopCategoryDao.getAllCategory();
	}
	
	@Override
	public List<ShopCategory> getCategoryByCateCodeRef(String cateCodeRef) {
		return shopCategoryDao.getCategoryByCateCodeRef(cateCodeRef);
	}
}
