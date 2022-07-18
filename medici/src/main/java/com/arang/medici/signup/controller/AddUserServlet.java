package com.arang.medici.signup.controller;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.arang.medici.signup.dao.UserDao;
import com.arang.medici.signup.domain.User;
import com.arang.medici.signup.service.UserService;

@WebServlet("/signup/add_user_db.do")
public class AddUserServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	private UserService userService;
		
	public void init(ServletConfig config) throws ServletException {
		userService = new UserService(new UserDao());
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {		
		request.setCharacterEncoding("UTF-8");
		
		//1. 폼 파라미터 얻기
		String userId = request.getParameter("userId");
		String passwd = request.getParameter("passwd");
		String koreanName = request.getParameter("koreanName");
		String englishName = request.getParameter("englishName");
		String ssnYear = request.getParameter("ssnYear");
		String ssnMonth = request.getParameter("ssnMonth");
		String ssnDay = request.getParameter("ssnDay");
		String acaBackGround = request.getParameter("acaBackGround");
		String major = request.getParameter("major");
		String careerYear = request.getParameter("careerYear");
		String careerType = request.getParameter("careerType");
		String company = request.getParameter("company");
		String portpolio = request.getParameter("portpolio");
		String mainGenre = request.getParameter("mainGenre");
		String priceAvg = request.getParameter("priceAvg");
		String salesRate = request.getParameter("salesRate");
		String mainArtwork = request.getParameter("mainArtwork");
		String phoneNumber = request.getParameter("phoneNumber");
		String email = request.getParameter("email");
		String sns = request.getParameter("sns");
		
		//2. 유효성 검증 및 변환
		List<String> errorMsgs = new ArrayList<>();
		if(userId == null || userId.length() == 0) {
			errorMsgs.add("id는 필수입력 정보입니다.");
		}if(passwd == null || passwd.length() == 0) {
			errorMsgs.add("비밀번호는 필수입력 정보입니다.");
		}
		
		RequestDispatcher dispatcher = null;
		if(errorMsgs.size() > 0) {
			request.setAttribute("errorMsgs", errorMsgs);
			dispatcher = request.getRequestDispatcher("/signup/error.jsp");
			dispatcher.forward(request, response);
			return;
		}
		User user = new User();
		user.setUserId(userId);
		user.setPasswd(passwd);
		user.setKoreanName(koreanName);
		user.setEnglishName(englishName);
		user.setSsn(ssnYear + ssnMonth + ssnDay);
		user.setAcaBackGround(acaBackGround);
		user.setMajor(major);
		user.setCareerYear(careerYear);
		user.setCareerType(careerType);
		user.setCompany(company);
		user.setPortpolio(portpolio);
		user.setMainGenre(mainGenre);
		user.setPriceAvg(priceAvg);
		user.setSalesRate(salesRate);
		user.setMainArtwork(mainArtwork);
		user.setPhoneNumber(phoneNumber);
		user.setEmail(email);
		
		//3. 비즈니스 서비스 호출
		userService.addUser(user);
//		userService.findUser(user);
		request.setAttribute("user", user);
		
		//4. NextPage
		
		dispatcher = request.getRequestDispatcher("/signup/success.jsp");
		dispatcher.forward(request, response);	
	}
		
}
