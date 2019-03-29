<%@page import="seok.yun.na.dtos.CinemaDto"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<meta name="viewport" content="width=device-width" ,initial-scale="1">
<link rel="stylesheet" href="css/bootstrap.css">
<title>상영관 상세정보</title>
<script type="text/javascript">
		function seatregForm(seq){
		location.href="./seatregForm.do?playhall_cd="+seq;
	}
</script>
</head>
<%
List<CinemaDto> lists = (List<CinemaDto>)request.getAttribute("lists");
%>
<nav class="navbar navbar-default">
 <div class="navbar-header">
  <button type="button" class="navbar-toggle collapsed"
   data-toggle="collapse" data-target="#bs-example-navbar-collapse-1"
   aria-expanded="false">
    <span class="icon-bar"></span>
    <span class="icon-bar"></span>
    <span class="icon-bar"></span>
   </button>
   <a class="navbar-brand" href="./adminMain.do">KOKOA SNMS</a>
 </div>
 <div class="collapse navbar-collapse" id="bs-example-navbar-collapse-1">
  <ul class="nav navbar-nav">
   <li><a href="./adminMain.do">메인</a><li>
   <li><a href="./notice_list.do">게시판</a><li>
    <li class="active"><a href="./cinemaList.do">영화관</a><li>
   <li><a href="./schedule_list.do">스케줄</a><li>
  </ul>
  <ul class="nav navbar-nav navbar-right">
   <li class="dropdown">
    <a href="#" class="dropdown-toggle"
    data-toggle="dropdown" role="button" aria-haspopup="true"
    aria-expanded="false">관리메뉴<span class="caret"></span></a>
  <ul class="dropdown-menu">
   <li><a href="./logout.do">로그아웃</a></li>
  </ul>
  </li>
  </ul>
 </div>
</nav>
<script type="text/javascript" src="https://code.jquery.com/jquery-3.2.1.min.js"></script>
<script src="js/bootstrap.js"></script>
<body>
<div class="container">
		<div class="row">
		<table class="table table-striped"
					style="text-align: center; border: 1px solid #dddddd">
<thead>
						<tr>
							<th colspan="5"
								style="background-color: #eeeeee; text-align: center;">좌석정보</th>
						</tr>
						<tr>
			<th style="background-color: #eeeeee; text-align: center;">좌석</th>			

		</tr>
					</thead>
		
		<tbody>
		<%
		  if(lists == null ||lists.size() == 0){
         %>
         <tr><td colspan="4">등록된 좌석이 없습니다</td></tr>
         <%
		  }else{

		for(CinemaDto dto : lists){
				%>
				<tr>
					 <td><%=dto.getSeatrow()%><%=dto.getSeatcol()%></td>
				</tr>
				
				<%
			}
		  }
		%>
		<tr>
		</tr>
		   </tbody>	
	</table>
	<input type="button" value="좌석등록" class="btn btn-primary pull-right" onclick="seatregForm(${playhall_cd})">
	<input type="button" class="btn btn-primary pull-right" value="이전" onclick="history.back()">
</form>
</div> 

</div> 

</body>
</html>



