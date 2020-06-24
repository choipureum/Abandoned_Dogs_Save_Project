
package user.qna.controller;


import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import user.qna.service.face.QnaService;
import user.qna.service.impl.QnaServiceImpl;



@WebServlet("/qna/write")
public class QnaWriteController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	//BoardService 객체
	private QnaService boardService = new QnaServiceImpl();

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		//로그인 되어있지 않으면 리다이렉트 
		//if( req.getSession().getAttribute("login") == null ) {
		//	resp.sendRedirect("/main");
		//	return;
		//}
		
		//VIEW 지정
		req.getRequestDispatcher("/WEB-INF/views/user/qna/write.jsp")
			.forward(req, resp);
		
	}
	
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		
		
		
		
		//작성글 삽입//파일 삽입 
		boardService.write(req);
		
		//목록으로 리다이렉션
		resp.sendRedirect("/qna/list");
		
	}
	
}


