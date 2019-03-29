<%@page import="seok.yun.na.dtos.NoticeDto"%>
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
<title>공지사항 수정</title>
<style type="text/css">
table {
	margin-top: 50px;
	margin-left: 20px;
}

td {
	border: 1px solid black;
	border-collapse: collapse;
	padding: 10px 10px 10px 10px;
}
</style>
<script type="text/javascript">
	function returnView() {
		location.href = "./notice_list.do";
	}
</script>
</head>

<%

   NoticeDto dto = (NoticeDto)request.getAttribute("dto");

%>

<body>
<nav class="navbar navbar-default">
		<div class="navbar-header">
			<button type="button" class="navbar-toggle collapsed"
				data-toggle="collapse" data-target="#bs-example-navbar-collapse-1"
				aria-expanded="false">
				<span class="icon-bar"></span> <span class="icon-bar"></span> <span
					class="icon-bar"></span>
			</button>
			<a class="navbar-brand" href="adminMain.jsp">KOKOA SNMS</a>
		</div>
		<div class="collapse navbar-collapse"
			id="bs-example-navbar-collapse-1">
			<ul class="nav navbar-nav">
				<li><a href="./adminMain.do">메인</a>
				<li>
   
				<li class="active"><a href="./notice_list.do">게시판</a>
				<li>
    
				<li><a href="./cinemaList.do">영화관</a>
				<li>
   
				<li><a href="./schedulemanage.do">스케줄</a>
				<li>
  
			</ul>
  <ul class="nav navbar-nav navbar-right">
   <li class="dropdown">
    <a href="#" class="dropdown-toggle" data-toggle="dropdown"
					role="button" aria-haspopup="true" aria-expanded="false">관리메뉴<span
						class="caret"></span></a>
  <ul class="dropdown-menu">
   <li><a href="./logout.do">로그아웃</a></li>
  </ul>
  </li>
  </ul>
 </div>
</nav>
<div class="container">
		<div class="row">
	<form action="./notice_edit.do" method="post">
		<table class="table table-striped"
					style="text-align: center; border: 1px solid #dddddd">
					<thead>
						<tr>
							<th colspan="3"
								style="background-color: #eeeeee; text-align: center;">공지사항
							 수정하기</th>
						</tr>
					</thead>
						<tbody>
			<tr>
			
				<td><input type="text" id="ntc_seq" name="ntc_seq" class="form-control"  value="<%=dto.getNtc_seq()%>" readonly="readonly"></td>
			</tr>
			<tr>
				<td><input type="text" id="title" name="title" class="form-control"  value="<%=dto.getTitle()%>"></td>
			</tr>
			<tr>
				<td><textarea class="form-control" placeholder="내용"
									id="content" name="content" maxlength="2000" style="height: 350px;" required="required"><%=dto.getContent()%></textarea>
				</td>
			</tr>
	
			</tbody>
		</table>
    <input type="submit" class="btn btn-primary pull-right" value="등록">
    <input type="button" class="btn btn-primary pull-right" value="취소"
					onclick="history.back()">


	</form>
</div>
</div>
<script type="text/javascript"
				src="https://code.jquery.com/jquery-3.2.1.min.js"></script>
			<script src="js/bootstrap.js"></script>
</body>
</html>
