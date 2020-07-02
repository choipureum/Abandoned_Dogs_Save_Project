
<%@page import="user.dogmiss.dto.DogMissAdd"%>
<%@page import="user.dogmiss.dto.DogMiss"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!-- 부트스트랩 3.3.2 -->
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.2/css/bootstrap.min.css">
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.2/css/bootstrap-theme.min.css">
<script
	src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.2/js/bootstrap.min.js"></script>

<script type="text/javascript"
	src="https://code.jquery.com/jquery-2.2.4.min.js"></script>


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
/* 분실견 테이블 */
.table-condensed {
	margin: 0 15% 2em 15%;
	width: 70%;
	line-height: 37px;
}

textarea {
	margin: 3px;
	border: 1px solid #dcdcdc;

}

/* 분실견 버튼 */
#button {
	position: relative;
	display: inline-block;
	left: 70%;
	bottom: 15px;
}

.center {
	text-align: center;
}
label{
	margin: 0;
	bottom: -10px;
}

</style>

<c:import url="/WEB-INF/views/user/util/header.jsp" />
<c:import url="/WEB-INF/views/user/util/sidebar.jsp"></c:import>

<!-- Banner -->
<section id="banner" data-video="images/banner">
	<div class="content">
		<h1>Abandoned dog lost</h1>
		<p>분실견 신고</p>
		<ul class="actions">
			<li><a href="#one" class="button scrolly">분실견 등록</a></li>
		</ul>
	</div>
</section>

<section id="one" class="wrapper">
	<div class="inner" style="margin: 0 auto; text-align: center">
		<h2>분실견 등록</h2>
	</div>
</section>


<form action="/miss/write" method="post" enctype="multipart/form-data">
	<table class="table-condensed">
		<tr>
			<th class="center">제목</th>
			<td><input class="font" type="text" name="title"></td>
		</tr>
		<tr>
			<th class="center">작성자</th>
			<td><input type="text" name="writer" value="<%=session.getAttribute("userid")%>"></td>
		</tr>
		<tr>
			<th class="center">유기견이름</th>
			<td><input type="text" name="name"></td>
		</tr>
		<tr>
			<th class="center">품종</th>
			<td><input type="text" name="kind"></td>
		</tr>
		<tr>
			<th class="center" >성별</th>
			<td><input type="checkbox" name="gender" value="남자"id="checkboxMale"  class="check"/>
				<label for="checkboxMale" style="margin-bottom: 0">남</label>
				<input type="checkbox" name="gender" value="여자" id="checkboxFemale"  class="check"/>
				<label for="checkboxFemale" style="margin-bottom: 0">여</label>
			</td>
		</tr>
		<tr>
			<th class="center">분실 위치</th>
			<td><input type="text" name="loc"></td>
		</tr>
		<tr>
			<th class="center">분실견 사진</th>
			<td><input type="file" name="file"></td>
		</tr>
		<tr>
			<th id="title" class="center">상세내용</th>
		</tr>
		<tr>
			<td colspan="2"><textarea id="content" name="content"  placeholder="더 자세한 사항을 기입해주세요 분실견을 찾는데 도움이 될 수 있습니다 "> </textarea></td>
		</tr>
	</table>
</form>
<div id="button">
	<button id="insert">등록</button>
	<button id="cancel">취소</button>
</div>




<c:import url="/WEB-INF/views/user/util/footer.jsp" />