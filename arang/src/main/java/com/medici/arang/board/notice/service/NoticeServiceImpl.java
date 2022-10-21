package com.medici.arang.board.notice.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.medici.arang.board.notice.command.NoticeCommand;
import com.medici.arang.board.notice.dao.NoticeDao;

public class NoticeServiceImpl implements NoticeService{
	
	@Autowired
	NoticeDao dao;
	
	@Override
	public long insertNotice(NoticeCommand command) {
		return dao.insertNotice(command);
	}

	@Override
	public long updateNotice(NoticeCommand command, long num) {
		return dao.updateNotice(command, num);
	}

	@Override
	public long deleteNotice(long num) {
		return dao.deleteNotice(num);
	}

	@Override
	public List<NoticeCommand> findAllNotice() {
		return dao.findAllNotice();
	}

	@Override
	public List<NoticeCommand> findOneNotice(long num) {
		return dao.findOneNotice(num);
	}

	@Override
	public long NoticeCount(long num) {
		return dao.NoticeCount(num);
	}

	@Override
	public long getCount() {
		return dao.getCount();
	}

	@Override
	public Page<NoticeCommand> findAll(Pageable pageable) {
		return dao.findAll(pageable);
	}

	@Override
	public List<NoticeCommand> paging(long num) {
		return paging(num);
	}

	@Override
	public Page<NoticeCommand> findAllbyTitle(Pageable pageable, String title) {
		return dao.findAllbyTitle(pageable, title);
	}

	@Override
	public Page<NoticeCommand> findAllbyWriter(Pageable pageable, String writer) {
		return dao.findAllbyWriter(pageable, writer);
	}

}
