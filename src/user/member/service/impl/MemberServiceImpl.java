package user.member.service.impl;

import javax.servlet.http.HttpServletRequest;

import user.member.dao.face.MemberDao;
import user.member.dao.impl.MemberDaoImpl;
import user.member.dto.MemberDTO;
import user.member.service.face.MemberService;

public class MemberServiceImpl implements MemberService{

   private MemberDao memberDao = new MemberDaoImpl();
   
   @Override
   public MemberDTO getParam(HttpServletRequest req) {
      //생년월일 스트링버퍼 사용해서 넣을 수 있는 값으로 변경해주기
     StringBuffer birth = new StringBuffer();
     birth.append(req.getParameter("userbirth_yy"));
     birth.append(req.getParameter("userbirth_mm"));
     birth.append(req.getParameter("userbirth_dd"));
   
      //객체생성
      MemberDTO member = new MemberDTO();
      
      //userid, userpw, username, useremail, useraddress , usertel, userbirth
      member.setUserid(req.getParameter("userid"));
      member.setUserpw(req.getParameter("userpw"));
      member.setUsername(req.getParameter("username"));
      member.setUseremail(req.getParameter("useremail"));
      member.setUseraddress(req.getParameter("useraddress"));
      member.setUserbirth(birth.toString());
      member.setUsertel(Integer.parseInt(req.getParameter("usertel")));
      
      return member;
      
   }


   @Override
   public int insert(MemberDTO member) {
      // TODO Auto-generated method stub
      
      //db 이용
      int next= memberDao.selectNextUserno();
      
      //시퀀스 값을 member 객체 에 대입
//      member.setUserno(next);
      
      //member 객체 db insert
   
      return memberDao.insert(member);
   }

}