<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>

<script type="text/javascript"
	src="https://code.jquery.com/jquery-2.2.4.min.js"></script>

<!-- 스마트 에디터 라이브러리 추가 -->
<script type="text/javascript"
	src="/resources/se2/js/service/HuskyEZCreator.js" charset="utf-8"></script>

<script type="text/javascript">
	$(document).ready(function() {

		//작성버튼 동작
		$("#btnUpdate").click(function() {

			//스마트에디터의 내용으로 <textarea>에 적용시키기
			submitContents($("#btnUpdate"));

			//form submit 수행
			$("form").submit();
		});

		//취소버튼 동작
		$("#btnCancel").click(function() {
			history.go(-1);
		});
	});
</script>

<style type="text/css">
#da {
	margin: 0 15% 2em 18%;
	width: 65%;
	line-height: 50px;
}

.text-center {
	position: relative;
	display: inline-block;
	left: 70%;
	bottom: 20px;
}

.btn {
	padding: 0 60px;
	height: 60px;
}
.center{
	text-align: center;
}

</style>


<c:import url="/WEB-INF/views/user/util/header.jsp" />
<c:import url="/WEB-INF/views/user/util/sidebar.jsp"></c:import>
<!-- Banner -->
<section id="banner" data-video="images/banner">
	<div class="content">
		<h1>Solving your questions</h1>
		<p>Q&A</p>
		<ul class="actions">
			<li><a href="#one" class="button scrolly">게시판 수정</a></li>
		</ul>
	</div>
</section>

<section id="one" class="wrapper">
	<div class="inner" style="margin: 0 auto; text-align: center">
		<h2>Q&A 수정</h2>
	</div>
</section>

<div id="da">
	<form action="/qna/update" method="post" enctype="multipart/form-data">
		<input type="hidden" name="qnano" value="${viewBoard.qnaNO }" />

		<table class="table-condensed">
			<tr>
				<th class="center">아이디</th>
				<td>${viewBoard.qnaWriter }</td>
			</tr>
			<tr>
				<th class="center">제목</th>
				<td><input type="text" name="title" style="width: 100%"
					value="${viewBoard.qnaTitle }" /></td>
			</tr>
			<tr>
				<th id="title" class="center">본문</th>
			</tr>
			<tr>
				<td colspan="2"><textarea id="content" name="content" rows="10"
						cols="100">${viewBoard.qnaContent }</textarea></td>
			</tr>
		</table>

		<label class="label">기존 첨부파일 : ${boardFile.qna_org_FILE_NAME}<br>첨부파일
			: <input type="file" name="file" /></label>

	</form>
</div>

<div class="text-center">
	<button type="button" id="btnUpdate" class="btn">수정 적용</button>
	<button type="button" id="btnCancel" class="btn">취소</button>
</div>



<!-- 스마트 에디터를 생성하는 코드 -->
<!-- 스마트 에디터의 스킨을 입히는 코드 -->
<script type="text/javascript">
	var oEditors = [];
	nhn.husky.EZCreator.createInIFrame({
		oAppRef : oEditors,
		elPlaceHolder : "content", //<textarea>의 id 를 입력
		sSkinURI : "/resources/se2/SmartEditor2Skin.html",
		fCreator : "createSEditor2",
		htParams : {
			bUseToolbar : true, //툴바 사용여부
			bUseVerticalResizer : false, //입력창 크기 조절 바
			bUseModeChanger : true
		//글쓰기 모드 탭
		}
	});

	//<form>의 submit이 수행되면 스마트에디터의 내용이 <textarea>에 적용됨
	function submitContents(elClickedObj) {
		// 에디터의 내용이 textarea에 적용된다.
		oEditors.getById["content"].exec("UPDATE_CONTENTS_FIELD", []);

		try {
			elClickedObj.form.submit();
		} catch (e) {
		}
	}
</script>


<c:import url="/WEB-INF/views/user/util/footer.jsp" />




