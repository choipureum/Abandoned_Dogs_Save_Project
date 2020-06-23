package admin.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import admin.service.face.AdminMemberListService;
import admin.service.impl.AdminMemberListServiceImpl;

@WebServlet("/admin/dogInsert")
public class AdminDogInsert extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	private AdminMemberListService adminMemberListService = new AdminMemberListServiceImpl();   
	
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.getRequestDispatcher("/WEB-INF/views/admin/AdminDogInsert.jsp").forward(req, resp);
		
	}

	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		adminMemberListService.dogWrite(req);
		
		resp.sendRedirect("/admin/dogInsert");
	}

}
