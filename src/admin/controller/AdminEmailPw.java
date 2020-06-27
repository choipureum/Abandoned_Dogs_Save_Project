package admin.controller;


import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.util.Date;
import java.util.HashMap;
import java.util.Random;
import java.util.StringTokenizer;

import javax.activation.DataHandler;
import javax.activation.DataSource;
import javax.mail.Authenticator;
import javax.mail.BodyPart;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.AddressException;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeBodyPart;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeMultipart;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.ServletInputStream;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import user.member.service.face.MemberService;
import user.member.service.impl.MemberServiceImpl;
import util.ByteArrayDataSource;

@WebServlet("/admin/emailcheck")
public class AdminEmailPw extends HttpServlet {
	private static final long serialVersionUID = 1L;

	//받는 사람
	private String to = "";

	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException  {
		//파일 업로드로- 같이 묶어서 받기
		//- getParameter로는 안된다 - 직접구현 or 웹에디터 
		req.setCharacterEncoding("UTF-8");
		resp.setContentType("text/html;charset=UTF-8");
		//이메일
		to=req.getParameter("email");
			
		//인증숫자 코드 4자리 수  - 0000-9999
		int random = (int)Math.random()*9999;

		String ran= "";
		for(int i=0;i<4;i++) {
			int n = (int)(Math.random()*10);
			ran+=String.valueOf(n);
		}

        System.setProperty("mail.smtp.starttls.enable", "true"); // gmail은 무조건 true 고정
        System.setProperty("mail.smtp.auth", "true"); // gmail은 무조건 true 고정
        System.setProperty("mail.smtp.host", "smtp.gmail.com"); // smtp 서버 주소
        System.setProperty("mail.smtp.port", "587"); // gmail 포트
       
        //구글 인증
        Authenticator auth = new MyAuthentication();
        Message msg = new MimeMessage(Session.getDefaultInstance(System.getProperties(), auth));
        //받는사람
        InternetAddress[] tos;
		try {
			tos = InternetAddress.parse(to);
			 msg.setRecipients(Message.RecipientType.TO, tos);
		        //한글을 위한 인코딩
		        msg.setHeader("Content-Type", "text/html;charset=UTF8");
		        //제목
		        msg.setSubject("<다솜>홈페이지 이메일 인증 메일입니다");
		        msg.setSentDate(new Date());
		 
		        //이메일 파일 전송(html)
		       String body="";
		        	//파일 붙이기
		        	body="<header style=\"background-color: #d2d2d2;\">\r\n" + 
		        			"<h1>다솜</h1>\r\n" + 
		        			"<hr>\r\n" + 
		        			"</header>\r\n" + 
		        			"<br><br>\r\n" + 
		        			"<img src=\"https://images.unsplash.com/photo-1534361960057-19889db9621e?ixlib=rb-1.2.1&ixid=eyJhcHBfaWQiOjEyMDd9&auto=format&fit=crop&w=1050&q=80\"\r\n" + 
		        			"		width=\"600px\" height=\"400px\" ><br><br>\r\n" + 
		        			"관리자 이메일로 전송되는 메일입니다<br><br>\r\n" + 
		        			"관리자의 비밀번호 : chl58004180  입니다<br><br>\r\n" + 
		        			"\r\n" + 
		        			"<footer style=\"background-color: #d2d2d2;\">\r\n" + 
		        			"    <p>Copyright © 2020 khacademy.Abandoned_Dogs_Save_Project. All rights reserved.</p>\r\n" + 
		        			"    <address>Contact webmaster for more information. 010-1111-1111</address>\r\n" + 
		        			"</footer>";

		        msg.setContent(body, "text/html;charset=UTF8 ");             		        
		        //전송
		        Transport.send(msg);
		} catch (AddressException e) {
			e.printStackTrace();
		} catch(MessagingException e) {
			e.printStackTrace();
		}
       resp.getWriter().write(ran);
	}    

	/**
	 * 보내는 사람 (구글 이메일 계정 인증)
	 * @author User
	 *
	 */
	class MyAuthentication extends Authenticator {
		 
	    private PasswordAuthentication pa;
	    private String id;
	    private String pw;
	    
	    // 보안 private 접근제한
	    private MyAuthentication() {
	    	//테스트 - 일단 내꺼
	        id = "pooreumsunny@gmail.com"; // 구글 ID
	        pw = "chl97983140"; // 구글 비밀번호
	        pa = new PasswordAuthentication(id, pw);
	    }

	    // 시스템에서 사용하는 인증정보
	    public PasswordAuthentication getPasswordAuthentication() {
	        return pa;
	    }
	}
	
	}



