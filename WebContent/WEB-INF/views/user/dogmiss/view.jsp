<%@page import="user.dogmiss.dto.DogMissFile"%>
<%@page import="user.dogmiss.dto.DogMissAdd"%>
<%@page import="user.dogmiss.dto.DogMiss"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>


<% DogMiss view = (DogMiss)request.getAttribute("view");%>
<%DogMissFile file = (DogMissFile)request.getAttribute("missFile"); %>



<link
	href="https://fonts.googleapis.com/css2?family=Do+Hyeon&display=swap"
	rel="stylesheet">


<!-- jQuery 2.2.4 -->
<script type="text/javascript"
	src="http://code.jquery.com/jquery-2.2.4.min.js"></script>


<style>


.input-group {
	width: 400px;
}

.wrapper {
	
}

#area {
	width: 411px;
	height: 399px;
	position: relative;
}

.ra1 {
	position: absolute;
	left: 50px;
	top: 40px;
	font-size: 16px;
}

.ra2 {
	position: absolute;
	left: 50px;
	top: 80px;
	font-size: 16px;
}

.ra3 {
	position: absolute;
	left: 50px;
	top: 120px;
	font-size: 16px;
}

.ra4 {
	position: absolute;
	left: 50px;
	top: 160px;
	font-size: 16px;
}

.ra5 {
	position: absolute;
	left: 50px;
	top: 200px;
	font-size: 16px;
}

.ra6 {
	position: absolute;
	left: 50px;
	top: 240px;
	font-size: 16px;
}

.ra7 {
	position: absolute;
	left: 50px;
	top: 280px;
	font-size: 16px;
}

#img {
	height: 350px;
}

td {
	margin-left: 5px;
}

.tit {
	font-family: 'Do Hyeon', sans-serif;
	font-size: 40px;
	color: yellow;
}

/* 유기견 목록 */
#missView {
	padding: 0 15%;
}

.view {
	float: left;
	margin: 0 20px 0 0;
}

.table-condensed {
	width: 63%;
}

.img {
	width: 417px;
	height: 445px;
	border-radius: 4px;
	-moz-border-radius: 4px;
	-khtml-border-radius: 4px;
	-webkit-border-radius: 4px;
}

.center {
	font-size: 1.1em;
	text-align: center;
	width: 25%;
}

/* 댓글란 */
#insert {
	width: 70%;
	height: 20%;
	padding-left: 15%;
}
#writer {
	width: 130px;
	display: inline;
	height: 80%;
	text-align: center;
}
#content {
	width: 70%;
	display: inline;
	height: 80%;
}
#btnCommInsert{
	height: 80%;
	width: 15%;
	font-size: 16px;
}

#comm {
	width: 70%;
	margin: 5% 0 5% 15%;
}

/* 버튼란 */
#del {
	margin-left: 60%;
}
.text-right {
	padding: 0 15% 0 0;
	float: right;
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
function deleteComment(miss_rno) {
   $.ajax({
      type: "post"
      , url: "/comment/delete"
      , dataType: "json"
      , data: {
         miss_rno: miss_rno
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

<c:import url="/main/header"></c:import>
<c:import url="/WEB-INF/views/user/util/sidebar.jsp"></c:import>

<!-- Banner -->
<section id="banner" data-video="images/banner">
	<div class="content">
		<h1>Abandoned dog lost</h1>
		<p>분실견 신고</p>
		<ul class="actions">
			<li><a href="#one" class="button scrolly">분실견 목록</a></li>
		</ul>
	</div>
</section>

<section id="one" class="wrapper">
	<div class="inner" style="margin: 0 auto; text-align: center">
		<h2>분실견 목록</h2>
	</div>
</section>

<div id="missView">
	<div class="view">
		<img class="img" src="/upload/<%=file.getMiss_stored_FILE_NAME()%>" />
	</div>
	<table class="table-condensed">
		<tr>
			<th class="center">조회수</th>
			<td><%=view.getMissHit()%></td>
		</tr>

		<tr>
			<th class="center">제목</th>
			<td><%=view.getMissTitle()%></td>
		</tr>
		<tr>
			<th class="center">이름</th>
			<td><%=view.getMissName()%></td>

		</tr>
		<tr>
			<th class="center">견종</th>
			<td><%=view.getMissKind()%></td>
		</tr>
		<tr>
			<th class="center">성별</th>
			<td><%=view.getMissGender()%></td>
		</tr>
		<tr>
			<th class="center">분실날짜</th>
			<td><%=view.getMissDate()%></td>
		</tr>
		<tr>
			<th class="center">분실장소</th>
			<td><%=view.getMissLoc()%></td>
		</tr>
		<tr>
			<th class="center">상세내용</th>
			<td><%=view.getMissContent()%></td>
		</tr>
	</table>

</div>


<!-- 버튼  -->
<div class="text-right" id="del">
	<button id="btnList">목록</button>
	<button id="btnUpdate">수정</button>
	<button id="btnDelete">삭제</button>
</div>


<!-- 댓글 리스트 -->
<div id="comm">
	<table>
		<thead>
			<tr>
				<th style="width: 15%; text-align: center;">작성자</th>
				<th style="width: 60%;">댓글</th>
				<th style="width: 20%; text-align: center;">작성일</th>
				<th style="width: 5%;"></th>
			</tr>
		</thead>
		<tbody id="commentBody">
			<c:forEach items="${commentList }" var="comment">
				<tr data-commentno="${comment.miss_rno }">

					<td style="text-align: center;"><%=session.getAttribute("userid") %></td>
					<!-- 닉네임으로 해도 좋음 -->
					<td>${comment.miss_content }</td>
					<td style="text-align: center;"><fmt:formatDate
							value="${comment.miss_date }" pattern="yy-MM-dd HH:mm" /></td>
					<td>

						<button onclick="deleteComment(${comment.miss_rno });">삭제</button>

					</td>

				</tr>
			</c:forEach>
		</tbody>
	</table>
	<!-- 댓글 리스트 end -->
</div>


<!-- 댓글 입력 -->
<div class="form-inline text-center" id="insert">
	<input type="text" size="10" class="form-control" id="writer"
		value="<%=session.getAttribute("userid") %>" readonly="readonly" /> <input type="text"
		id="content">
	<button id="btnCommInsert" class="btn">댓글등록</button>
</div>
<!-- 댓글 입력 end -->

<!-- 댓글 처리 end -->





<c:import url="/WEB-INF/views/user/util/footer.jsp" />