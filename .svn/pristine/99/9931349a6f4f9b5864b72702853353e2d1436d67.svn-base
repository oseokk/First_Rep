<%@page import="seok.yun.na.dtos.BookingDto"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
	
<%

%>
<title>결제</title>
<script type="text/javascript">

	function returnView(){
// 		location.href="./booking.do";
		history.go(-1);
	}
	
// 	function checkValue(){
// 	    if(!document.id.value){
// 	        alert("아이디를 입력하세요.");
// 	        return false;
// 	    }
// 	    if(!document.pw.value){
// 	        alert("비밀번호를 입력하세요.");
// 	        return false;
// 	    }
// 	    if(!document.name.value){
// 	        alert("이름을 입력하세요.");
// 	        return false;
// 	    }
// 	    if(!document.email.value){
// 	        alert("이메일을 입력하세요.");
// 	        return false;
// 	    }
// 	}
</script>
<%
// 	String booking_num = (String)request.getAttribute("booking_num");
%>
<%@include file = "Header.jsp"%> 
	<h1>-결제하기-</h1>
	<form action="./bookpay.do" method="post" >
		<!-- 결제입력창 -->
		<table>
			<tr>
				<td colspan="5"><input type="hidden" readonly="readonly" name="booking_num"  value="${booking_num}"></td>
			</tr>		
			<tr>
				<th>차감포인트</th>
				<td colspan="4"><input type="text" id="id" name="mem_point" value=""></td>
			</tr>
			<tr>
				<th>가용포인트</th>
				<td colspan="4"><input type="text" id="id" name="mem_point"  readonly="readonly" value=""></td>
			</tr>
			<tr>
				<th>카드종류</th>
				<td colspan="4">
				<select id="area1" name="area1" title="시도" style="width: 144px;">
									<option value="">카드종류선택</option>
									<option>신용/체크카드</option>
									<option>기타</option>
									<option>기타</option>
				</select>		
				</td>
			</tr>
			<tr>
				<th>카드번호</th>
				<td><input type="text"  id="cardnumber1" ></td>
				<td><input type="text"  id="cardnumber2" ></td>
				<td><input type="text"  id="cardnumber3" ></td>
				<td><input type="text"  id="cardnumber4" ></td>
			</tr>
			<tr>
				<th>유효기간</th>
				<td colspan="2"><input type="text" id="nickname" name="nickname" placeholder="월"></td>
				<td colspan="2"><input type="text" id="nickname" name="nickname" placeholder="년"></td>
			</tr>
			<tr>
				<th>비밀번호</th>
				<td colspan="2"><input type="hidden" >
				<td colspan="2"><input type="password" id="mem_pw1" name="mem_pw" placeholder="앞 2자리">
				</td>
			</tr>
			<tr>
				<th>생년월일</th>
				<td colspan="4"><input type="date" id="mem_bday" name="mem_bday" placeholder="생년월일 6자리/사업자번호 10자리"></td>
			</tr>
<!-- 			<tr> -->
<!-- 				<th>할부</th> -->
<!-- 				<td colspan="4"><input type="text" id="mem_phone" name="mem_phone"> -->
<!-- 				</td> -->
<!-- 			</tr> -->
			<tr>
				<th>결제금액</th>
				<td colspan="4"><input type="text" id="mem_phone" name="mem_phone" readonly="readonly">
				</td>
			</tr>
			<tr>
				<th colspan="5"><input type="submit" value="결제">
				 <input type="button" value="취소" onclick="returnView()"></th>
			</tr>
		</table>
	</form>
<%@include file = "Footer.jsp"%> 







