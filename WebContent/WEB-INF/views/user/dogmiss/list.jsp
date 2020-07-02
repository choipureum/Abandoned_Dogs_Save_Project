<%@page import="user.dogmiss.dto.DogMissAdd"%>
<%@page import="user.dogmiss.dto.DogMiss"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%List <DogMissAdd> list = (List)request.getAttribute("missList");  %>

<link href="https://fonts.googleapis.com/css2?family=Noto+Sans+KR:wght@300&family=Noto+Serif+KR:wght@700&display=swap" rel="stylesheet">
<link rel="stylesheet" 	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.2/css/bootstrap.min.css">
<link rel="stylesheet" 	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.2/css/bootstrap-theme.min.css">
<script	src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.2/js/bootstrap.min.js"></script>

<meta name="viewport" content="width=device-width, initial-scale=1" />
<link rel="stylesheet"
	href="/resources/UserBoardTemplate/assets/css/main.css" />


<!-- jQuery 2.2.4 -->
<script type="text/javascript"
	src="http://code.jquery.com/jquery-2.2.4.min.js"></script>

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


<style>

/* 검색, 분실견 등록하기 */
#dd {
	padding: 0 30%;
}

.btn {
	width: 15%
}

#write {
	padding: 0 10px;
	width: 20%;
}

#like {
	height: 150px;
}

#search {
	width: 49%;
	display: inline-block;
}

/* 분실견 리스트 */
#inner {
	display: grid;
	grid-template-columns: 1fr 1fr 1fr 1fr;
	row-gap: 10px;
	column-gap: 35px;
	width: 1500px;
	margin: 0 auto;
	margin-top: 30px;
	position: relative;
}

#img {
	height: 290px;
}

.box {
	overflow: hidden;
}

.box  img {
	-webkit-transform: scale(1);
	-moz-transform: scale(1);
	-ms-transform: scale(1);
	-o-transform: scale(1);
	transform: scale(1);
	-webkit-transition: .3s;
	-moz-transition: .3s;
	-ms-transition: .3s;
	-o-transition: .3s;
	transition: .3s;
}

.box:hover img {
	-webkit-transform: scale(1.2);
	-moz-transform: scale(1.2);
	-ms-transform: scale(1.2);
	-o-transform: scale(1.2);
	transform: scale(1.1);
}

.inner {
	font-family: 'Noto Sans KR', sans-serif;
	font-family: 'Noto Serif KR', serif;
}
</style>


<c:import url="/main/header"></c:import>
<c:import url="/WEB-INF/views/user/util/sidebar.jsp"></c:import>


<!-- Banner -->
<section id="banner" data-video="images/banner">
	<div class="content">
		<h1>Abandoned dog lost</h1>
		<p>분실견 신고</p>
		<ul class="actions">
			<li><a href="#one" class="button scrolly">분실견 조회</a></li>
		</ul>
	</div>
</section>

<section id="one" class="wrapper">
	<div class="inner" style="margin: 0 auto; text-align: center">
		<h2>분실견 조회</h2>
	</div>
</section>


<!-- 이곳이 내가 만든 코드  btnSerch 버튼을 눌렀을 때  search와 search2의 value 값을 전달하고 싶다 -->
<div id="dd">
	<select id="search2" style="width: 14%; display: inline-block;" class="btn">
		<option value="1">제목</option>
		<option value="2">품종</option>
		<option value="3">분실장소</option>
	</select> 
	<input class="form-control" type="text" id="search" />
	<button id="btnSearch" class="btn">검색</button>
	<button id="write" class="btn">분실견 신고하기</button>
</div>

<div id="inner">
	<% for(int i=0; i<list.size(); i++) {%>
	<div class="box">
		<a href="/miss/view?missno=<%=list.get(i).getMissNO()%>"
			class="image fit"><img id="img"
			src="/upload/<%=list.get(i).getMiss_stored_FILE_NAME() %>" alt="" /></a>
		<div class="inner" id="like">
			<div class="inner1" style="padding-top: 20px; font-size: 16px;">
				<p style="color: #eb4629; text-align: center; margin: 0;"><%=list.get(i).getMissTitle()%></p>
			</div>
			<div style="padding-top: 15px;">
				<div
					style="display: inline-block; text-align: center; padding-left: 6px;">
					분실장소<br>분실날짜<br>품종
				</div>
				<div style="display: inline-block; left: 5px; position: relative;">
					<%=list.get(i).getMissLoc()%><br><%=list.get(i).getMissDate()%><br><%=list.get(i).getMissKind()%></div>
			</div>
		</div>
	</div>
	<%} %>
</div>


<c:import url="/WEB-INF/views/user/dogmiss/paging.jsp" />
<c:import url="/WEB-INF/views/user/util/footer.jsp" />

