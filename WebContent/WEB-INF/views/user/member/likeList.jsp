<%@page import="user.member.dto.MemberAddDTO"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
 <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>   
 <%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
 
  
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<!-- Bootstrap 3.3.2 -->
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.2/css/bootstrap.min.css">
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.2/css/bootstrap-theme.min.css">
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.2/js/bootstrap.min.js"></script>

<script type="text/javascript" src="https://code.jquery.com/jquery-2.2.4.min.js"></script> 
<script>
$(document).ready(function() {
	// 선택체크 삭제
	$("#btnDelete").click(function() {
		// 선택된 체크박스
		var $checkboxes = $("input:checkbox[name='checkRow']:checked");
		
	
		// 체크된 대상들을 map으로 만들고 map을 문자열로 만들기
		var map = $checkboxes.map(function() {
			return $(this).val();
		});
		var names = map.get().join(",");
	
	
		
		// 전송 폼
		var $form = $("<form>")
			.attr("action", "/miss/delete")
			.attr("method", "post")
			.append(
				$("<input>")
					.attr("type", "hidden")
					.attr("name", "names")
					.attr("value", names)
			);
		$(document.body).append($form);
		$form.submit();
	
	});
});

//전체 체크/해제
function checkAll() {
	// checkbox들
	var $checkboxes=$("input:checkbox[name='checkRow']");

	// checkAll 체크상태 (true:전체선택, false:전체해제)
	var check_status = $("#checkAll").is(":checked");
	
	if( check_status ) {
		// 전체 체크박스를 checked로 바꾸기
		$checkboxes.each(function() {
			this.checked = true;	
		});
	} else {
		// 전체 체크박스를 checked 해제하기
		$checkboxes.each(function() {
			this.checked = false;	
		});
	}
}
</script>
<script type="text/javascript">


</script>
<body>
<div class="container">

<h1>찜목록</h1>
<hr>

<table class="table table-hover table-condensed table-striped">
<tr class="info">
	<th>
		<input type="checkbox" id="checkAll" onclick="checkAll();" />
	</th>
	<th >이미지</th>
	<th >견종</th>
	<th >성별</th>
	<th>엔드데이트</th>
	<th>입양신청 상태</th>
</tr>
<c:forEach items="${list}" var="list">
<input type="hidden" name="userid" value="${list.userid }">
<tr>
	<td><input type="checkbox" name="checkRow" value="${list.dogno }" /></td>
	<td><img style="width:30px; "id="img" src="/upload/${list.dog_stored_FILE_NAME }" alt="" /></td>
	<td>${list.dogKind}</td>
	<td>${list.dogGender}</td>
	<td>${list.dogEndDate}</td>
	
	<c:if test="${list.applysw eq 0}">
	<td>입양신청가능합니다</td>
	</c:if>
	<c:if test="${list.applysw eq 1}">
	<td>입양신청대기중 입니다</td>
	</c:if>
	<c:if test="${list.applysw eq 2}">
	<td>거절되었습니다</td>
	</c:if>
</tr>
</c:forEach>

</table>
	


<div >
	<button id="adoptCheck" class="btn btn-primary">입양신청</button>
</div>

<div>
	<button id="btnDelete" class="btn btn-warning pull-left">삭제</button>
</div>


<div id="paging">
	<c:import url="/commons/paging.jsp" />
</div>

</div><!-- .container -->


</body>
</html>