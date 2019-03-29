<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<meta name="viewport" content="width=device-width" ,initial-scale="1">
<link rel="stylesheet" href="css/bootstrap.css">
<title>공지사항 작성 화면</title>
<script type="text/javascript">
	function returnView() {
		location.href = "./notice_list.do";
	}
</script>
</head>
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
			<form action="./notice_add.do" method="post">
				<table class="table table-striped"
					style="text-align: center; border: 1px solid #dddddd">
					<thead>
						<tr>
							<th colspan="3"
								style="background-color: #eeeeee; text-align: center;">공지사항
								작성</th>

						</tr>
					</thead>
					<tbody>
						<tr>
							<td><input type="text" class="form-control" placeholder="제목"
								id="title" name="title" maxlength="50" required="required"></td>
						</tr>
						<tr>
							<td><textarea class="form-control" placeholder="내용"
									id="content" name="content" cols="2000" style="height: 350px;" required="required"></textarea>
							</td>
						</tr>
					</tbody>
				</table>
				<input type="submit" class="btn btn-primary pull-right" value="등록">
				<input type="button" class="btn btn-primary pull-right" value="취소"
					onclick="returnView()">
			</form>
			</div>
			</div>
			<script type="text/javascript"
				src="https://code.jquery.com/jquery-3.2.1.min.js"></script>
			<script src="js/bootstrap.js"></script>
</body>
</html>







