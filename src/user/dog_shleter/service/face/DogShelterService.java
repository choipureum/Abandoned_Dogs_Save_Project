package user.dog_shleter.service.face;

import java.util.List;

import user.dog.dto.DogDTO;
import user.dog.dto.Dog_Data;
import user.dog_shleter.dto.Dog_Shelter;

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
	 * @return - DogDTO
	 */
	public Dog_Data dogDetail(Dog_Data dog);
	
	

}
