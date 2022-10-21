package com.medici.arang.board.notice.service;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.medici.arang.board.notice.command.NoticeCommand;

@Service
public interface NoticeService {
	public long insertNotice(NoticeCommand command);
	public long updateNotice(NoticeCommand command, long num);
	public long deleteNotice(long num);
	public List<NoticeCommand> findAllNotice();
	public List<NoticeCommand> findOneNotice(long num);
	public long NoticeCount(long num);
	public List<NoticeCommand> paging(long num);
	public Page<NoticeCommand> findAll(Pageable pageable);
	public long getCount();
	public Page<NoticeCommand> findAllbyTitle(Pageable pageable, String title);
	public Page<NoticeCommand> findAllbyWriter(Pageable pageable, String writer);
	
}
