<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>


<script type="text/javascript" src="https://code.jquery.com/jquery-2.2.4.min.js"></script>


<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.2/css/bootstrap.min.css">
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.2/css/bootstrap-theme.min.css">
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.2/js/bootstrap.min.js"></script>

<meta name="viewport" content="width=device-width, initial-scale=1" />
<link rel="stylesheet"
	href="/resources/UserBoardTemplate/assets/css/main.css" />


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
/* 검색, Q&A 등록 */
#btnBox{
   padding: 0 30% 0 30%;
   margin-bottom: 2%;
}

#search{
   display:inline-block;
   width: 50%;
}


.btn {
	width: 20%
}

#btnwrite {
	width: 20%;
}

/* Q&A 리스트  */
.table-wrapper{
	margin: 0 13% 0 13%;
	width: 74%;
}

a { 
text-decoration:none; 
} 
</style>


<c:import url="/main/header"></c:import>
<c:import url="/WEB-INF/views/user/util/sidebar.jsp"></c:import>

<!-- Banner -->
<section id="banner" data-video="images/banner">
	<div class="content">
		<h1>Solving your questions</h1>
		<p>Q&A</p>
		<ul class="actions">
			<li><a href="#one" class="button scrolly">게시판 조회</a></li>
		</ul>
	</div>
</section>

<section id="one" class="wrapper">
	<div class="inner" style="margin: 0 auto; text-align: center">
		<h2>Q&A 조회</h2>
	</div>
</section>

<div id="btnBox">
   <input class="form-control" type="text" id="search"/>
      <button id="btnSearch" class="btn">검색</button>
      <button id="btnWrite" class="btn">글쓰기</button>
</div>

<!-- Table -->

<div class="table-wrapper">
   <table>
      <thead>
         <tr >
            <th style="text-align:center;" >번호</th>
            <th style="text-align:center;">글제목</th>
            <th style="text-align:center;">아이디</th>
            <th style="text-align:center;">작성일</th>
            <th style="text-align:center;">조회수</th> 
            <th style="text-align:center;">답변여부</th>               
         </tr>
      </thead>
   <tbody>
   <c:forEach items="${list }" var="board">
         <tr style="text-align:center;">
            <td>${board.qnaNO }</td>
            <td><a href="/qna/view?qnano=${board.qnaNO }">${board.qnaTitle }</a></td>
            <td>${board.qnaWriter }</td>
            <td><fmt:formatDate value="${board.qnaDate }" pattern="yyyy-MM-dd"/></td>  
            <td>${board.qnaHit }</td>          
            <c:set value="${board.delsw}" var="sw"/>
            <c:if test="${sw eq 'Y'}">
            <td ><span style="color:red">답변완료</span></td>
            </c:if>           
            <c:if test="${sw eq 'N'}">
            <td><span style="color:green">답변미완료</span></td>
            </c:if>
         </tr>
   </c:forEach>
   </tbody>
   </table>
</div>







<div id="paging">
   <c:import url="/commons/paging.jsp" />
</div>





   <c:import url="/WEB-INF/views/user/util/footer.jsp" />