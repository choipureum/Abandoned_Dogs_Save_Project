package user.dog_miss.service.face;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import user.dog_miss.dto.Dog_MissDTO;

public interface DogMissService {


	/**
	 * 파일업로드 전체 조회
	 * @return List<Dog_MissDTO>  - 조회된 결과
	 */
	public List<Dog_MissDTO> list();

	public int insertDogMiss(Dog_MissDTO dog_MissDTO);

	
}
