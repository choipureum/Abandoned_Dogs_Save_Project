package user.qna.service.impl;

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


import user.qna.dao.face.QnaDao;

import user.qna.dao.impl.QnaDaoImpl;

import user.qna.dto.QNA;

import user.qna.dto.QnaFile;
import user.qna.dto.Qna_Reply;
import user.qna.service.face.QnaService;
import util.Paging;




public class QnaServiceImpl implements QnaService {

	private QnaDao boardDao = new QnaDaoImpl();
	//private RecommendDao recommendDao = new RecommendDaoImpl();
	
	
	
	
//	public List getList() {
//		return boardDao.selectAll();
//	}

	@Override
	//paging객체를 전달받아 시작과 끝을 정하고 검색어로 조건문을 주었다 
	public List<QNA> getList(Paging paging) {
		return boardDao.selectAll(paging);
	}

	@Override
	//curpage와 검색어로 totalcount를 세어서 만든 paging객체를 반환
	public Paging getPaging(HttpServletRequest req) {
		
		//요청파라미터 curPage를 파싱한다
		String param = req.getParameter("curPage");
		int curPage = 0;
		if( param!=null && !"".equals(param) ) {
			curPage = Integer.parseInt(param);
		}

		//검색어
		String search = (String)req.getParameter("search");

		
		//검색어 search를 전달하여 title에서 검색어가 들어가는 수cnt를 반환
		//Board TB와 curPage 값을 이용한 Paging 객체를 생성하고 반환
		int totalCount = boardDao.selectCntAll(search);
		
		// Paging 객체 생성 
		Paging paging = new Paging(totalCount, curPage);
		
		//페이징 객체에 검색어 생성 
		paging.setSearch(search);
		
		//curpage와 검색어로 totalcount를 세어서 만든 paging객체를 반환
		return paging;
	}//end
	
	@Override
	//리스트.jsp로 부터 전달받은 qnano으로  빈객체를 생성
	public QNA getBoardno(HttpServletRequest req) {
		
		//요청파라미터 boardno를 파싱한다
		String param = req.getParameter("qnano");
		int boardno = 0;
		if( param!=null && !"".equals(param) ) {
			boardno = Integer.parseInt(param);
		}
		
		//게시글 번호를 DTO에 넣기
		QNA board = new QNA();
		board.setQnaNO(boardno);
		
		return board;
	}//end
	
	@Override
	//qnano이 있는 빈객체를 전달해 게시글조회수를 1 늘림//
	public QNA view(QNA viewBoard) {
		
		//게시글 조회수 +1
		boardDao.updateHit(viewBoard);
		
		//게시글 조회 반환//qnano에 해당하는 객체를 전달 받음 
		return boardDao.selectBoardByBoardno(viewBoard);
	}

	@Override
	public void write(HttpServletRequest req) {
		
		QNA board = null;
		QnaFile boardFile = null;
		
		boolean isMultipart = ServletFileUpload.isMultipartContent(req);
		
		if(!isMultipart) { //multipart/form-data 형식인지 검사
			System.out.println("[ERROR] multipart/form-data 형식이 아님");
			return;
			
		}
		
		
		//파일업로드를 사용하고 있을 경우
		board = new QNA();

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
			
			// form data 처리
			if( item.isFormField() ) {
				
				try {
					
					//제목 처리
					if( "title".equals( item.getFieldName() ) ) {
						board.setQnaTitle( item.getString("utf-8") );
					}
					
					//본문 처리
					if( "content".equals( item.getFieldName() ) ) {
						board.setQnaContent( item.getString("utf-8") );
					}
					if( "writer".equals( item.getFieldName() ) ) {
						board.setQnaWriter( item.getString("utf-8") );
					}
					
					
					
				} catch (UnsupportedEncodingException e) {
					e.printStackTrace();
				}
				
				//작성자id 처리//id를 writer에 삽입 
				//board.setQnaWriter((String) req.getSession().getAttribute("userid"));
				
			} else { //파일 처리
				UUID uuid = UUID.randomUUID();
				String u = uuid.toString().split("-")[4];
				
				//로컬 저장소 파일
				String stored = item.getName() + "_" + u;
				File up = new File(
					req.getServletContext().getRealPath("upload")
					, stored);
				
				//첨부파일 정보 객체
				boardFile = new QnaFile();
				boardFile.setQna_org_FILE_NAME(item.getName());
				boardFile.setQna_stored_FILE_NAME(stored);
				boardFile.setQna_FILE_SIZE(item.getSize());
				
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
		

		//게시글 번호 생성//반환
		int boardno = boardDao.selectBoardno();
		
		//게시글 정보가 없을 경우 처리
		if(board != null) {
			board.setQnaNO(boardno); //게시글 번호 입력
			
			//게시글 제목 없을 경우 처리
			if(board.getQnaTitle()==null || "".equals(board.getQnaTitle())) {
				board.setQnaTitle("(제목없음)");
			}

			boardDao.insert(board); //게시글 삽입
		}
		
		//첨부파일 정보가 없을 경우 처리
		if(boardFile != null) {
			boardFile.setQnaNo(boardno); //첨부파일에 게시글 번호 입력
			
			boardDao.insertFile(boardFile); //첨부파일 정보 삽입
		}
		
	}//end

	@Override
	//qnano에 해당하는 객체를 전달받아 dao에 넘김 //qnano에 해당하는 파일받아 반환 
	public QnaFile viewFile(QNA board) {
		return boardDao.selectFile(board);
	}//end
	
	@Override
	public boolean checkId(HttpServletRequest req) {
		
		//로그인한 세션 ID 얻기
		String loginId = (String) req.getSession().getAttribute("userid");

		//작성한 게시글 번호 얻기
		QNA board = getBoardno(req);
		
		//게시글 얻어오기
		board = boardDao.selectBoardByBoardno(board);

		//게시글의 작성자와 로그인 아이디 비교
		if( !loginId.equals(board.getQnaWriter()) ) {
			return false;
		}
		
		return true;
	}
	
	@Override
	//전달받은 파라미터를 
	public void update(HttpServletRequest req) {
		QNA board = null;
		QnaFile boardFile = null;
		
		boolean isMultipart = ServletFileUpload.isMultipartContent(req);
		
		if(!isMultipart) {
			//파일 첨부가 없을 경우
			board = new QNA();
			
			board.setQnaTitle(req.getParameter("title"));
			board.setQnaWriter((String) req.getSession().getAttribute("userid"));
			board.setQnaContent(req.getParameter("content"));
			
		} else {
			//파일업로드를 사용하고 있을 경우
			board = new QNA();

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
						if( "qnano".equals( item.getFieldName() ) ) {
							board.setQnaNO( Integer.parseInt(item.getString()) );
						}
	
						if( "title".equals( item.getFieldName() ) ) {
							board.setQnaTitle( item.getString("utf-8") ); 
						}
						if( "content".equals( item.getFieldName() ) ) {
							board.setQnaContent( item.getString("utf-8") );
						}
						
						board.setQnaWriter((String) req.getSession().getAttribute("userid"));
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
					
					boardFile = new QnaFile();
					boardFile.setQna_org_FILE_NAME(item.getName());
					boardFile.setQna_stored_FILE_NAME(stored);
					boardFile.setQna_FILE_SIZE(item.getSize());
					
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
		} //if(!isMultipart) end
		

//		System.out.println(board);
//		System.out.println(boardFile);
		
		if(board != null) {
			//update
			boardDao.update(board);
		}
		
		if(boardFile != null) {
			boardFile.setQnaNo(board.getQnaNO());
			//insert
			boardDao.insertFile(boardFile);
		}
	}
	

	

	@Override
	public void delete(QNA board) {
		
		//파일객체 삭제
		boardDao.deleteFile(board);
		
		//객체 삭제 
		boardDao.delete(board);
		
	}//end

	
	//게시글 답변 조회
	@Override
	public Qna_Reply Qna_ReplyDetail(int qnano) {

		return boardDao.Qna_ReplySelectByNo(qnano);
	}
	
	


	
}






