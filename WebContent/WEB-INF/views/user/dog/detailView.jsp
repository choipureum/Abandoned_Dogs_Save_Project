<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
    
    

<%@page import="user.dog.dto.DogDTO"%>
<%@page import="user.dog.dto.Dog_File_DTO"%>

<%DogDTO detailDog = (DogDTO) request.getAttribute("detailDog");  %>
<%Dog_File_DTO dogFile = (Dog_File_DTO) request.getAttribute("dogFile");  %>

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
	<img src="/upload/${dogFile.dog_stored_file_name }" style="width:500px;"/>
		<div class="inner">
			<div>이름 &nbsp;${detailDog.dogname }</div>
               <div>성별 &nbsp;${detailDog.doggender }</div>
               <div>품종 &nbsp;${detailDog.dogkind }</div>
               <div>중성화여부 &nbsp;${detailDog.dogneu }</div>
               <div>공고일 &nbsp;${detailDog.dogdate }</div>
			<a href="/views/user/dog/adoptView.jsp"><button onclick=" ">입양신청</button></a>
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