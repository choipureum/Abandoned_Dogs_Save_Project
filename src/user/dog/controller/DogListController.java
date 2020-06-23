package user.dog.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import user.dog.dto.Dog_Data;
import user.dog.service.face.DogService;
import user.dog.service.impl.DogServiceImpl;
import util.Paging;

@WebServlet("/dog/list")
public class DogListController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	
	//dogService객체 생성
	private DogService dogService = new DogServiceImpl();
		
		@Override
		protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
			
			
			//요청파라미터를 전달하여 Paging 객체 생성하기
			Paging paging = dogService.getPaging(req);
//			System.out.println("BoardListController - " + paging);
//			
			System.out.println("get");
//			
//			//게시글 전체 조회
////			List<Board> boardList = boardService.getList();
//			
//			게시글 페이징 처리 조회
			List<Dog_Data> dogList = dogService.getList(paging);
//			
//			
//			//페이징계산결과 MODEL값 전달
			req.setAttribute("paging", paging);
//			
//			//조회결과 MODEL값 전달
			req.setAttribute("dogList", dogList);
			
			
			
			//VIEW 지정 및 응답 - forward
			req.getRequestDispatcher("/WEB-INF/views/user/dog/view.jsp").forward(req, resp);		
			
			
			
		}
	
	
}
