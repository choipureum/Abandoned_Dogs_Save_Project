<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!-- Bootstrap 3.3.2 -->
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.2/css/bootstrap.min.css">
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.2/css/bootstrap-theme.min.css">
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.2/js/bootstrap.min.js"></script>



<script type="text/javascript"
src="https://code.jquery.com/jquery-2.2.4.min.js"></script>

<!DOCTYPE html>
<html>
<script type="text/javascript">
$(document).ready(function() {
	//목록버튼 동작
	$("#btnList").click(function() {
		$(location).attr("href", "/qna/list");
	});
	
	//수정버튼 동작
	$("#btnUpdate").click(function() {
		$(location).attr("href", "/qna/update?qnano=${viewBoard.qnaNO }");
	});

	//삭제버튼 동작
	$("#btnDelete").click(function() {
		$(location).attr("href", "/qna/delete?qnano=${viewBoard.qnaNO }");
	});
	
});
</script>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<div class="container">

<h1 class="pull-left">게시판 - 상세보기</h1>



<div class="clearfix"></div>

<hr>

<table class="table table-bordered">
<tr>
<td class="info">글번호</td><td colspan="3">${viewBoard.qnaNO }</td>
</tr>

<tr>
<td class="info">제목</td><td colspan="3">${viewBoard.qnaTitle }</td>
</tr>

<tr>
<td class="info">아이디</td><td>${viewBoard.qnaWriter }</td>
</tr>

<tr>
<td class="info">조회수</td><td>${viewBoard.qnaHit }</td>

</tr>

<tr>
<td class="info">작성일</td><td colspan="3">${viewBoard.qnaDate }</td>
</tr>

<tr><td class="info"  colspan="4">본문</td></tr>

<tr><td colspan="4">${viewBoard.qnaContent }</td></tr>

</table>

<div>
<a href="/file/download?fileno=${boardFile.qna_fileNo }">${boardFile.qna_org_FILE_NAME }</a>
</div>

<div class="text-center">	
	<button id="btnList" class="btn btn-primary">목록</button>
	
	<!-- <c:if test="${userid eq viewBoard.qnaWriter }"> -->
	
	<button id="btnUpdate" class="btn btn-info">수정</button>
	<button id="btnDelete" class="btn btn-danger">삭제</button>
	
	<!--</c:if>-->
</div>









</div><!-- .container -->
</body>
</html>