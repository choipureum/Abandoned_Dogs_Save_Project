package admin.service.impl;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import admin.dao.face.AdminMemberListDao;
import admin.dao.impl.AdminMemberListDaoImpl;
import admin.service.face.AdminMemberListService;
import user.member.dto.MemberDTO;

public class AdminMemberListServiceImpl implements AdminMemberListService{
	
	//DAO객체 생성
	private AdminMemberListDao adminMemberListDao = AdminMemberListDaoImpl.getInstance();
	
	
	@Override
	public List<MemberDTO> memberSelect(HashMap<String, Object> listOpt) {		
		List <MemberDTO>list = adminMemberListDao.select(listOpt);

		return list;
	}
	@Override
	public int memberCount(HashMap<String, Object> listOpt) {
		int res = adminMemberListDao.getMemberCount(listOpt);
		return res;
	}
	@Override
	public int memberDelete(MemberDTO member) {
		return 0;
	}
	@Override
	public List<MemberDTO> memberSelectAll() {
		List<MemberDTO>list = adminMemberListDao.selectAll();
		return list;
	}
	
	



}
