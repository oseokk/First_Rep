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
<script type="text/javascript">
	function Del() {
		/* var confirm = confirm("회원탈퇴하시겠습니까?");
 	alert(confirm); */
		if (confirm("회원탈퇴하시겠습니까?")) {
			return true;
		} else
			return false;
	}
	function goBack(){
		window.history.back();
	}
	
	function modify() {
		
		if(formChk()==true){
			
		alert("회원 정보가 수정되었습니다");
			
		}else{
		alert("정보 수정이 실패하였습니다.");
		}
		
	}
	function formChk(){
		
		if (document.getElementById("signPw").value == document.getElementById("signPwChk").value){
			
		}
		
	}
	
		
	
	
</script>

<div class="container">
	<%@include file="Header.jsp"%>
	<div><%@include file="mypage.jsp"%></div>
	<div class="maincontents_info">
		<div class="title_box">
			<div class="booking_title">
				<h2>나의정보수정</h2>
			</div>
		</div>
			<div class="booking_contents">
				<div class="booking_list_info">
					<form action="./modify.do" method="post" id="modify" onsubmit="return formChk()">
						<%
							for (MembershipDto dto : lists) {
						%>
						<div class="list_contents">
							<div class="float1_info">
								<div class="float1_list">
									<p>아이디</p>
									<p>현재 비밀번호</p>
									<p>변경 비밀번호</p>
									<p>비밀번호 확인</p>
									<p>닉네임</p>
									<p>생년월일</p>
									<p>휴대폰</p>
								</div>
								<div class="float1_list">
									<p><input type="text" name="mem_id" value="<%=dto.getMem_id()%>" readonly="readonly" style="width: 200px; background-color: #d5d5d5;"></p>
									<p><input type="password" name="nowPw" style="width: 200px" required="required"> </p>
									<p><input type="password" id="signPw" name="mem_pw" style="width: 200px" required="required"> </p>
									<p><input type="password" id="signPwChk" name="signPwChk" style="width: 200px" required="required"> </p>
									<p><input type="text" name="nickname" value="<%=dto.getNickname()%>" style="width: 200px" required="required"> </p>
									<p><input type="text" name="mem_bday" value="<%=dto.getMem_bday()%>" readonly="readonly" style="width: 200px; background-color: #d5d5d5; "></p> 
									<p><input type="text" name="mem_phone" value="<%=dto.getMem_phone()%>" style="width: 200px" required="required"></p>
								</div>
							</div>
						</div>
						<div>
							<div class="float2_info">
								<div class="float1_list">
									<p>잔여포인트</p>
									<p>선호장르1</p> 
									<p>선호장르2</p> 
									<p>선호장르3</p>
								</div>
								<div class="float1_list">
									<p><input type="text" name="mem_point" value="<%=dto.getMem_point()%>" readonly="readonly" style="width: 200px; background-color: #d5d5d5;"></p>  
									<p><input type="text" name="genre_1" value="<%=dto.getGenre_1()%>" style="width: 200px"></p>  
									<p><input type="text" name="genre_2" value="<%=dto.getGenre_2()%>" style="width: 200px"></p>  
									<p><input type="text" name="genre_3" value="<%=dto.getGenre_3()%>" style="width: 200px"></p> 
								</div>
							</div>
						</div>
						<%
							}
						%>
						<br>
						<div class="float3_info">
							<input type="submit" value="수정" onclick="modify()"
								class="float3_button2" style="width: 197px">
							<input type="button" value="취소" onclick="goBack()" id="but"
								class="float3_button1" style="width: 197px">
						</div>
					</form>
				</div>
			</div>
			<form action="./user_delete.do" method="post" onsubmit="return Del();" class="float3_info">
				<%
					for (MembershipDto dto : lists) {
				%>
				<%-- 		value="<%=dto.getMem_id()%>" --%>
				<input type="hidden" name="mem_id">
				<input type="submit" value="탈퇴하기" id="but" class="float3_button1" style="width: 400px">
				<%
					}
				%>
			</form>
	</div>
	<%@include file="Footer.jsp"%>
</div>






