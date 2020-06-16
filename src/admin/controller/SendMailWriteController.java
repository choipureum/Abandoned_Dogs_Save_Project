package admin.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import admin.service.face.AdminMemberListService;
import admin.service.impl.AdminMemberListServiceImpl;

//메일 입력창 보여주는 창
@WebServlet("/admin/mailwrite")
public class SendMailWriteController extends HttpServlet {
	private static final long serialVersionUID = 1L;
    private AdminMemberListService adminMemberListService = new AdminMemberListServiceImpl();
    
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {		
		int result=0;
		String[]arr=req.getParameterValues("member_mail[]"); 
		String id="";
		for(String e: arr) {
			//유저 메일보내기		
			id=	e.trim().substring(0, e.length()-1);					
		}		
		
		req.setAttribute("id", id);
		req.getRequestDispatcher("/resources/js/AdminMailForm.jsp").forward(req, resp);
		
	}


}
