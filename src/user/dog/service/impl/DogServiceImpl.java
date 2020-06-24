package user.dog.service.impl;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import admin.dto.DogClaimDTO;
import user.dog.dao.face.DogDao;
import user.dog.dao.impl.DogDaoImpl;
import user.dog.dto.DogDTO;
import user.dog.dto.Dog_Data;
import user.dog.dto.Dog_File_DTO;
import user.dog.dto.UserLike;
import user.dog.service.face.DogService;
import util.Paging;

public class DogServiceImpl implements DogService{
	
	//DogDao 객체 생성
		private DogDao dogDao = new DogDaoImpl();
		
		
		
		
		
		//ok
		@Override
		public Paging getPaging(HttpServletRequest req) {
			
			//전달파라미터 curPage를 파싱한다
			String param = req.getParameter("curPage");
			int curPage = 0;
			if( param!=null && !"".equals(param) ) {
				curPage = Integer.parseInt(param);
			}
			
			//Board 테이블의 총 게시글 수를 조회한다
			int totalCount = dogDao.selectCntAll();

			//Paging 객체 생성 - 현재 페이지(curPage), 총 게시글 수(totalCount) 활용
			Paging paging = new Paging(totalCount, curPage, 6);
//			Paging paging = new Paging(totalCount, curPage, 6);
			
			//Paging 객체 반환
			return paging;
		}

		//ok
		@Override
		public List<Dog_Data> getList(Paging paging) {
			return dogDao.selectAll(paging);
		}
		
		
		@Override
		public DogDTO getDogno(HttpServletRequest req) {
			
			//boardno를 저장할 객체 생성
			DogDTO dogno = new DogDTO();
			
			//boardno 전달파라미터 검증 - null, ""
			String param = req.getParameter("dogno");
			if(param!=null && !"".equals(param)) {
				
				//boardno 전달파라미터 추출
				dogno.setDogno( Integer.parseInt(param) );
			}
			
			//결과 객체 반환
			return dogno;
		}


		@Override
		public DogDTO view(DogDTO dogno) {
			//게시글 조회//dogno에 해당하는 객체의 정보만가져옮
			DogDTO dog= dogDao.selectDogByDogno(dogno); 
		      
		     
		      return dog;
		}

		@Override
		public Dog_File_DTO viewFile(DogDTO detailDog) {
			return dogDao.selectFile(detailDog);
		}

		@Override
		public void insertUserLike(HttpServletRequest req) {
			
			//userlike정보 저장할 객체
			UserLike userlike = null;
			
			
			int dogno = dogDao.selectDogno();
			
			
			
			userlike.setDogno(dogno);
			
			
			dogDao.insertUserLike(userlike);
		}

		@Override
		public void insertDogClaim(HttpServletRequest req) {
			
			//dogclaim 정보 저장할 객체
			DogClaimDTO claim = null;
			
			int dogno = dogDao.selectDogno();
			
			claim.setDogno(dogno);
			
			dogDao.insertDogClaim(claim);
			
		}

}

