package com.medici.arang.shop.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.medici.arang.shop.domain.Cart;
import com.medici.arang.shop.domain.ShopItem;
import com.medici.arang.shop.service.ShopItemServiceImpl;

@Controller("controller.customerCartController")
public class CustomerCartController {
	
	@Autowired
	ShopItemServiceImpl shopItemService;
	
	@GetMapping("/customer_page/customer_cart")
	public String customerCart(@RequestParam("itemName") String itemName) {
		System.out.println(itemName);
		ShopItem shopItem = shopItemService.getAllShopItemByName(itemName);
		String itemImg = shopItem.getItemImg();
		Double itemPrice = shopItem.getItemPrice();
		Cart cart = new Cart();
		cart.setItemImg(itemImg);
		cart.setItemName(itemName);
		cart.setItemStock(1);
		cart.setItemPrice(itemPrice);
		shopItemService.addCart(cart);
		
		return "customer_page/customer_main";
	}
	
//	public ResponseEntity<T> dosomething() {
//		return ResponseEntity.ok(list);
//	}
	
//	@PostMapping("/customer_page/customer_cart")
//	public String custoemrCart1() {
//		return "customer_page/customer_main";
//	}
	
	@GetMapping("/customer_page/customer_buy")
	public String customerBuyForm(@RequestParam("itemName1") String itemName,
			HttpServletRequest request) {
		ShopItem shopItem = shopItemService.getAllShopItemByName(itemName);
		String itemImg = shopItem.getItemImg();
		Double itemPrice = shopItem.getItemPrice();
		Cart cart = new Cart();
		cart.setItemImg(itemImg);
		cart.setItemName(itemName);
		cart.setItemStock(1);
		cart.setItemPrice(itemPrice);
		shopItemService.addCart(cart);
		
		List<Cart> cartItemList = shopItemService.getFindCart();
		request.setAttribute("cartItemList", cartItemList);
		List<ShopItem> itemList = shopItemService.getAllShopItem();
		request.setAttribute("itemList", itemList);
		
		return "customer_page/customer_buy";
	}
	
	@PostMapping("/customer_page/customer_buy")
	public String customerBuy() {
		return "customer_page/customer_buy_success";
	}
	
	@GetMapping("/customer_page/delete_cart_item")
	public String deleteCartItem(@RequestParam("deleteItem") long cid) {
		
		shopItemService.deleteCartItem(cid);
		
		return "redirect:/customer_page/customer_main";
	}
	
	@GetMapping("/customer_page/customer_buy_success")
	public String gomain() {
		return "customer_page/customer_main";
	}
}
