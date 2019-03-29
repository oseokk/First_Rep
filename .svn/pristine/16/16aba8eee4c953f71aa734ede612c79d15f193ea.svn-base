<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title></title>
<script type="text/javascript"
	src="https://code.jquery.com/jquery-3.3.1.js"></script>
<script
	src="//maxcdn.bootstrapcdn.com/bootstrap/latest/js/bootstrap.min.js"></script>
<link
	href="//maxcdn.bootstrapcdn.com/bootstrap/latest/css/bootstrap.min.css"
	rel="stylesheet">
	
<script type="text/javascript">
$(document).ready(function(){
	document.getElementById("btnUserId").style.display="none";
});

//중복검사
 function checkId(){
	 var doc = document.getElementById("id").value.trim();
	 if(doc==""){
		 alert("아이디를 입력하세요");
	 }else{
	$.ajax({
		type : "post",
		url : "./duplicateAjax.do",
		data : "chkId="+doc,
		async : true,
		success : function(msg){
// 			alert(msg.isc);
			if(msg.isc == true){
				document.getElementById("msg").innerHTML = "사용 가능한 아이디입니다."
				document.getElementById("btnUserId").style.display="block";
				 document.getElementById("btnConfirm").style.display="block";
				 document.getElementById("comment").style.display="none";
			}else{
				document.getElementById("msg").innerHTML = "이미 사용중인 아이디입니다."
				document.getElementById("btnUserId").style.display="none";
				 document.getElementById("btnConfirm").style.display="block";
				 document.getElementById("comment").style.display="none";
			}
		}
	});
	 document.getElementById("btnConfirm").style.display="none";
	 }
 }
 
 function useId(){
	 var doc = document.getElementById("id").value;
// 	 alert(doc);
	window.opener.document.getElementById("id").value = doc;
// 	window.opener.document.getElementById("name").focus();
	window.close();
 }
 
</script>
<style type="text/css">
#regist {
	border: 1px solid black;
	background: pink;
	position: absolute;
	top: 100px;
	left: 200px;
	display: none;
	z-index: 5;
}

#msg {
	font-size: 14px;
	font-weight: 1px;
}

body {
	background: #f8f8f8;
	margin-top: 100px;
	text-align: center;
}

#div {
	margin-left: 260px;
}

.form-control {
	margin-bottom: 0px;
	/*      margin:auto; */
	margin-left: 150px;
}

#id {
	margin-right: 10px;
}
</style>
</head>
<body>
	<div>
		<input type="text" id="id" class="form-control" autocomplete="off"
			placeholder="ID" style="width: 250px; float: left;">
		<input type="button" value="확인" onclick="checkId()" id="btnConfirm"
			class="form-control" style="width: 80px"> 
			<input type="button" id="btnUserId" value="사용하기" class="form-control"
			onclick="useId()" style="width: 100px"> <br>
		<b style="width: 350px;" id="comment">로그인에 사용하실 ID를 입력해주세요!</b>

	</div>
	<br>
	<div id="msg"></div>
	<br>
	<div id=div></div>

</body>
</html>




