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
<style>
/*테이블 한행 호버효과*/
tr.member_row:hover {background: #FAFAD2;}
input[type="checkbox"]{width: 20px;height: 20px;cursor: pointer;}
</style>
	<!-- 헤더 임포트 -->
		<c:import url="/WEB-INF/views/admin/util/Header.jsp"></c:import>
        <!-- Begin Page Content -->
        <div class="container-fluid">

          <!-- Page Heading -->
          <p class="mb-4"><a href="/admin/dashboard" class="d-none d-sm-inline-block btn btn-sm text-gray-600">홈&nbsp;&nbsp;</a>
          	<a href="#"class="d-none d-sm-inline-block btn btn-sm text-gray-600">>&nbsp;&nbsp;</a>
          	<a href="/admin/memberlist"class="d-none d-sm-inline-block btn btn-sm text-gray-900">분실견 게시판</a>
          </p>

          <!-- DataTales Example -->
          <div class="card shadow mb-4">
            <div class="card-header py-3">
              <h6 class="m-0 font-weight-bold text-primary">분실견 게시판</h6>
            </div>
            <div class="card-body">
            
           <!-- 삭제 버튼 -->
          <a  class='btn btn-warning btn-icon-split' href="#" onclick='chk_delete();'><span class='icon text-white-50'><i class='fas fa-redo'></i></span>
          <span class='text'style='color:white'>선택 분실견 삭제</span></a><br><br>
          
          <!-- 테이블 -->
              <div class="table-responsive">
                <table class="table table-bordered" id="dataTable" width="100%" cellspacing="0">
               
                  <thead>                   
                    <tr>
                      <th>
                      <input id="member_chk_All" type="checkbox" class="dogMiss_chk_All" />
                      </th>                                  		  
              		  <th>사진</th>
             		  <th>번호</th>
                	  <th>성별</th>
                	  <th>분실장소</th>
               		  <th>작성자</th>
               		  <th>견종</th>  
                    </tr>
                  </thead>
               	  <tbody>               	  	           
      				  	  	           
      					<c:forEach items="${missList }" var="m">      					
			            <tr class="member_row" onclick="location.href='/admin/dashboard'">									           
			            	<td onclick='event.cancelBubble=true;'> 
			            		<div style="padding:0 0 0 9px">               	
			           			<input type="checkbox" id="member_chk" class="dogMiss_chk"  data-dogMiss="${m.missno }"  />           	                                                			
								</div></td> 
			                <td><img  id="img" src="/upload/${ m.miss_stored_FILE_NAME() }" alt="사진없음" /></td>			                
			               	<td>${m.missno }</td>	
			              	<td>${m.missgender }</td>	
			                <td>${m.missloc }</td>
			                <td>${m.misswriter }</td>
			                <td>${m.misskind }</td>			                          
			            </tr>   
			            </c:forEach>      
               	  </tbody>                	                	                           	  	  
                </table>
                      
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

<!--   <!-- Page level plugins -->
<!--   <script src="/resources/AdminTemplate/vendor/datatables/jquery.dataTables.min.js"></script> -->
<!--   <script src="/resources/AdminTemplate/vendor/datatables/dataTables.bootstrap4.min.js"></script> -->
	<script src="https://cdn.datatables.net/1.10.21/js/jquery.dataTables.min.js"></script>
	<script src="https://cdn.datatables.net/1.10.21/js/dataTables.jqueryui.min.js"></script>
 
 
         
 
</body>
<script type="text/javascript">
$(document).ready(function(){
	  //멤버 전체선택
	  $("#dogMiss_chk_All").click(function(){
		  $(".dogMiss_chk").prop("checked",this.checked);
	  });	  
	  //데이터 테이블 기능구현
	 $('#dataTable').DataTable(			
		{
		  "language": {
		        "emptyTable": "데이터가 존재하지 않습니다.",
		        "lengthMenu": "페이지당 _MENU_ 개씩 보기",
		        "info": "현재 _START_ - _END_ / _TOTAL_건",
		        "infoEmpty": "데이터 없음",
		        "infoFiltered": "( _MAX_건의 데이터에서 필터링됨 )",
		        "search": "검색: ",
		        "zeroRecords": "일치하는 데이터가 없어요.",
		        "loadingRecords": "로딩중...",
		        "processing":     "잠시만 기다려 주세요...",
		        "paginate": {
		            "next": "다음",
		            "previous": "이전"
		        }
		    }, "lengthChange" : true,
		    	"paging" : true,
		    	"info":true

	    });	  	
	    });<%--document.ready End --%>
	    

	   

	  //전체선택 
	  function chk_All(){	
		  $(".dogMiss_chk_All").click(function(){
			  $(".dogMiss_chk").prop("checked",this.checked);
		  });		  	
	  }
 
	  //선택 분실견 삭제(삭제)
	  function chk_delete(){			
				swal({
					icon:"warning",
					text: "분실견 목록을 삭제하시겠습니까?",
					buttons:["아니요","삭제"]
					
				}).then((Yes)=> {				
					if(Yes){
						var checkArr = new Array();
						 
						 $("input[class='dogMiss_chk']:checked").each(function(){
							 checkArr.push($(this).attr("data-dogMiss"));
						 });	 
						 
						 $.post("/admin/delete",{"dogMiss_chk":checkArr},function(res){
							 swal({				
								  icon: "success",
								  text: "게시글 삭제가 완료되었습니다!"
								}).then(function() {
									 location.href ="/admin/dogmiss";							
							});				
						 });												
				}			
			})
			
			 	  
	  };


</script>
</html>