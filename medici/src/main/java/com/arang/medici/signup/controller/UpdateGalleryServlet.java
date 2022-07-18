package com.arang.medici.signup.controller;

import java.io.IOException;
import java.util.List;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.arang.medici.signup.dao.GalleryDao;
import com.arang.medici.signup.domain.Gallery;
import com.arang.medici.signup.service.GalleryService;


@WebServlet("/signup/update_gallery.do")
public class UpdateGalleryServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	private GalleryService galleryService;
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		
		String passwd = request.getParameter("passwd");
		String koreanName = request.getParameter("koreanName");
		String galleryId = request.getParameter("galleryId");
		
		galleryService = GalleryService.getInstance();
		galleryService = new GalleryService(new GalleryDao());		
		Gallery gallery = new Gallery();
		gallery.setPasswd(passwd);
		gallery.setGalleryName(koreanName);
		gallery.setGalleryId(galleryId);
		
		galleryService.updateGallery(gallery);
		request.setAttribute("gallery", gallery);
		
		RequestDispatcher dispatcher = null;
		dispatcher = request.getRequestDispatcher("/signup/update_gallery.jsp");
		dispatcher.forward(request, response);	
	}


}
