package user.qna.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import user.qna.dto.QNA;
import user.qna.service.face.QnaService;
import user.qna.service.impl.QnaServiceImpl;
;


@WebServlet("/qna/list")
public class QnaListController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    
		QnaService qnaService = new QnaServiceImpl();
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		//게시글 전체 조회
		List<QNA> qnaList = qnaService.getList();
	
		//List<Board> boardList = boardService.getList(paging);
		
		//조회결과 MODEL값 전달
		request.setAttribute("qnaList", qnaList);		
		
		request.getRequestDispatcher("/WEB-INF/views/user/qna/list.jsp").forward(request, response);
		
		
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	}

}
