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



@WebServlet("/qna/view")
public class QnaViewController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
  
	QnaService qnaService = new QnaServiceImpl();
	
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		QNA qnano = qnaService.getqnano(request);
		
		QNA viewqna = qnaService.view(qnano);
		
		//조회결과 MODEL값 전달
		request.setAttribute("viewqna", viewqna);
				
				//VIEW 지정 및 응답 - forward
		request.getRequestDispatcher("/WEB-INF/views/user/qna/view.jsp").forward(request, response);	
		
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
	}

}
