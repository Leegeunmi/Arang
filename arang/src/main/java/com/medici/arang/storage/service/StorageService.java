package com.medici.arang.storage.service;

import java.util.List;

import com.medici.arang.storage.domain.Storage;

public interface StorageService {
	
	public void addStorage(Storage storage);
	List<Storage> getAllStorage();
	List<Storage> getStorageByArtistId(String artistId);
	List<Storage> getStorageBySid(long sid);
	public void updateStorage(Storage storage, long sid);
	public void cancelStorage(long sid);
}
