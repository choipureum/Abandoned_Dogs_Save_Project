package user.qna.service.impl;

import java.util.List;

import user.qna.dao.face.QnaDao;
import user.qna.dao.impl.QnaDaoImpl;
import user.qna.dto.QNA;
import user.qna.service.face.QnaService;


public class QnaServiceImpl implements QnaService {
	
	private QnaDao qnaDao = new QnaDaoImpl();
	@Override
	public List<QNA> getList() {
		
		
		return qnaDao.selectAll();
			
		}
		
}
