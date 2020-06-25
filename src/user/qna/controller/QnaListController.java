package user.qna.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import user.qna.service.face.QnaService;
import user.qna.service.impl.QnaServiceImpl;
import util.Paging;


@WebServlet("/qna/list")
public class QnaListController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	private QnaService boardService = new QnaServiceImpl(); 
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		//검색어(title)파라미터를 이용한  paging객체의 totalcount로 pagig객체 생성하여 반환 
		Paging paging = boardService.getPaging(req);
		
		
		
		req.setAttribute("paging", paging);
		
		
		
		
		//paging객체를 전달받아 시작과 끝을 정하고 검색어로 조건문을 주어 객체를 리스트로 전달 받음 
		List list = boardService.getList(paging);
				
		//게시글 목록을 MODEL값으로 지정
		req.setAttribute("list", list);
		
		
		
		
		//VIEW 지정
		req.getRequestDispatcher("/WEB-INF/views/user/qna/list.jsp")
			.forward(req, resp);
		
	}
}

