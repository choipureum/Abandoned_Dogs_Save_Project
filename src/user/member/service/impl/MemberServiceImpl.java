package user.member.service.impl;

import java.io.UnsupportedEncodingException;

import javax.servlet.http.HttpServletRequest;

import user.member.dao.face.MemberDao;
import user.member.dao.impl.MemberDaoImpl;
import user.member.dto.MemberDTO;
import user.member.service.face.MemberService;

public class MemberServiceImpl implements MemberService{

   private MemberDao memberDao = new MemberDaoImpl();
   
   //getparam
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
   //멤버 다음 넘버 확인
   @Override
   public int insert(MemberDTO member) {

      //db 이용
      int next= memberDao.selectNextUserno();
      
      //시퀀스 값을 member 객체 에 대입
//      member.setUserno(next);
      
      //member 객체 db insert
   
      return memberDao.insert(member);
   }
   //로그인
   @Override
   public MemberDTO getLoginMember(HttpServletRequest req) {
	   
	 try {
		req.setCharacterEncoding("UTF-8");
	} catch (UnsupportedEncodingException e) {
		
		e.printStackTrace();
	}
	 MemberDTO member = new MemberDTO();
	 
	 member.setUserid(req.getParameter("userid"));
	 member.setUserpw(req.getParameter("userpw"));
	 
	 return member;

   }

   //로그인 성공 실패 확인
   @Override
   public boolean login(MemberDTO member) {

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

   //userid 확인 - 가입가능한지 안되는지 확인
   @Override
	public int registerCheck(String userid) {

	   return memberDao.registerCheck(userid);
   }

   //아이디 찾기 - username, useremail
   @Override
	public String findid(String username, String useremail) {
		
		return memberDao.findid(username,useremail);
	}

   // 유저이름과 아이디 이메일이 같은지 확인하는 작업
   //비밀번호 - 유저 정보 확인하고 있으면 비밀번호 재설정 / 없으면 alert 회원가입 페이지 로 
   
   @Override
   public int findpw(String username, String userid, String useremail) {
	  
	   return memberDao.findpw(username,userid,useremail);
	   
   }

   //유저 패스워드 update set useruid 같ㅇ느지 확인
   // 비밀번호 업데이트용ㄴ
   @Override
	public void changepassword(String userpw, String userid) {
		
		memberDao.changpassword(userpw, userid);
	
   }



}