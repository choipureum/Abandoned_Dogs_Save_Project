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

</script>
<!-- 다음 주소 api끝 -->

<!-- 자바스크립트 -->
<script type="text/javascript" src="https://code.jquery.com/jquery-2.2.4.min.js"></script>

<script type="text/javascript">

</script>
<!-- 유효성검사 코드 -->
<script type="text/javascript">
$(document).ready(function(){

	//#userid검증
	var uidReg = /^[A-Za-z0-9]{5,18}$/;
	
	//#userpassword 검증
	var upwReg = /^[A-Za-z0-9]{6,18}$/;
	
	//#username 검증
  	var unameReg = /^[가-힣]{2,5}$/;
  	
  	//출생년도 정규식 ( 생년월일 )
  	var yearReg = /^(19|20)[0-9]{2}$/;
  	var sw =true;

  	//아이디 blur
	$("#userid").blur(function(){
		if(uidReg.test($('#userid').val())){
			$("#id_check").text('');
		} else{
			$("#id_check").text('5자이상 18자이하 영문자, 숫자를 섞어서 입력하시오');
			$("#id_check").css('color','red');
		}
	})

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
	//이름 blur
	$('#username').blur(function(){
		if(unameReg.test($('#username').val())){
			$('#pw_check').text('');
		
		} else{
			$("#name_check").text('2글자 이상  5글자 이하 한글로 작성하세요');
			$("#name_check").css('color','red');
		}
	})
	
	// 	userbirth_yy 출생년도
	$('#userbirth_yy').blur(function(){
		if(yearReg.test($('#userbirth_yy').val())){
			$('#year_check').text('');
		
		} else{
			$("#year_check").text('19__ - 20__ 형식에 맞게 입력하세요');
			$("#year_check").css('color','red');
		}
	}) //blur
	
	$("#myForm").submit(function(){
						   
		   if(!uidReg.test($("#userid").val())){
		      alert("아이디를 체크하세요");

		      return false;
		   }
		   
		   if(!($("#hiddenIdCheck").val()=="ok")){
			   alert("아이디 중복확인 바랍니다");
			   return false;
		   }

		   if(!upwReg.test($("#userpw").val())){
		      alert("비밀번호는 6에서 18자리 소문자, 숫자를 ~");

		      return false;
		   }

		   if(!unameReg.test($("#username").val())) {

		      alert("이름한글로 2-5자");     
		      return false;
		   }
		   if(!($("#hiddenEmailCheck").val()=="ok")){
			   alert("이메일 인증확인을 해주세요");
			   return false;
		   }
		   
		   //#userpw_ck
		   if( $("#userpw").val() != $("#userpw_ck").val() ){
		      
		      alert("비밀번호가 달라요!")
		      $("#userpw").focus();      
		      //select 이벤트발생
		      $("#userpw_ck").select();
		      return false;		   
		   }

		   if(!uidReg.test($("#userid").val())){
			      alert("아이디를 체크하세요");

			      return false;
			   }
		   if(!yearReg.test($("#userbirth_yy").val())){
			   alert("년도를 확인하세요");
			   
			   return false;
		   }		   	  
		}) 		
		return true;
})
</script>

<!-- 변수 로 if문 -->
<!-- 아이디 중복체크  -->
<script type="text/javascript">

	function idCheck(){	
// 		ajax 활용
		var userid=$("#userid").val();
		$.ajax({
			type: 'POST',
			url: '/id/check',
// 			파라미터 변수 이름 값(사용자아이디값)
			data : {userid : userid},
			success : function(result){
				if(result==1){ // 아이다가 없규
					
					$("#id_check2").text('가입이 가능한 아이디입니다');
					$("#id_check2").css('color','blue');
					$("#hiddenIdCheck").attr("value","ok");
					
				} else if(result==0){
					$("#id_check2").text('아이디가 존재합니다');
					$("#id_check2").css('color','red');
					
				}else{
					$("#id_check2").text('아이디를 입력하세요 ');
					$("#id_check2").css('color','green');
				}
				
			}
		})
	}
	
</script>

<!-- 이메일 인증버튼 -->
<script type="text/javascript">
var ran=0;
function email(){

	if($("#useremail").val()==""){
		alert("이메일을 입력하세요");
		
		return false;
	}
	
	if($('#emailcheckbox').css("display") =="none") {
		$("#emailcheckbox").show();
	} 		
	//ajax 이용
	var useremail= $("#useremail").val();

	$.ajax({
		type: 'POST',
		url: '/email/check',
//			파라미터 변수 이름 값(사용자아이디값)
		data : {"useremail" : useremail},
		success : function(random){		
			//왜일까? ----------여기 짊ㄴ아ㅓ
			
			alert("이메일을 보냈습니다"+random);
			ran=random;			
		}
	});
};

// if (ran == 이메일인증.val()) emailCheck버튼
function emailCheckFunc(){
	
	if(ran == $("#useremailcheck").val()){
		$("#email_check").text('이메일이 인증되었습니다');
		$("#email_check").css('color','blue');	
		$("#hiddenEmailCheck").attr("value","ok");
	} else{
		$("#email_check").text('인증번호가 틀립니다  다시 확인해주세요!');
		$("#email_check").css('color','red');		
	}
}
</script>
<!-- css -->
<style type="text/css">

#emailcheckbox{
	display: none;
}
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
.btn-default{
   background-color: rgb(220,220,220);
   color:black;
   border-radius: 2px;
   border: 0;
   padding: 6px 20px;

}
.id_Button{
   background-color: rgb(220,220,220);
   color:black;
   border-radius: 2px;
   border: 0;
   padding: 6px 20px;

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

   <h5><span>회원가입 </span>페이지</h5>
   <hr>
   
<!--    비밀번호 확인 해주기  -->
<!--    메인화면 으로 가야하지 않나..?-->
   <form action="/singup/singup" method="post" id="myForm">
   <!-- 아이디 중복 값 체크용 히든 밸류 -->
   <input type="hidden" id="hiddenIdCheck"/>
   <h6><label>아이디<span id="red">(필수)</span><br>
      <input type="text" placeholder="아이디" name="userid" id="userid" class="username_input" required style="height:30px; width: 380px" />
      <button type ="button" value="ID중복확인" id="idCheckbutton" class="id_Button" onclick="idCheck()">ID중복확인</button>
      </label><div id="id_check"></div><div id="id_check2"></div>
      </h6>
 
 
   <h6><label>비밀번호<span id="red">(필수)</span>
      <input type="password" placeholder="비밀번호" name="userpw" id="userpw" class="pw" required style="height:30px; width: 495px"/></label>
  	<div id="pw_check"></div></h6>
  
   <h6><label>비밀번호확인<span id="red">(필수)</span>
      <input type="password" placeholder="비밀번호확인" name="userpw_ck" id="userpw_ck" class="pw" required style="height:30px; width: 495px"/></label>
   	<div id="pw_check2"></div></h6>
   
   <h6><label>이름<span id="red">(필수)</span>
      <input type="text" placeholder="이름" name="username" id="username" required style="height:30px; width: 495px"/></label>
      <div id="name_check"></div></h6>
      
  <h6><label>핸드폰<span id="red">(필수)</span>
      <input type="tel" placeholder="- 없이 숫자만 써주세요(숫자11자리)" name="usertel" maxlength="11" id="usertel" required style="height:30px; width: 495px"/></label></h6>
  
  
  <h6><label>생년월일<span id="red">(필수)</span><br>
      <input type="text" name="userbirth_yy" id="userbirth_yy" maxlength="4" placeholder="년(4자)" size="10" required style="height:30px">
<!--  	생년월일 월 -->
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
<!--   		생년월일 일 -->
      <select name="userbirth_dd" >
         <option value="">일</option>
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
         <option value="13">13</option>
         <option value="14">14</option>
         <option value="15">15</option>
         <option value="16">16</option>
         <option value="17">17</option>
         <option value="18">18</option>
         <option value="19">19</option>
         <option value="20">20</option>
         <option value="21">21</option>
         <option value="22">22</option>
         <option value="23">23</option>
         <option value="24">24</option>
         <option value="25">25</option>
         <option value="26">26</option>
         <option value="27">27</option>
         <option value="28">28</option>
         <option value="29">29</option>
         <option value="30">30</option>
         <option value="31">31</option>

      </select>
<!--      <input type="text" name="userbirth_dd" id="userbirth_dd" maxlength="2" placeholder="일" size="10" required style="height:30px"> -->
     <div id="year_check"></div></label></h6>

   <h6><label >이메일<span id="red">(필수)</span><br>
      <input type="email" placeholder="이메일" name="useremail" id="useremail" required style="height:30px; width: 380px"/>
      <button type ="button" value="이메일인증" class="id_Button" onclick="email()">이메일인증</button>
      
      </label></h6>
<!--     이메일인증 값 체크용 힐든 벨류  -->
	<input type="hidden" id="hiddenEmailCheck"/>
  	<div id="emailcheckbox">
	<h6>이메일인증
	<input type="text"  name="useremailcheck" id="useremailcheck" maxlength="4" style="height:30px; width: 200px" />
	<button type ="button" class="id_Button" id="emailCheck" onclick="emailCheckFunc()">인증 확인</button>
	<div id="email_check"></div>
<!-- 	//이메일 인증 컨트롤러 -->
<!-- 		//이메일 인증 하는 코드 -->
	
	</h6></div>

	<h6>주소<span id="red">(필수)</span>
		
	<div class="form-group">                   
		<input class="form-control"  placeholder="우편번호" name="mem_oaddress" id="mem_oaddress" type="text" readonly="readonly" required style=" height:28px; width: 100px">
    	<button type="button" class="btn-default" onclick="execPostCode();"><i class="fa fa-search"></i> 우편번호 찾기</button>                               
	</div>

	<div class="form-group">
    	<input type="text" class="form-control"  placeholder="도로명 주소" name="mem_address" id="mem_address" required style="height:30px; width: 254px" readonly="readonly" />
   	 	<input type="text" class="form-control" placeholder="상세주소" name="mem_detailaddress" id="mem_detailaddress" required style="height:30px; width: 230px"/>
	</div>
	</h6>
	
	<hr>
	<input type="submit" value="가입하기" class="singup" /><br>

  
   </form>
</div>
</body>
</html>
