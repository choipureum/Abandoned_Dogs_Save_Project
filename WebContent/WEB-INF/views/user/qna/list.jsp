<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>

<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.2/css/bootstrap.min.css">
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.2/css/bootstrap-theme.min.css">
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.2/js/bootstrap.min.js"></script>

<script type="text/javascript" src="https://code.jquery.com/jquery-2.2.4.min.js"></script>




<div>
	<c:import url="/WEB-INF/views/user/util/header.jsp" />
</div>







<script type="text/javascript">
$(document).ready(function() {
   
   //글쓰기 버튼 누르면 이동
   $("#btnWrite").click(function() {
      location.href="/qna/write";
   });
   
   //검색 버틀 클릭하면 리스트 controller로 검색어를 파라미터로 전달 하게된다 
   $("#btnSearch").click(function() {
      location.href="/qna/list?search="+$("#search").val();
   });
   
});
</script>




<!-- css 만지는중 -->
<style type="text/css">
#search{
	display:inline-block;
	

}
#btnBox{
	padding:150px;
}

</style>



<div class="container">
<br>
<h5>문 의 게 시 판</h5>
<h2>QnA</h2>
<br>
<hr>
<!-- Table -->

<div class="table-wrapper">
   <table>
      <thead>
         <tr>
            <th>번호</th>
            <th>제목</th>
            <th>아이디</th>
            <th>작성일</th>
            <th>조회수</th> 
            <th>답변여부</th>               
         </tr>
      </thead>
   <tbody>
   <c:forEach items="${list }" var="board">
         <tr>
            <td>${board.qnaNO }</td>
            <td><a href="/qna/view?qnano=${board.qnaNO }">${board.qnaTitle }</a></td>
            <td>${board.qnaWriter }</td>
            <td><fmt:formatDate value="${board.qnaDate }" pattern="yyyy-MM-dd"/></td>  
            <td>${board.qnaHit }</td>
            
            <c:if test="${board.delsw eq Y}">
            <td>답변완료</td>
            </c:if>
            <c:if test="${board.delsw eq null}">
            <td>답변미완료</td>
            </c:if>
         </tr>
   </c:forEach>
   </tbody>
   </table>
</div>


<div id="btnBox">
	<input class="form-control" type="text" id="search" style="width:300px;"/>
   	<button id="btnSearch" class="btn">검색</button>
   	<button id="btnWrite" class="button">글쓰기</button>
</div>







<div id="paging_paging">
   <c:import url="/commons/paging.jsp" />
</div>




</div><!-- .container -->


<div id="foot">
	<c:import url="/WEB-INF/views/user/util/footer.jsp" />
</div>
