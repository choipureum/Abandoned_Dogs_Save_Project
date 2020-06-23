<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
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
			<p>이름 : </p>
			<p>성별 : </p>
			<p>품종 : </p>
			<p>중성화여부 : </p>
			<p>공고일 : </p>
			<a href="/dog/adopt" class="button fit" data-poptrox=""  >입양신청</a>
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