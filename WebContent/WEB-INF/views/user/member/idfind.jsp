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

<!-- //아이디 찾기  -->
<script type="text/javascript">
$(window).load(function(){
	$("#idFind").click(idFind);
})
// 	username, useremail

// 	눌렀을때
function idFind(event){
	
	var username=$("#username").val();
	var useremail=$("#useremail").val();
	
	
	if($("#username").val()==""){
		alert("이름을 입력하세요");
	} else if($("#useremail").val()==""){
		alert("이메일을 입력하세요");
	} 

// 	//배열에 유저정보 삽입
// 	var userinfo=new Array;
// 	userinfo.push(username);
// 	userinfo.push(useremail);
	
	//확인
	console.log(userinfo);
	
	$.ajax({
		type : 'POST',
		url : '/id/find',
// 		data : {"userinfo" : userinfo},
		data : {
			"username" : username
			, "useremail" : useremail
		},
		dataType: "json",
		success : function(r){
			
			//확인
			console.log(r.data);
			if(r.data != null && r.data != ''){				
				$("#id_find").text('회원님의 아이디는 : ' + r.data);
				$("#id_find").css('color','blue');
			} else{
				$("#id_find").text('일치정보가 없습니다');
				$("#id_find").css('color','red');
			}
		}
		, error: function() {
			console.log("ajax 실패")
		}
		
	});
	

}


//controller전달 하는 부분





//이름이ㅏㄹㅇ 이메일 보내서

</script>

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

#findid {

    background-color: rgb(255,80,90); 
     color:white;  
     border-radius: 5px;  
     border: 0;  
     padding: 11px 95px;  
   
}

#login{

   	background-color: rgb(255,80,90);
    color:white; 
    border-radius: 5px; 
    border: 0; 
    padding: 11px 95px; 
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
   <form action="/id/find" method="post" id="myForm">

  
   <h6><label>이름<span id="red">(필수)</span>
      <input type="text" placeholder="이름" name="username" id="username" required style="height:30px; width: 495px"/></label>
      <div id="name_check"></div></h6>

   <h6><label >이메일<span id="red">(필수)</span>
      <input type="email" placeholder="이메일" name="useremail" id="useremail" required style="height:30px; width: 495px"/></label></h6>

	<hr>
	<button type="button" value="아이디 찾기" id="findid" onclick="idFind()" value="아이디찾기">아이디찾기</button>
	<button type="button" value="로그인" id="login" onclick="location.href='/login/login'" value="로그인">로그인</button>
	<hr>
<!-- 	찾은아이디 반환넣어줄 -->
  	<div id="id_find"></div>
  	<br><br>
   </form>
</div>
</body>
</html>
