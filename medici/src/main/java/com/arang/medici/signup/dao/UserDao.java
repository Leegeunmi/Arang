package com.arang.medici.signup.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.arang.medici.dataconnect.*;
import com.arang.medici.signup.domain.User;

public class UserDao {
	private DataSource dataSource;
	public UserDao() {
		NamingService ns = NamingService.getInstance();
		dataSource = (DataSource)ns.getAttribute("dataSource");
	}
	
	//ADD_USER
	public void plusUser(User user) {
		String sql = "INSERT INTO UserSignUp (userId, passwd, koreanName, englishName, "
				+ "ssn, acaBackGround, major, careerYear, careerType, company, portpolio,"
				+ " mainGenre, priceAvg, salesRate, mainArtwork, phoneNumber, email, sns)"
				 + " VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
		try {
			Connection con = null;
			PreparedStatement pstmt = null;	
			try {
				con = dataSource.getConnection();
				pstmt = con.prepareStatement(sql);
				pstmt.setString(1, user.getUserId());
				pstmt.setString(2, user.getPasswd());
				pstmt.setString(3, user.getKoreanName());
				pstmt.setString(3, user.getEnglishName());
				pstmt.setString(4, user.getSsn());
				pstmt.setString(5, user.getAcaBackGround());
				pstmt.setString(6, user.getMajor());
				pstmt.setString(7, user.getCareerYear());
				pstmt.setString(8, user.getCareerType());
				pstmt.setString(9, user.getCompany());
				pstmt.setString(10, user.getPortpolio());
				pstmt.setString(11, user.getMainGenre());
				pstmt.setString(12, user.getPriceAvg());
				pstmt.setString(13, user.getSalesRate());
				pstmt.setString(14, user.getMainArtwork());
				pstmt.setString(15, user.getPhoneNumber());
				pstmt.setString(16, user.getEmail());
				pstmt.executeUpdate();
			} finally {
				dataSource.close(pstmt, con);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	//UPDATE_USER
	public void updateUser(User user) { 
		String sql = "UPDATE UserSignUp SET passwd = ?, userName = ? WHERE userId = ?";
		try {
			Connection con = null;
			PreparedStatement pstmt = null;
			ResultSet rs = null;
			try {
				con = dataSource.getConnection();
				pstmt = con.prepareStatement(sql);
				pstmt.setString(1, user.getPasswd());
				pstmt.setString(2, user.getKoreanName());
				pstmt.setString(3, user.getUserId());
				pstmt.executeUpdate();
			} finally {
				dataSource.close(rs, pstmt, con);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	//DELETE_USER by userId
	public void deleteUserByUserId(User user) {
		String sql = "DELETE FROM UserSignUp WHERE userId = ?";		
		try {
			Connection con = null;
			PreparedStatement pstmt = null;
			ResultSet rs = null;
			try {
				con = dataSource.getConnection();
				pstmt = con.prepareStatement(sql);
				pstmt.setString(1, user.getKoreanName());
				pstmt.executeUpdate();
			} finally {
				dataSource.close(rs, pstmt, con);
			}
		} catch ( SQLException e) {
			e.printStackTrace();
		}
	}
	
	//FIND_USER
	public List<User> findAllUser() {
		String sql = "SELECT * FROM UserSignUp";
		List<User> userList = new ArrayList<User>();
		try {
			Connection con = null;
			PreparedStatement pstmt = null;	
			ResultSet rs = null;
			try {
				con = dataSource.getConnection();
				pstmt = con.prepareStatement(sql);
				rs = pstmt.executeQuery();
				while(rs.next()) {
					User c = new User();
					c.setUserId(rs.getString("userId"));
					c.setPasswd(rs.getString("passwd"));
					c.setKoreanName(rs.getString("koreanName"));
					c.setSsn(rs.getString("ssn"));
					c.setEmail(rs.getString("email"));
					userList.add(c);
				}
			}finally {
				dataSource.close(rs, pstmt, con);
			}
		}catch(SQLException e) {
			e.printStackTrace();
		}
		return userList;
	}
	
	public boolean isValidUser(String userId, String passwd) {
		String sql = "SELECT * FROM UserSignUp WHERE userId=? AND passwd=?";
		boolean bool = true;
		try {
			Connection con = null;
			PreparedStatement pstmt = null;
			ResultSet rs = null;
			try {
				con = dataSource.getConnection();
				pstmt = con.prepareStatement(sql);
				pstmt.setString(1, userId);
				pstmt.setString(2, passwd);
				rs = pstmt.executeQuery();
				if(!rs.next()) {
					bool = false;
				}
			} finally {
				dataSource.close(rs, pstmt, con);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}			
		return bool;		
	}
	
	public int idCheck(String id) {
		String sql = "SELECT userId FROM UserSignUp WHERE userId = ?";	
		int value = 0;			
		try {
			Connection con = null;
			PreparedStatement pstmt = null;
			ResultSet rs = null;
			try {
				con = dataSource.getConnection();
				pstmt = con.prepareStatement(sql);
				pstmt.setString(1, id);
				pstmt.executeQuery();
				if(rs.next()) value = 1;
			} finally {
				dataSource.close(rs, pstmt, con);
			} 
		} catch ( SQLException e) {
			e.printStackTrace();
		} 
		return value;
	}

	
}
