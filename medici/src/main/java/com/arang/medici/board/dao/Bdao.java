package com.arang.medici.board.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.sql.*;

import com.arang.medici.board.dto.Bdto;
import com.arang.medici.dataconnect.*;
import com.arang.medici.dataconnect.DataSource;

public class Bdao {
	private DataSource dataSource;
	public Bdao(){
		NamingService namingService = NamingService.getInstance();
		dataSource = (DataSource)namingService.getAttribute("dataSource");	
	}
	
	public ArrayList<Bdto> list(){
		String sql = "SELECT bId, bName, bTitle, bContent,"
				+ " bDate, bHit, bGroup, bStep, bIndent"
				+ " FROM board ORDER BY bId DESC, bStep ASC";
		ArrayList<Bdto> dtos = new ArrayList<Bdto>();
		try {
			Connection con = null;
			PreparedStatement pstmt = null;	
			ResultSet rs = null;
			try {
				con = dataSource.getConnection();
				pstmt = con.prepareStatement(sql);
				rs = pstmt.executeQuery();				
				while(rs.next()){
					int bId = rs.getInt("bId");
					String bName = rs.getString("bName");
					String bTitle = rs.getString("bTitle");
					String bContent = rs.getString("bContent");
					Timestamp bDate = rs.getTimestamp("bDate");
					int bHit = rs.getInt("bHit");
					int bGroup = rs.getInt("bgroup");
					int bStep = rs.getInt("bStep");
					int bIndent =rs.getInt("bIndent");
					Bdto dto = new Bdto(bId, bName, bTitle, bContent,
							bDate, bHit, bGroup, bStep, bIndent);
					dtos.add(dto);
				}
			}finally {
				dataSource.close(rs, pstmt, con);
			}
		}catch (SQLException e) {
			e.printStackTrace();			
		}
		return dtos;
	}
	
	public void write(String bName, String bTitle, String bContent){
		String sql ="INSERT INTO board(bId, bName, bTitle, bContent,"
				+ " bHit,"
				+ " bGroup, bStep, bIndent)"
				+ "VALUES(0,?,?,?,1,1,1,1)";
		try {
			Connection con = null;
			PreparedStatement pstmt = null;
			try {
				con = dataSource.getConnection();
				pstmt = con.prepareStatement(sql);
				pstmt.setString(1, bName);
				pstmt.setString(2, bTitle);
				pstmt.setString(3, bContent);
				pstmt.executeUpdate();
			} finally {
				dataSource.close(pstmt, con);
			}
		} catch (SQLException e) {					 
			e.printStackTrace();
		}			
	}
	
	public Bdto view(String sbId){
		String sql = "SELECT * FROM board WHERE bId=?";
		plusHit(sbId);
		Bdto dto = null;
		try {
			Connection con = null;
			PreparedStatement pstmt = null;
			ResultSet rs = null;			
			try {
				con = dataSource.getConnection();
				pstmt = con.prepareStatement(sql);
				pstmt.setInt(1, Integer.parseInt(sbId));
				rs = pstmt.executeQuery();
				if(rs.next()){
					int bId = rs.getInt("bId");
					String bName = rs.getString("bName");
					String bTitle = rs.getString("bTitle");
					String bContent = rs.getString("bContent");
					Timestamp bDate = rs.getTimestamp("bDate");
					int bHit = rs.getInt("bHit");
					int bGroup = rs.getInt("bgroup");
					int bStep = rs.getInt("bStep");
					int bIndent =rs.getInt("bIndent");
					dto = new Bdto(bId, bName, bTitle, bContent, bDate, bHit, bGroup, bStep, bIndent);
				}
			} finally {
				
			}
		}	catch (SQLException e) {
			e.printStackTrace();
		}
		return dto;
	}

	private void plusHit(String bId){
		String sql = "UPDATE board SET bHit = bHit+1 WHERE bId = ?";
		try {
			Connection con = null;
			PreparedStatement pstmt = null;			
			try {
				con = dataSource.getConnection();
				pstmt = con.prepareStatement(sql);
				pstmt.setString(1, bId);			
				int n = pstmt.executeUpdate();
			} finally {
				dataSource.close(pstmt, con);
			} 
		}catch(Exception e){
				e.printStackTrace();											
			}
		}
	
	public void modify(String bId, String bName, String bTitle, String bContent){
		String sql = "UPDATE board SET bName=?, bTitle=?, bContent=? WHERE bId =?";
		try {
			Connection con = null;
			PreparedStatement pstmt = null;
			try {
				con = dataSource.getConnection();
				pstmt = con.prepareStatement(sql);
				pstmt.setString(1, bName);
				pstmt.setString(2, bTitle);
				pstmt.setString(3, bContent);
				pstmt.setInt(4, Integer.parseInt(bId));				
				int n = pstmt.executeUpdate();				
			} finally {
				dataSource.close(pstmt, con);
			}
		}	catch (SQLException e) {
			e.printStackTrace();
		}
	}

	
	public void delete(String bId){
		String sql = "DELETE FROM board WHERE bId = ?";
		try {
			Connection con=null;
			PreparedStatement pstmt = null;
			try {
				con = dataSource.getConnection();
				pstmt = con.prepareStatement(sql);
				pstmt.setInt(1,Integer.parseInt(bId));				
				int n = pstmt.executeUpdate();				
			} finally {
				dataSource.close(pstmt, con);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	public Bdto replyView(String sBid){
		String sql = "SELECT * FROM board WHERE bId = ?";
		Bdto dto = null;
		try {
			Connection con = null;
			PreparedStatement pstmt = null;
			ResultSet rs = null;
			try {
				con = dataSource.getConnection();
				pstmt = con.prepareStatement(sql);
				pstmt.setInt(1,Integer.parseInt(sBid));
				rs = pstmt.executeQuery();	
				if(rs.next()){
					int bId = rs.getInt("bId");
					String bName = rs.getString("bName");
					String bTitle = rs.getString("bTitle");
					String bContent = rs.getString("bContent");
					Timestamp bDate = rs.getTimestamp("bDate");
					int bHit = rs.getInt("bHit");
					int bGroup = rs.getInt("bgroup");
					int bStep = rs.getInt("bStep");
					int bIndent = rs.getInt("bIndent");
					dto = new Bdto(bId, bName, bTitle, bContent,
							bDate, bHit, bGroup, bStep, bIndent);
				}
			}finally {
				dataSource.close(pstmt, con);
			}
		}	catch(SQLException e) {
			e.printStackTrace();
		}
			return dto;
	}

	public void reply(String bid, String bName, String bTitle,
			String bContent, String bGroup, String bStep, String bIndent){
		String sql = "INSERT INTO board(bName, bTitle, bContent, bgroup, bStep, bIndent)"
				+ "VALUES(?,?,?,?,?,?)";
		try {
			replyForm(bGroup, bStep);		
			Connection con = null;
			PreparedStatement pstmt = null;
			try {
				con = dataSource.getConnection();
				pstmt = con.prepareStatement(sql);				
				pstmt.setString(1, bName);
				pstmt.setString(2, bTitle);
				pstmt.setString(3, bContent);
				pstmt.setInt(4, Integer.parseInt(bGroup));
				pstmt.setInt(5, Integer.parseInt(bStep)+1);
				pstmt.setInt(6, Integer.parseInt(bIndent)+1);
				int n = pstmt.executeUpdate();
			} finally {
				dataSource.close(pstmt, con);
			}
		}	catch (SQLException e) {
			e.printStackTrace();							
		}
	}
	
	private void replyForm(String sGroup, String sStep){
		String sql = "UPDATE board SET bStep = bStep+1 "
				+ "WHERE bgroup = ? and bStep > ?";
		try {
			Connection con = null;
			PreparedStatement pstmt = null;			
			try {
				con = dataSource.getConnection();
				pstmt = con.prepareStatement(sql);
				pstmt.setInt(1, Integer.parseInt(sGroup));
				pstmt.setInt(2, Integer.parseInt(sStep));				
				int n = pstmt.executeUpdate();				
			} finally {
				dataSource.close(pstmt, con);
			}
		}	catch (SQLException e) {
			e.printStackTrace();
		}
	}


	}
