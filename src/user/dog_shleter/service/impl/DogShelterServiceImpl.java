package user.dog_shleter.service.impl;

import java.util.List;

import user.dog.dto.Dog_Data;
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
	public Dog_Shelter detail(Dog_Shelter dogShelter) {
		//TEST
		System.out.println("dogshelterService : " + dogShelter);
		return dogShelterDao.selectBy(dogShelter);
	
	}


	@Override
	public Dog_Data dogDetail(Dog_Data dog) {
		//TEST
		System.out.println("dogService : " + dog);
		return dogShelterDao.dogDetailList(dog);
	}
	
}
