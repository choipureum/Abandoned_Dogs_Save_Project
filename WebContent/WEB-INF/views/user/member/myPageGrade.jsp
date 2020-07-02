<%@page import="user.member.dto.MemberDTO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>   


<c:import url="/main/header"></c:import>
<c:import url="/WEB-INF/views/user/util/header.jsp"></c:import>
<c:import url="/WEB-INF/views/user/util/sidebar.jsp"></c:import>


<!--Alert 디자인 라이브러리 -->
<script src="https://unpkg.com/sweetalert/dist/sweetalert.min.js"></script>

<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>

<!-- 글씨체 -->
<link href="https://fonts.googleapis.com/css2?family=Do+Hyeon&display=swap" rel="stylesheet">
<!--Alert 디자인 라이브러리 -->
<script src="https://unpkg.com/sweetalert/dist/sweetalert.min.js"></script>
<!-- 다음 주소 api -->
<script src="https://t1.daumcdn.net/mapjsapi/bundle/postcode/prod/postcode.v2.js"></script>

<!--생년월일 기본값 가져오기 -->
<script type="text/javascript">
$(document).ready(function() {
   $("select[name='userbirth_mm']").val('${fn:substring(member.userbirth,4,6) }');
   
   $("select[name='userbirth_dd']").val('${fn:substring(member.userbirth,6,8) }');

})
</script>

<!-- css -->
<style type="text/css">

.container {
   width: 900px;

}

h2 {
   text-align: left;
}

h2 span {
   color: blue;
}


input {
   border: 1px solid lightgray;
   border-radius: 3px;
   border-bottom: teal 1px solid;
   border-left: medium none;
   border-right: medium none;
   border-top: medium none;
   font-size: 12px;
}

 select {    height: 35px; 
    width: 100px; 
 } 

/* 처음이름 */
.label {
   color: red;
   font-size: 15px;
}

 .tit_36 {    font-size: 20px; 
    font-weight: bold; 
 } 


h1 {
   margin: 0;
   padding: 5px;
}

h2{
text-align: center;
}


/*글씨체*/
 p { 
    font-size: 30px; 
 } 

</style>
</head>
<body>
      <!-- Banner -->
         <section id="banner">         
            <div class="content">
               <h1> <span class="light">회원등급안내</span></h1>
               <p> 다솜의 회원등급 안내 입니다 </p>
               <ul class="actions">
                  <li><a href="#one" class="button scrolly">회원 등급 안내</a></li>
               </ul>
            </div>
         </section>s
<!-- 입력  -->
<div class="container">
<br>
   <h2 id="one"> 회원 정보 </h2>
   <hr>
  
   <table>
      <tr>
         <td>
            <h5><label>아이디</label></h5>
            <input type="text" name="userid" id="userid"readonly="readonly" style="width: 385px" value="${member.userid }"/>
         </td>
         <td>
             <h5><label>이름</label></h5>
             <input type="text" placeholder="이름" name="username" id="username" readonly="readonly" class="underline" required style="width: 385px" value="${member.username }"/>
         </td>
      </tr>
      <tr>
         <td>
              <h5><label>핸드폰</label></h5>
             <input type="tel" readonly="readonly" placeholder="- 없이 숫자만 써주세요(숫자11자리)" class="underline" name="usertel" maxlength="11" id="usertel" required style="height: 43px; width: 385px" value="${member.usertel }"/>
         </td>
   
         <td>
               <h5><label>생년월일<br></label></h5>
              <input type="text" name="userbirth_yy" id="userbirth_yy" maxlength="4" placeholder="년(4자)" size="10" style="float:left;width:150px; display:inline-block;" readonly="readonly" value="${fn:substring(member.userbirth,0,4) }">
            <!--  생년월일 월 -->
               <input type="text" name="userbirth_mm" id="userbirth_mm"size="5" style="float:left;width:150px; display:inline-block;" readonly="readonly" value="${fn:substring(member.userbirth,4,6) }">

         <!--  생년월일 일 -->
                <input type="text" name="userbirth_dd" id="userbirth_dd" size="5" style="float:left;width:150px; display:inline-block;" readonly="readonly" value="${fn:substring(member.userbirth,6,8) }">
        </td>
      </tr>   

   </table>
   
   <table>   
      <tr>   
          <td>
             <h5><label >이메일</label></h5>
             <input type="email" placeholder="이메일"  class="underline" name="useremail" id="useremail" readonly="readonly" required style="width: 385px" value="${member.useremail }" />
         </td>
      </tr>
      <tr>
         <td>
            <h5><label>주소</label></h5>
            <div>기존 주소 : ${member.useraddress }</div>
         </td>
      </tr>
   </table>
</div>
<div class="container">
<br>
<h2> Member Grade </h2>
<hr>
   <!-- Table -->
   <div class="table-wrapper">
<table class="tbl_default2">
   <tbody>
      <tr>
         <th class="bln">등급</th>
         <td style="text-align: center; width:250px;">아이언</td>
         <td>실버</td>
         <td>골드</td>
         <td>다이아</td>
      </tr>
      <tr>
         <th class="bln"> </th>
         <td class="txt" style="text-align: center;"><img alt="" src="/resources/iron.jpg"></td>
         <td class="txt"><img alt="" src="/resources/silver.jpg"></td>
         <td class="txt"><img alt="" src="/resources/gold.jpg"></td>
         <td class="txt"><img alt="" src="/resources/diamond.jpg"></td>
      </tr>
      <tr>
         <th class="bln">등급기준</th>
         <td style="text-align: center;">신규회원  </td>
         <td>게시글 3회 작성</td>
         <td>게시글 6회 작성</td>
         <td>게시글 10회 작성</td>
      </tr>
   </tbody>
</table>   
   </div>
</div>

</body>


<c:import url="/WEB-INF/views/user/util/footer.jsp"></c:import>

