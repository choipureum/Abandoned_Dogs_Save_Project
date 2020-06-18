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
 * Servlet implementation class EmailCheckController
 */
@WebServlet("/email/check")
public class EmailCheckController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	//서비스객체 생성
	private MemberService memberService= new MemberServiceImpl();
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
//		인코딩
		req.setCharacterEncoding("UTF-8");
		resp.setContentType("text/html;charset=UTF-8");
		
		//이메일
		String useremail=req.getParameter("useremail");
		
		System.out.println(useremail);
		//인증숫자 코드 4자리 수  - 1000-9999
		int random=(int)(Math.random()*9999+1000);
		
		resp.getWriter().write(random);
		System.out.println(random);

		
		
		
		
	}

}
