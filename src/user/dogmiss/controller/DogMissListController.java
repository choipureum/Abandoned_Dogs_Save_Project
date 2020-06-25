package user.dogmiss.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;



import user.dogmiss.dto.DogMiss;
import user.dogmiss.dto.DogMissAdd;
import user.dogmiss.service.face.DogMissService;
import user.dogmiss.service.impl.DogMissServiceImpl;

import util.Paging;



@WebServlet("/miss/list")
public class DogMissListController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
				DogMissService dogmissService = new DogMissServiceImpl();

	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
				Paging paging = dogmissService.getPaging(req);
				
				List<DogMissAdd> missList = dogmissService.getList(paging);
							
				req.setAttribute("paging", paging);
				req.setAttribute("missList", missList);				
				req.getRequestDispatcher("/WEB-INF/views/user/dogmiss/list.jsp").forward(req, resp);		
						
	}

	
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
	}

}