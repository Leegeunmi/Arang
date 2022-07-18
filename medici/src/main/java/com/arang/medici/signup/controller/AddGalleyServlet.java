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

import com.arang.medici.signup.dao.GalleryDao;
import com.arang.medici.signup.domain.Gallery;
import com.arang.medici.signup.service.GalleryService;

@WebServlet("/signup/add_gallery_db.do")
public class AddGalleyServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	private GalleryService galleryService;
		
	public void init(ServletConfig config) throws ServletException {
		galleryService = new GalleryService(new GalleryDao());
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {		
		request.setCharacterEncoding("UTF-8");
		
		//1. 폼 파라미터 얻기
		String galleryId = request.getParameter("galleryId");
		String passwd = request.getParameter("passwd");
		String galleryName = request.getParameter("galleryName");
		String galleryScale = request.getParameter("galleryScale");
		String galleryAddr = request.getParameter("galleryAddr");
		String galleryNumber = request.getParameter("galleryNumber");
		String galleryEmail = request.getParameter("galleryEmail");
		String galleryEmail2 = request.getParameter("galleryEmail2");
		String gallerySns = request.getParameter("gallerySns");
		
		//2. 유효성 검증 및 변환
		List<String> errorMsgs = new ArrayList<>();
		if(galleryId == null || galleryId.length() == 0) {
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
		
		Gallery gallery = new Gallery();
		gallery.setGalleryId(galleryId);
		gallery.setPasswd(passwd);
		gallery.setGalleryName(galleryName);
		gallery.setGalleryScale(galleryScale);
		gallery.setGalleryAddr(galleryAddr);
		gallery.setGalleryNumber(galleryNumber);
		gallery.setGalleryEmail(galleryEmail + "@" + galleryEmail2);
		gallery.setGallerySns(gallerySns);
		
		//3. 비즈니스 서비스 호출
		galleryService.addGalley(gallery);
//		galleryService.findGallery(gallery);
		request.setAttribute("gallery", gallery);
		
		//4. NextPage
		dispatcher = request.getRequestDispatcher("/signup/gallery_success.jsp");
		dispatcher.forward(request, response);	
	}
		
}
