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
<%--한글 인코딩 --%>
<% request.setCharacterEncoding("UTF-8"); %>
<style>



</style>
	<!-- 헤더 임포트 -->
  	<c:import url="/WEB-INF/views/admin/util/Header.jsp"></c:import>
        <!-- Begin Page Content -->
        <div class="container-fluid">
			<!-- Page Heading -->
          <p class="mb-4"><a href="/admin/dashboard" class="d-none d-sm-inline-block btn btn-sm text-gray-600">홈&nbsp;&nbsp;</a>
          	<a href="#"class="d-none d-sm-inline-block btn btn-sm text-gray-600">>&nbsp;&nbsp;</a>
          	<a href="/admin/qna"class="d-none d-sm-inline-block btn btn-sm text-gray-900">QNA</a>
          	<a href="#"class="d-none d-sm-inline-block btn btn-sm text-gray-600">>&nbsp;&nbsp;</a>
          	<a href="/admin/qnaDetail"class="d-none d-sm-inline-block btn btn-sm text-gray-900">${qna.qnaWriter } 님의 QNA</a>
          </p>
            
         <!-- 폼태그 포스트 값전달 -->
         <div style="margin:0 auto;padding:40px"  >	
       
		 <div class="card position-relative">
                <div class="card-header py-3">
                  <h6 class="m-0 font-weight-bold text-primary">QNA 상세</h6>
                </div>
                <!-- 바디 -->
                <div class="card-body">
                  <div class="mb-3">
                     <code>Registration Caution  </code><p class="mb-0 small">QNA 답글은 등록시 자동 등록됩니다. 등록 후 게시판을 확인해주세요</p>
                  </div>
                  <div class="small mb-1"><i class='fas fa-question text-gray-400'></i> &nbsp;&nbsp; Question</div>
                  <hr>
                  <!-- 내용물 -->
                  <!-- 질문제목 -->
                  <nav class="navbar navbar-expand  mb-4">	                  
	                    <a class="navbar-brand">질문 제목</a>   
	                    <input type="hidden" name="qnano"/> 
	                   <input type="text" id="qnatitle" name="qnatitle" class="form-control bg-light border-0 small" value="${qna.qnaTitle }"style="width:500px; overflow:auto;"readonly>               
	                                
                  </nav>
                  <!-- 질문내용 -->
                  <nav class="navbar navbar-expand  mb-4">                
                    <a class="navbar-brand">질문 내용</a>                                      
                     <input type="text" id="qnacontent" name= "qnacontent"  class="form-control bg-light border-0 small" value="${qna.qnaContent }"style="width:500px; height:300px;overflow-y:scroll;"readonly>                 
                    </nav>
                    <!-- 작성회원 -->
                  <nav class="navbar navbar-expand  mb-4">                
                    <a class="navbar-brand">작성 회원</a>                                             
                     	<input type="text" id="qnawriter" name="qnawriter" class="form-control bg-light border-0 small" value="${qna.qnaWriter }"style="width:500px; "readonly>                
                    </nav>
                    <!-- 작성일자 -->
                  <nav class="navbar navbar-expand  mb-4">                
                    <a class="navbar-brand">작성일자</a>                                     
                     	<input type="text" id="qnaDate" name="qnaDate" class="form-control bg-light border-0 small" value="${qna.qnaDate }"style="width:500px; overflow:auto;"readonly>                 
                  </nav>
                  
                 
                   <!-- ------- 숨겨져잇는 댓글란------------------- -->
                    
                    <form action="/admin/qnaDetail" style="margin:0 auto;padding:40px;display:none;"  method="post" id="replyBtn">               
                   		
                   		<hr>
                   		<!-- 작성일자 -->
                  <nav class="navbar navbar-expand  mb-4">                
                    <a class="navbar-brand">답변 제목</a>                   
                     	<input type="hidden" name="qnano" value="${qna.qnaNO }">
                     	<input type="text" value="${ref.ref_title }"id="reftitle" name="reftitle" class="form-control bg-light border-0 small" style="width:500px; overflow:auto;">                  
                  </nav>
                   		<!-- 작성일자 -->
                  <nav class="navbar navbar-expand  mb-4">                
                    <a class="navbar-brand">답변 내용</a>                   
                     	<input type="text" value="${ref.ref_content }"id="refcontent" name="refcontent" class="form-control bg-light border-0 small" style="width:500px; height:400px;overflow:auto;">               
                  </nav>       
                 </form>
                  
                   <!-- ------------------- -->
                    <!-- 제출 버튼 -->
                  <nav class="navbar navbar-expand  mb-4">                                                
                    <ul class="navbar-nav ml-right">
                     	<li style="padding:30px 10px">
                     		<button class="btn btn-warning" type="button" onclick="submit()">
                 				 <i class="fas fa-bone fa-sm">&nbsp;관리자 QNA 답변 작성</i>
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
	</div>
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



<script>
	function submit(){	
		
			
		if($('#replyBtn').css("display") == "none") {
			$("#replyBtn").show();
			// 한번 더 눌렀을 때
			//제출
		} 	else{
			swal({
				icon:"warning",
				text:"답변을 작성하시겠습니까?",
				buttons:["아니요","작성"]
			}).then((Yes)=>{
				
				if(Yes){
					swal({
						icon:"success",
						text:"답변이 작성되었습니다"
					}).then(function(){
						$("#replyBtn").submit();				
					});
				}
			});
			

	
		}				
	}
</script>

</body>

</html>













