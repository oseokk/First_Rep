<%@page import="seok.yun.na.dtos.MessageDto"%>
<%@page import="seok.yun.na.dtos.NoticeDto"%>
<%@page import="seok.yun.na.dtos.CinemaDto"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<style type="text/css">
table {
	display :inline-block;
/* 	background-color : white; */

	font-size: 18px;
	width: 750px;
}
.divtable{
	background-color : #fff;
	
}

#delbtn {
	float: left;
	margin-right: 40px;
	font-size: 13px;
}

#삭제{
	margin-right: 130px;
	background-color:#4eaeaa; 
   border-radius: 5px;
   font-family: Godic;
   color: #fff;
   border-color:#4eaeaa; 
}
#삭제:hover{
	background-color: #dcedc2;
   border-color:#dcedc2; 
   color: black;

}
#작성{
	margin-left: 410px;
	background-color:#4eaeaa; 
   border-radius: 5px;
   font-family: Godic;
   color: #fff;
   border-color:#4eaeaa; 
}
#작성:hover{

	background-color: #dcedc2;
   border-color:#dcedc2; 
   color: black;


}


table.msgslist {
   	display : inline-block;
    border-collapse: separate;
    border-spacing: 1px;
    text-align: center;
    line-height: 1.5;
    margin: 20px 10px;
}
table.msgslist th {
    width: 155px;
    padding: 10px;
    font-weight: bold;
    vertical-align: top;
    color: black;
    background: #EFFBFB;
}
table.msgslist td {
    width: 155px;
    padding: 10px;
    vertical-align: top;
    border-bottom: 1px solid #ccc;
    background: #eee;
}




</style>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>보낸 메시지</title>
<link href="css/singlePageTemplate.css" rel="stylesheet" type="text/css">
<script type="text/javascript" src="https://code.jquery.com/jquery-3.2.1.min.js"></script>
<script type="text/javascript">
	function allchk(val){
// 		alert(val);
		var obj =  document.getElementsByName("msg_seq");
		for(var i=0;i<obj.length;i++){
			obj[i].checked = val;
		}
	}
	
	//jQuery submit 처리 방식
	$(function(){
		$("#muldelForm").submit(function(){
			if($('input:checkbox[name="msg_seq"]:checked').length == 0){
				alert("하나이상 체크해 주세요");
				return false;
			}
		});
	});
	function msgregForm(){
		location.href="./msgregForm.do";
	}
</script>


<%
// 	MembershipDto lDto 
// 	=  (MembershipDto)session.getAttribute("lDto");
	List<MessageDto> lists = (List<MessageDto>)request.getAttribute("lists");
%>

<div class="divtable">
	<%@include file="Header.jsp"%>
	<div><%@include file="messagemenu.jsp"%></div>
	<div class="maincontents">
				<h3 style="text-align: center;">
							<b>${lDto.nickname}님의 보낸 메세지</b>
						</h3>
	<form action="./msg_sdelete.do" method="post" id="muldelForm" >
	<table class="msgslist" >
			<tr>
				<th><input type="checkbox" name="all"
					style="width: 15px;text-align: center;"
					onclick="allchk(this.checked)"></th>
				<th style="width: 150px; text-align: center;">받는 사람</th>
				<th style="width: 400px; text-align: center;">메시지 내용</th>
				<th style="text-align: center; width: 350px">보낸 날짜</th>
			</tr>
		<%
			for(MessageDto dto : lists){
				%>
				<tr>
					<td><input type="checkbox" name="msg_seq" value="<%=dto.getMsg_seq()%>"> </td>
					<td style="text-align: center;"><%=dto.getFrd_id()%></td>
					<td style="text-align: center;"><%=dto.getMcontent()%></td>
					<td style="text-align: center;"><%=dto.getMdate()%></td>
				</tr>
					<%
			}
		%>
	</table>
		<div>	<input type="hidden" name="mem_id" value="${lDto.mem_id}">
				<input type="submit" value="삭제" id="삭제" style="float: left;margin-left:24px;width: 70px; height: 30px;"> </div>
		<div><input type="button" value="메세지 작성" style="margin-left:400px;margin-bottom:10px;float: left;width: 150px; height: 30px;" onclick="msgregForm()" id="작성"></div>
</form>
	</div>
<%@include file="Footer.jsp"%>
</div>




