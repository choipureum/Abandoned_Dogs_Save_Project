package admin.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import java.util.*;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import admin.dao.face.AdminMemberListDao;
import admin.dao.impl.AdminMemberListDaoImpl;
import admin.service.face.AdminMemberListService;
import admin.service.impl.AdminMemberListServiceImpl;
import user.member.dto.MemberDTO;
import util.JDBCTemplate;
@WebServlet("/admin/delete")
public class AdminMemberDeleteController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	//서비스 객체생성
		private AdminMemberListService adminMemberListService = new AdminMemberListServiceImpl();
	
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
//		 data:{member_chk : checkArr}		
		String[]arr=req.getParameterValues("member_chk[]"); 		
		for(String e: arr) {
			//유저 하나씩 삭제			
			String userid = e.trim().substring(0, e.length());	
			int res=adminMemberListService.memberDelete(userid);		

		}		
		resp.sendRedirect("/admin/memberlist");	
		
	}

}
