<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri ="http://java.sun.com/jsp/jstl/core" %>  
<%@ taglib prefix="fmt" uri ="http://java.sun.com/jsp/jstl/fmt" %>  
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>입양신청 처리</title>
<style type="text/css">
 
#memberContent{
 	overflow-y: scroll;  
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
	<form action="/admin/claimUpdate" method="post" class="container" style="margin:0 auto;padding:50px">
		 <div class="card position-relative">
                <div class="card-header py-3">
                  <h6 class="m-0 font-weight-bold text-primary">입양신청</h6>
                  
                </div>
                <div class="card-body">
                  <div class="mb-3">
                    <code>Current members : ${idCount } member</code><br><br>
                    <p class="mb-0 small"><code>Note:</code> 입양허가 신청은 변경은 관리자에게 권한이 있으며, 입양신청 처리를 하는 경우에는 기준 조건 충족시 수행할 수 있습니다. 입양신청은 <a href="/admin/memberlist">입양신청페이지</a>에서 가능합니다.</p>
                  </div>
                  <div class="small mb-1"><i class="fas fa-user fa-sm text-gray-300"></i>&nbsp;&nbsp;신청 회원목록</div><hr>                  
                 
                  <!-- 전체선택 -->
                   <a href="#" class="btn btn-secondary btn-icon-split btn-sm" onclick="chk_All()">
                    <span class="icon text-white-50">
                      <i class="fas fa-user-check"></i>
                    </span>
                    <span class="text">전체선택</span>
                  </a>
                  <!-- 입양 허가 -->
                  <a href="#" class="btn btn-success btn-icon-split btn-sm" onclick="Admit(1)"> <!-- 입양 허가 1 -->
                    <span class="icon text-white-50">
                      <i class="fas fa-check"></i>
                    </span>
                    <span class="text">입양허가</span>
                  </a>
                  <!--  입양 거절-->
                  <a href="#" class="btn btn-danger btn-icon-split btn-sm" onclick="Admit(2)"><!-- 입양 불허가 -->
                    <span class="icon text-white-50">
                      <i class="fas fa-times"></i>
                    </span>
                    <span class="text">입양불허가</span>
                  </a>
                              
                  <div class="navbar-light bg-light mb-4" style="padding:0 0 0 10px; height:240px; width:400px;" id="memberContent" >   
                  <br>
                  <!-- 반복문 하기 -->
                   <c:forEach items="${userid }" var="d">
                   <label for="${d }"> <input type="checkbox" class="member_chk" data-memberid="${d }"/>                     
                    <a class="navbar-brand" href="#" id="${d }"> &nbsp;&nbsp;${d }</a></label><br>
                    </c:forEach>                            
                  </div> 
                               
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
  
  
<script>
 function Admit(sw){
	 
	 //없을때 불가
	  if($("input[class='member_chk']:checked").length==0){
		  swal({				
			  icon: "error",
			  text: "최소 한명의 입양신청자를 선택해주세요!"
			})
		  return;
	  }
	
	 	 
	 //sw==1 입양신청 허가
	 if(sw==1){				
				swal({
					icon:"info",
					text: "입양신청을 승인하시겠습니까??",
					buttons:["아니요","예"]
					
				}).then((Yes)=> {				
					if(Yes){
						var checkArr = new Array();
						 
						 $("input[class='member_chk']:checked").each(function(){
							 checkArr.push($(this).attr("data-memberid"));
						 });	 
						 location.href="/admin/dogClaimAccept?userid="+ checkArr.join(",");
						 												
				}			
			})						 
	 }
	 //입양신청 불허가 sw==2
	 if(sw==2){
		 	 
			swal({
				icon:"error",
				text: "입양신청을 거절하시겠습니까?",
				buttons:["아니요","예"]
				
			}).then((Yes)=> {				
				if(Yes){
					var checkArr = new Array();
					 
					 $("input[class='member_chk']:checked").each(function(){
						 checkArr.push($(this).attr("data-memberid"));
					 });	 
					 
					 $.post("/admin/claimDelete",{"member_chk":checkArr},function(res){
						 swal({				
							  icon: "success",
							  text: "입양신청이 거절되었습니다!"
							}).then(function() {
								//종료
								 window.opener.location.reload();
								 window.close();					
						});				
					 });												
			}			
		})	
		 
	 }
 }


</script>
  
  
  
  
<script>

	//전체선택 
	  function chk_All(){	
		 if($(".member_chk").is(":checked")){
			 $(".member_chk").prop("checked",false);
		 }else{
			 $(".member_chk").prop("checked",true);
		 }
		
			  	
	  }
	//멤버 전체 선택 해제
	  function chk_All_Del(){
		  $(".member_chk").prop("checked",false);
		  $(".member_chk_All").prop("checked",false);
	  }
		 
</script>




</html>