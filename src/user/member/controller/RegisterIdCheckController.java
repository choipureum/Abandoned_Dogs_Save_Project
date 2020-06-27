package user.member.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import user.member.dao.impl.MemberDaoImpl;
import user.member.service.face.MemberService;
import user.member.service.impl.MemberServiceImpl;

/**
 * Servlet implementation class RegisterIdCheck
 */
@WebServlet("/id/check")
public class RegisterIdCheckController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	private MemberService memberService= new MemberServiceImpl();

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

//		인코딩
		req.setCharacterEncoding("UTF-8");
		resp.setContentType("text/html;charset=UTF-8");

		String userid=req.getParameter("userid");

		resp.getWriter().write(memberService.registerCheck(userid)+"");
	
	}
}
