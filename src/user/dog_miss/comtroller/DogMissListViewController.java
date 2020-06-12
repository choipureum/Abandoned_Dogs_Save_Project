package user.dog_miss.comtroller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import user.dog_miss.dto.Dog_MissDTO;
import user.dog_miss.service.face.DogMissService;
import user.dog_miss.service.impl.DogMissServiceImpl;

/**
 * Servlet implementation class DogMissListViewController
 */
@WebServlet("/dogmiss/list")
public class DogMissListViewController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	private DogMissService dogMissService = new DogMissServiceImpl();
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
	
		List<Dog_MissDTO> list =  dogMissService.list();
		
		for( Dog_MissDTO d : list ) {
			System.out.println(d);
		}
		req.setAttribute("list", list);
		
		req.getRequestDispatcher("/WEB-INF/views/dog_miss/DogMissListView.jsp")
			.forward(req, resp);
	}
	
}
