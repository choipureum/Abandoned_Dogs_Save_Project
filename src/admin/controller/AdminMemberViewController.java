package admin.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import admin.service.face.AdminMemberListService;
import admin.service.impl.AdminMemberListServiceImpl;
import user.member.dto.MemberDTO;


@WebServlet("/admin/memberView")
public class AdminMemberViewController extends HttpServlet {
	private static final long serialVersionUID = 1L;       
	private AdminMemberListService adminMemberListService =new AdminMemberListServiceImpl();
	
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {		
		String userid=req.getParameter("userid");		
		MemberDTO member = adminMemberListService.selectById(userid);

		req.setAttribute("user", member);
		req.getRequestDispatcher("/WEB-INF/views/admin/AdminDetailView.jsp").forward(req, resp);
	}



}
