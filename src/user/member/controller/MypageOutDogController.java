package user.member.controller;
import java.util.*;
import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


import admin.dto.Dogout;
import user.member.dao.face.MemberDao;
import user.member.dao.impl.MemberDaoImpl;
import user.member.service.face.MemberService;
import user.member.service.impl.MemberServiceImpl;

@WebServlet("/mypage/outdog")
public class MypageOutDogController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	private MemberService memberService= new MemberServiceImpl();
	private MemberDao memberDao = new MemberDaoImpl();
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		
		String userid=(String)req.getSession().getAttribute("userid");
		
		//아이디 잘 가져오나 확인~
		List<Dogout> list = new ArrayList<>();
		list = memberDao.SelectAllDogout(userid);

		
		req.setAttribute("dogout", list);
		//포워딩
		req.getRequestDispatcher("/WEB-INF/views/user/member/myPageOutDog.jsp").forward(req, resp);
	
	}
	

}
