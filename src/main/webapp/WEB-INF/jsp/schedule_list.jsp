<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
   pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<style type="text/css">




</style>
<title>스케쥴</title>
<meta http-equiv="content-type" content="text/html; charset=utf-8">
<link rel="stylesheet" href="//code.jquery.com/ui/1.12.1/themes/base/jquery-ui.css">
<!--달력을 그리기 위한 css파일 -->
<link href="./fullcalendar/css/fullcalendar.css" rel="stylesheet" type="text/css">
<link href="./css/calendar.css" rel="stylesheet" type="text/css">
<script src="http://code.jquery.com/jquery-1.11.1.js"></script>
<!--datepicker를 사용하기 위한 라이브러리  -->
<script src="//ajax.googleapis.com/ajax/libs/jquery/1.7.1/jquery.js"></script>
<script src="//code.jquery.com/ui/1.8.18/jquery-ui.js"></script>

<script src="https://cdnjs.cloudflare.com/ajax/libs/moment.js/2.18.1/moment.js"></script>
<script src="./fullcalendar/js/fullcalendar.js" type="text/javascript"></script>
<script src="./js/calendar.js" type="text/javascript"></script>
<script type="text/javascript">



</script>

</head>
<body>
	<!--div안에 달력이 그려짐  -->
   <div id="calendar" style="width: 95%; display: inline-block;"></div>
</body>
</html>