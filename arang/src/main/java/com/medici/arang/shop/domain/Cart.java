package com.medici.arang.shop.domain;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Cart {
	
	private long cid;
	private String itemImg;
	private String itemName;
	private int itemStock;
	private double itemPrice;
	
	public Cart() {
		
	}
}
