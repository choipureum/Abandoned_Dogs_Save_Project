<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
  <head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <meta http-equiv="X-UA-Compatible" content="ie=edge">
 <script type="text/javascript">
 
 var wintimer;
 clearTimeout(wintimer);
 wintimer= setTimeout("closewin()",3000); //5초후 닫힘

 function closewin() {
    window.close();
 }

 var cityCat = 4;
	function countDown() {
		if (cityCat != 0) {
			div1.innerHTML = cityCat;
			cityCat -= 1;
		}
		else {
			div1.innerHTML = "종료";
			clearInterval(repeat);
		}
	}
	div1.innerHTML = cityCat + 1;
	var repeat = setInterval(countDown, 1000);
 </script>
    <title>MailSubmit :: Thank you!</title>
  </head>
  <body>
    <div class="wrap">
      <div class="container">
        <div class="heading">
          <span class="big-message">감사합니다!</span>
        </div>
        <div class="img-container">
          <img src="img/thankyou.png" alt="thankyou-image">
        </div>
        <div class="content-div" id="div1">
            <p class="content">이메일 전송이 완료되었습니다!</p>
            <button onclick="closewin();">종료하기</button>
        </div>
      </div>
    </div>
  </body>
</html>