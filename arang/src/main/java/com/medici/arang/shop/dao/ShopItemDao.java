package com.medici.arang.shop.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.apache.tomcat.jdbc.pool.DataSource;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;

import com.medici.arang.shop.domain.Cart;
import com.medici.arang.shop.domain.ShopItem;

public class ShopItemDao {
	private JdbcTemplate jdbcTemplate;
	
	public ShopItemDao(DataSource dataSource) {
		jdbcTemplate = new JdbcTemplate(dataSource);
	}
	
	// 신규 상품 추가 
	public void addShopItem(ShopItem shopItem) {
		String sql = "INSERT INTO ShopItem (sid, cateCodeRef, cateCode, itemName, itemPrice,"
				+ " itemNum, itemStock, itemInfo, itemImg)"
				+ " VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?)";
		jdbcTemplate.update(sql, shopItem.getSid(),
				shopItem.getCateCodeRef(), shopItem.getCateCode(),
				shopItem.getItemName(), shopItem.getItemPrice(),
				shopItem.getItemNum(), shopItem.getItemStock(),
				shopItem.getItemInfo(), shopItem.getItemImg());
	}
	
	// 모든 상품 조회 
	public List<ShopItem> getAllShopItem() {
		String sql = "SELECT sid, cateCodeRef, cateCode, itemName, itemPrice, itemNum, "
				+ "itemStock, itemInfo, itemImg, regDate FROM ShopItem";
		return jdbcTemplate.query(sql, new ShopItemRowMapper());
	}
	// sid로 상품 조회 
	public List<ShopItem> findShopItemBySid(long sid) {
		String sql = "SELECT itemImg, itemName, itemStock, itemPrice,"
				+ " sid, cateCodeRef, cateCode, itemNum, itemInfo, regDate From ShopItem"
				+ " WHERE sid=?";
		
		return jdbcTemplate.query(sql, new ShopItemRowMapper(), sid);
	}
	
	// sid로 상품 전체 조회
	public ShopItem getAllShopItemBySid(long sid) {
		String sql = "SELECT itemImg, itemName, itemStock, itemPrice,"
				+ " sid, cateCodeRef, cateCode, itemNum, itemInfo, regDate From ShopItem"
				+ " WHERE sid=?";
		
		return jdbcTemplate.queryForObject(sql, new ShopItemRowMapper(), sid);
	}
	
	// 이름으로 상품 조회 
	public List<ShopItem> findItemByName(String itemName) {
		String sql = "SELECT itemImg, itemName, itemStock, itemPrice,"
				+ " sid, cateCodeRef, cateCode, itemNum, itemInfo, regDate From ShopItem"
				+ " WHERE itemName=?";
		
		return jdbcTemplate.query(sql, new ShopItemRowMapper(), itemName);
	}
	
	// 이름으로 상품 전체 조회 
	public ShopItem getAllShopItemByName(String itemName) {
		String sql = "SELECT itemImg, itemName, itemStock, itemPrice,"
				+ " sid, cateCodeRef, cateCode, itemNum, itemInfo, regDate From ShopItem"
				+ " WHERE itemName=?";
		return jdbcTemplate.queryForObject(sql, new ShopItemRowMapper(), itemName);
	}
	
	// 상품 업데이트하기 
	public void updateItem(ShopItem shopItem, long sid) {
		String sql = "UPDATE ShopItem"
				+ " SET sid=?, cateCodeRef=?, cateCode=?,"
				+ " itemName=?, itemPrice=?,"
				+ " itemNum=?, itemStock=?,"
				+ " itemInfo=?, itemImg=? WHERE sid=?";
		jdbcTemplate.update(sql, shopItem.getSid(),
				shopItem.getCateCodeRef(), shopItem.getCateCode(),
				shopItem.getItemName(), shopItem.getItemPrice(),
				shopItem.getItemNum(), shopItem.getItemStock(),
				shopItem.getItemInfo(), shopItem.getItemImg(),
				sid);
	}
	
	// 상품 삭제하기 
	
	public void deleteItem(long sid) {
		String sql = "DELETE FROM ShopItem WHERE sid=?";
		jdbcTemplate.update(sql, sid);
	}
	
	// 카트에 상품 담기 
	public void addCart(Cart cart) {
		String sql = "INSERT INTO Cart (cid, itemImg, itemName, itemStock, itemPrice)"
				+ " VALUES (?, ?, ?, ?, ?)";
		jdbcTemplate.update(sql, cart.getCid(),
				cart.getItemImg(), cart.getItemName(),
				cart.getItemStock(), cart.getItemPrice());
	}
	
	// 카트에 담긴 모든 상품 조회하기 
	public List<Cart> getFindCart() {
		String sql = "SELECT * FROM Cart";						
		return jdbcTemplate.query(sql, new RowMapper<Cart>() {
			
			public Cart mapRow(ResultSet rs, int rowNum) throws SQLException {
				Cart cart = new Cart();
				cart.setCid(rs.getLong("cid"));
				cart.setItemImg(rs.getString("itemImg"));
				cart.setItemName(rs.getString("itemName"));
				cart.setItemStock(rs.getInt("itemStock"));
				cart.setItemPrice(rs.getDouble("itemPrice"));
				
				return cart;
			}
		});
	}
	
	// 카트에 담긴 상품 삭제하기 
	public void deleteCartItem(long cid) {
		String sql = "DELETE FROM Cart WHERE cid=?";
		jdbcTemplate.update(sql, cid);
	}
}












































