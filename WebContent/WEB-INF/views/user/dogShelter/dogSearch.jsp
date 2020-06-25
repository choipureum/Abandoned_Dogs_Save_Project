<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<script type="text/javascript"
	src="http://code.jquery.com/jquery-2.2.4.min.js"></script>
<script type="text/javascript">
function searchCheck(frm){
    //검색
   
    if(frm.keyWord.value ==""){
        alert("검색 단어를 입력하세요.");
        frm.keyWord.focus();
        return;
    }
    frm.submit();      
}

</script>

<table>
 <tr>  
        <td colspan="7"> <br/>
            <form name="serach" method ="get">
            <select name="keyField">
                <option value="0"> ----선택----</option>
                <option value="id">아이디</option>
                <option value="name">이름</option>
                <option value="addr">주소</option>  
            </select>
            <input type="text" name="keyWord" />
            <input type="button" value="검색" onclick="searchCheck(form)" />
           
            </form>
           
        </td>      
</table>