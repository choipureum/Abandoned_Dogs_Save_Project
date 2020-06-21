package user.dog_shleter.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import user.dog_shleter.dto.Dog_Shelter;
import user.dog_shleter.service.face.DogShelterService;
import user.dog_shleter.service.impl.DogShelterServiceImpl;

/**
 * Servlet implementation class DogShelterDetailList
 */
@WebServlet("/dogshelter/detail")
public class DogShelterDetailList extends HttpServlet {
	private static final long serialVersionUID = 1L;

	private DogShelterService dogShelterService = new DogShelterServiceImpl();
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
	
		//전달파라미터 eno 추출
		String param = req.getParameter("shelterno");
		int shelterno = 0;
		if(param!=null && !"".equals(param)) {
			shelterno = Integer.parseInt(param);
		}
		System.out.println("EmpDetailController - shelterno : " + shelterno);
				
		//빈 DogShelter 객체 생성
		Dog_Shelter dogShelter= new Dog_Shelter();
		dogShelter.setShelterno(shelterno);//shelterno 저장
				
		//유기견 보호소 정보 상세 조회
		Dog_Shelter result = dogShelterService.detail(dogShelter);
		System.out.println("DogShelterDetailController - result TEST : " + result);
				
				
				
		//조회결과(MODEL) 값을 VIEW에 전달하기 - request객체 사용
		req.setAttribute("res", result);
				
		//VIEW를 지정하고 응답하기(포워딩) - request객체 사용
		req.getRequestDispatcher("/WEB-INF/views/user/dogShelter/dog_ShelterDetail.jsp")
		.forward(req, resp);
			}
	
	}
	
	
	

