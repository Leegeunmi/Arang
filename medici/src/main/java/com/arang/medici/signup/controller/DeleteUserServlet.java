package com.arang.medici.signup.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.arang.medici.signup.dao.UserDao;
import com.arang.medici.signup.domain.User;
import com.arang.medici.signup.service.UserService;

@WebServlet("/signup/delete_user.do")
public class DeleteUserServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	private UserService userservice;
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		
		String userId = request.getParameter("userId");
		
		UserService userService = UserService.getInstance();
		userService = new UserService(new UserDao());		
		User user = new User();
		user.setUserId(userId);
		System.out.println(user.getUserId());
		
		userService.deleteUserByUserId(user);
		request.setAttribute("user", user);
		
		RequestDispatcher dispatcher = null;
		dispatcher = request.getRequestDispatcher("/signup/delete_gallery.jsp");
		dispatcher.forward(request, response);	
	}

}
