<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
  <head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <meta http-equiv="X-UA-Compatible" content="ie=edge">
    
    <style type="text/css">
    *{font-family:"맑은고딕"}
    .big-message{margin:100px 0 0 0;}
    .content-div{margin:10px 0 20px 0;}


body:before{
  content:'';
  height:100%;
  display:inline-block;
  vertical-align:middle;
}
button{
  background:white;
  color:black;
  border:none;
  position:relative;
  height:60px;
  font-size:1.6em;
  padding:0 2em;
  cursor:pointer;
  transition:800ms ease all;
  outline:none;
}
button:hover{
  background:#fff;
  color:#1AAB8A;
}
button:before,button:after{
  content:'';
  position:absolute;
  top:0;
  right:0;
  height:2px;
  width:0;
  background: #1AAB8A;
  transition:400ms ease all;
}
button:after{
  right:inherit;
  top:inherit;
  left:0;
  bottom:0;
}
button:hover:before,button:hover:after{
  width:100%;
  transition:800ms ease all;
}

    </style>
 <script type="text/javascript">
 
 var wintimer;
 clearTimeout(wintimer);
 wintimer= setTimeout("closewin()",10000); //10초후 닫힘

 function closewin() {
    window.close();
 }
 var cnt=10;
 function countDown(){
	 cnt--;
	 document.getElementById("count").textContent= cnt;
 }
 var timer = setInterval(countDown,1000);
 </script>
    <title>MailSubmit :: Thank you!</title>
  </head>
  <body>
    <div class="wrap" style="margin:0 auto; text-align:center; padding:100px 100px;">
      <div class="container">
        <div class="heading">
          <span class="big-message" style="font-size:30px;">회원 이메일 전송 완료</span>
        </div>
        <div class="img-container">
          <img src="${pageContext.request.contextPath}/resources/mail_ok.PNG" alt="thankyou-image">
        </div>
        <div class="content-div" id="div1">
            <p class="content">이메일 전송이 완료되어 <span id="count"></span>초뒤에 종료됩니다</p>
            <button onclick="closewin();" >종료하기</button>
        </div>
      </div>
    </div>
  </body>
</html>