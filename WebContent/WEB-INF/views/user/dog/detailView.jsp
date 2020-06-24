<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
    
    

<%@page import="user.dog.dto.Dog_Data"%>
<%@page import="java.util.List"%>
<%List<Dog_Data> list = (List)request.getAttribute("dogList");  %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>

		<meta name="viewport" content="width=device-width, initial-scale=1" />
		<link rel="stylesheet" href="/resources/UserBoardTemplate/assets/css/main.css" />

</head>
<body>

<div class="box" >
		<h3>입양신청</h3>
	<a href="" class="image fit" style="left:25%" ><img src="/upload/${dog.dog_stored_file_name }"/></a>
		<div class="inner">
			<div>이름 ${dog.dogname }</div>
               <div>성별 ${dog.doggender }</div>
               <div>품종 ${dog.dogkind }</div>
               <div>중성화여부 ${dog.dogneu }</div>
               <div>공고일 ${dog.dogdate }</div>
			<form action="post" onclick=""><button>입양신청</button></form>
		</div>
</div>





<!-- Scripts -->
			<script src="/resources/UserBoardTemplate/assets/js/jquery.min.js"></script>
			<script src="/resources/UserBoardTemplate/assets/js/jquery.scrolly.min.js"></script>
			<script src="/resources/UserBoardTemplate/assets/js/jquery.poptrox.min.js"></script>
			<script src="/resources/UserBoardTemplate/assets/js/skel.min.js"></script>
			<script src="/resources/UserBoardTemplate/assets/js/util.js"></script>
			<script src="/resources/UserBoardTemplate/assets/js/main.js"></script>

</body>
</html>