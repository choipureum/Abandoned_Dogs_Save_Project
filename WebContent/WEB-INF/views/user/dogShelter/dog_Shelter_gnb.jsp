<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
  

<style type="text/css">
.gnb{text-align:center;position:fixed; display:block; left: 0px; top: 0px; bottom:0px;  background-color:#2a2d30; width: 110px; z-index: 99999;}
.gnb_menu{margin: 5px 0px 5px 0px;}
.gnb a{width:60px;height:80px;font-size: 13px;text-decoration: none;color: gray;}
.gnb_icon{width:60px;padding: 5px 5px 0px 5px;}
.gnb .selected{background-color: #e8eced;margin: 10px 0px 0px 10px;}
</style>

<script type="text/javascript" src="https://code.jquery.com/jquery-2.2.4.min.js"></script>

<script type="text/javascript">
// $(document).ready(function() {
// 	 $("#id01").click(function(){
// 	        //alert("검색 버튼 클릭!");

// 		var sheltername = $("#sheltername").val();
// 		var shelteraddress = $("#shelteraddress").val();
// 		var sheltertel = $("#sheltertel").val();
		console.log(sheltername);
		
		function checkboxArr() {
			var checkArr = [];     // 배열 초기화
		    $("input[name='test_check']:checked").each(function(i)) {
		        checkArr.push($(this).val());     // 체크된 것만 값을 뽑아서 배열에 push

		    }

		$.ajax({
			type : 'POST',
			url : '/dogshelter/dog_ShlterDetail',
			dataType: "text",
			data:
// 			{"datatype":"intit"},
// 				params,
			{
// 			"sheltername" : sheltername
// 			, "shelteraddress" : shelteraddress
// 			, "sheltertel" : sheltertel},
 			valueArrTest: checkArr},
			
			 success : function() {
	            
			 },	    
		       error : function(xhr, status, error) {
		        console.log(error);
		    }
		});
}





</script>

<body>

<div id="gnb" class="gnb">
    <ul>
        <li class="gnb_menu" id="dog_shelter">
            <a class="" href="<c:url value='/'/>">
                <img src="" alt="" class="gnb_icon"  >
                보호소 정보
                
            </a>
        </li>
        <li class="gnb_menu" id="dog_list">
            <a class="" href="<c:url value='/routeInfoPage.do'/>">
                <img src="" alt="" class="gnb_icon"  >
                유기견 정보
            </a>
        </li>
    </ul>
</div>
 
<script type="text/javascript">
    $(document).ready(function(){
        $(".gnb_menu").on("click",function(e){
            $(".gnb_menu").removeClass("selected");
        })
    })
</script>



</body>
</html>