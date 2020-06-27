<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>   


<c:import url="/WEB-INF/views/user/util/header.jsp"></c:import>

<script type="text/javascript">
$(document).ready(function(){
	$(".open").on('click',function(){
		$(".popup").show();
		$(".dim").show();
	});
	$(".popup .close").on('click',function(){
		$(this).parent().hide();
		$(".dim").hide();
	});
});
</script>		
<style type="text/css">

.Popup-container {
   width:385px;
   line-height:50px;
   margin: 40px auto;

}
/* 로그인입니다 css */
h3 {
   text-align: center;
}

h3 span{
   color:#ff9364;
}
/* 로그인버튼 */
.login {
   background-color: #6E6E6E;
   color:white;
   border-radius: 5px;
   border: 0;
   padding: 10px 172px;
   
}
/* 회원가입버튼 */
.singup {

   background-color:#6E6E6E;
   color:white;
   border-radius: 5px;
   border: 0;
   padding: 10px 165px;
   
}

/* 아이디 비밀번호 찾기 */
.found {
	position :relative;
	left:25px;
	margin: 0px 3px; 
	text-decoration: none;
	font-family: "돋움", dotum, "굴림", gulim, arial, helvetica, sans-serif;
	font-size: 13px;
}
.found:hover{
	text-decoration: underline;	
}


</style>

<style type="text/css">
/* 팝업처리 */
.popup { 
	display: none; 
	position: fixed; 
 	left: 50%;  
 	top: 50%;  
 	z-index: 100;  

	padding:50px 50px 50px;
	width: 550px; height: 530px; 
	transform: translate(-50%, -50%); 
	box-sizing: border-box; 
	background: #fff;
}
.popup h2 { 
	padding: 0 0 42px; 
	border-bottom: 3px solid #444; 
	font-weight: normal;
	font-size:36px; 
	color:#222; 
	text-align: center; 
	line-height: 100%;
}
.popup .close { 
	position: absolute; 
	right:40px; top: 40px; width: 41px; height: 41px; 
	background: url(/resources/mypageTemplate/img/btn-close.png) no-repeat; 
	color:transparent;
}
.popup .con { 
	padding: 20px 48px; 
	border-bottom:1px solid #e8e8e8;
}

.dim { 
	display: none;
	position: fixed; 
	left: 0; top: 0; 
	z-index: 99; 
	width: 100%; height: 100%; 
	background:rgba(0,0,0,0.5);
}
</style>

		<!-- Banner -->
			<section id="banner">
			
				<div class="content">
					<h1>For Dog, For Human</h1>
					<p>DaSom은 언제나 유기견들과 함께합니다 </p>
					<ul class="actions">
						<li><a href="#one" class="button scrolly">DaSom 알아보기</a></li>
					</ul>
				</div>
			</section>

		<!-- One -->
			<section id="one" class="wrapper">
				<div class="inner flex flex-3">
					<div class="flex-item left">
						<div>
							<h3>Magna ultricies</h3>
							<p>Morbi in sem quis dui plalorem ipsum<br /> euismod in, pharetra sed ultricies.</p>
						</div>
						<div>
							<h3>Ipsum adipiscing lorem</h3>
							<p>Tristique yonve cursus jam nulla quam<br /> loreipsu gravida adipiscing lorem</p>
						</div>
					</div>
					<div class="flex-item image fit round">
						<img src="images/pic01.jpg" alt="" />
					</div>
					<div class="flex-item right">
						<div>
							<h3>Tempus nullam</h3>
							<p>Sed adipiscing ornare risus. Morbi estes<br /> blandit sit et amet, sagittis magna.</p>
						</div>
						<div>
							<h3>Suscipit nibh dolore</h3>
							<p>Pellentesque egestas sem. Suspendisse<br /> modo ullamcorper feugiat lorem.</p>
						</div>
					</div>
				</div>
			</section>

		<!-- Two -->
			<section id="two" class="wrapper style1 special">
				<div class="inner">
					<h2>Feugiat lorem</h2>
					<figure>
					    <blockquote>
					        "Morbi in sem quis dui placerat ornare. Pellentesque odio nisi, euismod in, pharetra<br /> magna etiam lorem ultricies in diam. Sed arcu cras consequat."
					    </blockquote>
					    <footer>
					        <cite class="author">Jane Anderson</cite>
					        <cite class="company">CEO, Untitled</cite>
					    </footer>
					</figure>
				</div>
			</section>

		<!-- Three -->
			<section id="three" class="wrapper">
				<div class="inner flex flex-3">
					<div class="flex-item box">
						<div class="image fit">
							<img src="images/pic02.jpg" alt="" />
						</div>
						<div class="content">
							<h3>Consequat</h3>
							<p>Placerat ornare. Pellentesque od sed euismod in, pharetra ltricies edarcu cas consequat.</p>
						</div>
					</div>
					<div class="flex-item box">
						<div class="image fit">
							<img src="images/pic03.jpg" alt="" />
						</div>
						<div class="content">
							<h3>Adipiscing</h3>
							<p>Morbi in sem quis dui placerat Pellentesque odio nisi, euismod pharetra lorem ipsum.</p>
						</div>
					</div>
					<div class="flex-item box">
						<div class="image fit">
							<img src="images/pic04.jpg" alt="" />
						</div>
						<div class="content">
							<h3>Malesuada</h3>
							<p>Nam dui mi, tincidunt quis, accu an porttitor, facilisis luctus que metus vulputate sem magna.</p>
						</div>
					</div>
				</div>
			</section>
			<%-------------로그인 버튼 팝업 --%>
				<div class="popup">
				
				<div class="Popup-container">
				      <h3><span><i class="fas fa-bone text-gray-300"></i>&nbsp;&nbsp;로그인</span></h3>
				   <hr>
				   <form action="/login/login" method="post">				   
				      <!-- 로그인 틀 -->
				     
				      	<label for="userid"></label>
				      	<input type="text" class="inputForm" id="userid" name="userid" placeholder="ID" required style="height:50px; width: 380px" />
							
				      <label for="userpw"></label>
				      <input type="password"class="inputForm" id="userpw" name="userpw"  placeholder="PASSWORD" required style="height:50px; width: 380px" /><br>
				      
				      <!-- <button>로그인</button> -->
				       &nbsp;&nbsp;&nbsp;&nbsp;
				      <input type="submit" value="로그인" class="login"/>	
				   
				     &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; 	  			   
				  	 <input type="button" class="singup" value="회원가입" onclick="location.href='/resources/js/singupinfo.jsp'" />
						
					</form>
				
				<!-- 	아이디비밀번호 찾기 -->
					<a href="/id/find" class="found">아이디</a>
					<a href="/pw/find" class="found">비밀번호찾기</a>&nbsp;&nbsp;&nbsp;
					<a href="/admin" class="found">관리자 로그인</a>
				
				</div>
				<a href="#a" class="close">닫기</a>
				</div>

<div class="dim"></div>


		<c:import url="/WEB-INF/views/user/util/footer.jsp"></c:import>
		

