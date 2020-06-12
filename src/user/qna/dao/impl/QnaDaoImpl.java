package user.qna.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import user.qna.dao.face.QnaDao;
import user.qna.dto.QNA;
import util.JDBCTemplate;


public class QnaDaoImpl implements QnaDao {
	
	private Connection conn = null; //DB연결 객체
	private PreparedStatement ps = null; //SQL수행 객체
	private ResultSet rs = null; //SQL조회 결과 객체
	
	
	@Override
	public List<QNA> selectAll() {
		//DB연결 객체
				conn = JDBCTemplate.getConnection();
				
				//SQL 작성
				String sql = "";
				sql += "SELECT * FROM QNA";
				sql += " ORDER BY QNANO DESC";
				
				//결과 저장할 List
				List<QNA> qnaList = new ArrayList<>();
				
				try {
					ps = conn.prepareStatement(sql); //SQL수행 객체
					
					rs = ps.executeQuery(); //SQL 수행 및 결과집합 저장
					
					//조회 결과 처리
					while(rs.next()) {
						QNA qna = new QNA(); //결과값 저장 객체
						
						qna.setQnaNO( rs.getInt("qnano") );
						qna.setQnaTitle( rs.getString("qnatitle") );
						qna.setQnaContent( rs.getString("qnacontent") );
						qna.setQnaHit( rs.getInt("qnahit"));
						qna.setQnaDate( rs.getDate("qnadate") );
						qna.setQnaImg( rs.getString("qnaimg") );
						qna.setQnaWriter( rs.getString("qnawriter") );
																		
						//리스트에 결과값 저장
						qnaList.add(qna);
					}
					
				} catch (SQLException e) {
					e.printStackTrace();
				} finally {
					//DB객체 닫기
					JDBCTemplate.close(rs);
					JDBCTemplate.close(ps);
				}
				
				//최종 결과 반환
				return qnaList;
			}

		

}
