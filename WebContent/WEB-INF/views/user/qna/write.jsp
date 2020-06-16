<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!-- jQuery 2.2.4.min -->
<script type="text/javascript" src="https://code.jquery.com/jquery-2.2.4.min.js"></script>
<!-- 부트스트랩 3.3.2 -->
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.2/css/bootstrap.min.css">
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.2/css/bootstrap-theme.min.css">
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.2/js/bootstrap.min.js"></script>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>

<script type="text/javascript">
var oEditors = [];
nhn.husky.EZCreator.createInIFrame({
   oAppRef : oEditors
   , elPlaceHolder: "content" // 에디터가 적용될 <textarea>의 id
   , sSkinURI: "/resources/se2/SmartEditor2Skin.html"//에디터 스킨적용
   ,fCreator: "createSEditor2"
})
</script>
<script>
function submitContents(elClickedObj){
	//에디터의 내용을 #content에 반영한다 
	oEditors.getById["content"].exec("UPDATE_CONTENTS_FIELD",[]);
	
	try{
		elClickedObj.form.submit();
	}catch(e){}
}
</script>
<script type="text/javascript">
$(document).ready(function() {
	
	//작성버튼 동작
	   $("#btnWrite").click(function() {
		   //스마트에디터의 내용을 <textarea>에 적용한다 
		   submitContents($("#btnWrite"));
		   
		   $("form").submit();
	   });
	  
	
   
   //작성버튼 동작
   $("#btnWrite").click(function() {
      $("form").submit();
   });
   
   //취소버튼 동작
   $("#btnCancel").click(function() {
      history.go(-1);
   });
});
</script>
</head>
<body>
<div  class="container">
<form action="/qna/write" method="post">
	<table class="table table-hover table-condensed">
		<tr>
			<th>제목</th>
			<td><input type="text" placeholder="제목을 입력하세요" name="qnatitel"></td>
		</tr>
		<tr>
			<th>작성자</th>
			<td><input type="text" name="qnawriter"  placeholder="이름"></td>
		</tr>
		<tr>
			<th>첨부파일</th>
			<td><input type="file" name="qnafile" ></td>
		</tr>
		<tr>
			<th>내용</th>
			<td><textarea name="qnacontent" placeholder="내용을 입력하세요"></textarea></td>
		</tr>
</table>
</form>	
<div>			
	<button id="btnWrite">등록</button>
	<button id="btnCancel">취소</button>
</div>			


</div>
</body>
</html>