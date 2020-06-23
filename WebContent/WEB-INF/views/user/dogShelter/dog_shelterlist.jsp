<%-- <%@ page language="java" contentType="text/html; charset=UTF-8" --%>
<%--     pageEncoding="UTF-8" %> --%>
<!-- <!DOCTYPE html> -->
<!-- <html> -->
<!-- <head> -->
<!-- <meta http-equiv="Content-Type" content="text/html; charset=UTF-8"> -->
<!-- <script type="text/javascript" src="https://code.jquery.com/jquery-2.2.4.min.js"></script> -->

<!-- <title>jQuery Ajax TEST</title> -->
<!-- </head> -->
<!-- <body> -->
<!-- 	<!-- ajax와 json을 같이써보깅 --> -->
<!-- 	<h3>유기견 정보조회</h3> -->
<!-- 	<input type="number" min="0" max="2" id="input1" placeholder="입력"> -->
<!-- 	<button id="btn1">실행</button> -->
<!-- 	<div id="area1" class="area"></div> -->
<!-- 	<script> -->
// 		$("#btn1").click(function() {
// 			var index = $("#input1").val();
// 			$.ajax({
// 				url : "/dog/view'", // 보통 url를 쓸때 .do 라고 씀 (규약같은거)
// 				/* data : "index="+index, 쿼리스트링 방식 */
// 				data :{
// 		 			"sheltername" : sheltername
// 		 			, "shelteraddress" : shelteraddress
// 		 			, "sheltertel" : sheltertel}, // json object 방식 (키:값)
// 				type : "post",
// 				success : function(data) {
// 					console.log(data);
// 					var html = "<table border='1'>";
// 					/* for (var i in data) {  한개 데이터만 가져오기때문에 for문 필요업뜸*/
// 					var dogshelter = data;           //  여러개일때 for문 쓰고 data[i]
// 					html += "<tr><td>"+dogshelter.sheltername+"</td>";
// 					html += "<td>"+dogshelter.shelteraddress+"</td>";
// 					html += "<td>"+dogshelter.sheltertel+"</td></tr>";
// 					/* } */
// 					html += "</table>";
// 					$("#area1").html(html);
// 				},
// 				error : function(data) {
// 					console.log("ajax 처리 실패");
// 				}
// 			});
// 		});
<!-- 	</script> -->
<!-- </body> -->
<!-- </html> -->