<%@ page language="java" contentType="application/json; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<table border="1">
<tr>
	<th>아이디</th>
	<th>패스워드</th>
</tr>
<c:forEach var="list" items="${shelterList }">
<tr>
	<td>${list.sheltername }</td>
	<td>${list.shelteraddress }</td>
	<td>${list.sheltertel }</td>
</tr>
</c:forEach>
</table>