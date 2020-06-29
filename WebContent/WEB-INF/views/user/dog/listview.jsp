<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page import="user.dog.dto.UserLike"%>
<%UserLike userList= (UserLike)request.getAttribute("userLike");  %>
<!-- 자바스크립트 -->


<c:forEach items="${dogList }" var="dog">
<div class="box">                                                      
   <a href="/dog/detailView?dogno=${dog.dogno }"><img src="/upload/${dog.dog_stored_file_name }" alt="없음"  /></a>
   <div class="inner">
   <ul>
      <li>${dog.dogname }</li>
      <li>성별 ${dog.doggender }</li>
      <li>중성화여부 ${dog.dogneu }</li>
      <li>공고일 ${dog.dogdate }</li>		
     
	<!-- 하트버튼 -->
     <a class="heartDog" href="#">
     <i class="fa fa-heart-o" aria-hidden="true" data-dogno="${dog.dogno }" data-userid="${userlike.userid }"></i></a>                 
    </ul>
      <span class="heartDog"><i class="fa fa-heart-o" aria-hidden="true" data-dogno="${dog.dogno }" data-userid="${userlike.userid }"></i> </span>
      <!-- id 부분 dog no으로 가져오기  -->


   </div>
</div>

</c:forEach>
<script>



</script>


















