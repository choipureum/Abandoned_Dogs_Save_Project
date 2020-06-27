package user.dog.service.face;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import admin.dto.DogClaimDTO;
import user.dog.dto.DogDTO;
import user.dog.dto.Dog_Data;
import user.dog.dto.Dog_File_DTO;
import user.dog.dto.UserLike;
import util.Paging;

public interface DogService {

	/**
	 * 게시글 전체 조회
	 * 
	 * @return List<Dog_Data> - 게시글 전체 조회 결과 리스트
	 */
	public List<Dog_Data> getList(Paging paging);

	/**
	 * 페이징 객체 생성
	 * 
	 * 요청정보를 활용하여 curPage를 구하고
	 * dog 테이블과 curPage 값을 이용한 Paging 객체를 생성하여 반환한다
	 * 
	 * @param req - curPage정보를 담고 있는 요청정보 객체
	 * @return Paging - 페이징 계산이 완료된 결과 객체
	 */
	public Paging getPaging(HttpServletRequest req);

	

	/**
	 * dogno가져오기
	 * @param req
	 * @return dogno
	 */
	public DogDTO getDogno(HttpServletRequest req);

	
	/**
	 * 상세보기 결과
	 * @param dogno
	 * @return
	 */
	public DogDTO view(DogDTO dogno);

	/**
	 * 파일정보
	 * @param viewBoard
	 * @return dog_file
	 */
	public Dog_File_DTO viewFile(DogDTO detailDog);

	
	/**
	 * 담아두기 
	 *  버튼 클릭시 Userlike에 저장
	 * 
	 * @param req
	 */
	public void insertUserLike(HttpServletRequest req);

	/**
	 * 입양신청
	 * @param req
	 */
	public void insertDogClaim(HttpServletRequest req);
	
	/**
	 * 담아두기 취소
	 * @param userlike
	 */
	public void deleteUserLike(UserLike userlike);
	
	public void deleteDogClaim(DogClaimDTO dogclaim);
	
	
	/**
	 * 담아두기 상태 조회
	 * @param userlike
	 * @return
	 */
	public boolean isUserLike(UserLike userlike);
	
	/**
	 * 담아두기 정보 파라미터 얻ㄱ
	 * @param req - 요청 정보 객체
	 * @return userlike - 담아두기 정보 객체
	 */
	
	public UserLike getUserLike(HttpServletRequest req);
	
	
	public boolean UserLike(UserLike userlike);
	

}
