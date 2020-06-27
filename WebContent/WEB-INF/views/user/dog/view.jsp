
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%--한글 인코딩 --%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<%@page import="user.dog.dto.Dog_Data"%>
<%@page import="java.util.List"%>

<%List<Dog_Data> list = (List)request.getAttribute("dogList");  %>


<!DOCTYPE HTML>

<html>
	<head>
		<title>가족 찾기</title>
		<meta charset="utf-8" />
		<meta name="viewport" content="width=device-width, initial-scale=1" />
<!-- 		부트스트랩 -->
		<link rel="stylesheet" href="/resources/UserBoardTemplate/assets/css/main.css" /><!--  -->
		<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/font-awesome/4.5.0/css/font-awesome.min.css">
		


<!-- 스타일 css -->
<style type="text/css">
#doglist {
	display: grid;

	grid-template-columns: 1fr 1fr 1fr;
    row-gap: 10px;
    column-gap: 100px;


    width: 1000px;
    margin: 0 auto;
    margin-top : 20px;
<<<<<<< HEAD
=======
    
>>>>>>> branch 'master' of https://github.com/choipureum/Abandoned_Dogs_Save_Project.git
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

<!-- 담아두기css -->
<style type="text/css">
.fa-heart-o {
  color: red;
  cursor: pointer;
}

.fa-heart {
  color: red;
  cursor: pointer;
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
<<<<<<< HEAD
=======



<!-- 자바스크립트 -->
<script type="text/javascript" src="https://code.jquery.com/jquery-2.2.4.min.js"></script>

<!-- 하트버튼 자바스크립트 -->
<script type="text/javascript">

$(document).ready(function(){
	
   $(".heartDog > .fa").click(function(){
	   var dogno=$("i[class=fa]").attr("data-dogno");
	   var userid="";
	   
	   if($("i[class=fa-heart-o]")){
		   //이미 색칠 되어있는 하트
		   //	아작스 처리 -> 색칠빼고 아작스 담아두기 delete 기능수행
	   }
	   else{
		   //색칠 안되어있는 하트
		   //	 아작스처리 -> 색칠빼고 아작스 가서 담아주기(insert)기능 수행
	   }
	   
	   
	   
	   
	   
      if($("#'${dog.dogno }'").hasClass("liked")){
         $("#'${dog.dogno }'").html('<i class="fa fa-heart-o" aria-hidden="true"></i>');
         $("#'${dog.dogno }'").removeClass("liked");
      }else{
         $("#'${dog.dogno }'").html('<i class="fa fa-heart" aria-hidden="true"></i>');
         $("#'${dog.dogno }'").addClass("liked");
      }
   });
});
</script>



>>>>>>> branch 'master' of https://github.com/choipureum/Abandoned_Dogs_Save_Project.git
<div id="doglist"></div>
<<<<<<< HEAD
<div id="showplus"></div>

=======
<div id="showplus"><!-- <button id="btnUserLike">더보기</button> --></div>

<!-- board template -->
>>>>>>> branch 'master' of https://github.com/choipureum/Abandoned_Dogs_Save_Project.git
<!-- Scripts -->
<script type="text/javascript" src="https://code.jquery.com/jquery-2.2.4.min.js"></script>
<script src="/resources/UserBoardTemplate/assets/js/jquery.min.js"></script>
<script src="/resources/UserBoardTemplate/assets/js/jquery.scrolly.min.js"></script>
<script src="/resources/UserBoardTemplate/assets/js/jquery.poptrox.min.js"></script>
<script src="/resources/UserBoardTemplate/assets/js/skel.min.js"></script>
<script src="/resources/UserBoardTemplate/assets/js/util.js"></script>
<script src="/resources/UserBoardTemplate/assets/js/main.js"></script>




<!-- 무한스크롤 -->
<script type="text/javascript">

var page = 1;

$(window).scroll(function(){
	
	if($(window).scrollTop() == $(document).height() - $(window).height()){
		if('${paging.totalPage }' >= page  ) {
// 		console.log(page);
			$("body").append(loadlist())
		}		
// 		loadlist();
	}
})

function loadlist() {
	$.ajax({
		type:"post"
		, url: "/dog/list"
		, data: {
			curPage: page++
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



