package user.dog.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import user.dog.dto.DogDTO;
import user.dog.service.face.DogService;
import user.dog.service.impl.DogServiceImpl;

@WebServlet("/dog/list")
public class DogSearchListViewController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	
	//dogService객체 생성
			private DogService dogService = new DogServiceImpl();
		
		@Override
		protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
			
			
			List<DogDTO> dogList= dogService.list();
			
			
			
			
		}
	
	
}
