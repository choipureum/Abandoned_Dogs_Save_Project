package user.member.dao.impl;

import java.sql.Connection;

import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import user.member.dao.face.MemberDao;
import user.member.dto.MemberAddDTO;
import user.member.dto.MemberDTO;
import user.qna.dto.QNA;

import util.JDBCTemplate;
import util.Paging;

public class MemberDaoImpl implements MemberDao{
   
   private Connection conn = null; //db 연결객체
   private PreparedStatement ps= null; //sql 수행객체
   private ResultSet rs = null; //결과집합
   
   //nextval userno - 이제 안쓸거같은데
   @Override
   public int selectNextUserno() {
      conn= JDBCTemplate.getConnection();
      String sql = "select member_seq.nextval from dual";
      
      int nextval=0; // 조회 시퀀스
      
      try {
         ps= conn.prepareStatement(sql);
         rs=ps.executeQuery();
         
         while(rs.next()) {
            nextval=rs.getInt("nextval");
         }
      } catch (SQLException e) {
         // TODO Auto-generated catch block
         e.printStackTrace();
      } finally{
         
         try {
            if(rs!=null) rs.close();
            if(ps!=null) ps.close();
         } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
         }
         
      }     
      return nextval;
   }

   //회원가입
   @Override
   public int insert(MemberDTO member) {
      
      conn=JDBCTemplate.getConnection();
      String sql="insert into member(userid, userpw, username, useremail, useraddress, usertel, userbirth) values(?,?,?,?,?,?,?)";
      int result = 0 ;
      
      try {
         ps=conn.prepareStatement(sql);
         
         ps.setString(1, member.getUserid());
         ps.setString(2, member.getUserpw());
         ps.setString(3, member.getUsername());
         ps.setString(4, member.getUseremail());
         ps.setString(5, member.getUseraddress());
         ps.setString(6, member.getUsertel());
         ps.setString(7, member.getUserbirth());

         result = ps.executeUpdate();
         
      } catch (SQLException e) {
         // TODO Auto-generated catch block
         e.printStackTrace();
      } finally {
         try {
            if(ps!=null) ps.close();
         } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
         }
      }
      return result;
   }

   //userid 와 userpw 
   @Override
   public int selectCntMemberByUseridUserpw(MemberDTO member) {
	   
	   //db연결객체
	   conn = JDBCTemplate.getConnection();
	   
		//SQL 작성
		String sql = "";
		sql += "SELECT count(*) FROM member";
		sql += " WHERE 1=1";
		sql += "	AND userid = ?";
		sql += "	AND userpw = ?";
		
		//결과 저장 변수
		int cnt = -1;
		
		try {
			ps=conn.prepareStatement(sql);
			
			ps.setString(1, member.getUserid());
			ps.setString(2, member.getUserpw());
			
			rs=ps.executeQuery(); //sql 수행
			
			while(rs.next()) {
				cnt=rs.getInt(1);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			//DB객체 닫기
			JDBCTemplate.close(rs);
			JDBCTemplate.close(ps);
		}
		//결과 반환
		return cnt;
   }

   //로그인시 userid
   @Override
   public MemberDTO selectMemberByUserid(MemberDTO member) {

	   //db 연결 객체
	   conn = JDBCTemplate.getConnection();
	   
	   String sql ="select * from member where 1=1 and userid=?";
	   
	   MemberDTO result = null;
	   
	   try {
		ps=conn.prepareStatement(sql);
		
		ps.setString(1, member.getUserid());
		
		rs=ps.executeQuery(); //결과 집합
		
		while(rs.next()) {
			result=new MemberDTO();
			
			result.setUserid(rs.getString("userid"));
			result.setUserpw(rs.getString("userpw"));
			
		}
	} catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}finally {
		//DB객체 닫기
		JDBCTemplate.close(rs);
		JDBCTemplate.close(ps);
	}
	   return result;
   }
   

   @Override
//   전체조회
   public MemberDTO selectInfoAllByUserid(MemberDTO member) {

	   //db 연결 객체
	   conn = JDBCTemplate.getConnection();
	   
	   String sql ="select * from member where 1=1 and userid=?";
	   
	   MemberDTO result = null;
	   
	   try {
		ps=conn.prepareStatement(sql);
		
		ps.setString(1, member.getUserid());
		
		rs=ps.executeQuery(); //결과 집합
		
		while(rs.next()) {
			result=new MemberDTO();
			
			result.setUserid(rs.getString("userid"));
			result.setUserpw(rs.getString("userpw"));
			result.setUsername(rs.getString("username"));
			result.setUsertel(rs.getString("usertel"));
			result.setUseremail(rs.getString("useremail"));
			result.setUserbirth(rs.getString("userbirth"));
			result.setUseraddress(rs.getString("useraddress"));
			result.setUsergrade(rs.getInt("usergrade"));
			result.setUserregdate(rs.getDate("userregdate"));
			
		}
	} catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}finally {
		//DB객체 닫기
		JDBCTemplate.close(rs);
		JDBCTemplate.close(ps);
	}
	   return result;
   }

   //중복체크 할때 아이디 중복체크
   public int registerCheck(String userid) {
	   //db 연결 객체
	   conn = JDBCTemplate.getConnection();
	   
	   String sql = "select * from member where userid=?";
	   
	   try {
		   ps=conn.prepareStatement(sql);
		   ps.setString(1, userid);
		   
		   rs=ps.executeQuery();
		   if(!userid.equals("")) {
			   if(rs.next()) {
				   return 0; // 이미 존재하는 회원
			   } else {
				   return 1; //가입 가능한 회원 아이디 
		   } 
		  
		   }else {
			   return 2;
		   }
			   
		   
	} catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	} finally {
		JDBCTemplate.close(rs);
		JDBCTemplate.close(ps);
	}
	   return -1; //데이터베이스 오류 발생
	   
   }  
   //userid 찾기 / username과 useremail통해서 userid 찾기
   
   @Override
   public String findid(String username, String useremail) {
	   
	 //db 연결 객체
	   conn = JDBCTemplate.getConnection();
	   
	   String sql = "select userid from member where username=? and useremail=?";

	   String userid = "";
	   try {
		 //
		ps=conn.prepareStatement(sql);
		ps.setString(1, username);
		ps.setString(2, useremail);
		rs=ps.executeQuery();
			
		while(rs.next()) {
			userid = rs.getString("userid");
		} 
	} catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	} finally {
		JDBCTemplate.close(rs);
		JDBCTemplate.close(ps);
	}  
	   return userid; //실패
   }

   //userpw 체크 확인 사항
   @Override
   public int findpw(String userid, String useremail, String username) {
	   
	   conn = JDBCTemplate.getConnection();	   
	   String sql = "select count(*) from member where userid=? and useremail=? and username=?";
	   
	   try {
		   
		   ps=conn.prepareStatement(sql);
		   
		   ps.setString(1, userid);
		   ps.setString(2, useremail);
		   ps.setString(3, username);
		   
		   rs=ps.executeQuery();

		   while(rs.next()){
			   System.out.println(rs.getInt(1));
			   if(rs.getInt(1)==1) {			   
				   return 1; // 존재하니깐 비밀번호 재설정 가능
			   } else {
				   return 0; //alert 할 부분 
			   }
		   }		   
	   } catch (SQLException e) {
		// TODO Auto-generated catch block
		   e.printStackTrace();
	   } finally {
		   JDBCTemplate.close(rs);
		   JDBCTemplate.close(ps);
	   }
	   return -1; //데이터베이스 오류 발생

   }
//   비밀번호 재설정
   @Override
   public void changpassword(String userpw, String userid) {
	   
	   conn=JDBCTemplate.getConnection();
	   
	   String sql ="update member set userpw=? where userid=?";
	   
	   try {

		
		ps=conn.prepareStatement(sql);
		ps.setString(1, userpw);
		ps.setString(2, userid);
		
		ps.executeUpdate();
		
		
	} catch (SQLException e) {
		
		e.printStackTrace();
	} finally {
		   JDBCTemplate.close(ps);
	}
	  
   }
   
   
   //paging객체를 생성하기 위한 총 totalCount를 반환하는 메소드//dog, dogfile, userlike를 join 할 것이므로
   //dog의 전체 totalCount를 가져와도 상관이 없을거다
   public int selectCntAll() {
		
		conn = JDBCTemplate.getConnection(); //DB 연결
		
		//수행할 SQL
		String sql = "";
		sql += "SELECT ";
		sql += "	count(*)";
		sql += " FROM dog";

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
	}//selectCntAll end
   
   
	//paging객체를 전달받아 rnum을 생성하고 시작과 끝을 정함//where조건으로 검색어를 넣어서 반환 
	public List<MemberAddDTO> selectAll(Paging paging) {
		
		conn =JDBCTemplate.getConnection(); //DB 연결
		
//		//수행할 SQL
//		String sql = "";
//		sql += "SELECT * FROM (";
//		sql += "    SELECT rownum rnum, B.* FROM (";
//		sql += "        SELECT";
//		sql += "            qnano, qnatitle, qnacontent,"; 
//		sql += "            qnahit, qnadate, qnawriter";
//		sql += "        FROM qna";
//		sql += "        ORDER BY qnano DESC";
//		sql += "    ) B";
//		sql += "    ORDER BY rnum";
//		sql += " ) BOARD";
//		sql += " WHERE rnum BETWEEN ? AND ?";
		
		
		String sql = "";
		sql +=   "select * from (select rownum rnum, e.* from";
		sql +=  "(select c.dogNo,c.dogName,c.dogKind, c.dogGender, c.dogNeu,  c.dogDate, c.dogImg, c.shelterNo, c.dogEndDate,";
		sql +=  "c.dog_fileNo, c.dog_org_FILE_NAME, c.dog_stored_FILE_NAME, c.dog_FILE_SIZE, c.dog_DEL_GB, d.userid, d.adoptsw, d.applysw from";
		sql +=  "(select a.dogNo,a.dogName,a.dogKind, a.dogGender, a.dogNeu,  a.dogDate, a.dogImg, a.shelterNo, a.dogEndDate,";
		sql +=  "b.dog_fileNo, b.dog_org_FILE_NAME, b.dog_stored_FILE_NAME, b.dog_FILE_SIZE, b.dog_DEL_GB";
		sql +=  "from dog a, dog_file b where a.dogno = b.dogno)c , userlike d";
		sql +=  "where c.dogno = d.dogno order by c.dogno desc) e)";  
		sql +=  "WHERE rnum BETWEEN ? AND ?";
		
		
		
		
		
		
		List<MemberAddDTO> list = new ArrayList();
		
		try {
			//SQL 수행 객체
			ps = conn.prepareStatement(sql);
			
			
			ps.setInt(1, paging.getStartNo());
			ps.setInt(2, paging.getEndNo());
			
			//SQL 수행 및 결과 저장
			rs = ps.executeQuery();
			
			//SQL 수행 결과 처리
			while( rs.next() ) {
				MemberAddDTO board = new MemberAddDTO();
				
				board.setAdoptsw( rs.getString("adoptsw") );
				board.setApplysw( rs.getInt("applysw") );
				board.setDog_DEL_GB( rs.getString("dog_DEL_GB") );
				board.setDog_FILE_SIZE( rs.getInt("dog_FILE_SIZE") );
				board.setDog_fileNo(rs.getInt("dog_fileNo") );
				board.setDog_org_FILE_NAME( rs.getString("dog_org_FILE_NAME") );
				board.setDog_stored_FILE_NAME( rs.getString("dog_stored_FILE_NAME") );
				board.setDogDate( rs.getDate("dogDate") );
				board.setDogEndDate( rs.getDate("dogEndDate") );
				board.setDogGender( rs.getString("dogGender") );
				board.setDogImg( rs.getString("dogImg") );
				board.setDogKind( rs.getString("dogKind") );
				board.setDogName( rs.getString("dogName") );
				board.setDogNeu( rs.getString("dogNeu") );
				board.setDogNo( rs.getInt("dogNo") );
				board.setShelterNo( rs.getInt("shelterNo") );
				board.setUserid( rs.getString("userid") );
				
				
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

   //마이페이지 수정

   @Override
   public int modifyMypage(MemberDTO member) {
	
	   conn= JDBCTemplate.getConnection();
	   
	   String sql = "update member set userpw=?, usertel=?,  userbirth=?, useremail=?, useraddress=? where userid=?";
	   int result = 0 ;
	   
	   try {
		ps=conn.prepareStatement(sql);
		
		ps.setString(1, member.getUserpw());
		ps.setString(2, member.getUsertel());
		ps.setString(3, member.getUserbirth());
		ps.setString(4, member.getUseremail());
		ps.setString(5, member.getUseraddress());
		ps.setString(6, member.getUserid());
		
		result = ps.executeUpdate();
		
	} catch (SQLException e) {
		e.printStackTrace();
	} finally {
		JDBCTemplate.close(ps);
	}
	   return result;   
   }

   //탈퇴버튼 멤버 삭제
   @Override
   public void memberDelete(String userid) {
	   
	   conn = JDBCTemplate.getConnection();
	   
	   String sql = "delete from member where userid=?";
	   
	   try {
		ps=conn.prepareStatement(sql);
		ps.setString(1, userid);
		
		ps.executeUpdate();
		
	} catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	} finally {
		JDBCTemplate.close(ps);
	}
   }
}
