<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%@page import="user.dog.dto.Dog_Data"%>
<%@page import="java.util.List"%>
<%List<Dog_Data> list = (List)request.getAttribute("dogList");  %>
<!DOCTYPE HTML>
<!--
	Full Motion by TEMPLATED
	templated.co @templatedco
	Released for free under the Creative Commons Attribution 3.0 license (templated.co/license)
-->
<html>
	<head>
		<title>Full Motion</title>
		<meta charset="utf-8" />
		<meta name="viewport" content="width=device-width, initial-scale=1" />
		<link rel="stylesheet" href="/resources/UserBoardTemplate/assets/css/main.css" /><!--  -->
	</head>
	<body id="top">

			<!-- Banner -->
			<!--
				To use a video as your background, set data-video to the name of your video without
				its extension (eg. images/banner). Your video must be available in both .mp4 and .webm
				formats to work correctly.
			-->
				<section id="banner" data-video="images/banner">
					<div class="inner">
						<header>
							<h1>가족찾기</h1>
						
						</header>
						<a href="#main" class="more">Learn More</a>
					</div>
				</section>


			<% for(int i=0; i<list.size(); i++) {%>
                     <div class="box">																		
                        <a href="/dog/list?dogno=<%=list.get(i).getDogno()%>" class="image fit"><img src="//<%=list.get(i).getDog_org_file_name() %>" alt="" /></a>
                        <div class="inner">
                           <span>이름 <%=list.get(i).getDogname()%></span><br>
                           <span>성별<%=list.get(i).getDoggender()%></span><br>
                           <span>중성화여부<%=list.get(i).getDogneu()%></span><br>
                           <span>공고일<%=list.get(i).getDogdate()%></span>
                        </div>
                     </div>
                     <%} %>


			

			<!-- Footer -->
				<footer id="footer">
					<div class="inner">
						<h2>Etiam veroeros lorem</h2>
						<p>Pellentesque eleifend malesuada efficitur. Curabitur volutpat dui mi, ac imperdiet dolor tincidunt nec. Ut erat lectus, dictum sit amet lectus a, aliquet rutrum mauris. Etiam nec lectus hendrerit, consectetur risus viverra, iaculis orci. Phasellus eu nibh ut mi luctus auctor. Donec sit amet dolor in diam feugiat venenatis. </p>

						<ul class="icons">
							<li><a href="#" class="icon fa-twitter"><span class="label">Twitter</span></a></li>
							<li><a href="#" class="icon fa-facebook"><span class="label">Facebook</span></a></li>
							<li><a href="#" class="icon fa-instagram"><span class="label">Instagram</span></a></li>
							<li><a href="#" class="icon fa-envelope"><span class="label">Email</span></a></li>
						</ul>
						<p class="copyright">&copy; Untitled. Design: <a href="https://templated.co">TEMPLATED</a>. Images: <a href="https://unsplash.com/">Unsplash</a>. Videos: <a href="http://coverr.co/">Coverr</a>.</p>
					</div>
				</footer>

		<!-- Scripts -->
			<script src="/resources/UserBoardTemplate/assets/js/jquery.min.js"></script>
			<script src="/resources/UserBoardTemplate/assets/js/jquery.scrolly.min.js"></script>
			<script src="/resources/UserBoardTemplate/assets/js/jquery.poptrox.min.js"></script>
			<script src="/resources/UserBoardTemplate/assets/js/skel.min.js"></script>
			<script src="/resources/UserBoardTemplate/assets/js/util.js"></script>
			<script src="/resources/UserBoardTemplate/assets/js/main.js"></script>

	</body>
</html>