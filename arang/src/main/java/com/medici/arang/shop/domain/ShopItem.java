package com.medici.arang.shop.domain;

import java.util.Date;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class ShopItem {
	
	private long sid;
	private String cateCodeRef;
	private String cateCode;
	private String itemName;
	private double itemPrice;
	private int itemNum;
	private	int itemStock;
	private String itemInfo;
	private String itemImg;
	private Date regDate;
	
	public ShopItem() {
		
	}
}


//cateCodeRef		VARCHAR(20)		DEFAULT NULL,
//cateCode		VARCHAR(20)		DEFAULT NULL,
//itemName		VARCHAR(100)	DEFAULT NULL,
//itemPrice		DOUBLE			DEFAULT NULL,
//itemNum			INT				DEFAULT NULL,
//itemStock		INT				DEFAULT NULL,
//itemInfo		VARCHAR(500)	DEFAULT NULL,
//itemImg			VARCHAR(200)	DEFAULT NULL,
//regDate			TIMESTAMP		NOT NULL DEFAULT CURRENT_TIMESTAMP