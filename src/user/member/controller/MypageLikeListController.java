package user.member.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import user.member.dto.MemberAddDTO;
import user.member.service.face.MemberService;
import user.member.service.impl.MemberServiceImpl;
import util.Paging;


@WebServlet("/like/list")
public class MypageLikeListController extends HttpServlet {
	private static final long serialVersionUID = 1L;
   
		MemberService memberService = new MemberServiceImpl();
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		//paging객체의 totalcount로 pagig객체 생성하여 반환 
		Paging paging = memberService.getPaging(request);
		
		
		//paging객체를 전달하여  //starno과 endno에 맞는 객체를 가져옴 
		List<MemberAddDTO> list = memberService.getList(paging);
		
		
		request.setAttribute("list", list);
		

		request.getRequestDispatcher("/WEB-INF/views/user/member/likeList.jsp").forward(request, response);
	}


	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	
	}

}
