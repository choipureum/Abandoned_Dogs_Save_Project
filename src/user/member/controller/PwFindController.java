package user.member.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import user.member.service.face.MemberService;
import user.member.service.impl.MemberServiceImpl;

/**
 * Servlet implementation class PwFindController
 */
@WebServlet("/pw/find")
public class PwFindController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	//서비스 객체 생성
	private MemberService memberService= new MemberServiceImpl();
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

	      req.getRequestDispatcher("/WEB-INF/views/user/member/pwfind.jsp")
	         .forward(req, resp);
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		req.setCharacterEncoding("UTF-8");
		resp.setContentType("text/html;charset=UTF-8");
		
		String username=req.getParameter("username");
		String useremail= req.getParameter("useremail");
		String userid=req.getParameter("userid");


		//패스워드 찾기
		//select username userid useremail
	
		int result = memberService.findpw(userid, useremail, username);
		
		String json = "{\"data\":\""+result+"\"}";

		resp.getWriter().write(json);
	
	}

}
