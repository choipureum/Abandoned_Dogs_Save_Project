package user.dog.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import user.dog.dao.face.DogDao;
import user.dog.dto.DogDTO;
import util.JDBCTemplate;

public class DogDaoImpl implements DogDao{
	// OJDBC 관련 객체
		private Connection conn = null; //DB연결 객체
		private PreparedStatement ps = null; //SQL수행객체
		private ResultSet rs = null; // 조회 결과 객체
		
		
		@Override
		public List<DogDTO> selectAll() {
			
			conn = JDBCTemplate.getConnection(); //DB연결
			
			//SQL 작성
			String sql="SELECT * FROM dog ORDER BY dogno";
			
			//쿼리 결과 저장할 List
			List<DogDTO> list = new ArrayList<>();
			
			//SQL수행
					try {
						ps=conn.prepareStatement(sql);//SQL 수행 객체 생성
						rs=ps.executeQuery();

						//결과 처리
						while(rs.next()) {
							DogDTO dog = new DogDTO(); // 새로운 DOG 객체 생성
							
							//ResultSet에서 데이터를 꺼내 Emp객체에 삽입
							
							dog.setDogno(rs.getInt("dogno"));
							dog.setDogname(rs.getString("dogname"));
							dog.setDogkind(rs.getString("dogkind"));
							dog.setDoggender(rs.getString("doggender"));
							dog.setDogneu(rs.getString("dogneu"));
							dog.setDogdate(rs.getDate("dogdate"));
							dog.setDogimg(rs.getString("dogimg"));
							dog.setShelterno(rs.getInt("shelterno"));
							
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
					
					// 최종 결과 반환
					return list;
				
			
		}
		
		
		
		
	}