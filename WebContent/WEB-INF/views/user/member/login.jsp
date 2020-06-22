<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>login jsp</title>
 
   <link href="https://fonts.googleapis.com/icon?family=Material+Icons" rel="stylesheet">

<style type="text/css">

.container {
   width:385px;
   line-height:50px;
   margin: 40px auto;

}
/* 로그인입니다 css */
h5 {
   text-align: center;
}

h5 span{
   color:blue;
}
/* 로그인버튼 */
.login {
   background-color: rgb(255,80,90);
   color:white;
   border-radius: 5px;
   border: 0;
   padding: 10px 172px;
   
}
/* 회원가입버튼 */
.singup {

   background-color: rgb(255,80,90);
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
   top : 130px;
   margin: 0 355px;
   
}

/* 비밀번호 아이콘 */
#lock {
   position: absolute;
   top: 180px;
   margin: 0 355px;

}

#lockfind {
   position: absolute;
   top: 10px;
   margin: 320px 0px;

}
</style>
</head>
<body>

<!-- 비로그인상태 -->
<c:if test="${empty login }">

</c:if>

<div class="container">
<!--    아이디 아이콘 -->
   <div id="icons">
      <i class="material-icons">person_outline</i>   
   </div>
<!--    비밀번호ㅗ 아이콘 -->
   <div id="lock">
      <i class="material-icons">lock_outline</i>
   </div>
      <h5><span>로그인 </span> 페이지</h5>
   <hr>
   <form action="/login/login" method="post">
   
      <!-- 로그인 틀ㅇ -->
      <label for="userid"></label>
      <input type="text" id="userid" name="userid" placeholder="아이디" required style="height:30px; width: 380px" /><br>

      <label for="userpw"></label>
      <input type="text" id="userpw" name="userpw"  placeholder="비밀번호" required style="height:30px; width: 380px" /><br>
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

<!-- 로그인 되어있는 상태 -->
<%-- <c:if test="${not empty login }"> --%>
<!-- <input type ="button" value="로그아웃" onclick="location.href='/logout/logout'" /> -->

<%-- </c:if> --%>


</body>
</html>