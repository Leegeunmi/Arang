package com.arang.medici.storage.service;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.arang.medici.storage.dao.ArtworkDao;
import com.arang.medici.storage.domain.Artwork;

@WebServlet("/service/storage_service")
public class StorageServiceServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		
		ArtworkService artworkService = ArtworkService.getInstance();
		artworkService = new ArtworkService(new ArtworkDao());
		
		String artworkNum = request.getParameter("artworkNum");
		String storageAddr = request.getParameter("storageAddr");
		String startPeriod = request.getParameter("startPeriod");
		String endPeriod = request.getParameter("endPeriod");
		String deliveryService = request.getParameter("deliveryService");
		
		RequestDispatcher dispatcher = null;
		Artwork artwork = new Artwork();
		artwork.setArtworkNum(artworkNum);
		artwork.setStorage(storageAddr);
		artwork.setStartPeriod(startPeriod);
		artwork.setEndPeriod(endPeriod);
		artwork.setDbService(deliveryService);
		
		artworkService.addArtwork(artwork);
		request.setAttribute("artwork", artwork);
		
		dispatcher = request.getRequestDispatcher("/service/storage_sucess.jsp");
		dispatcher.forward(request, response);
	}

}
