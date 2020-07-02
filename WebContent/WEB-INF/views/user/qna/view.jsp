<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>



<script type="text/javascript"
	src="https://code.jquery.com/jquery-2.2.4.min.js"></script>
<style>

/* 분실견 테이블 */
.table-condensed {
	margin: 0 15% 2em 18%;
	width: 65%;
	line-height: 50px;
}
.text-center {
	position: relative;
	display: inline-block;
	left: 66%;
	bottom: 15px;
}
.center{
	text-align: center;
}
/* 분실견 답변란 */
#addmin{
	padding: 0 18%;	

}
.addminReply{
	display: inline-block;
	width: 80%;
	margin-bottom: 30px;
	font-size: 20px;
}
.reply1{
	display: inline-block;
	margin-left: 5%;
	width: 20%;
}

.reply2{
	display: inline-block;
	width: 40%;
}
.reply3{
	display: inline-block;
	width: 30%;
}
</style>

<script type="text/javascript">
	$(document).ready(function() {
		//목록버튼 동작
		$("#btnList").click(function() {
			$(location).attr("href", "/qna/list");
		});

		//수정버튼 동작
		$("#btnUpdate").click(function() {
			$(location).attr("href", "/qna/update?qnano=${viewBoard.qnaNO }");
		});

		//삭제버튼 동작
		$("#btnDelete").click(function() {
			$(location).attr("href", "/qna/delete?qnano=${viewBoard.qnaNO }");
		});

	});
</script>

<c:import url="/main/header"></c:import>
<c:import url="/WEB-INF/views/user/util/sidebar.jsp"></c:import>


<!-- Banner -->
<section id="banner" data-video="images/banner">
	<div class="content">
		<h1>Solving your questions</h1>
		<p>Q&A</p>
		<ul class="actions">
			<li><a href="#one" class="button scrolly">게시판 목록</a></li>
		</ul>
	</div>
</section>

<section id="one" class="wrapper">
	<div class="inner" style="margin: 0 auto; text-align: center">
		<h2>Q&A 목록</h2>
	</div>
</section>

<table class="table-condensed">
	<tr>
		<th class="center">글번호</th>
		<td>${viewBoard.qnaNO }</td>
	</tr>

	<tr>
		<th class="center">제목</th>
		<td>${viewBoard.qnaTitle }</td>
	</tr>

	<tr>
		<th class="center">아이디</th>
		<td>${viewBoard.qnaWriter }</td>
	</tr>

	<tr>
		<th class="center">조회수</th>
		<td>${viewBoard.qnaHit }</td>

	</tr>
	<tr>
		<th class="center">작성일</th>
		<td>${viewBoard.qnaDate }</td>
	</tr>
	<tr>
		<th class="center" >본문</th>
		<td>${viewBoard.qnaContent }</td>
	</tr>
	<tr>	
		<th class="center">첨부파일</th>
		<td><a href="/file/download?fileno=${boardFile.qna_fileNo }">${boardFile.qna_org_FILE_NAME }</a></td>
	</tr>
	 	
</table>


<div id="addmin">
	<h3>관리자 답변란</h3>
<hr>
	<div class="addminReply">
		<div class="reply1">제목</div>
		<div class="reply2">본문</div>
		<div class="reply3">답변날짜</div>
	</div>
	
	<div class="addminReply">
	<div class="reply1">${reply.ref_title}</div>
	<div class="reply2">${reply.ref_content}</div>
	<div class="reply3">${reply.ref_date}</div>
	</div>
	
	
</div>


<div class="text-center">
	<button id="btnList" class="btn">목록</button>
	<button id="btnUpdate" class="btn">수정</button>
	<button id="btnDelete" class="btn">삭제</button>
</div>

<c:import url="/WEB-INF/views/user/util/footer.jsp" />