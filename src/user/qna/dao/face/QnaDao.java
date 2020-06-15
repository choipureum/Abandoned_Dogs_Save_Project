package user.qna.dao.face;

import java.util.List;

import user.qna.dto.QNA;



public interface QnaDao {
	
	public List<QNA> selectAll();
}
