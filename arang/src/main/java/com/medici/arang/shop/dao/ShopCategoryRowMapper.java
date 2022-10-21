package com.medici.arang.shop.dao;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowCallbackHandler;
import org.springframework.jdbc.core.RowMapper;

import com.medici.arang.shop.domain.ShopCategory;

public class ShopCategoryRowMapper implements RowMapper<ShopCategory> {

	@Override
	public ShopCategory mapRow(ResultSet rs, int rowNum) throws SQLException {
		
		ShopCategory shopCategory = new ShopCategory();
		shopCategory.setCateName(rs.getString("cateName"));
		shopCategory.setCateCode(rs.getString("cateCode"));
		shopCategory.setCateCodeRef(rs.getString("cateCodeRef"));
		
		return shopCategory;
	}

}
