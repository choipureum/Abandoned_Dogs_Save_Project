package user.member.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import user.member.dto.MemberDTO;


@WebServlet("/login/login")
public class LoginController extends HttpServlet {
   private static final long serialVersionUID = 1L;
   
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
      
      //멤버
      MemberDTO member = new MemberDTO();
      
      
      

      
      
   }
   
   
   
   

}