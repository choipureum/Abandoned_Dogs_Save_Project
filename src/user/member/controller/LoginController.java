package user.member.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import user.member.dto.MemberDTO;
import user.member.service.face.MemberService;
import user.member.service.impl.MemberServiceImpl;


@WebServlet("/login/login")
public class LoginController extends HttpServlet {
   private static final long serialVersionUID = 1L;

   //MemberService 객체 생성
   private MemberService memberService= new MemberServiceImpl();
  
   @Override
   protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

      //포워딩
      req.getRequestDispatcher("/WEB-INF/views/user/member/login.jsp")
         .forward(req, resp);
   }
   
   @Override
   protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

	  
	   //전달 파라미터 얻기 - 로그인 정보
	   MemberDTO member = memberService.getLoginMember(req);

	   //로그인 인증
	   boolean login = memberService.login(member);

	   if(login) {
		   //로그인 사용자 정보 얻기
		   member=memberService.info(member);
		   
		   //세션 정보 저장하기
		   HttpSession session = req.getSession();
		   
		   session.setAttribute("login", login);
		   session.setAttribute("userid", member.getUserid());
		   session.setAttribute("userpw", member.getUserpw());

		   resp.sendRedirect("/main");
	   } else {
		   
		   //로그인 실패
//		   req.getRequestDispatcher("/WEB-INF/views/main.jsp").forward(req, resp);
		   resp.sendRedirect("/logout/fail");
	   }
	   
//	   //메인 리다이렉트
//	   resp.sendRedirect("/main");
//	   req.getRequestDispatcher("/WEB-INF/views/main.jsp").forward(req, resp);
	
   }

}