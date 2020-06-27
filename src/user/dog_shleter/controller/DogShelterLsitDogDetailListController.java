package user.dog_shleter.controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import user.dog.dto.Dog_Data;
import user.dog_shleter.service.face.DogShelterService;
import user.dog_shleter.service.impl.DogShelterServiceImpl;
import util.Paging;

/**
 * Servlet implementation class DogShelterLsitDogDetailListController
 */
@WebServlet("/dog/details")
public class DogShelterLsitDogDetailListController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	private DogShelterService dogShelterService = new DogShelterServiceImpl();

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		


		// 전달파라미터 shelterno 추출
		String param = req.getParameter("shelterno");

		// 요청파라미터를 전달하여 Paging 객체 생성하기
		Paging paging = dogShelterService.getPaging(req);

		// TEST
		System.out.println("param" + param);

		int shelterno = 0;
		if (param != null && !"".equals(param)) {
			shelterno = Integer.parseInt(param);
		}
		System.out.println("shelterno : " + shelterno);
		System.out.println("shelternoController" + shelterno);

		// 빈 DogShlter 객체 생성
		Dog_Data dog = new Dog_Data();
		dog.setShelterno(shelterno); // shelternno 저장
		// TEST
		System.out.println("Dog_Data : " + dog);

		// 유기견 상세조회
		List<Dog_Data> result = dogShelterService.dogDetail(dog, paging);

		//유기견 검색조회
//		List<Dog_Data> list = dogShelterService.dogSearch(paging, keyField, keyWord );
		
		for (Iterator iterator = result.iterator(); iterator.hasNext();) {
			dog = (Dog_Data) iterator.next();
			System.out.println(dog);
		}

		// TEST
		System.out.println("result : " + result);

		// 조회된 결과 값을 VIEW에 전달하기 - request 객체 사용
		req.setAttribute("result", result);

		
		// 페이징계산결과 MODEL값 전달
		req.setAttribute("paging", paging);
		
		// VIEW 지정 응답
		req.getRequestDispatcher("/WEB-INF/views/user/dogShelter/dogDetailView.jsp").forward(req, resp);

	}




}
