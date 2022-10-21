package com.medici.arang.board.exhibitions.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.medici.arang.board.exhibitions.command.FindExhibitionsCommand;
import com.medici.arang.board.exhibitions.dao.ExhibitionDao;

public class ExhibitionServiceImpl implements ExhibitionService{
	
	@Autowired
	ExhibitionDao exhibitionDao;
	
	public List<FindExhibitionsCommand> findContactExgibitions() {
		return exhibitionDao.findContactExgibitions();
	}
}
