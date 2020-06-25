package admin.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import admin.dao.face.AdminMemberListDao;
import admin.dao.impl.AdminMemberListDaoImpl;
import user.dogmiss.service.face.DogMissService;
import user.dogmiss.service.impl.DogMissServiceImpl;


@WebServlet("/admin/dogDelete")
public class dogDelete extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	private DogMissService dogmissService = new DogMissServiceImpl();
	private AdminMemberListDao adminMemberListDao = AdminMemberListDaoImpl.getInstance();
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		String[]arr=req.getParameterValues("dog_chk[]"); 	
		
		//Strint e = 아이디
		for(String e: arr) {			
			int dogno = Integer.parseInt(e);
			adminMemberListDao.dogDelete(dogno);//유기견 삭제
			adminMemberListDao.dogFileDelete(dogno); // 유기견 파일 삭제
		}		
	}
		
		
		
	
	
	
}


