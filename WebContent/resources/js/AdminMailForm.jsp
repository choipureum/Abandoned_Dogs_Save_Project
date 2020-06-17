<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri ="http://java.sun.com/jsp/jstl/core" %>  
<%@ taglib prefix="fmt" uri ="http://java.sun.com/jsp/jstl/fmt" %>  
<style type="text/css">
#content {
   width: 95%;
}
#container{
	width:100%;
	height:100%;
}
</style>
<!-- 스마트 에디터2 라이브러리 -->
<script type="text/javascript" src="/resources/se2/js/service/HuskyEZCreator.js" charset="utf-8"></script>
<script type="text/javascript" src="https://code.jquery.com/jquery-2.2.4.min.js"></script>
<script type="text/javascript">
 
 function submitContents(elClickedObj){
    //에디터의 내용을 #content에 반영한다   
    oEditors.getById["content"].exec("UPDATE_CONTENTS_FIELD",[] );  
    try{
       //<form>태그의 submit을 수행한다
       elClickedObj.form.submit();      
    }catch(e){ }   
 }
 </script> 
 <script type="text/javascript">
$(document).ready(function() {
	
	//작성버튼 동작
	$("#btnWrite").click(function() {
		
		//스마트에디터의 내용을 <textarea>에 적용하는 함수 호출
		submitContents( $("#btnWrite") );
		
		//<form> 태그 submit
		$("form").submit();
		
	});

});
</script>
<c:set var="memberEmail" value="${param.Email }"/>    


<form action="/WebSendMail" method="post" enctype="multipart/form-data" class="container">
	<table border="1" >
	<tr>
		<td>받는사람</td>
		<td><input type="text" id="toEmail"value="${memberEmail }" disabled="disabled"> </td>
	</tr>
	<tr>
	   <td>제목</td>
	   <td><input type="text" name="subject" size="100"></td>
	</tr>
	<tr>
	   <td>내용</td>
	   <td><textarea name="body" rows="30" cols="100" id="content"></textarea></td>
	</tr>
	<tr>
	   <td>파일</td>
	   <td><input type="file" name="attachment"></td>
	</tr>
	<tr>
	   <td colspan="2"><button type="button" id="btnWrite" class="btn btn-info">작성</button>
	   <input type="hidden" name="toEmail" value="${memberEmail }"/></td>	   
	</tr>
	</table>
</form>

 <script> 
 var oEditors=[];
 nhn.husky.EZCreator.createInIFrame({
    oAppRef:oEditors
    , elPlaceHolder:"content" //에디터가 적용될<textarea>의 id
    , sSkinURI: "/resources/se2/SmartEditor2Skin.html" //에디터 스킨
    , fCreator: "createSEditor2"
      
 });

 
 </script>
 
 
 
 