package com.medici.arang.storage.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.medici.arang.storage.dao.StorageDao;
import com.medici.arang.storage.domain.Storage;

public class StorageServiceImpl implements StorageService {
	
	@Autowired
	StorageDao storageDao;
	
	@Override
	public void addStorage(Storage storage) {
		storageDao.addStorage(storage);
	}
	
	@Override
	public List<Storage> getAllStorage() {
		return storageDao.getAllStorage();
	}
	
	@Override
	public List<Storage> getStorageByArtistId(String artistId) {
		return storageDao.getStorageByArtistId(artistId);
	}
	
	@Override
	public List<Storage> getStorageBySid(long sid) {
		return storageDao.getStorageBySid(sid);
	}
	
	@Override
	public void updateStorage(Storage storage, long sid) {
		storageDao.updateStorage(storage, sid);
	}
	
	@Override
	public void cancelStorage(long sid) {
		storageDao.cancelStorage(sid);
	}
}
