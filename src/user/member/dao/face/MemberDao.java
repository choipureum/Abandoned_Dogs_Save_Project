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

   
   
   
}