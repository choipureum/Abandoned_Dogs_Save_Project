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
import user.dog.dto.Dog_File_DTO;
import user.member.dto.MemberDTO;
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
			    	member.setUsergrade(rs.getInt("userGrade"));
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
			    	member.setUsergrade(rs.getInt("userGrade"));
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
			    	member.setUsergrade(rs.getInt("userGrade"));
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
	    	
	    	String sql = "Insert into dog(dogno, dogname, dogkind, doggender, dogneu, shelterno) values(dog_seq.nextval, ?,?,?,?,1)";
	    	
	    	try {
				ps=conn.prepareStatement(sql);
				ps.setString(1, dog.getDogname());
				ps.setString(2, dog.getDogkind());
				ps.setString(3, dog.getDoggender());
				//null이면 N으로 넣고 아니면 Y처리
				if(dog.getDogneu()==null) {
					ps.setString(4, "N");
				}
				else {
					ps.setString(4, "Y");
				}				
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
				ps.setInt(4, dogFile.getDog_file_size());
				ps.executeUpdate();
				
			} catch (SQLException e) {
				e.printStackTrace();
			} finally {
				JDBCTemplate.close(ps);
			}
	    }
	    @Override
	    public List <DogClaimDTO> dogClaimSelectAll(HashMap<String,Object> listOpt,Paging paging) {
	    	
	    	List <DogClaimDTO> list = new ArrayList<>();
	    	
	    	conn = JDBCTemplate.getConnection();
	    	sql = new StringBuffer();
	    	 
	    	
	    	sql.append("SELECT * FROM (");      
	    	sql.append(" SELECT rownum rnum, B.* FROM (");
	    	sql.append(" SELECT");
	    	sql.append(" *");
	    	sql.append(" FROM dog_claim");	  
	    	sql.append(" order by dogRegDate)B");
	    	sql.append(" )dog_claim");
	    	sql.append(" WHERE rnum BETWEEN ? AND ?");	
	    	
	    	try {
				ps=conn.prepareStatement(sql.toString());
				ps.setInt(1, paging.getStartNo());
		    	ps.setInt(2, paging.getEndNo());		
				rs= ps.executeQuery();
				
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
}















