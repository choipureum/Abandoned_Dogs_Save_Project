package user.dog_shleter.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import user.dog.dto.Dog_Data;
import user.dog_shleter.dao.face.DogShelterDao;
import user.dog_shleter.dto.Dog_Shelter;
import util.JDBCTemplate;


public class DogShelterDaoImpl  implements DogShelterDao {

	private Connection conn = null; //DB연결 객체
	private PreparedStatement ps = null; //SQL수행 객체
	private ResultSet rs = null; //SQL조회 결과 객체
	
	// 카카오 API 좌표값, 마커 조회 
	@Override
	public List<Dog_Shelter> selectAll() {
		
		//DB연결 객체
		conn = JDBCTemplate.getConnection();
		
		//SQL 작성
		String sql ="";
		sql += "SELECT * FROM dog_shelter";
		
		List<Dog_Shelter> dogShelterList = new ArrayList<>();
		
		try {
			ps = conn.prepareStatement(sql); //SQL 수행 객체
			rs = ps.executeQuery();// SQL 결과집합 저장
			
			while(rs.next()) {
				Dog_Shelter d = new Dog_Shelter();// 결과값 저장
				
				d.setShelterno(rs.getInt("shelterno"));
				d.setSheltername(rs.getString("sheltername"));
				d.setShelterlat(rs.getInt("shelterlat"));
				d.setShelterlon(rs.getInt("shelterlon"));
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
		//DB연결 객체
		conn = JDBCTemplate.getConnection();
				
		//SQL 작성
		String sql ="";
		sql += "SELECT * FROM dog_shelter WHERE shelterno = ?" ;
				
		//조회 결과가 저장될 DTO
		Dog_Shelter result = null;		
		
		System.out.println("dao result : " + result);
		
		try {
			ps = conn.prepareStatement(sql); //SQL 수행 객체
			ps.setInt(1, dogShelter.getShelterno()); //조회될 보호소 번호
			
			System.out.println("dao dogShelter : " + dogShelter);
			rs = ps.executeQuery();// SQL 결과집합 저장
					
			while(rs.next()) {
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
	
	//유기견 조회
	@Override
	public Dog_Data dogDetailList(Dog_Data dog) {
		
		//DB연결 객체
		conn = JDBCTemplate.getConnection();
				
		//SQL 작성
		String sql ="";
		sql += "SELECT * FROM dog WHERE shelterno = ?" ;
				
		//조회 결과가 저장될 DTO
		Dog_Data result = null;		
		
		System.out.println("dao result : " + result);
		
		try {
			ps = conn.prepareStatement(sql); //SQL 수행 객체
			ps.setInt(1, dog.getShelterno()); //조회될 보호소 번호
			
			System.out.println("dao dog : " + dog);
			
			rs = ps.executeQuery();// SQL 결과집합 저장
					
			while(rs.next()) {
				result = new Dog_Data();// 결과값 저장
				
				result.setDogname(rs.getNString("dogname"));
				result.setDoggender(rs.getString("doggender"));
				result.setDogneu(rs.getNString("dogneu"));
				result.setDogimg(rs.getString("dogimg"));
				result.setDogdate(rs.getDate("dogdate"));
				
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
	
	



