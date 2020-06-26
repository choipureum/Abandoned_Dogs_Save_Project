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
		
		List<DogClaimDTO>list = new ArrayList<>();
		//유기견 정보
		list = adminMemberListService.dogClaimSelectAll();
			
		req.setAttribute("dogClaimList", list);
		req.getRequestDispatcher("/WEB-INF/views/admin/AdminDogClaim.jsp").forward(req, resp);
	
	}

	

}
