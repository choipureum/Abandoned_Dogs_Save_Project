
<%@page import="user.qna.dto.QNA"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<% List<QNA> list = (List)request.getAttribute("qnaList");%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<table>
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
</body>
</html>