
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
	
<style type="text/css">
#floatMenu {
	position: absolute;
    width: 10%;
    height: 200px;
    right: 0;
    top: 280px;
    color: #fff;
    z-index: 9999999;
}

/* 테이블 logo 영역 */
.floatCenter {
	padding: 0px 35px;
	list-style-type: none;
}
</style>

<script type="text/javascript"
src="https://code.jquery.com/jquery-2.2.4.min.js"></script>

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

</script>

<div id="floatMenu">
<ul class="floatCenter">
	<li><a href="#"><img alt="top" src="../resources/s_logo01.png"> </a></li>
	<li><a href="#"><img alt="상담문의" src="../resources/s_logo02.png"> </a></li>
</ul>
</div>
