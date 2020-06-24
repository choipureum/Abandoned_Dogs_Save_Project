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


<link href="https://fonts.googleapis.com/css2?family=Do+Hyeon&display=swap" rel="stylesheet">


<% DogMiss view = (DogMiss)request.getAttribute("view");%>
<%DogMissFile file = (DogMissFile)request.getAttribute("missFile"); %>

<!-- jQuery 2.2.4 -->
<script type="text/javascript" src="http://code.jquery.com/jquery-2.2.4.min.js"></script>

<style>
.img{
	width:400px;
	height:400px;
}




.input-group{
	width:400px;
}



.wrapper{
margin: 0 auto;

}


.view{
	text-align:center;
	float:left;
	margin: 0 10px;
	
	
}


#area{
	
	width:411px;
	height:399px;
	position:relative;
}

.ra1{
	position:absolute;
	left:50px;
	top:40px;
	font-size:16px;
	
}
.ra2{
	position:absolute;
	left:50px;
	top:80px;
	font-size:16px;
}
.ra3{
	position:absolute;
	left:50px;
	top:120px;
	font-size:16px;
}
.ra4{
	position:absolute;
	left:50px;
	top:160px;
	font-size:16px;
}
.ra5{
	position:absolute;
	left:50px;
	top:200px;
	font-size:16px;
}
.ra6{
	position:absolute;
	left:50px;
	top:240px;
	font-size:16px;
}
.ra7{
	position:absolute;
	left:280px;
	top:40px;
	font-size:16px;
}

#img{
	height:350px;
}

td {
	margin-left:5px;
}

.tit{
	font-family: 'Do Hyeon', sans-serif;
	font-size:40px;
	color: yellow;
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
					<div class="tit">이  분실견을 찾아 주세요</div>
					<div class="titt">지나가는 개 다시보자 지나친 개 다시보자 마주친 개 다시보자</div><br>
		
<div class="wrapper">					
	<div class="view"><img  class="img" src ="/upload/<%=file.getMiss_stored_FILE_NAME()%>"/></div>
		<div class="view" id="area">					
		
		
		
		
		
		
		
		<span class="ra1">제목&nbsp;&nbsp;&nbsp;<%=view.getMissTitle()%></span><br> 
		<span class="ra2">이름&nbsp;&nbsp;&nbsp;<%=view.getMissName()%></span><br> 
		<span class="ra3">견종&nbsp;&nbsp;&nbsp;<%=view.getMissKind()%></span><br> 
		<span class="ra4">성별&nbsp;&nbsp;&nbsp;<%=view.getMissGender()%></span><br>
		<span class="ra5">분실날짜&nbsp;&nbsp;&nbsp;<%=view.getMissDate()%></span><br>
		<span class="ra6">분실장소&nbsp;&nbsp;&nbsp;<%=view.getMissLoc()%></span><br>
		<span class="ra7">조회수&nbsp;&nbsp;&nbsp;<%=view.getMissHit()%></span>
		
		
		
	</div>
</div>	

	<table style="width:100px;">
	<tr>
		
		<td><textarea  readonly cols="5" rows="10" style="width:820px;"><%=view.getMissContent()%></textarea></td>
	</tr>
	</table>
	



	<div class="text-right">	
		<button id="btnList" class="btn btn-info">목록</button>
		<button id="btnUpdate" class="btn btn-info">수정</button>
		<button id="btnDelete" class="btn btn-info">삭제</button>
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
			<script src="/resources/UserBoardTemplate/assets/js/jquery.min.js"></script>
			<script src="/resources/UserBoardTemplate/assets/js/jquery.scrolly.min.js"></script>
			<script src="/resources/UserBoardTemplate/assets/js/jquery.poptrox.min.js"></script>
			<script src="/resources/UserBoardTemplate/assets/js/skel.min.js"></script>
			<script src="/resources/UserBoardTemplate/assets/js/util.js"></script>
			<script src="/resources/UserBoardTemplate/assets/js/main.js"></script>

	</body>
</html>