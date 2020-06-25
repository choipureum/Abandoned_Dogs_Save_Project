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



@WebServlet("/qna/delete")
public class QnaDeleteController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	//BoardService 객체
	private QnaService boardService = new QnaServiceImpl();

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		//전달받은  qnano을 전달해 qnano에 해당하는 빈객체를 반환  
		QNA board = boardService.getBoardno(req);
		
		
		//파일과 객체 삭제함 
		boardService.delete(board);
		
		//목록으로 리다이렉트
		resp.sendRedirect("/qna/list");
		
	}
}

