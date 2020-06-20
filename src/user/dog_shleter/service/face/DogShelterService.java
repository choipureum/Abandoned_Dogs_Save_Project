package user.dog_shleter.service.face;

import java.util.List;

import user.dog_shleter.dto.Dog_Shelter;

public interface DogShelterService {

	/**
	 * 유기견 보호소 전체 목록 조회
	 * 
	 * @return List<Dog_Shelter> 
	 */
	public List<Dog_Shelter> list();

}
