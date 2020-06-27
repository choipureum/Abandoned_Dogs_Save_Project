<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>


<!DOCTYPE html>
<html>


<head>
<meta charset="UTF-8">
<title>Qna</title>
<!-- Bootstrap 3.3.2 -->
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.2/css/bootstrap.min.css">
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.2/css/bootstrap-theme.min.css">
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.2/js/bootstrap.min.js"></script>
      <!-- Scripts -->
<script src="/resources/UserTemplate/assets/js/jquery.min.js"></script>
<script src="/resources/UserTemplate/assets/js/jquery.scrolly.min.js"></script>
<script src="/resources/UserTemplate/assets/js/skel.min.js"></script>
<script src="/resources/UserTemplate/assets/js/util.js"></script>
<script src="/resources/UserTemplate/assets/js/main.js"></script>

<link rel="stylesheet" href="/resources/UserTemplate/assets/css/main.css" />



<script type="text/javascript" src="https://code.jquery.com/jquery-2.2.4.min.js"></script>


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


<style type="text/css">
table, th {
   text-align: center;
}

tr td:nth-child(2) {
   text-align: left;
}

tr td:not(:first-child), tr th:not(:first-child) {
   border-left: 1px solid white;
}

</style>


<!-- css 만지는중 -->
<style type="text/css">
.container{
   width:1100px;
   margin :40px auto;
   line-height: 16px;
}

h5,h2{
   text-align: center;
}

th{
   height: 30px;
}


#btnWrite{
/*    height: 60px; */
/*    width: 100px; */

   color:white;
   border: solid 1px gray;
   transition: all 0.5s;
   float :right;
}

#btnWrite:hover {
   background-color: white;
   color:black;
}

</style>

</head>

<body>

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
         </tr>
      </thead>
   <tbody>
   <c:forEach items="${list }" var="board">
         <tr>
            <td>${board.qnaNO }</td>
            <td><a href="/qna/view?qnano=${board.qnaNO }">${board.qnaTitle }</a></td>
            <td>${board.qnaWriter }</td>
            <td>${board.qnaHit }</td>
            <td><fmt:formatDate value="${board.qnaDate }" pattern="yyyy-MM-dd"/></td>   
         </tr>
   </c:forEach>
   </tbody>
   </table>
</div>


<div id="btnBox">

<!--    <button id="btnWrite" class="btn btn-primary">글쓰기</button> -->
   <button id="btnWrite" class="button">글쓰기</button>
</div>

<div class="form-inline text-center">
   <input class="form-control" type="text" id="search" style="width:300px;"/>
   <button id="btnSearch" class="btn">검색</button>
   
</div>


<div id="paging_paging">
   <c:import url="/commons/paging.jsp" />

</div>




</div><!-- .container -->
</body>
</html>