<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>아이디찾기</title>

<!-- 다음 주소 api -->
<script src="https://t1.daumcdn.net/mapjsapi/bundle/postcode/prod/postcode.v2.js"></script>


<!-- 자바스크립트 -->
<script type="text/javascript" src="https://code.jquery.com/jquery-2.2.4.min.js"></script>


<!-- css -->
<style type="text/css">

.container{
   width:500px;
   margin :40px auto;
   line-height: 16px;
}

h5{
   text-align: center;
}

h5 span{
   color:blue;
   
}

.findid {
   background-color: rgb(255,80,90);
   color:white;
   border-radius: 5px;
   border: 0;
   padding: 10px 215px;
   
}


input {
    border: 1px solid lightgray;
    border-radius: 3px;
}

#red{
   color:red;
}

select{
   height:35px; 
   width: 100px;
}

</style>
</head>
<body>
<!-- 입력  -->
<div class="container">

   <h5><span>아이디 </span>찾기</h5>
   <hr>
   
<!--    비밀번호 확인 해주기  -->
<!--    메인화면 으로 가야하지 않나..?-->
   <form action="/singup/singup" method="post" id="myForm">

  
   <h6><label>이름<span id="red">(필수)</span>
      <input type="text" placeholder="이름" name="username" id="username" required style="height:30px; width: 495px"/></label>
      <div id="name_check"></div></h6>

   <h6><label >이메일<span id="red">(필수)</span>
      <input type="email" placeholder="이메일" name="useremail" id="useremail" required style="height:30px; width: 495px"/></label></h6>

	<hr>
	<button type="button" value="아이디 찾기" class="findid" onclick="idFind()">아이디찾기</button>
	
	<hr>
<!-- 	찾은아이디 반환넣어줄 -->
  	<div id="id_find"></div>
   </form>
</div>
</body>
</html>
