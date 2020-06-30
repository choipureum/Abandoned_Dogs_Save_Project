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
		
		@Override
		public Paging getPaging(HttpServletRequest req) {
			
			//전달파라미터 curPage를 파싱한다
			String param = req.getParameter("curPage");
			int curPage = 0;
			if( param!=null && !"".equals(param) ) {
				curPage = Integer.parseInt(param);
			}
			
			//dog 테이블의 총 데이터 수를 조회한다
			int totalCount = dogDao.selectCntAll();

			//Paging 객체 생성 - 현재 페이지(curPage), 총 게시글 수(totalCount) 활용
			Paging paging = new Paging(totalCount, curPage,6);
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

		@Override
		public void deleteUserLike(UserLike userlike) {
			dogDao.deleteUserLike(userlike);
		}

		public void deleteDogClaim(DogClaimDTO dogclaim) {
			dogDao.deleteDogClaim(dogclaim);
		}

		@Override
		public boolean isUserLike(UserLike userlike) {
			int cnt = dogDao.selectCntUserLike(userlike);
			
			if(cnt>0) {// 담아두기했음
				return true;
			}else { //담아두지 않았음
				return false;
				
			}
			
		}

		@Override
		public UserLike getUserLike(HttpServletRequest req) {
			
			//전달파라미터 파싱
			int dogno = 0;
			String param = req.getParameter("dogno");
			if(param!=null && !"".equals(param)) {
				dogno = Integer.parseInt(param);
			}
			
			// 로그인한 아이디
			String userid = (String) req.getSession().getAttribute("userid");
			
			UserLike userlike = new UserLike();
			userlike.setDogno(dogno);
			userlike.setUserid(userid);
			
			
			return userlike;
		}

		@Override
		public boolean UserLike(UserLike userlike) {
		
			if(isUserLike(userlike)) {//담아두기한 상태
				dogDao.deleteUserLike(userlike);
				
				return false;
			} else {//담아두기 하지 않은 상태
				dogDao.insertUserLike(userlike);
			}
			return true;
			
		}

		@Override
		public UserLike selectUserLike(HttpServletRequest req) {
			UserLike userlike= dogDao.selectUserLike(req); 
		      
		     
			
			
			
			return userlike;
		}

		@Override
		public List<UserLike> listUserLike(UserLike userLike) {
			
			List<UserLike> userLikeList = dogDao.selectUserList(userLike);
			
			
			return userLikeList;
		}

//		@Override
//		public List<UserLike> listUserLike(UserLike userLike) {
//			return dogDao.listUserLike(userLike);
//		}

		
		
		
		
		
}

