package com.arang.medici.board.cmd;

import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.arang.medici.board.dao.Bdao;
import com.arang.medici.board.dto.Bdto;

public class BListCommand implements BCommand {
	public void execute(HttpServletRequest request, HttpServletResponse response)
			{
		Bdao dao = new Bdao();
		ArrayList<Bdto> dtos = dao.list();
		request.setAttribute("list", dtos);
	}
}
