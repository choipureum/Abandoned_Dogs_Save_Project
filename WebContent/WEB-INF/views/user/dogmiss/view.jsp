<%@page import="user.dogmiss.dto.DogMissFile"%>
<%@page import="user.dogmiss.dto.DogMissAdd"%>
<%@page import="user.dogmiss.dto.DogMiss"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>


<% DogMiss view = (DogMiss)request.getAttribute("view");%>
<%DogMissFile file = (DogMissFile)request.getAttribute("missFile"); %>

<div>
	<c:import url="/WEB-INF/views/user/util/header.jsp" />
</div>

<!-- Bootstrap 3.3.2 -->
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.2/css/bootstrap.min.css">
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.2/css/bootstrap-theme.min.css">
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.2/js/bootstrap.min.js"></script>


<link href="https://fonts.googleapis.com/css2?family=Do+Hyeon&display=swap" rel="stylesheet">



<!-- jQuery 2.2.4 -->
<script type="text/javascript" src="http://code.jquery.com/jquery-2.2.4.min.js"></script>

<style>
.img{
	width:400px;
	height:400px;
}




.input-group{
	width:400px;
}



.wrapper{
margin: 0 auto;

}


.view{
	text-align:center;
	float:left;
	margin: 0 10px;
	
	
}


#area{
	
	width:411px;
	height:399px;
	position:relative;
}

.ra1{
	position:absolute;
	left:50px;
	top:40px;
	font-size:16px;
	
}
.ra2{
	position:absolute;
	left:50px;
	top:80px;
	font-size:16px;
}
.ra3{
	position:absolute;
	left:50px;
	top:120px;
	font-size:16px;
}
.ra4{
	position:absolute;
	left:50px;
	top:160px;
	font-size:16px;
}
.ra5{
	position:absolute;
	left:50px;
	top:200px;
	font-size:16px;
}
.ra6{
	position:absolute;
	left:50px;
	top:240px;
	font-size:16px;
}
.ra7{
	position:absolute;
	left:280px;
	top:40px;
	font-size:16px;
}

#img{
	height:350px;
}

td {
	margin-left:5px;
}

.tit{
	font-family: 'Do Hyeon', sans-serif;
	font-size:40px;
	color: yellow;
}
.text-right{
	padding:50px;
}
</style>




<script type="text/javascript">
$(document).ready(function() {
	//목록버튼 동작
	$("#btnList").click(function() {
		$(location).attr("href", "/miss/list");
	});
	
	//수정버튼 동작
	$("#btnUpdate").click(function() {
		$(location).attr("href", "/miss/update?missno=<%=view.getMissNO() %>");
	});
	//삭제버튼 동작
	$("#btnDelete").click(function() {
		$(location).attr("href", "/miss/delete?missno=<%=view.getMissNO() %>");
	});
	
	
	
	

	// 댓글 입력
	$("#btnCommInsert").click(function() {
	
		
		$form = $("<form>").attr({
			action: "/comment/insert",
			method: "post"
		}).append(
			$("<input>").attr({
				type:"hidden",
				name:"missNo",
				value:"${view.missNO }"
			})
		).append(
			$("<input>").attr({
				type:"hidden",
				name:"writer",
				value:"${view.missWriter }"
			})
		).append(
			$("<textarea>")
				.attr("name", "content")
				.css("display", "none")
				.text($("#content").val())
		);
		$(document.body).append($form);
		$form.submit();
		
	});
	
});

//댓글 삭제
function deleteComment(qna_rno) {
	$.ajax({
		type: "post"
		, url: "/comment/delete"
		, dataType: "json"
		, data: {
			qna_rno: qna_rno
		}
		, success: function(data){
			if(data.success) {
				
				$("[data-commentno='"+miss_rno+"']").remove();
				
			} else {
				alert("댓글 삭제 실패");
			}
		}
		, error: function() {
			console.log("error");
		}
	});
}
</script>






		

			<!-- Main -->
				<div id="main">
					<div class="inner">

					<div class="container">
					<div class="tit">이  분실견을 찾아 주세요</div>
					<div class="titt">지나가는 개 다시보자 지나친 개 다시보자 마주친 개 다시보자</div><br>
		
			<div class="wrapper">					
	<div class="view"><img  class="img" src ="/upload/<%=file.getMiss_stored_FILE_NAME()%>"/></div>
		<div class="view" id="area">					
		
		
		
		
		
		
		
		<span class="ra1">제목&nbsp;&nbsp;&nbsp;<%=view.getMissTitle()%></span><br> 
		<span class="ra2">이름&nbsp;&nbsp;&nbsp;<%=view.getMissName()%></span><br> 
		<span class="ra3">견종&nbsp;&nbsp;&nbsp;<%=view.getMissKind()%></span><br> 
		<span class="ra4">성별&nbsp;&nbsp;&nbsp;<%=view.getMissGender()%></span><br>
		<span class="ra5">분실날짜&nbsp;&nbsp;&nbsp;<%=view.getMissDate()%></span><br>
		<span class="ra6">분실장소&nbsp;&nbsp;&nbsp;<%=view.getMissLoc()%></span><br>
		<span class="ra7">조회수&nbsp;&nbsp;&nbsp;<%=view.getMissHit()%></span>
		
		
		
	</div>
</div>	

	<table style="width:100px;">
	<tr>
		
		<td><textarea  readonly cols="5" rows="10" style="width:820px;"><%=view.getMissContent()%></textarea></td>
	</tr>
	</table>
	



	<div class="text-right">	
		<button id="btnList" class="btn btn-info">목록</button>
		<button id="btnUpdate" class="btn btn-info">수정</button>
		<button id="btnDelete" class="btn btn-info">삭제</button>
	</div>
</div>

	</div>
</div>


<div>

<hr>




<!-- 댓글 입력 -->
<div class="form-inline text-center">
	<input type="text" size="10" class="form-control" id="writer" value="${view.missWriter }" readonly="readonly"/>
	<textarea rows="2" cols="60" class="form-control" id="content"></textarea>
	<button id="btnCommInsert" class="btn">입력</button>
</div>	<!-- 댓글 입력 end -->


<!-- 댓글 리스트 -->
<table class="table table-striped table-hover table-condensed">
<thead>
<tr>
	<th style="width: 5%;">번호</th>
	<th style="width: 10%;">작성자</th>
	<th style="width: 50%;">댓글</th>
	<th style="width: 20%;">작성일</th>
	<th style="width: 5%;"></th>
</tr>
</thead>
<tbody id="commentBody">
<c:forEach items="${commentList }" var="comment">
<tr data-commentno="${comment.miss_rno }">
	<td>${comment.miss_rno }</td>
	<td>${comment.miss_writer }</td><!-- 닉네임으로 해도 좋음 -->
	<td>${comment.miss_content }</td>
	<td><fmt:formatDate value="${comment.miss_date }" pattern="yy-MM-dd hh:mm:ss" /></td>
	<td>
		
		<button class="btn btn-default btn-xs" onclick="deleteComment(${comment.miss_rno });">삭제</button>
		
	</td>
	
</tr>
</c:forEach>
</tbody>
</table>	<!-- 댓글 리스트 end -->

</div>	<!-- 댓글 처리 end -->
				
				
				
			<!-- Footer -->
				
		
					

		<!-- Scripts -->
			<script src="/resources/UserBoardTemplate/assets/js/jquery.min.js"></script>
			<script src="/resources/UserBoardTemplate/assets/js/jquery.scrolly.min.js"></script>
			<script src="/resources/UserBoardTemplate/assets/js/jquery.poptrox.min.js"></script>
			<script src="/resources/UserBoardTemplate/assets/js/skel.min.js"></script>
			<script src="/resources/UserBoardTemplate/assets/js/util.js"></script>
			<script src="/resources/UserBoardTemplate/assets/js/main.js"></script>

<c:import url="/WEB-INF/views/user/util/footer.jsp" />