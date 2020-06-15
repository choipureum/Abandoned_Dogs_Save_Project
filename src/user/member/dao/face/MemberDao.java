package user.member.dao.face;

import user.member.dto.MemberDTO;

public interface MemberDao {

   /**
    * member_seq 이용해서 userno  조회
    * @return member_seq.nextval();
    * 
    */
   public int selectNextUserno();

   /**
    * insert회원가입
    * 
    * @param member - userid, userpw, username, useremamil, useraddress
    */
   public int insert(MemberDTO member);

   
   
   /**
    *  로그인 정보
    * @param userid - 로그인 아이디
    * @param userpw - ㅎ로그인 비밀번호
    * @return
    */
   
   public int login(String userid, String userpw);

   
   
   
}