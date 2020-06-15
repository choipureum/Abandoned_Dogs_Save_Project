<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
        <%@ taglib prefix="c" uri ="http://java.sun.com/jsp/jstl/core" %>  
     <%@ taglib prefix="fmt" uri ="http://java.sun.com/jsp/jstl/fmt" %>  
<c:set var="memberid" value="${param.memberid }"/>    

<form action="/WebSendMail" method="post" enctype="multipart/form-data">
<table border="1" >
<tr>
   <td>Title</td>
   <td><input type="text" name="subject" size="40"></td>
</tr>
<tr>
   <td>Content</td>
   <td><textarea name="body" rows="10" cols="40"></textarea></td>
</tr>
<tr>
   <td>File</td>
   <td><input type="file" name="attachment"></td>
</tr>
<tr>
   <td colspan="2"><input type="submit" value="Submit"></td>
</tr>
<tr><td><input type="hidden" name="${memberid}" value="${memberid }"> </td></tr>
</table>
</form>
