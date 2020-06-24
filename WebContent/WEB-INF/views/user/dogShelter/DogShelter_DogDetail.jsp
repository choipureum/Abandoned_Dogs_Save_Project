<%@page import="user.dog.dto.Dog_Data"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%List<Dog_Data> list = (List)request.getAttribute("detail");  %>


<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

<style type="text/css">
#detail {
	display: grid;

	grid-template-columns: 1fr 1fr 1fr;
    row-gap: 10px;
    column-gap: 100px;

    width: 1000px;
    margin: 0 auto;
    margin-top : 20px;
}
.box {
}
.box a img {
	width: 200px;
	height: 200px;
}

.box a{
border-bottom: none;
}

</style>
<body>

				<div id="detail">
					<c:forEach items="${detail }" var="dog">
                     <div class="box">																		
                        <img src="/upload/${dog.dogno }" alt="없음" />
                        <div class="inner">
                          <div>이름 ${dog.dogname }</div>
                           <div>성별 ${dog.doggender }</div>
                           <div>중성화여부 ${dog.dogneu }</div>
                           <div>공고일 ${dog.dogdate }</div>
                        </div>
                       </c:forEach>
                     </div>
				
					<!-- Scripts -->
			<script src="/resources/UserBoardTemplate/assets/js/jquery.min.js"></script>
			<script src="/resources/UserBoardTemplate/assets/js/jquery.scrolly.min.js"></script>
			<script src="/resources/UserBoardTemplate/assets/js/jquery.poptrox.min.js"></script>
			<script src="/resources/UserBoardTemplate/assets/js/skel.min.js"></script>
			<script src="/resources/UserBoardTemplate/assets/js/util.js"></script>
			<script src="/resources/UserBoardTemplate/assets/js/main.js"></script>
</body>
</html>