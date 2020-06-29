<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>   


<c:import url="/main/header"></c:import>
<c:import url="/WEB-INF/views/user/util/sidebar.jsp"></c:import>
		
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

	//공고일 슬라이더
	$('.dogslider').bxSlider({   		
		minSlides: 1,
		maxSlides: 6,
		slideWidth:300,
		slideMargin:30,
		speed:0.5,
		moveSlides:1,
		pager:false,	
		auto: true,	
		shrinkItems:true,
		controls:false
	});
	
});
</script>		
<style type="text/css">
div > img{
	width:100px;
	height:150px;
}



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
<style>
div>img{
	width:300px;
	height:300px;
	padding:20px;
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
<link rel="stylesheet" href="http://cdn.jsdelivr.net/npm/xeicon@2.3.3/xeicon.min.css">
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.1.1/jquery.min.js"></script>
  <script src="https://cdn.jsdelivr.net/bxslider/4.2.12/jquery.bxslider.min.js"></script>
  
		<!-- Banner -->
			<section id="banner">			
				<div class="content">
					<h1> <span class="light">For Dog, For Human</span></h1>
					<p>DaSom은 언제나 유기견들과 함께합니다 </p>
					<ul class="actions">
						<li><a href="#one" class="button scrolly">DaSom 알아보기</a></li>
					</ul>
				</div>
			</section>

		<!-- One -->
			<section id="one" class="wrapper">
			<div class="inner" style="margin:0 auto; text-align: center">
				<h2 >동물의 4대자유</h2>
			<br>
			</div>
				<div class="inner flex flex-3">
									
					<div class="flex-item left">
						<div style="text-align:center">
							<h3>Being hungry</h3>
							<p>모든 동물은 배고픔과 갈증, 영양불량으로부터의 자유로워야 한다</p>
						</div>
						<br>
						<div style="text-align:center">
							<h3>Apprehensions</h3>
							<p>모든 동물은 불안과 스트레스로부터 자유로워야 한다</p>
						</div>
						<br>
					</div>
					<div class="flex-item image fit round">
						<img src="https://images.unsplash.com/photo-1551887373-3c5bd224f6e2?ixlib=rb-1.2.1&ixid=eyJhcHBfaWQiOjEyMDd9&auto=format&fit=crop&w=1050&q=80 alt="" />
					</div>
					<div class="flex-item right">
						<div style="text-align:center">
							<h3>An acute pain</h3>
							<p>모든 동물은 통증 · 상해 · 질병으로부터 자유로워야 한다</p>
						</div>
						<br>
						<div style="text-align:center">
							<h3>Inconvenient</h3>
							<p>모든 동물은 불편함으로부터 자유로워야 한다</p>
						</div>
					</div>
				</div>
			</section>
			<!-- two -->
			<section id="two" class="wrapper style1 special">
				<div class="inner">
					<h2>유기견의 실태</h2>
					<figure>
					    <blockquote>
					      	모든 유기견은 등록과 동시에 동물보호관리시스템에 따라 <code style="color:blue">10일</code>이 경과되면 
					      	<code style="color:blue">안락사 </code>처분합니다.<br>
					      	애정과 관심으로 10일이내 죽어가는 생명을 구하기에 동참해주세요!					     
					    </blockquote>
					</figure>
				</div>
			</section>
		<!-- three -->
			<section id="three" class="wrapper style1 special">
				<div class="inner">
					<h2>DaSom을 통한 유기견 살리기</h2>
					<figure>
					    <blockquote>
					      개나 고양이를 키우고 싶다면 유기동물 보호시설에서 보호하고 있는 유기동물을 입양하는게 어떨까요?<br />
						원하는 동물을 새 식구로 맞이하는 것은 물론 한 생명을 구했다는 자부심으로 가슴이 뿌듯해집니다.<br />
					    </blockquote>
					    <footer>
					        <cite class="author">Choi Pureum</cite>
					        <cite class="company">CEO, DaSom</cite>
					    </footer>
					</figure>
				</div>
			</section>

		<!-- four -->
			<section id="four" class="wrapper">
				<div class="inner flex flex-3">
					<div class="flex-item box">
						<div class="image fit">
							<img src="https://images.unsplash.com/photo-1576061503110-92bf7d4bee05?ixlib=rb-1.2.1&ixid=eyJhcHBfaWQiOjEyMDd9&auto=format&fit=crop&w=334&q=80" alt="" />
						</div>
						<div class="content">
							<h3>입양 전 진지하게 점검할&nbsp;&nbsp;&nbsp;&nbsp; 체크리스트</h3>
							<p><ol>
								<li>반려동물을 맞이할 환경적 준비, 마음의 각오는 되어 있습니까?<br></li>
								<li>개, 고양이는 10~15년 이상 삽니다. 결혼, 임신, 유학, 이사 등으로 가정환경이 바뀌어도 한번 인연을 맺은 동물은 끝까지 책임지고 보살피겠다는 결심이 섰습니까?</li>
								<li>모든 가족과의 합의는 되어 있습니까?</li>
								<li>반려동물을 기른 경험이 있습니까? 내 동물을 위해 공부할 각오가 되어 있습니까?</li>
								<li>아플 때 적절한 치료를 해주고, 중성화수술(불임수술)을 실천할 생각입니까?</li>
								<li>입양으로 인한 경제적 부담을 짊어질 의사와 능력이 있습니까?</li>
								<li>우리 집에서 키우는 다른 동물과 잘 어울릴 수 있을지 고민해보았습니까?</li>
							</ol>
						</div>
					</div>
					<div class="flex-item box">
						<div class="image fit">
							<img src="https://images.unsplash.com/photo-1551730459-92db2a308d6a?ixlib=rb-1.2.1&ixid=eyJhcHBfaWQiOjEyMDd9&auto=format&fit=crop&w=334&q=80 " alt="" />
						</div>
						<div class="content">
							<h3>입양 시 일부 경비가 청구될 수 있습니다.</h3>							
								<ol>
									<li>시·군·구청에서 보호하고 있는 유기동물 중 공고한 지 10일이 지나도 주인이 나타나지 않는 경우 일반인에게 분양할 수 있습니다.</li>
									<li>입양 보호시설에 미리 전화로 문의하시고, 담당자의 안내에 따라 방문 일시 등을 예약합니다.</li>
									<li>입양 시 신분증 복사본 2장과 필요한 반려동물 물품을 준비하고 보호시설을 방문해 입양계약서를 작성해야 합니다.</li>
									<li>입양 보호시설에는 신청자 본인이 직접 방문해야 합니다.</li>
									<li>미성년자에게는 반려동물을 분양하지 않습니다. 분양을 원하는 미성년자는 부모님의 허락을 얻어 반드시 부모님과 함께 방문해야 합니다.</li>
								</ol>
						
						</div>
					</div>
					<div class="flex-item box">
						<div class="image fit">
							<img src="https://images.unsplash.com/photo-1571772805064-207c8435df79?ixlib=rb-1.2.1&ixid=eyJhcHBfaWQiOjEyMDd9&auto=format&fit=crop&w=677&q=80" alt="" />
						</div>
						<div class="content">
							<h3>유기견 습득시 안내</h3>
							<br>
							<ol>
								<li>공공장소를 떠돌거나 버려진 동물을 발견한 경우 관할 시ㆍ군ㆍ구청과 해당 유기동물 보호시설에 신고해야 합니다.</li>
								<li>유기동물을 주인 없는 동물이라 여겨 마음대로 잡아서 팔거나 죽이면 2년 이하의 징역 또는 2천만원 이하의 벌금을 내게 됩니다.</li>
								<li>시장ㆍ군수ㆍ구청장은 관내에서 발견된 유기동물이 보호받을 수 있도록 필요한 조치를 해야 하며, 주인을 찾을 수 있도록 그 사실을 7 일 이상 공고해야 합니다.</li>
								<li>공고 후 10일이 지나도 주인을 찾지 못한 경우, 해당 시ㆍ군ㆍ구등이 동물의 소유권을 갖게 되어 개인에게 기증하거나 분양할 수 있습니다.</li>							
							</ol>
						</div>
					</div>
				</div>
			</section>
			<!-- five -->
			<section id="five" class="wrapper style1 special" style="background:white">
			<h2 style="color:#F08080"><i class="fas fa-paw"></i>&nbsp;&nbsp;등록된 유기견을 입양해주세요!</h2>
			<br><br>
				<div class="dogslider">
				<c:forEach items="${dogDataList }" var="m"> 
					  <div>
					 	<h3> <a href="#" style="color:#696969">이름 : ${m.dogname }</a></h3>					 	  
			              <img  id="img" src="/upload/${ m.dog_stored_file_name }" alt="" />			               
			               <h4 style="color:#696969"><span style="color:#87CEEB;font-size:1.4em;">${m.dogenddate }</span> 일 뒤 안락사 예정입니다</h4>
			               </div>
				</c:forEach> 
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
		

