
<%@page import="user.dogmiss.dto.DogMissAdd"%>
<%@page import="user.dogmiss.dto.DogMiss"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>



<!-- jQuery 2.2.4 -->
<script type="text/javascript" src="http://code.jquery.com/jquery-2.2.4.min.js"></script>




<!DOCTYPE HTML>

<html>
	<head>

<script>
$(document).ready(function() {
	 	//작성버튼 동작
	  
	 	
	 	$("#insert").click(function() {
	 
	 		
	      $("form").submit();
	   });
	   
	   //취소버튼 동작
	   $("#cancel").click(function() {
	      history.go(-1);
	   });
	
	
	
});	

</script>
	
	
	
	
	
		<title>Full Motion</title>
		<meta charset="utf-8" />
		<meta name="viewport" content="width=device-width, initial-scale=1" />
		<link rel="stylesheet" href="/resources/UserBoardTemplate/assets/css/main.css" /><!--  -->
	</head>
	<body id="top">

			<!-- Banner -->			
				<section id="banner" data-video="images/banner">
					<div class="inner">
						<header>
							<h1>Full Motion</h1>
							<p>A responsive video gallery template with a functional lightbox<br />
							designed by <a href="https://templated.co/">Templated</a> and released under the Creative Commons License.</p>
						</header>
						<a href="#main" class="more">Learn More</a>
					</div>
				</section>

			<!-- Main -->
		<div id="main">
			<div class="inner">
<div class="container">
		<form action="/miss/write" method="post" enctype="multipart/form-data" >
			<table class="table table-condensed">
				<tr>
					<th>제목</th>
					<td><input type="text" name="title"></td>
				</tr>
				<tr>
					<th>작성자</th>
					<td><input type="text" name="writer"></td>
				</tr>
				<tr>
					<th>유기견이름</th>
					<td><input type="text" name="name"></td>
				</tr>
				<tr>
					<th>품종</th>
					<td><input type="text" name="kind" ></td>
				</tr>
				<tr>
					<th>성별</th>
					<td>남<input type="checkbox" name="gender" value="male" >
						여<input type="checkbox" name="gender" value="female" >
					</td>
				</tr>
				<tr>
					<th>강아지 사진</th>
					<td><input type="file" name="file"></td>
				</tr>
				<tr>
					<th>분실 위치</th>
					<td><input type="text" name="loc"></td>
				</tr>
				<tr>
					<th>내용</th>
					<td><textarea name="content" id="content" cols="10" rows="20"></textarea></td>
				</tr>
			</table>
</form>	
<div>
	<button id="insert">등록</button>
	<button id="cancel">취소</button>
</div>
</div>
							
					</div>
				</div>
			
				
			<!-- Footer -->
				<footer id="footer">
					<div class="inner">
						    <address class="addr">
     							   상호명:다솜 │ 대표:4조 │ 개인정보관리자:4조
      						</address>
      						<p class="copy">Copyright 2020-2020 by 다솜. All rights reserved.</p>

						<ul class="icons">
							<li><a href="#" class="icon fa-twitter"><span class="label">Twitter</span></a></li>
							<li><a href="#" class="icon fa-facebook"><span class="label">Facebook</span></a></li>
							<li><a href="#" class="icon fa-instagram"><span class="label">Instagram</span></a></li>
							<li><a href="#" class="icon fa-envelope"><span class="label">Email</span></a></li>
						</ul>
						
					</div>
				</footer>

		<!-- Scripts -->
			<script src="/reources/UserBoardTemplate/assets/js/jquery.min.js"></script>
			<script src="/reources/UserBoardTemplate/assets/js/jquery.scrolly.min.js"></script>
			<script src="/reources/UserBoardTemplate/assets/js/jquery.poptrox.min.js"></script>
			<script src="/reources/UserBoardTemplate/assets/js/skel.min.js"></script>
			<script src="/reources/UserBoardTemplate/assets/js/util.js"></script>
			<script src="/reources/UserBoardTemplate/assets/js/main.js"></script>

	</body>

</html>