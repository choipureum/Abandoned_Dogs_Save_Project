<%@page import="user.member.dto.MemberAddDTO"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
 <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>   
 <%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
  <% List<MemberAddDTO> list = (List)request.getAttribute("list"); %>

 <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.2/css/bootstrap.min.css">
 <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.2/css/bootstrap-theme.min.css">
 <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.2/js/bootstrap.min.js"></script>
 
 <script type="text/javascript" src="https://code.jquery.com/jquery-2.2.4.min.js"></script>

 <c:import url="/WEB-INF/views/user/util/header.jsp" />

<style>
#adoptBtn{
	margine-left:10px;
}
#rejectBtn{
	margine-left:10px;
}
.btn{
	
}

br{
	margin-left:10px;
}
body{
	
}
</style>


 





  




<script>
$(document).ready(function() {
	
	
	$("#rejectBtn").click(function(){				
		alert('입양신청은 한마리만 가능합니다');		
	});
	
	
	$("#adoptBtn").click(function(){
		
		if($("input:checkbox[name='checkRow']:checked").length>1 ){
			  
			  // 선택 모두 해제
			  //chk_All_Del();
			  
			  $("input:checkbox[name='checkRow']:checked").prop('checked', false) ;

			  alert('입양신청은 한마리만 선택가능합니다');					  
			  return;
		  };
		  
		  //없을때 불가
		  if($("input:checkbox[name='checkRow']:checked").length==0){
			  
			  
			  alert('입양신청은 한마리 선택하셔야 합니다');		
			  return;
		  };
		  	
		  if($("input:checkbox[name='checkRow']:checked").length==1){
		  
		  
		
		  	
			
			  
			var checkbox = $("input:checkbox[name='checkRow']:checked");
			
			var tr = checkbox.parent().parent()
			var td =  tr.eq(6)

			 
			
			var httpRequest = new XMLHttpRequest();
			httpRequest.onreadystatechange = function() {
				if (httpRequest.readyState == XMLHttpRequest.DONE && httpRequest.status == 200 ) {
						
					td.innerHTML = httpRequest.responseText;
						 
					
					
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


<div class="container">
<br>
<h5>찜 게 시 판</h5>
<h2>찜목록</h2>
<br>

<hr>
<div class="table-wrapper">
<table >
<thead>
<tr class="info">
	<th>
		<input type="checkbox" id="checkAll" onclick="checkAll();"/><label for="checkAll"></label>
	</th>
	<th >이미지</th>
	<th >견종</th>
	<th >성별</th>
	<th>엔드데이트</th>
	<th>입양신청 상태</th>
</tr>
</thead>
 <tbody>
 <c:forEach items="${list }" var="list" varStatus="status">
<tr>


	<td><input type="checkbox" name="checkRow" id="${status.index}"  value=""/><label for="${status.index}" ></label></td>
	<td><img style="width:30px; "id="img" src="/upload/${list.dog_stored_FILE_NAME}" alt="" /></td>

	<td><input type="checkbox" name="checkRow" value="${list.dogNo }" /></td>
	
	<td><img style="width:30px;"id="img" src="/upload/${list.dog_stored_FILE_NAME }" alt="" /> </td>

	<td>${list.dogKind}</td>
	<td>${list.dogGender}</td>
	<td>${list.dogEndDate}</td>
	
	<c:if test="${list.applysw eq 0}">
	<td></td>
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
<tbody>
</table>
</div>	
<div class="btn" style="padding: 80px;">
	<button id="btnDelete" >삭제</button>
	<c:choose> 
		<c:when test="${reject eq 1}" >
			<button id="rejectBtn" >입양신청</button>
		</c:when>
		<c:otherwise >
			<button id="adoptBtn" >입양신청</button>
		</c:otherwise>
	</c:choose>
</div>




<div id="paging">
	<c:import url="/commons/paging.jsp" />
</div>

</div><!-- .container -->


	<c:import url="/WEB-INF/views/user/util/footer.jsp" />



