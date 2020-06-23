<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
  <head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <meta http-equiv="X-UA-Compatible" content="ie=edge">
   <!-- jQuery -->
   	<script src="https://code.jquery.com/jquery-3.5.1.js"></script>	
   	   	<!--Alert 디자인 라이브러리 -->
   	<script src="https://unpkg.com/sweetalert/dist/sweetalert.min.js"></script>
<script type="text/javascript">
window.onload = function () {
	 swal({				
		  icon: "success",
		  text: "등급 수정이 완료되었습니다!",
		  timer:3000,
		}).then(function() {
			 window.opener.location.reload();
			 window.close();
	});	
	

	}
</script>
    <title>Complete!</title>
  </head>
  <body>
  </body>
</html>