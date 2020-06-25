<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<c:forEach items="${dogList }" var="dog">
<div class="box">																		
	<a href="/dog/detailView?dogno=${dog.dogno }"><img src="/upload/${dog.dog_stored_file_name }" alt="없음" /></a>
	<div class="inner">
		<div>이름 ${dog.dogname }</div>
		<div>성별 ${dog.doggender }</div>
		<div>중성화여부 ${dog.dogneu }</div>
		<div>공고일 ${dog.dogdate }</div>
		<div><button style="background: none; border: none; font-size: 20px;">♥</button></div>
	</div>
</div>
</c:forEach>


<style type="text/css">


</style>