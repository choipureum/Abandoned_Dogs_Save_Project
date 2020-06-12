<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>

<link rel="stylesheet" type="text/css" href="../css/style.css">

<!-- 모든 페이지에 jQuery 라이브러리 추가됨 -->
<script type="text/javascript"
src="https://code.jquery.com/jquery-2.2.4.min.js"></script>

<script type="text/javascript">
// 모든 페이지에 적용되는 공통 Javascript
$(document).ready(function() {

	var gnb = $(".gnb").offset().top;
	$(window).scroll(function() { //스크롤하면 아래 코드 실행
	  	var window = $(this).scrollTop();

	    if(gnb <= window) {
	      $(".gnb").addClass("fixed");
	    } else {
	      $(".gnb").removeClass("fixed");
	    }
	})
 });
</script>
</head>
<body>
	<!-- header 영역  -->
	<header id="header">
		<div id="top_header">
			<!-- .logo  -->
			<a href="#"><img src="../resources/h_logo_1.png" width="150" height="150" class="logo"></a>
			<ul class="lnb">
          <!-- ** .lnb 시작 ** -->
          <li><a href="#">Login</a></li>
          <li><a href="#">Join</a></li>
        </ul>
		</div>
		<!--  .gnb 영역  -->
		<div class="gnb">
			<ul class="gnb_group">
				<li class="gnb_box"><a class="gnb_title" href="#section-1">사이트소개</a></li>
				<li class="gnb_box"><a class="gnb_title" href="#section-2">입양안내</a></li>
				<li class="gnb_box"><a class="gnb_title" href="#">가족찾기</a></li>
				<li class="gnb_box"><a class="gnb_title" href="#">분실신고</a></li>
				<li class="gnb_box"><a class="gnb_title" href="#">커뮤니티</a>
			</ul>
			<!-- .gnb end -->
		</div>
	</header>
	<!-- header end -->