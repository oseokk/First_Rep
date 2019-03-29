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
<title>영화관 상세정보</title>
<script type="text/javascript">
function phallregForm(seq){
	location.href="./phallregForm.do?cin_cd="+seq;
}
</script>
</head>
<%
List<CinemaDto> lists = (List<CinemaDto>)request.getAttribute("lists");
%>
<body>
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
<div class="container">
		<div class="row">
<table class="table table-striped"
					style="text-align: center; border: 1px solid #dddddd">
		<thead>
						<tr>
							<th colspan="5"
								style="background-color: #eeeeee; text-align: center;">영화관상세정보</th>
						</tr>
						<tr>
			<th style="background-color: #eeeeee; text-align: center;">영화관이름</th>			
			<th style="background-color: #eeeeee; text-align: center;">회사이름</th>
			<th style="background-color: #eeeeee; text-align: center;">주소명</th>	        
			<th style="background-color: #eeeeee; text-align: center;">도로명주소</th>
			<th style="background-color: #eeeeee; text-align: center;">상영관</th>
		</tr>
					</thead>
					<tbody>
		<%
		if(lists ==null ||lists.size()==0){
		%>			
		<tr><td colspan="5">등록된 상영관이 없습니다.</td></tr>
		<%
		}else{
			for(CinemaDto dto : lists){
		%>
		<tr>
		<td><%=dto.getSub_title().replaceAll(" ", "&nbsp;").replaceAll("<", "&lt;").replaceAll(">", "&gt;")%></td>
		<td><%=dto.getTitle()%></td>
		<td><%=dto.getAddress()%></td>
		<td><%=dto.getRoad_address()%></td>
		<td><a href="./phall_Detail.do?playhall_cd=<%=dto.getPlayhall_cd()%>"><%=dto.getPlayhall_name()%></a></td>
		</tr>
		<%
			}
		}
		%>
         <tr>
          <td colspan="5">
         <input type="button" value="상영관등록" class="btn btn-primary pull-left" onclick="phallregForm(${cin_cd})">
         <input type="button" class="btn btn-primary pull-left" value="이전" onclick="history.back()">
         </td>
         </tr>
        </tbody>	
        </table>
</div> 
</div>
</body>
</html>



