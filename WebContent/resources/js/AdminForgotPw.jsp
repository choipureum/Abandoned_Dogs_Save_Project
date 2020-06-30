<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">

<head>
 	<!--Alert 디자인 라이브러리 -->
   	<script src="https://unpkg.com/sweetalert/dist/sweetalert.min.js"></script>
  <meta charset="utf-8">


  <title>관리자 Forgot Password</title>

  <!-- Custom fonts for this template-->
  <link href="/resources/AdminTemplate/vendor/fontawesome-free/css/all.min.css" rel="stylesheet" type="text/css">
  <link href="https://fonts.googleapis.com/css?family=Nunito:200,200i,300,300i,400,400i,600,600i,700,700i,800,800i,900,900i" rel="stylesheet">

  <!-- Custom styles for this template-->
  <link href="/resources/AdminTemplate/css/sb-admin-2.min.css" rel="stylesheet">

</head>

<body class="bg-gradient-primary">

  <div class="container">

    <!-- Outer Row -->
    <div class="row justify-content-center" style="margin:80px 50px;">

      <div class="col-xl-10 col-lg-12 col-md-9">

        <div class="card o-hidden border-0 shadow-lg my-5">
          <div class="card-body p-0">
            <!-- Nested Row within Card Body -->
            <div class="row">
              <div class="col-lg-6 d-none d-lg-block bg-password-image"></div>
              <div class="col-lg-6">
                <div class="p-5">
                  <div class="text-center">
                    <h1 class="h4 text-gray-900 mb-2">비밀번호 찾기</h1>
                    <p class="mb-4">관리자 page 비밀번호는 관리자 계정 메일로 발송 됩니다. email을 확인해주시기 바랍니다</p>
                  </div>
                  <form class="user">
                    <div class="form-group">
                      <input type="email" class="form-control form-control-user" id="AdminEmail"name="email"aria-describedby="emailHelp" placeholder="Enter Email Address...">
                    </div>
                    <a href="#" class="btn btn-primary btn-user btn-block" onclick="submit()">
                    	이메일 페이지 발송
                    </a>
                  </form>
                  <hr>
                  
                  <div class="text-center">
                    <a class="small" href="/admin">로그인 페이지 이동</a>
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
  <script src="/resources/AdminTemplate/vendor/bootstrap/js/bootstrap.bundle.min.js"></script>

  <!-- Core plugin JavaScript-->
  <script src="/resources/AdminTemplate/vendor/jquery-easing/jquery.easing.min.js"></script>

  <!-- Custom scripts for all pages-->
  <script src="/resources/AdminTemplate/js/sb-admin-2.min.js"></script>
<script type="text/javascript">
function submit(){
	var email = $("#AdminEmail").val();

	if(email == 'pooreumsunny@gmail.com'){
		$.post("/admin/emailcheck",{'email' : email},function(res){
			swal({
				icon:"info",
				text: "이메일을 발송하였습니다"
			}).then(function(){
				location.href="/admin";
			});
		})
	}else{
		swal({
		icon:"error",
		text: "관리자 이메일이 아닙니다!"
		})
	}
}


</script>
</body>

</html>
