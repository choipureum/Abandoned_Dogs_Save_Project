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

<!DOCTYPE html>
<html>

<head>

  <meta charset="utf-8">

  <title>다솜 :: 관리자 페이지</title>

  <!-- Custom fonts for this template-->
  <link href="/resources/AdminTemplate/vendor/fontawesome-free/css/all.min.css" rel="stylesheet" type="text/css">
  <link href="https://fonts.googleapis.com/css?family=Nunito:200,200i,300,300i,400,400i,600,600i,700,700i,800,800i,900,900i" rel="stylesheet">

  <!-- Custom styles for this template-->
  <link href="/resources/AdminTemplate/css/sb-admin-2.min.css" rel="stylesheet">
  <!-- httpRequest.js 임포트 --> 
 <script type="text/javascript" src="/resources/js/httpRequest.js"></script> 
  <!-- google charts import -->
   <script type="text/javascript" src="https://www.gstatic.com/charts/loader.js"></script>
   <!-- jQuery -->
   <script type="text/javascript"  src="https://code.jquery.com/jquery-2.2.4.min.js"></script>
</head>

<body id="page-top">

  <!-- Page Wrapper -->
  <div id="wrapper">

    <!-- Sidebar -->
    <ul class="navbar-nav bg-gradient-primary sidebar sidebar-dark accordion" id="accordionSidebar">

      <!-- Sidebar - Brand -->
      <a class="sidebar-brand d-flex align-items-center justify-content-center" href="/admin/dashboard">
        <div class="sidebar-brand-icon ">
          <i class="fas fa-dog"></i>
        </div>
        <div class="sidebar-brand-text mx-3">다솜 Admin <sup></sup></div>
      </a>

      <!-- Divider -->
      <hr class="sidebar-divider my-0">

      <!-- Nav Item - Dashboard -->
      <li class="nav-item active">
        <a class="nav-link" href="/admin/dashboard">
          <i class="fas fa-fw fa-tachometer-alt"></i>
          <span>메인 대시보드</span></a>
      </li>

      <!-- Divider -->
      <hr class="sidebar-divider">

      <!-- Heading -->
      <div class="sidebar-heading">
       Management
      </div>

      <!-- Nav Item - Pages Collapse Menu -->
      <li class="nav-item">
        <a class="nav-link collapsed" href="#" data-toggle="collapse" data-target="#collapseTwo" aria-expanded="true" aria-controls="collapseTwo">
          <i class="fas fa-users"></i>
          <span>Member</span>
        </a>
        <div id="collapseTwo" class="collapse" aria-labelledby="headingTwo" data-parent="#accordionSidebar">
          <div class="bg-white py-2 collapse-inner rounded">
            <h6 class="collapse-header">회원</h6>
            <a class="collapse-item" href="cards.html">회원 관리</a>
          </div>
        </div>
      </li>

      <!-- Nav Item - Utilities Collapse Menu -->
      <li class="nav-item">
        <a class="nav-link collapsed" href="#" data-toggle="collapse" data-target="#collapseUtilities" aria-expanded="true" aria-controls="collapseUtilities">
          <i class="fas fa-table"></i>
          <span>Table</span>
        </a>
        <div id="collapseUtilities" class="collapse" aria-labelledby="headingUtilities" data-parent="#accordionSidebar">
          <div class="bg-white py-2 collapse-inner rounded">
            <h6 class="collapse-header">게시판 관리</h6>
            <a class="collapse-item" href="utilities-color.html">QNA게시판관리</a>
            <a class="collapse-item" href="utilities-border.html">분실견 게시판 관리</a>
            <a class="collapse-item" href="utilities-animation.html">유기견 게시판 관리</a>
            <a class="collapse-item" href="utilities-animation.html">입양신청 확인</a>
          </div>
        </div>
      </li>

      <!-- Divider -->
      <hr class="sidebar-divider">

      <!-- Heading -->
      <div class="sidebar-heading">
        Abondoned Dog
      </div>

      <!-- Nav Item - Pages Collapse Menu -->
      <li class="nav-item">
        <a class="nav-link collapsed" href="#" data-toggle="collapse" data-target="#collapsePages" aria-expanded="true" aria-controls="collapsePages">
          <i class="fas fa-fw fa-folder"></i>
          <span>Dog Management</span>
        </a>
        <div id="collapsePages" class="collapse" aria-labelledby="headingPages" data-parent="#accordionSidebar">
          <div class="bg-white py-2 collapse-inner rounded">
            <h6 class="collapse-header">유기견관리</h6>
            <a class="collapse-item" href="login.html">유기견 등록</a>
            <div class="collapse-divider"></div>
            <h6 class="collapse-header">아직 보류</h6>

          </div>
        </div>
      </li>
       
      <!-- Divider -->
      <hr class="sidebar-divider d-none d-md-block">

      <!-- Sidebar Toggler (Sidebar) -->
      <div class="text-center d-none d-md-inline">
        <button class="rounded-circle border-0" id="sidebarToggle"></button>
      </div>

    </ul>
    <!-- End of Sidebar -->

    <!-- Content Wrapper -->
    <div id="content-wrapper" class="d-flex flex-column">

      <!-- Main Content -->
      <div id="content">

        <!-- Topbar -->
       <c:import url="/WEB-INF/views/admin/util/Toolbar.jsp"></c:import>
        <!-- End of Topbar -->

        <!-- Begin Page Content -->
        <div class="container-fluid">

          <!-- Page Heading -->
          <h1 class="h3 mb-2 text-gray-800">회원 관리</h1>
          <p class="mb-4">기모기모 기모링</p>

          <!-- DataTales Example -->
          <div class="card shadow mb-4">
            <div class="card-header py-3">
              <h6 class="m-0 font-weight-bold text-primary">Dasom :: 회원목록</h6>
            </div>
            <div class="card-body">
              <div class="table-responsive">
                <table class="table table-bordered" id="dataTable" width="100%" cellspacing="0">
                  <thead>
                    <tr>
                      <th><input type="checkbox" class="member_chk_All" /></th>
                      <th>번호</th>
              		  <th>아이디</th>
             		  <th>회원이름</th>
                	  <th>휴대폰</th>
                	  <th>이메일</th>
               		  <th>가입일</th>
               		  <th>회원등급</th>  
                    </tr>
                  </thead>
                  <tfoot>
                    <tr>
                      <th><input type="checkbox" class="member_chk_All" /></th>
                      <th>번호</th>
              		  <th>아이디</th>
             		  <th>회원이름</th>
                	  <th>휴대폰</th>
                	  <th>이메일</th>
               		  <th>가입일</th>
               		  <th>회원등급</th> 
                    </tr>
                  </tfoot>
                  <tbody>
                     <!-- 번호 카운트 -->
		            <% int cnt= 0;  
		             for(int i=0;i<m.size();i++){
		             		cnt+=1; 
		             		// 커스텀 속성에 유저 아이디 담아보기
		             		String userid= m.get(i).getUserid();
		             		String userEmail=m.get(i).getUseremail();
		             		%>
            <tr>
            	<td><input type="checkbox" class="member_chk" data-memberid=<%=userid %> data-memberEmail=<%=userEmail %> /></td>            	                                 
                <td><%=cnt %></td>
                <td><%=m.get(i).getUserid() %></td>
                <td><%=m.get(i).getUsername() %></td>
                <td><%=m.get(i).getUsertel() %></td>
                <td><%=m.get(i).getUseremail() %></td>
                <td><%=m.get(i).getUserregdate() %></td>
                <td><%=m.get(i).getUsergrade() %></td>               
            </tr>         
            <% } %>
                  </tbody>
                  
                </table>
              </div>
            </div>
           <!-- 페이지 위치 출력, 페이징처리 여긴데...-->
         
          </div>

        </div>
        <!-- /.container-fluid -->

      </div>
      <!-- End of Main Content -->

      <!-- Footer -->
      <c:import url="/WEB-INF/views/admin/util/Footer.jsp"></c:import>
      <!-- End of Footer -->
	
    </div>
    <!-- End of Content Wrapper -->

  </div>
  <!-- End of Page Wrapper -->

  <!-- Scroll to Top Button-->
  <a class="scroll-to-top rounded" href="#page-top">
    <i class="fas fa-angle-up"></i>
  </a>

  <!-- Logout Modal-->
  <c:import url="/WEB-INF/views/admin/util/Logout_Model.jsp"></c:import>
   
  <!-- Bootstrap core JavaScript-->
  <script src="/resources/AdminTemplate/vendor/jquery/jquery.min.js"></script>
  <script src="/resources/AdminTemplate/vendor/bootstrap/js/bootstrap.bundle.min.js"></script>

  <!-- Core plugin JavaScript-->
  <script src="/resources/AdminTemplate/vendor/jquery-easing/jquery.easing.min.js"></script>

  <!-- Custom scripts for all pages-->
  <script src="/resources/AdminTemplate/js/sb-admin-2.min.js"></script>

  <!-- Page level plugins -->
  <script src="/resources/AdminTemplate/vendor/datatables/jquery.dataTables.min.js"></script>
  <script src="/resources/AdminTemplate/vendor/datatables/dataTables.bootstrap4.min.js"></script>

  <!-- Page level custom scripts -->
  <script src="/resources/AdminTemplate/js/demo/datatables-demo.js"></script>
 
</body>
<script type="text/javascript">
$(document).ready(function(){
	  //멤버 전체선택
	  $(".member_chk_All").click(function(){
		  $(".member_chk").prop("checked",this.checked);
	  });		 
	});
	 
	  //선택해제
	    function chk_All_Del(){	  
		  $(".member_chk").prop("checked",false);
		  $(".member_chk_All").prop("checked",false);
	  }
	  //전체선택 
	  function chk_All(){		
		  	$(".member_chk").prop("checked",true);
		  	$(".member_chk_All").prop("checked",true);
	  	
	  }
	  //멤버선택하면 전체 선택 해제
	   $(".member_chk").click(function(){
		   $(".member_chk_All").prop("checked",false);
	  });

	  
	  //체크메일보내기(삭제)
	  function chk_sendmail(){
		  var agree=confirm("선택 회원에게 메일을 보내시겠습니까?");
		  //여러명일때 불가
		  if($("input[class='member_chk']:checked").size()>1 && agree){
			  alert("다중선택 불가");
			  // 선택 모두 해제
			  chk_All_Del();
			  return;
		  };
		  //없을때 불가
		  if($("input[class='member_chk']:checked").size()==0 && agree){
			  alert("회원을 선택해주세요!");
			  return;
		  }
		  //한명 선택 했다면 정상 코드시행
		  if(agree){		 
			  var Email=  $("input[class='member_chk']:checked").attr("data-memberEmail");
			  //문자열 정돈
			  Email=Email.substring(0, Email.length).trim();
			  var f = document.getElementById("MailPostForm");
			  window.open("","MailForm","width=800,height=630,left=250,right=150");				  
			  f.Email.value= Email;	
			  f.target="MailForm";
			  f.submit();	   
		  };
	  };  
	  //선택회원 삭제(삭제)
	  function chk_delete(){
		  var agree=confirm("선택 회원들을 삭제하시겠습니까?");
		  //선택사항 삭제-확인 클릭시 
		  if(agree){
			 var checkArr = new Array();
			 
			 $("input[class='member_chk']:checked").each(function(){
				 checkArr.push($(this).attr("data-memberid"));
			 });	 
			 
			 $.post("/admin/delete",{"member_chk":checkArr},function(res){
				 location.href ="/admin/memberlist";
			 });	  
	  }
	  };



</script>
</html>
