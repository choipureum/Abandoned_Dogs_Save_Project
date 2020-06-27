package admin.dao.impl;

import util.Paging;
import java.sql.*;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.HashMap;
import java.util.List;
import java.util.TreeMap;

import admin.dao.face.AdminMemberListDao;
import admin.dto.DogClaimDTO;
import user.dog.dto.DogDTO;
import user.dog.dto.Dog_Data;
import user.dog.dto.Dog_File_DTO;
import user.dog.dto.UserLike;
import user.dogmiss.dto.DogMissAdd;
import user.member.dto.MemberDTO;
import user.qna.dto.QNA;
import user.qna.dto.Qna_Reply;
import util.JDBCTemplate;

public class AdminMemberListDaoImpl implements AdminMemberListDao{
	 	private Connection conn =null;
	    private PreparedStatement ps =null;
	    private ResultSet rs=null;
	     
	    //sql StringBuffer
	    //String하면 안됨, opt조건에 따라서 append 함수로 where문 추가
    	private StringBuffer sql;
	    //인스탠스
	    private static AdminMemberListDaoImpl instance;
	    
	    //접근을 막는 private 생성자
	    private AdminMemberListDaoImpl(){}
	    
	    //null값일때 instance 생성 가능 메소드
	    public static AdminMemberListDaoImpl getInstance(){
	        if(instance==null)
	            instance=new AdminMemberListDaoImpl();
	        return instance;
	    }
	    
	   /**
	    * 회원 조회 - 검색, 필터, 정렬에 따라( 전체,선택 조회)
	    * 
	    */
	    public List<MemberDTO> select(HashMap <String,Object> listOpt,Paging paging){	  
	    	
	    	conn= JDBCTemplate.getConnection();
	    	
	    	String grade = (String)listOpt.get("grade"); //검색옵션, 회원등급
	    	String opt = (String)listOpt.get("opt"); // 검색옵션(아이디,이름, 휴대폰번호등..)
	        String condition = (String)listOpt.get("condition"); // 검색내용
	        
	        //sql 객체 새로생성
	        sql=new StringBuffer();
	    	
	    	//반환 객체 List 생성
	    	List <MemberDTO> list = new ArrayList<>();

	    	sql.append("SELECT * FROM (");      
	    	sql.append(" SELECT rownum rnum, B.* FROM (");
	    	sql.append(" SELECT");
	    	sql.append(" userid,username, userTel, userEmail, userBirth, userAddress, userGrade, userRegDate");
	    	sql.append(" FROM member");	    		  	
	    		    	
            String search="";
            try {      
	            //grade를 선택안했을 때 where opt만 붙여준다 
		    	if(grade.equals("0")) {
			    	//회원 전체 조회(검색 디폴트값)
			    	if(opt.equals("0")) {	
			    		search="";			    		  		
			    	}
			    	// 정렬조건 - 아이디로 검색
			    	else if(opt.equals("1")) {
			    		search=" where userId=%"+condition+"%";	
			    	}
			    	//정렬조건 - 이름으로 검색
			    	else if(opt.equals("2")) {
			    		search=" where userName=%"+condition+"%";		    		
			    	}
		    	}
		    	//grade가 null이 아닐때
		    	else {
			    	//회원 전체 조회(검색 디폴트값)
		    		if(opt.equals("0")) {
		    			search=" where userGrade=%"+grade+"%";				             		         
			    	}
			    	// 정렬조건 - 아이디로 검색
			    	else if(opt.equals("1")) {
			    		search=" where userGrade=%"+grade+"% and userId=%"+condition+"%";	
			    	}
			    	//정렬조건 - 이름으로 검색
			    	else if(opt.equals("2")) {
			    		search=" where userGrade=%"+grade+"% userName=%"+condition+"%";		    				    		
			    	}
		    	} 
		    	//sql문 완성(정렬조건, 검색조건 충족)	    	
		    	sql.append(search);	 
		    	sql.append(" order by userRegDate)B");
		    	sql.append(" )MEMBER");
		    	sql.append(" WHERE rnum BETWEEN ? AND ?");	
		    	
		    	ps=conn.prepareStatement(sql.toString());
		    	ps.setInt(1, paging.getStartNo());
		    	ps.setInt(2, paging.getEndNo());		    	
		    	rs=ps.executeQuery();
		    	
		    	
		    	while(rs.next()) {
		    		//멤버객체 생성
			    	MemberDTO member =new MemberDTO();
			    	member.setUserid(rs.getString("userid"));
			    	member.setUsername(rs.getString("username"));
			    	member.setUsertel(rs.getString("userTel"));
			    	member.setUseremail(rs.getString("userEmail"));
			    	member.setUserbirth(rs.getString("userBirth"));
			    	member.setUseraddress(rs.getString("userAddress"));	
			    	member.setUsergrade(rs.getString("userGrade"));
			    	member.setUserregdate(rs.getDate("userRegDate"));
			    	list.add(member);
		    	}
            }catch(SQLException e) {
            	e.printStackTrace(); 	
            }finally {
            	JDBCTemplate.close(rs);
            	JDBCTemplate.close(ps);            	           	
            }           
	    	return list;
	    	
	    } //END select
	    
	    /**
	     * 회원 수 카운트 (검색 조건에 따라 다름)
	     */
	    @Override
	    public int getMemberCount(HashMap<String, Object> listOpt) {
	    	   		    	
	    	String grade =(String)listOpt.get("grade"); //등급
	    	String opt = (String)listOpt.get("opt"); // 검색옵션(아이디,이름, 휴대폰번호등..)
	        String condition = (String)listOpt.get("condition"); // 검색내용
	    	
	        //sql 객체 새로생성
	        sql=new StringBuffer();
	        
	        //글개수 카운트 인트값 생성
	        int cnt=0;
	        
	        sql.append("select count(*) from member");
	        String search="";
	        
	        try {
	        	conn=JDBCTemplate.getConnection();
	            //grade를 선택안했을 때 where opt만 붙여준다 
		    	if(grade.equals("0")) {
			    	//회원 전체 조회(검색 디폴트값)
		    		if(opt.equals("0")) {	
			    	 	             			             			             
			    	}
			    	// 정렬조건 - 아이디로 검색
			    	else if(opt.equals("1")) {
			    		search=" where userid like %"+condition+"%";			    					    		
			    	}
			    	//정렬조건 - 이름으로 검색
			    	else if(opt.equals("2")) {
			    		search=" where username like %"+condition+"%";			    					    				    					    		
			    	}
		    	}
		    	//grade가 null이 아닐때
		    	else {
			    	//회원 전체 조회(검색 디폴트값)
		    		if(opt.equals("0")) {
			    		search=" where userGrade like %"+grade+"%";	            		             			          
		    		}
			    	// 정렬조건 - 아이디로 검색
			    	else if(opt.equals("1")) {
			    		search=" where userid like %"+condition+"% and usergrade like %"+grade+"%";
			    	}
			    	//정렬조건 - 이름으로 검색
			    	else if(opt.equals("2")) {
			    		search=" where userid like %"+condition+"% and userGrade like %"+grade+"%";		    				    		
			    	}
		    	} 
		    	sql.append(search);		    		    	
		    	ps = conn.prepareStatement(sql.toString());
		    	//sql 완성	-> 실행	    	
		    	rs=ps.executeQuery();
		    	
		    	//값 반환
		    	if(rs.next()) {
		    		cnt = rs.getInt(1);
		    	}
 	
	        }catch(SQLException e) {
	        	e.getStackTrace();
	        }finally {
	        	JDBCTemplate.close(rs);
	        	JDBCTemplate.close(ps);	        	
	        }	        	
	    	return cnt;
	    } //END getMemberCount
	  
	    /**
	     * 회원 삭제
	     */
	    public int delete(String userid) {
	    	//반환값 int생성
	    	int res=0;
	    	sql=new StringBuffer();
	    	try {
	    		conn=JDBCTemplate.getConnection();
	    		sql.append("delete from member");
	    		sql.append(" where userid=?");
	    		
	    		ps=conn.prepareStatement(sql.toString());
	    		ps.setString(1, userid);
	    		res=ps.executeUpdate();
	    		if(res>0) {
	    			JDBCTemplate.commit(conn);
	    		}
	    	}catch(SQLException e) {
	    		e.printStackTrace();
	    	}finally{
	    		JDBCTemplate.close(ps);
	    	}
  		    	
			return res;
	    	
	    }
	    @Override
	    public MemberDTO selectID(String userid) {
	    	MemberDTO member = new MemberDTO();
	    	conn = JDBCTemplate.getConnection();
	    	
	    	sql=new StringBuffer();	    	
	    	sql.append("select * from member where userid=?");
	    	
	    	try {
				ps=conn.prepareStatement(sql.toString());
				ps.setString(1, userid);
				rs=ps.executeQuery();
				if(rs.next()) {
					member.setUserid(rs.getString("userid"));
			    	member.setUsername(rs.getString("username"));
			    	member.setUsertel(rs.getString("userTel"));
			    	member.setUseremail(rs.getString("userEmail"));
			    	member.setUserbirth(rs.getString("userBirth"));
			    	member.setUseraddress(rs.getString("userAddress"));	
			    	member.setUsergrade(rs.getString("userGrade"));
			    	member.setUserregdate(rs.getDate("userRegDate"));
				}								
			} catch (SQLException e) {
				e.printStackTrace();
			}    	finally {
				JDBCTemplate.close(rs);
				JDBCTemplate.close(ps);
			}
	    	return member;
	    }
	    
	    @Override
	    public List<MemberDTO> selectAll() {
	    	conn = JDBCTemplate.getConnection();
	    	sql=new StringBuffer();
	    	
	    	sql.append("SELECT * FROM member order by userid");
	    	List<MemberDTO> list = new ArrayList<>();
	    	
	    	
	    	try {
				ps= conn.prepareStatement(sql.toString());
				rs=ps.executeQuery();
				
				while(rs.next()) {
					MemberDTO member = new MemberDTO();
					member.setUserid(rs.getString("userid"));
			    	member.setUsername(rs.getString("username"));
			    	member.setUsertel(rs.getString("userTel"));
			    	member.setUseremail(rs.getString("userEmail"));
			    	member.setUserbirth(rs.getString("userBirth"));
			    	member.setUseraddress(rs.getString("userAddress"));	
			    	member.setUsergrade(rs.getString("userGrade"));
			    	member.setUserregdate(rs.getDate("userRegDate"));
			    	list.add(member);			    						
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}   	finally {
				JDBCTemplate.close(rs);
				JDBCTemplate.close(ps);
			}		    	
	    	return list;
	    }
	    // 그래프용
	    @Override
	    public TreeMap<Date, Integer> graphMember() {
	    	TreeMap<Date,Integer> DateMap = new  TreeMap<Date, Integer>();
	    	Calendar calc = Calendar.getInstance();
	    	SimpleDateFormat sb = new SimpleDateFormat("yyyy-MM-dd");
	    	conn = JDBCTemplate.getConnection();
	    	sql=new StringBuffer();
	    	calc.setTime(new Date());
	    	
	    	calc.add(Calendar.DATE, -11);	    	
	    	String minDate = sb.format(calc.getTime()) ;
	    	
	    	calc.add(Calendar.DATE, 11);
	    	String maxDate = sb.format(calc.getTime());
	    	
	    	
	    	sql.append("select * from (select * from member where userregDate<? and userRegDate>?) ");
	    	sql.append(" order by userregDate");
	    	
	    	try {
				Date startDate= sb.parse(minDate);
				Date endDate = sb.parse(maxDate);
				//문자열 날짜
				ArrayList<Date> dates = new ArrayList<Date>();
				Date currentDate= startDate;
				
				while(currentDate.compareTo(endDate)<=0){
					dates.add(sb.parse(sb.format(currentDate)));
					Calendar c = Calendar.getInstance();
					c.setTime(currentDate);
					c.add(Calendar.DAY_OF_MONTH, 1);
					currentDate = c.getTime();
				}
				
				ps =conn.prepareStatement(sql.toString());				
				ps.setString(1,maxDate);
				ps.setString(2,minDate);
				rs = ps.executeQuery();
								
				//해쉬맵에 최저 날짜부터 최대날짜까지 키값설정해주기 -> rs.next에서++;
				for(Date e: dates) {
					DateMap.put(e, 0);
				}
				while(rs.next()) {
					Date Date=sb.parse(rs.getString("userRegDate"));
					DateMap.put(Date,DateMap.getOrDefault(sb.parse(sb.format(rs.getDate("userRegDate"))), 0)+1);					
				}				
			
	    	}catch (SQLException e) {
				e.printStackTrace();
			}catch(ParseException e) {
				e.printStackTrace();
			}finally {
				JDBCTemplate.close(rs);
				JDBCTemplate.close(ps);
			}

	    	return DateMap;
	    }
	    
	    
	    @Override
		public void updateGradeById(String id,String grade) {
	    	conn = JDBCTemplate.getConnection();	    	
	    	sql = new StringBuffer();	    	
	    	sql.append("UPDATE member set usergrade=? where userid=?");
	    	try {
				ps= conn.prepareStatement(sql.toString());
			 	ps.setString(1, grade);
		    	ps.setString(2, id);
		    	ps.executeQuery();
			} catch (SQLException e) {
				e.printStackTrace();
			}finally {
				JDBCTemplate.close(ps);
			}
	
	}
	    @Override
	    public int selectDogNo() {	    	
	    	//DB연결 객체
			conn = JDBCTemplate.getConnection();
			
			//SQL 작성
			String sql = "";
			sql += "SELECT dog_seq.nextval FROM dual";
			
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
	    }
	    
	    
	    @Override
	    public void insertDog(DogDTO dog) {
	    	conn = JDBCTemplate.getConnection();
	    	
	    	String sql = "Insert into dog(dogno, dogname, dogkind, doggender, dogneu, shelterno) values(?, ?,?,?,?,?)";
	    	
	    	try {
				ps=conn.prepareStatement(sql);
				ps.setInt(1, dog.getDogno());
				ps.setString(2, dog.getDogname());
				ps.setString(3, dog.getDogkind());
				ps.setString(4, dog.getDoggender());				
				//null이면 N으로 넣고 아니면 Y처리
				if(dog.getDogneu()==null) {
					ps.setString(5, "N");
				}
				else {
					ps.setString(5, "Y");
				}
				ps.setInt(6, dog.getShelterno());
				ps.executeUpdate();
			} catch (SQLException e) {
				e.printStackTrace();
			} finally {
				JDBCTemplate.close(ps);
			}
	    }
	    
	    @Override
	    public void insertDogFile(Dog_File_DTO dogFile) {

			conn = JDBCTemplate.getConnection(); //DB 연결

			//다음 게시글 번호 조회 쿼리
			String sql = "";
			sql += "INSERT INTO dog_file(dog_fileno, dogno,DOG_ORG_FILE_NAME,DOG_STORED_FILE_NAME, DOG_FILE_SIZE)";
			sql += " VALUES ( dog_file_seq.nextval, ?, ?, ?, ? )";
			
			try {
				//DB작업
				ps = conn.prepareStatement(sql);

				ps.setInt(1, dogFile.getDogno());
				ps.setString(2, dogFile.getDog_org_file_name());
				ps.setString(3, dogFile.getDog_stored_file_name());
				ps.setDouble(4, dogFile.getDog_file_size());
				ps.executeUpdate();
				
			} catch (SQLException e) {
				e.printStackTrace();
			} finally {
				JDBCTemplate.close(ps);
			}
	    }
	    @Override
	    public List <DogClaimDTO> dogClaimSelectAll() {
	    	
	    	List <DogClaimDTO> list = new ArrayList<>();
	    	
	    	conn = JDBCTemplate.getConnection();
	    	sql = new StringBuffer();
	    	 
	    	
	    	sql.append(" select * from dog_claim order by dogregdate");
	    	
	    	try {
				ps=conn.prepareStatement(sql.toString());
			
				rs= ps.executeQuery();
				
				Date today = new Date();
				while(rs.next()) {
					DogClaimDTO dogClaim= new DogClaimDTO();
				    dogClaim.setDogno(rs.getInt("dogno"));
				    dogClaim.setDogkind(rs.getString("dogkind"));
				    dogClaim.setDogname(rs.getString("dogname"));
				    dogClaim.setDoggender(rs.getString("doggender"));
				    dogClaim.setDogneu(rs.getString("dogneu"));
				    dogClaim.setDogshelter(rs.getInt("dogshelter"));
				    dogClaim.setUserid(rs.getString("userid"));
				    dogClaim.setDogregdate(rs.getDate("dogregdate"));
				    //공고일 구하기 남은 일수
				  	long diffDay=0;		    
				    //두날짜 사이의 시간 차이(ms)를 하루 동안의 ms(24시*60분*60초*1000밀리초) 로 나눈다.
					diffDay = (today.getTime() - dogClaim.getDogregdate().getTime()) / (24*60*60*1000);
					diffDay= 10-diffDay;
				    dogClaim.setDogenddate(diffDay);
				    list.add(dogClaim);
	
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}   	
	    	return list;
	    }
	    
	    @Override
	    public int dogClaimCount(HashMap<String,Object> listOpt) {
	    	conn= JDBCTemplate.getConnection();
	    	int res =0;
	    	sql= new StringBuffer();
	    	sql.append("select count(*) from dog_Claim");
	    	 	
	    	try {
				ps= conn.prepareStatement(sql.toString());
				rs=ps.executeQuery();
				
				while(rs.next()) {
					res=rs.getInt(1);
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}finally {
				JDBCTemplate.close(ps);
				JDBCTemplate.close(rs);
			}	    	
	    	return res;
	    }
	    
	    
	    @Override
	    public void dogClaimDelete(String userid) {
	    	conn= JDBCTemplate.getConnection();
	    	
	    	sql= new StringBuffer();
	    	sql.append(" delete from dog_claim where userid=?");
	    	
	    	try {
				ps=conn.prepareStatement(sql.toString());
				ps.setString(1, userid);				
				ps.executeUpdate();
				
												
			} catch (SQLException e) {
				e.printStackTrace();
			}

	    	
	    }
	    @Override
	    public int dogClaimCount() {
	    	conn=JDBCTemplate.getConnection();
	    	sql= new StringBuffer();
	    	sql.append(" select count(*) from dog_Claim");
	    	int cnt=0;
	    	
	    	try {
				ps=conn.prepareStatement(sql.toString());
				rs=ps.executeQuery();
				
				while(rs.next()) {
					cnt=rs.getInt(1);
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}finally {
				JDBCTemplate.close(ps);
				JDBCTemplate.close(rs);
			}	
	    	return cnt;
	    }
	    
	    @Override
	    public int dogCount() {
	    	conn=JDBCTemplate.getConnection();
	    	sql= new StringBuffer();
	    	sql.append(" select count(*) from dog");
	    	int cnt=0;
	    	
	    	try {
				ps=conn.prepareStatement(sql.toString());
				rs=ps.executeQuery();
				
				while(rs.next()) {
					cnt=rs.getInt(1);
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}finally {
				JDBCTemplate.close(ps);
				JDBCTemplate.close(rs);
			}	
	    	return cnt;
	    }
	    
	    @Override
	    public int dogClaimBydognoCount() {
	    	conn=JDBCTemplate.getConnection();
	    	sql= new StringBuffer();
	    	sql.append(" select count(*) from (select dogno from dog_claim group by dogno)");
	    	int cnt=0;
	    	
	    	try {
				ps=conn.prepareStatement(sql.toString());
				rs=ps.executeQuery();
				
				while(rs.next()) {
					cnt=rs.getInt(1);
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}finally {
				JDBCTemplate.close(ps);
				JDBCTemplate.close(rs);
			}	
	    	return cnt;
	   
	    }
	    /**
	     * 입양 신청 불허가에따른 apply sw=2로 치환
	     */
	   @Override
	   public void dogClaimUpdateApplySw(String userid, int dogno) {
		   conn=JDBCTemplate.getConnection();
	    	sql= new StringBuffer();
	    	sql.append(" update userlike set applysw =2 where userid=? and dogno=?");
	    	
	    	try {
				ps=conn.prepareStatement(sql.toString());
				ps.setString(1, userid);
				ps.setInt(2, dogno);
				ps.executeUpdate();
				
			} catch (SQLException e) {
				e.printStackTrace();
			}finally {
				JDBCTemplate.close(ps);
			}	
	    }
	    /**
	     * 
	     * 입양신청 허가에 따른 변동
	     * 	  
	     */
	    //	같은 dogno에 따른 입양신청 전부 삭제
	    @Override
	    public void dogClaimDeleteByDogno(int dogno) {
	    	conn=JDBCTemplate.getConnection();
	    	sql= new StringBuffer();
	    	sql.append(" DELETE FROM dog_claim WHERE dogno=? ");
	    	
	    	try {
				ps=conn.prepareStatement(sql.toString());
				ps.setInt(1, dogno);
				ps.executeUpdate();
				
			} catch (SQLException e) {
				e.printStackTrace();
			}finally {
				JDBCTemplate.close(ps);
			}	
	    }
	    
	    //	입양 신청에따른 dog정보 삭제
	    @Override
	    public void dogDeleteByadmin(int dogno) {
	    	conn=JDBCTemplate.getConnection();
	    	sql= new StringBuffer();
	    	sql.append(" DELETE FROM dog WHERE dogno=? ");
	    	
	    	try {
				ps=conn.prepareStatement(sql.toString());
				ps.setInt(1, dogno);
				ps.executeUpdate();
				
			} catch (SQLException e) {
				e.printStackTrace();
			}finally {
				JDBCTemplate.close(ps);
			}	
	    }
	    //	입양 신청에 따른 userlike 정보 업데이트
	    @Override
	    public void userLikeUpdateByadmin(String userid, int dogno) {
	    	conn=JDBCTemplate.getConnection();
	    	sql= new StringBuffer();
	    	sql.append(" update userlike set adoptsw = 'Y' where userid=? and dogno=?");
	    	
	    	try {
				ps=conn.prepareStatement(sql.toString());
				ps.setString(1, userid);
				ps.setInt(2,dogno);
				ps.executeUpdate();
				
			} catch (SQLException e) {
				e.printStackTrace();
			}finally {
				JDBCTemplate.close(ps);
			}	
	    }
	    @Override
	    public int dogClaimBydogno(int dogno) {
	    	conn=JDBCTemplate.getConnection();
	    	sql= new StringBuffer();
	    	sql.append(" select count(*) from dog_claim where dogno=?  ");
	    	int res=0;
	    	
	    	try {
				ps=conn.prepareStatement(sql.toString());
				ps.setInt(1, dogno);
				rs=ps.executeQuery();
				
				while(rs.next()) {
					res=rs.getInt(1);
				}
				
			} catch (SQLException e) {
				e.printStackTrace();
			}finally {
				JDBCTemplate.close(ps);
				JDBCTemplate.close(rs);
			}	
	    	return res;
	    }
	    @Override
	    public int dognoBydogClaim(String userid) {
	    	conn=JDBCTemplate.getConnection();
	    	sql= new StringBuffer();
	    	sql.append(" select dogno from dog_claim where userid=?  ");
	    	int res=0;
	    	
	    	try {
				ps=conn.prepareStatement(sql.toString());
				ps.setString(1, userid);
				rs=ps.executeQuery();
				
				while(rs.next()) {
					res=rs.getInt(1);
				}				
			} catch (SQLException e) {
				e.printStackTrace();
			}finally {
				JDBCTemplate.close(ps);
				JDBCTemplate.close(rs);
			}	
	    	return res;
	    }
	    @Override
	    public void DeletedognoUserlike(int dogno) {
	    	conn= JDBCTemplate.getConnection();
	    	
	    	sql= new StringBuffer();
	    	sql.append(" delete from userlike where adoptsw='N' and dogno=?");	    	
	    	try {
				ps=conn.prepareStatement(sql.toString());
				ps.setInt(1,dogno);
				ps.executeUpdate();
			} catch (SQLException e) {
				e.printStackTrace();
			}finally {
				JDBCTemplate.close(ps);
			}	    		    		   
	    }
	    
	    
	    /**
	     * 게시판 페이지들
	     * selectAll()함수 집합
	     */	   	    
	  @Override
	    public List<QNA> qnaSelectAll() {
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
					qna.setQnaWriter( rs.getString("qnawriter") );
					qna.setDelsw( rs.getString("delsw") );
				
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
			return qnaList;
	    }  
	    
	  
	    @Override
	    public List<DogMissAdd> dogmissSelectAll() {
	    	conn = JDBCTemplate.getConnection();
	    	String sql = ""; 
			sql += "SELECT * FROM (SELECT missno, missname, misskind, missgender, missdate, missimg, missloc, misstitle, misscontent, misswriter, misshit";
			sql += "		FROM dog_miss";
			sql += "		ORDER BY missno DESC";
			sql += "	) B, ";
			sql += "   (SELECT";
			sql += "   missno, miss_fileno, miss_org_file_name, miss_stored_file_name, miss_file_size, miss_del_gb";
			sql += "   FROM dog_miss_file ";
			sql +="    )R ";
			sql +="    where B.missno = R.missno ";
			
			//결과 저장할 List
			List<DogMissAdd> missList = new ArrayList<>();
			
			try {
				ps = conn.prepareStatement(sql); //SQL수행 객체											
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
										
					missList.add(b);
				}
				
			} catch (SQLException e) {
				e.printStackTrace();
			} finally {
				//DB객체 닫기
				JDBCTemplate.close(rs);
				JDBCTemplate.close(ps);
			}			
			return missList;
    	
	    }
		 @Override
		public List<Dog_Data> dogDataSelectAll() {			
			    	conn = JDBCTemplate.getConnection();
			    	String sql = ""; 
					sql += "SELECT * FROM (SELECT dogno, dogname, dogkind, doggender, dogneu, dogdate, shelterno, dogimg";
					sql += "		FROM dog";
					sql += "		ORDER BY dogdate";
					sql += "	) B, ";
					sql += "   (SELECT";
					sql += "   dogno, dog_fileno, dog_org_file_name, dog_stored_file_name, dog_file_size, dog_del_gb";
					sql += "   FROM dog_file ";
					sql +="    )R ";
					sql +="    where B.dogno = R.dogno ";
					
					//결과 저장할 List
					List<Dog_Data> dogList = new ArrayList<>();
										
					try {
						ps = conn.prepareStatement(sql); //SQL수행 객체											
						rs = ps.executeQuery(); //SQL 수행 및 결과집합 저장
						Date today = new Date();
						//조회 결과 처리
						while(rs.next()) {
							Dog_Data d = new Dog_Data(); //결과값 저장 객체
							
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
												
							dogList.add(d);
						}
						
					} catch (SQLException e) {
						e.printStackTrace();
					} finally {
						//DB객체 닫기
						JDBCTemplate.close(rs);
						JDBCTemplate.close(ps);
					}			
					return dogList;
		    	
		}
	  
	    //--게시판삭제

	    @Override
	    public void QnaDelete(int qnano) {
	    	conn= JDBCTemplate.getConnection();
	    	
	    	sql= new StringBuffer();
	    	sql.append(" delete from qna where qnano=?");	    	
	    	try {
				ps=conn.prepareStatement(sql.toString());
				ps.setInt(1,qnano);
				ps.executeUpdate();
			} catch (SQLException e) {
				e.printStackTrace();
			}finally {
				JDBCTemplate.close(ps);
			}	  
	    }
	    @Override
	    public void dogDelete(int dogno) {
	    	conn= JDBCTemplate.getConnection();
	    	
	    	sql= new StringBuffer();
	    	sql.append(" delete from dog where dogno=?");	    	
	    	try {
				ps=conn.prepareStatement(sql.toString());
				ps.setInt(1,dogno);
				ps.executeUpdate();
			} catch (SQLException e) {
				e.printStackTrace();
			}finally {
				JDBCTemplate.close(ps);
			}	  
	    }
	    @Override
	    public void dogFileDelete(int dogno) {
	    	conn= JDBCTemplate.getConnection();
	    	
	    	sql= new StringBuffer();
	    	sql.append(" delete from dog_file where dogno=?");	    	
	    	try {
				ps=conn.prepareStatement(sql.toString());
				ps.setInt(1,dogno);
				ps.executeUpdate();
			} catch (SQLException e) {
				e.printStackTrace();
			}finally {
				JDBCTemplate.close(ps);
			}	  
	    }
	    
	    @Override
	    public void dogMissDelete(int dogMissno) {
	    	conn= JDBCTemplate.getConnection();
	    	
	    	sql= new StringBuffer();
	    	sql.append(" delete from dog_miss where missno=?");	    	
	    	try {
				ps=conn.prepareStatement(sql.toString());
				ps.setInt(1,dogMissno);
				ps.executeUpdate();
			} catch (SQLException e) {
				e.printStackTrace();
			}finally {
				JDBCTemplate.close(ps);
			}	  
	    }
	    
	    
	    @Override
	    public void dogMissFileDelete(int dogMissno) {
	    	conn= JDBCTemplate.getConnection();
	    	
	    	sql= new StringBuffer();
	    	sql.append(" delete from dog_miss_file where missno=?");	    	
	    	try {
				ps=conn.prepareStatement(sql.toString());
				ps.setInt(1,dogMissno);
				ps.executeUpdate();
			} catch (SQLException e) {
				e.printStackTrace();
			}finally {
				JDBCTemplate.close(ps);
			}	
	    }
	    @Override
	    public int dogMisscnt() {
	    	conn= JDBCTemplate.getConnection();
	    	int res=0;
	    	sql= new StringBuffer();
	    	sql.append(" select count(*) from dog_miss");	    	
	    	try {
				ps=conn.prepareStatement(sql.toString());
				rs =ps.executeQuery();
				
				while(rs.next()) {
					res= rs.getInt(1);
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}finally {
				JDBCTemplate.close(ps);
			}	
	    	
	    return res;
	    }
	    @Override
	    public List<UserLike> AdoptSelectById(String  userid) {
	    	List<UserLike> list= new ArrayList<>();
	    	conn = JDBCTemplate.getConnection();
	    	sql = new StringBuffer();
	    	sql.append(" select * from userlike where userid=? and adoptsw='Y'");
	    	try {
				ps=conn.prepareStatement(sql.toString());
				ps.setString(1, userid);
				rs= ps.executeQuery();
				
				while(rs.next()) {
					UserLike p = new UserLike();
					p.setDogno(rs.getInt("dogno"));
					p.setApplysw(rs.getInt("Applysw"));
					list.add(p);
				}
			} catch (SQLException e) {
				e.printStackTrace();
			} finally {
				JDBCTemplate.close(ps);
				JDBCTemplate.close(rs);
			}	   	
	    	return list;
	    }
	    
	    
	    
	    @Override
	    public List<UserLike> SelectById(String userid) {
	    	List<UserLike> list= new ArrayList<>();
	    	conn = JDBCTemplate.getConnection();
	    	sql = new StringBuffer();
	    	sql.append(" select * from userlike where userid=? and adoptsw= 'N'");
	    	try {
				ps=conn.prepareStatement(sql.toString());
				ps.setString(1, userid);
				rs= ps.executeQuery();
				
				while(rs.next()) {
					UserLike p = new UserLike();
					p.setDogno(rs.getInt("dogno"));
					p.setApplysw(rs.getInt("Applysw"));
					list.add(p);
				}
			} catch (SQLException e) {
				e.printStackTrace();
			} finally {
				JDBCTemplate.close(ps);
				JDBCTemplate.close(rs);
			}   	
	    	return list;
	    }
	    @Override
	    public Dog_Data selectByDogno(int dogno) {
	    	conn= JDBCTemplate.getConnection();
	    	String sql = ""; 
			sql += "SELECT * FROM (SELECT dogno, dogname, dogkind, doggender, dogneu, dogdate, shelterno, dogimg";
			sql += "		FROM dog";
			sql += "		ORDER BY dogdate";
			sql += "	) B, ";
			sql += "   (SELECT";
			sql += "   dogno, dog_fileno, dog_org_file_name, dog_stored_file_name, dog_file_size, dog_del_gb";
			sql += "   FROM dog_file ";
			sql +="    )R ";
			sql +="    where B.dogno = R.dogno and dogno=?";
			Dog_Data d= new Dog_Data();
	    	try {
				ps=conn.prepareStatement(sql.toString());
				ps.setInt(1, dogno);
				rs=ps.executeQuery();
							
				Date today = new Date();
				while(rs.next()) {
					d.setDogno(dogno);
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
			}finally {
				JDBCTemplate.close(ps);
				JDBCTemplate.close(rs);
			}
	    	return d;
	    }
	    @Override
	    public QNA QnaSelectByqnano(int qnano) {
	    	
	    	conn= JDBCTemplate.getConnection();
	    	sql= new StringBuffer();
	    	QNA qna = new QNA();
	    	sql.append("select * from qna where qnano=?");
	    	
	    	try {
				ps= conn.prepareStatement(sql.toString());
				ps.setInt(1, qnano);
				rs=ps.executeQuery();
				
				while(rs.next()) {
					qna.setQnaNO(qnano);
					qna.setQnaTitle(rs.getString("qnaTitle"));
					qna.setQnaContent(rs.getString("qnaContent"));
					qna.setQnaDate(rs.getDate("qnaDate"));
					qna.setQnaWriter(rs.getString("qnaWriter"));

				}
			} catch (SQLException e) {
				e.printStackTrace();
			}finally {
				JDBCTemplate.close(ps);
				JDBCTemplate.close(rs);
			}
    	
	    	return qna;
	    }
	    @Override
	    public void InsertQnaReply(int qnano, String title,String content) {
	    	conn= JDBCTemplate.getConnection();
	    	sql= new StringBuffer();
	    	Qna_Reply ref = new Qna_Reply();
	    	sql.append("insert into qna_reply(ref_title,ref_content,ref_date,qnano) values(?,?,sysdate,?) ");
	    	
	    	try {
				ps= conn.prepareStatement(sql.toString());
				ps.setString(1, title);
				ps.setString(2, content);
				ps.setInt(3, qnano);
				ps.executeUpdate();			
				
			} catch (SQLException e) {
				e.printStackTrace();
			}finally {
				JDBCTemplate.close(ps);
			}    		    	
	    }
	    
	    @Override
	    public void UpdateDelsw(int qnano) {
	    	conn= JDBCTemplate.getConnection();
	    	sql= new StringBuffer();
	    	Qna_Reply ref = new Qna_Reply();
	    	sql.append("update qna set delsw='Y' where qnano=? ");
	    	
	    	try {
				ps= conn.prepareStatement(sql.toString());		
				ps.setInt(1, qnano);
				ps.executeUpdate();			
				
			} catch (SQLException e) {
				e.printStackTrace();
			}finally {
				JDBCTemplate.close(ps);
			}    		    	
	    }
	    @Override
	    public Qna_Reply QnaRefSelect(int qnano) {
	    	conn= JDBCTemplate.getConnection();
	    	sql= new StringBuffer();
	    	Qna_Reply qnaRef = new Qna_Reply();
	    	sql.append("select * from qna_reply where qnano=?");
	    	
	    	try {
				ps= conn.prepareStatement(sql.toString());
				ps.setInt(1, qnano);
				rs=ps.executeQuery();
				
				while(rs.next()) {
					qnaRef.setQnano(qnano);
					qnaRef.setRef_title(rs.getString("ref_title"));
					qnaRef.setRef_content(rs.getString("ref_content"));
					qnaRef.setRef_date(rs.getDate("ref_date"));
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}finally {
				JDBCTemplate.close(ps);
				JDBCTemplate.close(rs);
			}
    	
	    	return qnaRef;
	    	
	        	
	    }
	    }
















