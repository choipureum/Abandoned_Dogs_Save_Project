package main;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import admin.dao.face.AdminMemberListDao;
import admin.dao.impl.AdminMemberListDaoImpl;
import user.dog.dto.Dog_Data;
import user.member.dto.MemberDTO;
import user.member.service.face.MemberService;
import user.member.service.impl.MemberServiceImpl;

@WebServlet("/main")
public class MainController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	//MemberService 객체 생성
	private MemberService memberService= new MemberServiceImpl();
	  
	// 어드민 Dao 적용
	private AdminMemberListDao adminMemberListDao = AdminMemberListDaoImpl.getInstance();
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.setCharacterEncoding("UTF-8");
		resp.setContentType("text/html;charset=UTF-8");		
		
		//bx 슬라이더 개 목록 보여주기
		List<Dog_Data> list = new ArrayList<>();
		list= adminMemberListDao.dogDataSelectAll();
		req.setAttribute("dogDataList", list);
			
		req.getRequestDispatcher("/WEB-INF/views/main.jsp").forward(req, resp);
	}
	
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
	
	
	
	
	}
}
	

