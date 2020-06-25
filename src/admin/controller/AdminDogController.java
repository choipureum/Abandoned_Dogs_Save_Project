package admin.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.*;

import admin.dao.face.AdminMemberListDao;
import admin.dao.impl.AdminMemberListDaoImpl;
import admin.service.face.AdminMemberListService;
import admin.service.impl.AdminMemberListServiceImpl;
import user.dog.dto.Dog_Data;


@WebServlet("/admin/dog")
public class AdminDogController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	private AdminMemberListService adminMemberListService = new AdminMemberListServiceImpl();
	private AdminMemberListDao adminMemberListDao = AdminMemberListDaoImpl.getInstance();
	
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
				
		List<Dog_Data> list = new ArrayList<>();
		list= adminMemberListDao.dogDataSelectAll();
		
		
		
		req.setAttribute("dogDataList", list);
		req.getRequestDispatcher("/WEB-INF/views/admin/AdminDog.jsp").forward(req, resp);
	
	}

	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
	
	}

}














