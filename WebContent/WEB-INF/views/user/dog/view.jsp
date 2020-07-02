<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%--한글 인코딩 --%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page import="user.dog.dto.Dog_Data"%>
<%@page import="user.dog.dto.UserLike"%>
<%@page import="java.util.List"%>

<%List<Dog_Data> list = (List)request.getAttribute("dogList");  %>
     
<!-- 스타일 css -->
<style type="text/css">
#doglist {
   display: grid;
   grid-template-columns: 1fr 1fr 1fr 1fr;
    row-gap: 10px;
    column-gap: 30px;
   width:85em;

    margin: 0 auto;
    margin-top : 100px;
    
}
.inner{
background-color: white;
text-align: center;
margin-top : 20px;
}
.inner li{
font-size: 16px;
color : black;
list-style: none;
font-family: 'Arita-dotum-Medium'; 
}
.inner ul li{

}

body{
background: white;
height:1000px;
}


}

.box {
width:320px;
height: 440px;

}
.box a img {
   width: 100%;
   height: 350px;
   
   
}
.box a img:hover{
transform:scale(1.05);
transition:2s;
}

.box a{
border-bottom: none;
}

#banner{
padding:none;
}	
  .progress-container {
            left:0;
            width: 100%;
            height: 0.4em;
            margin-bottom: 0px;
            position: fixed;
            top: 104px;
            overflow: hidden;
            background-color: white;
            content: "";
            display: table;
            table-layout: fixed;
        }

            .progress-bar {
            width: 0%;
            float: left;
            height: 80%;
            z-index:9999999;
            max-width: 100%;
            background-color:#FFA07A;
            -webkit-transition: width .4s ease;
            -o-transition: width .4s ease;
            transition: width .4s ease;
        }
#dd{

	padding: 0 25% 0 25%;
	display: inline-block;
	width: 100%
}
#search2{
	display: inline-block;
	width: 14%;

}
#search{
	width: 60%;
	margin: 0;
	display: inline-block;
}
#btnSearch{
	width: 17%;
	height: 6%;

}
</style>

<c:import url="/main/header"></c:import>      
<c:import url="/WEB-INF/views/user/util/sidebar.jsp"/> 

         <div class="progress-container">
        <div class="progress-bar"></div>
    </div>
<!-- Banner -->
         <section id="banner">         
            <div class="content">
               <h1>Fine Family with Dog</h1>
               <p>유기견 입양 </p>
               <ul class="actions">
                  <li><a href="#dd" class="button scrolly">갱얼쥐 입양</a></li>
               </ul>
            </div>
         </section>
        
         
         
         
<div style="margin:80px;padding:30px;border-radius:20px; border:3px solid #778899">
<h3>동물의 사육·관리 방법 등(동물보호법 시행규칙 제3조 별표1)</h3>

<h4>일반기준</h4>
<ul>
	<li>동물의 소유자등은 동물을 사육ㆍ관리할 때에 동물의 생명과 그 안전을 보호하고 복지를 증진하여야 한다.</li>
	<li>동물의 소유자등은 동물로 하여금 갈증ㆍ배고픔, 영양불량, 불편함, 통증ㆍ부상ㆍ질병, 두려움과 정상적으로 행동할 수 없는 것으로 인하여 고통을 받지 아니하도록 노력하여야 한다.</li>
	<li> 동물의 소유자등은 사육ㆍ관리하는 동물의 습성을 이해함으로써 최대한 본래의 습성에 가깝게 사육ㆍ관리하고, 동물의 보호와 복지에 책임감을 가져야 한다.</li>
</ul>
<h4>개별기준</h4>
<ul>
	<li>사육환경
	<ul><li>동물의 종류, 크기, 특성, 건강상태, 사육 목적 등을 고려하여 최대한 적절한 사육환경을 제공하여야 한다.</li>
	<li>동물의 사육공간 및 사육시설은 동물이 자연스러운 자세로 일어나거나 눕거나 움직이는 등 일상적인 동작을 하는 데에 지장이 없는 크기이어야 한다.</li></ul></li>
	<li>건강관리
	<ul><li>전염병 예방을 위하여 정기적으로 동물의 특성에 따른 예방접종을 하여야 한다.</li>
	<li>개는 분기마다 1회 이상 구충을 하여야 한다.</li></ul></li></ul>
	<hr>
	<p style="color:red"><code>입양시 주의사항!! :</code>&nbsp;DaSom에서는 유기견의 재유기 방지를 위해 한번에 1번의 입양신청만 받고있습니다. 
	입양신청이 허가되거나 거절되면 다시 신청할 수 있습니다. 주의부탁드립니다!</p>
</div>
 <div id="dd">
            <select id="search2" name="search2">
                 <option value="0">선택안함</option>
                 <option value="1">견종</option>
                 <option value="2">성별</option>
                 <option value="3">중성화여부</option>
               </select>
            <input  class="form-control" type="text" id="search" name="search"/>
            <button id="btnSearch" class="btn">검색</button>
         </div>
<div id="doglist"></div>
<div id="showplus"></div>
<div id="row12"></div>
<c:import url="/WEB-INF/views/user/util/footer.jsp"></c:import>

<!-- 무한스크롤 -->
<script type="text/javascript">
var page = 1;

$(window).scroll(function(){
   
   if($(window).scrollTop() >= $(document).height() - $(window).height()){
      if('${paging.totalPage }' >= page  ) {
//       console.log(page);
         $("body").append(loadlist())
      }      
//       loadlist();
   }
   var wintop = $(window).scrollTop(), docheight = $('article').height(), winheight = $(window).height()*3;
   console.log(wintop);
   var totalScroll = (wintop/(docheight-winheight))*100;
   console.log("total scroll" + totalScroll);
   $(".progress-bar").css("width",-totalScroll-50+"%");
   });

function loadlist() {
   $.ajax({
      type:"post"
      , url: "/dog/list"
      , data: {
         curPage: page++
      }
      , dataType: "html"
      , success: function(h) {
         
         console.log("AJAX success")
         $("#doglist").html( $("#doglist").html() + h )
      }
      , error: function() {
         console.log("AJAX error")
      }
   })
}   

</script>
<script type="text/javascript">
$("#btnSearch").click(function() {
      
		//검색어를 결정하는 select value값
	    var search2=$("#search2").val();
      
		//집접 입력한 검색어
	  var search = $("#search").val();

      //---------------------------------------------
      

      $.ajax({
            type:"post"
            , url: "/dog/list"
            , data: {
               search: search
               , search2: search2
            }
            , dataType: "html"
            , success: function(h) {
               
               console.log("AJAX success")
               $("#doglist").html( h )
            }
            , error: function() {
               console.log("AJAX error")
            }
         })
   
   
   
   
});


   
</script>



