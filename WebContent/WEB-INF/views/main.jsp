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
		<link rel="stylesheet" href="/resources/UserTemplate/assets/css/main.css" />
	</head>
	<body>

		<!-- Header -->
			<header id="header">
				<nav class="left">
					<a href="#menu"><span>Menu</span></a>
				</nav>
				<a href="/main" class="logo">DaSom</a>
				<nav class="right">
					<a href="#" class="button alt">Login</a>
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

		<!-- Banner -->
			<section id="banner">
			
				<div class="content">
					<h1>For Dog, For Human</h1>
					<p>DaSom은 언제나 유기견들과 함께합니다 </p>
					<ul class="actions">
						<li><a href="#one" class="button scrolly">DaSom 알아보기</a></li>
					</ul>
				</div>
			</section>

		<!-- One -->
			<section id="one" class="wrapper">
				<div class="inner flex flex-3">
					<div class="flex-item left">
						<div>
							<h3>Magna ultricies</h3>
							<p>Morbi in sem quis dui plalorem ipsum<br /> euismod in, pharetra sed ultricies.</p>
						</div>
						<div>
							<h3>Ipsum adipiscing lorem</h3>
							<p>Tristique yonve cursus jam nulla quam<br /> loreipsu gravida adipiscing lorem</p>
						</div>
					</div>
					<div class="flex-item image fit round">
						<img src="images/pic01.jpg" alt="" />
					</div>
					<div class="flex-item right">
						<div>
							<h3>Tempus nullam</h3>
							<p>Sed adipiscing ornare risus. Morbi estes<br /> blandit sit et amet, sagittis magna.</p>
						</div>
						<div>
							<h3>Suscipit nibh dolore</h3>
							<p>Pellentesque egestas sem. Suspendisse<br /> modo ullamcorper feugiat lorem.</p>
						</div>
					</div>
				</div>
			</section>

		<!-- Two -->
			<section id="two" class="wrapper style1 special">
				<div class="inner">
					<h2>Feugiat lorem</h2>
					<figure>
					    <blockquote>
					        "Morbi in sem quis dui placerat ornare. Pellentesque odio nisi, euismod in, pharetra<br /> magna etiam lorem ultricies in diam. Sed arcu cras consequat."
					    </blockquote>
					    <footer>
					        <cite class="author">Jane Anderson</cite>
					        <cite class="company">CEO, Untitled</cite>
					    </footer>
					</figure>
				</div>
			</section>

		<!-- Three -->
			<section id="three" class="wrapper">
				<div class="inner flex flex-3">
					<div class="flex-item box">
						<div class="image fit">
							<img src="images/pic02.jpg" alt="" />
						</div>
						<div class="content">
							<h3>Consequat</h3>
							<p>Placerat ornare. Pellentesque od sed euismod in, pharetra ltricies edarcu cas consequat.</p>
						</div>
					</div>
					<div class="flex-item box">
						<div class="image fit">
							<img src="images/pic03.jpg" alt="" />
						</div>
						<div class="content">
							<h3>Adipiscing</h3>
							<p>Morbi in sem quis dui placerat Pellentesque odio nisi, euismod pharetra lorem ipsum.</p>
						</div>
					</div>
					<div class="flex-item box">
						<div class="image fit">
							<img src="images/pic04.jpg" alt="" />
						</div>
						<div class="content">
							<h3>Malesuada</h3>
							<p>Nam dui mi, tincidunt quis, accu an porttitor, facilisis luctus que metus vulputate sem magna.</p>
						</div>
					</div>
				</div>
			</section>

		<c:import url="/WEB-INF/views/user/util/footer.jsp"></c:import>

		<!-- Scripts -->
			<script src="/resources/UserTemplate/assets/js/jquery.min.js"></script>
			<script src="/resources/UserTemplate/assets/js/jquery.scrolly.min.js"></script>
			<script src="/resources/UserTemplate/assets/js/skel.min.js"></script>
			<script src="/resources/UserTemplate/assets/js/util.js"></script>
			<script src="/resources/UserTemplate/assets/js/main.js"></script>

	</body>
</html>