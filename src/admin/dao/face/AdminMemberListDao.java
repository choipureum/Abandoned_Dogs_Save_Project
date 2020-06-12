package admin.dao.face;

import java.util.HashMap;
import java.util.List;

import admin.dao.impl.AdminMemberListDaoImpl;
import user.member.dto.MemberDTO;

public interface AdminMemberListDao {
	
	/**
	 * 회원조회
	 * @param - HashMap<String,Object> opt
	 * 
	 * @return List<MemberDTO> - 회원정보 반환
	 */
	public List<MemberDTO> select(HashMap <String,Object> listOpt);
	
	/**
	 * 조건에 따른 회원 수 카운트
	 * 
	 * 페이징에 쓰기위함
	 * @param - HashMap<String,Object> opt
	 * 
	 * @return - List<MemberDTO> - 회원 수 정수값 반환
	 */
	public int getMemberCount(HashMap<String,Object> listOpt);
	
	/**
	 * 회원 삭제
	 * 
	 * @param MemberDTO - memberDTO.userId 를 통해서 삭제 대상 판단 파라미터
	 * @return - int(1,0) -> 삭제유무 판단 int
	 */
	public int delete(MemberDTO member);

	
}		
