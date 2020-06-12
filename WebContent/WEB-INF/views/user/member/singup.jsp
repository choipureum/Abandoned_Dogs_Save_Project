<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>회원가입</title>


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

.singup {
   background-color: rgb(255,80,90);
   color:white;
   border-radius: 5px;
   border: 0;
   padding: 10px 224px;
   
}

input {
    border: 1px solid lightgray;
    border-radius: 3px;
}

#red{
   color:red;
}

</style>
</head>
<body>


<div class="container">

   <h5><span>회원가입 </span>페이지</h5>
   <hr>
   
<!--    비밀번호 확인 해주기  -->
<!--    메인화면 으로 가야하지 않나..?-->
   <form action="/singup/singup" method="post">
   <h6><label id="userid">아이디<span id="red">(필수)</span>
      <input type="text" placeholder="아이디" name="userid" id="userid" required style="height:30px; width: 495px" /></label></h6>
   <h6><label id="userpw">비밀번호<span id="red">(필수)</span>
      <input type="password" placeholder="비밀번호" name="userpw" id="userpw" required style="height:30px; width: 495px"/></label></h6>
   <h6><label id="userpw_ck">비밀번호확인<span id="red">(필수)</span>
      <input type="password" placeholder="비밀번호확인" name="userpw_ck" id="userpw_ck" required style="height:30px; width: 495px"/></label></h6>
   <h6><label id="username">이름<span id="red">(필수)</span>
      <input type="text" placeholder="이름" name="username" id="username" required style="height:30px; width: 495px"/></label></h6>
   <h6><label id="useremail">이메일<span id="red">(필수)</span>
      <input type="email" placeholder="이메일" name="useremail" id="useremail" required style="height:30px; width: 495px"/></label></h6>
   <h6><label id="useraddress">주소<span id="red">(필수)</span>
      <input type="text" placeholder="주소를입력하세요" name="useraddress" id="useraddress" required style="height:30px; width: 495px"/></label></h6>

<hr>
      <input type="submit" value="가입하기" class="singup"/><br>
      
   </form>
</div>



</body>
</html>