<%@page import="user.dog_shleter.dto.Dog_Shelter"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

	<%	Dog_Shelter l = (Dog_Shelter) request.getAttribute("res"); %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<h1>TEST 유기견 정보 조회</h1>
<hr>
<table border="1">
<tr>
	<th>유기견 보호소 번호</th>
	<th>유기견 보호소 명</th>
	<th>유기견 보호소 주소</th>
	<th>유기견 보호소 전화번호</th>
</tr>
<tr>
	<td><%=l.getShelterno() %></td>
	<td><%=l.getSheltername()%></td>
	<td><%=l.getShelteraddress() %></td>
	<td><%=l.getSheltertel() %></td>
</tr>

</table>


</body>
</html>