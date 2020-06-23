package admin.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import admin.service.face.AdminMemberListService;
import admin.service.impl.AdminMemberListServiceImpl;

@WebServlet("/admin/updateGrade")
public class AdminUpdateGradeController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	//서비스 객체생성
	private AdminMemberListService adminMemberListService = new AdminMemberListServiceImpl();   
	
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
			 String grade = req.getParameter("grade");
			 String id = req.getParameter("id");
			 adminMemberListService.UpdateGrade(id, grade);	
			 
			 resp.getWriter().write(grade);
		}

	}
