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
<c:import url="/WEB-INF/views/user/util/header.jsp"></c:import>  
      <script src="http://code.jquery.com/jquery-2.2.4.min.js"></script>
    

<script>
//입양신청 기능 구현
function apply(){
	
   var dogno="${param.dogno }";
   var userid="${param.userid}";
  
   if($("input[id='check']").is(":checked")){
	   swal({
		      icon:"warning",   
		      title:"입양신청을 하시겠습니까?",
		      text:"입양신청 답변은 수일 소요됩니다",   
		      buttons:["아니요","입양신청"]
		   }).then((Yes)=>{
		      if(Yes){
		         $.post("/dog/applyOK",{"dogno":dogno,"userid":userid},function(res){
		            swal({
		               icon:"success",   
		               text:"입양신청이 완료되었습니다!"
		            }).then(function(res){
		               location.href="/resources/js/applayThankyou.jsp";
		            })
		         });
		      }
		   }); 
   }else{
	   swal({
		      icon:"error",   
		      text:"입양신청 주의사항에 체크해주세요",   
		   }) 	   
   }  
}
</script>
<br><br>
<div style="text-align:center; ">
  <i class="fas fa-paw fa-3x"></i>
  <h1 style="padding:30px;color:#696969">입양 안내</h1>

  </div>
   <div style="padding:50px; text-align:center;margin:0 auto;">
      
      <div style="border: 5px solid #FFA07A;width:800px;text-align:center;margin:0 auto;">
      <img src="/resources/applyOrder.jpg" style="width:600px;height:1000px;">
      </div>   
   <br>
   <br>
   <br>
   <div style="text-align:left">
      <h3 style="color:#FF7F50">입양 전 진지하게 점검해야 할 체크리스트</h3>
      <ol>
         <li>반려동물을 맞이할 환경적 준비, 마음의 각오는 되어 있습니까?</li>
         <li>개, 고양이는 10~15년 이상 삽니다. 결혼, 임신, 유학, 이사 등으로 가정환경이 바뀌어도 한번 인연을 맺은 동물은 끝까지 책임지고 보살피겠다는 결심이 섰습니까?</li>
         <li>모든 가족과의 합의는 되어 있습니까?</li>
         <li>반려동물을 기른 경험이 있습니까? 내 동물을 위해 공부할 각오가 되어 있습니까?</li>
         <li>아플 때 적절한 치료를 해주고, 중성화수술(불임수술)을 실천할 생각입니까?</li>
         <li>입양으로 인한 경제적 부담을 짊어질 의사와 능력이 있습니까?</li>
         <li>우리 집에서 키우는 다른 동물과 잘 어울릴 수 있을지 고민해보았습니까?</li>
         <li>입양 시 일부 경비가 청구될 수 있습니다.</li>
         
         <li>시·군·구청에서 보호하고 있는 유기동물 중 공고한 지 10일이 지나도 주인이 나타나지 않는 경우 일반인에게 분양할 수 있습니다.</li>
         <li>입양 보호시설에 미리 전화로 문의하시고, 담당자의 안내에 따라 방문 일시 등을 예약합니다.</li>
         <li>입양 시 신분증 복사본 2장과 필요한 반려동물 물품을 준비하고 보호시설을 방문해 입양계약서를 작성해야 합니다.</li>
         <li>입양 보호시설에는 신청자 본인이 직접 방문해야 합니다.</li>
         <li>미성년자에게는 반려동물을 분양하지 않습니다. 분양을 원하는 미성년자는 부모님의 허락을 얻어 반드시 부모님과 함께 방문해야 합니다.</li>   
      </ol>
      <div style="font-size:20px;">
       <div class="pretty p-image p-plain">
        <input type="checkbox" id="check"/>
        <div class="state">
            <img class="image" src="https://image.shutterstock.com/image-vector/check-list-button-icon-vector-600w-1175614018.jpg">
            <label for="check">입양신청에 대한 주의사항을 숙지하였습니다</label>
        </div>
    </div>
    </div>   
   </div>
<br>
<br>


<button style="font-size: 15px;" onclick="history.go(-1)">뒤로가기</button>
<button style="font-size: 15px;" onclick="apply()">입양신청하기</button>
      </div>
      <form action="/WEB-INF/views/user/dog/applyChk.jsp" method="post" id="applyForm">
         <input type="hidden" name="dogno" value="${param.dogno }"/>
         <input type="hidden" name="userid" value="${param.userid }"/>      
      </form>



 <c:import url="/WEB-INF/views/user/util/footer.jsp"></c:import> 
