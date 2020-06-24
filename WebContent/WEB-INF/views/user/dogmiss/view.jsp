<%@page import="user.dogmiss.dto.DogMissFile"%>
<%@page import="user.dogmiss.dto.DogMissAdd"%>
<%@page import="user.dogmiss.dto.DogMiss"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>




<!-- Bootstrap 3.3.2 -->
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.2/css/bootstrap.min.css">
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.2/css/bootstrap-theme.min.css">
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.2/js/bootstrap.min.js"></script>




<% DogMiss view = (DogMiss)request.getAttribute("view");%>
<%DogMissFile file = (DogMissFile)request.getAttribute("missFile"); %>

<!-- jQuery 2.2.4 -->
<script type="text/javascript" src="http://code.jquery.com/jquery-2.2.4.min.js"></script>

<style>
.img{
	width:400px;
	height:400px;
}

</style>
<script type="text/javascript">
$(document).ready(function() {
	//목록버튼 동작
	$("#btnList").click(function() {
		$(location).attr("href", "/miss/list");
	});
	
	//수정버튼 동작
	$("#btnUpdate").click(function() {
		$(location).attr("href", "/miss/update?missno=<%=view.getMissNO() %>");
	});
	//삭제버튼 동작
	$("#btnDelete").click(function() {
		$(location).attr("href", "/miss/delete?missno=<%=view.getMissNO() %>");
	});
	
});
</script>



<!DOCTYPE HTML>
<style>
#img{
	height:290px;
}
</style>
<html>
	<head>
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
<table class="table table-condensed">
	<tr>
	
		<th>제목</th>
		<th>이름</th>
		<th>품종</th>
		<th>성별</th>
		<th>분실날짜</th>
		<th>분실장소</th>
		<th>조회수</th>
		<th>내용</th>
	</tr>
	<tr>
		
		<td><%=view.getMissTitle()%></td>
		<td><%=view.getMissName()%></td>
		<td><%=view.getMissKind()%></td>
		<td><%=view.getMissGender()%></td>
		<td><%=view.getMissDate()%></td>
		<td><%=view.getMissLoc()%></td>
		<td><%=view.getMissHit()%></td>
		<td><%=view.getMissContent()%></td>
	</tr>
</table>


	<div>
		<a href="/upload/<%=file.getMiss_stored_FILE_NAME()%>"
		 download="<%=file.getMiss_org_FILE_NAME()%>"><%=file.getMiss_org_FILE_NAME()%></a>
	</div>


	<img class="img" src ="/upload/<%=file.getMiss_stored_FILE_NAME()%>"/>



	<div class="text-right">	
		<button id="btnList" class="btn btn-primary">목록</button>
		<button id="btnUpdate" class="btn btn-info">수정</button>
		<button id="btnDelete" class="btn btn-danger">삭제</button>
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