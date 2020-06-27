package user.dog.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import admin.dto.DogClaimDTO;
import user.dog.dto.DogDTO;
import user.dog.dto.Dog_File_DTO;
import user.dog.dto.UserLike;
import user.dog.service.face.DogService;
import user.dog.service.impl.DogServiceImpl;

/**
 * Servlet implementation class DogDetailController
 */
@WebServlet("/dog/detailView")
public class DogDetailController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	//BoardService 객체 생성
		private DogService dogService = new DogServiceImpl();
		
		
		@Override
		protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

			//전달파라미터 얻기 - boardno
			DogDTO dogno = dogService.getDogno(req);

			//상세보기 결과 조회
			DogDTO detailDog = dogService.view(dogno);
			
			//파일 정보 VIEW에 전달
			Dog_File_DTO dogFile = dogService.viewFile(detailDog);
			
			
			System.out.println("detail : "+detailDog);
			System.out.println("detailFile" +dogFile);
			
			
			
			req.setAttribute("dogFile", dogFile);
			
			
			
			//조회결과 MODEL값 전달
			req.setAttribute("detailDog", detailDog);
			
			//VIEW 지정 및 응답 - forward
			req.getRequestDispatcher("/WEB-INF/views/user/dog/detailView.jsp").forward(req, resp);	
		
		}
		
		
		@Override
		protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
			
			
				// 값 넣어주기 , 도그 클레임 인서트 할려면 , 담아두기 여부 , 담아두기 안되어있으면 userlike 인서트 
			// userlike인서트 되어있으면 userlike의 adoptsw 1
			
			//전달파라미터 얻기 - dogno
			DogDTO dogno = dogService.getDogno(req);
			
			DogClaimDTO dogclaim = null;
			
			
			dogService.deleteDogClaim(dogclaim);
			
			
			
			
			
//			resp.sendRedirect("/dog/list");
			
		}
		
}
