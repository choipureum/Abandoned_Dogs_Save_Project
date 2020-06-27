package user.member.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/logout/fail")
public class LogoutFail extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
////    swal
		req.setAttribute("icon", "warning");
		req.setAttribute("msg", "아이디또는 비밀번호를 확인해주세요!");
		req.setAttribute("title", " 로그인에 실패 했습니다");
		req.setAttribute("url", "/main");
    
    //view 전달
		req.getRequestDispatcher("/WEB-INF/views/user/member/swal.jsp")
			.forward(req, resp);
		
		
	}

}
