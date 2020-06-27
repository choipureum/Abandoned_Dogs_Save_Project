<%@page import="user.member.dto.MemberAddDTO"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
 <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>   
 <%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
 
 

<script>
$(document).ready(function() {
	
	
	$("#rejectBtn").click(function(){				
		alert('입양신청은 한마리만 가능합니다');		
	});
	
	
	$("#adoptBtn").click(function(){
		
		
		if($("input:checkbox[name='checkRow']:checked").length>1 ){
			  
			  // 선택 모두 해제
			  //chk_All_Del();
			  
			  alert('입양신청은 한마리만 선택가능합니다');		
			  
			  return;
		  };
		  
		  //없을때 불가
		  if($("input:checkbox[name='checkRow']:checked").length==0){
			  
			  
			  alert('입양신청은 한마리 선택하셔야 합니다');		
			  return;
		  };
		  	
		  if($("input:checkbox[name='checkRow']:checked").length==1){
			
			  
			var a = $("input:checkbox[name='checkRow']:checked").val();
			 
			console.log(a);
			var httpRequest = new XMLHttpRequest();
			httpRequest.onreadystatechange = function() {
				if (httpRequest.readyState == XMLHttpRequest.DONE && httpRequest.status == 200 ) {
					if($("#text").val() = a){		
					
						$("#text").innerHTML = httpRequest.responseText;
					
					}
				}
			};
				
				// GET 방식으로 요청을 보내면서 데이터를 동시에 전달함.
				httpRequest.open("GET", "/ajax/like_01.jsp",  true);
				httpRequest.send();
			
		  
		 };
		
		
	});
			     	
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
			.attr("action", "/like/delete")
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
	
		
		
	});<%--document end --%>
	

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

<c:import url="/WEB-INF/views/user/util/header.jsp"></c:import>

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
<tr>
	<td><input type="checkbox" name="checkRow" value="${list.dogNo }" /></td>
	
	<td><img style="width:30px;"id="img" src="/upload/${list.dog_stored_FILE_NAME }" alt="" /> </td>
	<td>${list.dogKind}</td>
	<td>${list.dogGender}</td>
	<td>${list.dogEndDate}</td>
	
	<c:if test="${list.applysw eq 0}">
	<td><span id="text" value="${list.dogNo }"></span></td>
	</c:if>
	<c:if test="${list.applysw eq 1}">
	<c:set value="1" var="reject"/>
	<td>입양신청대기중입니다</td>
	</c:if>
	<c:if test="${list.applysw eq 2}">
	<td>입양신청이 거절 되었습니다</td>
	</c:if>
	
</tr>
</c:forEach>
</table>
	
<div >
	<c:choose> 
		<c:when test="${reject eq 1}" >
			<button id="rejectBtn" class="btn btn-primary">입양신청</button>
		</c:when>
		<c:otherwise >
			<button id="adoptBtn" class="btn btn-primary">입양신청</button>
		</c:otherwise>
	</c:choose>
</div>
<div>
	<button id="btnDelete" class="btn btn-warning pull-left">삭제</button>
</div>

<button onclick="ApplySubmit()"></button>

<div id="paging">
	<c:import url="/commons/paging.jsp" />
</div>

</div><!-- .container -->
	<c:import url="/WEB-INF/views/user/util/footer.jsp"></c:import>