<%@page import="user.member.dto.MemberAddDTO"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!-- Bootstrap 3.3.2 -->
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.2/css/bootstrap.min.css">
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.2/css/bootstrap-theme.min.css">
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.2/js/bootstrap.min.js"></script>    


<%List <MemberAddDTO> list = (List)request.getAttribute("list"); %>
    
    
    
<!DOCTYPE html>
<html>







<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<div class="container">

<h1>찜목록</h1>
<hr>

<table class="table table-hover table-condensed table-striped">
<tr class="info">
	<th >체크</th>
	
	<th >이미지</th>
	<th >견종</th>
	<th >성별</th>
	<th>엔드데이트</th>
	<th>입양신청 상태</th>
</tr>
<c:forEach items="${list }" var="board">
<tr>
	<td><input type="checkbox" name="check"></td>
	
	<td>이미지</td>
	<td>견종</td>
	<td>성별</td>
	<td>엔드데이트</td>
	<td>입양신청상태</td>
</tr>
</c:forEach>
</table>



<div id="btnBox">
	<button id="btnWrite" class="btn btn-primary">입양신청하기</button>
</div>




<jsp:include page="/commons/paging.jsp" />

</div><!-- .container -->


</body>
</html>