<%@page import="seok.yun.na.dtos.NoticeDto"%>
<%@page import="seok.yun.na.dtos.CinemaDto"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<meta name="viewport" content="width=device-width",initial-scale="1">
<link rel="stylesheet" href="css/bootstrap.css">
<title>공지사항 보기</title>

<script type="text/javascript">
	function allchk(val){
// 		alert(val);
		var obj =  document.getElementsByName("chk");
		for(var i=0;i<obj.length;i++){
			obj[i].checked = val;
		}
	}
	
	//jQuery submit 처리 방식
	$(function(){
		$("#muldelForm").submit(function(){
			if($('input:checkbox[name="chk"]:checked').length == 0){
				alert("하나이상 체크해 주세요");
				return false;
			}
		});
	});
	function notice_addForm(){
		location.href="./notice_addForm.do";
	}
</script>

</head>
<%
// 	MembershipDto lDto 
// 	=  (MembershipDto)session.getAttribute("lDto");
	List<NoticeDto> lists = (List<NoticeDto>)request.getAttribute("lists");
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
   <a class="navbar-brand" href="adminMain.jsp">KOKOA SNMS</a>
 </div>
 <div class="collapse navbar-collapse" id="bs-example-navbar-collapse-1">
  <ul class="nav navbar-nav">
   <li><a href="./adminMain.do">메인</a><li>
   <li class="active"><a href="./notice_list.do">게시판</a><li>
    <li><a href="./cinemaList.do">영화관</a><li>
   <li><a href="./schedulemanage.do">스케줄</a><li>
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
<form action="./notice_delete.do" method="post" id="muldelForm" >
	<table class="table table-striped" style="text-align: center; border:1px solid #dddddd">
	<thead>
		<tr>
			<th style="background-color: #eeeeee; text-align: center;">
			<input type="checkbox" name="all" onclick="allchk(this.checked)"> 
			</th>
			<th style="background-color: #eeeeee; text-align: center;">글번호</th>			
			<th style="background-color: #eeeeee; text-align: center;">작성자</th>
			<th style="background-color: #eeeeee; text-align: center;">제목</th>	        
			<th style="background-color: #eeeeee; text-align: center;">작성일</th>
		</tr>
		</thead>
	 <tbody>		
		<%
for(NoticeDto dto : lists){
				%>
				<tr>
					<td><input type="checkbox" name="chk" value="<%=dto.getNtc_seq()%>"> </td>
					<td><%=dto.getNtc_seq()%></td><td><%=dto.getMem_id()%></td>
					<td><a href="./notice_Detail.do?ntc_seq=<%=dto.getNtc_seq()%>"><%=dto.getTitle()%></a></td>
					<td><%=dto.getRegdate()%></td>
				</tr>
				<%
			}
		%>
		<tr>
			<td colspan="6">
				<input type="submit" value="삭제" class="btn btn-primary pull-left">
<input type="button" value="공지사항 작성" class="btn btn-primary pull-left" onclick="notice_addForm()">
			</td>
		</tr>
		</tbody>
	</table>
</form>
</div>
</div>


<%-- 	<%=lDto%> --%>
<%-- 	${lDto} --%>
</body>
</html>



