<%@page import="user.member.dto.MemberAddDTO"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
 <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>   
 <%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
 
 <script type="text/javascript"src="https://code.jquery.com/jquery-2.2.4.min.js"></script>

    
<!-- Bootstrap 3.3.2 -->
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.2/css/bootstrap.min.css">
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.2/css/bootstrap-theme.min.css">
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.2/js/bootstrap.min.js"></script>    



    
    
    
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
<c:forEach items="${list}" var="list">
<input type="hidden" name="userid" value="${list.userid }">
<tr>
	<td><input type="checkbox" name="check" ></td>
	<td><img style="width:30px; "id="img" src="/upload/${list.dog_stored_FILE_NAME }" alt="" /></td>
	<td>${list.dogKind}</td>
	<td>${list.dogGender}</td>
	<td>${list.dogEndDate}</td>
	
	<c:if test="${list.applysw eq 0}">
	<td>입양신청가능합니다</td>
	</c:if>
	<c:if test="${list.applysw eq 1}">
	<td>입양신청대기중 입니다</td>
	</c:if>
	<c:if test="${list.applysw eq 2}">
	<td>거절되었습니다</td>
	</c:if>
</tr>
</c:forEach>

</table>
	


<div id="btnBox">
	<button id="btnWrite" class="btn btn-primary">입양신청</button>
</div>




<div id="paging">
	<c:import url="/commons/paging.jsp" />
</div>

</div><!-- .container -->


</body>
</html>