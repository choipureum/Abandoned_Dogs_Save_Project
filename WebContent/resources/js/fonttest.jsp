<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!doctype html>
<html>
<head>
<meta charset="utf-8">
    
<title>하트태그</title>
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/font-awesome/4.5.0/css/font-awesome.min.css">

<!-- 자바스크립트 -->
<script type="text/javascript" src="https://code.jquery.com/jquery-2.2.4.min.js"></script>

<script type="text/javascript">
$(document).ready(function(){
	$("#heart").click(function(){
		if($("#heart").hasClass("liked")){
			$("#heart").html('<i class="fa fa-heart-o" aria-hidden="true"></i>');
			$("#heart").removeClass("liked");
		}else{
			$("#heart").html('<i class="fa fa-heart" aria-hidden="true"></i>');
			$("#heart").addClass("liked");
		}
	});
});
</script>
    
<style>
.fa-heart-o {
  color: red;
  cursor: pointer;
}

.fa-heart {
  color: red;
  cursor: pointer;
}

</style>
</head>
<body>

<span id = heart><i class="fa fa-heart-o" aria-hidden="true" ></i> </span>

</body>
</html>