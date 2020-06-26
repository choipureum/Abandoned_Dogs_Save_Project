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
			req.setCharacterEncoding("UTF-8");
			resp.setContentType("text/html;charset=UTF-8");
		
			 int gradeSw =Integer.parseInt( req.getParameter("grade"));
			 String res = req.getParameter("grade");
			 String id = req.getParameter("id");
			 
			 String grade="";
			 //등급 한글로 변환
			 switch(gradeSw) {			
				 case 1:
					 grade="아이언";
					 break;
				 case 2:
					 grade="실버";
					 break;
				 case 3:
					 grade="골드";
					 break;
				 case 4:
					 grade="다이아";
				 
				 }				
			 adminMemberListService.UpdateGrade(id, grade);	
			 
			 resp.getWriter().write(res);
		}

	}
