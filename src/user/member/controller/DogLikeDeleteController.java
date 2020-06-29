package user.member.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import user.member.dao.face.MemberDao;
import user.member.dao.impl.MemberDaoImpl;
@WebServlet("/dog/doglikeDelete")

public class DogLikeDeleteController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	private MemberDao memberDao = new MemberDaoImpl();	
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
	
		String userid =req.getParameter("userid");
		int dogno = Integer.parseInt(req.getParameter("dogno"));		
		memberDao.DeleteUserlike(userid, dogno);	

	}

}
