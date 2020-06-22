<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>비밀번호 찾기</title>
<!-- 자바스크립트 -->
<script type="text/javascript" src="https://code.jquery.com/jquery-2.2.4.min.js"></script>

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
	
	$.ajax({
		type:'POST',
		url:'/change/pw',
		data : {
			"userid":userid
			, "userpw":userpw
		},
		success:function(res){
			alert("비밀번호 변경이 완료되었습니다!")
			location.href="/login/login";
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
#pwChange{

   background-color: rgb(255,80,90);
   color:white;
   border-radius: 5px;
   border: 0;
   padding: 10px 200px;

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

   <h5><span>비밀번호 </span>재설정</h5>
   <hr>
   
<!--    비밀번호 확인 해주기  -->
<!--    메인화면 으로 가야하지 않나..?-->
   <form action="/change/pw" method="post" id="myForm">

   <h6><label>비밀번호<span id="red">(필수)</span>
      <input type="password" placeholder="비밀번호" name="userpw" id="userpw" class="pw" required style="height:30px; width: 495px"/></label>
  	<div id="pw_check"></div></h6>
  
   <h6><label>비밀번호확인<span id="red">(필수)</span>
      <input type="password" placeholder="비밀번호확인" name="userpw_ck" id="userpw_ck" class="pw" required style="height:30px; width: 495px"/></label>
   	<div id="pw_check2"></div></h6>
	  
	<hr>
	<input type="button" value="비밀번호재설정" id="pwChange" onclick="pwChangeFunc()">
	<hr>

  	<br><br>
   </form>
</div>
</body>
</html>
