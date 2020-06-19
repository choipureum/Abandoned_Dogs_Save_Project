package user.dog_shleter.controller;


import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import user.dog_shleter.dto.Dog_Shelter;

/**
 * Servlet implementation class DogShelterAJaxController
 */
@WebServlet("/DogShelterAJaxController")
public class DogShelterAJaxController extends HttpServlet {
	private static final long serialVersionUID = 1L;
   
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
	
		req.getRequestDispatcher("/WEB-INF/views/dogShelter/list.jsp")
			.forward(req, resp);
		
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

//		resp.setContentType("application/json; charset=utf-8");
//		
//		PrintWriter out = resp.getWriter();
//	
//		out.println( new Gson().toJson(shelterList));
		
		List<Dog_Shelter> shelterList = new ArrayList<>();

		req.setAttribute("shelterList", shelterList);
		
		req.getRequestDispatcher("/WEB-INF/views/ajax/dog_ShelterResult.jsp")
			.forward(req, resp);
		
	}
	
	
}
