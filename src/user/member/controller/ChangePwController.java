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
 * Servlet implementation class ChangePwController
 */
@WebServlet("/change/pw")
public class ChangePwController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	   
    private MemberService memberService = new MemberServiceImpl();
	   
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String userid=req.getParameter("userid");
//		System.out.println(userid);
		req.getRequestDispatcher("/resources/js/changepassword.jsp").forward(req, resp);
	      
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

//		인코딩
		req.setCharacterEncoding("UTF-8");
		resp.setContentType("text/html;charset=UTF-8");
		
//		update 해줘야함 무엇을 ? userid만보고
		
		String userid = req.getParameter("userid");
		String userpw= req.getParameter("userpw");
		
		System.out.println("체인지" + userid);
		
		memberService.changepassword(userpw, userid);
		
		req.getRequestDispatcher("/WEB-INF/views/user/member/result.jsp").
					forward(req, resp);
		
		
	}

}
