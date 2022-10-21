package com.medici.arang.storage.dao;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.medici.arang.storage.domain.Storage;

public class StorageRowMapper implements RowMapper<Storage> {

	@Override
	public Storage mapRow(ResultSet rs, int rowNum) throws SQLException {
		
		Storage storage = new Storage();
		storage.setSid(rs.getLong("sid"));
		storage.setArtistId(rs.getString("artistId"));
		storage.setMyAddress(rs.getString("myAddress"));
		storage.setStoragePeriodStart(rs.getString("storagePeriodStart"));
		storage.setStoragePeriodEnd(rs.getString("storagePeriodEnd"));
		storage.setArtworkType(rs.getString("artworkType"));
		storage.setArtworkSize(rs.getString("artworkSize"));
		storage.setLocationArea(rs.getString("locationArea"));
		storage.setCharge(rs.getInt("charge"));
		storage.setTransport(rs.getBoolean("transport"));
		storage.setApprovalStatus(rs.getString("approvalStatus"));
		storage.setRegDate(rs.getDate("regDate"));
		
		return storage;	
	}

}
