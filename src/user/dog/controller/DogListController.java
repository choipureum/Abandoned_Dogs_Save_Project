package user.dog.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import user.dog.dao.face.DogDao;
import user.dog.dao.impl.DogDaoImpl;
import user.dog.dto.Dog_Data;
import user.dog.dto.UserLike;
import user.dog.service.face.DogService;
import user.dog.service.impl.DogServiceImpl;
import user.member.dao.face.MemberDao;
import user.member.dao.impl.MemberDaoImpl;
import util.Paging;
import java.util.*;

@WebServlet("/dog/list")
public class DogListController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	// dogService객체 생성
	private DogService dogService = new DogServiceImpl();
	private DogDao dogDao = new DogDaoImpl();
	private MemberDao memberDao = new MemberDaoImpl();
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		 HttpSession session = req.getSession();
		 String userid = (String) session.getAttribute("userid");
		 List<UserLike> userlikeList = new ArrayList<>();
	     userlikeList=memberDao.LikeSelectByid(userid);
	     req.setAttribute("dognoList", userlikeList); 
		 
		 
		 // 요청파라미터를 전달하여 Paging 객체 생성하기		
		Paging paging = dogService.getPaging(req);
		
		
		req.setAttribute("paging", paging);
		req.setCharacterEncoding("utf-8");
		// VIEW 지정 및 응답 - forward
		req.getRequestDispatcher("/WEB-INF/views/user/dog/view.jsp").forward(req, resp);
	}

	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		// 요청파라미터를 전달하여 Paging 객체 생성하기
			
		// Dog_Data 리스트 가져오기
		Paging paging = dogService.getPaging(req);
		List<Dog_Data> dogList = dogService.getList(paging);

		for (Iterator iterator = dogList.iterator(); iterator.hasNext();) {
			Dog_Data dog_Data = (Dog_Data) iterator.next();
//				System.out.println("TEST  :  "+dog_Data);
		}
		HttpSession session = req.getSession();
	    String userid = (String) session.getAttribute("userid");
	      
	     //id를 기준으로 유저라이크 받아오기
	    List<UserLike> userlikeList = new ArrayList<>();
	    userlikeList=memberDao.LikeSelectByid(userid);
	    req.setAttribute("userlike", userlikeList);

//			//페이징계산결과 MODEL값 전달
		req.setAttribute("paging", paging);
		req.setAttribute("userid", userid);
//			//조회결과 MODEL값 전달
		req.setAttribute("dogList", dogList);

		// VIEW 지정 및 응답 - forward
		req.getRequestDispatcher("/WEB-INF/views/user/dog/listview.jsp").forward(req, resp);

	}

}
