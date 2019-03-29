<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>

<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<style type="text/css">

	#form{
	display: inline-block;	
	text-align: center;
	}
	
	table {
	text-align: left;
}



table.msgregForm {
   	display : inline-block;
    border-collapse: separate;
    border-spacing: 1px;
    text-align: center;
    line-height: 1.5;
    margin: 20px 10px;
}
table.msgregForm th {
    width: 155px;
    padding: 10px;
    font-weight: bold;
    vertical-align: top;
    color: black;
    background: #EFFBFB;
}
table.msgregForm td {
    width: 155px;
    padding: 10px;
    vertical-align: top;
    border-bottom: 1px solid #ccc;
    background: #eee;
}

#취소{
	background-color:#4eaeaa; 
   border-radius: 5px;
   font-family: Godic;
   color: #fff;
   border-color:#4eaeaa; 
}
#취소:hover{
	background-color: #dcedc2;
   border-color:#dcedc2; 
   color: black;

}
#보내기{
/* 	margin-left: 410px; */
	background-color:#4eaeaa; 
   border-radius: 5px;
   font-family: Godic;
   color: #fff;
   border-color:#4eaeaa; 
}
#보내기:hover{

	background-color: #dcedc2;
   border-color:#dcedc2; 
   color: black;


}




</style>
<title>메세지 전송 화면</title>
<script type="text/javascript">
	
	function returnView(){
		history.go(-1);
	}

	
</script>
	<div class="container">
<%@include file="Header.jsp"%>
	<div><%@include file="messagemenu.jsp"%></div>
<div id="form" class="maincontents" >
<h3>친구에게 메세지 보내기</h3>
<form action="./msg_send.do" method="post">
	<table class="msgregForm">
		<tr>
			<th>보내는 사람</th>
			<td style="text-align: left;">
				<b style="font-size: 16px">${lDto.mem_id}</b>
				<input type="hidden" id="mem_id" readonly="readonly"  name="mem_id" value="${lDto.mem_id}" style="width:350px;font-size: 15px; text-align: left: ;">
			</td>
		</tr>
		<tr>
			<th>받는 사람 ID</th>
			<td style="text-align: left;">
				<input type="text" id="frd_id" name="frd_id"  placeholder="아이디를 입력하세요." autocomplete="off" style="width:500px;font-size: 16px; float: left;">
			</td>
		</tr>
		<tr>
			<th>메세지 내용</th>
			<td>
				<input type="text" id="mcontent" name="mcontent"  placeholder="보낼 내용을 입력해주세요!" style="width:500px;height:300px;text-align: center;font-size: 14px;">
			</td>
		</tr>

				<tr>
			<th colspan="2">
				<input type="submit" value="보내기" id="보내기">
				<input type="button" value="취소" onclick="returnView()" id="취소">
			</th>
		</tr>
	</table>
	
	
</form>
</div>
<%@include file="Footer.jsp"%>
</div>







