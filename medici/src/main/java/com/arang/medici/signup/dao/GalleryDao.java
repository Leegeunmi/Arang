package com.arang.medici.signup.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.arang.medici.dataconnect.*;
import com.arang.medici.signup.domain.Gallery;

public class GalleryDao {
	private DataSource dataSource;
	public GalleryDao() {
		NamingService ns = NamingService.getInstance();
		dataSource = (DataSource)ns.getAttribute("dataSource");
	}
	
	//ADD_USER
	public void plusGallery(Gallery gallery) {
		String sql = "INSERT INTO GalleryList (GalleryId, passwd, GalleryName, GalleryScale, GalleryAddr, GalleryNumber, GalleryEmail, GallerySns)"
				 + " VALUES (?, ?, ?, ?, ?, ?, ?, ?)";
		try {
			Connection con = null;
			PreparedStatement pstmt = null;	
			try {
				con = dataSource.getConnection();
				pstmt = con.prepareStatement(sql);
				pstmt.setString(1, gallery.getGalleryId());
				pstmt.setString(2, gallery.getPasswd());
				pstmt.setString(3, gallery.getGalleryName());
				pstmt.setString(4, gallery.getGalleryScale());
				pstmt.setString(5, gallery.getGalleryAddr());
				pstmt.setString(6, gallery.getGalleryNumber());
				pstmt.setString(7, gallery.getGalleryEmail());
				pstmt.setString(8, gallery.getGallerySns());
				pstmt.executeUpdate();
			} finally {
				dataSource.close(pstmt, con);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	//UPDATE_USER
	public void updateGallery (Gallery gallery) { 
		String sql = "UPDATE GalleryList SET passwd = ?, GalleryName = ? WHERE GalleryId = ?";
		try {
			Connection con = null;
			PreparedStatement pstmt = null;
			try {
				con = dataSource.getConnection();
				pstmt = con.prepareStatement(sql);
				pstmt.setString(1, gallery.getPasswd());
				pstmt.setString(2, gallery.getGalleryName());
				pstmt.setString(3, gallery.getGalleryId());
				pstmt.executeUpdate();
			} finally {
				dataSource.close(pstmt, con);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	//DELETE_USER by userId
	public void deleteGalleryByGalleryId(Gallery gallery) {
		String sql = "DELETE FROM GalleryList WHERE galleryId = ?";		
		try {
			Connection con = null;
			PreparedStatement pstmt = null;
			try {
				con = dataSource.getConnection();
				pstmt = con.prepareStatement(sql);
				pstmt.setString(1, gallery.getGalleryId());
				pstmt.executeUpdate();
			} finally {
				dataSource.close(pstmt, con);
			}
		} catch ( SQLException e) {
			e.printStackTrace();
		}
	}
	
	//FIND_USER
	public List<Gallery> findAllGallery() {
		String sql = "SELECT * FROM GalleryList";
		List<Gallery> galleryList = new ArrayList<Gallery>();
		try {
			Connection con = null;
			PreparedStatement pstmt = null;	
			ResultSet rs = null;
			try {
				con = dataSource.getConnection();
				pstmt = con.prepareStatement(sql);
				rs = pstmt.executeQuery();
				while(rs.next()) {
					Gallery gallery = new Gallery();
					gallery.setGalleryId(rs.getString("galleryId"));
					gallery.setPasswd(rs.getString("passwd"));
					gallery.setGalleryName(rs.getString("galleryName"));
					gallery.setGalleryScale(rs.getString("galleryScale"));
					gallery.setGalleryAddr(rs.getString("galleryAddr"));
					gallery.setGalleryNumber(rs.getString("galleryNumber"));
					gallery.setGalleryEmail(rs.getString("galleryEmail"));
					gallery.setGallerySns(rs.getString("gallerySns"));
					galleryList.add(gallery);
				}
			}finally {
				dataSource.close(rs, pstmt, con);
			}
		}catch(SQLException e) {
			e.printStackTrace();
		}
		return galleryList;
	}
	
	public boolean isValidUser(String galleryId, String passwd) {
		String sql = "SELECT * FROM GalleryList WHERE galleryId=? AND passwd=?";
		boolean bool = true;
		try {
			Connection con = null;
			PreparedStatement pstmt = null;
			ResultSet rs = null;
			try {
				con = dataSource.getConnection();
				pstmt = con.prepareStatement(sql);
				pstmt.setString(1, galleryId);
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
