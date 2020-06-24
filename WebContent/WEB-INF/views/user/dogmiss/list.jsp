
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
		location.href="/miss/list?search="+$("#search").val()+"&search2="+$("#search2").val();
		
	});
	
	
	
	
	
});
</script>


<!DOCTYPE HTML>
<style>

#write{
	margin-top: 30px;
    margin-left: 1220px;
}
#img{
	height:290px;
}

#like{
	height:150px;
}

.inner1{
	position:absolute;
	
	left:120px;	
	
}
#search2{
	display:inline;

}
#search{
	display:inline;
}

	
.inner2{
	position:absolute;
	
	left:120px;
	top:340px;
}
.inner3{
	position:absolute;
	
	left:120px;
	top:370px;
}
.inner4{
	position:absolute;
	
	left:120px;
	top:400px;
}

.box{
	position:relative;
}

#dd{
	margin-left: 1060;
    margin-top: 50;

}


.box{ overflow: hidden; }

.box  img {
    -webkit-transform:scale(1);
    -moz-transform:scale(1);
    -ms-transform:scale(1); 
    -o-transform:scale(1);  
    transform:scale(1);
    -webkit-transition:.3s;
    -moz-transition:.3s;
    -ms-transition:.3s;
    -o-transition:.3s;
    transition:.3s;
}
.box:hover img {
    -webkit-transform:scale(1.2);
    -moz-transform:scale(1.2);
    -ms-transform:scale(1.2);   
    -o-transform:scale(1.2);
    transform:scale(1.2);
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
				
				
				
					
				<!-- 검색 keyword를 전달하는 sql문  google에서 따온 코드 
				<form action="board-search" method="get">
    				<select name="searchCategory">
        				<option value="1">작성자</option>
        				<option value="2">글제목</option>
        				<option value="3">글제목 + 내용</option>
   					 </select>
   					 <input type="text" name="searchKeyword"  placeholder="키워드" required />
    				 <input type="submit" value="검색" />
				</form>
				-->
				
				
			<!-- 이곳이 내가 만든 코드  btnSerch 버튼을 눌렀을 때  search와 search2의 value 값을 전달하고 싶다 -->
				<div id="dd">
				<select id="search2" style="width:100px;">
        			<option value="1">제목</option>
        			<option value="2">품종</option>
        			<option value="3">분실장소</option>
   				</select>
				<input class="form-control" type="text" id="search" style="width:100px" />
				<button id="btnSearch" class="btn">검색</button>
				</div>
				<button id="write">신고하기</button>
			
				
				
				
				
				<!--  이곳이 원본이다 
				<div class="form-inline text-center" id="serch">
					<input class="form-control" type="text" id="search" placeholder="품종으로  검색"/>
					<button id="btnSearch" class="btn" >검색</button>&nbsp;&nbsp;
					<button id="write" >신고하기</button>
				</div>
				 -->
			
			
			
			
			
			<!-- Main -->
				<div id="main">
					<div class="inner">

					<!-- Boxes -->
						<div class="thumbnails">
							<% for(int i=0; i<list.size(); i++) {%>
							<div class="box">
								<a href="/miss/view?missno=<%=list.get(i).getMissNO()%>" class="image fit"><img id="img" src="/upload/<%=list.get(i).getMiss_stored_FILE_NAME() %>" alt="" /></a>
								<div class="inner" id="like">
									<div class="inner1"><h4 style="text-color:red;"><span class="glyphicon glyphicon-menu-right" aria-hidden="true"></span>&nbsp;제목&nbsp;:&nbsp;&nbsp;<%=list.get(i).getMissTitle()%></h4></div>
									<div class="inner2">분실장소&nbsp;:&nbsp;&nbsp;<%=list.get(i).getMissLoc()%></div>
									<div class="inner3">분실날짜&nbsp;:&nbsp;&nbsp;<%=list.get(i).getMissDate()%></div>
									<div class="inner4">품종&nbsp;:&nbsp;&nbsp;<%=list.get(i).getMissKind()%></div>
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