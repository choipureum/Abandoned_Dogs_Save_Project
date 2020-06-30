package user.member.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

<<<<<<< HEAD

=======
>>>>>>> branch 'master' of https://github.com/choipureum/-Abandoned_Dogs_Save_Project.git
import admin.dto.Dogout;

import user.member.service.face.MemberService;
import user.member.service.impl.MemberServiceImpl;

@WebServlet("/mypage/outdog")
public class MypageOutDogController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	private MemberService memberService= new MemberServiceImpl();
	
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		
		String userid=(String)req.getSession().getAttribute("userid");
		
		//아이디 잘 가져오나 확인~
		System.out.println(userid);
		Dogout dogout = memberService.myPageDogOut(userid);	
		System.out.println(dogout);

		req.setAttribute("dogout", dogout);
		//포워딩
		req.getRequestDispatcher("/WEB-INF/views/user/member/myPageOutDog.jsp").forward(req, resp);
	
	}
	

}
