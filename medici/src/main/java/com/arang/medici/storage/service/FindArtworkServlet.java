package com.arang.medici.storage.service;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.arang.medici.storage.dao.ArtworkDao;
import com.arang.medici.storage.domain.Artwork;

@WebServlet("/service/find_artwork")
public class FindArtworkServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		
		ArtworkService artworkService = ArtworkService.getInstance();
		artworkService = new ArtworkService(new ArtworkDao());
		List<Artwork> artworkList = artworkService.findArtwork();
		request.setAttribute("artworkList", artworkList);
		
		RequestDispatcher dispatcher = null;
		dispatcher = request.getRequestDispatcher("find_artwork.jsp");
		dispatcher.forward(request, response);
	}

}
