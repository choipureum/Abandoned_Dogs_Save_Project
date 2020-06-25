package admin.controller;
import util.Paging;
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


@WebServlet("/admin/dashboard")
public class AdminDashboard extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	//서비스 객체생성
	private AdminMemberListService adminMemberListService = new AdminMemberListServiceImpl();
	//다오 생성
	private AdminMemberListDao adminMemberListDao = AdminMemberListDaoImpl.getInstance();
	
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		 // 검색조건과 내용을 Map에 담는다.
		HashMap<String, Object> listOpt = new HashMap<String, Object>();
		 // 검색조건과 검색내용을 가져온다.
		if(req.getParameter("opt")!=null && req.getParameter("opt").equals("") ) {
			listOpt.put("opt", req.getParameter("opt"));
		}else {
			listOpt.put("opt","0");	
		}
		
		if(req.getParameter("condition")!=null &&req.getParameter("condition").equals("")) {
			listOpt.put("condition", req.getParameter("condition"));
		}else {
			listOpt.put("condition","");	
		}
		
		if(req.getParameter("grade")!=null && req.getParameter("grade").equals("")) {
			listOpt.put("grade", req.getParameter("grade"));	
		}else {
			listOpt.put("grade","0");
		}
		
		
		//멤버 수 세기
		int membercnt=0;
		membercnt= adminMemberListService.memberCount(listOpt);
		//그래프 멤버 리스트에 담기
		
		TreeMap<Date,Integer> graphMember=adminMemberListService.getGraphMember();
		List<Date>graphKey = new ArrayList<>();
		List<Integer>graphVal = new ArrayList<>();
		for(Date key:graphMember.keySet()) {
			graphKey.add(key);
			graphVal.add(graphMember.get(key));
		}
		//유기견 전체 수 세기
		int dogcnt = 0;
		dogcnt=adminMemberListDao.dogCount();
		//유기견 입양신청 수 세기
		int dog_claim =0;
		dog_claim= adminMemberListDao.dogClaimCount();
		//분실견 전체 수 세기
		int dog_missCnt =0;
		dog_missCnt = adminMemberListDao.dogMisscnt();
		//멤버 조회하기
		List<MemberDTO>memberAll = adminMemberListService.memberSelectAll();
		
		
		req.setAttribute("dogMissCnt", dog_missCnt);
		req.setAttribute("dogcnt", dogcnt);
		req.setAttribute("dog_claim", dog_claim);
		req.setAttribute("graphKey", graphKey);	
		req.setAttribute("graphVal", graphVal);		
		req.setAttribute("memberAll", memberAll);
		req.setAttribute("membercnt", membercnt);
		req.getRequestDispatcher("/WEB-INF/views/admin/AdminDashboard.jsp").forward(req, resp);
		
	}
	

}
