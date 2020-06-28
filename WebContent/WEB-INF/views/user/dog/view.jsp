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

   grid-template-columns: 1fr 1fr 1fr;
    row-gap: 10px;
    column-gap: 50px;
	width:80em;

    margin: 0 auto;
    margin-top : 100px;
    
}
.inner{
background-color: white;
}
.inner li{
font-size: 16px;
color : black;
list-style: none;


}
.inner ul{


}




body{
background: white;
}


}

.box {
width:320px;
height: 440px;

}
.box a img {
   width: 100%;
   height: 200px;
   
   
}
.box a img:hover{
transform:scale(1.1);
transition:2s;
}

.box a{
border-bottom: none;
}

#banner{
padding:none;
}

</style>

<!-- 담아두기css -->
<style type="text/css">
.fa-heart-o {
  color: red;
  cursor: pointer;
}

.fa-heart {
  color: red;
  cursor: pointer;
}

</style>         

<c:import url="/WEB-INF/views/user/util/header.jsp"></c:import>		


<!-- Banner -->
			<section id="banner">
			
				<div class="content">
					<h1>Fine Family with Dog</h1>
					<p>유기견 입양 </p>
				
				</div>
			</section>

<div id="doglist"></div>
<div id="showplus"></div>
<c:import url="/WEB-INF/views/user/util/footer.jsp"></c:import>

<!-- 무한스크롤 -->
<script type="text/javascript">

var page = 1;

$(window).scroll(function(){
   
   if($(window).scrollTop() == $(document).height() - $(window).height()){
      if('${paging.totalPage }' >= page  ) {
//       console.log(page);
         $("body").append(loadlist())
      }      
//       loadlist();
   }
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




