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

      req.getRequestDispatcher("/WEB-INF/views/user/member/singup.jsp")
         .forward(req, resp);
   }

   @Override
   protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

//      인코딩
      req.setCharacterEncoding("UTF-8");      
//      파라미터 저장 - service 이용
      MemberDTO member = memberService.getParam(req);
   
      //데이터베이스 입력
      int res=memberService.insert(member);
      //결과반환
   
      if(res>0) {
         req.setAttribute("res", res);
      }else {
         System.out.println("입력실패");
      }
      //view 전달
      req.getRequestDispatcher("/WEB-INF/views/user/member/result.jsp")
         .forward(req, resp);

   }

}