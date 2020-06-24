<%@page import="user.member.dto.MemberDTO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    

<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>


<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>마이페이지 수정</title>

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

<!--생년월일 기본값 가져오기 -->
<script type="text/javascript">
$(document).ready(function() {
	$("select[name='userbirth_mm']").val('${fn:substring(member.userbirth,4,6) }');
	
	$("select[name='userbirth_dd']").val('${fn:substring(member.userbirth,6,8) }');

})
</script>

<!-- 유효성검사 -->
<script type="text/javascript">
$(document).ready(function(){
	
	//#userpassword 검증
	var upwReg = /^[A-Za-z0-9]{6,18}$/;
	
  	//출생년도 정규식 ( 생년월일 )
  	var yearReg = /^(19|20)[0-9]{2}$/;
	
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

		   if(!upwReg.test($("#userpw").val())){
		      alert("비밀번호는 6에서 18자리 소문자, 숫자를 ~");

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

		   if(!yearReg.test($("#userbirth_yy").val())){
			   alert("년도를 확인하세요");
			   
			   return false;
		   }		   	

		   
		}) 		
		return true;

})



</script>



<!-- css -->
<style type="text/css">


#emailcheckbox{
	display: none;
}
.container{
   width:800px;
   margin :40px auto;
   line-height: 16px;
}

h2{
   text-align: left;
}

h2 span{
   color:blue;
   
}
/* 수정하기 */
.modify {

   background-color: #7DBCBE;
   color:white;
   border-radius: 5px;
   border: 0;
   padding: 10px 160px;
   
}

.withdraw{
   background-color: black;
   color:white;
   border-radius: 5px;
   border: 0;
   padding: 10px 160px;
}

.btn_btn{
	margin:auto;
	width:50%;
	
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
    border-bottom: teal 1px solid;
    border-left: medium none;
    border-right: medium none;
    border-top: medium none;
	font-size:12px;
}

#red{
   color:red;
}

select{
   height:35px; 
   width: 100px;
}

/* 처음이름 */
.label{
	color:red;
	font-size:13px;
}
.tit_36{
	font-size: 20px;
	font-weight: bold;
}

/* 탈퇴모달 */

/* 모달버튼 */
.modalwithdraw{
	all: unset;
	background-color: black;
	color: white;
	padding: 15px 25px;
	border-radius: 6px;
	cursor: pointer;
}

.modalcancel{
	all: unset;
	background-color: #7DBCBE;
	color: white;
	padding: 15px 25px;
	border-radius: 6px;
	cursor: pointer;


}
.modal{
	position: fixed;
	top: 0; left: 0;
	width: 100%; height: 100%;
	display: flex;
	justify-content: center;
	align-items : center;
}
/* 모달뒷배경 */
.md_overlay {
	background-color: rgba(0, 0, 0, 0.6);
	width: 100%; height: 100%;
	position: absolute;
}
/* 모달창크기 */
.md_content {
	width: 50%; 
	height : 30%;
	position: relative;
	padding: 100px 100px;
	background-color: white;
	text-align: center;
	border-radius: 6px;
	box-shadow: 0 10px 20px rgba(0,0,0,0.20), 0 6px 6px rgba(0, 0, 0, 0.20);
}
h1 {
	margin:0; 
	padding: 5px;
}
.hidden {
	display: none;
}
.modal_text { padding: 16px; }

</style>
</head>
<body>
<!-- 입력  -->
<div class="container">

    <p class="tit_36">회원정보 변경<span class="label">(필수는 꼭 해주세요!)</span></p>
   
   <hr>
   <form action="/mypage/modify" method="post" id="myForm">
   
<table>
<tr>
	<td>
		<h6><label>아이디<br>
		<input type="text" name="userid" id="userid"readonly="readonly" style="height:30px; width: 385px" value="${member.userid }"/></h6>
	</td>
	<td>
    	<h6><label>이름<br>
    	<input type="text" placeholder="이름" name="username" id="username" readonly="readonly" class="underline" required style="height:30px; width: 385px" value="${member.username }"/></label></h6>
	</td>
</tr>

<tr>
	<td>
		<h6><label>비밀번호<span id="red">(필수)</span>
		<input type="password" placeholder="비밀번호" name="userpw" id="userpw" required style="height:30px; width: 385px"/></label>
		<div id="pw_check"></div></h6>
  </td>
  <td>
		<h6><label>비밀번호확인<span id="red">(필수)</span>
		<input type="password" placeholder="비밀번호확인" name="userpw_ck" id="userpw_ck" required style="height:30px; width: 385px"/></label>
		<div id="pw_check2"></div></h6>
   </td>
</tr>

<tr>
	<td>
  		<h6><label>핸드폰<span id="red">( - 표시 없이 11자리로만 써주세요!)</span>
    	<input type="tel" placeholder="- 없이 숫자만 써주세요(숫자11자리)" class="underline" name="usertel" maxlength="11" id="usertel" required style="height:30px; width: 385px" value="${member.usertel }"/></label></h6>
	</td>
	
	<td>
   		<h6><label>생년월일<span id="red">(필수)</span><br>
        	<input type="text" name="userbirth_yy" id="userbirth_yy" maxlength="4" placeholder="년(4자)" size="10" required style="height:30px"  value="${fn:substring(member.userbirth,0,4) }">
<!--  	생년월일 월 -->
      <select name="userbirth_mm">
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
      <select name="userbirth_dd">
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
	<td>
	
</tr>
</table>

<table>
<tr>

<!--     이메일중복체크 값 체크용 힐든 벨류  -->
		<input type="hidden" id="hiddenEmailCheck"/>
 	  <h6><label >이메일<br>
      <input type="email" placeholder="이메일"  class="underline" name="useremail" id="useremail" readonly="readonly" required style="height:30px; width: 385px" value="${member.useremail }" />

</tr>

<tr>
	<h6>주소<span id="red">(필수)</span>
	<div>기존 주소 : ${member.useraddress }</div>
	<div class="form-group">                   
		<input class="form-control"  placeholder="우편번호" name="mem_oaddress" id="mem_oaddress" type="text" readonly="readonly" required style=" height:28px; width: 100px">
    	<button type="button" class="btn-default" onclick="execPostCode();"><i class="fa fa-search"></i> 우편번호 찾기</button>                               
	</div>

	<div class="form-group">
    	<input type="text" class="form-control"  placeholder="도로명 주소" name="mem_address" id="mem_address" required style="height:30px; width: 270px" readonly="readonly" />
   	 	<input type="text" class="form-control" placeholder="상세주소" name="mem_detailaddress" id="mem_detailaddress" required style="height:30px; width: 240px"/>
	</div></h6>

</tr>
</table>
	
	<hr>
	

	<div class="first" style="float:left;">
<!-- 	<button type="button" value="수정하기" class="modify">수정하기</button> -->
	<input type="submit" value="수정하기" class="modify" />
	</div>
	<div class="second" style="float:right;">
	<button type="button" id="open" value="탈퇴하기" class="withdraw">탈퇴하기</button>
		<div class="modal hidden">
		<div class="md_overlay"></div>
		<div class="md_content" style="width:500px">
			<h1>탈퇴하기</h1><br>
			<div class="modal_text" style="border: 1px solid gold; padding: 10px; height: 150px;">
				그동안 다솜을 이용해 주셔서 감사합니다.
				더 좋은 서비스와 품질로 보답하겠습니다.

				* 탈퇴 후에는 아이디와 예약내역 등의 데이터 복구가 불가능합니다.
				* 탈퇴 후에는 등록된 게시물 삭제가 불가능합니다. 

			</div>
			<br>
			<button type="button" class="modalwithdraw">탈퇴하기</button>
			<button type="button" id="cancel" class="modalcancel">취소하기</button>		
		</div>
	</div>
	</div>
	
	<script type="text/javascript">
	

		//필요한 엘리먼트들을 선택한다.
		const openButton = document.getElementById("open");
		const modal = document.querySelector(".modal");
		const overlay = modal.querySelector(".md_overlay");
		const closeButton = modal.querySelector("#cancel");

		//동작함수
		const openModal = () => {
			modal.classList.remove("hidden");
		}
		const closeModal = () => {
			modal.classList.add("hidden");
		}
		//클릭 이벤트
		openButton.addEventListener("click", openModal);
		closeButton.addEventListener("click", closeModal);
		
	
	</script>
	</form>

</div>

   

</body>
</html>
