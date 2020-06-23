<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>마이페이지 메인</title>

<!-- 부트스트랩 임포트 -->
<!-- Bootstrap Core CSS -->
<link href="/resources/mypageTemplate/vendor/bootstrap/css/bootstrap.min.css" rel="stylesheet">
<!-- Custom Fonts -->
<link href="/resources/mypageTemplate/vendor/fontawesome-free/css/all.min.css" rel="stylesheet" type="text/css">
<link href="https://fonts.googleapis.com/css?family=Source+Sans+Pro:300,400,700,300italic,400italic,700italic" rel="stylesheet" type="text/css">
<link href="/resources/mypageTemplate/vendor/simple-line-icons/css/simple-line-icons.css" rel="stylesheet">
<!-- Custom CSS -->
<link href="/resources/mypageTemplate/css/stylish-portfolio.min.css" rel="stylesheet">

</head>
<body>

<!-- Portfolio -->
<section class="content-section" id="portfolio">
	<div class="container">
    <div class="content-section-heading text-center">
        <h3 class="text-secondary mb-0">Mypage</h3>
        <h2 class="mb-5">MyPage</h2>
    </div>
    <div class="row no-gutters">
      <div class="col-lg-6">
        <a class="portfolio-item" href="#!">
          <div class="caption" onclick="Move(1);">
            <div class="caption-content">
              <div class="h2">개인정보 수정</div>
              <p class="mb-0">개인정보를 수정 할 수 있습니다!</p>
            </div>
          </div>
         <img class="img-fluid" src="/resources/mypageTemplate/img/portfolio-1.jpg" alt="">
        </a>
      </div>
      <div class="col-lg-6">
        <a class="portfolio-item" href="#!">
          <div class="caption">
            <div class="caption-content">
              <div class="h2">리뷰관리</div>
              <p class="mb-0">작성한 리뷰를 관리 할 수 있습니다!</p>
             </div>
           </div>
           <img class="img-fluid" src="/resources/mypageTemplate/img/portfolio-2.jpg" alt="">
        </a>
      </div>
      <div class="col-lg-6">
        <a class="portfolio-item" href="#!">
          <div class="caption">
            <div class="caption-content">
              <div class="h2">찜목록</div>
              <p class="mb-0">자신이 찜 한 유기견을 확인 할 수 있습니다!</p>
            </div>
          </div>
          <img class="img-fluid" src="/resources/mypageTemplate/img/dog2.JPG" style="width:600px; height:371px;" alt="">
        </a>
      </div>
      <div class="col-lg-6">
        <a class="portfolio-item" href="#!">
          <div class="caption">
            <div class="caption-content">
              <div class="h2">분양 받은 강아지</div>
              <p class="mb-0">분양 받은 강아지를 확인 할 수 있습니다!</p>
            </div>
          </div>
          <img class="img-fluid" src="/resources/mypageTemplate/img/dog.JPG" style="width:600px; height:371px;" alt="">
        </a>
      </div>
    </div>
  </div>
</section>


<!-- Scroll to Top Button-->
<a class="scroll-to-top rounded js-scroll-trigger" href="#page-top">
	<i class="fas fa-angle-up"></i>
</a>

<!-- Bootstrap core JavaScript -->
<script src="/resources/mypageTemplate/vendor/jquery/jquery.min.js"></script>
<script src="/resources/mypageTemplate/vendor/bootstrap/js/bootstrap.bundle.min.js"></script>

<!-- Plugin JavaScript -->
<script src="/resources/mypageTemplate/vendor/jquery-easing/jquery.easing.min.js"></script>

<!-- Custom scripts for this template -->
<script src="/resources/mypageTemplate/js/stylish-portfolio.min.js"></script>
</body>
<script type="text/javascript">
function Move(sw){
	
	
		location.href="/mypage/modify";
		
		
	
	
}

</script>

</html>






