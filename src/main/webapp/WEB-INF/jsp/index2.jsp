<%@page import="seok.yun.na.dtos.NoticeDto"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
   pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>KOKOA</title>
<link href="css/singlePageTemplate.css" rel="stylesheet" type="text/css">
<!--The following script tag downloads a font from the Adobe Edge Web Fonts server for use within the web page. We recommend that you do not modify it.-->
<script>var __adobewebfontsappname__="dreamweaver"</script>
<script src="http://use.edgefonts.net/source-sans-pro:n2:default.js" type="text/javascript"></script>
<script type="text/javascript" src="http://code.jquery.com/jquery-latest.js"></script>
<script type="text/javascript">
   // Auto 롤링 아이디
   var rollingId;

   $(document)
         .ready(
               function() {

                  var $panel = $("#ul_panel");
                  var itemWidth = $panel.children().outerWidth(); // 아이템 가로 길이
                  var itemLength = $panel.children().length; // 아이템 수

                  function auto() {
                     // 2초마다 start 호출
                     rollingId = setInterval(function() {
                        start();
                     }, 3000);
                  }

                  function start() {

                     $panel.css("width", itemWidth * itemLength);
                     $panel.animate({
                        "left" : -itemWidth + "px"
                     }, function() {

                        // 첫번째 아이템을 마지막에 추가하기
                        $(this).append(
                              "<li>"
                                    + $(this).find("li:first")
                                          .html() + "</li>");

                        // 첫번째 아이템을 삭제하기
                        $(this).find("li:first").remove();

                        // 좌측 패널 수치 초기화
                        $(this).css("left", 0);
                     });
                  }

                  auto();

                  // 배너 마우스 오버 이벤트
                  $panel.mouseover(function() {
                     clearInterval(rollingId);
                  });

                  // 배너 마우스 아웃 이벤트
                  $panel.mouseout(function() {
                     auto();
                  });

                  // 이전 이벤트
                  $("#prev").on("click", prev);

                  $("#prev").mouseover(function(e) {
                     clearInterval(rollingId);
                  });

                  $("#prev").mouseout(auto);

                  // 다음 이벤트
                  $("#next").on("click", next);

                  $("#next").mouseover(function(e) {
                     clearInterval(rollingId);
                  });

                  $("#next").mouseout(auto);

                  // 이전 이벤트 실행
                  function prev(e) {
                     $panel.css("left", -itemWidth);
                     $panel.prepend("<li>"
                           + $panel.find("li:last").html() + "</li>");
                     $panel.animate({
                        "left" : "0px"
                     }, function() {
                        $(this).find("li:last").remove();
                     });
                  }

                  // 다음 이벤트 실행
                  function next(e) {
                     $panel.animate({
                        "left" : -itemWidth + "px"
                     }, function() {
                        $(this).append(
                              "<li>"
                                    + $(this).find("li:first")
                                          .html() + "</li>");
                        $(this).find("li:first").remove();
                        $(this).css("left", 0);
                     });
                  }

                  // 일별박스오피스 버튼 클릭시

                  $("#score")
                        .click(
                              function() {
                                 $(this)
                                       .css(
                                             {
                                                'text-shadow' : '#1e4158 0 1px 0',
                                                'border' : '1px solid #0a3c59',
                                                'background' : '#65a9d7',
                                                'background' : '-webkit-gradient(linear, left top, left bottom, from(#6dc4ff), to(#326180))',
                                                'background-image' : '-ms-linear-gradient(top, #3e779d 0%, #65a9d7 100%)',
                                                'color' : '#fff'
                                             });
                                 $("#weekbox").css({
                                    'background' : '',
                                    'background-image' : '',
                                    'color' : '',
                                    'border' : ''
                                 });
                                 $("#daybox").css({
                                    'background' : '',
                                    'background-image' : '',
                                    'color' : '',
                                    'border' : ''
                                 });
                              });

                  $("#daybox")
                        .click(
                              function() {
                                 $(this)
                                       .css(
                                             {
                                                'text-shadow' : '#1e4158 0 1px 0',
                                                'border' : '1px solid #0a3c59',
                                                'background' : '#65a9d7',
                                                'background' : '-webkit-gradient(linear, left top, left bottom, from(#6dc4ff), to(#326180))',
                                                'background-image' : '-ms-linear-gradient(top, #3e779d 0%, #65a9d7 100%)',
                                                'color' : '#fff'
                                             });
                                 $("#weekbox").css({
                                    'background' : '',
                                    'background-image' : '',
                                    'color' : '',
                                    'border' : ''
                                 });
                                 $("#score").css({
                                    'background' : '',
                                    'background-image' : '',
                                    'color' : '',
                                    'border' : ''
                                 });
                                 fn_dayboxListAjax();
                              });

                  // 주간박스오피스 버튼 클릭시 
                  $("#weekbox")
                        .click(
                              function() {
                                 $(this)
                                       .css(
                                             {
                                                'text-shadow' : '#1e4158 0 1px 0',
                                                'border' : '1px solid #0a3c59',
                                                'background' : '#65a9d7',
                                                'background' : '-webkit-gradient(linear, left top, left bottom, from(#6dc4ff), to(#326180))',
                                                'background-image' : '-ms-linear-gradient(top, #3e779d 0%, #65a9d7 100%)',
                                                'color' : '#fff'
                                             });
                                 $("#daybox").css({
                                    'background' : '',
                                    'background-image' : '',
                                    'color' : '',
                                    'border' : ''
                                 });
                                 $("#score").css({
                                    'background' : '',
                                    'background-image' : '',
                                    'color' : '',
                                    'border' : ''
                                 });
                                 fn_weekboxListAjax();
                              });

                  //공지사항 아코디언 메뉴
                  $("table>.ncontent").hide();
                  $("table>.ncontent").siblings(".ncontent").hide();
                  $("table>.ntitle").addClass("active");

                  $(".ntitle")
                        .click(
                              function() {
                                 $(this).next().stop().slideToggle();
                                 $(this).next()
                                       .siblings(".ncontent")
                                       .stop().slideUp();
                                 $(this).toggleClass("active");

                                 $(this)
                                       .siblings(".ntitle")
                                       .each(
                                             function() {
                                                if ($(this)
                                                      .hasClass(
                                                            "active")) {
                                                   $(this)
                                                         .removeClass(
                                                               "active");
                                                }
                                             });

                              });
               });

   //일별 박스오피스
   function fn_dayboxListAjax() {
      $
            .ajax({
               method : "get", // 서버에 전송하는 방식
               url : "./dayboxListAjax.do",
               async : true, //비동기식(기본:비동식, 동기식 false)
               success : function(data) { // 서버통신 성공했을때 
                  var list = data.dm;
                  var html = "";
                  $("#ul_panel").empty();
                  for (var i = 0; i < list.length; i++) {
                     var str = list[i];
                     html += "<li><a href='javascript:openWin("
                           + str.moviecd
                           + ")'>"
                           + "<img src="+str.image+" title="+str.movieNm+"></a><br/>" 
                           + "<input type='text' id='movieNm' value='"+str.movieNm
                           +   "' class='rollingname' readonly='readonly'></li>";
                  }
                  $("#ul_panel").append(html);
               },
               // success가 실패 했을때
               error : function(e) {
                  alert("서버통신에 실패함");
               }
            }); // ajax
   }
   //주간 박스오피스
   function fn_weekboxListAjax() {
      $
            .ajax({
               method : "get", // 서버에 전송하는 방식
               url : "./weekboxListAjax.do",
               async : true, //비동기식(기본:비동식, 동기식 false)
               success : function(data) { // 서버통신 성공했을때 
                  var list = data.dm;
                  var html = "";
                  $("#ul_panel").empty();
                  for (var i = 0; i < list.length; i++) {
                     var str = list[i];
                     html += "<li><a href='javascript:openWin("
                           + str.moviecd
                           + ")'>"
                           + "<img src="+str.image+" title="+str.movieNm+"></a><br/>" 
                           + "<input type='text' id='movieNm' value='"+str.movieNm
                           +   "' class='rollingname' readonly='readonly'></li>";
                  }
                  $("#ul_panel").append(html);
               },
               // success가 실패 했을때
               error : function(e) {
                  alert("서버통신에 실패함");
               }
            }); // ajax
   }
   //영화 상세 팝업
   function openWin(cd) {
      var url = "./movie_like.do?moviecd=" + cd;
      var title = "상세";
      var prop = "top=100px, left=400px, width=470px, "
            + "height=500px, scrollbars=no, resizeable=no";
      window.open(url, title, prop);
   }
   //로그아웃
   function logout() {
      location.href = "./logout.do";
   }
   //소셜메뉴가기
   function social(mem_id) {
      location.href = "./social.do?id=" + mem_id;
   }
   //메시지 창 가기
   function message(mem_id) {
      location.href = "./message.do?id="+mem_id;
   }
</script>
<script type="text/javascript">
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
                  $("#updown").click(function(){
                  	var a = $("#updown").val();
                  	if($("#updown").val()=="▼"){
                  		$(".schedule").slideDown();
                  		$("#updown").val("▲");
                  	}else{
                  		$(".schedule").slideUp();
                  		$("#updown").val("▼");
                  	}
                  	
                  });
                  
               });

   function socialgo() {
      var id = document.getElementById("social_id").value;
      if (id === "") {
         alert("로그인을 해주세요");
      } else {
         location.href="./social.do?id="+id;
      }

   }
   
</script>

<style type="text/css">
.rolling_panel {
   position: relative;
   width: 600px;
   height: 240px;
   margin-left: 100px;
   padding: 0;
   overflow: hidden;
   align-content: center;
}

.rolling_panel ul {
   width: 600;
   position: absolute;
   margin: 3px;
   padding: 0;
   list-style: none;
}

.rolling_panel ul li {
   float: left;
   width: 200px;
   height: 200px;
   padding: 5px;
}

.rolling_panel ul li a img {
   width: 150px;
   height: 200px;
}

.ul_panel {
   width: 600px;
}

.accordion {
   width: 800px;
   border-bottom: 1px solid #c4c4c4;
   margin: 10px auto;
    font-family:GODIC;
   padding: 7px 15px;
   border-bottom: none;
   cursor: pointer;
   color: #fff;
    background-repeat: no-repeat;
   background-position: right -51px;
}

/* h3요소에 마우스 커서를 올리면 배경색이
 #e3e2e2로 바뀌고, 마우스커서가 나가면 원상태로 복귀되도록 설정 */
.ntitle:hover {
   background-color: #B3B3B3;
}
/* h3요소에 class 이름이 active인 
요소에 대한 배경이미지 위치를 right 5px이 되도록 설정*/
.active {
   background-position: right 5px;
}

/* p요소들에 대해 배경색 #f7f7f7 , 
외부 여백 상하좌우 0px, margin
내부여백 상 10px 좌우 15px 하 10px , padding 
테두리 실선 1px 색상  #c4c4c4 로 설정 border */
.ntitle {
   padding: 10px 15px 10px 15px;
background-color: #4c7c83;
}

.ncontent {
   background-color: #ffffff;
   margin: 0px;
   padding: 10px 15px 10px 15px;
   border: 1px solid #c4c4c4;
   text-align: left;
   color:black;
}

#prev {
   float: left;
   margin-top: 10px;
}

#next {
   float: right;
   margin-top: 10px;
}

.rollingname {
   width: 150px;
   text-align: center;
   background-color: #151515;
   font-weight: bold;
   color: #ebebeb;
   border-color: black;
}

.bbox {
   width: 150px;
   height: 30px;
   border: 1px solid #595959;
   background: #dcedc2;
   background: -webkit-gradient(linear, left top, left bottom, from(#666566),
      to(#2e2e2e));
   background: -webkit-linear-gradient(top, #666566, #2e2e2e);
   background: -moz-linear-gradient(top, #666566, #2e2e2e);
   background: -ms-linear-gradient(top, #666566, #2e2e2e);
   background: -o-linear-gradient(top, #666566, #2e2e2e);
   background-image: -ms-linear-gradient(top, #666566 0%, #2e2e2e 100%);
   padding: 0px 21px;
   -webkit-border-radius: 6px;
   -moz-border-radius: 6px;
   border-radius: 6px;
   -webkit-box-shadow: rgba(255, 255, 255, 0.4) 0 1px 0, inset
      rgba(255, 255, 255, 0.4) 0 1px 0;
   -moz-box-shadow: rgba(255, 255, 255, 0.4) 0 1px 0, inset
      rgba(255, 255, 255, 0.4) 0 1px 0;
   box-shadow: rgba(255, 255, 255, 0.4) 0 1px 0, inset
      rgba(255, 255, 255, 0.4) 0 1px 0;
   /* text-shadow: #2e2e2e 0 1px 0; */
   color: gray;
   font-size: 14px;
   font-weight: bold;
   text-decoration: none;
   vertical-align: middle;
   font-family: Godic;
}

.bbox:hover {
   border: 1px solid #0a3c59;
   text-shadow: #1e4158 0 1px 0;
   background: #F0FD01;
   background: -webkit-gradient(linear, left top, left bottom, from(#F0FA3C),
      to(#F0FD01));
   background: -webkit-linear-gradient(top, #F0FA3C, #F0FD01);
   background: -moz-linear-gradient(top, #F0FA3C, #F0FD01);
   background: -ms-linear-gradient(top, #F0FA3C, #F0FD01);
   background: -o-linear-gradient(top, #F0FA3C, #F0FD01);
   background-image: -ms-linear-gradient(top, #F0FA3C 0%, #F0FD01 100%);
   color: #2a363b;
}

.bbox:active {
   text-shadow: #1e4158 0 1px 0;
   border: 1px solid #0a3c59;
   background: #65a9d7;
   background: -webkit-gradient(linear, left top, left bottom, from(#3e779d),
      to(#326180));
   background: -webkit-linear-gradient(top, #3e779d, #65a9d7);
   background: -moz-linear-gradient(top, #3e779d, #65a9d7);
   background: -ms-linear-gradient(top, #3e779d, #65a9d7);
   background: -o-linear-gradient(top, #3e779d, #65a9d7);
   background-image: -ms-linear-gradient(top, #3e779d 0%, #65a9d7 100%);
   color: #fff;
}

.bbox:visited {
   border: 1px solid #0a3c59;
   text-shadow: #1e4158 0 1px 0;
   background: #F0FD01;
   background: -webkit-gradient(linear, left top, left bottom, from(#F0FA3C),
      to(#F0FD01));
   background: -webkit-linear-gradient(top, #F0FA3C, #F0FD01);
   background: -moz-linear-gradient(top, #F0FA3C, #F0FD01);
   background: -ms-linear-gradient(top, #F0FA3C, #F0FD01);
   background: -o-linear-gradient(top, #F0FA3C, #F0FD01);
   background-image: -ms-linear-gradient(top, #F0FA3C 0%, #F0FD01 100%);
   color: #2a363b;
}

.btns {
   width: 30px;
   height: 200px;
   border: 1px solid #2f9599;
   background: #2f9599;
   color: #ffffff;
   font-size: 14px;
   font-family: helvetica, serif;
   text-decoration: none;
   vertical-align: middle;
   margin-top: 10px;
}

.btns:active {
   border: 1px solid #547980;
   background: #547980;
   color: #ffffff;
}
@CHARSET "UTF-8";
@font-face { 
   font-family: 'Hypnotica'; 
   src: url(./fonts/Hypnotica.ttf); 
   format('truetype'); 
   }
div>h2 {
   text-align: center;
   font-family: 'Hypnotica'; 
   font-size: 25px;
}

.panel-title {
   margin-bottom: 50px;
}


.ssession{
text-align: center;
    width: 100%;
    margin-left: auto;
    margin-right: auto;
    background-color: #fff;
    
}
#infobtn{
   background-color: #4c7c83;
   border-radius: 5px;
   font-family: Godic;
   color: #fff; 
   border-color:#4c7c83;

}
#logoutbtn{
   background-color: #4c7c83;
   border-radius: 5px;
   font-family: Godic;
   color: #fff;
   border-color:#4c7c83; 
}
#infobtn:hover{
 background-color: #dcedc2;
 border-color:#dcedc2; 
 color: black;
}
#logoutbtn:hover{
   background-color: #dcedc2;
   border-color:#dcedc2; 
   color: black;
}
.homebtn{
margin-top: 10px;
}
}
</style>
<%
   List<NoticeDto> lists = (List<NoticeDto>) request.getAttribute("lists");
   MembershipDto Mdto = (MembershipDto) session.getAttribute("lDto");
%>
<!-- Main Container -->
<div class="container">
   <%@include file="Header.jsp"%>
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


         <main id="gallery" class="gallery">
         <form action="msearch.do">
            <input type="text" name="keyword" placeholder="영화명 검색"
               autocomplete="off" required="required"> <input type="submit" value="검색">
         </form>
         <a href="javascript:void(0)" id="prev"><input type="button"
            class="btns" value="◀"></a> <a href="javascript:void(0)"
            id="next"><input type="button" class="btns" value="▶"></a>
         <div class="rolling_panel">
            <ul id="ul_panel">
               <c:forEach items="${dm}" var="MDto">
                  <li><a href="javascript:openWin(${MDto.moviecd});"><img
                        src="${MDto.image}" title="${MDto.movieNm}"></a><br /> 
                        <input type="text" id="movieNm" value="${MDto.movieNm}"
                     class="rollingname" readonly="readonly"></li>
               </c:forEach>
            </ul>
         </div>

         </main>

         <div class="gallery_menu">
          <input
               type="button" id='daybox' class="bbox" value="일별박스오피스"> <input
               type="button" id='weekbox' class="bbox" value="주간박스오피스">
         </div>




         <div class="board">
            <p>공지사항</p>
            <div class="notice">
               <table class="accordion">
                  <%
                     for (int i = 0; i < 3; i++) {
                        NoticeDto dto = lists.get(i);
                  %>
                  <tr class="ntitle">
                     <td><%=dto.getTitle()%></td>
                     <td><%=dto.getRegdate()%></td>
                  </tr>
                  <tr class="ncontent" rowspan="2" style="display: none">
                     <td colspan="2"><%=dto.getContent()%></td>
                  </tr>
                  <%
                     }
                  %>
               </table>
            </div>
            <p>스케쥴</p>
            <input type="button" id="updown" value="▼">
            <div class="schedule" style="display: none">
            <%@ include file="schedule_list.jsp" %>
            </div>
         </div>
      </div>
   </div>
   <%@include file="Footer.jsp"%>
</div>