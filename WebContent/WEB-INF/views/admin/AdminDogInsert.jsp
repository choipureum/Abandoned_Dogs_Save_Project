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
 <!-- 파일박스 스타일 -->
<style>
 .filebox input[type="file"] { position: absolute; width: 1px; height: 1px; padding: 0; margin: -1px; overflow: hidden; clip:rect(0,0,0,0); border: 0; }  
 .filebox label { display: inline-block; margin:0 20px; padding: .5em .75em; color: #999; font-size: inherit; line-height: normal; vertical-align: middle; background-color: #fdfdfd; cursor: pointer; border: 1px solid #ebebeb; border-bottom-color: #e2e2e2; border-radius: .25em; }  
 .filebox .upload-name { display: inline-block; padding: .5em .75em; /* label의 패딩값과 일치 */ font-size: inherit; font-family: inherit; line-height: normal; vertical-align: middle; background-color: #f5f5f5; border: 1px solid #ebebeb; border-bottom-color: #e2e2e2; border-radius: .25em; -webkit-appearance: none; /* 네이티브 외형 감추기 */ -moz-appearance: none; appearance: none; } 
 /* imaged preview */   
 /* 이미지가 표시될 지역 */ 
 .filebox .upload-display { margin-bottom: 5px; }  
 @media(min-width: 768px) {  
 	.filebox .upload-display { display: inline-block; margin-right: 5px; margin-bottom: 0; }  
 	}  
 /* 추가될 이미지를 감싸는 요소 */ 
 .filebox .upload-thumb-wrap {  display: inline-block; width: 54px; padding: 2px; vertical-align: middle; border: 1px solid #ddd; border-radius: 5px; background-color: #fff; }  
 /* 추가될 이미지 */ 
 .filebox .upload-display img {  display: block; max-width: 100%; width: 100% \9; height: auto; } 
</style>
  	<c:import url="/WEB-INF/views/admin/util/Header.jsp"></c:import>
        <!-- Begin Page Content -->
        <div class="container-fluid">
			<!-- Page Heading -->
          <p class="mb-4"><a href="/admin/dashboard" class="d-none d-sm-inline-block btn btn-sm text-gray-600">홈&nbsp;&nbsp;</a>
          	<a href="#"class="d-none d-sm-inline-block btn btn-sm text-gray-600">>&nbsp;&nbsp;</a>
          	<a href="/admin/dogInsert"class="d-none d-sm-inline-block btn btn-sm text-gray-900">유기견 등록</a>
          </p>
            
         <!-- 폼태그 포스트 값전달 -->
         <form action="/admin/dogInsert" method="post" id="dogInsertForm" style="margin:0 auto;padding:40px" enctype="multipart/form-data">
		 <div class="card position-relative">
                <div class="card-header py-3">
                  <h6 class="m-0 font-weight-bold text-primary">유기견 등록</h6>
                </div>
                <!-- 바디 -->
                <div class="card-body">
                  <div class="mb-3">
                     <code>Registration Caution  </code><p class="mb-0 small">등록시 유의사항-품종오류가 발생할 수 있으니 품종입력에 유의하시기 바랍니다</p>
                  </div>
                  <div class="small mb-1">유기견</div>
                  <hr>
                  <!-- 내용물 -->
                  <!-- 이름 -->
                  <nav class="navbar navbar-expand  mb-4">
	                  
	                    <a class="navbar-brand">이름</a>                   
	                    <ul class="navbar-nav ml-center">
	                     	<li><input type="text" id="dogName" name="dogName" class="form-control bg-light border-0 small" placeholder="강아지 이름"></li>
	                    </ul>               
                  </nav>
                  <!-- 견종 -->
                  <nav class="navbar navbar-expand  mb-4">                
                    <a class="navbar-brand">견종</a>                   
                    <ul class="navbar-nav ml-center">
                     	<li><input type="text" id="dogKind" name="dogKind" class="form-control bg-light border-0 small" placeholder="한글견종입력"></li>
                    </ul>
                    </nav>
                    <!-- 성별 -->
                  <nav class="navbar navbar-expand  mb-4">                
                    <a class="navbar-brand">성별</a>                   
                    <ul class="navbar-nav ml-center">                
                     	<li>
                     	<!-- 암컷 -->
                     	 <div class="pretty p-default p-round p-thick">                    			
						        <input type="checkbox" value="M" id=manCkeck name="genderCheck"/>
						        <div class="state">
						            <label for="manCheck">수컷</label>
						        </div>						        
						    </div>
						    <!-- 슈컷 -->
						    <div class="pretty p-default p-round p-thick">
                     			<!-- 암컷 -->
						        <input type="checkbox" value="W" id="womanCheck" name="genderCheck"/>
						        <div class="state">
						            <label for="womanCheck">암컷</label>
						        </div>						        
						    </div>
						    </li>                     	
                    </ul>
                    </nav>
                    <!-- 중성화 -->
                  <nav class="navbar navbar-expand  mb-4">                
                    <a class="navbar-brand">중성화</a>                   
                    <ul class="navbar-nav ml-center">
                     	<li>
                     		<div class="pretty p-switch p-fill">
						     <input type="checkbox" name="dogNeu" value="Y"/>
						        <div class="state">
						            <label>&nbsp;&nbsp;Neutered</label>
						        </div>
						    </div></li>
                   	 </ul>
                    </nav>
                    <!-- 사진 -->
                  <nav class="navbar navbar-expand  mb-4">                
                    <a class="navbar-brand">사진</a>                   
                    <ul class="navbar-nav ml-center">
                     	<li>
                     		<div class="filebox bs3-primary preview-image">
                            <input class="upload-name" value="파일선택" disabled="disabled" style="width: 200px;">
                            <label for="dogImg">업로드</label> 
                          <input type="file" id="dogImg" class="upload-hidden" name="dogImg"> 
                        </div>
						</li>
                    </ul>
                    </nav>
                     <!-- 제출 버튼 -->
                  <nav class="navbar navbar-expand  mb-4">                                                
                    <ul class="navbar-nav ml-right">
                     	<li style="padding:30px 10px">
                     		<button class="btn btn-warning" type="button" onclick="DogSubmit()">
                 				 <i class="fas fa-bone fa-sm">&nbsp;등록</i>
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
<!-- 이미지처리 스크립트 -->,<!-- 수컷 암컷중 하나만 선택하는 라디오 버튼 으로 교체 -->
<script>
$(document).ready(function(){
	   var fileTarget = $('.filebox .upload-hidden');

	    fileTarget.on('change', function(){
	        if(window.FileReader){
	            // 파일명 추출
	            var filename = $(this)[0].files[0].name;
	        } 

	        else {
	            // Old IE 파일명 추출
	            var filename = $(this).val().split('/').pop().split('\\').pop();
	        };

	        $(this).siblings('.upload-name').val(filename);
	    });

	    //preview image 
	    var imgTarget = $('.preview-image .upload-hidden');

	    imgTarget.on('change', function(){
	        var parent = $(this).parent();
	        parent.children('.upload-display').remove();

	        if(window.FileReader){
	            //image 파일만
	            if (!$(this)[0].files[0].type.match(/image\//)) return;
	            
	            var reader = new FileReader();
	            reader.onload = function(e){
	                var src = e.target.result;
	                parent.prepend('<div class="upload-display"><div class="upload-thumb-wrap"><img src="'+src+'" class="upload-thumb"></div></div>');
	            }
	            reader.readAsDataURL($(this)[0].files[0]);
	        }

	        else {
	            $(this)[0].select();
	            $(this)[0].blur();
	            var imgSrc = document.selection.createRange().text;
	            parent.prepend('<div class="upload-display"><div class="upload-thumb-wrap"><img class="upload-thumb"></div></div>');

	            var img = $(this).siblings('.upload-display').find('img');
	            img[0].style.filter = "progid:DXImageTransform.Microsoft.AlphaImageLoader(enable='true',sizingMethod='scale',src=\""+imgSrc+"\")";        
	        }
	    });
	    
	    //암컷 수컷 하나만 선택가능
	    // check박스가 radio처럼 동작
	    $('input[type="checkbox"][name="genderCheck"]').click(function(){
	    	//click이 끝났을때
	    	if($(this).prop('checked')){
	    		//checkbox전체를 체크 해제후 click한 요소만 체크
	    		$('input[type="checkbox"][name="genderCheck"]').prop('checked',false);
	    		$(this).prop('checked',true);
	    	}
	    });
		  
	});

</script>
<!-- 제출 -->
<script>
	//Dog 삽입 제출
	function DogSubmit(){
		swal({
			icon:"warning",
			text: "강아지 등록을 하시겠습니까?",
			buttons:["아니요","유기견 등록"]
			
		}).then((Yes)=>{				
			if(Yes){
				if(dogCheck()){
					swal({				
						  icon: "success",
						  text: "유기견 등록이 완료되었습니다!"
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
				  text: "강아지 이름을 입력해주세요"
				}).then(function() {															
					  return false;								
			});
		      return false;
		   }
		
		   if(nullCheck($("#dogKind").val().trim())){
			   swal({								  
					  text: "견종을 입력해주세요"
					}).then(function() {															
						  return false;								
				});
			      return false;
			   }		
		   //성별 둘중에 하나라도 체크시 넘어감
		  if(!$('input[name="genderCheck"]').is(":checked")){
			  swal({								  
				  text: "성별을 체크해주세요"
				}).then(function() {															
					  return false;								
			});
		      return false;
		 			  }
		   if($(".upload-name").val()=='파일선택'){
			   swal({								  
					  text: "강아지 사진을 업로드해주세요"
					}).then(function() {															
						  return false;								
				});
			      return false;
		 	 };
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













