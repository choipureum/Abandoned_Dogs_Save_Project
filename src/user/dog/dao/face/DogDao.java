package user.dog.dao.face;

import java.util.List;

import user.dog.dto.Dog;
import user.dog.dto.Dog_Data;
import user.dog.dto.Dog_File;
import util.Paging;

public interface DogDao {

	
	public List<Dog_Data> selectAll(Paging paging);

	



	public int selectDogno();

	public int selectCntAll();

	public Dog selectDogByDogno(Dog dogno);

	public Dog_File selectFile(Dog detailDog);

	
}
