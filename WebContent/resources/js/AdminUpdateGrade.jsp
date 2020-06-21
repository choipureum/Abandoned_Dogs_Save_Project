<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri ="http://java.sun.com/jsp/jstl/core" %>  
<%@ taglib prefix="fmt" uri ="http://java.sun.com/jsp/jstl/fmt" %>  
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>등급 변경</title>
<style type="text/css">
 
.boxContent{
 	overflow-y: scroll;
 	width: 300px;
    height: 300px;
    border:1px solid #eee;
}
.fa-chevron-right:hover{
	color:black;

}
</style>
	<script src="https://code.jquery.com/jquery-3.5.1.js"></script>	
	<!-- Custom fonts for this template-->
  <link href="/resources/AdminTemplate/vendor/fontawesome-free/css/all.min.css" rel="stylesheet" type="text/css">
  <link href="https://fonts.googleapis.com/css?family=Nunito:200,200i,300,300i,400,400i,600,600i,700,700i,800,800i,900,900i" rel="stylesheet">
   <link href="https://code.jquery.com/ui/1.12.1/themes/base/jquery-ui.css" rel="stylesheet" type="text/css">
   <link href="https://cdn.datatables.net/1.10.21/css/dataTables.jqueryui.min.css" rel="stylesheet" type="text/css">
  <!-- Custom styles for this template-->
  <link href="/resources/AdminTemplate/css/sb-admin-2.min.css" rel="stylesheet">
  <!-- httpRequest.js 임포트 --> 
 <script type="text/javascript" src="/resources/js/httpRequest.js"></script> 
<script>
function close(){
    opener.location.reload();
    window.close();
}

function update(sw){
	var num = sw
	var userGradeById ="${param.gradeId}"
			
	$.ajax({
		type : 'POST',
		url : '/admin/updateGrade',
		data : {
			"grade" : num
			, "id" : userGradeById
		},
		dataType: "json",
		success : function(r){			
			//확인
			location.href="/resources/js/updateComplete.jsp"
		}
		, error: function() {
			console.log("등급 업데이트 실패")
		}		
	});
}
</script>
</head>
<body>
	<form action="/admin/updateGrade" method="post" class="container" style="margin:0 auto;padding:50px">
		 <div class="card position-relative">
                <div class="card-header py-3">
                  <h6 class="m-0 font-weight-bold text-primary">회원 등급 변경</h6>
                </div>
                <div class="card-body">
                  <div class="mb-3">
                    <code>Current Rating : ${param.Grade }</code>
                  </div>
                  <div class="small mb-1">회원</div>
                  <nav class="navbar navbar-expand navbar-light bg-light mb-4">
                    <a class="navbar-brand" href="#">${param.gradeId }</a>
                    <ul class="navbar-nav ml-auto">
                      <li class="nav-item dropdown">
                        <a class="nav-link dropdown-toggle" href="#" id="navbarDropdown" role="button" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
                          등급 조정
                        </a>
                        <div class="dropdown-menu dropdown-menu-right animated--grow-in" aria-labelledby="navbarDropdown">
                          <a class="dropdown-item" href="#" onclick="update(1)">아이언</a>
                          <a class="dropdown-item" href="#" onclick="update(2)">실버</a>  
                          <a class="dropdown-item" href="#" onclick="update(3)">골드</a>
                          <a class="dropdown-item" href="#" onclick="update(4)">다이아</a>
                        </div>
                      </li>
                    </ul>
                  </nav>
                  <p class="mb-0 small">Note: 회원 등급 변경은 관리자에게 권한이 있으며, 등급을 조정하는 경우에는 기준 조건 충족시 수행할 수 있습니다. 등급 변경은 <a href="/admin/memberlist">회원관리</a>에서 가능합니다.</p>
                </div>
              </div>
	</form>
</body>
<!-- Bootstrap core JavaScript-->
  <script src="/resources/AdminTemplate/vendor/jquery/jquery.min.js"></script>
  <script src="/resources/AdminTemplate/vendor/bootstrap/js/bootstrap.bundle.min.js"></script>

  <!-- Core plugin JavaScript-->
  <script src="/resources/AdminTemplate/vendor/jquery-easing/jquery.easing.min.js"></script>

  <!-- Custom scripts for all pages-->
  <script src="/resources/AdminTemplate/js/sb-admin-2.min.js"></script>
</html>