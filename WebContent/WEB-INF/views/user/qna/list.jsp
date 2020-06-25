<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<!-- Bootstrap 3.3.2 -->
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.2/css/bootstrap.min.css">
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.2/css/bootstrap-theme.min.css">
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.2/js/bootstrap.min.js"></script>


<script type="text/javascript"
src="https://code.jquery.com/jquery-2.2.4.min.js"></script>

<script type="text/javascript">
$(document).ready(function() {
	
	//글쓰기 버튼 누르면 이동
	$("#btnWrite").click(function() {
		location.href="/qna/write";
	});
	
	//검색 버틀 클릭하면 리스트 controller로 검색어를 파라미터로 전달 하게된다 
	$("#btnSearch").click(function() {
		location.href="/qna/list?search="+$("#search").val();
	});
	
});
</script>



<!DOCTYPE html>
<html>


<style type="text/css">
table, th {
	text-align: center;
}

tr td:nth-child(2) {
	text-align: left;
}

tr td:not(:first-child), tr th:not(:first-child) {
	border-left: 1px solid white;
}

</style>





<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<div class="container">

<h1>게시글 목록</h1>
<hr>

<table class="table table-hover table-condensed table-striped">
<tr class="info">
	<th style="width: 10%">글번호</th>
	<th style="width: 50%">제목</th>
	<th style="width: 15%">아이디</th>
	<th style="width: 10%">조회수</th>
	<th style="width: 15%">작성일</th>
</tr>
<c:forEach items="${list }" var="board">
<tr>
	<td>${board.qnaNO }</td>
	<td><a href="/qna/view?qnano=${board.qnaNO }">${board.qnaTitle }</a></td>
	<td>${board.qnaWriter }</td>
	<td>${board.qnaHit }</td>
	<td><fmt:formatDate value="${board.qnaDate }" pattern="yyyy-MM-dd"/></td>
</tr>
</c:forEach>
</table>



<div id="btnBox">
	<button id="btnWrite" class="btn btn-primary">글쓰기</button>
</div>

<div class="form-inline text-center">
	<input class="form-control" type="text" id="search" />
	<button id="btnSearch" class="btn">검색</button>
</div>


<jsp:include page="/commons/paging.jsp" />

</div><!-- .container -->
</body>
</html>