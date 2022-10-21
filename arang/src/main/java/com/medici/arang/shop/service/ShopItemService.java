package com.medici.arang.shop.service;

import java.util.List;

import com.medici.arang.shop.domain.Cart;
import com.medici.arang.shop.domain.ShopItem;

public interface ShopItemService {
	
	public void addShopItem(ShopItem shopItem);
	List<ShopItem> getAllShopItem();
	List<ShopItem> findShopItemBySid(long sid);
	public ShopItem getAllShopItemBySid(long sid);
	List<ShopItem> findItemByName(String itemName);
	public ShopItem getAllShopItemByName(String itemName);
	public void updateItem(ShopItem shopItem, long sid);
	public void deleteItem(long sid);
	public void addCart(Cart cart);
	List<Cart> getFindCart();
	public void deleteCartItem(long cid);
}
