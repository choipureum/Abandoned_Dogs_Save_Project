package user.qna.dao.impl;


import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;


import user.qna.dao.face.QnaDao;
import user.qna.dto.QNA;
import user.qna.dto.QnaFile;
import util.JDBCTemplate;
import util.Paging;




public class QnaDaoImpl implements QnaDao {

	private Connection conn = null;
	
	private PreparedStatement ps = null;
	private ResultSet rs = null;
	
	@Override
//	public List selectAll() {
//		
//		conn = JDBCTemplate.getConnection(); //DB 연결
//		
//		//수행할 SQL
//		String sql = "";
//		sql += "SELECT ";
//		sql += "	qnano";
//		sql += "	, qnatitle";
//		sql += "	, id";
//		sql += "	, content";
//		sql += "	, hit";
//		sql += "	, writtendate";
//		sql += " FROM board";
//		sql += " ORDER BY boardno DESC";
//		
//		//최종 결과를 저장할 List
//		List list = new ArrayList();
//		
//		try {
//			//SQL 수행 객체
//			ps = conn.prepareStatement(sql);
//			
//			//SQL 수행 및 결과 저장
//			rs = ps.executeQuery();
//			
//			//SQL 수행 결과 처리
//			while( rs.next() ) {
//				QNA board = new QNA();
//				
//				board.setBoardno( rs.getInt("boardno") );
//				board.setTitle( rs.getString("title") );
//				board.setId( rs.getString("id") );
//				board.setContent( rs.getString("content") );
//				board.setHit( rs.getInt("hit") );
//				board.setWrittendate( rs.getDate("writtendate") );
//				
//				list.add(board);
//			}
//			
//		} catch (SQLException e) {
//			e.printStackTrace();
//		} finally {
//			try {
//				if(rs!=null)	rs.close();
//				if(ps!=null)	ps.close();
//			} catch (SQLException e) {
//				e.printStackTrace();
//			}
//		}
//		
//		//최종 결과 반환
//		return list;
//	}
	
	
	//paging객체를 전달받아 rnum을 생성하고 시작과 끝을 정함//where조건으로 검색어를 넣어서 반환 
	public List selectAll(Paging paging) {
		
		conn =JDBCTemplate.getConnection(); //DB 연결
		
		//수행할 SQL
		String sql = "";
		sql += "SELECT * FROM (";
		sql += "    SELECT rownum rnum, B.* FROM (";
		sql += "        SELECT";
		sql += "            qnano, qnatitle, qnacontent,"; 
		sql += "            qnahit, qnadate, qnawriter";
		sql += "        FROM qna";
		sql += "		WHERE qnatitle LIKE '%'||?||'%'"; 
		sql += "        ORDER BY qnano DESC";
		sql += "    ) B";
		sql += "    ORDER BY rnum";
		sql += " ) BOARD";
		sql += " WHERE rnum BETWEEN ? AND ?";
		
		
		//최종 결과를 저장할 List
		List list = new ArrayList();
		
		try {
			//SQL 수행 객체
			ps = conn.prepareStatement(sql);
			
			ps.setString(1, paging.getSearch());
			ps.setInt(2, paging.getStartNo());
			ps.setInt(3, paging.getEndNo());
			
			//SQL 수행 및 결과 저장
			rs = ps.executeQuery();
			
			//SQL 수행 결과 처리
			while( rs.next() ) {
				QNA board = new QNA();
				
				board.setQnaNO( rs.getInt("qnano") );
				board.setQnaTitle( rs.getString("qnatitle") );
				board.setQnaContent( rs.getString("qnacontent") );
				board.setQnaHit( rs.getInt("qnahit") );
				board.setQnaDate( rs.getDate("qnaDate") );
				board.setQnaWriter( rs.getString("qnawriter") );
				
				list.add(board);
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				if(rs!=null)	rs.close();
				if(ps!=null)	ps.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		
		//최종 결과 반환
		return list;
	}//end
	
	@Override
	public int selectCntAll() {
		
		conn = JDBCTemplate.getConnection(); //DB 연결
		
		//수행할 SQL
		String sql = "";
		sql += "SELECT ";
		sql += "	count(*)";
		sql += " FROM board";

		//최종 결과 변수
		int cnt = 0;
		
		try {
			//SQL 수행 객체
			ps = conn.prepareStatement(sql);
			
			//SQL 수행 및 결과 저장
			rs = ps.executeQuery();
			
			//SQL 수행 결과 처리
			while( rs.next() ) {
				cnt = rs.getInt(1);
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				if(rs!=null)	rs.close();
				if(ps!=null)	ps.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		
		//최종 결과 반환
		return cnt;
	}
	
	@Override
	//검색어 파라미터를 전달 받아 검색어에해당하는 테이블의 수를 count해서 반환 
	public int selectCntAll(String search) {
		
		conn =JDBCTemplate.getConnection(); //DB 연결
		
		//수행할 SQL
		String sql = "";
		sql += "SELECT ";
		sql += "	count(*)";
		sql += " FROM qna";
		sql += " WHERE qnatitle LIKE '%'||?||'%'";

		//최종 결과 변수
		int cnt = 0;
		
		try {
			//SQL 수행 객체
			ps = conn.prepareStatement(sql);
			
			
			//?에 검색어 저장 
			ps.setString(1, search);

			//SQL 수행 및 결과 저장
			rs = ps.executeQuery();
			
			//SQL 수행 결과 처리
			while( rs.next() ) {
				cnt = rs.getInt(1);
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				if(rs!=null)	rs.close();
				if(ps!=null)	ps.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		
		//최종 결과 반환//검색어가 들어간 것의 수를 반환 
		return cnt;
	}
	
	@Override
	//게시글 조회수 1 증가시키기 
	public void updateHit(QNA viewBoard) {
		
		conn = JDBCTemplate.getConnection(); //DB 연결

		//게시글 조회수 증가 쿼리
		String sql = "";
		sql+="UPDATE qna";
		sql+=" SET qnahit = qnahit + 1";
		sql+=" WHERE qnano = ?";
	
		try {
			ps = conn.prepareStatement(sql);
			
			ps.setInt(1, viewBoard.getQnaNO());
			
			ps.executeUpdate();
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				// 자원 해제
				if(ps!=null)	ps.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
				
	}//end

	@Override
	//qnano이있는 빈객체를 전달받아 qnano에 해당하는 객체를 반환 
	public QNA selectBoardByBoardno(QNA viewBoard) {

		conn = JDBCTemplate.getConnection(); //DB 연결

		//게시글 조회쿼리
		String sql = "";
		sql += "SELECT ";
		sql += "	qnano";
		sql += "	, qnatitle";
		sql += "	, qnacontent";
		sql += "	, qnahit";
		sql += "	, qnadate";
		sql += "	, qnawriter";
		sql += " FROM qna B";
		sql += " WHERE qnano = ?";
	
		try {
			ps = conn.prepareStatement(sql);
			
			ps.setInt(1, viewBoard.getQnaNO());
			
			rs = ps.executeQuery();
			
			while( rs.next() ) {
				
				viewBoard.setQnaNO( rs.getInt("qnano") );
				viewBoard.setQnaTitle( rs.getString("qnatitle") );
				viewBoard.setQnaContent( rs.getString("qnacontent") );
				viewBoard.setQnaHit( rs.getInt("qnahit") );
				viewBoard.setQnaDate( rs.getDate("qnadate") );
				viewBoard.setQnaWriter( rs.getString("qnawriter") );
				
				
			}

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				// 자원 해제
				if(rs!=null)	rs.close();
				if(ps!=null)	ps.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
				
		return viewBoard;
		
	}//end
	
	@Override
	//write.jsp로 부터 전달받은 파라미터를 저장 
	public void insert(QNA board) {
		
		conn =JDBCTemplate.getConnection(); //DB 연결

		//다음 게시글 번호 조회 쿼리
		String sql = "";
		sql += "INSERT INTO qna(qnano,qnatitle,qnacontent,qnahit,qnadate,qnawriter) ";
		sql += " VALUES (?, ?, ?, 0, sysdate,?)";
		
		try {
			//DB작업
			ps = conn.prepareStatement(sql);
			ps.setInt(1, board.getQnaNO());
			ps.setString(2, board.getQnaTitle());
			ps.setString(3, board.getQnaContent());
			ps.setString(4, board.getQnaWriter());

			ps.executeUpdate();
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				//DB객체 닫기
				if(ps!=null)	ps.close();
				
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}//end
	
	@Override
	//게시글 번호 반환
	public int selectBoardno() {
		
		conn = JDBCTemplate.getConnection(); //DB 연결

		//다음 게시글 번호 조회 쿼리
		String sql = "";
		sql += "SELECT qna_seq.nextval";
		sql += " FROM dual";
		
		//게시글번호
		int boardno = 0;
		
		try {
			//DB작업
			ps = conn.prepareStatement(sql);
			rs = ps.executeQuery();
			
			//결과 담기
			while(rs.next()) {
				boardno = rs.getInt(1);
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				//DB객체 닫기
				if(rs!=null)	rs.close();
				if(ps!=null)	ps.close();
				
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		
		//게시글 번호 반환
		return boardno;
	}//end


	@Override
	//파일 업데이트 
	public void insertFile(QnaFile boardFile) {
		
		conn = JDBCTemplate.getConnection(); //DB 연결

		//다음 게시글 번호 조회 쿼리
		String sql = "";
		sql += "INSERT INTO qna_File(qnano,qna_fileno,qna_org_file_name,qna_stored_file_name,qna_file_size,qna_del_gb) ";
		sql += " VALUES (?,qna_file_seq.nextval, ?, ?, ?, ?)";
		
		try {
			//DB작업
			ps = conn.prepareStatement(sql);
			ps.setInt(1, boardFile.getQnaNo());
			ps.setString(2, boardFile.getQna_org_FILE_NAME());
			ps.setString(3, boardFile.getQna_stored_FILE_NAME());
			ps.setDouble(4, boardFile.getQna_FILE_SIZE());
			ps.setString(5, boardFile.getQna_DEL_GB());

			ps.executeUpdate();
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				//DB객체 닫기
				if(ps!=null)	ps.close();
				
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}//end

	@Override
	//qnano 이 들어있는 객체를 전달받음 
	public QnaFile selectFile(QNA board) {
		
		conn = JDBCTemplate.getConnection(); //DB 연결

		//다음 게시글 번호 조회 쿼리
		String sql = "";
		sql += "SELECT * FROM qna_file";
		sql += " WHERE qnano = ?";
		
		QnaFile boardFile = new QnaFile();
		
		try {
			//DB작업
			ps = conn.prepareStatement(sql);
			ps.setInt(1, board.getQnaNO());

			rs = ps.executeQuery();
			
			while(rs.next()) {
			
				boardFile.setQnaNo( rs.getInt("qnano") );
				boardFile.setQna_fileNo( rs.getInt("qna_fileno") );
				boardFile.setQna_org_FILE_NAME( rs.getString("qna_org_file_name") );
				boardFile.setQna_stored_FILE_NAME( rs.getString("qna_stored_file_name") );
				boardFile.setQna_FILE_SIZE( rs.getDouble("qna_file_size") );
				boardFile.setQna_DEL_GB( rs.getString("qna_del_gb") );
				
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				//DB객체 닫기
				if(ps!=null)	ps.close();
				if(rs!=null)	rs.close();
				
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		
		return boardFile;
	}//end
	
	@Override
	public QnaFile selectByFileno(int fileno) {
		
		conn = JDBCTemplate.getConnection(); //DB 연결

		//다음 게시글 번호 조회 쿼리
		String sql = "";
		sql += "SELECT * FROM qna_file";
		sql += " WHERE qna_fileno = ?";
		
		//DB 객체
		PreparedStatement ps = null; 
		ResultSet rs = null;
		
		QnaFile boardFile = new QnaFile();
		
		try {
			//DB작업
			ps = conn.prepareStatement(sql);
			ps.setInt(1, fileno);

			rs = ps.executeQuery();
			
			while(rs.next()) {
			
				boardFile.setQna_fileNo( rs.getInt("qna_fileno") );
				boardFile.setQnaNo( rs.getInt("qnano") );
				boardFile.setQna_org_FILE_NAME( rs.getString("qna_org_file_name") );
				boardFile.setQna_stored_FILE_NAME( rs.getString("qna_stored_file_name") );
				boardFile.setQna_FILE_SIZE( rs.getDouble("qna_file_size") );
				boardFile.setQna_DEL_GB( rs.getString("qna_del_gb") );
				
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				//DB객체 닫기
				if(ps!=null)	ps.close();
				if(rs!=null)	rs.close();
				
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		
		return boardFile;
	}
	
	@Override
	//객체를 전달받아 업데이트 
	public void update(QNA board) {
//		System.out.println(board);
		
		//다음 게시글 번호 조회 쿼리
		String sql = "";
		sql += "UPDATE qna";
		sql += " SET qnatitle = ?,";
		sql += " 	qnacontent = ?";
		sql += " WHERE qnano = ?";
		
		//DB 객체
		PreparedStatement ps = null; 
		
		try {
			//DB작업
			ps = conn.prepareStatement(sql);
			ps.setString(1, board.getQnaTitle());
			ps.setString(2, board.getQnaContent());
			ps.setInt(3, board.getQnaNO());

			ps.executeUpdate();
			
		} catch (SQLException e) {
			e.printStackTrace();
			
		} finally {
			try {
				//DB객체 닫기
				if(ps!=null)	ps.close();
				
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}//end
	
	
//	public String selectNickByUserid(QNA board) {
//		
//		conn = JDBCTemplate.getConnection(); //DB 연결
//
//		//다음 게시글 번호 조회 쿼리
//		String sql = "";
//		sql += "SELECT usernick FROM member";
//		sql += " WHERE userid = ?";
//		
//		//DB 객체
//		PreparedStatement ps = null; 
//		ResultSet rs = null;
//		
//		String usernick = null;
//		
//		try {
//			//DB작업
//			ps = conn.prepareStatement(sql);
//			ps.setString(1, board.getId());
//
//			rs = ps.executeQuery();
//			
//			while(rs.next()) {
//				usernick = rs.getString("usernick");
//			}
//			
//		} catch (SQLException e) {
//			e.printStackTrace();
//		} finally {
//			try {
//				//DB객체 닫기
//				if(ps!=null)	ps.close();
//				if(rs!=null)	rs.close();
//				
//			} catch (SQLException e) {
//				e.printStackTrace();
//			}
//		}
//		
//		return usernick;
//	}
	
	@Override
	//qnano이 있는 객체를 전달받아 
	public void delete(QNA board) {
		
		conn = JDBCTemplate.getConnection(); //DB 연결

		//다음 게시글 번호 조회 쿼리
		String sql = "";
		sql += "DELETE qna";
		sql += " WHERE qnano = ?";
		
		//DB 객체
		PreparedStatement ps = null; 
		
		try {
			//DB작업
			ps = conn.prepareStatement(sql);
			ps.setInt(1, board.getQnaNO());

			ps.executeUpdate();
			
		} catch (SQLException e) {
			e.printStackTrace();
			
		} finally {
			try {
				//DB객체 닫기
				if(ps!=null)	ps.close();
				
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}//end
	
	@Override
	//qnano이 있는 객체를 전달받아 삭제 함 
	public void deleteFile(QNA board) {
		
		conn = JDBCTemplate.getConnection(); //DB 연결

		//다음 게시글 번호 조회 쿼리
		String sql = "";
		sql += "DELETE qna_file";
		sql += " WHERE qnano = ?";
		
		//DB 객체
		PreparedStatement ps = null; 
		
		try {
			//DB작업
			ps = conn.prepareStatement(sql);
			ps.setInt(1, board.getQnaNO());

			ps.executeUpdate();
			
		} catch (SQLException e) {
			e.printStackTrace();
			
		} finally {
			try {
				//DB객체 닫기
				if(ps!=null)	ps.close();
				
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}//end
	
}

	

