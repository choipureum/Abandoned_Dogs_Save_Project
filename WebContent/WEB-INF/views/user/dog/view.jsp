<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<%@page import="user.dog.dto.Dog_Data"%>
<%@page import="java.util.List"%>
<%List<Dog_Data> list = (List)request.getAttribute("dogList");  %>
<!DOCTYPE HTML>

<html>
	<head>
		<title>Full Motion</title>
		<meta charset="utf-8" />
		<meta name="viewport" content="width=device-width, initial-scale=1" />
		<link rel="stylesheet" href="/resources/UserBoardTemplate/assets/css/main.css" /><!--  -->
		
<style type="text/css">
#doglist {
	display: grid;

	grid-template-columns: 1fr 1fr 1fr;
    row-gap: 10px;
    column-gap: 100px;


    width: 1000px;
    margin: 0 auto;
    margin-top : 20px;
    
    
}

body{
background: white;
}


.box {
background: skyblue;
}
.box a img {
	width: 200px;
	height: 200px;
}
.box a img:hover{
transform:scale(1.04);
}

.box a{
border-bottom: none;
}

</style>		
</head>
<body id="top">
<section id="banner" data-video="images/banner">
	<div class="inner">
		<header>
			<h1>가족찾기</h1>
		
		</header>
		<a href="#main" class="more">Learn More</a>
	</div>
</section>
<div id="doglist"></div>
<div id="showplus"><button>더보기</button></div>
<!-- Scripts -->
			<script src="/resources/UserBoardTemplate/assets/js/jquery.min.js"></script>
			<script src="/resources/UserBoardTemplate/assets/js/jquery.scrolly.min.js"></script>
			<script src="/resources/UserBoardTemplate/assets/js/jquery.poptrox.min.js"></script>
			<script src="/resources/UserBoardTemplate/assets/js/skel.min.js"></script>
			<script src="/resources/UserBoardTemplate/assets/js/util.js"></script>
			<script src="/resources/UserBoardTemplate/assets/js/main.js"></script>


<script type="text/javascript">
var curPage = 1;
$(document).ready(function() {
	
	loadlist();
	
	$("#showplus").click(function() {
		
		if( curPage > '${paging.totalPage }' ) {
			return false;
		}
		
		loadlist();
	})
	
})

function loadlist() {
	$.ajax({
		type:"post"
		, url: "/dog/list"
		, data: {
			curPage: curPage++
		}
		, dataType: "html"
		, success: function(h) {
			console.log("AJAX success")
			$("#doglist").html( $("#doglist").html() + h )
		}
		, error: function() {
			console.log("AJAX error")
		}
	})
}
</script>

	</body>
</html>