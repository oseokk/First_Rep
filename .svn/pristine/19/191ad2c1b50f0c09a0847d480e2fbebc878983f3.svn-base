<%@page import="java.util.List"%>
<%@page import="seok.yun.na.dtos.MembershipDto"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>KOKOA</title>
<link href="css/singlePageTemplate.css" rel="stylesheet" type="text/css">
<script type="text/javascript"
	src="https://code.jquery.com/jquery-3.3.1.js"></script>

<%
	List<MembershipDto> lists = (List<MembershipDto>) request.getAttribute("kDto");
%>

<div class="container">
	<%@include file="Header.jsp"%>
		<div><%@include file="mypage.jsp"%></div>
	<div class="maincontents_info">
		<div class="title_box">
			<div class="booking_title">
				<h2>나의정보조회</h2>
			</div>
		</div>
			<div class="booking_contents">
				<div class="booking_list_info">
					<%
								for (MembershipDto dto : lists) {
							%>
					<div class="list_contents">
						<div class="float1_info">
							<div class="float1_list">
								<p>아이디</p>
								<p>비밀번호</p>
								<p>닉네임</p>
								<p>생년월일</p>
								<p>휴대폰</p>
							</div>
							<div class="float1_list">
								<p><%=dto.getMem_id()%></p>
								<p><input type="hidden" value="<%=dto.getMem_pw()%>">&nbsp;&nbsp;&nbsp;</p>
								<p><%=dto.getNickname()%></p>
								<p><%=dto.getMem_bday()%></p>
								<p><%=dto.getMem_phone()%></p>
							</div>
						</div>
						<div class="float2_info">
							<div class="float1_list">
								<p>잔여포인트</p>
								<p>선호장르1</p>
								<p>선호장르2</p>
								<p>선호장르3</p>
							</div>
							<div class="float1_list">
								<p><%=dto.getMem_point()%></p>
								<p><%=dto.getGenre_1()%></p>
								<p><%=dto.getGenre_2()%></p>
								<p><%=dto.getGenre_3()%></p>
							</div>
						</div>
						<%
								}
							%>
					</div>
				</div>
			</div>

	</div>
<%@include file="Footer.jsp"%>
</div>






