package user.dog_shleter.dao.face;

import java.util.ArrayList;
import java.util.List;

import user.dog.dto.DogDTO;
import user.dog.dto.Dog_Data;
import user.dog_shleter.dto.Dog_Shelter;
import util.Paging;

public interface DogShelterDao {


	/**
	 * 카카오 API 좌표값, 마커 조회
	 * 좌표값, 보호소 명
	 * @return
	 */
	public List<Dog_Shelter> selectAll();

	/**
	 * shelterno를 통한 유기견 보호소 정보 조회
	 * 
	 * @param dogShelter
	 * @return
	 */
	public Dog_Shelter selectBy(Dog_Shelter dogShelter);

	/**
	 * shelterno를 통한 유기견 전체 정보값 반환
	 * @param paging 
	 * @param - String dog
	 * @return - DogDTO
	 */
	public List<Dog_Data> dogDetailList(Dog_Data dog, Paging paging);

	/**
	 *  페이징
	 * @return
	 */
	public int selectCntAll();

}
