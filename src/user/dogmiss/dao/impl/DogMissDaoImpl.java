package user.dogmiss.dao.impl;

import java.sql.Connection;



import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;


import user.dogmiss.dao.face.DogMissDao;
import user.dogmiss.dto.DogMiss;
import user.dogmiss.dto.DogMissAdd;
import user.dogmiss.dto.DogMissFile;
import util.JDBCTemplate;
import util.Paging;





public class DogMissDaoImpl implements DogMissDao {
	

	private Connection conn = null; //DB연결 객체
	private PreparedStatement ps = null; //SQL수행 객체
	private ResultSet rs = null; //SQL조회 결과 객체
	
	
	@Override
	//게시글의 전체 숫자를 가져와서 페이징 객체를 생성한다 
//	public List<DogMiss> selectAll() {
//		//DB연결 객체
//				conn = JDBCTemplate.getConnection();
//				
//				//SQL 작성
//				String sql = "";
//				sql += "SELECT * FROM dog_miss";
//				sql += " ORDER BY missno DESC";
//				
//				//결과 저장할 List
//				List<DogMiss> missList = new ArrayList<>();
//				
//				try {
//					ps = conn.prepareStatement(sql); //SQL수행 객체
//					
//					rs = ps.executeQuery(); //SQL 수행 및 결과집합 저장
//					
//					//조회 결과 처리
//					while(rs.next()) {
//						DogMiss miss = new DogMiss(); //결과값 저장 객체
//						
//						qna.setQnaNO( rs.getInt("qnano") );
//						qna.setQnaTitle( rs.getString("qnatitle") );
//						qna.setQnaContent( rs.getString("qnacontent") );
//						qna.setQnaHit( rs.getInt("qnahit"));
//						qna.setQnaDate( rs.getDate("qnadate") );
//						qna.setQnaWriter( rs.getString("qnawriter") );
//					
//						//리스트에 결과값 저장
//						qnaList.add(qna);
//					}
//					
//				} catch (SQLException e) {
//					e.printStackTrace();
//				} finally {
//					//DB객체 닫기
//					JDBCTemplate.close(rs);
//					JDBCTemplate.close(ps);
//				}
//				
//				//최종 결과 반환
//				return qnaList;
//			}
	
	public int selectNextUserno() {

		  

		  conn = JDBCTemplate.getConnection(); //DB 연결

		  

		  String sql = "";

		  sql += "SELECT qna_seq.nextval FROM dual";

		  

		  int nextval = 0; //조회된 시퀀스 값(nextval)

		  

		  try {

		   ps = conn.prepareStatement(sql); //SQL수행객체 생성

		   

		   rs = ps.executeQuery(); //SQL쿼리 수행 및 결과 반환

		   

		   rs.next();

		   

		//   nextval = rs.getInt(1);

		   nextval = rs.getInt("nextval");

		   

		  } catch (SQLException e) {

		   e.printStackTrace();

		  } finally {

		   try {

		    //자원 해제

		    if(rs!=null) rs.close();

		    if(ps!=null) ps.close();

		   } catch (SQLException e) {

		    e.printStackTrace();

		   }

		  }

		  

		  return nextval;

		 }
	
	

//	 public void insert(QNA qna) {
//
//	  
//
//	  conn = JDBCTemplate.getConnection(); //DB 연결
//
//	  
//	 
//	  
//	  
//	  
//
//	  String sql = "";
//
//	  sql += "INSERT INTO qna (qnano, qnatitle, qnacontent, qnahit, qnadate, qnaimg, qnawriter)";
//
//	  sql += " VALUES ( ?, ?, ?, 0, sysdate,?,? )";
//
//	  
//
//	  try {
//
//	   ps = conn.prepareStatement(sql); //SQL수행객체 생성
//
//	   
//
//	   ps.setInt(1, qna.getQnaNO());
//	   
//	   ps.setString(2, qna.getQnaTitle());
//
//	   ps.setString(3, qna.getQnaContent());
//
//	   ps.setString(4, qna.getQnaImg());
//
//	   ps.setString(5, qna.getQnaWriter());
//
//
//	   ps.executeUpdate(); //SQL쿼리 수행
//
//	   
//
//	  } catch (SQLException e) {
//
//	   e.printStackTrace();
//
//	  } finally {
//
//	   try {
//
//	    //자원 해제
//
//	    if(ps!=null) ps.close();
//
//	   } catch (SQLException e) {
//
//	    e.printStackTrace();
//
//	   }
//
//	  }
//
//	 }

	@Override
	//게시글의 전체 숫자를 가져와서 페이징 객체를 생성한다 
	public int selectCntAll() {//ok
		
			
			//DB연결 객체
			conn = JDBCTemplate.getConnection();
			
			//SQL 작성
			String sql = "";
			sql += "SELECT count(*) FROM dog_miss";
			
			//결과 저장할 변수
			int totalCount = 0;
			
			try {
				ps = conn.prepareStatement(sql); //SQL수행 객체
				
				rs = ps.executeQuery(); //SQL 수행 및 결과집합 저장
				
				//조회 결과 처리
				while(rs.next()) {
					totalCount = rs.getInt(1);
				}
				
			} catch (SQLException e) {
				e.printStackTrace();
			} finally {
				//DB객체 닫기
				JDBCTemplate.close(rs);
				JDBCTemplate.close(ps);
			}
			
			//최종 결과 반환
			return totalCount;
			
		}//selectCNTall 끝 
	
	
		//stratnum과 endnum에 해당하는 게시글 만 가져옮
		public List<DogMissAdd> selectAll(Paging paging) {
		
		//DB연결 객체
		conn = JDBCTemplate.getConnection();
		
		//SQL 작성
		String sql = "select * from"; 
		sql += "(SELECT * FROM (SELECT rownum rnum, B.* FROM (SELECT missno, missname, misskind, missgender, missdate, missimg, missloc, misstitle, misscontent, misswriter, misshit";
		sql += "		FROM dog_miss WHERE misskind LIKE '%'||?||'%'";
		sql += "		ORDER BY missno DESC";
		sql += "	) B";
		sql += "    ) BOARD";
		sql += "    WHERE rnum BETWEEN ? AND ?) A ,";
		sql += "   (SELECT";
		sql += "   missno, miss_fileno, miss_org_file_name, miss_stored_file_name, miss_file_size, miss_del_gb";
		sql += "   FROM (" ;
		sql += "   SELECT DMF.* ,row_number() over( partition by missno order by miss_fileno desc ) od  FROM dog_miss_file DMF ";
		sql +="    )R WHERE od = 1) B";
		sql +="    where A.missno = B.missno ";
		
		
		
		
		
		
		
		
		
		
		
		
		
		
//		String sql = "";
//		sql += "SELECT * FROM (";
//		sql += "    SELECT rownum rnum, B.* FROM (";
//		sql += "        SELECT";
//		sql += "            qnano, qnatitle, qnacontent,"; 
//		sql += "            qnahit, qnadate, qnawriter";
//		sql += "        FROM qna";
//		sql += "		WHERE qnatitle LIKE '%'||?||'%'"; 
//		sql += "        ORDER BY qnano DESC";
//		sql += "    ) B";
//		sql += "    ORDER BY rnum";
//		sql += " ) BOARD";
//		sql += " WHERE rnum BETWEEN ? AND ?";
//		
//		
//		//최종 결과를 저장할 List
//		List list = new ArrayList();
//		
//		try {
//			//SQL 수행 객체
//			ps = conn.prepareStatement(sql);
//			
//			ps.setString(1, paging.getSearch());
//			ps.setInt(2, paging.getStartNo());
//			ps.setInt(3, paging.getEndNo());
//		
		
		
		
		
				
//		SELECT 
//	    missno
//	    , miss_fileno
//	    , miss_org_file_name
//	    , miss_stored_file_name
//	    , miss_file_size
//	    , miss_del_gb
//	FROM (
//	    SELECT
//	        DMF.*
//	        , row_number() over( partition by missno order by miss_fileno desc ) od
//	    FROM dog_miss_file DMF
//	) R
//	WHERE od = 1;
//		
		
		
		
		
		
		
		
		//결과 저장할 List
		List<DogMissAdd> missList = new ArrayList<>();
		
		try {
			ps = conn.prepareStatement(sql); //SQL수행 객체
			
			ps.setString(1, paging.getSearch());
			ps.setInt(2, paging.getStartNo());
			ps.setInt(3, paging.getEndNo());
			
			rs = ps.executeQuery(); //SQL 수행 및 결과집합 저장
			
			//조회 결과 처리
			while(rs.next()) {
				DogMissAdd b = new DogMissAdd(); //결과값 저장 객체
				
				b.setMissNO( rs.getInt("missno") );
				b.setMissName( rs.getString("missname") );
				b.setMissKind( rs.getString("misskind") );
				b.setMissGender( rs.getString("missgender"));
				b.setMissDate( rs.getDate("missdate") );
				b.setMissImg( rs.getString("missimg") );
				b.setMissLoc( rs.getString("missloc") );
				b.setMissTitle( rs.getString("misstitle") );
				b.setMissContent( rs.getString("misscontent") );
				b.setMissWriter( rs.getString("misswriter") );
				b.setMissHit( rs.getInt("misshit") );
				
				b.setMiss_fileNO( rs.getInt("miss_fileno") );
				
				
				b.setMiss_org_FILE_NAME( rs.getString("miss_org_file_name") );
				b.setMiss_stored_FILE_NAME( rs.getString("miss_stored_file_name") );
				b.setMiss_FILE_SIZE( rs.getDouble("miss_file_size") );
				b.setMiss_DEL_GB( rs.getString("miss_del_gb") );
				
				
				//리스트에 결과값 저장
				missList.add(b);
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			//DB객체 닫기
			JDBCTemplate.close(rs);
			JDBCTemplate.close(ps);
		}
		
		//최종 결과 반환
		return missList;
	}//selectAll end
		
		

	public DogMiss selectBoardByMissno(DogMiss missno) {
	
	//DB연결 객체
	conn = JDBCTemplate.getConnection();
	
	//SQL 작성
	String sql = "";
	sql += "SELECT * FROM dog_miss";
	sql += " WHERE missno = ?";
	
	//결과 저장할 Board객체
	DogMiss b = null;
	
	try {
		ps = conn.prepareStatement(sql); //SQL수행 객체
		
		ps.setInt(1, missno.getMissNO()); //조회할 게시글 번호 적용
		
		rs = ps.executeQuery(); //SQL 수행 및 결과집합 저장
		
		//조회 결과 처리
		while(rs.next()) {
			b = new DogMiss(); //결과값 저장 객체
			
			b.setMissNO( rs.getInt("missno") );
			b.setMissName( rs.getString("missname") );
			b.setMissKind( rs.getString("misskind") );
			b.setMissGender( rs.getString("missgender"));
			b.setMissDate( rs.getDate("missdate") );
			b.setMissImg( rs.getString("missimg") );
			b.setMissLoc( rs.getString("missloc") );
			b.setMissTitle( rs.getString("misstitle") );
			b.setMissContent( rs.getString("misscontent") );
			b.setMissWriter( rs.getString("misswriter") );
			b.setMissHit( rs.getInt("misshit") );
			
		}
		
	} catch (SQLException e) {
		e.printStackTrace();
	} finally {
		//DB객체 닫기
		JDBCTemplate.close(rs);
		JDBCTemplate.close(ps);
	}
	
	//최종 결과 반환
	return b;
}//end

	
	//리스트 목록에서 클릭한 객체의 조회수를 증가시키는 메소드
	public void updateHit(DogMiss missno) {
	
	//DB연결 객체
	conn = JDBCTemplate.getConnection();
	
	//SQL 작성
	String sql = "";
	sql += "UPDATE dog_miss";
	sql += " SET missHit = missHit + 1";
	sql += " WHERE missno = ?";
	
	
	try {
		ps = conn.prepareStatement(sql); //SQL수행 객체
		
		ps.setInt(1, missno.getMissNO()); //조회할 게시글 번호 적용
		
		ps.executeUpdate(); //SQL 수행
		
	} catch (SQLException e) {
		e.printStackTrace();
	} finally {
		//DB객체 닫기
		JDBCTemplate.close(ps);
	}
	
}//end

	//missno에 해당하는 파일객체 가져오기 
	public DogMissFile selectFile(DogMiss Board) {
	
	//DB연결 객체
	conn = JDBCTemplate.getConnection();
	
	//SQL 작성
	String sql = "";
	sql += "select * from dog_miss_file where miss_fileno = (SELECT max(miss_fileno) FROM dog_miss_file WHERE missno = ? )";
	
	
	
	
	
	//결과 저장할 BoardFile 객체
	DogMissFile missfile = null;
	
	try {
		ps = conn.prepareStatement(sql); //SQL수행 객체
		
		ps.setInt(1, Board.getMissNO()); //조회할 boardno 적용
		
		rs = ps.executeQuery(); //SQL 수행 및 결과집합 저장
		
		//조회 결과 처리
		while(rs.next()) {
			 missfile = new DogMissFile();
	
			missfile.setMissNo( rs.getInt("missno") );
			missfile.setMiss_fileNO( rs.getInt("miss_fileno") );
			missfile.setMiss_org_FILE_NAME( rs.getString("miss_org_file_name") );
			missfile.setMiss_stored_FILE_NAME( rs.getString("miss_stored_file_name") );
			missfile.setMiss_FILE_SIZE( rs.getDouble("miss_file_size") );
			missfile.setMiss_DEL_GB( rs.getString("miss_del_gb") );
			
		}
		
	} catch (SQLException e) {
		e.printStackTrace();
	} finally {
		//DB객체 닫기
		JDBCTemplate.close(rs);
		JDBCTemplate.close(ps);
	}
	
	//최종 결과 반환
	return missfile;
	
}//end
	
	
		public DogMissFile viewFM(DogMissFile FM) {
		
		conn = JDBCTemplate.getConnection();
		
		
		String sql = "select * from dog_miss_file where miss_fileno = (SELECT max(miss_fileno) FROM dog_miss_file WHERE missno = ? )";
		
		
		
		
		//결과 저장할 BoardFile 객체
		DogMissFile boardFile = null;
		
		try {
			ps = conn.prepareStatement(sql); //SQL수행 객체
			
			ps.setInt(1, FM.getMissNo()); //조회할 boardno 적용
			
			rs = ps.executeQuery(); //SQL 수행 및 결과집합 저장
			
			//조회 결과 처리
			while(rs.next()) {			
				boardFile = new DogMissFile();
				
				boardFile.setMiss_fileNO( rs.getInt("miss_fileno") );
				boardFile.setMissNo( rs.getInt("missno") );
				boardFile.setMiss_org_FILE_NAME( rs.getString("miss_org_file_name") );
				boardFile.setMiss_stored_FILE_NAME( rs.getString("miss_stored_file_name") );
				boardFile.setMiss_FILE_SIZE( rs.getDouble("miss_file_size") );
				boardFile.setMiss_DEL_GB( rs.getString("miss_del_gb") );
				
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			//DB객체 닫기
			JDBCTemplate.close(rs);
			JDBCTemplate.close(ps);
		}
		
		
		return FM;
	};
	
	
	
		
		//게시글을 write한 후에 게시글에 대한 missno 생성  
		public int selectBoardno() {
		
		//DB연결 객체
		conn = JDBCTemplate.getConnection();
		
		//SQL 작성
		String sql = "";
		sql += "SELECT dog_miss_seq.nextval FROM dual";
		
		//결과 저장할 변수
		int boardno = 0;
		
		try {
			ps = conn.prepareStatement(sql); //SQL수행 객체
			
			rs = ps.executeQuery(); //SQL 수행 및 결과집합 저장
			
			//조회 결과 처리
			while(rs.next()) {
				boardno = rs.getInt(1);
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			//DB객체 닫기
			JDBCTemplate.close(rs);
			JDBCTemplate.close(ps);
		}
		
		//최종 결과 반환
		return boardno;
	}//end
	

		public void insert(DogMiss board) {
			
			conn = JDBCTemplate.getConnection(); //DB 연결

			//다음 게시글 번호 조회 쿼리
			String sql = "";
			sql += "INSERT INTO dog_miss(missno,missname,misskind,missgender,missdate,missimg,missloc,misstitle,misscontent,misswriter,misshit) ";
			sql += " VALUES (?,?,?,?,sysdate,?,?,?,?,?, 0)";
			
			try {
				//DB작업
				ps = conn.prepareStatement(sql);

				ps.setInt(1, board.getMissNO());
				ps.setString(2, board.getMissName());
				ps.setString(3, board.getMissKind());
				ps.setString(4, board.getMissGender());
				ps.setString(5, board.getMissImg());
				ps.setString(6, board.getMissLoc());
				ps.setString(7, board.getMissTitle());
				ps.setString(8, board.getMissContent());
				ps.setString(9, board.getMissWriter());


				ps.executeUpdate();
				
			} catch (SQLException e) {
				e.printStackTrace();
			} finally {
				JDBCTemplate.close(ps);
			}
		}//inser end

		@Override
		//받아온 파일 파일 db에 저장 
		public void insertFile(DogMissFile boardFile) {
			
			
			
			
			
			conn = JDBCTemplate.getConnection(); //DB 연결

			//다음 게시글 번호 조회 쿼리
			String sql = "";
			sql += "INSERT INTO dog_miss_file(missno,miss_fileno,miss_org_file_name, miss_stored_file_name, miss_file_size,miss_del_gb)";
			sql += " VALUES ( ?, dog_miss_file_seq.nextval, ?, ?, ?, ? )";
			
			try {
				//DB작업
				ps = conn.prepareStatement(sql);

				ps.setInt(1, boardFile.getMissNo());
				ps.setString(2, boardFile.getMiss_org_FILE_NAME());
				ps.setString(3, boardFile.getMiss_stored_FILE_NAME());
				ps.setDouble(4, boardFile.getMiss_FILE_SIZE());
				ps.setString(5, boardFile.getMiss_DEL_GB());

				ps.executeUpdate();
				
			} catch (SQLException e) {
				e.printStackTrace();
			} finally {
				JDBCTemplate.close(ps);
			}
		}//inserfile end 
		
		
		
		
			public void delete(DogMiss board) {
			
			//DB연결 객체
			conn = JDBCTemplate.getConnection();

			//다음 게시글 번호 조회 쿼리
			String sql = "";
			sql += "DELETE dog_miss";
			sql += " WHERE missno = ?";
			
			//DB 객체
			PreparedStatement ps = null; 
			
			try {
				//DB작업
				ps = conn.prepareStatement(sql);
				ps.setInt(1, board.getMissNO());

				ps.executeUpdate();
				
			} catch (SQLException e) {
				e.printStackTrace();
				
			} finally {
				JDBCTemplate.close(ps);
			}
		}
		
		
		
		
			
			
			
			
		
		
		
		
		
		
		
		@Override
		public void deleteFile(DogMiss board) {
			
			//DB연결 객체
			conn = JDBCTemplate.getConnection();

			//다음 게시글 번호 조회 쿼리
			String sql = "";
			sql += "DELETE dog_miss_file";
			sql += " WHERE missno = ?";
			
			//DB 객체
			PreparedStatement ps = null; 
			
			try {
				//DB작업
				ps = conn.prepareStatement(sql);
				ps.setInt(1, board.getMissNO());

				ps.executeUpdate();
				
			} catch (SQLException e) {
				e.printStackTrace();
				
			} finally {
				JDBCTemplate.close(ps);
			}
		}
		public void update(DogMiss board) {

			//DB연결 객체
			conn = JDBCTemplate.getConnection();

			//다음 게시글 번호 조회 쿼리
			String sql = "";
			sql += "UPDATE dog_miss";
			sql += " SET missname=?,misskind=?,missgender=?,missimg=?,missloc=?, misstitle = ?,";
			sql += " 	misscontent = ? ";
			sql += " WHERE missno = ?";
			
			//DB 객체
			PreparedStatement ps = null; 
			
			try {
				//DB작업
				ps = conn.prepareStatement(sql);
				ps.setString(1, board.getMissName());
				ps.setString(2, board.getMissKind());
				ps.setString(3, board.getMissGender());
				ps.setString(4, board.getMissImg());
				ps.setString(5, board.getMissLoc());
				ps.setString(6, board.getMissTitle());
				ps.setString(7, board.getMissContent());
				ps.setInt(8, board.getMissNO());

				ps.executeUpdate();
				
			} catch (SQLException e) {
				e.printStackTrace();
				
			} finally {
				JDBCTemplate.close(ps);
			}
		}


//		public List<DogMissAdd> joinList(DogMiss list) {
//			
//			//DB연결 객체
//			conn = JDBCTemplate.getConnection();
//			
//			List<DogMissAdd> listt = new ArrayList<>();
//			
//			
//			String sql = null; 
//			
//			DogMissAdd missAdd = null;
//			
//			
//			try {
//				
//				while(rs.next()) {	
//					
//					
//					missAdd = new DogMissAdd();
//					
//					missAdd.setMiss_fileNO( rs.getInt("miss_fileno") );
//					missAdd.setMissNo( rs.getInt("missno") );
//					missAdd.setMiss_org_FILE_NAME( rs.getString("miss_org_file_name") );
//					missAdd.setMiss_stored_FILE_NAME( rs.getString("miss_stored_file_name") );
//					missAdd.setMiss_FILE_SIZE( rs.getDouble("miss_file_size") );
//					missAdd.setMiss_DEL_GB( rs.getString("miss_del_gb") );
//					
//					missAdd.setMissName( rs.getString("missname") );
//					missAdd.setMissKind( rs.getString("misskind") );
//					missAdd.setMissGender( rs.getString("missgender"));
//					missAdd.setMissDate( rs.getDate("missdate") );
//					missAdd.setMissImg( rs.getString("missimg") );
//					missAdd.setMissLoc( rs.getString("missloc") );
//					missAdd.setMissTitle( rs.getString("misstitle") );
//					missAdd.setMissContent( rs.getString("misscontent") );
//					missAdd.setMissWriter( rs.getString("misswriter") );
//					missAdd.setMissHit( rs.getInt("misshit") );
//					
//					listt.add(missAdd);
//					
//				}	
//				
//				
//				
//			} catch (Exception e2) {
//				
//			}
//			
//			
//			
//			
//			
//			
//			
//			
//			
//			
//			
//			
//			
//			
//		
//			
//			
//			
//			
//			
//			return null;
//		};
//	
		public int selectCntAll(String search) {
			
			conn =JDBCTemplate.getConnection(); //DB 연결
			
			//수행할 SQL
			String sql = "";
			sql += "SELECT ";
			sql += "	count(*)";
			sql += " FROM dog_miss";
			sql += " WHERE misskind LIKE '%'||?||'%'";

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


}