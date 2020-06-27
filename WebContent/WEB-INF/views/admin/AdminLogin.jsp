<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri ="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html lang="en">

<head>

  <meta charset="utf-8">

  <title>다솜 :: 관리자 로그인 페이지</title>

  <!-- Custom styles for this template-->
  <link href="/resources/AdminTemplate/css/sb-admin-2.min.css" rel="stylesheet">
	<!-- Custom fonts for this template-->
  <link href="/resources/AdminTemplate/vendor/fontawesome-free/css/all.min.css" rel="stylesheet" type="text/css">
  <link href="https://fonts.googleapis.com/css?family=Nunito:200,200i,300,300i,400,400i,600,600i,700,700i,800,800i,900,900i" rel="stylesheet">
   <link href="https://code.jquery.com/ui/1.12.1/themes/base/jquery-ui.css" rel="stylesheet" type="text/css">
   <link href="https://cdn.datatables.net/1.10.21/css/dataTables.jqueryui.min.css" rel="stylesheet" type="text/css">
   <!-- 체크박스, 라디오버튼 -->
   <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/pretty-checkbox@3.0/dist/pretty-checkbox.min.css">
  
  <!-- Custom styles for this template-->
  <link href="/resources/AdminTemplate/css/sb-admin-2.min.css" rel="stylesheet">
  <!-- httpRequest.js 임포트 --> 
 <script type="text/javascript" src="/resources/js/httpRequest.js"></script> 
  <!-- google charts import -->
   <script type="text/javascript" src="https://www.gstatic.com/charts/loader.js"></script>
   <!-- jQuery -->
   	<script src="https://code.jquery.com/jquery-3.5.1.js"></script>	
   	<!--Alert 디자인 라이브러리 -->
   	<script src="https://unpkg.com/sweetalert/dist/sweetalert.min.js"></script>
</head>

<body class="bg-gradient-primary">

  <div class="container" >

    <!-- Outer Row -->
    <div class="row justify-content-center" style="margin:80px 50px;">

      <div class="col-xl-10 col-lg-12 col-md-9">

        <div class="card o-hidden border-0 shadow-lg my-5">
          <div class="card-body p-0">
            <!-- Nested Row within Card Body -->
            <div class="row">
              <div class="col-lg-6 d-none d-lg-block bg-login-image"></div>
              <div class="col-lg-6">
                <div class="p-5">
                  <div class="text-center">
                    <h1 class="h4 text-gray-900 mb-4">다솜 : 관리자 페이지</h1>
                  </div>
                  <form class="user" method="post" action="/admin" >
                    <div class="form-group">
                      <input type="email"name="adminId" class="form-control form-control-user" id="userId" aria-describedby="emailHelp" placeholder="Enter Email Address...">
                    </div>
                    <div class="form-group">
                      <input type="password"name="adminPw" class="form-control form-control-user" id="userPw" placeholder="Password">
                    </div>
                    <div class="form-group">
                      <div class="custom-control custom-checkbox small">
                        <input type="checkbox" class="custom-control-input">
                        <label class="custom-control-label" for="customCheck">아이디 저장</label>
                      </div>
                    </div>
                    <a href="#" class="btn btn-primary btn-user btn-block" onclick="submit()">
                      Login
                    </a>
                    <hr>
                   
                  </form>
                  
                  <div class="text-center">
                    <a class="small" href="/resources/js/AdminForgotPw.jsp">비밀번호 찾기</a>
                  </div>
                
                </div>
              </div>
            </div>
          </div>
        </div>

      </div>

    </div>

  </div>

  <!-- Bootstrap core JavaScript-->
  <script src="/resources/AdminTemplate/vendor/jquery/jquery.min.js"></script>
  <script src="/resources/AdminTemplate/endor/bootstrap/js/bootstrap.bundle.min.js"></script>

  <!-- Core plugin JavaScript-->
  <script src="/resources/AdminTemplate/vendor/jquery-easing/jquery.easing.min.js"></script>



</body>

<script type="text/javascript">
//제출 메소드
function submit(){
	var userid=$("#userId").val();
	var userpw=$("#userPw").val();
	
	
	if($("#userId").val()==""){
		swal({				
			  icon: "error",
			  text: "아이디를 입력하세요!"
			});
		return false;
		
	}
	else if($("#userPw").val()==""){
		swal({				
			  icon: "error",
			  text: "비밀번호를 입력하세요!"
			});
		return false;
	}
	$.ajax({
		type : 'POST',
		url : '/admin',

		data : {
			"userid" : userid
			, "userpw" : userpw		
		},		
		dataType: "json",
		success : function(res){
			console.log(res);
			if(res.data == 0){ 
				swal({				
					  icon: "success",
					  text: "로그인 성공"
					}).then(function(){
						location.href="/admin/dashboard";		
					});
					
			}
			else if(res.data==1){
				swal({				
					  icon: "error",
					  text: "아이디 오류입니다"
					});
			}else{
				swal({				
					  icon: "error",
					  text: "비밀번호 오류입니다"
					});
			}

		}
		, error: function() {
			console.log("ajax 실패")
		}
		
	});			
}
</script>

</html>
