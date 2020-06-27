<%@page import="user.dog.dto.Dog_Data"%>
<%@page import="user.dog_shleter.dto.Dog_Shelter"%>
<%@page import="javax.annotation.PostConstruct"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>


<%	List<Dog_Shelter> dogList = (List) request.getAttribute("list");%>
	
	
<!-- 헤더 임포트 -->
<c:import url="/WEB-INF/views/user/util/header/Header.jsp"></c:import>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>

<script type="text/javascript" src="/resources/js/httpRequest.js"></script>
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
<style type="text/css">
.dogshelterlist {
	text-decoration: none;
}
</style>
<script type="text/javascript">

$(document).ready(function() {

$(document).on("click", ".dogshelterlist", function() {
	console.log($(this).children("a").attr("href"))

	$.ajax({
		type: "get"
		, url: $(this).children("a").attr("href")
		, dataType: "html"
		, success: function(h) {
			console.log("succ");
			console.log(h);
			$("#container").html(h)
		}
		, error: function() {
			console.log("err")
		}
	})
	
	return false;
})

})

</script>


</head>
<body>

	<div style="position: relative;">
		<div id="map" style="width: 125%%; height: 920px;"></div>
		<div id="container"
			style="z-index: 9999; position: absolute; display: inline-block; width: 30%; height: 37%; left: 50px; bottom: 50px"></div>
	</div>

	<script type="text/javascript"
		src="//dapi.kakao.com/v2/maps/sdk.js?appkey=5645296e24208ec4f20113a550ae0767&libraries=services,clusterer,drawing"></script>

	<script>
		var mapContainer = document.getElementById('map'), // 지도를 표시할 div 
		mapOption = {
			center : new kakao.maps.LatLng(37.56682, 126.97865), // 지도의 중심좌표
			level : 11, // 지도의 확대 레벨
			mapTypeId : kakao.maps.MapTypeId.ROADMAP
		// 지도종류
		};

		// 지도를 생성한다 
		var map = new kakao.maps.Map(mapContainer, mapOption);
		
		 // 마커 클러스터러를 생성합니다 
        var clusterer = new daum.maps.MarkerClusterer({
            map: map, // 마커들을 클러스터로 관리하고 표시할 지도 객체 
            averageCenter: true, // 클러스터에 포함된 마커들의 평균 위치를 클러스터 마커 위치로 설정 
            minLevel: 8 // 클러스터 할 최소 지도 레벨 
        });
        
		 
		if (navigator.geolocation) {

			// GeoLocation을 이용해서 접속 위치를 얻어옵니다
			navigator.geolocation.getCurrentPosition(function(position) {

				var lat = position.coords.latitude, // 위도
				lon = position.coords.longitude; // 경도

				var locPosition = new kakao.maps.LatLng(lat, lon), // 마커가 표시될 위치를 geolocation으로 얻어온 좌표로 생성합니다
				message = '<div style="padding:5px;">현재위치</div>'; // 인포윈도우에 표시될 내용입니다

				// 마커와 인포윈도우를 표시합니다
				displayMarker(locPosition, message);

			});

			
			
			// 지도에 마커와 인포윈도우를 표시하는 함수입니다
			function displayMarker(locPosition, message) {

				// 마커를 생성합니다
				var marker_present = new kakao.maps.Marker({
					map : map,
					position : locPosition
				});

				var iwContent = message, // 인포윈도우에 표시할 내용
				iwRemoveable = true;

				// 인포윈도우를 생성합니다
				var infowindow = new kakao.maps.InfoWindow({
					content : iwContent,
					removable : iwRemoveable
				});

				// 인포윈도우를 마커위에 표시합니다 
				infowindow.open(map, marker_present);

				// 지도 중심좌표를 접속위치로 변경합니다
				map.setCenter(locPosition);
			}

		}
	
		<%for (int i = 0; i < dogList.size(); i++) {%>
		 
		// 마커를 표시할 위치와 내용을 가지고 있는 객체 배열 
		var marker = new kakao.maps.Marker({
			position : new kakao.maps.LatLng('<%=dogList.get(i).getShelterlat()%>','<%=dogList.get(i).getShelterlon()%>'),		
			map: map,
			clickable : true
		});
						

		//띄울 인포윈도우 정의
// 		var iwContent = 
<%--  			<%=dogList.get(i).getSheltername()%>  --%>
<%--  			<%=dogList.get(i).getShelteraddress()%>  --%>
		//// 인포윈도우에 표출될 내용으로 HTML 문자열이나 document element가 가능합니다
		//iwRemoveable = true; // removeable 속성을 ture 로 설정하면 인포윈도우를 닫을 수 있는 x버튼이 표시됩니다

		// 마커에 표시할 인포윈도우를 생성합니다 
			var infowindow = new kakao.maps.InfoWindow({
			content : '<div class="dogshelterlist">'+
			'	<a href="/dog_shelter/detail?shelterno='+
					'<%=dogList.get(i).getShelterno()%>">'+
					'<%=dogList.get(i).getSheltername()%>'+
					'</div>'
			});
	
	
		// 마커에 mouseover 이벤트와 mouseout 이벤트를 등록합니다
	    // 이벤트 리스너로는 클로저를 만들어 등록합니다 
	    // for문에서 클로저를 만들어 주지 않으면 마지막 마커에만 이벤트가 등록됩니다
// 	    kakao.maps.event.addListener(marker, 'mouseover', makeOverListener(map, marker, infowindow));
	    kakao.maps.event.addListener(marker, 'mouseout', makeOutListener(infowindow));
	  
		// 마커에 클릭이벤트를 등록합니다
      	// 마커 위에 인포윈도우를 표시합니다
		kakao.maps.event.addListener(marker, 'click', makeOverListener(map, marker, infowindow));
		
		
		<%}%>

		
	// 인포윈도우를 표시하는 클로저를 만드는 함수입니다 
	function makeOverListener(map, marker, infowindow) {
	    return function() {
	    	infowindow.open(map, marker);
	    };
	}

	// 인포윈도우를 닫는 클로저를 만드는 함수입니다 
	function makeOutListener(infowindow) {
	    return function() {
	       setTimeout(function() {
	    	infowindow.close();		
			},3000);
	    };
	};

	
	</script>


	<div id="search"></div>
	<div id="dog"></div>
	<div id="showplus">
		<button>더보기</button>
	</div>

</body>
</html>