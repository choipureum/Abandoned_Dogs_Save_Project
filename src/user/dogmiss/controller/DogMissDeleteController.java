package user.dogmiss.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import user.dogmiss.dto.DogMiss;
import user.dogmiss.service.face.DogMissService;
import user.dogmiss.service.impl.DogMissServiceImpl;





@WebServlet("/miss/delete")
public class DogMissDeleteController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	DogMissService missService = new DogMissServiceImpl();

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		


		//missno을 빈 DogMiss객체에 넣어서 받아 옮 
		DogMiss	board = missService.getBoardno(request);
		
		
		
		//missno을 집어 넣은 빈객체의 missno에 해당하는DogMiss객체와 DogMissfile 객체  삭제 
		missService.delete(board);
		
		//목록으로 리다이렉트
		response.sendRedirect("/miss/list");

	

		
		
		
		
		
		
		
		
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	}

}
