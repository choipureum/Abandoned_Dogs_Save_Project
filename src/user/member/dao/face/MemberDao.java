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
    * userid와 userpw 가 일치하는 회원의 수를 조회
    * @param member - 조회할 회원의 정보
    * @return int 1(존재하는 회원), 0 ( 존재하지 않는 회우너 ) -1 (에러)
    */
   
   public int selectCntMemberByUseridUserpw(MemberDTO member);

   /**
    * userid를 이용해 회원정보 조회
    * @param member - 조회할 회원
    * @return - 조회된 결과 객체
    */
   public MemberDTO selectMemberByUserid(MemberDTO member);


   /**
    *  userid를 통해서 회원 중복 확인
    * @param member
    * @return 1 ( 존재하는 회원, 0 존재하지 않는 회원 , -1 에러)
    */
   public int registerCheck(String userid);

   /**
    * username과 useremail를 통해서 userid 찾기
    * @param username
    * @param useremail
    * @return 1 있음 0없음 -1실패
    */
   public String findid(String username, String useremail);

   
   
}