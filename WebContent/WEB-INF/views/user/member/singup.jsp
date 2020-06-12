<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>회원가입</title>
<script type="text/javascript" src="https://code.jquery.com/jquery-2.2.4.min.js"></script>

<!-- 비밀번호 확인 자바스크립트 -->
<script type="text/javascript">
$(document).ready(function(){
   

$("#myForm").submit(function(){
   
   //#userid검증
   var uidReg = /^[A-Za-z0-9]{5,}$/;
   
   if(!uidReg.test($("#userid").val())){
      alert("아이디를 체크하세요");
      ${"#userid"}.val("");
      return false;
   }
   
   //#userpw 검증
   
   var upwReg = /^[A-Za-z0-9]{6,18}$/;
   if(!upwReg.test($("#userpw").val())){
      alert("비밀번호는 6에서 18자리 대소문자숫자를 ~");
      ${"#userpw"}.val("");
      return false;
   }
   
   //#username 검증
   var unameReg = /^[가-힣]{2,4}$/;
   if(!unameReg.test($("#username").val())) {
      ${"#username"}.val("");
      alert("이름한글로 2-4자");     
      return false;
   }
   
   
   //#userpw_ck
   if( $("#userpw").val() != $("#userpw_ck").val() ){
      
      alert("비밀번호가 달라요!")
      //다지우기
      $("#userpw_ck").val("");
      $("#userpw").focus();
      
      //select 이벤트발생
      $("#userpw_ck").select();
      return false;
   
   }
   return true;

   
});

})


</script>

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

select{
   height:35px; 
   width: 100px;
}
</style>
</head>
<body>


<div class="container">

   <h5><span>회원가입 </span>페이지</h5>
   <hr>
   
<!--    비밀번호 확인 해주기  -->
<!--    메인화면 으로 가야하지 않나..?-->
   <form action="/singup/singup" method="post" id="myForm">
   
   <h6><label>아이디<span id="red">(필수)</span>
      <input type="text" placeholder="아이디" name="userid" id="userid" required style="height:30px; width: 495px" /></label></h6>
   <h6><label>비밀번호<span id="red">(필수)</span>
      <input type="password" placeholder="비밀번호" name="userpw" id="userpw" class="pw" required style="height:30px; width: 495px"/></label></h6>
   <h6><label>비밀번호확인<span id="red">(필수)</span>
      <input type="password" placeholder="비밀번호확인" name="userpw_ck" id="userpw_ck" class="pw" required style="height:30px; width: 495px"/></label></h6>
   <span id="alert-success" style="display: none;">비밀번호가 일치합니다.</span>
   <span id="alert-danger" style="display: none; color: #d92742; font-weight: bold; ">비밀번호가 일치하지 않습니다.</span>
   <h6><label>이름<span id="red">(필수)</span>
      <input type="text" placeholder="이름" name="username" id="username" required style="height:30px; width: 495px"/></label></h6>
  <h6><label>핸드폰<span id="red">(필수)</span>
      <input type="tel" placeholder="핸드폰번호입력" name="usertel" id="usertel" required style="height:30px; width: 495px"/></label></h6>
  
  
  <h6><label>생년월일<span id="red">(필수)</span><br>
      <input type="text" name="userbirth_yy" id="userbirth_yy" maxlength="4" placeholder="년(4자)" size="10" required style="height:30px">
      <select name="userbirth_mm" >
         <option value="">월</option>
         <option value="01">1</option>
         <option value="02">2</option>
         <option value="03">3</option>
         <option value="04">4</option>
         <option value="05">5</option>
         <option value="06">6</option>
         <option value="07">7</option>
         <option value="08">8</option>
         <option value="09">9</option>
         <option value="10">10</option>
         <option value="11">11</option>
         <option value="12">12</option>   
      </select>
     <input type="text" name="userbirth_dd" id="userbirth_dd" maxlength="2" placeholder="일" size="10" required style="height:30px">
     </label></h6>
     
        
  
   <h6><label >이메일<span id="red">(필수)</span>
      <input type="email" placeholder="이메일" name="useremail" id="useremail" required style="height:30px; width: 495px"/></label></h6>
   <h6><label>주소<span id="red">(필수)</span>
      <input type="text" placeholder="주소를입력하세요" name="useraddress" id="useraddress" required style="height:30px; width: 495px"/></label></h6>

   <hr>
      <input type="submit" value="가입하기" class="singup"/><br>
      
   </form>
   
</div>



</body>
</html>
