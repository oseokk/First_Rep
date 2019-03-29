<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>관리자 페이지 입니다.</title>
</head>
<body>
	<div>
	아이디 :${lDto.mem_id} / 닉네임 :${lDto.nickname}<br>
	<p>관리자님 안녕하세요?</p>
	<a href="./logout.do">로그아웃</a>
	<a href="./schedulemanage.do">개봉일시사회추가/삭제</a>
	<a href="./cinemaList.do">영화관리스트</a>
	<a href="./notice_list.do">공지사항 게시판</a>
</div>



</body>
</html>