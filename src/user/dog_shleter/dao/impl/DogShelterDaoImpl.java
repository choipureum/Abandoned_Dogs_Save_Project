
package user.dog_shleter.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import user.dog.dto.DogDTO;
import user.dog.dto.Dog_Data;
import user.dog_shleter.dao.face.DogShelterDao;
import user.dog_shleter.dto.Dog_Shelter;
import util.JDBCTemplate;
import util.Paging;

public class DogShelterDaoImpl implements DogShelterDao {

	private static final String SQL_SELECT_BY_DOGNAME = null;
	private static final String SQL_SELECT_BY_DOGKIND = null;
	private Connection conn = null; // DB연결 객체
	private PreparedStatement ps = null; // SQL수행 객체
	private ResultSet rs = null; // SQL조회 결과 객체

	// 카카오 API 좌표값, 마커 조회
	@Override
	public List<Dog_Shelter> selectAll() {

		// DB연결 객체
		conn = JDBCTemplate.getConnection();

		// SQL 작성
		String sql = "";
		sql += "SELECT * FROM dog_shelter";

		List<Dog_Shelter> dogShelterList = new ArrayList<>();

		try {
			ps = conn.prepareStatement(sql); // SQL 수행 객체
			rs = ps.executeQuery();// SQL 결과집합 저장

			while (rs.next()) {
				Dog_Shelter d = new Dog_Shelter();// 결과값 저장

				d.setShelterno(rs.getInt("shelterno"));
				d.setSheltername(rs.getString("sheltername"));
				d.setShelterlat(rs.getString("shelterlat"));
				d.setShelterlon(rs.getString("shelterlon"));
				d.setShelteraddress(rs.getString("shelteraddress"));
				d.setSheltertel(rs.getString("sheltertel"));

				dogShelterList.add(d);
			}

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			JDBCTemplate.close(rs);
			JDBCTemplate.close(ps);
		}

		return dogShelterList;
	}

	@Override
	public Dog_Shelter selectBy(Dog_Shelter dogShelter) {
		// DB연결 객체
		conn = JDBCTemplate.getConnection();

		// SQL 작성
		String sql = "";
		sql += "SELECT * FROM dog_shelter WHERE shelterno = ?";

		// 조회 결과가 저장될 DTO
		Dog_Shelter result = null;

		System.out.println("dao result : " + result);

		try {
			ps = conn.prepareStatement(sql); // SQL 수행 객체
			ps.setInt(1, dogShelter.getShelterno()); // 조회될 보호소 번호

			System.out.println("dao dogShelter : " + dogShelter);
			rs = ps.executeQuery();// SQL 결과집합 저장

			while (rs.next()) {
				result = new Dog_Shelter();// 결과값 저장

				result.setShelterno(rs.getInt("shelterno"));
				result.setSheltername(rs.getString("sheltername"));
				result.setShelteraddress(rs.getString("shelteraddress"));
				result.setSheltertel(rs.getString("sheltertel"));

			}

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			JDBCTemplate.close(rs);
			JDBCTemplate.close(ps);
		}

		return result;
	}

	// 유기견 조회
	@Override
	public List<Dog_Data> dogDetailList(Dog_Data dog, Paging paging) {
		// DB연결 객체
		conn = JDBCTemplate.getConnection();

		// SQL 작성
		// SQL 작성
		String sql = "";
		sql += "SELECT * FROM (";
		sql += "    SELECT rownum rnum, R.* FROM (";
		sql += "        SELECT ";
		sql += "            D.dogno, dogname, dogkind, doggender";
		sql += "            , dogneu, dogdate, dogimg, D.shelterno";
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
		sql += "        , dog_shelter DS";
		sql += "        WHERE D.dogno = DF_RES.dogno";
		sql += "        AND D.shelterno = DS.shelterno";
		sql += "        ORDER BY dogno DESC";
		sql += "    ) R";
		sql += " ) RES";
		sql += " WHERE rnum BETWEEN ? and ?";
		sql += " 	AND shelterno = ?";

		// 조회 결과가 저장될 DTO
		List<Dog_Data> dogDTOList = new ArrayList<>();

		System.out.println("dao result : " + dogDTOList);

		try {
//			if(keyWord !=null && !keyWord.equals("")) {
//				sql +="WHERE"+keyField.trim()+" LIKE '%"+keyWord.trim()+"%' order by dogdate";
//			} else {//모든 레코드 검색
//				sql +="order by dogdate";
//			} 
//			System.out.println("sql" + sql);

			ps = conn.prepareStatement(sql);

			ps.setInt(1, paging.getStartNo()); // 페이징 게시글 시작 번호
			ps.setInt(2, paging.getEndNo()); // 페이징 게시글 끝 번호
			ps.setInt(3, dog.getShelterno());

			rs = ps.executeQuery();// SQL 결과집합 저장

			while (rs.next()) {
				Dog_Data d = new Dog_Data(); // 결과값 저장 객체

				// 결과값 한 행 처리
				d.setDogno(rs.getInt("dogno"));
				d.setDogname(rs.getString("dogname"));
				d.setDogkind(rs.getString("dogkind"));
				d.setDoggender(rs.getString("doggender"));
				d.setDogneu(rs.getString("dogneu"));
				d.setDogdate(rs.getDate("dogdate"));
				d.setDogimg(rs.getString("dogimg"));
				d.setShelterno(rs.getInt("shelterno"));
				d.setDog_fileno(rs.getInt("dog_fileno"));
				d.setDog_org_file_name(rs.getString("dog_org_file_name"));
				d.setDog_stored_file_name(rs.getString("dog_stored_file_name"));
				d.setDog_file_size(rs.getInt("dog_file_size"));
				d.setDog_del_gb(rs.getString("dog_del_gb"));

				// 리스트에 결과값 저장
				dogDTOList.add(d);
			}

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			JDBCTemplate.close(rs);
			JDBCTemplate.close(ps);
		}

		return dogDTOList;

	}

	@Override
	public int selectCntAll() {
		conn = JDBCTemplate.getConnection(); // DB연결

		// SQL 작성
		String sql = "";
		sql += "SELECT dog_seq.nextval FROM dual";

		// 최종 결과값
		int cnt = 0;

		try {
			ps = conn.prepareStatement(sql); // SQL수행 객체

			rs = ps.executeQuery(); // SQL수행 및 결과집합 반환

			// 조회결과 처리
			while (rs.next()) {
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
	public List<Dog_Data> dogSearchList(int category, String keyword, Paging paging) {
		List<Dog_Data> list = new ArrayList<>();
		
		conn = JDBCTemplate.getConnection(); // DB연결
		
		try {
			conn = ps.getConnection();
		
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return list;
	}

}
