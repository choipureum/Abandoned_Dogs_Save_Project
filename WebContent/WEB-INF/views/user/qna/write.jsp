<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>

<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.2/css/bootstrap.min.css">
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.2/css/bootstrap-theme.min.css">
<script
	src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.2/js/bootstrap.min.js"></script>

<script type="text/javascript"
	src="https://code.jquery.com/jquery-2.2.4.min.js"></script>


<script type="text/javascript"
	src="https://code.jquery.com/jquery-2.2.4.min.js"></script>
<!-- 스마트 에디터2 라이브러리 -->
<script type="text/javascript"
	src="/resources/se2/js/service/HuskyEZCreator.js" charset="utf-8"></script>

<script type="text/javascript">
	// <form>이 submit되면
	// 스마트 에디터 내용을 <textarea>반영해주는 함수
	function submitContents(elClickedObj) {
		// 에디터의 내용이 textarea에 적용된다.
		oEditors.getById["content"].exec("UPDATE_CONTENTS_FIELD", []);

		try {
			elClickedObj.form.submit(); // <form> submit 수행
		} catch (e) {
		}
	}
</script>

<script type="text/javascript">
	$(document).ready(function() {

		//작성버튼 동작
		$("#btnWrite").click(function() {

			// 스마트에디터의 내용을 <textarea>에 적용
			submitContents($("#btnWrite"));

			// form submit
			$("form").submit();
		});

		//취소버튼 동작
		$("#btnCancel").click(function() {
			history.go(-1);
		});
	});
</script>

<style type="text/css">
.table-condensed {
	margin: 0 15% 2em 15%;
	width: 70%;
}

#button {
	position: relative;
	display: inline-block;
	left: 70%;
	bottom: 20px;
}

.center {
	text-align: center;
}

.text-center {
	padding: 150px;
}
.btn{
	padding: 0 60px;
	height: 60px;	
}

</style>

<<c:import url="/main/header" />
<c:import url="/WEB-INF/views/user/util/sidebar.jsp"></c:import>


<!-- Banner -->
<section id="banner" data-video="images/banner">
	<div class="content">
		<h1>Solving your questions</h1>
		<p>Q & A</p>
		<ul class="actions">
			<li><a href="#one" class="button scrolly">게시판 등록</a></li>
		</ul>
	</div>
</section>

<section id="one" class="wrapper">
	<div class="inner" style="margin: 0 auto; text-align: center">
		<h2>Q&A 등록</h2>
	</div>
</section>

<form action="/qna/write" method="post" enctype="multipart/form-data">
	<table class="table-condensed">
		<tr>
			<th class="center">아이디</th>
			<td><input type="text" name="writer" value="<%= session.getAttribute("userid") %>" disabled="disabled" /></td>
		</tr>
		<tr>
			<th class="center">제목</th>
			<td><input type="text" name="title" /></td>
		</tr>
		<tr>
			<th id="title" class="center" >본문</th>
		</tr>
		<tr>
			<td colspan="2"><textarea id="content" name="content"></textarea></td>
		</tr>
		<tr>
			<th class="center">첨부파일</th>
			<td><input type="file" name="file" /></td>
		</tr>
	</table>
</form>
<div id="button">
	<button id="btnWrite" class="btn">작성</button>
	<button id="btnCancel" class="btn">취소</button>
</div>
<!-- 스마트 에디터 적용 코드 -->
<!-- <textarea>태그에 스마트 에디터의 스킨을 입히는 코드 -->
<script type="text/javascript">
	var oEditors = [];
	nhn.husky.EZCreator.createInIFrame({
		oAppRef : oEditors,
		elPlaceHolder : "content", // 에디터가 적용되는 <textarea>의 id
		sSkinURI : "/resources/se2/SmartEditor2Skin.html", // 에디터 스킨
		fCreator : "createSEditor2"
	});
</script>

<c:import url="/WEB-INF/views/user/util/footer.jsp" />
