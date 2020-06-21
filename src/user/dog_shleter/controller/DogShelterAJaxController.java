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
import user.dog_shleter.service.face.DogShelterService;
import user.dog_shleter.service.impl.DogShelterServiceImpl;

/**
 * Servlet implementation class DogShelterAJaxController
 */
@WebServlet("/dogshelter/view")
public class DogShelterAJaxController extends HttpServlet {
	private static final long serialVersionUID = 1L;
   
	private DogShelterService dogShelterService = new DogShelterServiceImpl();
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
	
		System.out.println("doget 연결");
		
		req.getRequestDispatcher("/WEB-INF/views/user/dogShelter/dog_ShelterResult.jsp")
			.forward(req, resp);
		
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

//		resp.setContentType("application/json; charset=utf-8");
//		
//		PrintWriter out = resp.getWriter();
//	
//		out.println( new Gson().toJson(shelterList));
		System.out.println("doPOST 성공");
		
		req.setCharacterEncoding("UTF-8");
		resp.setContentType("text/html;charset=UTF-8");
		
		String sheltername= req.getParameter("sheltername");
		System.out.println(sheltername);
		String shelteraddress = req.getParameter("shelteraddress");
		String sheltertel = req.getParameter("sheltertel");
		
		
		List<Dog_Shelter> result = dogShelterService.view(sheltername, shelteraddress, sheltertel);
		
		
		String json = "{\"data\":\""+result+"\"}";
		
		resp.getWriter().write(json);
		
		//test
		System.out.println("json" + json);
		
		System.out.println(result);
		

		
	}
	
	
}
