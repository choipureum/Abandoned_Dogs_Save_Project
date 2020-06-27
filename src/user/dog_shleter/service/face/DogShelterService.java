package user.dog_shleter.service.face;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import user.dog.dto.Dog_Data;
import user.dog_shleter.dto.Dog_Shelter;
import util.Paging;

public interface DogShelterService {

	/**
	 * 유기견 보호소 조회
	 * 좌표값 lat, lon, sheltername 
	 * 
	 * @return List<Dog_Shelter> 
	 */
	public List<Dog_Shelter> list();
	
	/**
	 * 유기견 보호소 조회
	 * @param dogShelter - 조회 대상 sheleterno
	 * @return Dog_shelter 조회된 결과
	 */
	public Dog_Shelter detail(Dog_Shelter dogShelter);

	/**
	 * 유기견 조회
	 * @param dog - String shelterno
	 * @param paging - paginh
	 * @return - DogDTO
	 */
	public List<Dog_Data> dogDetail(Dog_Data dog, Paging paging);

	/**
	 * 페이징 생성
	 * 
	 * 요청정보를 활용하여 curPage를 구하고
	 * Dog테이블과 curPage 값을 이용한 Paging 객체를 생성하여 반환
	 * 	 
	 * @param req - curPage 정보를 담고 있는 요청정보 객체
	 * @return Panging - 페이징 계산이 완료된 결과 객체
	 */
	public Paging getPaging(HttpServletRequest req);


	

}
