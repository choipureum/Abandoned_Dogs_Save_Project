package user.member.dao.impl;

import java.sql.Connection;
import java.util.*;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import admin.dto.Dogout;
import user.dog.dto.Dog_Data;
import user.dog.dto.UserLike;
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
			result.setUsergrade(rs.getString("usergrade"));
			
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
			result.setUsergrade(rs.getString("usergrade"));
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
   		public int selectCntAll(String userid) {
		
		conn = JDBCTemplate.getConnection(); //DB 연결
		
		//수행할 SQL
//		String sql = "";
//		sql += " SELECT ";
//		sql += " count(*)";
//		sql += " FROM dog";
		
		
		String sql = "";
		sql += "  SELECT o.*, c.userid, p.dog_fileno";
		sql += "  FROM dog o";
		sql += "  LEFT OUTER JOIN userlike c ON o.dogno = c.dogno";
		sql += "  LEFT OUTER JOIN dog_file p ON o.dogno = p.dogno";
		sql += "  WHERE";
		sql += "  c.userid = 'member04'";

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
		
//		   String sql = " ";
//	       sql +=  "	select * from (select rownum rnum, e.* from"; 
//	       sql +=  "	(";
//	       sql +=  "	select"; 
//	       sql +=  "	a.dogno, a.dogname,a.dogkind,a.doggender, a.dogNeu, a.dogDate, a.dogImg, a.shelterNo, a.dogEndDate,";
//	       sql +=  "	b.dog_fileNo, b.dog_org_FILE_NAME,b.dog_stored_FILE_NAME,b.dog_FILE_SIZE,b.dog_DEL_GB,";
//	       sql +=  "	c.userid,c.adoptsw,c.applysw";
//	       sql +=  "	from";
//	       sql +=  "	dog a, dog_file b, userlike c";
//	       sql +=  "	where a.dogno = b.dogno";
//		   sql +=  "	and   a.dogno = c.dogno order by a.dogno";
//	       sql +=  "	) e"; 
//	       sql +=  "	order by rnum )"; 
//	       sql +=  "	WHERE rnum BETWEEN ? AND ?";
		  
//		String sql = " ";
//	       sql +=  "	select * from (select rownum rnum, e.* from"; 
//	       sql +=  "	(";
//	       sql +=  "	select"; 
//	       sql +=  "	a.dogno, a.dogname,a.dogkind,a.doggender, a.dogNeu, a.dogDate, a.dogImg, a.shelterNo, a.dogEndDate,";
//	       sql +=  "	b.dog_fileNo, b.dog_org_FILE_NAME,b.dog_stored_FILE_NAME,b.dog_FILE_SIZE,b.dog_DEL_GB,";
//	       sql +=  "	c.userid,c.adoptsw,c.applysw";
//	       sql +=  "	from";
//	       sql +=  "	dog a, dog_file b, userlike c";
//	       sql +=  "	where a.dogno = b.dogno";
//		   sql +=  "	and   a.dogno = c.dogno order by a.dogno";
//	       sql +=  "	) e"; 
//	       sql +=  "	order by rnum )"; 
//	       sql +=  "	WHERE rnum BETWEEN ? AND ?";
		
		String sql = "";
		sql += "  select * from (select rownum rnum, e.* from";
		sql += "  (SELECT o.*, p.dog_fileNo, p.dog_org_FILE_NAME, p.dog_stored_FILE_NAME, p.dog_FILE_SIZE, p.dog_DEL_GB, c.applysw, c.adoptsw, c.userid ";
		sql += "  FROM dog o";
		sql += "  LEFT OUTER JOIN userlike c ON o.dogno = c.dogno";
		sql += "  LEFT OUTER JOIN dog_file p ON o.dogno = p.dogno";
		sql += "  WHERE";
		sql += "  c.userid = 'member04') e order by rnum)" ;
		sql += "  WHERE rnum BETWEEN ? AND ?";

		
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
   
   @Override
   public int modifyMypageNotAdd(MemberDTO member) {
	
	   conn= JDBCTemplate.getConnection();
	   
	   String sql = "update member set userpw=?, usertel=?,  userbirth=?, useremail=? where userid=?";
	   int result = 0 ;
	   
	   try {
		ps=conn.prepareStatement(sql);
		
		ps.setString(1, member.getUserpw());
		ps.setString(2, member.getUsertel());
		ps.setString(3, member.getUserbirth());
		ps.setString(4, member.getUseremail());
		ps.setString(5, member.getUserid());
		
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
   
   

	@Override
	// 찜목록 리스트.jsp에서 체크된 강아지 파일을 삭제하는 기능 
	public void deleteMemberFileList(String names){
		
		conn = JDBCTemplate.getConnection(); //DB 연결

		String sql = "DELETE FROM dog_file WHERE dogno IN ( "+names+" )";
		
		try {
			ps = conn.prepareStatement(sql);
			
			ps.executeUpdate();
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				if(ps!=null)	ps.close();
				
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}//deleteMemberFileList end 
	
	
	//// 찜목록 리스트.jsp에서 체크된 강아지 리스트을 삭제하는 기능 
	 public void deleteMemberList(String names) {
		 
		conn = JDBCTemplate.getConnection(); //DB 연결

		String sql = "DELETE FROM dog WHERE dogno IN ( "+names+" )";
			
			try {
				ps = conn.prepareStatement(sql);
				
				ps.executeUpdate();
				
			} catch (SQLException e) {
				e.printStackTrace();
			} finally {
				try {
					if(ps!=null)	ps.close();
					
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
		 
		 
		 
	 }//deleteMemberList end 
	 
	 
	 	//// 찜목록 리스트.jsp에서 체크된 강아지 리스트을 삭제하는 기능 
	 	public void deleteUserlikeList(String names) {
		 
		 conn = JDBCTemplate.getConnection(); //DB 연결

			String sql = "DELETE FROM userlike WHERE dogno IN ( "+names+" )";
				
				try {
					ps = conn.prepareStatement(sql);
					
					ps.executeUpdate();
					
				} catch (SQLException e) {
					e.printStackTrace();
				} finally {
					try {
						if(ps!=null)	ps.close();
						
					} catch (SQLException e) {
						e.printStackTrace();
					}
				}
		 
		 
		 
	 }//deleteUserlikeList end
	   @Override
		public List<UserLike> LikeSelectByid(String userid) {
			List<UserLike> list = new ArrayList<>();
		   conn = JDBCTemplate.getConnection();
			StringBuffer sql = new StringBuffer();
			sql.append("Select * From userlike where userid=? ");
						
			
			try {
				ps=conn.prepareStatement(sql.toString());
				ps.setString(1, userid);
				rs=ps.executeQuery();
				
				while(rs.next()) {
					UserLike like = new UserLike();
					like.setDogno(rs.getInt("dogno"));
					like.setUserid(userid);
					like.setAdoptsw(rs.getString("adoptsw"));
					like.setApplysw(rs.getInt("applysw"));
					list.add(like);
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
	  		   
		   return list;
		}
	
	  
	@Override
	public Dog_Data dogSelectBydogno(int dogno) {
		conn = JDBCTemplate.getConnection();
		String sql="";    	 
		sql += "SELECT * FROM (SELECT dogno, dogname, dogkind, doggender, dogneu, dogdate, shelterno, dogimg";
		sql += "		FROM dog";
		sql += "		ORDER BY dogdate";
		sql += "	) B, ";
		sql += "   (SELECT";
		sql += "   dogno, dog_fileno, dog_org_file_name, dog_stored_file_name, dog_file_size, dog_del_gb";
		sql += "   FROM dog_file ";
		sql +="    )R ";
		sql +="    where B.dogno = R.dogno ";
		sql+= " and R.dogno=?";
		Dog_Data d= new Dog_Data();
		Date today= new Date();
		
		try {
			ps= conn.prepareStatement(sql);
			ps.setInt(1, dogno);
			rs=ps.executeQuery();
			
			while(rs.next()) {
				d.setDogno(rs.getInt("dogno"));
				d.setDogname(rs.getString("dogname"));
				d.setDogkind( rs.getString("dogkind") );
				d.setDoggender( rs.getString("doggender") );
				d.setDogneu( rs.getString("dogneu") );
				d.setDogdate( rs.getDate("dogdate") );
				d.setDogimg( rs.getString("dogimg") );
				d.setShelterno( rs.getInt("shelterno") );
				//공고일 구하기 남은 일수
			  	long diffDay=0;		    
			    //두날짜 사이의 시간 차이(ms)를 하루 동안의 ms(24시*60분*60초*1000밀리초) 로 나눈다.
				diffDay = (today.getTime() - d.getDogdate().getTime()) / (24*60*60*1000);
				diffDay= 10-diffDay;							
			    d.setDogenddate(diffDay);			
				d.setDog_fileno( rs.getInt("dog_fileno") );				
				d.setDog_org_file_name( rs.getString("dog_org_file_name") );
				d.setDog_stored_file_name( rs.getString("dog_stored_file_name") );
				d.setDog_file_size( rs.getDouble("dog_file_size") );
				d.setDog_del_gb( rs.getString("dog_del_gb") );			
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return d;
		}
	
	/**
	 * userid를 통해서 회원 삭제 
	 * deletedogmiss / deleteqna / DeleteQna_File /DeleteDogMiss_File
	 */
	@Override
		public void DeleteDogMiss(String userid) {
			conn = JDBCTemplate.getConnection();
			String sql="delete from qna where userid=? ";
			try {
				ps=conn.prepareStatement(sql);
				ps.setString(1, userid);
				ps.executeUpdate();
				
			} catch (SQLException e) {
				e.printStackTrace();
			}finally {
				JDBCTemplate.close(ps);
			}
			
	}
	@Override
			public void DeleteQna(String userid) {
			conn = JDBCTemplate.getConnection();
				String sql="delete from dog_miss where userid=? ";
				try {
					ps=conn.prepareStatement(sql);
					ps.setString(1, userid);
					ps.executeUpdate();
					
				} catch (SQLException e) {
					e.printStackTrace();
				}finally {
					JDBCTemplate.close(ps);
				}
		
			}
	@Override
		public void DeleteQna_File(String userid) {
		conn = JDBCTemplate.getConnection();
		String sql="delete from qna_file where userid=? ";
		try {
			ps=conn.prepareStatement(sql);
			ps.setString(1, userid);
			ps.executeUpdate();
			
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			JDBCTemplate.close(ps);
		}
		}
@Override
	public void DeleteDogMiss_File(String userid) {
	conn = JDBCTemplate.getConnection();
	String sql="delete from dog_miss_file where userid=? ";
	try {
		ps=conn.prepareStatement(sql);
		ps.setString(1, userid);
		ps.executeUpdate();
		
	} catch (SQLException e) {
		e.printStackTrace();
	}finally {
		JDBCTemplate.close(ps);
	}
	}


	
//	@SuppressWarnings("null")
	@Override
	public Dogout myPageDogOut(String userid) {
	
		conn=JDBCTemplate.getConnection();

		String sql= "select * from dogout where userid=?";
		
		Dogout result =null;

		   
<<<<<<< HEAD
		try {			
			ps=conn.prepareStatement(sql);			
			ps.setString(1, userid);			
=======
		try {
			ps=conn.prepareStatement(sql);
			
			ps.setString(1, userid);
			
>>>>>>> branch 'master' of https://github.com/choipureum/-Abandoned_Dogs_Save_Project.git
			rs=ps.executeQuery(); //결과 집합
			
			while(rs.next()) {
				
<<<<<<< HEAD
				result=new Dogout();				
				result.setUserid(userid);
=======
>>>>>>> branch 'master' of https://github.com/choipureum/-Abandoned_Dogs_Save_Project.git
				result.setDogname(rs.getString("dogname"));
				result.setDogkind(rs.getString("dogkind"));
				result.setDoggender(rs.getString("doggender"));
				result.setOutdate(rs.getDate("outdate"));
				result.setDog_stored_file_name(rs.getString("dog_stored_file_name"));
<<<<<<< HEAD
=======
				
>>>>>>> branch 'master' of https://github.com/choipureum/-Abandoned_Dogs_Save_Project.git
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
public void InsertUserlike(String userid, int dogno) {
	// TODO Auto-generated method stub
	
<<<<<<< HEAD
	@Override
		public void DeleteUserlike(String userid, int dogno) {
			conn = JDBCTemplate.getConnection();
			String sql="delete from userlike where userid=? and dogno=? ";
			try {
				ps=conn.prepareStatement(sql);
				ps.setString(1, userid);
				ps.setInt(2, dogno);
				ps.executeUpdate();
				
			} catch (SQLException e) {
				e.printStackTrace();
		}
	}
=======
}

@Override
public void DeleteUserlike(String userid, int dogno) {
	// TODO Auto-generated method stub
>>>>>>> branch 'master' of https://github.com/choipureum/-Abandoned_Dogs_Save_Project.git
	
<<<<<<< HEAD
	@Override
		public void InsertUserlike(String userid, int dogno) {
			conn = JDBCTemplate.getConnection();
			String sql="insert into userlike(userid,dogno,adoptsw,applysw) values(?,?,'N',0) ";

			try {
				ps=conn.prepareStatement(sql);
				ps.setString(1, userid);
				ps.setInt(2, dogno);
				ps.executeUpdate();
				
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	@Override
		public int UserlikeCount(String userid, int dogno) {
			conn= JDBCTemplate.getConnection();
			String sql="select * from userlike where userid=? and dogno=? ";
			int res=0;
			
			try {
				ps=conn.prepareStatement(sql);
				ps.setString(1, userid);
				ps.setInt(2, dogno);
				rs= ps.executeQuery();
				
				if(rs.next()) {				
				res=1;
			}
				
			} catch (SQLException e) {
				e.printStackTrace();
			
		}
			return res;
	}
=======
}

	
	
	

>>>>>>> branch 'master' of https://github.com/choipureum/-Abandoned_Dogs_Save_Project.git

}
