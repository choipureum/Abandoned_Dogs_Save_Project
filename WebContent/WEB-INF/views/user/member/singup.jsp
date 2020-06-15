<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>회원가입</title>
<!-- 다음 주소 api -->

<script src="https://t1.daumcdn.net/mapjsapi/bundle/postcode/prod/postcode.v2.js"></script>
<script>

function execPostCode() {
    new daum.Postcode({
        oncomplete: function(data) {
           // 팝업에서 검색결과 항목을 클릭했을때 실행할 코드를 작성하는 부분.

           // 도로명 주소의 노출 규칙에 따라 주소를 조합한다.
           // 내려오는 변수가 값이 없는 경우엔 공백('')값을 가지므로, 이를 참고하여 분기 한다.
           var fullRoadAddr = data.roadAddress; // 도로명 주소 변수
           var extraRoadAddr = ''; // 도로명 조합형 주소 변수

           // 법정동명이 있을 경우 추가한다. (법정리는 제외)
           // 법정동의 경우 마지막 문자가 "동/로/가"로 끝난다.
           if(data.bname !== '' && /[동|로|가]$/g.test(data.bname)){
               extraRoadAddr += data.bname;
           }
           // 건물명이 있고, 공동주택일 경우 추가한다.
           if(data.buildingName !== '' && data.apartment === 'Y'){
              extraRoadAddr += (extraRoadAddr !== '' ? ', ' + data.buildingName : data.buildingName);
           }
           // 도로명, 지번 조합형 주소가 있을 경우, 괄호까지 추가한 최종 문자열을 만든다.
           if(extraRoadAddr !== ''){
               extraRoadAddr = ' (' + extraRoadAddr + ')';
           }
           // 도로명, 지번 주소의 유무에 따라 해당 조합형 주소를 추가한다.
           if(fullRoadAddr !== ''){
               fullRoadAddr += extraRoadAddr;
           }

           // 우편번호와 주소 정보를 해당 필드에 넣는다.
           console.log(data.zonecode);
           console.log(fullRoadAddr);
           
           
           $("[name=mem_oaddress]").val(data.zonecode);
           $("[name=mem_address]").val(fullRoadAddr);
           
           document.getElementById('mem_oaddress').value = data.zonecode; //5자리 새우편번호 사용
           document.getElementById('mem_address').value = fullRoadAddr;
//            document.getElementById('mem_detailaddress').value = data.jibunAddress;
       }
    }).open();
}






//     function execDaumPostcode() {
//         new daum.Postcode({
//             oncomplete: function(data) {
//                 // 팝업에서 검색결과 항목을 클릭했을때 실행할 코드를 작성하는 부분.

//                 // 각 주소의 노출 규칙에 따라 주소를 조합한다.
//                 // 내려오는 변수가 값이 없는 경우엔 공백('')값을 가지므로, 이를 참고하여 분기 한다.
//                 var addr = ''; // 주소 변수
//                 var extraAddr = ''; // 참고항목 변수

//                 //사용자가 선택한 주소 타입에 따라 해당 주소 값을 가져온다.
//                 if (data.userSelectedType === 'R') { // 사용자가 도로명 주소를 선택했을 경우
//                     addr = data.roadAddress;
//                 } else { // 사용자가 지번 주소를 선택했을 경우(J)
//                     addr = data.jibunAddress;
//                 }

//                 // 사용자가 선택한 주소가 도로명 타입일때 참고항목을 조합한다.
//                 if(data.userSelectedType === 'R'){
//                     // 법정동명이 있을 경우 추가한다. (법정리는 제외)
//                     // 법정동의 경우 마지막 문자가 "동/로/가"로 끝난다.
//                     if(data.bname !== '' && /[동|로|가]$/g.test(data.bname)){
//                         extraAddr += data.bname;
//                     }
//                     // 건물명이 있고, 공동주택일 경우 추가한다.
//                     if(data.buildingName !== '' && data.apartment === 'Y'){
//                         extraAddr += (extraAddr !== '' ? ', ' + data.buildingName : data.buildingName);
//                     }
//                     // 표시할 참고항목이 있을 경우, 괄호까지 추가한 최종 문자열을 만든다.
//                     if(extraAddr !== ''){
//                         extraAddr = ' (' + extraAddr + ')';
//                     }

                
//                 } else {
                  
//                 }

//                 // 우편번호와 주소 정보를 해당 필드에 넣는다.
//                 document.getElementById('mem_oaddress').value = data.zonecode;
//                 document.getElementById("mem_address").value = addr;
//                 // 커서를 상세주소 필드로 이동한다.
//                 document.getElementById("mem_detailaddress").focus();
//             }
//         }).open();
//     }
</script>

<script type="text/javascript" src="https://code.jquery.com/jquery-2.2.4.min.js"></script>

<!-- 비밀번호 확인 자바스크립트 -->
<script type="text/javascript">
$(document).ready(function(){
   

$("#myForm").submit(function(){
   
   //#userid검증
   var uidReg = /^[A-Za-z0-9]{5,}$/;
   
   if(!uidReg.test($("#userid").val())){
      alert("아이디를 체크하세요");
//       ${"#userid"}.val("");
      return false;
   }
   
   //#userpw 검증
   
   var upwReg = /^[A-Za-z0-9]{6,18}$/;
   if(!upwReg.test($("#userpw").val())){
      alert("비밀번호는 6에서 18자리 대소문자숫자를 ~");
//       ${"#userpw"}.val("");
      return false;
   }
   
   //#username 검증
   var unameReg = /^[가-힣]{2,4}$/;
   if(!unameReg.test($("#username").val())) {
//       ${"#username"}.val("");
      alert("이름한글로 2-4자");     
      return false;
   }
   
   
   //#userpw_ck
   if( $("#userpw").val() != $("#userpw_ck").val() ){
      
      alert("비밀번호가 달라요!")
      //다지우기
//       $("#userpw_ck").val("");
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
  


<!-- 주소 api -->
<h6>주소<span id="red">(필수)</span>
<div class="form-group">                   
<input class="form-control" style="width: 40%; display: inline;" placeholder="우편번호" name="mem_oaddress" id="mem_oaddress" type="text" readonly="readonly" >
    <button type="button" class="btn btn-default" onclick="execPostCode();"><i class="fa fa-search"></i> 우편번호 찾기</button>                               
</div>

<div class="form-group">
    <input class="form-control" style="top: 5px;" placeholder="도로명 주소" name="mem_address" id="mem_address" type="text" readonly="readonly" />
</div>

<div class="form-group">
    <input class="form-control" placeholder="상세주소" name="mem_detailaddress" id="mem_detailaddress" type="text"  />
</div>
</h6>





<!-- <div class="form-group">                    -->
<!-- <input type="text" id="mem_oaddress" name = "mem_oaddress" placeholder="우편번호"> -->
<!-- <input type="button" onclick="execDaumPostcode()" value="우편번호 찾기"><br> -->
<!-- <input type="text" id="mem_address" name="mem_address" placeholder="주소"><br> -->
<!-- <input type="text" id="mem_detailaddress" name="mem_detailaddress" placeholder="상세주소"> -->

<!-- </div> -->

<!-- <div id="layer" style="display:none;position:fixed;overflow:hidden;z-index:1;-webkit-overflow-scrolling:touch;"> -->
<!-- <img src="//t1.daumcdn.net/postcode/resource/images/close.png" id="btnCloseLayer" style="cursor:pointer;position:absolute;right:-3px;top:-3px;z-index:1" onclick="closeDaumPostcode()" alt="닫기 버튼"> -->
<!-- </div> -->

  
  
  
   <hr>
      <input type="submit" value="가입하기" class="singup"/><br>
      
   </form>
   
</div>



</body>
</html>
