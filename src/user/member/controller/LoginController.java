package user.member.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import user.member.service.face.MemberService;
import user.member.service.impl.MemberServiceImpl;


@WebServlet("/login/login")
public class LoginController extends HttpServlet {
   private static final long serialVersionUID = 1L;

   //MemberService 객체 생성
   private MemberService memberService= new MemberServiceImpl();

   
   @Override
   protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
      
      
      //접속 테스트
//      System.out.println("접속테스트입니다 아ㅏ아ㅏㅏ");
      
      //포워딩
      req.getRequestDispatcher("/WEB-INF/views/user/member/login.jsp")
         .forward(req, resp);

   }
   
   @Override
   protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
      
	   //인코딩
	   req.setCharacterEncoding("UTF-8");
	   
	   //id/ pw 가져오기
	   String userid = req.getParameter("userid");
	   String userpw = req.getParameter("userpw");

	   
	   //if 문
	   if(memberService.login(userid,userpw)) {
		   
		   
	   }

	   

      

      
      
   }
   
   
   
   

}