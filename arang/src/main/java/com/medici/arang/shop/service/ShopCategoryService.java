package com.medici.arang.shop.service;

import java.util.List;

import com.medici.arang.shop.domain.ShopCategory;

public interface ShopCategoryService {
	public void addShopCategory(ShopCategory shopCategory);
	List<ShopCategory> getAllCategory();
	List<ShopCategory> getCategoryByCateCodeRef(String cateCodeRef);
}
