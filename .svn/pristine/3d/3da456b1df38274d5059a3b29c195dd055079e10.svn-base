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
</script>

<body>
<table>
		<tr>
			<td colspan="7" width="100%" bgcolor="powderblue"></td>
		</tr>
		<c:forEach items="${dm}" var="MDto">


			<tr>
				<td rowspan="2">
				<a href="./movie_like.do?moviecd=${MDto.moviecd}" title="${MDto.movieNm}">
				<img src="${MDto.image}" width="300" height="300">
				</a></td>
				<td rowspan="2" width="800">${MDto.moviecd}</td>
				<td rowspan="2" width="800">${MDto.movieNm}</td>
				<td width="200">${b.rank}</td>
			</tr>
			<tr>
				<td rowspan="2" width="800">${MDto.openDt}</td>
				<td rowspan="4" width="800">${MDto.audicnt}</td>

			</tr>
			<tr>
				<%--                 <td colspan="7">영화정보:${b.description}</td> --%>
				<!--             </tr> -->
			<tr>
				<td colspan="7" width="100%" bgcolor="pink"></td>
			</tr>
		</c:forEach>
	</table>
	<%@include file = "Footer.jsp"%> 
</div>
</body>
</html>


