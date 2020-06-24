<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>


<nav aria-label="Page navigation example">
<ul class="pagination" style="float:right; float-right:20px;">
	
	<!-- 첫 페이지로 가기 -->
	<c:if test="${paging.curPage ne 1 }">
<%-- 	<c:if test="${paging.curPage gt paging.pageCount  }"> --%>
	<li class="page-item"><a href="/admin/dogClaim" class="page-link">첫장</a></li>
	</c:if>
	
	
	<!-- 이전 페이징 리스트로 가기 -->
	<c:if test="${paging.startPage gt paging.pageCount }">
	<li class="page-item"><a href="/admin/dogClaim?curPage=${paging.startPage - paging.pageCount }" class="page-link">이전</a></li>
	</c:if>
	
<%-- 	<c:if test="${paging.startPage le paging.pageCount }"> --%>
<!-- 	<li class="disabled"><a class="page-link"></a></li> -->
<%-- 	</c:if> --%>
	
	
	<!-- 이전 페이지로 가기 -->
	<c:if test="${paging.curPage ne 1 }">
	<li  class="page-item"><a href="/admin/dogClaim?curPage=${paging.curPage - 1 }" class="page-link">이전</a>
	</c:if>
	
	
	<c:forEach begin="${paging.startPage }" end="${paging.endPage }" var="i">
	
	<!-- 현재 페이지라면 강조(.active) -->
	<c:if test="${paging.curPage eq i }">
	<li  class="page-item"><a href="/admin/dogClaim?curPage=${i }" class="page-link">${i }</a></li>
	</c:if>
	
	<!-- 현재 페이지가 아니라면 평소 모습-->
	<c:if test="${paging.curPage ne i }">
	<li  class="page-item"><a href="/admin/dogClaim?curPage=${i }"class="page-link">${i }</a></li>
	</c:if>

	</c:forEach>


	<!-- 다음 페이지로 가기 -->
	<c:if test="${paging.curPage ne paging.totalPage}">
	<li  class="page-item"><a href="/admin/dogClaim?curPage=${paging.curPage + 1 }"class="page-link">다음</a>
	</c:if>
	

	<!-- 다음 페이징 리스트로 가기 --> 
	<c:if test="${paging.endPage ne paging.totalPage }">
	<li  class="page-item"><a href="/admin/dogClaim?curPage=${paging.startPage + paging.pageCount }" class="page-link">다음</a></li>
	</c:if>

<%-- 	<c:if test="${paging.endPage eq paging.totalPage }"> --%>
<!-- 		<li class="disabled"><a class="page-link">&rarr;</a></li> -->
<%-- 	</c:if> --%>


	<!-- 마지막 페이지로 가기 -->
	<c:if test="${paging.curPage ne paging.totalPage }">
	<li class="page-item"><a href="/admin/dogClaim?curPage=${paging.totalPage }" class="page-link">마지막</a></li>
	</c:if>
	
</ul>
</nav>