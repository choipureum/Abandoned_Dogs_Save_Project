package admin.controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import admin.dao.face.AdminMemberListDao;
import admin.dao.impl.AdminMemberListDaoImpl;
import admin.service.face.AdminMemberListService;
import admin.service.impl.AdminMemberListServiceImpl;
import user.dog.dto.DogDTO;
import user.dog.dto.Dog_Data;
import user.dog.dto.UserLike;
import user.member.dto.MemberDTO;


@WebServlet("/admin/memberView")
public class AdminMemberViewController extends HttpServlet {
	private static final long serialVersionUID = 1L;       
	private AdminMemberListService adminMemberListService =new AdminMemberListServiceImpl();
	private AdminMemberListDao adminMemberListDao = AdminMemberListDaoImpl.getInstance();
	
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {		
		String userid=req.getParameter("userid");		
		MemberDTO member = adminMemberListService.selectById(userid);

		
		//유저에 따른 dog데이터 정제
		List<UserLike> MyLikeDog = new ArrayList<>();
		List<UserLike> MyDog = new ArrayList<>();
		List<Dog_Data>MyLikeDogDTO = new ArrayList<>();
		List<Dog_Data>MyDogDTO = new ArrayList<>();
		
		
		MyLikeDog=adminMemberListDao.SelectById(userid);
		MyDog=adminMemberListDao.AdoptSelectById(userid);
		//담기( Dog Data)
		for(int i=0;i<MyLikeDog.size();i++) {			
			MyLikeDogDTO.add(adminMemberListDao.selectByDogno(MyLikeDog.get(i).getDogno()));
	
		}
		for(int i=0;i<MyDog.size();i++) {	
			MyDogDTO.add(adminMemberListDao.selectByDogno(MyDog.get(i).getDogno()));
		}
		
		
		req.setAttribute("MyDog",MyDogDTO );
		req.setAttribute("MyLikeDog",MyLikeDogDTO );
		req.setAttribute("user", member);

		req.getRequestDispatcher("/WEB-INF/views/admin/AdminDetailView.jsp").forward(req, resp);
	}



}
