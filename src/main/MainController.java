package main;

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

@WebServlet("/main")
public class MainController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	//MemberService 객체 생성
	  private MemberService memberService= new MemberServiceImpl();
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.setCharacterEncoding("UTF-8");
		resp.setContentType("text/html;charset=UTF-8");		
		req.getRequestDispatcher("/WEB-INF/views/main.jsp").forward(req, resp);
	}
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
	
	
	
	
	}
}
	

