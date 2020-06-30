<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<%@page import="user.dog.dto.DogDTO"%>
<%@page import="user.dog.dto.Dog_File_DTO"%>

<!-- 모델 값 가져오기 -->
<%DogDTO detailDog = (DogDTO) request.getAttribute("detailDog");  %>
<%Dog_File_DTO dogFile = (Dog_File_DTO) request.getAttribute("dogFile");  %>
      <meta name="viewport" content="width=device-width, initial-scale=1" />
      <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/pretty-checkbox@3.0/dist/pretty-checkbox.min.css" />
      
      <script src="http://code.jquery.com/jquery-2.2.4.min.js"></script>
<c:import url="/main/header"></c:import>     

<script>
var element = $(".blink");
var shown = true;
setInterval(toggle, 300);

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
<script>
function applyDog(){
	
   swal({
      icon:"warning",   
      text:"입양신청을 진행하시겠습니까?",
      buttons:["아니요","입양신청"]
   }).then((Yes)=>{
	   
      if(Yes){
         $("#applyForm").submit();   
      }
   });
}

</script>
   <div style="padding:30px; text-align:left; height:530px;">
   <img src="/upload/${dogFile.dog_stored_file_name }" style="width:400px; height:400px; margin:80px;border-radius:50px; border:3px solid #FF7F50"/>
      <div class="inner"  style="line-height:50px;display:inline-block;  position: absolute;  padding:50px 80px; ">      
               <h2 style="text-align:left;"><span style="color:#FF7F50"><i class="fas fa-dog"></i>${detailDog.dogname }</span>의 Profile</h2>
               <hr>
               <div style="font-weight: bold; font-size:20px">품종 : ${detailDog.dogkind }</div>
               <div style="font-weight: bold; font-size:20px">성별 : 
               <c:set var="g" value="${detailDog.doggender}"/>
                     <c:if test="${g eq 'W' }">암컷&nbsp;<i class="fas fa-venus" style="color:red"></i></c:if>
                     <c:if test="${g eq 'M' }">수컷&nbsp;<i class="fas fa-mars" style="color:blue"></i></c:if>
               </div>
               <div style="font-weight: bold; font-size:20px">중성화여부 :    
                  <c:if test="${detailDog.dogneu eq 'Y' }"><i class="fas fa-toggle-on fa-lg"></i></c:if>
                     <c:if test="${detailDog.dogneu eq 'N' }"><i class="fas fa-toggle-off fa-lg"></i></c:if>                           
               </div>
                  <div style="font-weight: bold; font-size:20px">유기견 등록일 : ${detailDog.dogdate }</div>
            <div style="font-weight: bold; font-size:20px">보호소명 :  
               <!-- 보호소 번호별 이름 값 출력 -->
               <c:set var="s" value="${detailDog.shelterno}"/>
               <c:choose>
                  <c:when test="${s eq 1 }">대전동물보호소</c:when>
                  <c:when test="${s eq 2 }">충주유기견보호소</c:when>
                  <c:when test="${s eq 3 }">울산유기동물보호센터</c:when>
                  <c:when test="${s eq 4 }">부산동물보호센터</c:when>
                  <c:when test="${s eq 5 }">동해시유기견보호소</c:when>
                  <c:when test="${s eq 6 }">광주동물보호소</c:when>
                  <c:when test="${s eq 7 }">시흥엔젤홍유기견보호소</c:when>
                  <c:when test="${s eq 8 }">아산시유기동물보호소</c:when>
                  <c:when test="${s eq 9 }">보령유기견보호소</c:when>
                  <c:otherwise>
                     용인시동물보호센터
                  </c:otherwise>                              
               </c:choose>
            </div>
            <br>
               <div style="color:red;font-size:22px;font-weight: bold" class="blink">${detailDog.dogenddate } 일 뒤 공고일 만료</div>
            
      </div>
      </div>
      <div style=" margin:0 50px 200px 0 ;text-align:right">
         <button style="font-size: 15px;" onclick="applyDog()">입양신청</button>
         <button style="font-size: 15px;"  onclick="self.close()">닫기</button>
      </div>
      <form action="/resources/js/applyChk.jsp" method="post" id="applyForm">
         <input type="hidden" name="dogno" value="${detailDog.dogno }"/>
         <input type="hidden" name="userid" value="<%=session.getAttribute("userid")%>"/>      
      </form>


<!-- <a href="javascript:self.close()">닫기</a> -->

 <c:import url="/WEB-INF/views/user/util/footer.jsp"></c:import> 





