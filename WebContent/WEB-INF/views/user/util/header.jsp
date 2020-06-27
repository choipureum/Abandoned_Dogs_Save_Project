<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>


<!DOCTYPE HTML>

<html>
	<head>
		<title>DaSom</title>
		<meta charset="utf-8" />
		<meta name="viewport" content="width=device-width, initial-scale=1" />
		<script src="https://code.jquery.com/jquery-2.2.4.min.js"></script>
		 <link href="/resources/AdminTemplate/vendor/fontawesome-free/css/all.min.css" rel="stylesheet" type="text/css">
		 <link href="https://fonts.googleapis.com/icon?family=Material+Icons" rel="stylesheet">
		<link rel="stylesheet" href="/resources/UserTemplate/assets/css/main.css" />  
		<!-- Scripts -->			
		<script src="/resources/UserTemplate/assets/js/jquery.min.js"></script>
		<script src="/resources/UserTemplate/assets/js/jquery.scrolly.min.js"></script>
		<script src="/resources/UserTemplate/assets/js/skel.min.js"></script>
		<script src="/resources/UserTemplate/assets/js/util.js"></script>
		<script src="/resources/UserTemplate/assets/js/main.js"></script>
		</head>   
    <body>
		<!-- Header -->
			<header id="header">
				<nav class="left">
					<a href="#menu"><span>Menu</span></a>
				</nav>
				<a href="/main" class="logo">DaSom</a>
				<nav class="right">
					 <c:if test="${empty login }"> 
					<a href="#" class="button alt open">Login</a>
					</c:if>
					<c:if test="${not empty login }">
<!-- 					<a href="#" class ="button alt open">LogOut</a> -->
						<%=session.getAttribute("userid") %> 님 환영합니다!
					<input type ="button" value="Logout" class="button alt open" onclick="location.href='/logout/logout'" />
					</c:if>
				</nav>
				
				
			</header>

		<!-- Menu -->
			<nav id="menu">
				<ul class="links">
					<li><a href="/main">홈</a></li>
					<li><a href="generic.html">가족찾기</a></li>
					<li><a href="elements.html">분실견</a></li>
					<li><a href="elements.html">보호소 지도찾기</a></li>
					<li><a href="elements.html">QNA</a></li>
				</ul>
				<ul class="actions vertical">
					<li><a href="#" class="button fit">Login</a></li>
				</ul>
			</nav>