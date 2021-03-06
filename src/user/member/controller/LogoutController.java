package user.member.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("/logout/logout")
public class LogoutController extends HttpServlet {
   private static final long serialVersionUID = 1L;
   
   @Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
	   
	   
	   //세션 정보 지우기 - 로그아웃
	   req.getSession().invalidate();
	   
	   //로그인 화면으로
	   //원래는 메인 화면으로 리다이렉트
	   
	   resp.sendRedirect("/main");
	}
   

}