package user.dog.dao.face;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import admin.dto.DogClaimDTO;
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
	public int selectCntAll();



//	public UserLike insertUserLike(HttpServletRequest req);




	
	public void insertUserLike(UserLike userlike);





	public void insertDogClaim(DogClaimDTO claim);



//	public void insertUserLike(DogDTO dog);





//	public void insertUserLike(UserLike userlike);





//	public void insertUserLike(HttpServletRequest req);
	
	
	
	
}
