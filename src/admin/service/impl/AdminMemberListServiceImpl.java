package admin.service.impl;

import java.io.File;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.TreeMap;
import java.util.UUID;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.FileUploadException;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;

import admin.dao.face.AdminMemberListDao;
import admin.dao.impl.AdminMemberListDaoImpl;
import admin.dto.DogClaimDTO;
import admin.service.face.AdminMemberListService;
import user.dog.dto.DogDTO;
import user.dog.dto.Dog_File_DTO;
import user.member.dto.MemberDTO;
import admin.service.*;
import util.JDBCTemplate;
import util.Paging;


public class AdminMemberListServiceImpl implements AdminMemberListService{
	
	//DAO객체 생성
	private AdminMemberListDao adminMemberListDao = AdminMemberListDaoImpl.getInstance();
	
	
	@Override
	public List<MemberDTO> memberSelect(HashMap<String, Object> listOpt, Paging paging) {				
		return adminMemberListDao.select(listOpt,paging);
	}
	@Override
	public int memberCount(HashMap<String, Object> listOpt) {
		int res = adminMemberListDao.getMemberCount(listOpt);
		return res;
	}
	@Override
	public int memberDelete(String userid) {
		int res=adminMemberListDao.delete(userid);
		
		return res;
	}
	@Override
	public List<MemberDTO> memberSelectAll() {
		List<MemberDTO>list = adminMemberListDao.selectAll();
		return list;
	}	
	
	@Override
	public Paging getPaging(HttpServletRequest req, HashMap<String,Object> listOpt,String sw) {
		//전달파라미터 curPage를 파싱한다
		String param = req.getParameter("curPage");
		int curPage = 0;
		if( param!=null && !"".equals(param) ) {
			curPage = Integer.parseInt(param);
		}	
		int totalCount=0;
		
		if(sw.equals("member")) {
			//회원 테이블의 총 게시글 수를 조회한다
			totalCount = adminMemberListDao.getMemberCount(listOpt);
		}else if(sw.equals("dogClaim")) {
			//강아지 입양신청 총 숫자 조회
			totalCount = adminMemberListDao.dogClaimCount(listOpt);
		}
		//Paging 객체 생성
		Paging paging = new Paging(totalCount, curPage); 
						
		//계산된 Paging 객체 반환
		return paging;
	}
	@Override
	public TreeMap<Date, Integer> getGraphMember() {		
		return adminMemberListDao.graphMember();
	}
	@Override
	public MemberDTO selectById(String userid) {
		MemberDTO member=adminMemberListDao.selectID(userid);
		return member;
	}
	@Override
	public void UpdateGrade(String id,String grade) {
		adminMemberListDao.updateGradeById(id,grade);
	}
	
	@Override
	public void dogWrite(HttpServletRequest req) {
				DogDTO dog =null;
				Dog_File_DTO dogFile = null;
				
				boolean isMultipart = false;
				isMultipart = ServletFileUpload.isMultipartContent(req);
				
				//multipart/form-data 인코딩으로 전송되지 않았을 경우
				if( !isMultipart ) {
					System.out.println("[ERROR] multipart/form-data 형식이 아님");					
					return; 
				}				
				 dog = new DogDTO();
			
				DiskFileItemFactory factory = new DiskFileItemFactory();
				factory.setSizeThreshold( 1 * 1024 * 1024 ); //1MB						
				File repository = new File(req.getServletContext().getRealPath("tmp"));
				factory.setRepository(repository);			
				ServletFileUpload upload = new ServletFileUpload(factory);
				upload.setFileSizeMax( 10*1024*1024 ); //10MB
				
				List<FileItem> items = null;
				try {
					items = upload.parseRequest(req);
				} catch (FileUploadException e) {
					e.printStackTrace();
				}
				
				Iterator<FileItem> iter = items.iterator();
				while( iter.hasNext() ) {
					FileItem item = iter.next();
					
					// 1) 빈 파일 처리
					if( item.getSize() <= 0 )	continue;
					
					// 2) 일반적인 요청 데이터 처리
					if( item.isFormField() ) {

						String key = item.getFieldName(); //키 추출
						if( "dogName".equals(key) ) { 
							try {
								dog.setDogname( item.getString("UTF-8") );
							} catch (UnsupportedEncodingException e) {
								e.printStackTrace();
							}
							
						} else if ( "dogKind".equals(key) ) { 
							try {
								dog.setDogkind( item.getString("UTF-8") );
							} catch (UnsupportedEncodingException e) {
								e.printStackTrace();
							}						
						} else if("genderCheck".equals(key)) {
							try {
								dog.setDoggender( item.getString("UTF-8") );
							} catch (UnsupportedEncodingException e) {
								e.printStackTrace();
							}	
						}
						else if("dogNeu".equals(key)) {
							try {
								dog.setDogneu( item.getString("UTF-8") );
							} catch (UnsupportedEncodingException e) {
								e.printStackTrace();
							}	
						}
						else if("shelter".equals(key)) {
							try {
								dog.setShelterno(Integer.parseInt( item.getString("UTF-8")) );
							} catch (UnsupportedEncodingException e) {
								e.printStackTrace();
							}	
						}
						
					} // if( item.isFormField() ) end - 폼필드 확인
					
					
					
					// 3) 파일 처리
					if( !item.isFormField() ) {
						
						// --- UUID 생성 ---
						UUID uuid = UUID.randomUUID(); //랜덤 UID 생성
						String u = uuid.toString().split("-")[0]; //8자리 uid
									
						// --- 로컬 저장소의 파일 객체 생성 ---
						File up = new File(
								req.getServletContext().getRealPath("upload") // 업로드될 폴더 경로
								, item.getName()+"_"+u // 원본파일명_uid
								);
						// ------------------------------------
						
						// --- 첨부파일 정보 객체 ---
					
						dogFile = new Dog_File_DTO(); //객체 생성
						dogFile.setDog_org_file_name(item.getName()); //원본파일명
						dogFile.setDog_stored_file_name(item.getName()+"_"+u); //저장파일명
						dogFile.setDog_file_size((int)item.getSize());
						// --------------------------
						
						// --- 처리 완료된 파일 업로드 하기 ---
						try {
							item.write(up); //실제 업로드
							item.delete(); //임시 파일 삭제
						} catch (Exception e) {
							e.printStackTrace();
						}
						// -----------------------------------
						
					} // 파일 처리 end					
				} // while( iter.hasNext() ) end - 
								
				//DB데이터 입력				
				//게시글 번호 생성 - Dao 이용
				int dogno= adminMemberListDao.selectDogNo();
				
					
				//게시글 번호 입력
				dog.setDogno(dogno);			
				//게시글 삽입
				adminMemberListDao.insertDog(dog);
			
								
				//첨부파일 정보가 있을 경우
				if(dogFile != null) {
					//게시글 번호 입력
					dogFile.setDogno(dogno);			
					//첨부파일 삽입
					adminMemberListDao.insertDogFile(dogFile);
				}
	}
	@Override
	public List<DogClaimDTO> dogClaimSelectAll() {				
		return adminMemberListDao.dogClaimSelectAll();
	}
	
	/**
	 * 
	 * 입양 신청 불허가
	 */
	@Override
	public void dogClaimDelete(String userid) {
			//개 입양신청 삭제
			adminMemberListDao.dogClaimDelete(userid);
			
			//dogClaim id를 통한 개번호 조회
			int dogno=adminMemberListDao.dognoBydogClaim(userid);
			
			//입양 불허가 업데이트 apply sw =2;로 바꾸기
			adminMemberListDao.dogClaimUpdateApplySw(userid,dogno);
	}
	/**
	 * 입양신청 허가 서비스 구성
	 * 
	 * 
	 */
	@Override
	public void dogClaimAccept(String userid) {
		
		//dogno 조회
		//dogClaim id를 통한 개번호 조회
		int dogno=adminMemberListDao.dognoBydogClaim(userid);
		
		//입양신청 dogno같은 애들 모조리 삭제
		adminMemberListDao.dogClaimDeleteByDogno(dogno);
	
		//userlike update sw=1
		adminMemberListDao.userLikeUpdateByadmin(userid, dogno);
		
		//userlike 해당 dogno 전부 삭제
		adminMemberListDao.DeletedognoUserlike(dogno);
		
		//dog정보 삭제
		adminMemberListDao.dogDeleteByadmin(dogno);
	}
}






