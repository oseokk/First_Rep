<%@page import="java.util.List"%>
<%@page import="seok.yun.na.dtos.BookingDto"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>KOKOA</title>
<link href="css/singlePageTemplate.css" rel="stylesheet" type="text/css">
<!--The following script tag downloads a font from the Adobe Edge Web Fonts server for use within the web page. We recommend that you do not modify it.-->
<script>var __adobewebfontsappname__="dreamweaver"</script>
<script src="http://use.edgefonts.net/source-sans-pro:n2:default.js"
	type="text/javascript"></script>
<script type="text/javascript"
	src="http://code.jquery.com/jquery-latest.js"></script>
	
<script type="text/javascript">
	
	// 결제가 된 상태라면 결제하기 버튼을 숨기는 기능
	$(document).ready(function() {
		if (document.getElementById("tic_pay").value=='Y'){
			$("#paygo").hide();
		}
	});

	function allchk(val) {
		var obj = document.getElementsByName("chk");
		for (var i = 0; i < obj.length; i++) {
			obj[i].checked = val;
		}
	}

	$(function() {
		$("#bookingList").submit(function() {
			if ($('input:checkbox[name="chk"]:checked').length == 0) {
				alert("1개 이상 체크해 주세요");
				return false;
			}
		});
	});

	function ppay(val) {
		location.href = "./bookpaygo.do?booking_num="+val;
	}
	
</script>

<%
	List<BookingDto> lists = (List<BookingDto>) request.getAttribute("lists");
%>
<div class="container">
<%@include file="Header.jsp"%>
<%@include file="mypage.jsp"%>
<div class="maincontents">
	<input type="hidden" readonly="readonly" id="mem_id" name="mem_id" value="${lDto.mem_id}">
	<form action="./bookdelete.do" method="post" id="bookingList">
		<div class="title_box">
			<div class="booking_title">
<!-- 				<input type="checkbox" name="all" onclick="allchk(this.checked)"> -->
				<h2>예매내역</h2>
			</div>
			<div class="booking_button"><a href="./mapgo.do">
				<div class="con_button3">다른예매 계속하기</div></a>
			</div>
		</div>
		<div class="booking_contents">
			<!-- 예매내역 리스트 반복 -->
			
				<%
					if (lists == null || lists.size() == 0) {
				%>
				<p>예매한 내역이 없습니다</p>
				<%
					} else {
						for (BookingDto dto : lists) {
				%>
			<div class="booking_list">
				<div class="list_title">
					<h1 style="text-align: left;"><input type="checkbox" name="chk" value="<%=dto.getBooking_num()%>" style="display: inline-block; margin : -10px 10px 0 10px"><%=dto.getTitle()%></h1>
				</div>
				<div class="list_contents">
					<div class="float1">
						<div class="float1_list">
							<p>예매날짜</p>
							<p>영화관</p>
							<p>예매좌석</p>
							<p>예매번호</p>
						</div>
						<div class="float1_list">
							<p><%=dto.getPlay_date()%></p>
							<p><%=dto.getCin_name()%>&nbsp;<%=dto.getSub_title()%></p>
							<p><%=dto.getSeatrow()%><%=dto.getSeatcol()%>&nbsp;<input type="hidden" value="<%=dto.getSeat_cd()%>"></p>
							<p><%=dto.getBooking_num()%></p>
						</div>
					</div>
					<div class="float2">
						<div class="float1_list">
							<p>상영시간</p>
							<p>상영관</p>
							<p>결제여부</p>
							<p>&nbsp;&nbsp;&nbsp;&nbsp;</p>
						</div>
						<div class="float1_list">
							<p><%=dto.getStart_time()%>~<%=dto.getEnd_time()%></p>
							<p><%=dto.getPlayhall_name()%></p>
							<p><input type="hidden" id="tic_pay" value="<%=dto.getTic_pay()%>"><%=dto.getTic_pay()%></p>
							<p>&nbsp;&nbsp;&nbsp;&nbsp;</p>
						</div>
					</div>
					<div class="float3">
						<input class="float3_button2" type="button" value="결제하기" id="paygo" onclick="ppay('<%=dto.getBooking_num()%>')" > 
						<input class="float3_button1" type="submit" value="예매취소" style="margin-top:2px; ">
					</div>
				</div>
			</div>
					<%
						}
					}
					%>
			<!-- 예매내역 리스트 끝 -->
		</div>
	</form>
</div>
<%@include file="Footer.jsp"%>
</div>
