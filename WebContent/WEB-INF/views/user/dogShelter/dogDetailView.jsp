<%@page import="java.util.ArrayList"%>
<%@page import="user.dog.dto.Dog_Data"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>   
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<script	src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
<!-- 자바스크립트 -->
<!-- <script type="text/javascript" src="https://code.jquery.com/jquery-2.2.4.min.js"></script> -->

<%List<Dog_Data> dog = (List) request.getAttribute("result");%>
	
<style type="text/css">
.box {
	overflow: hidden;
}

.box img {
	width: 300px;
	height: 200px;
	 -webkit-transform:scale(1);
    -moz-transform:scale(1);
    -ms-transform:scale(1); 
    -o-transform:scale(1);  
    transform:scale(1);
    -webkit-transition:.3s;
    -moz-transition:.3s;
    -ms-transition:.3s;
    -o-transition:.3s;
    transition:.3s;
}

.box img:hover {
    -webkit-transform:scale(1.2);
    -moz-transform:scale(1.2);
    -ms-transform:scale(1.2);   
    -o-transform:scale(1.2);
    transform:scale(1.2);
}
</style>

<%-- 	<%for (int i = 0; i < dog.size(); i++) {%> --%>
<!-- 	<div class="box"> -->
<%-- 		<img src="/upload/<%=dog.get(i).getDog_stored_file_name() %> alt="없음" /> --%>
<!-- 		<div class="inner"> -->
<%-- 			<div>이름 <%=dog.get(i).getDogname() %></div> --%>
<%-- 			<div>품종 <%=dog.get(i).getDogkind() %></div> --%>
<%-- 			<div>성별 <%=dog.get(i).getDoggender() %></div> --%>
<%-- 			<div>중성화여부 <%=dog.get(i).getDogneu() %></div> --%>
<%-- 			<div>공고일 <%=dog.get(i).getDogdate() %></div> --%>
<!-- 			<div> -->
<!-- 			</div> -->
<!-- 		</div> -->
<!-- 	</div> -->
<%-- 	<% } %> --%>


<c:forEach items="${result }" var="dog">
	<div class="box">
		<img src="/upload/${dog.dog_stored_file_name }" alt="없음" />
		<div class="inner">
			<div>이름 ${dog.dogname }</div>
			<div>품종 ${dog.dogkind }</div>
			<div>성별 ${dog.doggender }</div>
			<div>중성화여부 ${dog.dogneu }</div>
			<div>공고일 ${dog.dogdate }</div>
			<div>
			</div>
		</div>
	</div>
</c:forEach>



