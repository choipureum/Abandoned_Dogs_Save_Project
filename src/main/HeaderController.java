package main;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import user.dog.dto.Dog_Data;
import user.dog.dto.UserLike;
import user.member.dao.face.MemberDao;
import user.member.dao.impl.MemberDaoImpl;


@WebServlet("/main/header")
public class HeaderController extends HttpServlet {
   private static final long serialVersionUID = 1L;
       
   private MemberDao memberDao= new MemberDaoImpl();
   protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
      
      HttpSession session = req.getSession();
      String userid = (String) session.getAttribute("userid");
      
      //id를 기준으로 유저라이크 받아오기
      List<UserLike> userlikeList = new ArrayList<>();
      userlikeList=memberDao.LikeSelectByid(userid);
      
      //동물 세부사항
      List <Dog_Data> dogList =new ArrayList<>();
      
      for(UserLike d:userlikeList) {
         Dog_Data dog = new Dog_Data();
         dog=memberDao.dogSelectBydogno(d.getDogno());
         dogList.add(dog);
      }   
      //id를 기준으로 유저라이크 동물 수세기
      int dogcnt = userlikeList.size();
       
      req.setAttribute("userlikeList", userlikeList);
      req.setAttribute("dog_List", dogList);
      req.setAttribute("dogcnt", dogcnt);
      req.getRequestDispatcher("/WEB-INF/views/user/util/header.jsp").forward(req, resp);
   }



}