<%@page import="user.qna.dto.QnaFile"%>
<%@page import="user.qna.dto.QNA"%>
<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
    
<!-- jQuery 2.2.4.min -->
<script type="text/javascript" src="https://code.jquery.com/jquery-2.2.4.min.js"></script>
<!-- 부트스트랩 3.3.2 -->
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.2/css/bootstrap.min.css">
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.2/css/bootstrap-theme.min.css">
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.2/js/bootstrap.min.js"></script>
<% QNA viewqna = (QNA)request.getAttribute("viewqna");%>
<%QnaFile qnafile = (QnaFile)request.getAttribute("qnaFile"); %>
<!DOCTYPE html>
<html>
<head>
<script type="text/javascript">
$(document).ready(function() {
	//목록버튼 동작
	$("#btnList").click(function() {
		$(location).attr("href", "/qna/list");
	});
	
	//수정버튼 동작
	$("#btnUpdate").click(function() {
	});

	//삭제버튼 동작
	$("#btnDelete").click(function() {
	});
	
});
</script>
<meta charset="EUC-KR">
<title>Insert title here</title>
</head>
<body>
<div class="container">
<table class="table table-condensed">
	<tr>
		<th>번호</th>
		<th>제목</th>
		<th>작성일</th>
		<th>작성자</th>
		<th>내용</th>
		<th>조회수</th>
	</tr>
	
	
	<tr>
		<td><%=viewqna.getQnaNO()%></td>
		<td><%=viewqna.getQnaTitle()%></td>
		<td><%=viewqna.getQnaDate()%></td>
		<td><%=viewqna.getQnaWriter()%></td>
		<td><%=viewqna.getQnaContent()%></td>
		<td><%=viewqna.getQnaHit()%></td>
	</tr>
	
</table>


<div>
<a href="/upload/<%=qnafile.getQna_stored_FILR_NAME()%>"
 download="<%=qnafile.getQna_org_FILE_NAME()%>"><%=qnafile.getQna_org_FILE_NAME()%></a>
</div>


<div class="text-right">	
		<button id="btnList" class="btn btn-primary">목록</button>
		<button id="btnUpdate" class="btn btn-info">수정</button>
		<button id="btnDelete" class="btn btn-danger">삭제</button>
</div>
</div>
</body>
</html>