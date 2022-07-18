package com.arang.medici.signup.controller;

import java.io.IOException;
import java.util.List;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.arang.medici.signup.dao.UserDao;
import com.arang.medici.signup.domain.User;
import com.arang.medici.signup.service.UserService;


@WebServlet("/signup/update_user.do")
public class UpdateUserServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	private UserService userservice;
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		
		String passwd = request.getParameter("passwd");
		String koreanName = request.getParameter("koreanName");
		String userId = request.getParameter("userId");
		
		UserService userService = UserService.getInstance();
		userService = new UserService(new UserDao());		
		User user = new User();
		user.setPasswd(passwd);
		user.setKoreanName(koreanName);
		user.setUserId(userId);
		
		userService.updateUser(user);
		request.setAttribute("user", user);
		
		RequestDispatcher dispatcher = null;
		dispatcher = request.getRequestDispatcher("/signup/update_user.jsp");
		dispatcher.forward(request, response);	
	}


}
