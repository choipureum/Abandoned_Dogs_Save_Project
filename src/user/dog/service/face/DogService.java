package user.dog.service.face;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import user.dog.dto.DogDTO;
import user.dog.dto.Dog_Data;
import user.dog.dto.Dog_File_DTO;
import user.dog.dto.UserLike;
import util.Paging;

public interface DogService {

	/**
	 * 게시글 전체 조회
	 * 
	 * @return List<Board> - 게시글 전체 조회 결과 리스트
	 */
	public List<Dog_Data> getList(Paging paging);

	/**
	 * 페이징 객체 생성
	 * 
	 * 요청정보를 활용하여 curPage를 구하고
	 * Board 테이블과 curPage 값을 이용한 Paging 객체를 생성하여 반환한다
	 * 
	 * @param req - curPage정보를 담고 있는 요청정보 객체
	 * @return Paging - 페이징 계산이 완료된 결과 객체
	 */
	public Paging getPaging(HttpServletRequest req);

	

	/**
	 * dogno가져오기
	 * @param req
	 * @return
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
	 * @return
	 */
	public Dog_File_DTO viewFile(DogDTO detailDog);

	
	/**
	 * 입양신청 
	 *  버튼 클릭시 Userlike에 저장
	 * 
	 * @param req
	 */
	public void insertUserLike(HttpServletRequest req);

	public void insertDogClaim(HttpServletRequest req);
	
	
	/**
	 * 
	 */
	
	

}
