
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>



<style type="text/css">
#floatMenu {
	position: absolute;
    width: 10%;
    height: 200px;
    right: 20px;
    top: 600px;
    color: #fff;
    z-index: 9999999;
}

/* 테이블 logo 영역 */
.floatCenter {
	padding: 0px 35px;
	list-style-type: none;
}
.scroll-to-top {
  position: fixed;
  right: 15px;
  bottom: 15px;
  display: none;
  width: 50px;
  height: 50px;
  text-align: center;
  color: white;
  background: rgba(52, 58, 64, 0.5);
  line-height: 45px;
}

.scroll-to-top:focus, .scroll-to-top:hover {
  color: white;
}

.scroll-to-top:hover {
  background: #343a40;
}

.scroll-to-top i {
  font-weight: 800;
}
</style>

<script type="text/javascript"
src="https://code.jquery.com/jquery-2.2.4.min.js"></script>
<script>
  window.kakaoAsyncInit = function() {
    Kakao.Channel.createChatButton({
      container: '#kakao-talk-channel-chat-button',
    });
  };

  (function(d, s, id) {
    var js, fjs = d.getElementsByTagName(s)[0];
    if (d.getElementById(id)) return;
    js = d.createElement(s); js.id = id;
    js.src = '//developers.kakao.com/sdk/js/kakao.plusfriend.min.js';
    fjs.parentNode.insertBefore(js, fjs);
  })(document, 'script', 'kakao-js-sdk');
</script>

<script type="text/javascript">
$(document).ready(function() {

	// 기존 css에서 플로팅 배너 위치(top)값을 가져와 저장한다.
	var floatPosition = parseInt($("#floatMenu").css('top'));
	// 250px 이런식으로 가져오므로 여기서 숫자만 가져온다. parseInt( 값 );

	$(window).scroll(function() {
		// 현재 스크롤 위치를 가져온다.
		var scrollTop = $(window).scrollTop();
		var newPosition = scrollTop + floatPosition + "px";

		/* 애니메이션 없이 바로 따라감
		 $("#floatMenu").css('top', newPosition);
		 */

		$("#floatMenu").stop().animate({
			"top" : newPosition
		}, 1000);

	}).scroll();

});

// Scroll to top button appear
$(document).scroll(function() {
  var scrollDistance = $(this).scrollTop();
  if (scrollDistance > 100) {
    $('.scroll-to-top').fadeIn();
  } else {
    $('.scroll-to-top').fadeOut();
  }
});

</script>

<div id="floatMenu">
<ul class="floatCenter">
	<li><div
		  id="kakao-talk-channel-chat-button"
		  data-channel-public-id="_xcLqmC"
		  data-title="consult"
		  data-size="small"
		  data-color="yellow"
		  data-shape="pc"
		  data-support-multiple-densities="true"
		></div> <br><br></li>
	
</ul>
</div>
<!-- Scroll to Top Button-->
<a class="scroll-to-top rounded js-scroll-trigger" href="#">
	<i class="fas fa-angle-up"></i>
</a>

