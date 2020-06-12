package user.dog_miss.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import user.dog_miss.dao.face.DogMissDao;
import user.dog_miss.dto.Dog_MissDTO;
import util.JDBCTemplate;

public class DogMissDaoImpl implements DogMissDao {
	// OJDBC관련 객체
	private Connection conn = null; // DB연결 객체
	private PreparedStatement ps = null; // SQL 수행 객체
	private ResultSet rs = null; // 조회결과 처리 객체

	@Override
	public List<Dog_MissDTO> selectAll() {

		conn = JDBCTemplate.getConnection();

		String sql = "";
		sql += "SELECT * FROM dog_miss";
		sql += " OREDER BY dogno";
		
		List<Dog_MissDTO> list = new ArrayList<>();
		
		try {
			ps = conn.prepareStatement(sql);
			rs = ps.executeQuery();
			
			while(rs.next()) {
				Dog_MissDTO dog_MissDTO = new Dog_MissDTO();
				
				dog_MissDTO.setMissno(rs.getInt("misno"));
				dog_MissDTO.setMissname(rs.getString("missname"));
				dog_MissDTO.setMisskind(rs.getString("misskind"));
				dog_MissDTO.setMissdate(rs.getDate("misssdate"));
				dog_MissDTO.setMissimg(rs.getString("missimg"));
				dog_MissDTO.setMissloc(rs.getString("missloc"));
				dog_MissDTO.setMisstitle(rs.getString("misstitle"));
				dog_MissDTO.setMisscontent(rs.getString("misscontent"));
				dog_MissDTO.setMisswriter(rs.getString("misswriter"));
				dog_MissDTO.setMisshit(rs.getString("misshit"));
				
				list.add(dog_MissDTO);
			}
		
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			JDBCTemplate.close(rs);
			JDBCTemplate.close(ps);
		}
		
		return list;
	}

	@Override
	public int insertDog_Miss(Connection conn, Dog_MissDTO dog_MissDTO) {
		
		conn = JDBCTemplate.getConnection();
		
		String sql = "";
		sql += "INSERT INTO dog_miss VLUES(?,?,?,?,?,?,?,?,?,?)";
		
		int res = 0;
		
		try {
			ps = conn.prepareStatement(sql);
			
			ps.setInt(1, dog_MissDTO.getMissno());
			ps.setString(2, dog_MissDTO.getMissname());
			ps.setString(3, dog_MissDTO.getMisskind());
			ps.setString(4, dog_MissDTO.getMissgender());
			ps.setDate(5, dog_MissDTO.getMissdate());
			ps.setString(6, dog_MissDTO.getMissimg());
			ps.setString(7, dog_MissDTO.getMissloc());
			ps.setString(8, dog_MissDTO.getMisstitle());
			ps.setString(9, dog_MissDTO.getMisscontent());
			ps.setString(10, dog_MissDTO.getMisshit());
			
			ps.execute();
			res=ps.executeUpdate();

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			JDBCTemplate.close(ps);
		}
		
		return res;
	}

	

}













