package user.dog_miss.comtroller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import user.dog_miss.dto.Dog_MissDTO;
import user.dog_miss.service.face.DogMissService;
import user.dog_miss.service.impl.DogMissServiceImpl;

/**
 * Servlet implementation class DogMissInsertViewController
 */
@WebServlet("/dogmiss/insert")
public class DogMissInsertViewController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	private DogMissService dogMissService = new DogMissServiceImpl();
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
	
		req.getRequestDispatcher("/WEB-INF/views/user/dog_miss/DogMissInsertView.jsp")
			.forward(req, resp);
	
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
	
		req.setCharacterEncoding("UTF-8");
		
		Dog_MissDTO dog_MissDTO = new Dog_MissDTO();
		
		int res = dogMissService.insertDogMiss(dog_MissDTO);
		
		if(res > 0) {
			resp.sendRedirect("/dog_miss/DogMissList");
		} else {
			req.setAttribute("message", "입력실패");
		}
		
		
	
	}

}
