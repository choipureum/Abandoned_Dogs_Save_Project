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

@WebServlet("/mypage/grade")
public class MyPageGradeController extends HttpServlet {
   private static final long serialVersionUID = 1L;
   
   private MemberService memberService= new MemberServiceImpl();
   
   @Override
   protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

      String userid=(String) req.getSession().getAttribute("userid");
      
      MemberDTO member = new MemberDTO();
      member.setUserid(userid);
      
      member = memberService.getMemberInfo(member);

      req.setAttribute("member", member);
      
      req.getRequestDispatcher("/WEB-INF/views/user/member/myPageGrade.jsp").forward(req, resp);
      
   }
       
}