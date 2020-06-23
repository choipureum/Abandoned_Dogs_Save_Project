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

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
				//검색어(kind)파라미터를 이용한  paging객체의 totalcount로 pagig객체 생성하여 반환 
				//paging객체 생성 //paging객체를 생성해야 한 페이지에 몇개의 게시글을 정할지 시작할 수 있다 
				Paging paging = dogmissService.getPaging(request);
				
				//게시글의 startnum과 endnum까지의 데이터를 file객체와 join을 한것을 가져옮
				List<DogMissAdd> missList = dogmissService.getList(paging);
				
				//paging객체와 파일 테이블을 조인하는 객체 불러오기 
				//List<DogMissAdd> joinList = dogmissService.joinList(missList);
				
				
				
				
				//Paging처리 결과 MODEL값 전달
				request.setAttribute("paging", paging);

				//조회결과 MODEL값 전달
				request.setAttribute("missList", missList);
				
				//VIEW 지정 및 응답 - forward
				request.getRequestDispatcher("/WEB-INF/views/user/dogmiss/list.jsp").forward(request, response);		
				
		
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	}

}