<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!-- 자바스크립트 -->
<script type="text/javascript" src="https://code.jquery.com/jquery-2.2.4.min.js"></script>
<<<<<<< HEAD
<script type="text/javascript">
$(document).ready(function(){
   $("#heart").click(function(){
      if($("#heart").hasClass("liked")){
         $("#heart").html('<i class="fa fa-heart-o" aria-hidden="true"></i>');
         $("#heart").removeClass("liked");
      }else{
         $("#heart").html('<i class="fa fa-heart" aria-hidden="true"></i>');
         $("#heart").addClass("liked");
      }
   });
});
</script>
=======
>>>>>>> branch 'master' of https://github.com/choipureum/Abandoned_Dogs_Save_Project.git


<c:forEach items="${dogList }" var="dog">
<div class="box">																		
	<a href="/dog/detailView?dogno=${dog.dogno }"><img src="/upload/${dog.dog_stored_file_name }" alt="없음"  /></a>
	<div class="inner">
		<div>이름 ${dog.dogname }</div>
		<div>성별 ${dog.doggender }</div>
		<div>중성화여부 ${dog.dogneu }</div>
		<div>공고일 ${dog.dogdate }</div>
		${dog.dogno }
<<<<<<< HEAD
		<span id = heart><i class="fa fa-heart-o" aria-hidden="true" ></i> </span><!-- id 부분 dog no으로 가져오기  -->
=======
<!-- 하트버튼 -->
		<span class="heartDog"><i class="fa fa-heart-o" aria-hidden="true" data-dogno="${dog.dogno }"></i> </span><!-- id 부분 dog no으로 가져오기  -->
>>>>>>> branch 'master' of https://github.com/choipureum/Abandoned_Dogs_Save_Project.git
		
	</div>
</div>
</c:forEach>




















