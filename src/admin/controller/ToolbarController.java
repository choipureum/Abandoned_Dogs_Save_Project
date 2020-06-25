package admin.controller;

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
import admin.dto.DogClaimDTO;
import admin.service.face.AdminMemberListService;
import admin.service.impl.AdminMemberListServiceImpl;
import util.Paging;

@WebServlet("/admin/toolbar")
public class ToolbarController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	//서비스 객체생성
	private AdminMemberListService adminMemberListService = new AdminMemberListServiceImpl();
	//다오 생성
	private AdminMemberListDao adminMemberListDao = AdminMemberListDaoImpl.getInstance();
	
	
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		//유기견 전체 수 세기
		int dogcnt = 0;
		dogcnt=adminMemberListDao.dogCount();
		//유기견 입양신청 수 세기
		int dog_claim =0;
		dog_claim= adminMemberListDao.dogClaimCount();
		
		//유기견 입양 신청 수(by dogno이 같으면 1)
		int dog_claimBydogno=0;
		dog_claimBydogno=adminMemberListDao.dogClaimBydognoCount();
		
		
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
		String sw="dogClaim";
		Paging paging = adminMemberListService.getPaging(req,listOpt,sw); //기본값
		
		//유기견 정보
		list = adminMemberListService.dogClaimSelectAll(listOpt, paging);
		
		req.setAttribute("dog_claimBydogno", dog_claimBydogno);
		req.setAttribute("dogcnt", dogcnt);
		req.setAttribute("dog_claim", dog_claim);
		req.setAttribute("doglist", list);
		req.getRequestDispatcher("/WEB-INF/views/admin/util/Toolbar.jsp").forward(req, resp);		
	}

}
