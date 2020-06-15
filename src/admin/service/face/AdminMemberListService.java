package admin.service.face;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.TreeMap;

import javax.servlet.http.HttpServletRequest;

import user.member.dto.MemberDTO;
import util.Paging;
public interface AdminMemberListService {
		
	/**
	 * 회원 조회
	 * DAO와 같은 기능
	 * @param listOpt
	 * @return List<MemberDTO>
	 */
	public List<MemberDTO> memberSelect(HashMap <String,Object> listOpt,Paging paging);
	
	
	/**
	 * 회원 삭제
	 * DAO와 같은기능
	 * @param member
	 * @return int - 정수값
	 */
	public int memberDelete(String userid);
	
	/**
	 * 회원수 카운트
	 * DAO와 같은기능
	 * @param listOpt
	 * @return int - 정수값
	 */
	public int memberCount(HashMap<String,Object> listOpt);
	
	/**
	 * 회원  전체 조회
	 * @return - List<MemberDTO>
	 * @param
	 */
	public List<MemberDTO> memberSelectAll();
	
	/**
	 * 페이징 객체 생성
	 * 
	 * @param req - 요청 정보 객체
	 * @return Paging - 페이징 계산이 완료된 객체
	 */
	public Paging getPaging(HttpServletRequest req, HashMap<String, Object> listOpt);
	
	/**
	 * 그래프 멤버 30일 변화 반환 그래프
	 * @param - null
	 * @return - HashMap<Date,Integer>
	 */
	public TreeMap<Date,Integer> getGraphMember();
	
	
	
	
}
