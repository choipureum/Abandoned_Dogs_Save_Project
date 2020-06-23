package user.dogmiss.service.impl;

import java.io.File;


import java.io.UnsupportedEncodingException;
import java.util.Iterator;
import java.util.List;
import java.util.UUID;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.FileUploadException;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;

import user.dogmiss.dao.face.DogMissDao;
import user.dogmiss.dao.impl.DogMissDaoImpl;
import user.dogmiss.dto.DogMiss;
import user.dogmiss.dto.DogMissAdd;
import user.dogmiss.dto.DogMissFile;
import user.dogmiss.service.face.DogMissService;
import util.Paging;








public class DogMissServiceImpl implements DogMissService {

	private DogMissDao dogMissDao = new DogMissDaoImpl();
	
	//public List<DogMiss> getList() {
		
		
		//return dogMissDao.selectAll();
			
		//}
//	
//	 public QNA getParam(HttpServletRequest request) {
//
//		   QNA qna = new QNA();
//
//		   qna.setQnaTitle( request.getParameter("title") );
//
//		   qna.setQnaContent( request.getParameter("content") );
//
//		   qna.setQnaWriter( request.getParameter("writer") );
//		   
//		   return qna;
//
//		 }
//	 
//	 public QNA join(QNA qna) {
//
//		  
//
//		  int next = qnaDao.selectNextUserno();
//
//		  qna.setQnaNO( next );
//
//		
//		  qnaDao.insert(qna);
//		  
//		  return qna;
//
//		  
//
//		 }

	@Override
	//페이징 객체를 생성한다//db정보가 필요없는 비지니스 로직이기 때문에 service에서 처리한다 
	public Paging getPaging(HttpServletRequest req) {
		
		
		//전달파라미터 curPage를 파싱한다
		String param = req.getParameter("curPage");
		int curPage = 0;
		if( param!=null && !"".equals(param) ) {
			curPage = Integer.parseInt(param);
		}
		
		
		//검색어
		String search = (String)req.getParameter("search");

				
		//검색어 search를 전달하여 kind에서 검색어가 들어가는 수cnt를 반환
		//Board TB와 curPage 값을 이용한 Paging 객체를 생성하고 반환
		int totalCount = dogMissDao.selectCntAll(search);
				
		// Paging 객체 생성 
		Paging paging = new Paging(totalCount, curPage);
				
		//페이징 객체에 검색어 생성 
		paging.setSearch(search);
				
		//curpage와 검색어로 totalcount를 세어서 만든 paging객체를 반환
		return paging;
		
		
		
		
		
		
		
		//Board 테이블의 총 게시글 수를 조회한다
		//int totalCount = dogMissDao.selectCntAll();
		
		//Paging 객체 생성//페이징 생성자의 전달인자의 데이터형이int이다 그래서 int형으로 바꿔준것이다 
		//Paging paging = new Paging(totalCount, curPage); 
		
		//계산된 Paging 객체 반환
		//return paging;
	}//getPaging end

	@Override
	public List<DogMissAdd> getList(Paging paging) {
		
			return dogMissDao.selectAll(paging);
		
	}
	
	
	//missno을 넣은 객체를 생성 - 자바는 객체지향이기 때문에 굳이 객체를 생성하는건가?
	public DogMiss getmissno(HttpServletRequest req) {
		
		
		DogMiss missno = new DogMiss();
		
		//getparameter로 얻으면 항상 String 타입이기 때문에 int형으로 변화시켜줘야 한다 
		String param = req.getParameter("missno");
		if(param!=null && !"".equals(param)) {
			
		missno.setMissNO( Integer.parseInt(param) );
		}
		
		//결과 missno값이 들어간 객체 반환
		return missno;
	}//end
	
	
	//missno이 들어간 객체를 받아  hit을 증가시키고 missno에 해당하는 객체를 가져옮
	public DogMiss view(DogMiss missno) {

		//게시글 조회//missno에 해당하는 객체의 정보만가져옮
		DogMiss board = dogMissDao.selectBoardByMissno(missno); 
		
		if(board != null) {
			//파라미터로 전달 받은 missno에 해당하는 게시글 조회수 증가
			dogMissDao.updateHit(board);
		}
		
		return board;
	}//end
	
	
	//전달받은 파라미터의 missno에 해당하는 파일객체를 가져오기
	public DogMissFile viewFile(DogMiss view) {
		return dogMissDao.selectFile(view);
	}//end
	
	public DogMissFile viewFM(DogMissFile FM) {
		return dogMissDao.viewFM(FM);
	};
	
	
	@Override
	//write.jsp로 부터 전달받은 파라미터를 저장
	public void write(HttpServletRequest req) {
		
		//----------- urlencoded 처리 -----------
//		Board board = new Board();
//
//		board.setTitle( req.getParameter("title") );
//		board.setContent( req.getParameter("content") );
//
//		//작성자id 처리
//		board.setId((String) req.getSession().getAttribute("userid"));
//
//		if(board.getTitle()==null || "".equals(board.getTitle())) {
//			board.setTitle("(제목없음)");
//		}
//
//		boardDao.insert(board);
		//---------------------------------------
		
		//게시글 정보 저장할 객체
		DogMiss board = null;
		
		//첨부파일 정보 저장할 객체
		DogMissFile boardFile = null;
		
		//파일업로드 형태의 데이터가 맞는지 검사
		boolean isMultipart = false;
		isMultipart = ServletFileUpload.isMultipartContent(req);
		
		//multipart/form-data 인코딩으로 전송되지 않았을 경우
		if( !isMultipart ) {
			return; //fileupload() 메소드 실행 중지
		}
		
		//게시글 정보 저장할 객체 생성
		board = new DogMiss();
	
		//디스트기반 아이템 팩토리
		DiskFileItemFactory factory = new DiskFileItemFactory();

		//메모리 처리 사이즈 지정
		factory.setSizeThreshold( 1 * 1024 * 1024 ); //1MB
		
		
		//임시 저장소 설정
		File repository = new File(req.getServletContext().getRealPath("tmp"));
		factory.setRepository(repository);
		
		//파일업로드 객체 생성
		ServletFileUpload upload = new ServletFileUpload(factory);

		//업로드 용량 제한
		upload.setFileSizeMax( 10*1024*1024 ); //10MB
		
		//전달 데이터 파싱
		List<FileItem> items = null;
		try {
		items = upload.parseRequest(req);
		} catch (FileUploadException e) {
			e.printStackTrace();
		}
		
		//추출된 전달파라미터 처리 반복자
		Iterator<FileItem> iter = items.iterator();

		//모든 요청 정보 처리하기
		while( iter.hasNext() ) {
			FileItem item = iter.next();
			
			// 1) 빈 파일 처리
			if( item.getSize() <= 0 )	continue;
			
			// 2) 일반적인 요청 데이터 처리
			if( item.isFormField() ) {
				
				

				String key = item.getFieldName(); //키 추출
				if( "title".equals(key) ) { //전달파라미터 name이 "title"
					try {
						board.setMissTitle( item.getString("UTF-8") );
					} catch (UnsupportedEncodingException e) {
						e.printStackTrace();
					}
					
				} else if ( "content".equals(key) ) { //전달파라미터 name이 "content"
					try {
						board.setMissContent( item.getString("UTF-8") );
					} catch (UnsupportedEncodingException e) {
						e.printStackTrace();
					}
					
				}else if ( "writer".equals(key) ) { //전달파라미터 name이 "content"
					try {
						board.setMissWriter( item.getString("UTF-8") );
					} catch (UnsupportedEncodingException e) {
						e.printStackTrace();
					}
				
					}else if ( "kind".equals(key) ) { //전달파라미터 name이 "content"
						try {
							board.setMissKind( item.getString("UTF-8") );
						} catch (UnsupportedEncodingException e) {
							e.printStackTrace();
						}
						
					}else if ( "name".equals(key) ) { //전달파라미터 name이 "content"
						try {
							board.setMissName( item.getString("UTF-8") );
						} catch (UnsupportedEncodingException e) {
							e.printStackTrace();
						}
					}else if ( "gender".equals(key) ) { //전달파라미터 name이 "content"
						try {
							board.setMissGender( item.getString("UTF-8") );
						} catch (UnsupportedEncodingException e) {
							e.printStackTrace();
						}
					}else if ( "img".equals(key) ) { //전달파라미터 name이 "content"
						try {
							board.setMissImg( item.getString("UTF-8") );
						} catch (UnsupportedEncodingException e) {
							e.printStackTrace();
						}
					}else if ( "loc".equals(key) ) { //전달파라미터 name이 "content"
						try {
							board.setMissLoc( item.getString("UTF-8") );
						} catch (UnsupportedEncodingException e) {
							e.printStackTrace();
						}
					}
					 
			}//isFormfeild end
			
			
			// 3) 파일 처리
			if( !item.isFormField() ) {
				
				// --- UUID 생성 ---
				UUID uuid = UUID.randomUUID(); //랜덤 UID 생성
				String u = uuid.toString().split("-")[0]; //8자리 uid
				// -----------------
				
				// --- 로컬 저장소의 파일 객체 생성 ---
				File up = new File(
						req.getServletContext().getRealPath("upload") // 업로드될 폴더 경로
						, item.getName()+"_"+u // 원본파일명_uid
						);
				// ------------------------------------
				
				// --- 첨부파일 정보 객체 ---
				boardFile = new DogMissFile(); //객체 생성
				boardFile.setMiss_org_FILE_NAME(item.getName()); //원본파일명
				boardFile.setMiss_stored_FILE_NAME(item.getName()+"_"+u); //저장파일명
				boardFile.setMiss_FILE_SIZE((double)item.getSize());
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
			
		} // while( iter.hasNext() ) end - FileItem 반복 처리
		
		
		//DB데이터 입력
		
		//게시글 작성자 id 입력
		//board.setId( (String) req.getSession().getAttribute("userid") );
		
		//게시글 번호 생성 - Dao 이용
		int boardno = dogMissDao.selectBoardno();
		
		//게시글 정보가 있을 경우
		if(board != null) {
			//if(board.getTitle() == null || board.getTitle(). 
			//-->제목없음이 나오게 
			
			//게시글 번호 입력
			board.setMissNO(boardno);
			
			//write로 가져온 정보를 게시글 db데이터에 삽입
			dogMissDao.insert(board);
		}
		
		//첨부파일 정보가 있을 경우
		if(boardFile != null) {
			
			//게시글 번호를 파일 db에 입력  입력
			boardFile.setMissNo(boardno);
			
			//첨부파일  파일 db에 삽입
			dogMissDao.insertFile(boardFile);
		}
		
	}//write end
	
		
		//전달 파라미터를 받아 빈 객체를 생성 
		public DogMiss getBoardno(HttpServletRequest req) {
		
		//boardno를 저장할 객체 생성
		DogMiss boardno = new DogMiss();
		
		//boardno 전달파라미터 검증 - null, ""
		String param = req.getParameter("missno");
		if(param!=null && !"".equals(param)) {
			
			//boardno 전달파라미터 추출
			boardno.setMissNO( Integer.parseInt(param) );
		}
		
		//결과 객체 반환
		return boardno;
	}//getBoardno end
		
		
		
		public void delete(DogMiss board) {
			
			
			//boardno이 들어가있는 파일 모두 삭제
			dogMissDao.deleteFile(board);
			
			//boardno이 들어있는 QNA 객체 삭제 
			dogMissDao.delete(board);
			
		}//delete end
		
		public void update(HttpServletRequest req) {
			DogMiss board = null;
			DogMissFile boardFile = null;
			
			
			//파일업로드 형태의 데이터가 맞는지 검사
			boolean isMultipart = false;
			isMultipart = ServletFileUpload.isMultipartContent(req);
			
			//multipart/form-data 인코딩으로 전송되지 않았을 경우
			if( !isMultipart ) {
				System.out.println("[ERROR] multipart/form-data 형식이 아님");
				
				return; //fileupload() 메소드 실행 중지
			}

			
			//파일업로드를 사용하고 있을 경우
			board = new DogMiss();

			//디스크팩토리
			DiskFileItemFactory factory = new DiskFileItemFactory();

			//메모리처리 사이즈
			factory.setSizeThreshold(1 * 1024 * 1024); //1MB

			//임시 저장소
			File repository=new File(req.getServletContext().getRealPath("tmp"));
			factory.setRepository(repository);
			
			//업로드 객체 생성
			ServletFileUpload upload = new ServletFileUpload(factory);
			
			//용량 제한 설정 : 10MB
			upload.setFileSizeMax(10 * 1024 * 1024);
			
			//form-data 추출 
			List<FileItem> items = null;
			try {
				items = upload.parseRequest(req);
				
			} catch (FileUploadException e) {
				e.printStackTrace();
			}
			
			//파싱된 데이터 처리 반복자
			Iterator<FileItem> iter = items.iterator();
			
			//요청정보 처리
			while( iter.hasNext() ) {
				FileItem item = iter.next();
				
				// 빈 파일 처리
				if( item.getSize() <= 0 )	continue;
				
				// 빈 파일이 아닐 경우
				if( item.isFormField() ) {
					try {
						//boardno을 히든으로 해놓은 다음에 전달 받음 
						if( "missno".equals( item.getFieldName() ) ) {
							board.setMissNO( Integer.parseInt(item.getString()) );
						}

						if( "title".equals( item.getFieldName() ) ) {
							board.setMissTitle( item.getString("utf-8") ); 
						}
						if( "content".equals( item.getFieldName() ) ) {
							board.setMissContent( item.getString("utf-8") );
						}
						if( "name".equals( item.getFieldName() ) ) {
							board.setMissName( item.getString("utf-8") );
						}
						if( "kind".equals( item.getFieldName() ) ) {
							board.setMissKind( item.getString("utf-8") );
						}
						if( "loc".equals( item.getFieldName() ) ) {
							board.setMissLoc( item.getString("utf-8") );
						}
						if( "img".equals( item.getFieldName() ) ) {
							board.setMissImg( item.getString("utf-8") );
						}
						if( "writer".equals( item.getFieldName() ) ) {
							board.setMissWriter( item.getString("utf-8") );
						}
						if( "gender".equals( item.getFieldName() ) ) {
							board.setMissGender( item.getString("utf-8") );
						}
						
						//board.setId((String) req.getSession().getAttribute("userid"));
						
					} catch (UnsupportedEncodingException e) {
						e.printStackTrace();
					}
					
				} else {
					UUID uuid = UUID.randomUUID();
					String u = uuid.toString().split("-")[4];

					//로컬 저장소 파일
					String stored = item.getName() + "_" + u;
					File up = new File(
						req.getServletContext().getRealPath("upload")
						, stored);
					
					boardFile = new DogMissFile();
					boardFile.setMiss_org_FILE_NAME(item.getName());
					boardFile.setMiss_stored_FILE_NAME(stored);
					boardFile.setMiss_FILE_SIZE((int)item.getSize());
					
					try {
						// 실제 업로드
						item.write(up);
						
						// 임시 파일 삭제
						item.delete();
						
					} catch (Exception e) {
						e.printStackTrace();
					} // try end
				} //if end
			} //while end
			

//			System.out.println(board);
//			System.out.println(boardFile);
			
			if(board != null) {
				dogMissDao.update(board);
			}
			
			//boardno에 해당하는 파을을 파일db에 저장한다 
			if(boardFile != null) {
				boardFile.setMissNo(board.getMissNO());
				dogMissDao.insertFile(boardFile);
			}
		}//update end


		//public List<DogMissAdd> joinList(DogMiss missList) {
		//	// TODO Auto-generated method stub
		//	return null;
		//}
		
		
		//public List <DogMissAdd> joinList(DogMiss missList){
			
		//	return dogMissDao.joinList(missList);
		//};

  }
