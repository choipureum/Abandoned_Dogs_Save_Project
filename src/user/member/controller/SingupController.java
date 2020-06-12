package user.member.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import user.member.dao.face.MemberDao;
import user.member.dto.MemberDTO;
import user.member.service.face.MemberService;
import user.member.service.impl.MemberServiceImpl;

@WebServlet("/singup/singup")
public class SingupController extends HttpServlet {
   private static final long serialVersionUID = 1L;
   
   private MemberService memberService = new MemberServiceImpl();
   
   
   @Override
   protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
      
      System.out.println("g확인");
      req.getRequestDispatcher("/WEB-INF/views/user/member/singup.jsp")
         .forward(req, resp);
   
      
   }
   
   //아이디 체크 컨트롤러 필요 
   
   @Override
   protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
      //생성
      MemberDTO member=new MemberDTO();
//      인코딩
      req.setCharacterEncoding("UTF-8");
      
//      파라미터 저장 - service 이용
      MemberDTO memberDTO = memberService.getParam(req);
      
//      MemberDTO result= memberService.join(member);
      
      int result = memberService.insert(member);
      //결과반환
      
      
//      //결과 값 반환 확인
//      
//      if(result ==1 ) {
//         
//         req.setAttribute("result", result);
//         HttpSession session=req.getSession();
//         session.setAttribute("sessionID", "userId");
////         메인으로 이동
//         RequestDispatcher rd=req.getRequestDispatcher("/WEB-INF/views/user/member/main.jsp");
//         rd.forward(req, resp);
//      
//      } else {
//         req.setAttribute("result", 0);
//         RequestDispatcher rd= req.getRequestDispatcher("/WEB-INF/views/user/member/singup.jsp");
//         rd.forward(req, resp);
//      }


   }

}