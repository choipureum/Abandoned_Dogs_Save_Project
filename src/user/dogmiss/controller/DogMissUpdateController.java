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



@WebServlet("/miss/update")
public class DogMissUpdateController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	DogMissService missService = new DogMissServiceImpl();
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		//로그인한 사람의 글이 아니면 중단하고 목록으로 리다이렉트
				//if( !boardService.checkId(req) ) {
				//	resp.sendRedirect("/board/list");
				//	return;
				//}
				
				//게시글 번호 파싱//게시글 번호를 빈 객체 안에다가 넣어 놓기 
				DogMiss viewBoard = missService.getBoardno(request);
				
				//게시글 조회//missno에 해당하는 객체를 전달받음/missno에 해당하는 조회수 증가
				viewBoard = missService.view(viewBoard);

				//MODEL로 게시글 전달
				request.setAttribute("viewBoard", viewBoard);
				
				//여기서 boardno에 해당하는 파일객체를 먼저 삭제해야한다 
				
				
				//첨부파일 전달//missno에 해당하는 파일객체를 가져와 전달한다 //boardno은 fk이기 때문에 중복이 되어도 된다 
				 DogMissFile boardFile = missService.viewFile(viewBoard);
				
				//fileno이 가장큰 파일 객체를 가져와야 한다 
				DogMissFile boardF = missService.viewFM(boardFile);
				
				//boardF를 전달하자 
				request.setAttribute("boardF", boardF);
				
				//VIEW 지정
				request.getRequestDispatcher("/WEB-INF/views/user/dogmiss/update.jsp").forward(request, response);
				
		
		
		
		
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		//수정요청으로 받은 파라미터들을 update를 한다 
		missService.update(request);
		
		response.sendRedirect("/miss/list");
		
		
		
		
		
		
		
		
	}

}

