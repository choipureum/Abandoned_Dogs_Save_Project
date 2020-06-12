package user.dog.dao.face;

import java.util.List;

import user.dog.dto.DogDTO;


public interface DogDao {

	
	public List<DogDTO> selectAll();
	
}
