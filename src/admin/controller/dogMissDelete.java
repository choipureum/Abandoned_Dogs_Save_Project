package admin.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import admin.dao.face.AdminMemberListDao;
import admin.dao.impl.AdminMemberListDaoImpl;

/**
 * Servlet implementation class dogMissDelete
 */
@WebServlet("/admin/dogMissDelete")
public class dogMissDelete extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	private AdminMemberListDao adminMemberListDao = AdminMemberListDaoImpl.getInstance();
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
	
		String[]arr=req.getParameterValues("dogMiss_chk[]"); 	
		
		//Strint e = 아이디
		for(String e: arr) {			
			int dogMiss = Integer.parseInt(e);
			adminMemberListDao.dogMissFileDelete(dogMiss);
			adminMemberListDao.dogMissDelete(dogMiss);
		
		}	
	
	
	}

}
