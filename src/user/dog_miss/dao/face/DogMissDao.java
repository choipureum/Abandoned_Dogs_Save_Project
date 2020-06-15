package user.dog_miss.dao.face;

import java.sql.Connection;
import java.util.List;

import user.dog_miss.dto.Dog_MissDTO;

public interface DogMissDao {

	public List<Dog_MissDTO> selectAll();

	public int insertDog_Miss(Connection conn, Dog_MissDTO dog_MissDTO);

	

}
