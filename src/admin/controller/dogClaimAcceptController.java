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
import user.dog.dto.Dog_Data;

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
		List<String> id = new ArrayList<>();
		int cnt=0;
		for(String e:userid) {
			id.add(e);
			
			int dogno = adminMemberListDao.dognoBydogClaim(e);
			//승인 처리
			adminMemberListService.dogClaimAccept(e);
			//승인 완료
			//입양신청 dogno같은 유저 라이크 모조리 apply sw=2
			adminMemberListDao.dogClaimUpdateApplySw(e, dogno);	
					
			cnt+=adminMemberListDao.dogClaimBydogno(dogno);			
		}
		
		
		req.setAttribute("dogClaimCnt", cnt);
		req.setAttribute("userid", id);
		req.setAttribute("idCount", id.size());
					
		//입양신청 허가 페이지 보이기
		req.getRequestDispatcher("/WEB-INF/views/admin/AdminDogClaimAccept.jsp").forward(req, resp);
	}


}
