package user.member.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.websocket.SendResult;

import user.member.service.face.MemberService;
import user.member.service.impl.MemberServiceImpl;


@WebServlet("/like/delete")
public class likeListDeleteController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
   

	MemberService memberService = new MemberServiceImpl();
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String names = request.getParameter("names");
		
		if( !"".equals(names) && names != null) {
			 
			memberService.memberListDelete(names);
			memberService.memberAddDelete(names);
			
			
		}
		
		response.sendRedirect("/like/list");

		
		
	}

}
