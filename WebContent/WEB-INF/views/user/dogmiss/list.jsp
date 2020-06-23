
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



<%List <DogMissAdd> list = (List)request.getAttribute("missList");  %>

<!-- jQuery 2.2.4 -->
<script type="text/javascript" src="http://code.jquery.com/jquery-2.2.4.min.js"></script>

<script type="text/javascript">
$(document).ready(function() {
	
	//글쓰기 버튼 누르면 이동
	$("#write").click(function() {
		location.href="/miss/write";
	});
	
	
	//검색 버틀 클릭하면 리스트 controller로 검색어를 파라미터로 전달 하게된다 
	$("#btnSearch").click(function() {
		location.href="/miss/list?search="+$("#search").val();
	});
	
	
	
	
	
});
</script>


<!DOCTYPE HTML>
<style>
#img{
	height:290px;
}
#serch{
	margin-left:778px;
	margin-top:50px;
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
				
				
				
					
				
				
				<div class="form-inline text-center" id="serch">
					
					<input class="form-control" type="text" id="search" placeholder="품종으로  검색"/>
					<button id="btnSearch" class="btn" >검색</button>&nbsp;&nbsp;
					<button id=write >신고하기</button>
				</div>
				
			<!-- Main -->
				<div id="main">
					<div class="inner">

					<!-- Boxes -->
						<div class="thumbnails">
							<% for(int i=0; i<list.size(); i++) {%>
							<div class="box">
								<a href="/miss/view?missno=<%=list.get(i).getMissNO()%>" class="image fit"><img  id="img" src="/upload/<%=list.get(i).getMiss_stored_FILE_NAME() %>" alt="" /></a>
								<div class="inner">
									<h3>품종 <%=list.get(i).getMissKind()%></h3>
									<span>성별<%=list.get(i).getMissGender()%></span><br>
									<span>장소<%=list.get(i).getMissLoc()%></span><br>
									<span>분실날짜<%=list.get(i).getMissDate()%></span>
								</div>
							</div>
							<%} %>

						</div>

					</div>
				</div>
				
				<!-- 여기가 글쓰기 장소  -->
				
				
			
				
				<div id="paging">
						<c:import url="/WEB-INF/views/user/dogmiss/paging.jsp" />
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