<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page import="user.dog.dto.UserLike"%>
<%UserLike userList= (UserLike)request.getAttribute("userLike");  %>
<!-- 자바스크립트 -->
<script>
var element = $(".blink");
var shown = true;

setInterval(toggle, 200);

function toggle() {

   if(shown) {
       element.hide();
       shown = false;
   } else {
       element.show();
       shown = true;
   }
}

</script>

<c:forEach items="${dogList }" var="dog">
<div class="box" style="border-radius:20px;">                                                      
   <a href="/dog/detailView?dogno=${dog.dogno }"><img src="/upload/${dog.dog_stored_file_name }" alt="없음"  /></a>
   <div class="inner" style="text-align:left">
   <br>
   <ul style="padding:10px;">   
      <li style="color:#FFA07A;font-size:18px;font-weight:bold;line-height:5px;">${dog.dogname }&nbsp;&nbsp;&nbsp;&nbsp;
      <span class="heartDog"><i class="fa fa-heart-o" aria-hidden="true" data-dogno="${dog.dogno }" data-userid="${userlike.userid }"></i> </span></li>
      <hr>
      <li>성별 :  
	     <c:if test="${dog.doggender eq 'M' }" >수컷 </c:if>
	     <c:if test="${dog.doggender eq 'W' }">암컷</c:if>       
      </li>
      <li>견종 : ${dog.dogkind }</li>
      <li>중성화여부 : 
       <c:if test="${dog.dogneu eq 'Y'}" >Y </c:if>
	     <c:if test="${dog.dogneu eq 'N' }">N</c:if>       
       </li>
      <li>공고일 남은시일 :<span class="blink" style="color:#FF4500;font-weight:bold"> ${dog.dogenddate } 일!</span></li>
      	
    </ul>      
   </div>
</div>
</c:forEach>
<script>



</script>


















