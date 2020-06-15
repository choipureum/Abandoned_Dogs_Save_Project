package user.member.dao.impl;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import user.member.dao.face.MemberDao;
import user.member.dto.MemberDTO;
import util.JDBCTemplate;

public class MemberDaoImpl implements MemberDao{
   
   private Connection conn = null; //db 연결객체
   private PreparedStatement ps= null; //sql 수행객체
   private ResultSet rs = null; //결과집합
   
   //nextval
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


   @Override
   public int login(String userid, String userpw) {
	   // TODO Auto-generated method stub
	   return 0;
   }
}
