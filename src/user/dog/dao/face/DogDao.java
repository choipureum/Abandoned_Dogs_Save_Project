package user.dog.dao.face;

import java.util.List;

import user.dog.dto.DogDTO;
import user.dog.dto.Dog_Data;
import user.dog.dto.Dog_File_DTO;
import util.Paging;

public interface DogDao {

	
	public List<Dog_Data> selectAll(Paging paging);

	



	public int selectDogno();

	public int selectCntAll();

	public DogDTO selectDogByDogno(DogDTO dogno);

	public Dog_File_DTO selectFile(DogDTO detailDog);

	
}
