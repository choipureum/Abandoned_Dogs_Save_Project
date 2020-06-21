package admin.service.impl;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.TreeMap;

import javax.servlet.http.HttpServletRequest;

import admin.dao.face.AdminMemberListDao;
import admin.dao.impl.AdminMemberListDaoImpl;
import admin.service.face.AdminMemberListService;
import user.member.dto.MemberDTO;
import admin.service.*;
import util.JDBCTemplate;
import util.Paging;

public class AdminMemberListServiceImpl implements AdminMemberListService{
	
	//DAO객체 생성
	private AdminMemberListDao adminMemberListDao = AdminMemberListDaoImpl.getInstance();
	
	
	@Override
	public List<MemberDTO> memberSelect(HashMap<String, Object> listOpt, Paging paging) {				
		return adminMemberListDao.select(listOpt,paging);
	}
	@Override
	public int memberCount(HashMap<String, Object> listOpt) {
		int res = adminMemberListDao.getMemberCount(listOpt);
		return res;
	}
	@Override
	public int memberDelete(String userid) {
		int res=adminMemberListDao.delete(userid);
		
		return res;
	}
	@Override
	public List<MemberDTO> memberSelectAll() {
		List<MemberDTO>list = adminMemberListDao.selectAll();
		return list;
	}	
	
	@Override
	public Paging getPaging(HttpServletRequest req, HashMap<String,Object> listOpt) {
		//전달파라미터 curPage를 파싱한다
		String param = req.getParameter("curPage");
		int curPage = 0;
		if( param!=null && !"".equals(param) ) {
			curPage = Integer.parseInt(param);
		}					
		//회원 테이블의 총 게시글 수를 조회한다
		int totalCount = adminMemberListDao.getMemberCount(listOpt);
						
		//Paging 객체 생성
		Paging paging = new Paging(totalCount, curPage); 
						
		//계산된 Paging 객체 반환
		return paging;
	}
	@Override
	public TreeMap<Date, Integer> getGraphMember() {		
		return adminMemberListDao.graphMember();
	}
	@Override
	public MemberDTO selectById(String userid) {
		MemberDTO member=adminMemberListDao.selectID(userid);
		return member;
	}
	@Override
	public void UpdateGrade(String id,String grade) {
		adminMemberListDao.updateGradeById(id,grade);
	}
}






