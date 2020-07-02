<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%@ page import="admin.dto.Dogout"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>   

<!-- 헤더 입포트 -->
<c:import url="/main/header"></c:import>
<c:import url="/WEB-INF/views/user/util/sidebar.jsp"></c:import>

<!--Alert 디자인 라이브러리 -->
<script src="https://unpkg.com/sweetalert/dist/sweetalert.min.js"></script>


<script type="text/javascript">

</script>



<style type="text/css">
table, th {
   text-align: center;
}

tr td:nth-child(2) {
   text-align: left;
}

tr td:not(:first-child), tr th:not(:first-child) {
   border-left: 1px solid white;
}

</style>


<!-- css 만지는중 -->
<style type="text/css">
.mypagedogout{
   width:1100px;
   margin :40px auto;
   line-height: 16px;
}

h5,h2{
   text-align: center;
}

th{
   height: 30px;
}


#btnWrite{
/*    height: 60px; */
/*    width: 100px; */

   color:white;
   border: solid 1px gray;
   transition: all 0.5s;
   float :right;
}

#btnWrite:hover {
   background-color: white;
   color:black;
}

</style>

</head>




<body>

		<!-- Banner -->
			<section id="banner">			
				<div class="content">
					<h1> <span class="light">B y e D o g</span></h1>
					<p>분양된 강아지의 목록을 확인 할 수 있습니다</p>
					<ul class="actions">
<!-- 						<li><a href="#one" class="button scrolly">DaSom 알아보기</a></li> -->
					</ul>
				</div>
			</section>

<div class="mypagedogout">

<br>
<h2> B y e D o g </h2>
<br>
<hr>
	<!-- Table -->
	<div class="table-wrapper">
		<table style="white-space:nowrap;">
			<thead>
				<tr style="padding:0 0 0 20px;">
					<th style="text-align:center">사진</th>
					<th>이름</th>
					<th style="text-align:center">견종</th>
					<th style="text-align:center">성별</th>
					<th style="text-align:center">입양날짜</th>               
				</tr>
			</thead>
			<tbody>
			<c:forEach items="${dogout }" var="dogout">
				<tr>
					<td>
					<img  id="img" src="/upload/${ dogout.dog_stored_file_name }" alt="" style="width:100px;height:70px;border-radius:20px;"/></td>			                
			        <td>${dogout.dogname }</td>	
			        <td>${dogout.dogkind }</td>
			        <td>${dogout.doggender }</td>	
			        <td>${dogout.outdate }</td>
				</tr>		
		</c:forEach>
			</tbody>
		</table>	
	</div>
</div>

</body>
<c:import url="/WEB-INF/views/user/util/footer.jsp"></c:import>


