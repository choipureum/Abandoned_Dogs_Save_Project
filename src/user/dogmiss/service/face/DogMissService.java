package user.dogmiss.service.face;

import java.util.List;


import javax.servlet.http.HttpServletRequest;

import user.dogmiss.dto.Comment;
import user.dogmiss.dto.DogMiss;
import user.dogmiss.dto.DogMissAdd;
import user.dogmiss.dto.DogMissFile;


import util.Paging;



public interface DogMissService {

	
	//public List<DogMiss> getList();
	
	//public QNA getParam(HttpServletRequest request);
	
	//public QNA join(QNA member);
	
	
	
	public Paging getPaging(HttpServletRequest request);
	
	public List<DogMissAdd> getList(Paging paging);
	
	public DogMiss getmissno(HttpServletRequest req);
	
	public DogMiss view(DogMiss missno);
	
	public DogMissFile viewFile(DogMiss view);
	
	public void write(HttpServletRequest request);
	
	
	public DogMiss getBoardno(HttpServletRequest req);
	
	public void delete(DogMiss board);
	
	public DogMissFile viewFM(DogMissFile FM);
	
	public void update(HttpServletRequest req);
	
	/**
	 * 댓글 전달파라미터 꺼내기
	 */
	public Comment getComment(HttpServletRequest request);
	
	/**
	 * 댓글 입력
	 * 
	 * @param comment - 삽입될 댓글
	 */
	public void insertComment(Comment comment);

	
	/**
	 * 댓글 리스트
	 * 
	 * @param board - 댓글이 조회될 게시글
	 * @return List - 댓글 리스트
	 */
	public List<Comment> getCommentList(DogMiss viewBoard);
	
	/**
	 * 댓글 삭제
	 *  
	 * @param comment - 삭제할 댓글
	 * @return boolean - 삭제 성공 여부
	 */
	public boolean deleteComment(Comment comment);
	
}