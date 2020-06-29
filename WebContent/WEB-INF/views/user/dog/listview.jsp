<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page import="user.dog.dto.UserLike"%>
<%UserLike userList= (UserLike)request.getAttribute("userLike");  %>

<!-- 자바스크립트 -->
<script>
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
$(document).ready(function(){
	//체크박스 클릭시 이벤트		
	 $("input[class='doglikeChk']").change(function(){
	        if($("input[class='doglikeChk']").is(":checked")){
        	
		        var dogno = $(this).attr("data-dogno");
		        var userid = $(this).attr("data-id");
		        		        
		        $.post("/dog/doglikeInsert",{"dogno":dogno,"userid":userid},function(res){
		        	 swal({				
			   			  icon: "success",
			   			  text: "강아지 관심목록에 추가되었습니다"
			   			});	   
		        })   	     	 	        	 
	        }else{
	        	 var dogno = $(this).attr("data-dogno");
			     var userid = $(this).attr("data-id");
	        	
			     $.post("/dog/doglikeDelete",{"dogno":dogno,"userid":userid},function(res){
			    	 swal({				
			   			  icon: "warning",
			   			  title: "주의",
			   			  text: "강아지 관심목록에서 제외됩니다!"			     
			     });	     
	   			});
	        }
	    });

});

</script>

<c:forEach items="${dogList }" var="dog">
   <a href="/dog/detailView?dogno=${dog.dogno }"><img src="/upload/${dog.dog_stored_file_name }" alt="없음"  /></a>
   <div class="inner" style="text-align:left">
   <br>
   <ul style="padding:10px;">   
      <li style="color:#FFA07A;font-size:18px;font-weight:bold;line-height:5px;">${dog.dogname }&nbsp;&nbsp;&nbsp;&nbsp;   
      
       <!-- 하트 표시 -->    
    <div class="pretty p-image p-plain">
        <input type="checkbox" data-dogno="${dog.dogno }" class="doglikeChk"data-id=" <%=session.getAttribute("userid")%>"/>
        <div class="state">
            <img class="image" src="https://upload.wikimedia.org/wikipedia/commons/thumb/c/c8/Love_Heart_symbol.svg/591px-Love_Heart_symbol.svg.png">
            <label>Like</label>
        </div>
    </div>

           
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

</c:forEach>
<script>



</script>


















