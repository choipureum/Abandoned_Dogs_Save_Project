package admin.service.face;

import java.util.HashMap;
import java.util.List;

import user.member.dto.MemberDTO;

public interface AdminMemberListService {
		
	/**
	 * 회원 조회
	 * DAO와 같은 기능
	 * @param listOpt
	 * @return List<MemberDTO>
	 */
	public List<MemberDTO> memberSelect(HashMap <String,Object> listOpt);
	
	
	/**
	 * 회원 삭제
	 * DAO와 같은기능
	 * @param member
	 * @return int - 정수값
	 */
	public int memberDelete(MemberDTO member);
	
	/**
	 * 회원수 카운트
	 * DAO와 같은기능
	 * @param listOpt
	 * @return int - 정수값
	 */
	public int memberCount(HashMap<String,Object> listOpt);
}
