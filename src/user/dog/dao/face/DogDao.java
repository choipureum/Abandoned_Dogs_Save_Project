package user.dog.dao.face;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import admin.dto.DogClaimDTO;
import admin.dto.Dogout;
import user.dog.dto.DogDTO;
import user.dog.dto.Dog_Data;
import user.dog.dto.Dog_File_DTO;
import user.dog.dto.UserLike;
import util.Paging;

public interface DogDao {

	/**
	 * 게시글 전체 조회
	 * @param paging
	 * @return Dog_Data
	 */
	public List<Dog_Data> selectAll(Paging paging);

	


	/**
	 * 유기견번호 선택
	 * @return
	 */
	public int selectDogno();

	/**
	 * 
	 * @param dogno
	 * @return
	 */
	public DogDTO selectDogByDogno(DogDTO dogno);

	/**
	 * 
	 * @param detailDog
	 * @return
	 */
	public Dog_File_DTO selectFile(DogDTO detailDog);

	/**
	 * 
	 * @return
	 */
	//public int selectCntAll();
	public int selectCntAll(String search, int search2);


//	public UserLike insertUserLike(HttpServletRequest req);




	/**
	 * userlike 정보 삽입
	 * @param userlike
	 */
	public void insertUserLike(UserLike userlike);




	/**
	 * dogclaim에 
	 * @param claim
	 */
	public void insertDogClaim(DogClaimDTO claim);




	public void deleteUserLike(UserLike userlike);




	public void deleteDogClaim(DogClaimDTO dogclaim);




	public int selectCntUserLike(UserLike userlike);




	public UserLike selectUserLike(HttpServletRequest req);






	/**
	 * 유기견 마이페이지 담아두기
	 * @param userLike
	 * @return
	 */
	public List<UserLike> selectUserList(UserLike userLike);

	 public void UserlikeSWUpdate(String userid, int dogno);


	public void insertDogClaim(Dog_Data claim, String userid);
	/**
	 * 유저아이디랑 dogno을 기준으로 userlike 찾기
	 * 
	 * @param userid
	 * @param dogno
	 * @return
	 */
	public int userlikeChk(String userid, int dogno);	
	/**
	 * 
	 * userlike에 넣으면서 신청하기
	 * 
	 * 
	 * @param userid
	 * @param dogno
	 */
	public void insertUserlikeApply(String userid, int dogno);
	
	/**
	 * 입양신청이 진행됫는지 체크하기
	 * 
	 * @param userid
	 * @param dogno
	 * @return
	 */
	public int chkUseridApply(String userid, int dogno);
	
	
	
}
