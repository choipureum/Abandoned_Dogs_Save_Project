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




@WebServlet("/comment/delete")
public class CommentDeleteeController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	DogMissService dogMissService = new DogMissServiceImpl();
   
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Comment comment = new Comment();
		
		String commentNo = (String) request.getParameter("miss_rno");
		
		comment.setMiss_rno( Integer.parseInt(commentNo) );
		
		boolean success = dogMissService.deleteComment(comment);
		
		response.getWriter().append("{\"success\":"+success+"}");
	}

}
