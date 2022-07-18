package com.arang.medici.signup.controller;

import java.io.IOException;
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
import com.arang.medici.signup.service.UserService;

@WebServlet("/signup/find_gallery.do")
public class FindGalleryServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	private GalleryService galleryService;
	
	public void init(ServletConfig config) throws ServletException {
	}
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		
		galleryService = GalleryService.getInstance();
		galleryService = new GalleryService(new GalleryDao());
		List<Gallery> galleryList = galleryService.findAllGallery();
		request.setAttribute("galleryList", galleryList);
		
		RequestDispatcher dispatcher = null;
		dispatcher = request.getRequestDispatcher("/signup/find_gallery.jsp");
		dispatcher.forward(request, response);
	}

}
