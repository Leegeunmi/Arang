package com.arang.medici.storage.service;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.arang.medici.storage.dao.ArtworkDao;
import com.arang.medici.storage.domain.Wallet;

@WebServlet("/service/payment")
public class PaymentServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		
		String userId = request.getParameter("userId");
		Double inputBalance = Double.parseDouble(request.getParameter("inputBalance"));
		
		Wallet wallet = new Wallet();
		wallet.setUserId(userId);
		wallet.setBalance(inputBalance);
		
		ArtworkService artworkService = ArtworkService.getInstance();
		artworkService = new ArtworkService(new ArtworkDao());
		wallet = artworkService.payment(wallet);
		request.setAttribute("wallet", wallet);
		
		RequestDispatcher dispatcher = null;
		dispatcher = request.getRequestDispatcher("/service/payment_sucess.jsp");
		dispatcher.forward(request, response);	
	}

}
