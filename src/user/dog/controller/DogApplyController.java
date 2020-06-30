package user.dog.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import user.dog.dao.face.DogDao;
import user.dog.dao.impl.DogDaoImpl;
import user.dog.dto.Dog_Data;
import user.member.dao.face.MemberDao;
import user.member.dao.impl.MemberDaoImpl;

@WebServlet("/dog/applyOK")
public class DogApplyController extends HttpServlet {
   private static final long serialVersionUID = 1L;
    private DogDao dogDao = new DogDaoImpl();
   private MemberDao memberDao = new MemberDaoImpl();
   protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
      
      String userid= req.getParameter("userid");
      int dogno = Integer.parseInt(req.getParameter("dogno"));
      
      //userlike - > applysw=1 로 업데이트
      dogDao.UserlikeSWUpdate(userid, dogno);
      //dogno을 기준으로 dog정보 객체 생성
      Dog_Data dog = new Dog_Data();
      dog= memberDao. dogSelectBydogno(dogno);
      //dogclaim에 insert
      dogDao.insertDogClaim(dog, userid);  
   }

}