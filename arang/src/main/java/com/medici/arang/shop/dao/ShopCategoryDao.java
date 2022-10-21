package com.medici.arang.shop.dao;

import java.util.List;

import org.apache.tomcat.jdbc.pool.DataSource;
import org.springframework.jdbc.core.JdbcTemplate;

import com.medici.arang.shop.domain.ShopCategory;

public class ShopCategoryDao {
	private JdbcTemplate jdbcTemplate;
	
	public ShopCategoryDao(DataSource dataSource) {
		jdbcTemplate = new JdbcTemplate(dataSource);
	}
	
	// 신규 상품 카테고리 추가 
	public void addShopCategory(ShopCategory shopCategory) {
		String sql = "INSERT INTO ShopCategory (cateName, cateCode, cateCodeRef)"
				+ " VALUES (?, ?, ?)";
		jdbcTemplate.update(sql, shopCategory.getCateName(),
				shopCategory.getCateCode(), shopCategory.getCateCodeRef());
		}
	
	// 모든 상품 카테고리 조회 
	public List<ShopCategory> getAllCategory() {
		String sql = "SELECT cateName, cateCode, cateCodeRef FROM ShopCategory";
		return jdbcTemplate.query(sql, new ShopCategoryRowMapper());
	}
	
	// RefCode로 상품 카테고리 조회하기 
	public List<ShopCategory> getCategoryByCateCodeRef(String cateCodeRef) {
		String sql = "SELECT cateName,cateCode, cateCodeRef FROM ShopCategory"
				+ " WHERE cateCodeRef=?";
		return jdbcTemplate.query(sql, new ShopCategoryRowMapper(), cateCodeRef);
	}
	
	// 카테고리 수정하기 
	public void updateCategory(ShopCategory shopCategory, String cateCodeRef) {
		String sql = "UPDATE ShopCategory"
				+ " SET cateName=?, cateCode=?, coateCodeRef=? WHERE cateCodeRef=?";
		jdbcTemplate.update(sql,
				shopCategory.getCateName(), shopCategory.getCateCode(), shopCategory.getCateCodeRef(), cateCodeRef);
	}
	
	// 카테고리 삭제하기
	public void deleteCategory(String cateCodeRef) {
		String sql = "DELETE FROM ShopCategory WHERE cateCodeRef=?";
		jdbcTemplate.update(sql, cateCodeRef);
	}
}
 