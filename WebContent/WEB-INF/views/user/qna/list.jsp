
<%@page import="user.qna.dto.QNA"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!-- jQuery 2.2.4.min -->
<script type="text/javascript" src="https://code.jquery.com/jquery-2.2.4.min.js"></script>
<!-- 부트스트랩 3.3.2 -->
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.2/css/bootstrap.min.css">
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.2/css/bootstrap-theme.min.css">
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.2/js/bootstrap.min.js"></script>
<% List<QNA> list = (List)request.getAttribute("qnaList");%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style>
#wrapperb button{ border: 1px solid ; 
background-color: rgba(0,0,0,0); 

padding: 5px; }

#writeb{ border-top-left-radius: 5px; 
 border-top-right-radius: 5px; 
 border-bottom-left-radius: 5px;
 border-bottom-right-radius: 5px;
 margin-right:13%  }

</style>
</head>
<body>
<div class="container">
<table class="table table-hover table-condensed">
	<tr>
		<th>번호</th>
		<th>제목</th>
		<th>내용</th>
		<th>작성일</th>
		<th>작성자</th>
		<th>조회수</th>
	</tr>
	
	
	
	<% for(int i=0; i<list.size(); i++) {%>
	<tr>
		<td><%=list.get(i).getQnaNO()%></td>
		<td><%=list.get(i).getQnaTitle()%></td>
		<td><%=list.get(i).getQnaContent()%></td>
		<td><%=list.get(i).getQnaDate()%></td>
		<td><%=list.get(i).getQnaWriter()%></td>
		<td><%=list.get(i).getQnaHit()%></td>
	</tr>
	<%} %>
</table>
</div>
<div class="text-right" id="wrapperb">
<form action="#" method="get">
	
		<button id="writeb">글쓰기</button>
	
</form>
</div>
<div class="text-center">
	<ul class="pagination">
		<li><a href="#">1</a></li>
		<li><a href="#">2</a></li>
		<li><a href="#">3</a></li>
		<li><a href="#">4</a></li>
		<li><a href="#">5</a></li>
	</ul>
</div>
</body>
</html>