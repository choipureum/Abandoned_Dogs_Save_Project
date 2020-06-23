<%@page import="util.Paging"%>
<%@page import="java.util.ArrayList"%>
<%@page import="java.util.TreeMap"%>
<%@page import="java.util.List"%>
<%@page import="user.member.dto.MemberDTO"%>
<%@page import="java.util.Date"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri ="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri ="http://java.sun.com/jsp/jstl/fmt" %> 
<style>

td{
 white-space: nowrap;
}
/*회원메뉴 3개 그리드 너비, 테이블 조정*/
.fixed{
	width:400px;	
	word-break:break-all;
	padding:20px;
}
.fixed-grid{
	height:450px;
	
}
.fixed-info{
	width:400px;	
	word-break:break-all;
	padding:11px 11px 11px 60px;	
}
</style>

		<c:import url="/WEB-INF/views/admin/util/Header.jsp"></c:import>
        <!-- Begin Page Content -->
        <div class="container-fluid">

          <!-- Page Heading -->
          <p class="mb-4"><a href="/admin/dashboard" class="d-none d-sm-inline-block btn btn-sm text-gray-600">홈&nbsp;&nbsp;</a>
          	<a href="#"class="d-none d-sm-inline-block btn btn-sm text-gray-600">>&nbsp;&nbsp;</a>
          	<a href="/admin/memberlist"class="d-none d-sm-inline-block btn btn-sm text-gray-600">회원 관리&nbsp;&nbsp;</a>
          	<a href="#"class="d-none d-sm-inline-block btn btn-sm text-gray-600">>&nbsp;&nbsp;</a>
          	<a href="/admin/memberView?userid=${user.userid}"class="d-none d-sm-inline-block btn btn-sm text-gray-900">${user.userid }님 관리</a>         	
          </p>

        </div>
        <!-- /.container-fluid -->
		 <div class="card shadow mb-4">
                <div class="card-header py-3">
                  <h6 class="m-0 font-weight-bold text-primary">${user.userid } 님 회원 정보 &nbsp;&nbsp;&nbsp;
                   <!-- 삭제하기 버튼 onclick메소드 발동 - 삭제 -->
                   <a href="#" onclick="memberDelete();" class="btn btn-danger btn-circle btn-sm">
                    <i class="fas fa-trash"></i>
                  </a>
                   </h6>                  
                </div>
                <div class="card-body">
                 	<div class="col-6">
						<!-- 상세보기 테이블 만들기 -->                 	
                 		<table style="margin:30px;">                		
                 			<tr>
                 				<td rowspan="3"> <img class="img-profile rounded-circle" style="width:150px;height:150px;"
                     src="https://images.macrumors.com/t/x_zUFqghBUNBxVUZN_dYoKF3D9g=/1600x0/article-new/2019/04/guest-user-250x250.jpg"></td>
                 				<td colspan="3">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
                 				<i class="fas fa-users  text-gray-500"></i>&nbsp;&nbsp;  ${user.username }</td>
                 			</tr>                 		
                 			<tr>                 			
                 				<td>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
                 				<i class="fas fa-birthday-cake  text-gray-500"></i>&nbsp;&nbsp;  ${user.userbirth }</td>
                 			</tr>
                 			<tr>
                 				<td >&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
                 				<i class="fas fa-phone-volume  text-gray-500"></i>&nbsp;&nbsp;  ${user.usertel } </td>
                 			</tr>                		
                 		</table>                    	                    
                    </div>
                    <hr align="center">
                    <!-- 회원 정보,및 마이페이지에 속한 다양한 그리드 형식 정보 -->
                    <table>                   
                   		<tr>
                   		<!-- 회원 상세정보 boarder -->
                   		<td class="fixed">                   	
                     	<div class="card mb-4 py-3 border-left-success fixed-grid">
             		   		<div class="card-body">
                  				<span class="font-weight-bold text-gray-800">회원 상세 정보&nbsp;&nbsp;&nbsp;&nbsp; </span> 
                  				<!-- 이메일 보내기 버튼 onclick메소드 발동 - 메일창 -->
							        <a href="#" onclick="sendmail();" class="btn btn-primary btn-circle btn-sm">
							              <i class="fas fa-envelope"></i>
							          </a>&nbsp;&nbsp;  
							          <!-- 등급 업데이트 버튼 -->
							         <a href="#" onclick="updateGrade();" class="btn btn-warning btn-circle btn-sm">
							              <i class="fas fa-star"></i>
							          </a>                         				
                  				<hr style="width: 100%; ">
                  				<!-- 상세 정보 출력하기 -->
                  				<table width="500px"style="table-layout: fixed;">
                  					<tr>
                  						<td>회원 아이디</td>
                  						<td class="text-gray-900 fixed-info">${user.userid }</td>                  					
                  					</tr>
                  					<tr>
                  						<td>회원 이름</td>
                  						<td class="text-gray-900 fixed-info">${user.username }</td>                  					
                  					</tr>
                  					<tr>
                  						<td>회원 전화번호</td>
                  						<td class="text-gray-900 fixed-info">${user.usertel }</td>                  					
                  					</tr>
                  					<tr>
                  						<td>회원 생년월일</td>
                  						<td class="text-gray-900 fixed-info">${user.userbirth }</td>                  					
                  					</tr>
                  					<tr>
                  						<td>회원 주소</td>
                  						<td class="text-gray-900 fixed-info">${user.useraddress }</td>                  					
                  					</tr>
                  					<tr>
                  						<td>회원 가입일</td>
                  						<td class="text-gray-900 fixed-info">${user.userregdate }</td>                  					
                  					</tr>
                  					<tr>
                  						<td>회원 이메일</td>
                  						<td class="text-gray-900 fixed-info">${user.useremail }        						 						                  						       						
                  						</td> <!-- 이메일 끝 -->                 					
                  					</tr>
                  					<tr>
                  						<td>회원 등급</td>
                  						<td class="text-gray-900 fixed-info">${user.usergrade }                 						                     						           						
                  						</td>                  					
                  					</tr>	
                  				</table>
                				</div>
                			</div>
                		</td>
                		<!-- 회원이 찜한 강아지 목록 -->
                		<td class="fixed">                			
                			<div class="card mb-4 py-3 border-left-info fixed-grid">
                			<div class="card-body">
                  				<span class="font-weight-bold text-gray-800">찜한 강아지 목록</span>
                  				<hr style="width:100%">
                			</div>
                			</div>
                		</td>	
                		<!-- 회원이 입양한 강아지 목록(예시) -->
                		<td class="fixed">               			
                			<div class="card mb-4 py-3 border-left-warning fixed-grid">
                			<div class="card-body">
                  				<span class="font-weight-bold text-gray-800">입양받은 강아지</span>
                  				<hr style="width:100%">
                			</div>
                			</div>
                		</td>  
                		           			
              			</tr>
    				 </table>
              			</div>
                </div>
                 <!-- 메일 보내기 폼 메소드(히든) --> 
				<form id="MailPostForm" action="/resources/js/AdminMailForm.jsp" method="post" target="MailForm">
						<input type="hidden" id="Email" name="Email"/>	
				</form> 				        
          		<!-- 이메일 폼  -->
          		<!-- 등급아이디, 등급 폼 메소드(히든) --> 
				<form id="GradeForm" action="/resources/js/AdminUpdateGrade.jsp" method="post" target="gradeForm">
				    <input type="hidden" id="Grade" name="Grade"/>
				    <input type="hidden" id="gradeId" name="gradeId"/>				   	
				</form>         
   <c:import url="/WEB-INF/views/admin/util/Footer.jsp"></c:import>
  <!-- Bootstrap core JavaScript-->
  <script src="/resources/AdminTemplate/vendor/jquery/jquery.min.js"></script>
  <script src="/resources/AdminTemplate/vendor/bootstrap/js/bootstrap.bundle.min.js"></script>

  <!-- Core plugin JavaScript-->
  <script src="/resources/AdminTemplate/vendor/jquery-easing/jquery.easing.min.js"></script>

  <!-- Custom scripts for all pages-->
  <script src="/resources/AdminTemplate/js/sb-admin-2.min.js"></script>


<script>
<%--멤버 삭제 버튼 메소드 --%>
function memberDelete(){	
	swal({
		icon:"warning",
		text: "${user.userid} 회원 정보를 삭제하시겠습니까?",
		buttons:["아니요","회원 삭제"]
		
	}).then((Yes)=>{	
	
		var checkArr = new Array;		
		checkArr.push("${user.userid}");
		 $.post("/admin/delete",{"member_chk":checkArr},function(res){
			 swal({				
				  icon: "success",
				  text: "회원 삭제가 완료되었습니다!"
				}).then(function() {
					 location.href ="/admin/memberlist";								
			});
						 
		 });
	})
}
 <%--메일 보내기 sendmail 메소드--%> 
 function sendmail(){	
 	  var Email = "${user.useremail }";
 	  console.log(Email);
	  //문자열 정돈
	  Email=Email.substring(0, Email.length).trim();
	  var f = document.getElementById("MailPostForm");
	  window.open("","MailForm","width=800,height=630,left=250,right=150");				  
	  f.Email.value=Email;
	  f.target="MailForm";
	  f.submit();	   	
}
 <%--등급 변경 메소드--%>
 function updateGrade(){	
	  var grade = "${user.usergrade }";
	  var gradeId = "${user.userid}";	
	  var gradeName ="${user.username}";
	  
	  //문자열 정돈
	  grade = grade.trim();
	  gradeId=gradeId.substring(0, gradeId.length).trim();
	  var g = document.getElementById("GradeForm");
	  window.open("","gradeForm","width=500,height=450,left=250,right=150");	
	  g.Grade.value=grade;
	  g.gradeId.value =gradeId; 
	  g.target="gradeForm";
	  g.submit();	   	
}
</script>
</body>
</html>
