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
import user.qna.dto.Qna_Reply;

@WebServlet("/admin/qnaDetail")
public class AdminQnaDetail extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	private AdminMemberListDao adminMemberListDao = AdminMemberListDaoImpl.getInstance();
	
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.setCharacterEncoding("UTF-8");
		resp.setContentType("text/html;charset=UTF-8");		
		int qnano = Integer.parseInt(req.getParameter("qnano"));		
		QNA qna = new QNA();
		qna= adminMemberListDao.QnaSelectByqnano(qnano);
		Qna_Reply ref= new Qna_Reply();
		ref= adminMemberListDao.QnaRefSelect(qnano);
		
		req.setAttribute("qna", qna);
		req.setAttribute("ref", ref);
		req.getRequestDispatcher("/WEB-INF/views/admin/AdminQnaDetail.jsp").forward(req, resp);
	
	}
	
	
	
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.setCharacterEncoding("UTF-8");
		resp.setContentType("text/html;charset=UTF-8");
		//qna 답변을 입력하고 ,qna delsw 를 Y로 치환
		int qnano=Integer.parseInt(req.getParameter("qnano"));
		String title = req.getParameter("reftitle");
		String content = req.getParameter("refcontent");
		adminMemberListDao.InsertQnaReply(qnano,title,content);		
		adminMemberListDao.UpdateDelsw(qnano) ;
	
		resp.sendRedirect("/admin/qna");
	
	}

}
