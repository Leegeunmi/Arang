package com.arang.medici.board.cmd;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.arang.medici.board.dao.Bdao;
import com.arang.medici.board.dto.Bdto;

public class BViewCommand implements BCommand {
	
	public void execute(HttpServletRequest request, HttpServletResponse response){
		String bId = request.getParameter("bId");
		Bdao dao = new Bdao();
		Bdto dto = dao.view(bId);
		
		request.setAttribute("view", dto);
	}
}
