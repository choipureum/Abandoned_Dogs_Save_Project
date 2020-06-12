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
    * @param member - 회원정보있고
    * @return - db
    */
   public int insert(MemberDTO member);

}