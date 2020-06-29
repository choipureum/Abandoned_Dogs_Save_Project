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
		<!-- 뱃지 아이콘 -->
		<style>
		.badge {
  display: inline-block;
  padding: 0.25em 0.4em;
  font-size: 75%;
  font-weight: 700;
  line-height: 1;
  text-align: center;
  white-space: nowrap;
  vertical-align: baseline;
  border-radius: 0.35rem;
  transition: color 0.15s ease-in-out, background-color 0.15s ease-in-out, border-color 0.15s ease-in-out, box-shadow 0.15s ease-in-out;
}

@media (prefers-reduced-motion: reduce) {
  .badge {
    transition: none;
  }
}

a.badge:hover, a.badge:focus {
  text-decoration: none;
}

.badge:empty {
  display: none;
}

.btn .badge {
  position: relative;
  top: -1px;
}

.badge-pill {
  padding-right: 0.6em;
  padding-left: 0.6em;
  border-radius: 10rem;
}

.badge-primary {
  color: #fff;
  background-color: #4e73df;
}

a.badge-primary:hover, a.badge-primary:focus {
  color: #fff;
  background-color: #2653d4;
}

a.badge-primary:focus, a.badge-primary.focus {
  outline: 0;
  box-shadow: 0 0 0 0.2rem rgba(78, 115, 223, 0.5);
}

.badge-secondary {
  color: #fff;
  background-color: #858796;
}

a.badge-secondary:hover, a.badge-secondary:focus {
  color: #fff;
  background-color: #6b6d7d;
}

a.badge-secondary:focus, a.badge-secondary.focus {
  outline: 0;
  box-shadow: 0 0 0 0.2rem rgba(133, 135, 150, 0.5);
}

.badge-success {
  color: #fff;
  background-color: #1cc88a;
}

a.badge-success:hover, a.badge-success:focus {
  color: #fff;
  background-color: #169b6b;
}

a.badge-success:focus, a.badge-success.focus {
  outline: 0;
  box-shadow: 0 0 0 0.2rem rgba(28, 200, 138, 0.5);
}

.badge-info {
  color: #fff;
  background-color: #36b9cc;
}

a.badge-info:hover, a.badge-info:focus {
  color: #fff;
  background-color: #2a96a5;
}

a.badge-info:focus, a.badge-info.focus {
  outline: 0;
  box-shadow: 0 0 0 0.2rem rgba(54, 185, 204, 0.5);
}

.badge-warning {
  color: #fff;
  background-color: #f6c23e;
}

a.badge-warning:hover, a.badge-warning:focus {
  color: #fff;
  background-color: #f4b30d;
}

a.badge-warning:focus, a.badge-warning.focus {
  outline: 0;
  box-shadow: 0 0 0 0.2rem rgba(246, 194, 62, 0.5);
}

.badge-danger {
  color: #fff;
  background-color: #e74a3b;
}

a.badge-danger:hover, a.badge-danger:focus {
  color: #fff;
  background-color: #d52a1a;
}

a.badge-danger:focus, a.badge-danger.focus {
  outline: 0;
  box-shadow: 0 0 0 0.2rem rgba(231, 74, 59, 0.5);
}

.badge-light {
  color: #3a3b45;
  background-color: #f8f9fc;
}

a.badge-light:hover, a.badge-light:focus {
  color: #3a3b45;
  background-color: #d4daed;
}

a.badge-light:focus, a.badge-light.focus {
  outline: 0;
  box-shadow: 0 0 0 0.2rem rgba(248, 249, 252, 0.5);
}

.badge-dark {
  color: #fff;
  background-color: #5a5c69;
}

a.badge-dark:hover, a.badge-dark:focus {
  color: #fff;
  background-color: #42444e;
}

a.badge-dark:focus, a.badge-dark.focus {
  outline: 0;
  box-shadow: 0 0 0 0.2rem rgba(90, 92, 105, 0.5);
}	
		
		</style>
					
		</head>   
    <body>
		<!-- Header -->
			<header id="header">
				<nav class="left">
					<a href="#menu"><span>Menu</span></a>
				</nav>
				<a class="nav-link dropdown-toggle" href="#" id="alertsDropdown" role="button" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
                <i class="fas fa-envelope fa-fw"></i>
                <!-- Counter - Alerts -->
                <span class="badge badge-danger badge-counter">5</span>
              </a>
		
				<a href="/main" class="logo">DaSom</a>									
				<nav class="right">
					 <c:if test="${empty login }"> 
					<a href="#" class="button alt open">Login</a>
					</c:if>
					<c:if test="${not empty login }">
			<!-- 	<a href="#" class ="button alt open">LogOut</a> -->
						<%=session.getAttribute("userid") %> 님 환영합니다!&nbsp;&nbsp;&nbsp;
					<input type ="button" value="Logout" class="button alt open" onclick="location.href='/logout/logout'" />
					</c:if>
				</nav>
				
				
			</header>

		<!-- Menu -->
			<nav id="menu">
				<ul class="links">
					<li><a href="/main">홈</a></li>
					<c:if test="${not empty login }">
						<li><a href="/mypage/main">마이페이지</a></li>
					</c:if>
					<li><a href="generic.html">가족찾기</a></li>
					<li><a href="elements.html">분실견</a></li>
					<li><a href="elements.html">보호소 지도찾기</a></li>
					<li><a href="elements.html">QNA</a></li>
					<li><a href="/dog/list">가족찾기</a></li>
					<li><a href="/miss/list">분실견</a></li>
					<li><a href="/dog_shelter/list">보호소 지도찾기</a></li>
					<li><a href="/qna/list">QNA</a></li>
				</ul>
<!-- 				<ul class="actions vertical"> -->
<!-- 					<li><a href="#" class="button fit">Login</a></li> -->
<!-- 				</ul> -->
			</nav>