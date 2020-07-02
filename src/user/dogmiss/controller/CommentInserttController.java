package user.dogmiss.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import user.dogmiss.dto.Comment;
import user.dogmiss.service.face.DogMissService;
import user.dogmiss.service.impl.DogMissServiceImpl;



@WebServlet("/comment/insert")
public class CommentInserttController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
   
	DogMissService dogMissService = new DogMissServiceImpl();
	

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//doGet으로 받은 request를 doPost로 보냄 
		doPost(request, response);
		
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//comment.jsp에서 받은 파라미터를 commment객체에 저장하여 전달 받음 
		Comment comment = dogMissService.getComment(request);
		
		//객체에 저장한 comment를 db에 저장 
		dogMissService.insertComment(comment);
		
		response.sendRedirect("/miss/view?missno="+comment.getMissNo());
	}

}
