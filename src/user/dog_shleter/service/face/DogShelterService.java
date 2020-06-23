package user.dog_shleter.service.face;

import java.util.List;

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
	 * 보호소명, 보호소 주소, 보호소 전화번호
	 * @return 
	 */
	public List<Dog_Shelter> view(String sheltername, String shelteraddress, String sheltertel);

	
	
	/**
	 * 유기견 보호소 조회
	 * @param dogShelter - 조회 대상 shelterno
	 * @return Dog_shelter 조회된 결과
	 */
	public Dog_Shelter detail(Dog_Shelter dogShelter);
	
	

}
