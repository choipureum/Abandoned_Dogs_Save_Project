package admin.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import admin.dao.face.AdminMemberListDao;
import admin.dao.impl.AdminMemberListDaoImpl;
import user.dogmiss.dto.DogMissAdd;
import user.dogmiss.service.face.DogMissService;
import user.dogmiss.service.impl.DogMissServiceImpl;
import util.Paging;


@WebServlet("/admin/dogmiss")
public class AdminDogMissController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private DogMissService dogmissService = new DogMissServiceImpl();
	private AdminMemberListDao adminMemberListDao = AdminMemberListDaoImpl.getInstance();
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
				
		List<DogMissAdd> missList = adminMemberListDao.dogmissSelectAll();
				
	
		
		req.setAttribute("missList", missList);					
		req.getRequestDispatcher("/WEB-INF/views/admin/AdminDogMiss.jsp").forward(req, resp);
	
	}

	
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
	}

}
