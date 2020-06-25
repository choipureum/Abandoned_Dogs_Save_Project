
<%@page import="user.dog_shleter.dto.Dog_Shelter"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%
	Dog_Shelter l = (Dog_Shelter) request.getAttribute("res");
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
	/* 	pos`ition: relative; */
}
</style>
<script type="text/javascript">
	var curPage = 1;
	$(document).ready(function() {

		loadlist();

		$("#showplus").click(function() {

			if (curPage > '${paging.totalPage }') {
				return false;
			}

			loadlist();
		})
	})

	$(document).ready(function() {

		$(document).on("click", ".w3-container", function() {
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

	$(document).ready(function() {
		$(document).on("click", ".w3-container", function() {

			$.ajax({
				type : "get",
				url : "/dog/detail",
				dataType : "html",
				success : function(h) {
					console.log("AJAX success")
					$("#search").html(h)
				},
				error : function() {
					console.log("AJAX error")
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

<div class="w3-display-left w3-padding w3-col l6 m8"
	style="width: 100%;">
	<div class="w3-container w3-red">
		<h2>
			<i class="fa fa-bed w3-margin-right"></i>보호소 정보
		</h2>
	</div>
	<div class="w3-container w3-white w3-padding-16" style="">
		<div class="w3-row-padding" style="margin: 0 -16px;">
			<div class="w3-half w3-margin-bottom">
				<label><i class="fa fa-calendar-o"></i>유기견 보호소 번호</label> <label><%=l.getShelterno()%></label>
			</div>
			<div class="w3-half">
				<label><i class="fa fa-calendar-o"></i>유기견 보호소 명</label> <label><%=l.getSheltername()%></label>
			</div>
		</div>
		<div class="w3-row-padding" style="margin: 8px -16px;">
			<div class="w3-half w3-margin-bottom">
				<label><i class="fa fa-male"></i> 유기견 보호소 주소</label> <label><%=l.getShelteraddress()%></label>
			</div>
			<div class="w3-half">
				<label><i class="fa fa-c	hild"></i>유기견 보호소 전화번호</label> <label><%=l.getSheltertel()%></label>
			</div>
		</div>

		<a href="/dog/detail?shelterno=<%=l.getShelterno()%>">
			<button>유기견 조회용</button>
		</a>
	</div>
</div>

<!-- Scripts -->
<script src="/resources/UserBoardTemplate/assets/js/jquery.min.js"></script>
<script
	src="/resources/UserBoardTemplate/assets/js/jquery.scrolly.min.js"></script>
<script
	src="/resources/UserBoardTemplate/assets/js/jquery.poptrox.min.js"></script>
<script src="/resources/UserBoardTemplate/assets/js/skel.min.js"></script>
<script src="/resources/UserBoardTemplate/assets/js/util.js"></script>
<script src="/resources/UserBoardTemplate/assets/js/main.js"></script>


