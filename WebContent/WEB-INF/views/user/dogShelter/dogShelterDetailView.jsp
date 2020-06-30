
<%@page import="user.dog_shleter.dto.Dog_Shelter"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<script	src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
<!-- 자바스크립트 -->
<!-- <script type="text/javascript" src="https://code.jquery.com/jquery-2.2.4.min.js"></script> -->

<%
	Dog_Shelter l = (Dog_Shelter) request.getAttribute("result");
%>


<style type="text/css">
#dog {
	display: grid;
	grid-template-columns: 1fr 1fr 1fr;
	row-gap: 10px;
	column-gap: 100px;
	width: 1000px;
	margin: 0 auto;
	margin-top: 30px;
	/* 	top: 420px; */
	position: relative;
}

.w3-display-left {
font-size: 15px;
}
</style>
<script type="text/javascript">
$(document).ready(function() {
	var curPage = 1;
	$(window).scroll(function(){
		   
		   if($(window).scrollTop() == $(document).height() - $(window).height()){
		      if('${paging.totalPage }' >= page  ) {
//		       console.log(page);
		         $("body").append(loadlist())
		      }      
//		       loadlist();
		   }
		})


$(document).on("click", ".w3-container", function () {
			console.log($(this).children("a").attr("href"))

			$.ajax({
				type : "get",
				url : $(this).children("a").attr("href"),
				dataType : "html",
				data : {

					curPage : curPage++
				},
				success : function(h) {
					console.log("succ");
					console.log(h);
					 $("#dog").html(h)
						
				},
				error : function() {
					console.log("err")
				}
			})

			return false;
		})


	
})

	</script>
	
<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="stylesheet" href="https://www.w3schools.com/w3css/4/w3.css">
<link rel="stylesheet"
	href="https://fonts.googleapis.com/css?family=Raleway">
<link rel="stylesheet"
	href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">

<!-- 헤더 임포트 -->
<%-- <c:import url="/WEB-INF/views/user/util/header.jsp"></c:import> --%>

<div class="w3-display-left w3-padding w3-col l6 m8" style="width:481px; height: 600px">
	<div class="w3-container w3-red">
		<h2>
			<label><i class="fa fa-bed w3-margin-right"></i><label><%=l.getSheltername()%></label></label> 
		</h2>
	</div>
	<div class="w3-container w3-white w3-padding-16" style="height: 221px; width: 450px">
		<div class="w3-row-padding" style="margin: 0 -16px;">
			<div class="w3-half" style="width: 62%">
				<label><i class="fa fa-calendar-o"></i><%=l.getSheltername()%></label>
				<label><i class="fa fa-child"></i>유기견 보호소 전화번호</label>
				<label><%=l.getSheltertel()%></label>
				<label><i class="fa fa-male"></i> 유기견 보호소 주소</label>
				<label><%=l.getShelteraddress()%></label>
			</div>	
		</div>
<!-- 			<div class="w3-half"> -->
<!-- 			</div> -->
<!-- 		<div class="w3-row-padding" style="margin: 8px -16px; "> -->
<!-- 			<div class="w3-half w3-margin-bottom"  style="width: 110%;"> -->
<!-- 			</div> -->
<!-- 		</div> -->
		<a href="/dog/details?shelterno=<%=l.getShelterno()%>" style="position: relative; left: 250px; top: -40px; ">
			<button>유기견 조회</button>
		</a>
	</div>
</div>

	

<%-- <c:import url="/WEB-INF/views/user/util/footer.jsp"></c:import> --%>

