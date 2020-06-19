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
 * Servlet implementation class DogShelter
 */
@WebServlet("/dogshelter/list")
public class DogShelterListView extends HttpServlet {
	private static final long serialVersionUID = 1L;

	//Dog_Shelter 객체 생성
	private DogShelterService dogShelterService = new DogShelterServiceImpl();
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
	
		//접속 테스트
		System.out.println("DogShelter GET 성공");
		
		List<Dog_Shelter> shelterList = dogShelterService.list();
		
		for( Dog_Shelter D : shelterList) {
			System.out.println(D);
		}
		
		//조회 결과(MODEL 값)를 VIEW에 전달
		req.setAttribute("list", shelterList);
		
		// JSP를 VIEW로 지정하고 응답으로 사용하기 - 포워딩
		req.getRequestDispatcher("/WEB-INF/views/dogShelter/list.jsp")
			.forward(req, resp);
		

		
		
	}
	

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		List<Dog_Shelter> shelterList = new ArrayList<>();

		req.setAttribute("shelterList", shelterList);
		
		req.getRequestDispatcher("/WEB-INF/views/ajax/dog_ShelterResult.jsp")
			.forward(req, resp);
		
	
	}
}
