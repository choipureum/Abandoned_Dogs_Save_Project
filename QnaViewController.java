package user.qna.controller;

import java.io.IOException;


import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import user.qna.dto.QNA;

import user.qna.dto.QnaFile;
import user.qna.dto.Qna_Reply;
import user.qna.service.face.QnaService;
import user.qna.service.impl.QnaServiceImpl;



@WebServlet("/qna/view")
public class QnaViewController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	private QnaService boardService = new QnaServiceImpl(); 
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		//게시글 번호 파싱//게시글번호가 있는 빈 객체 생성 
		QNA viewBoard = boardService.getBoardno(req);
		
		//게시글 조회//qnano에 해당하는 객체 반환받음
		viewBoard = boardService.view(viewBoard);

		//MODEL로 게시글 전달
		req.setAttribute("viewBoard", viewBoard);
		
		//첨부파일 전달//파라미터 qnano이 있는 객체에 해당하는 파일 가져 옮
		QnaFile boardFile = boardService.viewFile(viewBoard);
		
		req.setAttribute("boardFile", boardFile);
		
		//------------------------------------------------------
		
		//게시글 답변 받기
		//게시글 번호 파싱
		int qnano = Integer.parseInt(req.getParameter("qnano"));
		
		//빈객체 생성
		Qna_Reply reply = new Qna_Reply();
		
		reply = boardService.Qna_ReplyDetail(qnano);
		
		req.setAttribute("reply", reply);
		
		//VIEW 지정
		req.getRequestDispatcher("/WEB-INF/views/user/qna/view.jsp")
		.forward(req, resp);
		
	}
}

