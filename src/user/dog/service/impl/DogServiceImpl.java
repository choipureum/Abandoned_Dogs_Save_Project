package user.dog.service.impl;

import java.util.List;

import user.dog.dao.face.DogDao;
import user.dog.dao.impl.DogDaoImpl;
import user.dog.dto.DogDTO;
import user.dog.service.face.DogService;



public class DogServiceImpl implements DogService{
	
	//dogDao객체 생성
	private DogDao dogDao= new DogDaoImpl();

	@Override
	public List<DogDTO> list() {
	
	//DOG테이블, DB 조회 결과 얻어오기 - Dao 이용
	List<DogDTO> dogList= dogDao.selectAll();
	//결과 반환
	return dogList;

	}

}

