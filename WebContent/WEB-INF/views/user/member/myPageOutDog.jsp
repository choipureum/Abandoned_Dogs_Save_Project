<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>   


<c:import url="/WEB-INF/views/user/util/header.jsp"></c:import>
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

<div class="mypagedogout">

<br>
<h5>분양된 강아지의 목록을 확인 할 수 있습니당</h5>
<h2> B y e D o g </h2>
<br>
<hr>

	<!-- Table -->
	<div class="table-wrapper">
		<table style="1px solid">
			<thead>
				<tr>
					<th>사진</th>
					<th>이름</th>
					<th>견종</th>
					<th>성별</th>
					<th>입양날짜</th>               
				</tr>
			</thead>

		</table>	
	</div>
</div>








</body>


















<c:import url="/WEB-INF/views/user/util/footer.jsp"></c:import>


