package com.medici.arang.shop.dao;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.medici.arang.shop.domain.ShopItem;

public class ShopItemRowMapper implements RowMapper<ShopItem> {

	@Override
	public ShopItem mapRow(ResultSet rs, int rowNum)
			throws SQLException {
		
		ShopItem shopItem = new ShopItem();	
		shopItem.setSid(rs.getLong("sid"));
		shopItem.setCateCodeRef(rs.getString("cateCodeRef"));
		shopItem.setCateCode(rs.getString("cateCode"));
		shopItem.setItemName(rs.getString("itemName"));
		shopItem.setItemPrice(rs.getDouble("itemPrice"));
		shopItem.setItemNum(rs.getInt("itemNum"));
		shopItem.setItemStock(rs.getInt("itemStock"));
		shopItem.setItemInfo(rs.getString("itemInfo"));
		shopItem.setItemImg(rs.getString("itemImg"));
		shopItem.setRegDate(rs.getDate("regDate"));
		
		return shopItem;
	}

}
