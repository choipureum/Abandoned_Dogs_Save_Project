package user.dogmiss.controller;

import java.io.IOException;
import java.util.Iterator;
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
		
				//search와 search2 값을 가져오는 지 확인 - ok
				//System.out.println(request.getParameter("search"));//
				//System.out.println(Integer.parseInt(request.getParameter("search2")));
				
				
				//String search = request.getParameter("search");//내가 직접 검색한 값
				//int search2 = Integer.parseInt(request.getParameter("search2"));//value값 전달
				   
				
				
				
		
		
				//검색어 파라미터와 value값을  이용한  paging객체의 totalcount로 pagig객체 생성하여 반환 
				//paging객체 생성 //paging객체를 생성해야 한 페이지에 몇개의 게시글을 정할지 시작할 수 있다 
				Paging paging = dogmissService.getPaging(request);
				
				//게시글의 startnum과 endnum까지의 데이터를 file객체와 join을 한것을 가져옮
				List<DogMissAdd> missList = dogmissService.getList(paging);
				
				//paging 처리할 때 검색도 같이 해줘야 겠다 
				//List<DogMiss> list = dogMissService.select(search, search2);
				
				
				
				//paging객체와 파일 테이블을 조인하는 객체 불러오기 
				//List<DogMissAdd> joinList = dogmissService.joinList(missList);
				
				
				//System.out.println(paging);
				
				//Paging처리 결과 MODEL값 전달
				request.setAttribute("paging", paging);

				
				//강사님이 확인용으로 작성한 구문 
				//for (Iterator iterator = missList.iterator(); iterator.hasNext();) {
				//	DogMissAdd dogMissAdd = (DogMissAdd) iterator.next();
				//	System.out.println(dogMissAdd);
				//}
				//조회결과 MODEL값 전달
				
				
				request.setAttribute("missList", missList);
				
				//VIEW 지정 및 응답 - forward
				request.getRequestDispatcher("/WEB-INF/views/user/dogmiss/list.jsp").forward(request, response);		
				
		
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	}

}