package admin.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet("/admin")
public class AdminLogin extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.getRequestDispatcher("/WEB-INF/views/admin/AdminLogin.jsp").forward(req, resp);
	
	}

	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		req.setCharacterEncoding("UTF-8");
		resp.setContentType("text/html;charset=UTF-8");
		
		String userid=req.getParameter("userid");
		String userpw= req.getParameter("userpw");
		String json = "";
		int result=1;
		
		if(userid.equals("poo1994@hanmail.net")) {											
			if(userpw.equals("chl58004180")) {
				//세션 정보 저장하기
				HttpSession session = req.getSession();
				session.setAttribute("login", true);
				session.setAttribute("userid",userid);
				session.setAttribute("userpw", userpw);
				result=0;				
			}
			else {
				result=2;
			}
			
		}
		
		json = "{\"data\":\""+result+"\"}";
		resp.getWriter().write(json);
	}
	
}
