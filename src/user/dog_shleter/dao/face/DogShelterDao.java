package user.dog_shleter.dao.face;

import java.util.List;

import user.dog_shleter.dto.Dog_Shelter;

public interface DogShelterDao {


	/**
	 * 보호소 전체 조회
	 * @return
	 */
	public List<Dog_Shelter> selectAll();

}
