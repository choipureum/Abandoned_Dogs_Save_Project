<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri ="http://java.sun.com/jsp/jstl/core" %>  
<%@ taglib prefix="fmt" uri ="http://java.sun.com/jsp/jstl/fmt" %>  
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>입양신청 처리</title>
<script type="text/javascript">
	window.onload = function () {
				let timerInterval
				swal({
				  title: '입양신청 허가 중입니다',
				  html: '시간이 <b></b>초 남았습니다.',
				  timer: 2000,
				  timerProgressBar: true,
				  onBeforeOpen: () => {
				    Swal.showLoading()
				    timerInterval = setInterval(() => {
				      const content = Swal.getContent()
				      if (content) {
				        const b = content.querySelector('b')
				        if (b) {
				          b.textContent = Swal.getTimerLeft()
				        }
				      }
				    }, 100)
				  },
				  onClose: () => {
				    clearInterval(timerInterval)
				  }
				}).then((result) => {
					 swal({				
						  icon: "success",
						  text: "등급 수정이 완료되었습니다!",
						  timer:3000,
						}).then(function() {
							 window.opener.location.reload();
							 window.close();
					});
					
					
				});

		}
</script>
	<script src="https://code.jquery.com/jquery-3.5.1.js"></script>	
	<!-- Custom fonts for this template-->
  <link href="/resources/AdminTemplate/vendor/fontawesome-free/css/all.min.css" rel="stylesheet" type="text/css">
  <link href="https://fonts.googleapis.com/css?family=Nunito:200,200i,300,300i,400,400i,600,600i,700,700i,800,800i,900,900i" rel="stylesheet">
   <link href="https://code.jquery.com/ui/1.12.1/themes/base/jquery-ui.css" rel="stylesheet" type="text/css">
   <link href="https://cdn.datatables.net/1.10.21/css/dataTables.jqueryui.min.css" rel="stylesheet" type="text/css">
  <!-- Custom styles for this template-->
  <link href="/resources/AdminTemplate/css/sb-admin-2.min.css" rel="stylesheet">
  <!-- 체크박스 디자인 -->
  <link href=" https://cdn.jsdelivr.net/npm/pretty-checkbox@3.0/dist/pretty-checkbox.min.css" rel="stylesheet"/>
  <!-- httpRequest.js 임포트 --> 
 <script type="text/javascript" src="/resources/js/httpRequest.js"></script> 
 	<!--Alert 디자인 라이브러리 -->
   	<script src="https://unpkg.com/sweetalert/dist/sweetalert.min.js"></script>
<script>


</script>
</head>
<body>


</body>
<!-- Bootstrap core JavaScript-->
  <script src="/resources/AdminTemplate/vendor/jquery/jquery.min.js"></script>
  <script src="/resources/AdminTemplate/vendor/bootstrap/js/bootstrap.bundle.min.js"></script>

  <!-- Core plugin JavaScript-->
  <script src="/resources/AdminTemplate/vendor/jquery-easing/jquery.easing.min.js"></script>

  <!-- Custom scripts for all pages-->
  <script src="/resources/AdminTemplate/js/sb-admin-2.min.js"></script>
  
  


</html>