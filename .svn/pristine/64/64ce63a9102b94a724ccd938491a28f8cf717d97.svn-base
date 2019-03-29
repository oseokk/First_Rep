<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@page import="java.util.List"%>
<%@page import="seok.yun.na.dtos.MembershipDto"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>메인화면</title>
<%
List<MembershipDto> lists = (List<MembershipDto>)request.getAttribute("kDto");
	
%>
<script type="text/javascript"
	src="https://code.jquery.com/jquery-3.3.1.js"></script>
<script src="//ajax.googleapis.com/ajax/libs/jquery/1/jquery.min.js"></script>
<script
	src="//maxcdn.bootstrapcdn.com/bootstrap/latest/js/bootstrap.min.js"></script>
<link
	href="//maxcdn.bootstrapcdn.com/bootstrap/latest/css/bootstrap.min.css"
	rel="stylesheet">
<style>
body {
	background: #f8f8f8;
	padding: 60px 0;
	margin-left: 550px;
	margin-top: 200px;
	text-align: center;
}

#fmField>div {
	margin: 15px 0;
}

div>h2 {
	text-align: center;
}

.panel-title {
	margin-bottom: 100px;
}


</style>


<script type="text/javascript">
	
	function regForm(){
		location.href="./regForm.do";
	}
	
	
</script>

</head>
<body>
	<div class="container">
		<div class="col-md-6 col-md-offset-3 col-sm-8 col-sm-offset-2">
			<div class="panel panel-success">
				<div class="panel-heading">
					<div class="panel-title">
						<h2>Social Network Movie Service</h2>
					</div>
				</div>
				<div class="panel-body">
					<form action="./login.do" method="post" id="fmField" name="fmField" autocomplete="off">
						<div>
							<input type="text" class="form-control" name="mem_id"
								placeholder="xxxx@gmail.com" required="required" 
								autofocus id="userId">
						</div>
						<div>
							<input type="password" class="form-control" name="mem_pw"
								placeholder="Password" required="required" id="userPw">
						</div>
						<div>
							<input type="submit" class="form-control btn btn-primary"
								value="로그인" onclick="return checkForm();"> <input
								type="button" class="form-control btn btn-primary" value="회원가입"
								onclick="regForm()">
						</div>
					</form>
				</div>
			</div>
		</div>	
	</div>
	

	
	
	
	
	
	
</body>
</html>




