<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page import="user.dog.dto.UserLike"%>
 
<!-- 자바스크립트 -->
<script type="text/javascript" src="https://code.jquery.com/jquery-2.2.4.min.js"></script>


<c:forEach items="${dogList }" var="dog">
<div class="box">                                                      
   <a href="/dog/detailView?dogno=${dog.dogno }"><img src="/upload/${dog.dog_stored_file_name }" alt="없음"  /></a>
   <div class="inner">
      <div>이름 ${dog.dogname }</div>
      <div>성별 ${dog.doggender }</div>
      <div>중성화여부 ${dog.dogneu }</div>
      <div>공고일 ${dog.dogdate }</div>
      ${dog.dogno }
<!-- 하트버튼 -->
      <span class="heartDog"><i class="fa fa-heart-o" aria-hidden="true" data-dogno="${dog.dogno }" data-userid="${userlike.userid }"></i> </span><!-- id 부분 dog no으로 가져오기  -->
      
   </div>
</div>
</c:forEach>



















