<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
    
    

<%@page import="user.dog.dto.DogDTO"%>
<%@page import="user.dog.dto.Dog_File_DTO"%>

<!-- 모델 값 가져오기 -->
<%DogDTO detailDog = (DogDTO) request.getAttribute("detailDog");  %>
<%Dog_File_DTO dogFile = (Dog_File_DTO) request.getAttribute("dogFile");  %>
		<meta name="viewport" content="width=device-width, initial-scale=1" />
		<link rel="stylesheet" href="/resources/UserBoardTemplate/assets/css/main.css" />
		
<c:import url="/WEB-INF/views/user/util/header.jsp"></c:import>		
<div class="box" >
		<h3>입양신청</h3>
	<img src="/upload/${dogFile.dog_stored_file_name }" style="width:500px;"/>
		<div class="inner">
			<div>이름 &nbsp;${detailDog.dogname }</div>
               <div>성별 &nbsp;${detailDog.doggender }</div>
               <div>품종 &nbsp;${detailDog.dogkind }</div>
               <div>중성화여부 &nbsp;${detailDog.dogneu }</div>
               <div>공고일 &nbsp;${detailDog.dogdate }</div>
			<button onclick=>입양신청</button>
		</div>
</div>
<c:import url="/WEB-INF/views/user/util/footer.jsp"></c:import>






