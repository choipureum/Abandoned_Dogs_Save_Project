package admin.service.face;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.TreeMap;

import javax.servlet.http.HttpServletRequest;

import admin.dto.DogClaimDTO;
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
	 * @return Paging,String sw - 페이징 계산이 완료된 객체, total카운트 다르게 받기위한 스위치
	 */
	public Paging getPaging(HttpServletRequest req, HashMap<String, Object> listOpt,String sw);
	
	/**
	 * 그래프 멤버 30일 변화 반환 그래프
	 * @param - null
	 * @return - HashMap<Date,Integer>
	 */
	public TreeMap<Date,Integer> getGraphMember();
	
	/**
	 * 회원 아이디를 통한 유저 전체 정보 반환
	 * 
	 * @param - String userid
	 * @return - MemberDTO
	 */
	public MemberDTO selectById(String userid);
	/**
	 * 유저 등급 변화
	 * @param id,grade
	 * @return - void
	 */
	public void UpdateGrade(String id,String grade) ;
		
	/**
	 * dogInsert 에 사용할
	 * 파일 포함 객체 읽어들이기
	 * 
	 * @param req
	 */
	public void dogWrite(HttpServletRequest req);
	
	/**
	 * 입양신청 목록 보이기 
	 * 
	 * @return - DogClaimDTO 개 입양신청 DTO 반환
	 * @param
	 */
	 public List<DogClaimDTO> dogClaimSelectAll(HashMap<String, Object> listOpt, Paging paging);
	 
	 /**
	  * 유저 아이디를 통해서
	  * 입양신청 삭제 -> userLike 항목 값 1->0으로 치환 두가지 기능
	  * 
	  * @param userid
	  */	 
	 public void dogClaimDelete(String userid);
	 
	 
	 
	 //입양신청 허가
	 /**
	  * 입양신청 허가에 따른 메소드 실행
	  *  	1. 해당 유기견과 같은(동일한) 입양신청 모두삭제
	  * 	2. dog 정보  userlike adaptSW 1로 Update작업
	  * 	3. dog 정보 삭제하기 (dog 유기견 정보 삭제)
	  * 
	  * @param userid
	  * @param dogno
	  */
	 public void dogClaimAccept(String userid);
	 
	 
	 
}






