package user.member.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import user.member.dto.MemberDTO;
import user.member.service.face.MemberService;
import user.member.service.impl.MemberServiceImpl;


@WebServlet("/mypage/modify")
public class MyPageModify extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	private MemberService memberService = new MemberServiceImpl();
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		//세션 정보 얻기 - login id
		String userid = (String) req.getSession().getAttribute("userid");
		
		MemberDTO member = new MemberDTO();
		member.setUserid(userid);
		
		//DB조회 - login id 이용
		member = memberService.getMemberInfo(member);
//		System.out.println(member);
		//request 컨텍스트 정보 추가 - DB 조회결과
		req.setAttribute("member", member);
		
		req.getRequestDispatcher("/WEB-INF/views/user/member/myPageModify.jsp").forward(req, resp);
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {


//      인코딩
		req.setCharacterEncoding("UTF-8");      

		
//      파라미터 저장 - service 이용
		MemberDTO member = memberService.getParam(req);
   
      
		String userid=req.getParameter("userid");
		
//		userid 확인
		System.out.println("modify userid" + userid);
		
		int res = memberService.modifyMypage(member);
		
		if(res>0) {
			req.setAttribute("res", res);
		} else {
			System.out.println("입력실패");
		}
		
	      //view 전달
	      req.getRequestDispatcher("/WEB-INF/views/user/member/myPageMain.jsp")
	         .forward(req, resp);
		
		
		
		
		
	}

}
