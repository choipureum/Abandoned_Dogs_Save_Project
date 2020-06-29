package user.dogmiss.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import user.dogmiss.dao.face.CommentDao;
import user.dogmiss.dto.Comment;
import user.dogmiss.dto.DogMiss;
import util.JDBCTemplate;



public class CommentDaoImpl implements CommentDao {
	// DB 연결 객체
	private Connection conn = null;

	// JDBC 객체
	private PreparedStatement ps;
	private ResultSet rs;
	
	//입력받은 갯글객체를 받아 db에 저장
	public void insertComment(Comment comment) {
		

			conn = JDBCTemplate.getConnection();

			String sql
			= "INSERT INTO miss_Reply ("
					+ "		missno,"
					+ "		miss_rno,"
					+ "		miss_content,"
					+ "		miss_writer, miss_date )"
					+ "	VALUES ("
					+ "		?, miss_comment_seq.nextval,"
					+ "		?,"
					+ "		?,"
					+ "		sysdate )";

			try {
				ps = conn.prepareStatement(sql);

				ps.setInt(1, comment.getMissNo());
				ps.setString(2, comment.getMiss_content());
				ps.setString(3, comment.getMiss_writer());
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


		}//insert End
	
	
	//qnano에 해당하는 commentlist를 반환
	public List<Comment> selectComment(DogMiss viewBoard){
		
		
		

			conn = JDBCTemplate.getConnection();

			String sql
			= "SELECT * FROM ("
					+ "SELECT rownum rnum, B.* FROM ("
					+ "	SELECT"
					+ "		missno,"
					+ "		miss_rno,"
					+ "		miss_content,"
					+ "		miss_writer,"
					+ "		miss_date"
					+ "	FROM miss_Reply"
					+ "	WHERE missno = ?"
					+ "	ORDER BY miss_date"
					+ "	) B"
					+ ") ORDER BY rnum";

			List <Comment>commentList = new ArrayList<>();
			try {
				ps = conn.prepareStatement(sql);

				ps.setInt(1, viewBoard.getMissNO() );

				// ResultSet 반환
				rs = ps.executeQuery();

				while( rs.next() ) {
					Comment comment = new Comment();

					comment.setMissNo(rs.getInt("missNo"));
					comment.setMiss_rno(rs.getInt("miss_rno"));
					comment.setMiss_content(rs.getString("miss_content"));
					comment.setMiss_writer(rs.getString("miss_writer"));
					
					comment.setMiss_date(rs.getDate("miss_date"));

					commentList.add(comment);
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

			return commentList;
		}//end
		
	//댓글 삭제
	public void deleteComment(Comment comment) {

		conn = JDBCTemplate.getConnection();

		String sql
		= "DELETE miss_Reply"
				+ "	WHERE miss_rno = ?";

		try {
			ps = conn.prepareStatement(sql);
			ps.setInt(1, comment.getMiss_rno());
			
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
	}

	@Override
	public int countComment(Comment comment) {

		conn = JDBCTemplate.getConnection();

		String sql = "SELECT COUNT(*) FROM miss_Reply WHERE miss_rno=?";
		
		int cnt = 0;
		try {
			ps = conn.prepareStatement(sql);
			ps.setInt(1, comment.getMiss_rno());
			rs = ps.executeQuery();
			rs.next();
			cnt = rs.getInt(1);
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				rs.close();
				ps.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		
		return cnt;
	}
}
