package user.dogmiss.dao.face;

import java.util.List;

import user.dogmiss.dto.Comment;
import user.dogmiss.dto.DogMiss;



public interface CommentDao {

	
	public void insertComment(Comment comment);
	
	public List<Comment> selectComment(DogMiss viewBoard);
	
	
	/**
	 * 댓글 삭제하기
	 * 
	 * @param comment - 삭제할 댓글
	 */
	public void deleteComment(Comment comment);

	/**
	 * 댓글 카운트 - 댓글 존재 여부 확인
	 * 
	 * @param comment - 존재 여부 체크 대상 댓글
	 * @return int - 댓글 갯수
	 */
	public int countComment(Comment comment);
}
