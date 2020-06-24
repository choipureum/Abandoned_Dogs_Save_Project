package admin.dao.face;
import java.util.*;
import java.util.Date;
import java.util.HashMap;
import java.util.List;

import admin.dao.impl.AdminMemberListDaoImpl;
import admin.dto.DogClaimDTO;
import user.dog.dto.DogDTO;
import user.dog.dto.Dog_File_DTO;
import user.member.dto.MemberDTO;
import util.Paging;
public interface AdminMemberListDao {
	
	/**
	 * 회원조회
	 * @param - HashMap<String,Object> opt
	 * 
	 * @return List<MemberDTO> - 회원정보 반환
	 */
	public List<MemberDTO> select(HashMap <String,Object> listOpt,Paging paging);
	
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
	public int delete(String userid);
	
	/**
	 * 유저 id 를 통한 멤버 전체 정보값 반환
	 * 
	 * @param - String userid
	 * @return - MemberDTO
	 */
	public MemberDTO selectID(String userid);
	
	/**
	 * 
	 * 회원 전체 조회
	 * @param - 없음
	 * @return - List<MemberDTO>
	 */
	public List<MemberDTO> selectAll();
	
	/**
	 * 회원 한달간 날짜 -15 , +15로 해쉬맵 반환
	 * @param - void;
	 * @return - TreeMap<Date,Integer>
	 */
	public TreeMap<Date,Integer> graphMember();
	
	/**
	 * 유저 아이디를 통한 등급 업데이트
	 * 
	 * @param id,grade
	 */
	public void updateGradeById(String id,String grade);
	
	/**
	 * dogNo 뽑기
	 * 
	 * @param 
	 */
	public int selectDogNo();
	
	/**
	 *  개 정보 삽입
	 * 
	 * @return - void
	 * @param - int Dogno
	 */
	 
	public void insertDog(DogDTO dog);
	
	
	/**
	 * 
	 * 개 파일 정보 삽입
	 * 
	 * @return - void
	 * @param - Dog_File_DTO
	 */
	 public void insertDogFile(Dog_File_DTO dogFile);	
	 
	 
	 
	 /**
	  * 개 입양신청 목록 조회
	  * @return List<DogClaimDTO> - 개 입양신청
	  */
	 public List<DogClaimDTO> dogClaimSelectAll(HashMap<String,Object> listOpt,Paging paging); 
	 
	 /**
	  * 입양신청 총 갯수 조회, 페이징에 사용
	  * 
	  * @return int - 총 신청 수 출력
	  */
	 public int dogClaimCount(HashMap<String,Object> listOpt);
	 
}		
