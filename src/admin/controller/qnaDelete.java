package admin.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import admin.dao.face.AdminMemberListDao;
import admin.dao.impl.AdminMemberListDaoImpl;
import admin.service.face.AdminMemberListService;
import admin.service.impl.AdminMemberListServiceImpl;

@WebServlet("/admin/qnaDelete")
public class qnaDelete extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	private AdminMemberListService adminMemberListService = new AdminMemberListServiceImpl();
	private AdminMemberListDao adminMemberListDao = AdminMemberListDaoImpl.getInstance();
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String[]arr=req.getParameterValues("list_chk[]"); 	
		
		//Strint e = 아이디
		for(String e: arr) {	
		
			int qnano = Integer.parseInt(e);
			adminMemberListDao.QnaDelete(qnano);
		}		
	}


}
