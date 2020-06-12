<%@page import="java.util.List"%>
<%@page import="user.member.dto.MemberDTO"%>
<%@page import="java.util.Date"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri ="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri ="http://java.sun.com/jsp/jstl/fmt" %>    
<%	List<MemberDTO> m = (List) request.getAttribute("list"); %> 
<% int membercnt= (int)request.getAttribute("membercnt"); %>   
<!DOCTYPE html>
<html>
  <head>
    <meta charset="utf-8">
    <title>관리자 페이지[회원관리]</title>
 	<style type="text/css">
		body{
			margin:0;
			padding:0px;
			font-size:14px;
			font-family: helvetica,sans-serif;
			}
		/*기준날짜 적어주는 작은 글씨*/
		span{
			position:relative;
			font-size:10px;
			float:right;
			padding-right:40px;
			
		}
		/*방문통계 버튼지표*/
		button[id~=visitor_detail]{
			float:right;
			margin-right:30px;
			margin-top:30px;
			border:1px solid gray;
			border-radius:20px;
			width:80px;
			height:80px;
			
		}
		/*버튼 호버*/
		button[id~=visitor_detail]:hover{
			background:gray;
			color:white;
			transition:all 0.3s;
		}
		/*방문자수 맨위 div상자*/
 		.member_top, #Line_Controls_Chart, #myMember{
			postion:absolute;
 			border:1px solid gray;	
 			text-align:center;	
 			margin:30px;
 		}
 	
 		/*방문자수 어제 오늘 작은 글씨 - 한줄로 표시*/
 		dl{
 			display:inline-block;
 			padding:10px 30px 20px 10px;
 		}
 		/*방문자수 실제 나타내는 숫자 글씨*/
 		dl>dd{			
 			text-align:center;
 			font-size:2em;
 			font-weight: bold;
 			padding:10px 50px 20px 10px;
 		}
 		
 	
 	</style>
    <!-- jQuery -->
    <script src="https://code.jquery.com/jquery-2.2.4.min.js"></script>
    <!-- google charts import -->
    <script type="text/javascript" src="https://www.gstatic.com/charts/loader.js"></script>
  </head>
  
  
  
  <body>
  
  <div id="container">
  		<span class="info_rate_date">
  			<c:set var="now" value="<%=new Date() %>"/>
  			<fmt:formatDate value="${now }" type="date" dateStyle="medium"/> 기준  			
  		</span>
  		<button id="visitor_detail" >방문통계</button>
	  <!-- 방문자 수 박스 -->
	  <div class="member_top">
	  
	  	<div class= "box_visitor">
	  	<!-- 오늘 회원 가입 수 -->
	  		<dl class="count_visitor">
	  			<dt>오늘 가입 회원 수</dt>
	  			<dd>100</dd>
	  		</dl>
	  	<!-- 오늘 회원 가입 수 -->
	  	<dl class="count_visitor">
	  		<dt>어제 가입 회원 수</dt>
	  		<dd>80</dd>
	  	</dl>
	  	<!-- 오늘 회원 가입 수 -->
	  	<dl class="count_visitor">
	  		<dt>누적 회원가입 회원 수</dt>
	  		<dd><%=membercnt %></dd>
	  	</dl>
	  	</div>	  	
	  </div>
	  
	   <!-- 회원 수 그래프 표시 -->
	   <div id="Line_Controls_Chart">
	      <!-- 라인 차트 생성할 영역 -->
	      <div id="lineChartArea" style="padding:0px 20px 0px 0px;"></div>
	      <!-- 컨트롤바를 생성할 영역 -->
	      <div id="controlsArea" style="padding:0px 20px 0px 0px;"></div>
	    </div>
	    
	 
	 <!-- 회원 목록 View -->
	 <div id="myMember">
	 	<div>
	 		 <table id="bList" width="100%" border="3" bordercolor="lightgray">
            <tr heigh="30">
            	<th>전체선택<input type="checkbox" class="member_chk_All" /></th>
                <th>번호</th>
                <th>아이디</th>
                <th>회원이름</th>
                <th>휴대폰</th>
                <th>이메일</th>
                <th>회원등급</th>              
            </tr>  
            <!-- 번호 카운트 -->
            <% int cnt= 0;  
             for(int i=0;i<m.size();i++){
             		cnt+=1; %>
            <tr>
            	<td><input type="checkbox" class="member_chk"/></td>
                <td><%=cnt %></td>
                <td><%=m.get(i).getUserid() %></td>
                <td><%=m.get(i).getUsername() %></td>
                <td><%=m.get(i).getUsertel() %></td>
                <td><%=m.get(i).getUseremail() %></td>
                <td><%=m.get(i).getUsergrade() %></td>               
            </tr>
            <% } %>
        </table> 	
	 	</div> 
	 </div>
	
    <br>
 
    <!--  검색 부분 -->
    <br>
    <div id="searchForm">
        <form action="/admin/memberlist" method="post">
        <select name="grade">
                <option value="0" selected="selected">--등급선택--</option>
                <option value="1">브론즈</option>
                <option value="2">실버</option>
                <option value="3">골드</option>
                <option value="4">다이아</option>
          </select>
            <select name="opt">
                <option value="0" selected="selected">--검색조건--</option>
                <option value="1">아이디</option>
                <option value="2">회원명</option>
            </select>
            <input type="text" size="20" name="condition"/>&nbsp;
            <input type="submit" value="회원검색"/>
        </form>    
    </div>

   </div><!-- container 끝 -->
  </body>
 
 
 
 
 

  <script type="text/javascript">
  var chartDrowFun = {
 
    chartDrow : function(){
        var chartData = '';
 
        var chartDateformat     = 'yyyy년MM월dd일';
        //라인차트의 라인 수
        var chartLineCount    = 10;
        //컨트롤러 바 차트의 라인 수
        var controlLineCount    = 10;
 
 
        function drawDashboard() {
 
          var data = new google.visualization.DataTable();
          //그래프에 표시할 컬럼 추가
          data.addColumn('datetime' , '날짜');
          data.addColumn('number'   , '회원수');
 
          //그래프에 표시할 데이터
          var dataRow = [];
 			
          //데이터 삽입예시 (더미데이터)
          for(var i = 0; i <= 29; i++){ //랜덤 데이터 생성
            var total   = Math.floor(Math.random() * 100) + 1;         
 
            dataRow = [new Date('2020', '06', i , '10'), total];
            data.addRow(dataRow);
          }
 
            var chart = new google.visualization.ChartWrapper({
              chartType   : 'LineChart',
              containerId : 'lineChartArea', //라인 차트 생성할 영역
              options     : {
                              isStacked   : 'percent',
                              focusTarget : 'category',
                              height          : 500,
                              width              : '100%',
                              legend          : { position: "top", textStyle: {fontSize: 13}},
                              pointSize        : 5,
                              tooltip          : {textStyle : {fontSize:12}, showColorCode : true,trigger: 'both'},
                              hAxis              : {format: chartDateformat, gridlines:{count:chartLineCount,units: {
                                                                  years : {format: ['yyyy년']},
                                                                  months: {format: ['MM월']},
                                                                  days  : {format: ['dd일']},
                                                                  hours : {format: ['HH시']}}
                                                                },textStyle: {fontSize:12}},
                vAxis              : {minValue: 100,viewWindow:{min:0},gridlines:{count:-1},textStyle:{fontSize:12}},
                animation        : {startup: true,duration: 600,easing: 'in' },
                annotations    : {pattern: chartDateformat,
                                textStyle: {
                                fontSize: 15,
                                bold: true,
                                italic: true,
                                color: '#871b47',
                                auraColor: '#d799ae',
                                opacity: 0.8,
                                pattern: chartDateformat
                              }
                            }
              }
            });
 
            var control = new google.visualization.ControlWrapper({
              controlType: 'ChartRangeFilter',
              containerId: 'controlsArea',  //control bar를 생성할 영역
              options: {
                  ui:{
                        chartType: 'LineChart',
                        chartOptions: {
                        chartArea: {'width': '60%','height' : 80},
                          hAxis: {'baselineColor': 'none', format: chartDateformat, textStyle: {fontSize:12},
                            gridlines:{count:controlLineCount,units: {
                                  years : {format: ['yyyy년']},
                                  months: {format: ['MM월']},
                                  days  : {format: ['dd일']},
                                  hours : {format: ['HH시']}}
                            }}
                        }
                  },
                    filterColumnIndex: 0
                }
            });
 
            var date_formatter = new google.visualization.DateFormat({ pattern: chartDateformat});
            date_formatter.format(data, 0);
 
            var dashboard = new google.visualization.Dashboard(document.getElementById('Line_Controls_Chart'));
            window.addEventListener('resize', function() { dashboard.draw(data); }, false); //화면 크기에 따라 그래프 크기 변경
            dashboard.bind([control], [chart]);
            dashboard.draw(data);
 
        }
          google.charts.setOnLoadCallback(drawDashboard); 
      }
    }
 
$(document).ready(function(){
  google.charts.load('current', {'packages':['line','controls']});
  chartDrowFun.chartDrow(); //chartDrow() 실행
  
  // 방문통계 이동
  $("#visitor_detail").on("click", function(){
				location.href="/admin/visitor";
			});
  //멤버 전체선택
  $(".member_chk_All").click(function(){
	  $(".member_chk").prop("checked",this.checked);
  });
  
			
});
  </script>
</html>


