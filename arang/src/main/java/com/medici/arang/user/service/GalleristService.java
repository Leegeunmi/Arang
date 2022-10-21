package com.medici.arang.user.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.medici.arang.user.command.GalleristCommend;
import com.medici.arang.user.domain.GalleristVo;

@Service
public interface GalleristService {
	public void insertGallerist(GalleristCommend commend);
	public boolean isValidUser(String email, String passwd);
	GalleristCommend findMyGallerist(String email);
	void updateGalleristByEmail(GalleristCommend gallerist);
}
