package user.dog_shleter.service.impl;

import java.util.List;

import user.dog_shleter.dao.face.DogShelterDao;
import user.dog_shleter.dao.impl.DogShelterDaoImpl;
import user.dog_shleter.dto.Dog_Shelter;
import user.dog_shleter.service.face.DogShelterService;

public class DogShelterServiceImpl implements DogShelterService {

	private DogShelterDao dogShelterDao = new DogShelterDaoImpl();
	
	//유기견 보호소 조회
	 
	@Override
	public List<Dog_Shelter> list() {
		
		List<Dog_Shelter> dogShelterList = dogShelterDao.selectAll();
		
		
		return dogShelterList;
	}

	@Override
	public List<Dog_Shelter> view(String sheltername, String shelteraddress, String sheltertel) {
		
		return dogShelterDao.view(sheltername, shelteraddress, sheltertel);
	}

	@Override
	public Dog_Shelter detail(Dog_Shelter dogShelter) {
		return dogShelterDao.selectBy(dogShelter);
	}
	
}
