
<%@page import="user.qna.dto.QNA"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

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
	</tr>
	
	<% List<QNA> list = (List)request.getAttribute("qnalist");
	
	for(int i=0; i<list.size(); i++) {%>
	<tr>
		<td><%=list.get(i).getQnaNO()%></td>
		<td><%=list.get(i).getQnaTitle()%></td>
	</tr>
	<%} %>
</table>
</body>
</html>