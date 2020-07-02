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
import admin.dto.Dogout;
import admin.service.face.AdminMemberListService;
import admin.service.impl.AdminMemberListServiceImpl;
import user.dog.dto.DogDTO;
import user.dog.dto.Dog_Data;
import user.dog.dto.UserLike;
import user.member.dao.face.MemberDao;
import user.member.dao.impl.MemberDaoImpl;
import user.member.dto.MemberDTO;


@WebServlet("/admin/memberView")
public class AdminMemberViewController extends HttpServlet {
	private static final long serialVersionUID = 1L;       
	private AdminMemberListService adminMemberListService =new AdminMemberListServiceImpl();
	private AdminMemberListDao adminMemberListDao = AdminMemberListDaoImpl.getInstance();
	
	private MemberDao memberDao = new MemberDaoImpl();
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {		
		String userid=req.getParameter("userid");		
		MemberDTO member = adminMemberListService.selectById(userid);

		
		//유저에 따른 dog데이터 정제
		List<UserLike> MyLikeDog = new ArrayList<>();
		List<Dog_Data>MyLikeDogDTO = new ArrayList<>();
		
		
		
		MyLikeDog=adminMemberListDao.SelectById(userid);
		
		//담기( Dog Data)
		for(int i=0;i<MyLikeDog.size();i++) {			
			MyLikeDogDTO.add(adminMemberListDao.selectByDogno(MyLikeDog.get(i).getDogno()));
	
		}
		List<Dogout> list = new ArrayList<>();
		list = memberDao.SelectAllDogout(userid);
	
		int doglikeCnt = MyLikeDogDTO.size();
		int mydogCnt = list.size();
		
		req.setAttribute("cntLike", doglikeCnt);
		req.setAttribute("cntMine", mydogCnt);
			
		req.setAttribute("MyDog",list );
		req.setAttribute("MyLikeDog",MyLikeDogDTO );
		req.setAttribute("user", member);

		req.getRequestDispatcher("/WEB-INF/views/admin/AdminDetailView.jsp").forward(req, resp);
	}



}
