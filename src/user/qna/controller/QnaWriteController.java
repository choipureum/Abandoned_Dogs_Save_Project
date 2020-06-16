package user.qna.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import user.qna.dto.QNA;
import user.qna.service.face.QnaService;
import user.qna.service.impl.QnaServiceImpl;


@WebServlet("/qna/write")
public class QnaWriteController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	QnaService qnaService = new QnaServiceImpl();
   
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
				//로그인 되어있지 않으면 리다이렉트 
				//if( request.getSession().getAttribute("login") == null ) {
					
				//	response.sendRedirect("/");
					
				//	return;
				//}
				
				request.getRequestDispatcher("/WEB-INF/views/user/qna/write.jsp").forward(request, response);;
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
			
		
		
		
		QNA qna = qnaService.getParam(request);

		 
		 qnaService.join(qna);

		 
		 response.sendRedirect("/qna/list");
		//response.sendRedirect("/WEB-INF/views/user/qna/list");

		    

		 
		
		
	}

}
