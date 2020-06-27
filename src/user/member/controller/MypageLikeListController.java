package user.member.controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import user.dog.dto.Dog_Data;
import user.dog.dto.UserLike;
import user.member.dao.face.MemberDao;
import user.member.dao.impl.MemberDaoImpl;
import user.member.dto.MemberAddDTO;
import user.member.service.face.MemberService;
import user.member.service.impl.MemberServiceImpl;
import util.Paging;


@WebServlet("/like/list")
public class MypageLikeListController extends HttpServlet {
		private static final long serialVersionUID = 1L;
		MemberService memberService = new MemberServiceImpl();

		MemberDao memberDao =  new MemberDaoImpl();
		protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

//				dog_data -> dog 데이터를 담을 리스트 //이거를 보내봤자 userlike 변수 값이 담겨있지가 않아요 !!
//				List<Dog_Data> dogList = new ArrayList<>();			 
//			 
			 
//			 List<UserLike>userlikeList = new ArrayList<>();
//			
//			 //userid를 기준으로 userlike가져옴
//			 userlikeList= memberDao.LikeSelectByid(userid);
//			 
//			 for(UserLike e: userlikeList) {
//				 int dogno = e.getDogno();				 
//				 //dogno에따라서 도그데이터 축적하기
//				 Dog_Data dog = new Dog_Data();
//				//dogno을 기준으로 dog_Data 반환 메소드
//				
//				 dog=memberDao.dogSelectBydogno(dogno);
//				 
//				 dogList.add(dog);
//			 }

		//1. 세션 값으로  로그인을 한 user의 id를 받아옴
		String userid="member04";
		
		
		//2.userid를 이용해서 paging객체 반환하기
		Paging paging = memberService.getPaging(request , userid);

		//찜목록
		//paging객체의 totalcount로 pagig객체 생성하여 반환 
		//Paging paging = memberService.getPaging(request);
		
		
		//paging객체를 전달하여  //starno과 endno에 맞는 객체를 가져옴 
		List<MemberAddDTO> list = memberService.getList(paging);
		
		
		request.setAttribute("list", list);

//		request.setAttribute("dogList", dogList);
//		request.setAttribute("userlikeList", userlikeList);

		request.getRequestDispatcher("/WEB-INF/views/user/member/likeList.jsp").forward(request, response);
	}


	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	
	}

}
