package com.medici.arang.user.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.medici.arang.user.dao.GalleristDao;
import com.medici.arang.user.command.GalleristCommend;
import com.medici.arang.user.domain.GalleristVo;

public class GalleristServiceImpl implements GalleristService{
	
	@Autowired
	private GalleristDao galleristDao = new GalleristDao();
	
	@Override
	public void insertGallerist(GalleristCommend commend) {
		galleristDao.insertGallerist(commend);
	}

	@Override
	public boolean isValidUser(String email, String passwd) {
		return galleristDao.isValidUser(email, passwd);
	}
	@Override
	public GalleristCommend findMyGallerist(String email) {
		return galleristDao.findMyGallerist(email);
	}
	@Override
	public void updateGalleristByEmail(GalleristCommend gallerist) {
		galleristDao.updateGalleristByEmail(gallerist);
	}
}