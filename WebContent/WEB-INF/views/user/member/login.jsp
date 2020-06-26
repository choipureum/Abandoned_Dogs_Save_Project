<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>login jsp</title>

<!-- Custom fonts for this template-->
  <link href="/resources/AdminTemplate/vendor/fontawesome-free/css/all.min.css" rel="stylesheet" type="text/css">
 <link href="https://fonts.googleapis.com/icon?family=Material+Icons" rel="stylesheet">
<!-- 자바스크립트 -->
<script type="text/javascript" src="https://code.jquery.com/jquery-2.2.4.min.js"></script>

<script type="text/javascript">
$(document).ready(function(){
	$(".open").on('click',function(){
		$(".popup").show();
		$(".dim").show();
	});
	$(".popup .close").on('click',function(){
		$(this).parent().hide();
		$(".dim").hide();
	});
})


</script>
<style type="text/css">

.container {
   width:385px;
   line-height:50px;
   margin: 40px auto;

}
/* 로그인입니다 css */
h3 {
   text-align: center;
}

h3 span{
   color:#ff9364;
}
/* 로그인버튼 */
.login {
   background-color: #6E6E6E;
   color:white;
   border-radius: 5px;
   border: 0;
   padding: 10px 172px;
   
}
/* 회원가입버튼 */
.singup {

   background-color:#6E6E6E;
   color:white;
   border-radius: 5px;
   border: 0;
   padding: 10px 165px;
   
}

/* 아이디 비밀번호 찾기 */
a {
	position :relative;
	left:25px;
	
	margin: 0px 3px; 
	text-decoration: none;
	font-family: "돋움", dotum, "굴림", gulim, arial, helvetica, sans-serif;
	font-size: 13px;
}
a:hover{
	text-decoration: underline;
	
}

#icons {
   position: absolute;
   top : 180px;
   margin: 0 355px;
   
}

/* 비밀번호 아이콘 */
#lock {
   position: absolute;
   top: 230px;
   margin: 0 355px;

}

#lockfind {
   position: absolute;
   top: 55px;
   margin: 320px 0px;

}
</style>

<style type="text/css">
/* 팝업처리 */
.popup { 
	display: none; 
	position: fixed; 
 	left: 50%;  
 	top: 50%;  
 	z-index: 100;  

	padding:50px 50px 50px;
	width: 550px; height: 530px; 
	transform: translate(-50%, -50%); 
	box-sizing: border-box; 
	background: #fff;
}
.popup h2 { 
	padding: 0 0 42px; 
	border-bottom: 3px solid #444; 
	font-weight: normal;
	font-size:36px; 
	color:#222; 
	text-align: center; 
	line-height: 100%;
}
.popup .close { 
	position: absolute; 
	right:40px; top: 40px; width: 41px; height: 41px; 
	background: url(/resources/mypageTemplate/img/btn-close.png) no-repeat; 
	color:transparent;
}
.popup .con { 
	padding: 20px 48px; 
	border-bottom:1px solid #e8e8e8;
}

.dim { 
	display: none;
	position: fixed; 
	left: 0; top: 0; 
	z-index: 99; 
	width: 100%; height: 100%; 
	background:rgba(0,0,0,0.5);
}


</style>

</head>
<body>

<!-- 비로그인상태 -->
<c:if test="${empty login }">

</c:if>


<a href = "#a" class="open">로그인</a>

<div class="popup">

<div class="container">
<!--    아이디 아이콘 -->
   <div id="icons">
      <i class="material-icons">person_outline</i>   
   </div>
<!--    비밀번호ㅗ 아이콘 -->
   <div id="lock">
      <i class="material-icons">lock_outline</i>
   </div>
      <h3><span>로그인 </span></h3>
   <hr>
   <form action="/login/login" method="post">
   
      <!-- 로그인 틀ㅇ -->
      <label for="userid"></label>
      <input type="text" id="userid" name="userid" placeholder="아이디" required style="height:30px; width: 380px" /><br>

      <label for="userpw"></label>
      <input type="password" id="userpw" name="userpw"  placeholder="비밀번호" required style="height:30px; width: 380px" /><br>
      <!-- <button>로그인</button> -->
      <input type="submit" value="로그인" class="login"/>
   </form>
   
   <input type="button" class="singup" value="회원가입" onclick="location.href='/resources/js/singupinfo.jsp'" />
	
<!-- 	아이디 비밀번호 찾기 -->
   <div id="lockfind">
      <i class="material-icons">lock_outline</i>
   </div>

<!-- 	아이디비밀번호 찾기 -->
	<a href="/id/find">아이디</a>
	<a href="/pw/find">비밀번호찾기</a>

</div>
<a href="#a" class="close">닫기</a>
</div>

<div class="dim"></div>

<!-- 로그인 되어있는 상태 -->
<%-- <c:if test="${not empty login }"> --%>
<!-- <input type ="button" value="로그아웃" onclick="location.href='/logout/logout'" /> -->

<%-- </c:if> --%>
</body>
</html>