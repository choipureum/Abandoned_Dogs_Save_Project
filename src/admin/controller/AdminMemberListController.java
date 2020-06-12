package admin.controller;

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

import admin.service.face.AdminMemberListService;
import admin.service.impl.AdminMemberListServiceImpl;
import user.member.dto.MemberDTO;

@WebServlet("/admin/memberlist")
public class AdminMemberListController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	//서비스 객체생성
	private AdminMemberListService adminMemberListService = new AdminMemberListServiceImpl();
	 // 검색조건과 내용을 Map에 담는다.
    private HashMap<String, Object> listOpt = new HashMap<String, Object>();
    
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		listOpt.put("opt","0");	
		listOpt.put("condition","");
		listOpt.put("grade","5");
		//멤버 수 세기
		int membercnt=0;
		membercnt= adminMemberListService.memberCount(listOpt);
		List<MemberDTO> memberList = adminMemberListService.memberSelect(listOpt);
		
		for(MemberDTO m : memberList) {
			System.out.println("멤버");
			System.out.println(m);
		}
		req.setAttribute("list", memberList);	
		req.setAttribute("membercnt", membercnt);
		req.getRequestDispatcher("/WEB-INF/views/admin/AdminMemberListView.jsp").forward(req, resp);
	}
	//포스트
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		 
        // 검색조건과 검색내용을 가져온다.
        String opt = req.getParameter("opt");
        String condition = req.getParameter("condition");
        String grade=req.getParameter("grade");
     
        listOpt.put("opt", opt);
        listOpt.put("condition", condition);
        listOpt.put("grade",grade);
             
        int listCount = adminMemberListService.memberCount(listOpt);
        List<MemberDTO> list =  adminMemberListService.memberSelect(listOpt);
        
//        req.setAttribute("list", list);
        
//        //포워딩(맞나? 확인좀...)
//        req.getRequestDispatcher("/WEB-INF/views/admin/AdminMemberListView.jsp").forward(req, resp);
	}
}
