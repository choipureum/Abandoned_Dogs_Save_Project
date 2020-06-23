package user.dog_shleter.dao.face;

import java.util.List;

import user.dog_shleter.dto.Dog_Shelter;

public interface DogShelterDao {


	/**
	 * 보호소 조회
	 * 좌표값, 보호소 명
	 * @return
	 */
	public List<Dog_Shelter> selectAll();

	/**
	 * 보호소 조회
	 * 보호소 명, 보호소 주소, 보호소 전화번호
	 * @param sheltername
	 * @param shelteraddress
	 * @param sheltertel
	 * @return
	 */
	public List<Dog_Shelter> view(String sheltername, String shelteraddress, String sheltertel);

	/**
	 * 
	 * @param dogShelter
	 * @return
	 */
	public Dog_Shelter selectBy(Dog_Shelter dogShelter);

}
