package user.dog_shleter.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import user.dog.dto.Dog_Data;
import user.dog_shleter.service.face.DogShelterService;
import user.dog_shleter.service.impl.DogShelterServiceImpl;

/**
 * Servlet implementation class DogShelterLsitDogDetailListController
 */
@WebServlet("/dog/detail")
public class DogShelterLsitDogDetailListController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	private DogShelterService dogShelterService = new DogShelterServiceImpl();
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		//전달파라미터 shelterno 추출
		String param = req.getParameter("shelterno");
		
		//TEST
		System.out.println("param" + param);
		
		int shelterno = 0;
		if(param!=null && !"".equals(param)) {
			shelterno = Integer.parseInt(param);
		}
		System.out.println("shelterno : " + shelterno);
		
		//빈 DogShelter 객체 생성
		Dog_Data dogShelter= new Dog_Data();
		dogShelter.setShelterno(shelterno);//shelterno 저장
		
		System.out.println("shelternoController" + shelterno);
		
		//빈 DogShlter 객체 생성
		Dog_Data dog = new Dog_Data();
		dog.setShelterno(shelterno); //shelternno 저장
		
		//TEST
		System.out.println("Dog_Data : " + dog);
		
		
		//유기견 상세조회
		Dog_Data result = dogShelterService.dogDetail(dog);
		
		//TEST
		System.out.println("result : " + result);
		
		//조회된 결과 값을 VIEW에 전달하기 - request 객체 사용
		req.setAttribute("detail", result);
		
		//VIEW를 지정하고 응답하기(포워딩) - request객체 사용
		req.getRequestDispatcher("/WEB-INF/views/user/dogShelter/DogShelter_DogDetail.jsp")
		.forward(req, resp);
		
	
	}
	
	
}
