package user.dogmiss.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import user.dogmiss.dto.DogMiss;
import user.dogmiss.service.face.DogMissService;
import user.dogmiss.service.impl.DogMissServiceImpl;



@WebServlet("/miss/write")
public class DogMissWriteController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
   
  

	
	DogMissService dogMissService = new DogMissServiceImpl();
	
	
		protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		
		
		
		
		request.getRequestDispatcher("/WEB-INF/views/user/dogmiss/write.jsp").forward(request, response);
		
		}
		
	
		
		
		
		protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
			
			//작성글 삽입
			dogMissService.write(request);
			
			
	
			//-------------------------------------
	
			//QNA qna = qnaService.getParam(request);

	 
	 		//qnaService.join(qna);

			
			response.sendRedirect("/miss/list");
			//response.sendRedirect("/WEB-INF/views/user/qna/list");

		
		
	}

}
