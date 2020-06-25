package user.member.service.face;

import javax.servlet.http.HttpServletRequest;

import user.member.dto.MemberDTO;

public interface MemberService {
   
   /**
    * 전달파라미터 추출(파싱)
    * @param req - 요청 정보 객체
    * @return Member - 전달파라미터를 다은 객ㄱ체
    */
   public MemberDTO getParam(HttpServletRequest req);

   /**
    * 회원가입 하는 부분
    * 
    * @param member - 회원정보 
    * @return - db
    */
   public int insert(MemberDTO member);

   /**
    *  로그인 정보 추출
    * @param req - 요청 정보 객체
    * @return MemberDTO - 로그인 정보
    */

   public MemberDTO getLoginMember(HttpServletRequest req);

   /**
    * 로그인 처리
    * @param member - 로그인 정보
    * @return true - 인증됨, false - 인증되지 않음
    */
   public boolean login(MemberDTO member);

   /**
    * 정보 가져오기
    * @param member - 회원 아이디를 가진 객체 
    * @return member - 조회된 회원 정보
    */
   public MemberDTO info(MemberDTO member);

   /**
    *  userid 중복체크
    * @param userid 
    * @return 1 성공  0 실패 -1 에러
    */
   public int registerCheck(String userid);

   /**
    * id 찾기 기능
    * @param username - 이름
    * @param useremail - 이메일 
    * @return string 맞으면 userid 
    */
   public String findid(String username, String useremail);

   /**
    * 비밀번호 체크 전에 이름 아이디 이메일 확인기능
    * @param username
    * @param userid
    * @param useremail
    * @return (int)로 할껀뎅..
    */
   public int findpw(String username, String userid, String useremail);

   /**
    * userpw set 용도 userid같은지 확인
    * @param userpw
    * @param userid
    */
   public void changepassword(String userpw, String userid);

   /**
    * 멤버의 모든 정보 회원 정보 수정할때 
    * @param member
    * @return member
    */

   public MemberDTO getMemberInfo(MemberDTO member);

   /**
    * userid를 이용한 업데이트
    * @param userid
 * @return 
    */
   public int modifyMypage(MemberDTO member);

   /**
    *  userid에 알맞은 회원을 탈퇴시킴
    * @param userid
    */
   public void memberDelete(String userid);


}




