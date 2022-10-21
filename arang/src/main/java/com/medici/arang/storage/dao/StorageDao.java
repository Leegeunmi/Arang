package com.medici.arang.storage.dao;

import java.util.List;

import javax.sql.DataSource;

import org.springframework.jdbc.core.JdbcTemplate;

import com.medici.arang.storage.domain.Storage;

public class StorageDao {
	private JdbcTemplate jdbcTemplate;
	
	public StorageDao(DataSource dataSource) {
		jdbcTemplate = new JdbcTemplate(dataSource);
	}
	
	// 보관 신청 받기 
	public void addStorage(Storage storage) {
		String sql = "INSERT INTO Storage (artistId, myAddress, storagePeriodStart, storagePeriodEnd, artworkType,"
				+ " artworkSize, locationArea, charge, transport, approvalStatus)"
				+ " VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
		jdbcTemplate.update(sql,
				storage.getArtistId(), storage.getMyAddress(),
				storage.getStoragePeriodStart(), storage.getStoragePeriodEnd(), storage.getArtworkType(),
				storage.getArtworkSize(), storage.getLocationArea(), 
				storage.getCharge(), storage.getTransport(), storage.getApprovalStatus());
	}
	
	// 모든 보관 신청 조회 
	public List<Storage> getAllStorage() {
		String sql = "SELECT sid, artistId, myAddress, storagePeriodStart, storagePeriodEnd, artworkType,"
				+ " artworkSize, locationArea, charge, transport, approvalStatus, regDate FROM Storage";
		return jdbcTemplate.query(sql, new StorageRowMapper());
	}
	
	// artistId로 보관 신청 조회
	public List<Storage> getStorageByArtistId(String artistId) {
		String sql = "SELECT sid, artistId, myAddress, storagePeriodStart, storagePeriodEnd, artworkType,"
				+ " artworkSize, locationArea, charge, transport, approvalStatus, regDate FROM Storage"
				+ " WHERE artistId=?";
		
		return jdbcTemplate.query(sql, new StorageRowMapper(), artistId);
	}
	
	// sid로 보관 신청 조회
		public List<Storage> getStorageBySid(long sid) {
			String sql = "SELECT sid, artistId, myAddress, storagePeriodStart, storagePeriodEnd, artworkType,"
					+ " artworkSize, locationArea, charge, transport, approvalStatus, regDate FROM Storage"
					+ " WHERE sid=?";
			
			return jdbcTemplate.query(sql, new StorageRowMapper(), sid);
		}
	
	// 보관 신청 수정
	public void updateStorage(Storage storage, long sid) {
		String sql = "UPDATE Storage"
				+ " SET artistId=?, myAddress=?,"
				+ " storagePeriodStart=?, storagePeriodEnd=?, artworkType=?,"
				+ " artworkSize=?, locationArea=?,"
				+ " charge=?, transport=?,"
				+ " approvalStatus=? WHERE sid=?";
		jdbcTemplate.update(sql,
				storage.getArtistId(), storage.getMyAddress(),
				storage.getStoragePeriodStart(), storage.getStoragePeriodEnd(), storage.getArtworkType(),
				storage.getArtworkSize(), storage.getLocationArea(),
				storage.getCharge(), storage.getTransport(), storage.getApprovalStatus(), sid);
	}
	
	// 보관 신청 취소
	public void cancelStorage(long sid) {
		String sql = "DELETE FROM Storage WHERE sid=?";
		jdbcTemplate.update(sql, sid);
	}
	
}
