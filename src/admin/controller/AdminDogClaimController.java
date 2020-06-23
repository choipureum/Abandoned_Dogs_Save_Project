package admin.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.*;

import admin.dto.DogClaimDTO;
import admin.service.face.AdminMemberListService;
import admin.service.impl.AdminMemberListServiceImpl;
import util.Paging;
@WebServlet("/admin/dogClaim")
public class AdminDogClaimController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	private AdminMemberListService adminMemberListService =new AdminMemberListServiceImpl();
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
		List<DogClaimDTO> list = new ArrayList<>();
		
		//페이징 처리 하는 스위치
		String sw = "dogClaim";	
		//페이징
		Paging paging = adminMemberListService.getPaging(req,listOpt,sw); //기본값
		list = adminMemberListService.dogClaimSelectAll(listOpt, paging);
		
		req.setAttribute("paging", paging);
		req.setAttribute("dogClaimList", list);
		req.getRequestDispatcher("/WEB-INF/views/admin/AdminDogClaim.jsp").forward(req, resp);
	
	}

	

}
