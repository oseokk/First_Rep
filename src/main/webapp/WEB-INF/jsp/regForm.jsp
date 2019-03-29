<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>회원 등록 화면</title>
<script type="text/javascript"
	src="https://code.jquery.com/jquery-3.3.1.js"></script>
<style>
#fmField>div {
	margin: 15px 0;
}

div>h2 {
	text-align: center;
}

.panel-title {
	margin-bottom: 70px;
}

.panel-body {
	text-align: left;
	margin-bottom: 10;
}

#req {
	font-size: 9px;
	color: gray;
}

div>input {
	border-radius: 5px;
}
</style>
<script type="text/javascript">

	function duplicationId() {
		var title = "아이디중복확인";
		var url = "./duplicate.do";
		var option = "width=600px, height=300px";
		window.open(url, title, option);
	}

	function returnView() {
		location.href = "./main.do";
	}

	function chkPassword() {
		var pw1 = document.getElementById("mem_pw1").value;
		var pw2 = document.getElementById("mem_pw2").value;
		// 		alert(pw1);
		// 		alert(pw2);
		if (pw1 == "" || pw2 == "" || pw1 != pw2) {
			alert("비밀번호가 일치하지 않습니다");
			pw1 = "";
			pw2 = "";
			return false;
		} else {
			return true;
		}

	}
</script>

<div class="container">
	<%@include file="Header.jsp"%>
	<div style="display: inline-block;">
		<div class="col-md-6 col-md-offset-3 col-sm-8 col-sm-offset-2">
			<div class="panel panel-success">
				<div class="panel-heading">
					<div class="panel-title">
						<h2>
							<b>멤버쉽 신규가입</b>
						</h2>
					</div>
					<div class="panel-body">
						<form action="./regist.do" method="post" autocomplete="off"
							onsubmit="return chkPassword();">
							<div id="req">* 필수 입력란 입니다.</div>
							<div style="display: inline;">
								<b>*아이디(이메일)</b><br> <input type="text" id="id"
									name="mem_id" class="form-control" readonly="readonly"
									placeholder="xxxx@gmail.com" style="width: 400px; float: left;"><input
									type="button" value="중복확인" onclick="duplicationId()"
									style="width: 100px; height: 39px;">
							</div>
							<div>
								<b>*비밀번호</b><br> <input type="password" id="mem_pw1"
									name="mem_pw" placeholder="Password" style="width: 500px"
									required="required">
							</div>
							<div>
								<b>*비밀번호확인</b><br> <input type="password" id="mem_pw2"
									placeholder="Password Confirm" style="width: 500px"
									required="required">
							</div>
							<div>
								<b>*닉네임</b><br> <input type="text" id="nickname"
									name="nickname" placeholder="Nickname" style="width: 500px"
									required="required">
							</div>
							<div>
								<b>*생년월일</b><br> <input type="date" id="mem_bday"
									name="mem_bday" placeholder="생년월일" style="width: 500px"
									required="required">
							</div>
							<div>
								<b>*연락처</b><br> <input type="text" id="mem_phone"
									name="mem_phone" required="required"
									placeholder="010-xxxx-xxxx로 입력해주세요" style="width: 500px">
							</div>
							<div></div>
							<div>
								<select id="title" name="genre_1"
									style="width: 100px; float: left;">
									<option value="SF">SF</option>
									<option value="공포">공포</option>
									<option value="액션">액션</option>
									<option value="스릴">스릴</option>
									<option value="재난">재난</option>
									<option value="범죄">범죄</option>
									<option value="키즈">키즈</option>
									<option value="로맨스">로맨스</option>
									<option value="코미디">코미디</option>
								</select> <select id="title" name="genre_2"
									style="width: 100px; float: left;">
									<option value="SF">SF</option>
									<option value="공포">공포</option>
									<option value="액션">액션</option>
									<option value="스릴">스릴</option>
									<option value="재난">재난</option>
									<option value="범죄">범죄</option>
									<option value="키즈">키즈</option>
									<option value="로맨스">로맨스</option>
									<option value="코미디">코미디</option>
								</select> <select id="title" name="genre_3" style="width: 100px;">
									<option value="SF">SF</option>
									<option value="공포">공포</option>
									<option value="액션">액션</option>
									<option value="스릴">스릴</option>
									<option value="재난">재난</option>
									<option value="범죄">범죄</option>
									<option value="키즈">키즈</option>
									<option value="로맨스">로맨스</option>
									<option value="코미디">코미디</option>
								</select> Favorite Genre (영화 선호장르를 선택해주세요.)
							</div>
							<br>
							<div>
								<input type="submit" class="form-control btn btn-primary"
									style="width: 247px" value="회원가입"> <input type="button"
									value="취소" class="form-control btn btn-primary"
									style="width: 247px" onclick="returnView()">
							</div>
						</form>
					</div>
				</div>
			</div>
		</div>
	</div>
</div>

<%@include file="Footer.jsp"%>





