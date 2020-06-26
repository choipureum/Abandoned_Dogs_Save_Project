<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>비밀번호 찾기</title>
<!--Alert 디자인 라이브러리 -->
<script src="https://unpkg.com/sweetalert/dist/sweetalert.min.js"></script>



<!-- 자바스크립트 -->
<script type="text/javascript" src="https://code.jquery.com/jquery-2.2.4.min.js"></script>

<script type="text/javascript">

function email(){
	
	if($('#emailcheckbox').css("display") =="none") {
		$("#emailcheckbox").show();
	} 
}


</script>
<!-- //아이디 찾기  -->
<script type="text/javascript">
$(window).load(function(){
	$("#pwFind").click(pwFind);
})
// 	username, useremail

// 	눌렀을때
function pwFind(event){
	
	var username=$("#username").val();
	var userid=$("#userid").val();
	var useremail=$("#useremail").val();
	
	
	if($("#username").val()==""){
// 		alert("이름을 입력하세요!");
		swal({
			title: "이름을 입력하세요!",
			icon:"error"
		});
		return false;
		
	}else if($("#userid").val()==""){
// 		alert("아이디를 입력하세요!")
		swal({
			title: "아이디를 입력하세요!",
			icon:"error"
		});
		return false;
	} else if($("#useremail").val()==""){
// 		alert("이메일을 입력하세요!");
		swal({
			title: "이메일을 입력하세요!",
			icon:"error"
		});
		return false;
	} else if(!($("#hiddenEmailCheck").val()=="ok")){
		swal({
			title: "이메일 인증을 해주세요!",
			icon:"error"
		});
		return false;
	}
	
	//배열에 유저정보 삽입
	var userinfo=new Array;
	userinfo.push(username);
	userinfo.push(useremail);
	userinfo.push(userid);

	$.ajax({
		type : 'POST',
		url : '/pw/find',
// 		data : {"userinfo" : userinfo},
		data : {
			"username" : username
			, "useremail" : useremail
			, "userid" : userid
		},
		
		dataType: "json",
		success : function(res){
			console.log(res);
// 			return 값으로 넘겨주기
			if(res.data == 1){ //있으니깐 - 비밀번호 재설정 홈페이지로 이동
				location.href="/change/pw?userid="+userid;				
			}
			else{
				swal({
					title: "회원의 정보가 존재하지 않습니다!",
					icon:"error"
				});
			}

		}
		, error: function() {
			console.log("ajax 실패")
		}
		
	});
}
</script>

<!-- 비밀번호 확인 이메일 체크 -->
<script type="text/javascript">

var ran=0;
function email(){
	
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
// 			alert("이메일을 보냈습니다"+random);
// 			ran=random;	
			swal({
				icon:"success",
				title: "이메일을 보냈습니다",
			});
			
			ran=random;
		}
	});	
};

//if (ran == 이메일인증.val()) emailCheck버튼
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


#findpw {

    background-color: rgb(255,80,90); 
     color:white;  
     border-radius: 5px;  
     border: 0;  
     padding: 11px 93px;  
   
}

.id_Button{
   background-color: rgb(220,220,220);
   color:black;
   border-radius: 2px;
   border: 0;
   padding: 6px 20px;

}
#emailcheckbox{
	display: none;
}
#login{

   	background-color: rgb(255,80,90);
    color:white; 
    border-radius: 5px; 
    border: 0; 
    padding: 11px 93px; 
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

   <h5><span>비밀번호 </span>찾기</h5>
   <hr>
   
<!--    비밀번호 확인 해주기  -->
<!--    메인화면 으로 가야하지 않나..?-->
	<form action="/pw/find" method="post" id="myForm">
  
	<h6><label>이름<span id="red">(필수)</span>
    	<input type="text" placeholder="이름" name="username" id="username" required style="height:30px; width: 495px"/></label>
    </h6>
      
    <h6><label >아이디<span id="red">(필수)</span>
    	<input type="email" placeholder="아이디" name="userid" id="userid" required style="height:30px; width: 495px"/></label>
    </h6>
      
   	<h6><label >이메일<span id="red">(필수)</span><br>
    	<input type="email" placeholder="이메일" name="useremail" id="useremail" required style="height:30px; width: 380px"/>
	  	<button type ="button" value="이메일인증" class="id_Button" onclick="email()">이메일인증</button></label>
	</h6>

  	<div id="emailcheckbox">
		<h6>이메일인증
			<input type="text"  name="useremailcheck" id="useremailcheck" maxlength="4" style="height:30px; width: 200px" />
			<button type ="button" class="id_Button" id="emailCheck" onclick="emailCheckFunc()">인증 확인</button>
			<div id="email_check"></div>
		</h6>
	</div>
	  
	<hr>
	
	<input type="hidden" id="hiddenEmailCheck"/>
	<button type="button" value="비밀번호찾기" id="findpw" onclick="pwFind()" >비밀번호찾기</button>
	<button type="button" value="로그인" id="login" onclick="location.href='/login/login'" value="로그인">로그인</button>
	<hr>
<!-- 	찾은아이디 반환넣어줄 -->
  	<div id="id_find"></div>
  	<br><br>
   </form>
</div>
</body>
</html>
