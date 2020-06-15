<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
        <%@ taglib prefix="c" uri ="http://java.sun.com/jsp/jstl/core" %>  
     <%@ taglib prefix="fmt" uri ="http://java.sun.com/jsp/jstl/fmt" %>  
<c:set var="memberid" value="${param.member_mail }"/>    

<form action="/WebSendMail" method="post" enctype="multipart/form-data">
<table border="1" >
<tr>
   <td>제목</td>
   <td><input type="text" name="subject" size="80"></td>
</tr>
<tr>
   <td>내용</td>
   <td><textarea name="body" rows="30" cols="75"></textarea></td>
</tr>
<tr>
   <td>파일</td>
   <td><input type="file" name="attachment"></td>
</tr>
<tr>
   <td colspan="2"><input type="submit" value="메일보내기"></td>
</tr>
</table>

<input type="text" name="${memberid}" value="${memberid }"disabled="disabled"> 
</form>
