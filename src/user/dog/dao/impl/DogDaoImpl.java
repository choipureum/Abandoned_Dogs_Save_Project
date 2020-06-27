package user.dog.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import admin.dto.DogClaimDTO;
import user.dog.dao.face.DogDao;
import user.dog.dto.DogDTO;
import user.dog.dto.Dog_Data;
import user.dog.dto.Dog_File_DTO;
import user.dog.dto.UserLike;
import util.JDBCTemplate;
import util.Paging;

public class DogDaoImpl implements DogDao{
	private Connection conn = null; //DB연결 객체
	private PreparedStatement ps = null; //SQL수행 객체
	private ResultSet rs = null; //SQL조회 결과 객체
	
	
	

	@Override
	public List<Dog_Data> selectAll(Paging paging) {
		
		//DB연결 객체
		conn = JDBCTemplate.getConnection();
		
		//SQL 작성
		String sql = ""; 
		sql += "SELECT * FROM (";
		sql += "    SELECT rownum rnum, R.* FROM (";
		sql += "        SELECT ";
		sql += "            D.dogno, dogname, dogkind, doggender";
		sql += "            , dogneu, dogdate, dogimg, shelterno";
		sql += "            , dog_fileno, dog_org_file_name, dog_stored_file_name, dog_file_size, dog_del_gb";
		sql += "        FROM dog D, (";
		sql += "            SELECT";
		sql += "                *";
		sql += "            FROM (";
		sql += "                SELECT";
		sql += "                    DF.*";
		sql += "                    , row_number() over( partition by dogno order by dog_fileno desc ) od";
		sql += "                FROM dog_file DF";
		sql += "            )R";
		sql += "            WHERE od = 1";
		sql += "        ) DF_RES";
		sql += "        WHERE D.dogno = DF_RES.dogno(+)";
		sql += "        ORDER BY dogno DESC";
		sql += "    ) R";
		sql += " ) RES";
		sql += " WHERE rnum BETWEEN ? and ?";

		//결과 저장할 List
		List<Dog_Data> dogList = new ArrayList<>();
		try {
			ps = conn.prepareStatement(sql); //SQL수행 객체
			
			ps.setInt(1, paging.getStartNo());	//페이징 게시글 시작 번호
			ps.setInt(2, paging.getEndNo());	//페이징 게시글 끝 번호
			
			rs = ps.executeQuery(); //SQL 수행 및 결과집합 저장
			
			//조회 결과 처리
			while(rs.next()) {
				Dog_Data d = new Dog_Data(); //결과값 저장 객체
				
				//결과값 한 행 처리
				d.setDogno(rs.getInt("dogno"));
				d.setDogname(rs.getString("dogname"));
				d.setDogkind( rs.getString("dogkind") );
				d.setDoggender( rs.getString("doggender") );
				d.setDogneu( rs.getString("dogneu") );
				d.setDogdate( rs.getDate("dogdate") );
				d.setDogimg( rs.getString("dogimg") );
				d.setShelterno( rs.getInt("shelterno") );
				d.setDog_fileno(rs.getInt("dog_fileno"));
				d.setDog_org_file_name(rs.getString("dog_org_file_name"));
				d.setDog_stored_file_name(rs.getString("dog_stored_file_name"));
				d.setDog_file_size(rs.getInt("dog_file_size"));
				d.setDog_del_gb(rs.getString("dog_del_gb"));
				
				//리스트에 결과값 저장
				dogList.add(d);
//				System.out.println("121212"+dogList);
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			//DB객체 닫기
			JDBCTemplate.close(rs);
			JDBCTemplate.close(ps);
		}
		
		//최종 결과 반환
		return dogList;
	}
	

	@Override
	public int selectDogno() {
		
		//DB연결 객체
		conn = JDBCTemplate.getConnection();
		
		//SQL 작성
		String sql = "";
		sql += "SELECT dog_seq.nextval FROM dual";
		
		//결과 저장할 변수
		int dogno = 0;
		
		try {
			ps = conn.prepareStatement(sql); //SQL수행 객체
			
			rs = ps.executeQuery(); //SQL 수행 및 결과집합 저장
			
			//조회 결과 처리
			while(rs.next()) {
				dogno = rs.getInt(1);
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			//DB객체 닫기
			JDBCTemplate.close(rs);
			JDBCTemplate.close(ps);
		}
		
		//최종 결과 반환
		return dogno;
	}

	@Override
	public int selectCntAll() {
		conn = JDBCTemplate.getConnection(); //DB연결
		
		//SQL 작성
		String sql = "";
		sql += "SELECT count(*) FROM dog";
		
		//최종 결과값
		int cnt = 0;
		
		try {
			ps = conn.prepareStatement(sql); //SQL수행 객체
			
			rs = ps.executeQuery(); //SQL수행 및 결과집합 반환
			
			//조회결과 처리
			while( rs.next() ) {
				cnt = rs.getInt(1);
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			// 객체 닫기
			JDBCTemplate.close(rs);
			JDBCTemplate.close(ps);
		}
		
		return cnt;
	}


	@Override
	public DogDTO selectDogByDogno(DogDTO dogno) {
		//DB연결 객체
		conn = JDBCTemplate.getConnection();
		
		//SQL 작성
		String sql = "";
		sql += "SELECT * FROM Dog";
		sql += " WHERE dogno = ?";
		
		//결과 저장할 DogDTO객체
		DogDTO dog = null;
		
		try {
			ps = conn.prepareStatement(sql); //SQL수행 객체
			
			ps.setInt(1, dogno.getDogno()); //조회할 게시글 번호 적용
			
			rs = ps.executeQuery(); //SQL 수행 및 결과집합 저장
			
			//조회 결과 처리
			while(rs.next()) {
				dog = new DogDTO(); //결과값 저장 객체
				
				//결과값 한 행 처리
				dog.setDogno(rs.getInt("dogno"));
				dog.setDogname(rs.getString("dogname"));
				dog.setDogkind( rs.getString("dogkind") );
				dog.setDoggender( rs.getString("doggender") );
				dog.setDogneu( rs.getString("dogneu") );
				dog.setDogdate( rs.getDate("dogdate") );
				dog.setDogimg( rs.getString("dogimg") );
				dog.setShelterno( rs.getInt("shelterno") );
				
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			//DB객체 닫기
			JDBCTemplate.close(rs);
			JDBCTemplate.close(ps);
		}
		
		//최종 결과 반환
		return dog;
	}


	@Override
	public Dog_File_DTO selectFile(DogDTO detailDog) {
		//DB연결 객체
		conn = JDBCTemplate.getConnection();
		
		//SQL 작성
		String sql = "";
		sql += "SELECT * FROM dog_file";
		sql += " WHERE dogno = ?";
		
		//결과 저장할 BoardFile 객체
		Dog_File_DTO dogFile = null;
		
		try {
			ps = conn.prepareStatement(sql); //SQL수행 객체
			
			ps.setInt(1, detailDog.getDogno()); //조회할 boardno 적용
			
			rs = ps.executeQuery(); //SQL 수행 및 결과집합 저장
			
			//조회 결과 처리
			while(rs.next()) {
				dogFile = new Dog_File_DTO();
				
				dogFile.setDogno(rs.getInt("dogno"));
				dogFile.setDog_fileno(rs.getInt("dog_fileno"));
				dogFile.setDog_org_file_name(rs.getString("dog_org_file_name"));
				dogFile.setDog_stored_file_name(rs.getString("dog_stored_file_name"));
				dogFile.setDog_file_size(rs.getInt("dog_file_size"));
				dogFile.setDog_del_gb(rs.getString("dog_del_gb"));
				
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			//DB객체 닫기
			JDBCTemplate.close(rs);
			JDBCTemplate.close(ps);
		}
		
		//최종 결과 반환
		return dogFile;
		
	}


	@Override
	public void insertUserLike(UserLike userlike) {
		//DB연결 객체
		conn = JDBCTemplate.getConnection();
	
		String sql = "";
		sql += "INSERT INTO userlike(userid,adoptsw,applysw,dogno)";
		sql += " VALUES ( ?,?,?,?)";
		
		try {
			ps= conn.prepareStatement(sql);
			
			ps.setString(1, userlike.getUserid());
			ps.setString(2, userlike.getAdoptsw());
			ps.setInt(3, userlike.getApplysw());
			ps.setInt(4, userlike.getDogno());
			ps.setInt(2, userlike.getDogno());
			
			
			if(userlike.getAdoptsw()==null) {
				ps.setString(3, "N");
				
			}else {
				ps.setString(3, "Y");
			}

			ps.executeUpdate();
			
		} catch (SQLException e) {
			e.printStackTrace();
		}	finally {
			JDBCTemplate.close(ps);
		}
		
		
	}


	@Override
	public void insertDogClaim(DogClaimDTO claim) {
		//DB연결 객체
		conn = JDBCTemplate.getConnection();
		
		//
		
		
		String sql = "";
		sql += "INSERT INTO dog_claim(dogno,dogname,dogkind,doggender,dogneu,dogshelter,userid)";
		sql += " VALUES ( ?,?,?,?,?,?,?)";
		
		
		
		try {
			ps= conn.prepareStatement(sql);
			
			
			
			
			ps.setInt(1, claim.getDogno());
			ps.setString(2, claim.getDogname());
			ps.setString(3, claim.getDogkind());
			ps.setString(4, claim.getDoggender());
			ps.setString(5, claim.getDogneu());
			ps.setInt(6, claim.getDogshelter());
			ps.setDate(7, claim.getDogregdate());
			ps.setString(8, claim.getUserid());
			
			
			
			ps.executeUpdate();
			
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			JDBCTemplate.close(ps);
		}
		
	}


	@Override
	public void deleteUserLike(UserLike userlike) {
		//DB연결 객체
		conn = JDBCTemplate.getConnection();
		
		//SQL구문
		String sql = "DELETE FROM USERLIKE WHERE dogno=? ";
		
		
		
		try {
			ps= conn.prepareStatement(sql);
			
			ps.setInt(1, userlike.getDogno());
			
			ps.executeUpdate();
			
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			JDBCTemplate.close(ps);
		}
		
		
				
		
	}


	@Override
	public void deleteDogClaim(DogClaimDTO dogclaim) {
		conn = JDBCTemplate.getConnection();
		
		//SQL구문
		String sql = "DELETE FROM DOGCLAIM WHERE USERID=? ";
		
		try {
			ps= conn.prepareStatement(sql);
			
			ps.setString(1, dogclaim.getUserid());
			
			ps.executeUpdate();
			
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			JDBCTemplate.close(ps);
		}
		
	}


	@Override
	public int selectCntUserLike(UserLike userlike) {
		String sql ="";
		sql += "SELECT count(*) FROM userlike";
		sql += " WHERE dogno = ?";
		sql += " 	AND userid = ?";
		sql += " 	 AND adoptsw = ?";
		sql += " 	  AND applysw = ?";
		
		
		
		
		int cnt = -1;
		
		try {
			//DB작업
			ps = conn.prepareStatement(sql);
			ps.setInt(1, userlike.getDogno());
			ps.setString(2, userlike.getUserid());
			ps.setString(3, userlike.getAdoptsw());
			ps.setInt(4, userlike.getApplysw());
			rs = ps.executeQuery();
			
			while(rs.next()) {
				
				cnt = rs.getInt(1);
			}
			
			
			
		} catch (SQLException e) {
			e.printStackTrace();
		}	finally {
			JDBCTemplate.close(ps);
			JDBCTemplate.close(rs);
			
		}
		
		return cnt;
	}


	


	
	
	
	
	
	
	
	
	

		
	}