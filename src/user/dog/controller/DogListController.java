package user.dog.controller;

import java.io.IOException;



import java.util.Iterator;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import user.dog.dto.Dog_Data;
import user.dog.dto.UserLike;
import user.dog.service.face.DogService;
import user.dog.service.impl.DogServiceImpl;
import util.Paging;
import java.util.*;

@WebServlet("/dog/list")
public class DogListController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	// dogService객체 생성
	private DogService dogService = new DogServiceImpl();

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		// 요청파라미터를 전달하여 Paging 객체 생성하기
		Paging paging = dogService.getPaging(req);
		req.setAttribute("paging", paging);

		req.setCharacterEncoding("utf-8");
		// VIEW 지정 및 응답 - forward
		req.getRequestDispatcher("/WEB-INF/views/user/dog/view.jsp").forward(req, resp);
	}

	
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		// 요청파라미터를 전달하여 Paging 객체 생성하기
		Paging paging = dogService.getPaging(req);		
			
		// Dog_Data 리스트 가져오기
//		Paging paging = dogService.getPaging(req);
		List<Dog_Data> dogList = dogService.getList(paging);

		for (Iterator iterator = dogList.iterator(); iterator.hasNext();) {
			Dog_Data dog_Data = (Dog_Data) iterator.next();
//				System.out.println("TEST  :  "+dog_Data);
		}


//		UserLike userlike = dogService.getUserLike(req);
		
//		// userlike의 유저 아이디가 null 아니라면 model 값 전달
//		if( req.getSession().getAttribute(userlike.getUserid()) != null  ) {
//			req.setAttribute("userid", userlike.getUserid());
//		}
		
//		System.out.println("userid : "+userlike.getUserid());
		
//		dogService.insertUserLike(req);
//		dogService.deleteUserLike(userlike);
		
//			//담아두기 정보 얻기
//			UserLike userlike = dogService.getUserLike(req);
//			
//			//담아두기 정보 토글
//			boolean result = dogService.UserLike(userlike);
//			System.out.println(userlike);
//			System.out.println(result);

		// 결과 JSon응답
//			resp.getWriter().println("{\"result\" :" + result);

//			//페이징계산결과 MODEL값 전달
		req.setAttribute("paging", paging);
//			
//			//조회결과 MODEL값 전달
		req.setAttribute("dogList", dogList);

		// VIEW 지정 및 응답 - forward
		req.getRequestDispatcher("/WEB-INF/views/user/dog/listview.jsp").forward(req, resp);

	}

}
