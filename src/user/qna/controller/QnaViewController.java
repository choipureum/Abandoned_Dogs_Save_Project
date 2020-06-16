package user.qna.controller;

import java.io.IOException;



import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import user.qna.dto.QNA;
import user.qna.dto.QnaFile;
import user.qna.service.face.QnaService;
import user.qna.service.impl.QnaServiceImpl;




@WebServlet("/qna/view")
public class QnaViewController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
  
	QnaService qnaService = new QnaServiceImpl();
	
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		
		//전달파라미터 얻기 - boardno //전달받은 bordno을 빈 board객체에 저장함 
		QNA qnano = qnaService.getqnano(request);
		
		//상세보기 결과 조회//파라마터 boardno에 해당하는 테이블의 hit값 증가시키고 파라미터로 넘어온 boardno에 대한 객체 얻어 옮
		QNA viewqna = qnaService.view(qnano);
		
		//-----------------------------------------------------
		
		//첨부파일 정보 VIEW에 전달//viewqna 객체에 해당하는 boardno의 파일 객체를 가져오기
		QnaFile qnaFile = qnaService.viewFile(viewqna);
		
		request.setAttribute("qnaFile", qnaFile);
				
		//조회결과 MODEL값 전달
		request.setAttribute("viewqna", viewqna);
				
		//VIEW 지정 및 응답 - forward
		request.getRequestDispatcher("/WEB-INF/views/user/qna/view.jsp").forward(request, response);	
		
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
	}

}