package admin.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.jasper.tagplugins.jstl.core.Param;

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
@WebServlet("/admin/delete")
public class AdminMemberDeleteController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	//서비스 객체생성
		private AdminMemberListDao adminMemberListDao = AdminMemberListDaoImpl.getInstance();
	
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		System.out.println("딜리트 post 출력");
//		 data:{member_chk : checkArr}	
		String [] arr=null; //이거 어케 받지?
		System.out.println("딜리트 post 도착");
		
		for(String e: arr) {
			//유저 하나씩 삭제
			MemberDTO m = new MemberDTO();
			m.setUserid(e);
			adminMemberListDao.delete(m);
		}		
		//리 다이렉트
		resp.sendRedirect("/admin/memberlist");
	}

}
