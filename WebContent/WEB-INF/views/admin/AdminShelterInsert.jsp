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


  	<c:import url="/WEB-INF/views/admin/util/Header.jsp"></c:import>
        <!-- Begin Page Content -->
        <div class="container-fluid">
			<!-- Page Heading -->
          <p class="mb-4"><a href="/admin/dashboard" class="d-none d-sm-inline-block btn btn-sm text-gray-600">홈&nbsp;&nbsp;</a>
          	<a href="#"class="d-none d-sm-inline-block btn btn-sm text-gray-600">>&nbsp;&nbsp;</a>
          	<a href="/admin/shelterInsert"class="d-none d-sm-inline-block btn btn-sm text-gray-900">유기견 보호소</a>
          </p>
            
         <!-- 폼태그 포스트 값전달 -->
         <form action="/admin/shelterInsert" method="post" id="dogInsertForm" style="margin:0 auto;padding:40px">
		 <div class="card position-relative">
                <div class="card-header py-3">
                  <h6 class="m-0 font-weight-bold text-primary">유기견 보호소 등록</h6>
                </div>
                <!-- 바디 -->
                <div class="card-body">
                  <div class="mb-3">
                     <code>Registration Caution  </code><p class="mb-0 small">등록시 유의사항-보호소명 확인에 유의하시기 바랍니다</p>
                  </div>
                  <div class="small mb-1">유기견 보호소</div>
                  <hr>
                  <!-- 내용물 -->
                  <!-- 보호소명 -->
                  <nav class="navbar navbar-expand  mb-4">
	                  
	                    <a class="navbar-brand">보호소 명</a>                   
	                    <ul class="navbar-nav ml-center">
	                     	<li><input type="text" id="dogName" name="dogName" class="form-control bg-light border-0 small" placeholder="강아지 이름"></li>
	                    </ul>               
                  </nav>
                  <!-- 주소 -->
                  <nav class="navbar navbar-expand  mb-4">                
                    <a class="navbar-brand">주소</a>                   
                    <ul class="navbar-nav ml-center">
                     	<li><input type="text" id="dogKind" name="dogKind" class="form-control bg-light border-0 small" placeholder="한글견종입력"></li>
                    </ul>
                    </nav>
                   <!-- 전화번호 -->
                  <nav class="navbar navbar-expand  mb-4">                
                    <a class="navbar-brand">전화번호</a>                   
                    <ul class="navbar-nav ml-center">
                     	<li><input type="text" id="dogTel" name="dogTel" class="form-control bg-light border-0 small" placeholder="한글견종입력"></li>
                    </ul>
                    </nav>
                   
                   
                     <!-- 제출 버튼 -->
                  <nav class="navbar navbar-expand  mb-4">                                                
                    <ul class="navbar-nav ml-right">
                     	<li style="padding:30px 10px">
                     		<button class="btn btn-warning" type="button" onclick="DogSubmit()">
                 				 <i class="fas fa-home fa-sm">&nbsp;등록</i>
                			</button>                			
						</li>
                   	 </ul>
                    </nav>
                  <p class="mb-0 small"><code>Note:</code> 「동물보호법」 제17조, 시행령7조 및 동법 시행규칙 제20조에 따라 유기·유실동물을 보호하고 있는 경우에는 소유자 등이
						보호조치 사실을 알 수 있도록 7일 동안 <a target="_blank" rel="nofollow" href="https://www.animal.go.kr/front/awtis/loss/lossList.do?menuNo=1000000057">공고</a>하여야 합니다.
						공고 중인 동물 소유자는 해당 시군구 및 동물보호센터에 문의하시어 동물을 찾아가시기 바랍니다.
						다만, 「동물보호법」 제19조 및 동법 시행규칙 제21조에 따라 소유자에게 보호비용이 청구될 수 있습니다.
						또한 「동물보호법」 제17조에 따른 공고가 있는 날부터 10일이 경과하여도 소유자 등을 알 수 없는 경우에는
						「유실물법」 제12조 및 「민법」 제253조의 규정에도 불구하고 해당 시·도지사 또는 시장·군수·구청장이 그 동물의 소유권을 취득하게 됩니다.</p>
                </div>
              </div>
	</form>      
        </div>
        <!-- /.container-fluid -->

      <c:import url="/WEB-INF/views/admin/util/Footer.jsp"></c:import>

 <!-- Bootstrap core JavaScript-->
  <script src="/resources/AdminTemplate/vendor/jquery/jquery.min.js"></script>
  <script src="/resources/AdminTemplate/vendor/bootstrap/js/bootstrap.bundle.min.js"></script>

  <!-- Core plugin JavaScript-->
  <script src="/resources/AdminTemplate/vendor/jquery-easing/jquery.easing.min.js"></script>

  <!-- Custom scripts for all pages-->
  <script src="/resources/AdminTemplate/js/sb-admin-2.min.js"></script>


<!-- 제출 -->
<script>
	//Dog 삽입 제출
	function DogSubmit(){
		swal({
			icon:"warning",
			text: "새로운 보호소 등록을 하시겠습니까?",
			buttons:["아니요","보호소 등록"]
			
		}).then((Yes)=>{				
			if(Yes){
				if(dogCheck()){
					swal({				
						  icon: "success",
						  text: "보호소 등록이 완료되었습니다!"
						}).then(function() {															
							$("#dogInsertForm").submit();									
				})
			}
		}			
	})
	}
	function dogCheck(){
		//제출 시 유효성 검사					
		   if(nullCheck($("#dogName").val().trim())){   
		      swal({								  
				  text: "보호소 이름을 입력해주세요"
				}).then(function() {															
					  return false;								
			});
		      return false;
		   }
		
		   if(nullCheck($("#dogKind").val().trim())){
			   swal({								  
					  text: "보호소 장소를 입력해주세요"
					}).then(function() {															
						  return false;								
				});
			      return false;
			   }
		   if(nullCheck($("#dogTel").val().trim())){
			   swal({								  
					  text: "보호소 번호를 입력해주세요"
					}).then(function() {															
						  return false;								
				});
			      return false;
			   }	
		   
		  return true;
	};
	//눌값 체크
function nullCheck(str){
	 if(typeof str == "undefined" || str == null || str == "")
         return true;
     else
         return false ;
}
</script>



</body>

</html>













