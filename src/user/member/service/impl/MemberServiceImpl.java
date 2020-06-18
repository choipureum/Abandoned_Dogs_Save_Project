package user.member.service.impl;

import java.io.UnsupportedEncodingException;

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
     //주소 하나로 합치기
     StringBuffer address = new StringBuffer();
     address.append(req.getParameter("mem_oaddress")+" ");
     address.append(req.getParameter("mem_address")+" ");
     address.append(req.getParameter("mem_detailaddress"));
      //객체생성
      MemberDTO member = new MemberDTO();
      
      //userid, userpw, username, useremail, useraddress , usertel, userbirth , mem_oaddress, mem_address, mem_detailaddress
  
      member.setUserid(req.getParameter("userid"));
      member.setUserpw(req.getParameter("userpw"));
      member.setUsername(req.getParameter("username"));
      member.setUseremail(req.getParameter("useremail"));
      member.setUseraddress(address.toString());
      member.setUserbirth(birth.toString());
      member.setUsertel(req.getParameter("usertel"));
      
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



   @Override
   public MemberDTO getLoginMember(HttpServletRequest req) {
	   
	 try {
		req.setCharacterEncoding("UTF-8");
	} catch (UnsupportedEncodingException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	 MemberDTO member = new MemberDTO();
	 
	 member.setUserid(req.getParameter("userid"));
	 member.setUserpw(req.getParameter("userpw"));
	 
	 return member;
	 
	   
   }

   @Override
   public boolean login(MemberDTO member) {
	   // TODO Auto-generated method stub
	   if( memberDao.selectCntMemberByUseridUserpw(member) > 0 ) {
			return true; //로그인 성공
		} else {
			return false; //로그인 실패
		}
   }

   @Override
   public MemberDTO info(MemberDTO member) {
	   return memberDao.selectMemberByUserid(member);
   }

   @Override
	public int registerCheck(String userid) {
	   // TODO Auto-generated method stub
	   return memberDao.registerCheck(userid);
   }

@Override
	public String findid(String username, String useremail) {
		// TODO Auto-generated method stub
		return memberDao.findid(username,useremail);
	}

}