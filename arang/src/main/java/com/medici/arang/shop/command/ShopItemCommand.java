package com.medici.arang.shop.command;

import java.util.Date;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class ShopItemCommand {
	
	private String cateCodeRef;
	private String cateCode;
	private String itemName;
	private double itemPrice;
	private int itemNum;
	private	int itemStock;
	private String itemInfo;
	private String itemImg;
	private Date regDate;
	
	public ShopItemCommand() {
		super();
	}
}
