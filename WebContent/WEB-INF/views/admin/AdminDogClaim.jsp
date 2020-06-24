<%@page import="admin.dto.DogClaimDTO"%>
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
<%List<DogClaimDTO> d = (List) request.getAttribute("dogClaimList"); %>
<%Paging paging =(Paging)request.getAttribute("paging"); %>

<style>
#useridView:hover {background: #FAFAD2;}
input[type="checkbox"]{width: 20px;height: 20px;cursor: pointer;}
</style>

	<!-- 헤더 임포트 -->
		<c:import url="/WEB-INF/views/admin/util/Header.jsp"></c:import>

        <!-- Begin Page Content -->
        <div class="container-fluid">

         <!-- Page Heading -->
          <p class="mb-4"><a href="/admin/dashboard" class="d-none d-sm-inline-block btn btn-sm text-gray-600">홈&nbsp;&nbsp;</a>
          	<a href="#"class="d-none d-sm-inline-block btn btn-sm text-gray-600">>&nbsp;&nbsp;</a>
          	<a href="/admin/dogInsert"class="d-none d-sm-inline-block btn btn-sm text-gray-900">입양신청 확인</a>       	
          </p>
             <!-- 진행률 보드 -->
              <div class="card mb-4">
                <div class="card-header py-3">
                  <h6 class="m-0 font-weight-bold text-primary">입양 신청란</h6>
                </div>
                <div class="card-body">                
                  <div class="mb-1 small"><code>note : </code>입양신청률&nbsp;&nbsp;&nbsp;&nbsp;<code>10 / 30</code></div>
                  <div class="progress progress-sm mb-2">
                    <div class="progress-bar" role="progressbar" style="width: 50%" aria-valuenow="75" aria-valuemin="0" aria-valuemax="100"></div>
                  </div> 
                  <br><hr><br> 
                  <!--  입양신청처리 버튼 -->               
	                  <a  class='btn btn-info btn-icon-split' href="#" onclick='chk_confirm();'>
	                  <span class='icon text-white-50'><i class='fas fa-bone'></i></span>
	                  <span class='text'style='color:white'>입양신청 처리</span></a>
                  	<!-- -- -->
                  	<br><br>
                  <div class="table-responsive">
                  	 
                <table class="table table-bordered" id="dataTable" width="100%" cellspacing="0">               
                  <thead>                   
                    <tr>
                      <th>
                      <input id="dog_chk_All" type="checkbox" class="dog_chk_All" />
                      </th>                                  		  
              		  <th>유기견번호</th>
             		  <th>유기견명</th>
                	  <th>견종</th>
                	  <th>성별</th>
                	  <th>중성화 여부</th>
               		  <th>신청자</th>
               		  <th>신청일</th>
               		  <th>공고일 남은날짜</th>                             		  
                    </tr>
                  </thead>
               	  <tbody>    
               	  <% int cnt=0; %>           	  	           
      					<c:forEach items="${dogClaimList }" var="d">
      					 <% cnt++; %>
			            <tr class="dog_row" >										           
			            	<td onclick='event.cancelBubble=true;'> 
			            		<div style="padding:0 15px 0 0px">               	
			           			<input type="checkbox" id="dog_chk" class="dog_chk"  data-memberid=${d.userid } />           	                                                			
								</div></td> 
			                <td>${d.dogno }</td>			                
			                <td>${d.dogname }</td>
			                <td>${d.dogkind }</td>
			                <td>${d.doggender }</td>
			                <td>${ d.dogneu }</td>
			                <!-- 유저 아이디 보이기 팝업 -->
			                <td id="useridView" onclick="window.open('/admin/memberView?userid=${d.userid }','');">${d.userid }</td>
			                 <td>${ d.dogregdate }</td>      
			                 <!-- 공고일 남은날짜 -->
			                 <td></td>                    
			            </tr>   
			            </c:forEach>      
			          
               	  </tbody> 
               	  <tfoot>
					    <tr>				    
					        <th colspan="2" style="text-align:right;white-space:nowrap;">TOTAL : </th>
					        <th colspan="7" style="text-align:left;white-space:nowrap;"> <%=cnt %> &nbsp;마리</th>
					    </tr>
					</tfoot>
               	                           	  	  
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

	<script src="https://cdn.datatables.net/1.10.21/js/jquery.dataTables.min.js"></script>
	<script src="https://cdn.datatables.net/1.10.21/js/dataTables.jqueryui.min.js"></script>

</body>
<script>
$(document).ready(function(){
	  //멤버 전체선택
	  $("#dog_chk_All").click(function(){
		  $(".dog_chk").prop("checked",this.checked);
	  }) 
});	//document  ready 끝  

	//전체선택 
	  function chk_All(){	
		  $(".dog_chk_All").click(function(){
			  $(".dog_chk").prop("checked",this.checked);
		  });		  	
	  }
	//멤버 전체 선택 해제
	  function chk_All_Del(){
		  $(".dog_chk").prop("checked",false);
		  $(".dog_chk_All").prop("checked",false);
	  }
		 
</script>
<script>
//선택회원 삭제(삭제)
function chk_confirm(){			
		
		var checkArr = new Array();
					 
		 $("input[class='dog_chk']:checked").each(function(){
			 checkArr.push($(this).attr("data-memberid"));
			 });	 			
		window.open("/admin/claimUpdate?userid="+ checkArr.join(","),"","width=700,height=600,left=350,right=150");
			
		}	


</script>


</html>
