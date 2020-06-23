package user.dog_shleter.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import user.dog_shleter.dao.face.DogShelterDao;
import user.dog_shleter.dto.Dog_Shelter;
import util.JDBCTemplate;


public class DogShelterDaoImpl  implements DogShelterDao {

	private Connection conn = null; //DB연결 객체
	private PreparedStatement ps = null; //SQL수행 객체
	private ResultSet rs = null; //SQL조회 결과 객체
	
	// 마커 정보 
	@Override
	public List<Dog_Shelter> selectAll() {
		
		//DB연결 객체
		conn = JDBCTemplate.getConnection();
		
		//SQL 작성
		String sql ="";
		sql += "SELECT * FROM dog_sheleter";
		
		List<Dog_Shelter> dogShelterList = new ArrayList<>();
		
		try {
			ps = conn.prepareStatement(sql); //SQL 수행 객체
			rs = ps.executeQuery();// SQL 결과집합 저장
			
			while(rs.next()) {
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

	
	//상세 정보
	@Override
	public List<Dog_Shelter> view(String sheltername, String shelteraddress, String sheltertel) {
		
		conn = JDBCTemplate.getConnection();
		
		List<Dog_Shelter> list = new ArrayList<>(); 
		
		String sql = "SELECT sheltername, shelteraddress, sheltertel FROM dog_sheleter WHERE sheltername=? ";
		
		String shelter = "";
		
		try {
			ps= conn.prepareStatement(sql);
			
			ps.setString(1, sheltername);
			System.out.println(sheltername);
			rs = ps.executeQuery();
			
			System.out.println(rs.next());
			while(rs.next()) {
				shelter=rs.getString("sheltername");
				shelter=rs.getString("shelteraddress");
				shelter=rs.getString("sheltertel");
				
			}
	
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			JDBCTemplate.close(rs);
			JDBCTemplate.close(ps);
			
		}
		
		
		return list;
	}


	@Override
	public Dog_Shelter selectBy(Dog_Shelter dogShelter) {
		
		//DB연결 객체
		conn = JDBCTemplate.getConnection();
				
		//SQL 작성
		String sql ="";
		sql += "SELECT * FROM dog_sheleter WHERE sheleterno = ?" ;
				
		//조회 결과가 저장될 DTO
		Dog_Shelter result = null;		
		
		try {
			ps = conn.prepareStatement(sql); //SQL 수행 객체
			ps.setInt(1, dogShelter.getShelterno()); //조회될 보호소 번호
			
			rs = ps.executeQuery();// SQL 결과집합 저장
					
			while(rs.next()) {
				Dog_Shelter d = new Dog_Shelter();// 결과값 저장
						
				d.setShelterno(rs.getInt("shelterno"));
				d.setSheltername(rs.getString("sheltername"));
				d.setShelterlat(rs.getString("shelterlat"));
				d.setShelterlon(rs.getString("shelterlon"));
				d.setShelteraddress(rs.getString("shelteraddress"));
				d.setSheltertel(rs.getString("sheltertel"));
						
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
}
	
	



