package admin.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import admin.dao.face.AdminMemberListDao;
import admin.dao.impl.AdminMemberListDaoImpl;
import user.qna.dto.QNA;

@WebServlet("/admin/qnaDetail")
public class AdminQnaDetail extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	private AdminMemberListDao adminMemberListDao = AdminMemberListDaoImpl.getInstance();
	
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
				
		int qnano = Integer.parseInt(req.getParameter("qnano"));
		QNA qna = new QNA();
		qna= adminMemberListDao.QnaSelectByqnano(qnano);
		req.setAttribute("qna", qna);
		req.getRequestDispatcher("/WEB-INF/views/admin/AdminQnaDetail.jsp").forward(req, resp);
	
	}
	
	
	
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
	}

}
