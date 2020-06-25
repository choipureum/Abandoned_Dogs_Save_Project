package admin.controller;

import java.io.IOException;
import java.util.ArrayList;
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

@WebServlet("/admin/dogClaimAccept")
public class dogClaimAcceptController extends HttpServlet {
	
	//서비스 객체생성
	private AdminMemberListService adminMemberListService = new AdminMemberListServiceImpl();
	//다오 생성
	private AdminMemberListDao adminMemberListDao = AdminMemberListDaoImpl.getInstance();
	
	private static final long serialVersionUID = 1L;
       
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		String useridArr=req.getParameter("userid");
		
		String []userid=useridArr.split(",");		
//		List<String> id = new ArrayList<>();
//		List<Integer> cnt = new ArrayList<>();
//		for(String e:userid) {
//			id.add(e);
//			//승인 처리
//			adminMemberListService.dogClaimAccept(e);
//			//승인 완료
//			int dogno = adminMemberListDao.dognoBydogClaim(e);
//			cnt.add(adminMemberListDao.dogClaimBydogno(dogno));
//		}
//		
//		
//		
//		
//		req.setAttribute("cnt", cnt);
//		req.setAttribute("userid", id);
//		req.setAttribute("idCount", id.size());
					
		//입양신청 허가 페이지 보이기
		req.getRequestDispatcher("/WEB-INF/views/admin/AdminDogClaimAccept.jsp").forward(req, resp);
	}


}
