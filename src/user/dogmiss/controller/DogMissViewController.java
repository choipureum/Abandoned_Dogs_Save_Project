package user.dogmiss.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import user.dogmiss.dto.DogMiss;
import user.dogmiss.dto.DogMissFile;
import user.dogmiss.service.face.DogMissService;
import user.dogmiss.service.impl.DogMissServiceImpl;


@WebServlet("/miss/view")
public class DogMissViewController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	DogMissService missService = new DogMissServiceImpl();
   

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
				//전달파라미터 얻기 - missno //전달받은 miossno을 빈 missno객체에 저장함 //객체지향 ㅠ
				DogMiss missno = missService.getmissno(request);
				
				//상세보기 결과 조회//파라마터 boardno에 해당하는 테이블의 hit값 증가시키고 파라미터로 넘어온 boardno에 대한 객체 얻어 옮
				DogMiss view = missService.view(missno);		
				//-----------------------------------------------------
				
				//첨부파일 정보 VIEW에 전달//view 객체에 해당하는 missno의 파일 객체를 가져오기
				DogMissFile missFile = missService.viewFile(view);
				
				
				
				
				
				
				request.setAttribute("missFile", missFile);
						
				//조회결과 MODEL값 전달
				request.setAttribute("view", view);
						
				
				
				
				request.getRequestDispatcher("/WEB-INF/views/user/dogmiss/view.jsp").forward(request, response);	
		
		
		
		
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	}

}