<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>



<c:if test="${list.applysw eq '0'}">
	<td>입양신청가능합니다</td>
	</c:if>
	
	<c:if test="${list.applysw eq '1'}">
	<td>입양신청대기중 입니다</td>
	</c:if>
	<c:if test="${list.applysw eq '2'}">
	<td>거절되었습니다</td>
	</c:if>
</body>
</html>