<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>  

<c:import url="/main/header"></c:import>

<!--Alert 디자인 라이브러리 -->
<script src="https://unpkg.com/sweetalert/dist/sweetalert.min.js"></script>

<!-- 비밀번호 유효성 검사 -->
<script type="text/javascript">
$(document).ready(function(){
   
   //#userpassword 검증
   var upwReg = /^[A-Za-z0-9]{6,18}$/;
   //비밀번호 blur
   $('#userpw').blur(function(){
      if(upwReg.test($('#userpw').val())){
         $('#pw_check').text('');
         
      } else{
         
         $("#pw_check").text('6자-12자 소문자, 숫자를 섞어서 입력하시오');
         $("#pw_check").css('color','red');
      }
   });
   //#userpw  #userpw_ck 일치 확인
   $('#userpw_ck').blur(function(){
      if($("#userpw").val() == '') {
         $('#pw_check2').text('비밀번호를 입력하세요');
         $('#pw_check2').css('color','green');
         
      } else if($('#userpw').val() != $(this).val()){      
         $('#pw_check2').text('비밀번호가 일치하지 않습니다');
         $('#pw_check2').css('color','red');
      } else {
      
         $('#pw_check2').text('비밀번호가 일치합니다');
         $('#pw_check2').css('color','blue');
      } 
   })
   
   
})
</script>

<!-- 만약 재설정 버튼 누르면 alert뜨면서 비밀번호가 재설정 되었습니다 -->
<!-- 로그인 홈페이지로 이동 -->
<script type="text/javascript">

function pwChangeFunc(){
   
   var userid="${param.userid}";
   var userpw=$("#userpw").val();
   var userpw_ck=$("#userpw_ck").val();
   //#userpassword 검증
   var upwReg = /^[A-Za-z0-9]{6,18}$/;
   
   
   if($("#userpw").val() != $("#userpw_ck").val()){
      swal({
         title: "비밀번호를 확인해주세요!!",
         icon:"error"
      });
      
      return false;
   } 
   else if($("#userpw").val() == ""){
      swal({
         title: "비밀번호를 확인해주세요!!",
         icon:"error"
      });
      return false;
   }
   
//    비밀번호 정규
   if(!upwReg.test($("#userpw").val())){
      swal({
         title: "비밀번호는 6에서 18자리 소문자, 숫자!",
         icon:"error"
      });

       return false;
   }
   
   
   $.ajax({
      type:'POST',
      url:'/change/pw',
      data : {
         "userid":userid
         , "userpw":userpw
      },
      success:function(res){         
//    if문
         alert("비밀번호 변경이 완료되었습니다!");
         

         location.href="/main";
         
      }
      
   })
}

</script>
<!-- css -->
<style type="text/css">

/* 전체틀 */
.container{
   width:500px;
   margin :40px auto;
   line-height: 16px;
}

/* 메인 이름 */
h5{
   text-align: center;
}

h5 span{
   color:blue;
   
}

input {
    border: 1px solid lightgray;
/*     border-radius: 3px; */
}

#red{
   color:red;
}




</style>

</head>
<body>
<!-- 입력  -->
<div class="container">

   <h5><span>비밀번호 </span>재설정</h5>
   <hr>
   
<!--    비밀번호 확인 해주기  -->
<!--    메인화면 으로 가야하지 않나..?-->
   <form action="/change/pw" method="post" id="myForm">

   <h6><label>비밀번호<span id="red">(필수)</span>
      <input type="password" placeholder="비밀번호" name="userpw" id="userpw" class="pw" required style="width: 495px"/></label>
     <div id="pw_check"></div></h6>
  
   <h6><label>비밀번호확인<span id="red">(필수)</span>
      <input type="password" placeholder="비밀번호확인" name="userpw_ck" id="userpw_ck" class="pw" required style="width: 495px"/></label>
      <div id="pw_check2"></div></h6>
     
   <hr>
   <div style="margin:0 auto;text-align:center;">
   <input type="button" value="비밀번호재설정" id="pwChange" onclick="pwChangeFunc()" >
   </div>
   <hr>

     <br><br>
   </form>
</div>
</body>
<c:import url="/WEB-INF/views/user/util/footer.jsp"></c:import>