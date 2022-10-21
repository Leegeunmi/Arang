package com.medici.arang.shop.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.medici.arang.shop.dao.ShopItemDao;
import com.medici.arang.shop.domain.Cart;
import com.medici.arang.shop.domain.ShopItem;

public class ShopItemServiceImpl implements ShopItemService{
	
	@Autowired
	ShopItemDao shopItemDao;
	
	@Override
	public void addShopItem(ShopItem shopItem) {
		shopItemDao.addShopItem(shopItem);
	}
	
	@Override
	public List<ShopItem> getAllShopItem() {
		return shopItemDao.getAllShopItem();
	}
	
	@Override
	public List<ShopItem> findShopItemBySid(long sid) {
		return shopItemDao.findShopItemBySid(sid);
	}
	
	@Override
	public ShopItem getAllShopItemBySid(long sid) {
		return shopItemDao.getAllShopItemBySid(sid);
	}
	
	@Override
	public List<ShopItem> findItemByName(String itemName) {
		return shopItemDao.findItemByName(itemName);
	}
	
	@Override
	public ShopItem getAllShopItemByName(String itemName) {
		return shopItemDao.getAllShopItemByName(itemName);
	}
	
	@Override
	public void updateItem(ShopItem shopItem, long sid) {
		shopItemDao.updateItem(shopItem, sid);
	}
	
	@Override
	public void deleteItem(long sid) {
		shopItemDao.deleteItem(sid);
	}
	
	@Override
	public void addCart(Cart cart) {
		shopItemDao.addCart(cart);
	}
	
	@Override
	public List<Cart> getFindCart() {
		return shopItemDao.getFindCart();
	}
	
	@Override
	public void deleteCartItem(long cid) {
		shopItemDao.deleteCartItem(cid);
	}
}
