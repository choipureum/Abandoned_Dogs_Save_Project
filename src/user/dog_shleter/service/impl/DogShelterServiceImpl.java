package user.dog_shleter.service.impl;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import user.dog.dto.Dog_Data;
import user.dog_shleter.dao.face.DogShelterDao;
import user.dog_shleter.dao.impl.DogShelterDaoImpl;
import user.dog_shleter.dto.Dog_Shelter;
import user.dog_shleter.service.face.DogShelterService;
import util.Paging;

public class DogShelterServiceImpl implements DogShelterService {

	private DogShelterDao dogShelterDao = new DogShelterDaoImpl();
	
	//좌표값, 마커 조회
	 
	@Override
	public List<Dog_Shelter> list() {
		
		List<Dog_Shelter> dogShelterList = dogShelterDao.selectAll();
		
		
		return dogShelterList;
	}


	//유기견 보호소 조회
	@Override
	public Dog_Shelter detail(Dog_Shelter dogShelter) {
		//TEST
		System.out.println("dogshelterService : " + dogShelter);
		return dogShelterDao.selectBy(dogShelter);
	
	}


	@Override
	public List<Dog_Data> dogDetail(Dog_Data dog, Paging paging) {
		return dogShelterDao.dogDetailList(dog, paging);
		
	}
	

	@Override
	public Paging getPaging(HttpServletRequest req) {
		//전달파라미터 curPage를 파싱한다
		String param = req.getParameter("curPage");
		int curPage = 0;
		if( param!=null && !"".equals(param) ) {
			curPage = Integer.parseInt(param);
		}
		
		//dog 테이블의 총 게시글 수를 조회한다
		int totalCount = dogShelterDao.selectCntAll();

		//Paging 객체 생성 - 현재 페이지(curPage), 총 게시글 수(totalCount) 활용
		Paging paging = new Paging(totalCount, curPage, 6);
	
		//Paging 객체 반환
		return paging;
	}






	
	}
	
