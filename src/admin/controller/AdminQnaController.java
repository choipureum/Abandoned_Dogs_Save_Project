package admin.controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import admin.dao.face.AdminMemberListDao;
import admin.dao.impl.AdminMemberListDaoImpl;
import admin.service.face.AdminMemberListService;
import admin.service.impl.AdminMemberListServiceImpl;
import user.qna.dto.QNA;

@WebServlet("/admin/qna")
public class AdminQnaController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	private AdminMemberListService adminMemberListService = new AdminMemberListServiceImpl();
	private AdminMemberListDao adminMemberListDao = AdminMemberListDaoImpl.getInstance();
	
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
				
		List<QNA> list = new ArrayList<>();
		list=adminMemberListDao.qnaSelectAll();
	
		req.setAttribute("qnaList", list);
		req.getRequestDispatcher("/WEB-INF/views/admin/AdminQna.jsp").forward(req, resp);
		
	
	}
	
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
	}

}
