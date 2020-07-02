<%@page import="user.dogmiss.dto.DogMissFile"%>
<%@page import="user.dogmiss.dto.DogMissAdd"%>
<%@page import="user.dogmiss.dto.DogMiss"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<%
	DogMiss view = (DogMiss) request.getAttribute("viewBoard");
%>
<%
	DogMissFile file = (DogMissFile) request.getAttribute("boardF");
%>



<!-- jQuery 2.2.4 -->
<script type="text/javascript"
	src="http://code.jquery.com/jquery-2.2.4.min.js"></script>

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

<style>
#missUpdate {
	margin: 0 15% 2em 18%;
	width: 65%;
	line-height: 50px;
}

.text-center {
	position: relative;
	display: inline-block;
	left: 70%;
	bottom: 20px;
}

.btn {
	padding: 0 60px;
	height: 60px;
}

.center {
	text-align: center;
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
			<li><a href="#one" class="button scrolly">분실견 수정</a></li>
		</ul>
	</div>
</section>

<section id="one" class="wrapper">
	<div class="inner" style="margin: 0 auto; text-align: center">
		<h2>분실견 수정</h2>
	</div>
</section>

<!-- Main -->
<div id="missUpdate">
	<form action="/miss/update" method="post" enctype="multipart/form-data">
		<input type="hidden" name="missno" value="<%=view.getMissNO()%>" />
		<table class="table-condensed">

			<tr>
				<th class="center">제목</th>
				<td><input type="text" name="title"
					value="<%=view.getMissTitle()%>"></td>
			</tr>
			<tr>
				<th class="center">작성자</th>
				<td><%=view.getMissWriter()%></td>
			</tr>
			<tr>
				<th class="center">유기견이름</th>
				<td><input type="text" name="name"
					value="<%=view.getMissName()%>"></td>
			</tr>
			<tr>
				<th class="center">품종</th>
				<td><input type="text" name="kind"
					value="<%=view.getMissKind()%>"></td>
			</tr>
			<tr>
				<th class="center">성별</th>
				<td><input type="checkbox" name="gender" value="남자"
					id="checkboxMale" /><label for="checkboxMale">남</label> <input
					type="checkbox" name="gender" value="여자" id="checkboxFemale" /> <label
					for="checkboxFemale">여</label></td>
			</tr>
			<tr>
				<th class="center">분실 위치</th>
				<td><input type="text" name="loc"
					value="<%=view.getMissLoc()%>"></td>
			</tr>
			<tr>
				<th id="title" class="center">상세내용</th>
			</tr>
			<tr>
				<td colspan="2"><textarea name="content" id="content" cols="5"
						rows="10"><%=view.getMissContent()%></textarea></td>
			</tr>
		</table>

		<label>기존파일 : <a
			href="/upload/<%=file.getMiss_stored_FILE_NAME()%>"
			download="<%=file.getMiss_org_FILE_NAME()%>">"<%=file.getMiss_org_FILE_NAME()%></a></label>
		<label>첨부파일 : <input type="file" name="file" /></label>

	</form>
</div>

<div class="text-center">
	<button type="button" id="insert" class="btn">수정 적용</button>
	<button type="button" id="cancel" class="btn">취소</button>
</div>




<c:import url="/WEB-INF/views/user/util/footer.jsp" />