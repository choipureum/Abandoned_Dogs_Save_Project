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
      
      //객체생성
      MemberDTO member = new MemberDTO();
      
      //userid, userpw, username, useremail, useraddress
      member.setUserid(req.getParameter("userid"));
      member.setUserpw(req.getParameter("userpw"));
      member.setUsername(req.getParameter("username"));
      member.setUseremail(req.getParameter("useremail"));
      member.setUseraddress(req.getParameter("useraddress"));

      return member;
      
   }


   @Override
   public int insert(MemberDTO member) {
      // TODO Auto-generated method stub
      return 0;
   }

}