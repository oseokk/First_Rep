<%@ page language="java" contentType="text/html; charset=UTF-8"
   pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link rel="stylesheet" href="css/bootstrap.css">
<meta name="viewport" content="width=device-width" ,initial-scale="1">
<title>관리자 스케쥴 관리</title>
<script type="text/javascript">
   function returnView() {
      location.href = "./notice_list.do";
   }
</script>
</head>
<body>
   <nav class="navbar navbar-default">
      <div class="navbar-header">
         <button type="button" class="navbar-toggle collapsed"
            data-toggle="collapse" data-target="#bs-example-navbar-collapse-1"
            aria-expanded="false">
            <span class="icon-bar"></span> <span class="icon-bar"></span> <span
               class="icon-bar"></span>
         </button>
         <a class="navbar-brand" href="adminMain.jsp">KOKOA SNMS</a>
      </div>
      <div class="collapse navbar-collapse"
         id="bs-example-navbar-collapse-1">
         <ul class="nav navbar-nav">
            <li><a href="./adminMain.do">메인</a>
            <li>
            <li><a href="./notice_list.do">게시판</a>
            <li>
            <li><a href="./cinemaList.do">영화관</a>
            <li>
            <li class="active"><a href="./schedulemanage.do">스케줄</a>
            <li>
         </ul>
         <ul class="nav navbar-nav navbar-right">
            <li class="dropdown"><a href="#" class="dropdown-toggle"
               data-toggle="dropdown" role="button" aria-haspopup="true"
               aria-expanded="false">관리메뉴<span class="caret"></span></a>
               <ul class="dropdown-menu">
                  <li><a href="./logout.do">로그아웃</a></li>
               </ul></li>
         </ul>
      </div>
   </nav>


   <div class="container">
      <div class="row">
   <h3>개봉일추가하기</h3>
         <form action="./schedule_add.do" method="post">
            <table class="table table-striped"
               style="text-align: center; border: 1px solid #dddddd">
               <tr>
                  <th style="background-color: #eeeeee; text-align: center;">영화명</th>
                  <td><input type="text" class="form-control" name="scheduleContent"></td>
               </tr>
               <tr>
                  <th style="background-color: #eeeeee; text-align: center;">개봉일 시작일</th>
                  <td><input type="date" class="form-control" name="startDate"></td>
               <tr>
                  <th style="background-color: #eeeeee; text-align: center;">개봉일 마지막일</th>
                  <td><input type="date" class="form-control" name="endDate"></td>
               </tr>

               <tr>
                  <th colspan="2"><input type="submit" class="btn btn-primary pull-right" value="추가"></th>
               </tr>
            </table>
         </form>



         <h3>영화관개봉일삭제하기</h3>
         <form action="./schedule_del.do" method="post">
            <table class="table table-striped"
               style="text-align: center; border: 1px solid #dddddd">
               <tr>
                  <th style="background-color: #eeeeee; text-align: center;">영화명</th>
                  <td><input type="text" class="form-control" name="scheduleContent"></td>
               <tr>
                  <th colspan="2"><input type="submit" class="btn btn-primary pull-right" value="삭제"></th>
               </tr>
            </table>
         </form>
         </div>
         </div>
</body>
</html>