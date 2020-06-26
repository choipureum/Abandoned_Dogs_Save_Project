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
 * Servlet implementation class MemberDeleteController
 */
@WebServlet("/member/delete")
public class MemberDeleteController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	MemberService memberService = new MemberServiceImpl();
	
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		String userid=req.getParameter("userid");
//		System.out.println(userid);
		
		//탈퇴하기
		memberService.memberDelete(userid);
		
	}

}
