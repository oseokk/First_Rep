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
<title>영화관 리스트</title>

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
	function regForm(){
		location.href="./cinemaregForm.do";
	}
</script>

</head>
<%
// 	MembershipDto lDto 
// 	=  (MembershipDto)session.getAttribute("lDto");
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
<form action="./muldel.do" method="post" id="muldelForm" >
	<table class="table table-striped" style="text-align: center; border:1px solid #dddddd">
	<thead>
		<tr>
			<th style="background-color: #eeeeee; text-align: center;">
			<input type="checkbox" name="all" onclick="allchk(this.checked)">
			</th>
			<th style="background-color: #eeeeee; text-align: center;">영화관이름</th>	
			<th style="background-color: #eeeeee; text-align: center;">회사이름</th>	
			<th style="background-color: #eeeeee; text-align: center;">주소</th>	
			<th style="background-color: #eeeeee; text-align: center;">도로명주소</th>	
		</tr>
			</thead>
	 <tbody>
		<%
		if(lists == null ||lists.size() == 0){
			%>
			<tr><td colspan="4">등록된 영화관이 없습니다</td></tr>
			<%
		}else{
// 			for(int i=0; i<lists.size() ; i++){
// 				 BoardDto dto =  lists.get(i);
// 				 dto.getMem_id();
			for(CinemaDto dto : lists){
				%>
				<tr>
					<td><input type="checkbox" name="chk" value="<%=dto.getCin_cd()%>"> </td>
					<td><a href="./cin_Detail.do?cin_cd=<%=dto.getCin_cd()%>"><%=dto.getSub_title()%></a></td><td><%=dto.getTitle()%></td>
					<td><%=dto.getAddress()%></td><td><%=dto.getRoad_address()%></td>
				</tr>
				<%
			}
}
		%>
		<tr>
			<td colspan="5">
				<input type="submit" value="삭제" class="btn btn-primary pull-left">
<input type="button" value="영화관 등록" class="btn btn-primary pull-left" onclick="regForm()">
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



