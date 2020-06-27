<%@page import="user.dog.dto.Dog_Data"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%
	List<Dog_Data> listword = (List) request.getAttribute("keyWord");
	List<Dog_Data> listfield = (List) request.getAttribute("keyField");
 %> 
	
<script type="text/javascript"src="http://code.jquery.com/jquery-2.2.4.min.js"></script>
<script type="text/javascript">

function list() {
    document.list.action = "dog/detail";
    document.list.submit();
}


function check() {
    if (document.search.keyWord.value == "") {
        alert("검색어를 입력하세요.");
        document.search.keyWord.focus();
        return;
    }
    document.search.submit();
}



</script> 


<form action="dog/detail" method="post">
    <select name="searchCategory">
        <option value="1">작성자</option>
        <option value="2">글제목</option>
        <option value="3">글제목 + 내용</option>
    </select>
    <input type="text" name="searchKeyword" 
        placeholder="키워드" required />
    <input type="submit" value="검색" />
</form>


<!-- <!--     <form action="dog/detail" name="search" method="post"> --> -->
<!-- <!--         <table border=0 width=800 cellpadding=5 cellspacing=0> --> -->
<!-- <!--  		<tr> --> -->
<!-- <!--             <td align=right valign=top> --> -->
<!-- <!--             <select name="keyField" size="1"> --> -->
<%-- <%--                 <option value="name" <c:if test="${'dogname'==keyField }"> selected</c:if>> 이름 </option> --%> --%>
<%-- <%--                 <option value="title" <c:if test="${'dogkind'==keyField }"> selected</c:if>> 품종 </option> --%> --%>
<%-- <%--             </select><input type="text" size="16" name="keyWord" value="${keyWord }"> --%> --%>
<!-- <!--             <input type="button" value="검색" onClick="check()"><input type="hidden" name="page" value="0"></td> --> -->
<!-- <!--         </tr>                 --> -->
<!-- <!--         </table> --> -->
<!-- <!--     </form>   --> -->
