package user.dog_shleter.service.impl;

import java.util.List;

import user.dog_shleter.dao.face.DogShelterDao;
import user.dog_shleter.dao.impl.DogShelterDaoImpl;
import user.dog_shleter.dto.Dog_Shelter;
import user.dog_shleter.service.face.DogShelterService;

public class DogShelterServiceImpl implements DogShelterService {

	private DogShelterDao dogShelterDao = new DogShelterDaoImpl();
	
	@Override
	public List<Dog_Shelter> list() {
		
		List<Dog_Shelter> dogShelterList = dogShelterDao.selectAll();
		
		
		return dogShelterList;
	}

}
