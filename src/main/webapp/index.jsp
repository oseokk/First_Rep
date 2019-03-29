<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1>첫페이지로 이동하기</h1>
	<a href="./main.do">첫페이지</a>
	<a href="./booking.do?mem_id=member005">예매리스트</a>
	<a href="./mapgo.do">영화관찾기</a>
	<a href="./movie_like.do?moviecd=20178161">평점 리스트</a>
	<a href="./msg_list.do?mem_id=${lDto.mem_id}">전체 메세지</a>
	<a href="./msg_nlist.do?mem_id=${lDto.mem_id}">안읽은 메세지</a>
	<a href="./msg_slist.do?mem_id=${lDto.mem_id}">보낸 메시지</a>
	<a href="./social.do">social</a>
	<a href="./calendar.do">스케쥴</a>
	<a href="./ac.do">테스트</a>
	<a href="./sm.do">서치</a>
</body>
</html>