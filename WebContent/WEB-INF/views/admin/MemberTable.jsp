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
<%List<MemberDTO>all =(List)request.getAttribute("memberAll"); %> 
<%Paging paging =(Paging)request.getAttribute("paging"); %>
<%List<MemberDTO> m = (List) request.getAttribute("memberlist"); %>
<% int membercnt= (int)request.getAttribute("membercnt"); %> 

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
          	<a href="/admin/memberlist"class="d-none d-sm-inline-block btn btn-sm text-gray-900">회원 관리</a>
          </p>

          <!-- DataTales Example -->
          <div class="card shadow mb-4">
            <div class="card-header py-3">
              <h6 class="m-0 font-weight-bold text-primary">Dasom :: 회원목록</h6>
            </div>
            <div class="card-body">
            <!-- 메일보내기 버튼 -->
           <a  class='btn btn-primary btn-icon-split' href="#" onclick='chk_sendmail()'><span class='icon text-white-50'>
           <i class='fas fa-envelope'></i></span><span class='text'style='color:white'>메일보내기</span></a>
           <!-- 삭제 버튼 -->
          <a  class='btn btn-warning btn-icon-split' href="#" onclick='chk_delete();'><span class='icon text-white-50'><i class='fas fa-user-minus'></i></span>
          <span class='text'style='color:white'>선택회원 삭제</span></a><br><br>
          
          <!-- 테이블 -->
              <div class="table-responsive">
                <table class="table table-bordered" id="dataTable" width="100%" cellspacing="0">
               
                  <thead>                   
                    <tr>
                      <th>
                      <input id="member_chk_All" type="checkbox" class="member_chk_All" />
                      </th>                                  		  
              		  <th>아이디</th>
             		  <th>회원이름</th>
                	  <th>휴대폰</th>
                	  <th>이메일</th>
               		  <th>가입일</th>
               		  <th>회원등급</th>  
                    </tr>
                  </thead>
               	  <tbody>               	  	           
      				<% int cnt=0; %>           	  	           
      					<c:forEach items="${memberlist }" var="m">
      					 <% cnt++; %>
			            <tr class="member_row" onclick="location.href='/admin/memberView?userid=${m.userid}'">									           
			            	<td onclick='event.cancelBubble=true;'> 
			            		<div style="padding:0 0 0 9px">               	
			           			<input type="checkbox" id="member_chk" class="member_chk"  data-memberid="${m.userid }" data-memberEmail="${m.useremail }" />           	                                                			
								</div></td> 
			                <td>${m.userid }</td>			                
			               	<td>${m.username }</td>	
			              	<td>${m.usertel }</td>	
			                <td>${m.useremail }</td>
			                <td>${m.userregdate }</td>
			                <td>${m.usergrade }</td>			                          
			            </tr>   
			            </c:forEach>      
               	  </tbody> 
               	  <tfoot>
					    <tr>				    
					        <th colspan="2" style="text-align:right;white-space:nowrap;">TOTAL : </th>
					        <th colspan="6" style="text-align:left;white-space:nowrap;"><%=cnt%> 명</th>					    
					      			        
					    </tr>
					</tfoot>
               	                           	  	  
                </table>
                <!-- 메일 보내기 폼 메소드(히든) --> 
				<form id="MailPostForm" action="/resources/js/AdminMailForm.jsp" method="post" target="MailForm">
					<input type="hidden" id="Email" name="Email"/>	
				</form>
          
              </div>
            </div>
           <!-- 페이지 위치 출력,-->
         	
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
	  $("#member_chk_All").click(function(){
		  $(".member_chk").prop("checked",this.checked);
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

	  	//상단 버튼 삽입
		//삭제버튼
	  	$('#dataTable_filter').
		prepend("<button class='member_delete' onclick='chk_delete();'style='border:0;outline:0'><a  class='btn btn-warning btn-icon-split'><span class='icon text-white-50'><i class='fas fa-user-minus'></i></span><span class='text'style='color:white'>선택회원 삭제</span></a></button>");
	  
	    });<%--document.ready End --%>
	    

	   

	  //전체선택 
	  function chk_All(){	
		  $(".member_chk_All").click(function(){
			  $(".member_chk").prop("checked",this.checked);
		  });		  	
	  }


	  
	  //체크메일보내기(삭제)
	  function chk_sendmail(){		 
		  swal({
				icon:"warning",
				text: "선택 회원에게 메일을 보내시겠습니까?",
				buttons:["아니요","메일보내기"]
				
			}).then((Yes)=> {		
		  //한명 선택 했다면 정상 코드시행
		 
				  //여러명일때 불가
				  if($("input[class='member_chk']:checked").length>1 ){
					  alert("다중선택 불가");
					  // 선택 모두 해제
					  chk_All_Del();
					  return;
				  };
				  //없을때 불가
				  if($("input[class='member_chk']:checked").length==0){
					  alert("회원을 선택해주세요!");
					  return;
				  }
				  var Email=  $("input[class='member_chk']:checked").attr("data-memberEmail");
				  Email=Email.trim();
				  //문자열 정돈
				  var f = document.getElementById("MailPostForm");
				  window.open("","MailForm","width=800,height=630,left=250,right=150");				  
				  f.Email.value= Email;	
				  f.target="MailForm";
				  f.submit();	   
		  });
	  };  
	  //선택회원 삭제(삭제)
	  function chk_delete(){			
				swal({
					icon:"warning",
					text: "회원을 삭제하시겠습니까?",
					buttons:["아니요","삭제"]
					
				}).then((Yes)=> {				
					if(Yes){
						var checkArr = new Array();
						 
						 $("input[class='member_chk']:checked").each(function(){
							 checkArr.push($(this).attr("data-memberid"));
						 });	 
						 
						 $.post("/admin/delete",{"member_chk":checkArr},function(res){
							 swal({				
								  icon: "success",
								  text: "회원 삭제가 완료되었습니다!"
								}).then(function() {
									 location.href ="/admin/memberlist";							
							});				
						 });												
				}			
			})
			
			 	  
	  };

	//멤버 전체 선택 해제
	  function chk_All_Del(){
		  $(".member_chk").prop("checked",false);
		  $(".member_chk_All").prop("checked",false);
	  }
</script>
</html>


















