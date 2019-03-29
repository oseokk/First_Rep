<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>

<script type="text/javascript">
	function pagemove() {
		location.href = "${b.link}";
	}
</script>
<body>
	<center>
		<form action="movieList.do">
			<input type="text" name="keyword"> <input type="submit"
				value="검색">
		</form>
	</center>
	${movieList}
	<table>
		<tr>
			<td colspan="7" width="100%" bgcolor="pink"></td>
		</tr>

		<c:forEach items="${movieList}" var="b">
			<tr>
				<td width="200"><input type="button" onclick="pagemove()"
					value="상세정보"></td>
			</tr>


			<tr>
				<td rowspan="4">순위:${b.rank}</td>
				<td rowspan="2"><img src="${b.image}" onclick="pagemove()" width="300" height="300"></td>
			</tr>
			<tr>
				<td width="200">코드 : ${b.movieCd}</td>
				<td>영화명 : ${b.movieNm}</td>
			</tr>
			<tr>
				<td colspan="7" width="100%" bgcolor="pink"></td>
			</tr>
		</c:forEach>
	</table>
</body>
</html>


