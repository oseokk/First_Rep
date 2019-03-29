<%@page import="java.util.List"%>
<%@page import="seok.yun.na.dtos.CinemaDto"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<meta name="viewport" content="width=device-width" ,initial-scale="1">
<link rel="stylesheet" href="css/bootstrap.css">
<title>좌석 등록 화면</title>
<script type="text/javascript">
/* 	function duplicationId(){
		var title = "아이디중복확인";
		var url = "./duplicate.do";
		var option = "width=300px, height=500px";
		window.open(url,title,option);
	} */
	
	function returnView(){
		location.href="./cinemaList.do";
	}
	
/* 	function chkPassword(){
		var pw1 = document.getElementById("password1").value;
		var pw2 = document.getElementById("password2").value; */
// 		alert(pw1);
// 		alert(pw2);
/* 		if(pw1=="" || pw2=="" || pw1!=pw2){
			alert("비밀번호가 일치하지 않습니다");
			pw1 = "";
			pw2 = "";
			return false;
		}else{
			return true;
		}

	} */
	
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
				<li><a href="./notice_list.do">게시판</a>
				<li>
				<li class="active"><a href="./cinemaList.do">영화관</a>
				<li>
				<li><a href="./schedule_list.do">스케줄</a>
				<li>
			</ul>
			<ul class="nav navbar-nav navbar-right">
				<li class="dropdown"><a href="#" class="dropdown-toggle"
					data-toggle="dropdown" role="button" aria-haspopup="true"
					aria-expanded="false">관리메뉴<span class="caret"></span></a>
					<ul class="dropdown-menu">
						<li><a href="./logout.do">로그아웃</a></li>
					</ul></li>
			</ul>
		</div>
	</nav>
<div class="container">
		<div class="row">
<form action="./seat_add.do" method="post">
	<table class="table table-striped"
					style="text-align: center; border: 1px solid #dddddd">
					<thead>
						<tr>
							<th colspan="3"
								style="background-color: #eeeeee; text-align: center;">좌석등록</th>
						</tr>
					</thead>
					<tbody>
	<tr>

				<td><input type="text" class=" form-control" id="playhall_cd" name="playhall_cd" value="${playhall_cd}" readonly="readonly"></td>
		</tr>
		<tr>
			<td>
				<input type="text" class=" form-control" placeholder="좌석행" id="seatrow" name="seatrow" maxlength="1" required="required">
			</td>
		</tr>
		<tr>
			<td>
				<input type="text" class=" form-control" placeholder="좌석열" id="seatcol" name="seatcol" maxlength="1" required="required">
			</td>
		</tr>
			
		</tbody>
	</table>
				<input type="submit" class="btn btn-primary pull-right" value="등록">
				<input type="button" class="btn btn-primary pull-right" value="취소" onclick="history.back()">
</form>
</div>
			</div>
			<script type="text/javascript"
				src="https://code.jquery.com/jquery-3.2.1.min.js"></script>
			<script src="js/bootstrap.js"></script>
</body>
</html>







