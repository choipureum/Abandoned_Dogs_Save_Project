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
 * Servlet implementation class IdFindController
 */
@WebServlet("/id/find")
public class IdFindController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	//서비스 객체 생성
	private MemberService memberService= new MemberServiceImpl();
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

	      req.getRequestDispatcher("/WEB-INF/views/user/member/idfind.jsp")
	         .forward(req, resp);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

//		인코딩
		req.setCharacterEncoding("UTF-8");
		resp.setContentType("text/html;charset=UTF-8");
		
		
		String username = req.getParameter("username");
		String useremail = req.getParameter("useremail");
		
		System.out.println(username);
		System.out.println(useremail);
		String result = memberService.findid(username,useremail);
		
		String json = "{\"data\":\""+result+"\"}";
		
		System.out.println(json);
		resp.getWriter().write(json);

//		String[] userinfo = req.getParameterValues("userinfo[]");
//		
//		
//		for(String p : userinfo) {
//			String user =p.trim();
//			//확인
////			System.out.println(user);
//		}
//	
//		System.out.println(userinfo[0].trim()+"");
//		System.out.println(userinfo[1].trim());
//		System.out.println(memberService.findid(userinfo[0].trim()+"",userinfo[1].trim())+"");
//		
//		String json = "{";
//		json += "";
				
//		resp.getWriter().write();
//		
//		System.out.println(username+useremail);
	}
}
