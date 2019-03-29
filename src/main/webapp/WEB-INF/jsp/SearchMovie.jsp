<%@page import="seok.yun.na.dtos.NoticeDto"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
   pageEncoding="UTF-8"%>
   <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>KOKOA</title>
<link href="css/singlePageTemplate.css" rel="stylesheet" type="text/css">
<!--The following script tag downloads a font from the Adobe Edge Web Fonts server for use within the web page. We recommend that you do not modify it.-->
<script>var __adobewebfontsappname__="dreamweaver"</script>
<script src="http://use.edgefonts.net/source-sans-pro:n2:default.js" type="text/javascript"></script>
<script type="text/javascript" src="http://code.jquery.com/jquery-latest.js"></script>
<script type="text/javascript">
function openWin(src){
   var url = "./movie_like.do?moviecd="+src;
   var title = "상세";
   var prop = "top=100px, left=400px, width=500px, "+
                     "height=500px, scrollbars=no, resizeable=no";
   window.open(url, title, prop);
}
$(document).ready(function login() {
    $("#login_btn")
          .click(
                function() {
                   var id = document.getElementById("loginId").value;
                   var pw = document.getElementById("userPw").value;
                   $.ajax({
                            type : "post",
                            url : "./login.do",
                            data : {
                               id : id,
                               pw : pw
                            },
                            async : false,
                            success : function(data) {
                               var member = data.lDto;
                               if(member==null){
                                  alert("아이디와 비밀번호를 확인해주세요.");
                               }else{
                               $("#login").empty();
                               document.getElementById("index_user").innerHTML = "<div class='panel-title'><h2>Social Network<br/> Movie Service</h2></div>"
                                     + member.nickname
                                     + "님 환영합니다"
                                     +"<form action='./myinfo.do'>"
                                     + "<input type='hidden' name='mem_id' value='"+member.mem_id+"'>"
                                     + "<div class='homebtn'><input type='submit' value='MYINFO' id='infobtn'>"
                                     + "<input type='button' value='LOGOUT' onclick='logout()' id='logoutbtn'></div></form>"
                                     + "<div><img src='./images/message.png' onclick='message()' style='width: 60px; height:60px;'></div>";
                               document.getElementById("social_id").value = member.mem_id;
                               }
                               },
                            error : function(e) {
                               alert("통신실패!!");
                            }
                         });
                });
});
</script>
<style type="text/css">
 .searchmovie{
    text-align: center;
    clear: both;
    width: 100%;
    height: 100%;
    background-color: #2c2c2c;
    padding-bottom: 0px;
    padding-top: 0px;
    margin-top: 0px;
    margin-bottom: 0px;

 }
 
.searchtable{
 width:700px;
 height:120px;
 margin : 20px 50px 20px 50px;
 background: white;
 text-align: justify;
 font-family: Godic;
}
.searchtable tr td{
 font-size: 10pt; 
 font-weight: bold;
 border-bottom: 1px solid #e8e8e8;
 border-collapse: collapse;   
 padding-left: 0px;
 padding-right: 10px;
}



</style>

<%
   List<NoticeDto> lists = (List<NoticeDto>)request.getAttribute("lists");
     MembershipDto Mdto = (MembershipDto) session.getAttribute("lDto");
%>
</head>
<body>
<!-- Main Container -->
<div class="container"> 
<%@include file = "Header.jsp"%> 
   <div class="main">
     <info class="user"> <%-- 화면 세션창 ajax 처리 --%> <%
    if (Mdto == null) {
 %> <!-- 로그인 아닐떄 -->
      <div id="login"><%@include file="home.jsp"%></div>
      <%
         } else {
      %> <!-- 로그인 일때 -->
      <div id="userpage"><%@include file="userPage.jsp"%></div>
      <%
         }
      %>
         <input type="hidden" id="social_id" name="id" value="${lDto.mem_id}">


      <div id="index_user"></div>

      </info>
   <div class="contents">
      
  
  <main id="searchmovie" class="searchmovie">
    <form action="msearch.do">
         <input type="text" name="keyword" placeholder="영화명 검색" autocomplete="off"> 
         <input type="submit" value="검색">
      </form>
  <table class="searchtable">
        <c:forEach items="${SR}" var ="sr">
              <tr>
             <td style="width: 120px; height: 120px;"><a href="javascript:openWin(${sr.moviecd});" title="${sr.movieNm}">
             <img src="${sr.image}" width="120" height="120">
            </a></td>
                <td>${sr.moviecd}</td>
                <td>${sr.movieNm}</td>
                <td>${sr.movieNmEn}</td>
                <td>${sr.prdtYear}<br>${sr.nationAlt}</td>
                <td>${sr.genreAlt}</td>
            </tr>
        </c:forEach>
    </table>





  </div>
   
  </main>
<%@include file = "Footer.jsp"%> 
</div>
<!-- Main Container Ends -->
</body>
</html>