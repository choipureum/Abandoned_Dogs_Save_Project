<%@page import="user.dog_shleter.dto.Dog_Shelter"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%
	List<Dog_Shelter> dogList = (List) request.getAttribute("list");
%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>

<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>

<script type="text/javascript">

$(document).ready(function(){

	// .check 클래스 중 어떤 원소가 체크되었을 때 발생하는 이벤트

	$(".check").click(function(){  // 여기서 .click은 체크박스의 체크를 뜻한다.
		var str = "";  // 여러개가 눌렸을 때 전부 출력이 될 수 있게 하나의 객체에 담는다.
		$(".check").each(function(){  // .each()는 forEach를 뜻한다.
			if($(this).is(":checked"))  // ":checked"를 이용하여 체크가 되어있는지 아닌지 확인한다.
				str += $(this).val() + " ";  // 체크된 객체를 str에 저장한다.
		});
		$("#multiPrint").text(str);  // #multiPrint에 체크된 원소를 출력한다.

	});

	
	// 전부 체크하는 방법
	$("#allCheck").click(function(){
		if($(this).is(":checked"))  // 먼저 #allCheck가 선택되었는지 확인한다.
            // 체크가 되어있으면 .check의 모든 원소에 checked="checked"를 추가한다.
			$(".check").attr("checked","checked")  
		else
			$(".check").removeAttr("checked")  // 체크가 안 되어있으면 "checked"를 제거한다.
			 // 이 때 체크가 되어있는 원소는 안 바뀐다. 어디까지나 체크가 안 된 것들에 대해서만 효과가 있다.
		var str = "";  // 여러개가 눌렸을 때 전부 출력이 될 수 있게 하나의 객체에 담는다.
		$(".check").each(function(){  // .each()는 forEach를 뜻한다.
			if($(this).is(":checked"))  // ":checked"를 이용하여 체크가 되어있는지 아닌지 확인한다.
				str += $(this).val() + " ";  // 체크된 객체를 str에 저장한다.
		});
		$("#multiPrint").text(str);  // #multiPrint에 체크된 원소를 출력한다.
	});
});

</script>



</head>
<body>



<form>

checkbox 확인 : <span id="multiPrint"></span><br/>
<input type="checkbox" class="check" value="하나">하나
<input type="checkbox" class="check" value="둘">둘
<input type="checkbox" class="check" value="셋">셋
<input type="checkbox" class="check" value="넷">넷
<input type="checkbox" class="check" value="다섯">다섯
<input type="checkbox" id="allCheck" >모두 체크<br/>
</form>

</body>
</html>