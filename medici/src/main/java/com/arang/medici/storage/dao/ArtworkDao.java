package com.arang.medici.storage.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.arang.medici.dataconnect.*;
import com.arang.medici.storage.domain.*;

public class ArtworkDao {
	private DataSource dataSource;
	public ArtworkDao() {
		NamingService ns = NamingService.getInstance();
		dataSource = (DataSource)ns.getAttribute("dataSource");
	}
	
	public void addArtwork(Artwork artwork) {
		String sql = "INSERT INTO Artworks (artworkNum, storage, startPeriod, endPeriod, deliveryService)"
				+ " VALUES (?, ?, ?, ?, ?)";
		try {
			Connection con = null;
			PreparedStatement pstmt = null;
			try {
				con = dataSource.getConnection();
				pstmt = con.prepareStatement(sql);
				pstmt.setString(1, artwork.getArtworkNum());
				pstmt.setString(2, artwork.getStorage());
				pstmt.setString(3, artwork.getStartPeriod());
				pstmt.setString(4, artwork.getEndPeriod());
				pstmt.setString(5, artwork.getDbService());
				pstmt.executeLargeUpdate();
			} finally {
				dataSource.close(pstmt, con);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public List<Artwork> findArtwork() {
		String sql = "SELECT * FROM Artworks";
		List<Artwork> artworkList = new ArrayList<Artwork>();
		try {
			Connection con = null;
			PreparedStatement pstmt = null;	
			ResultSet rs = null;
			try {
				con = dataSource.getConnection();
				pstmt = con.prepareStatement(sql);
				rs = pstmt.executeQuery();
				while(rs.next()) {
					Artwork artwork = new Artwork();
					artwork.setArtworkNum(rs.getString("artworkNum"));
					artwork.setUserId(rs.getString("userId"));
					artwork.setStorage(rs.getString("storage"));
					artwork.setStartPeriod(rs.getString("startPeriod"));
					artwork.setEndPeriod(rs.getString("endPeriod"));
					artwork.setDbService("deliveryService");
					artworkList.add(artwork);
				}
			}finally {
				dataSource.close(rs, pstmt, con);
			}
		}catch(SQLException e) {
			e.printStackTrace();
		}
		return artworkList;
	}
	
	public Wallet payment(Wallet wallet) {
		String sql = "SELECT * FROM Wallet WHERE userId = ?";
		
		try {
			Connection con = null;
			PreparedStatement pstmt = null;
			ResultSet rs = null;
			try {
				Double CalcBalance = null;
				Double ResultBalance = null;
				con = dataSource.getConnection();
				pstmt = con.prepareStatement(sql);
				
				pstmt.setString(1, wallet.getUserId());
				rs = pstmt.executeQuery();
				while(rs.next()) {
					CalcBalance = rs.getDouble("balance");
				}
				
				ResultBalance = (CalcBalance - wallet.getBalance());
				
				if ( ResultBalance >= 0 ) {
					wallet.setResultBalance(ResultBalance);
					wallet.setSucessMsg(wallet.getBalance() + "원 결제완료!!");
					updateBalance(wallet.getUserId(), ResultBalance);
				}else {
					wallet.setFailMsg("결제실패..!! 이유 : 잔액부족");
				}
				
				
			} finally {
				dataSource.close(rs, pstmt, con);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return wallet;
	}
	
	public void updateBalance(String userId, Double inputBalance) {
		String sql = "UPDATE Wallet SET balance=? WHERE userId=?";
		try {
			Connection con = null;
			PreparedStatement pstmt = null;
			try {
				con = dataSource.getConnection();; 
				pstmt = con.prepareStatement(sql);
				pstmt.setDouble(1, inputBalance);
				pstmt.setString(2, userId);
				pstmt.executeUpdate();
			} finally {
				dataSource.close(pstmt, con);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
}
