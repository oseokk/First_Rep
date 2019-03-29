<%@page import="seok.yun.na.dtos.SCMovieDto"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<!DOCTYPE html>

<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>★★★★★★social Main★★★★★★</title>
<link href="css/singlePageTemplate.css" rel="stylesheet" type="text/css">
<link href="css/social.css" rel="stylesheet" type="text/css">
<!--The following script tag downloads a font from the Adobe Edge Web Fonts server for use within the web page. We recommend that you do not modify it.-->
<script>var __adobewebfontsappname__="dreamweaver"</script>
<script src="http://use.edgefonts.net/source-sans-pro:n2:default.js" type="text/javascript"></script>
<script type="text/javascript" src="http://code.jquery.com/jquery-latest.js"></script>

<style type="text/css">
</style>
<script type="text/javascript" src="http://code.jquery.com/jquery-latest.js"></script>
<script type="text/javascript" src="https://code.jquery.com/jquery-3.2.1.min.js"></script>

<script type="text/javascript">
/* --watched_movie-- Ajax 처리 */
var a = 0;
function nextMovie(mem_id){
	var id = mem_id;
	a++;
	$.ajax({
		type : "post",
		url : "./newspeedAjax.do",
		data : {id : id, a : a},
		async : false,
		success : function(data){
			var newDate = data.changeDate;
			var newList = data.changeMovie;
			var newScore = data.changeScore;
			
  			document.getElementById("change_img").src = newList[a].image;
  			document.getElementById("changeOpen_img").href = "javascript:openWin("+newList[a].moviecd+")";
  			document.getElementById("changeOpen_name").href = "javascript:openWin("+newList[a].moviecd+")";
			document.getElementById("watched_name").innerHTML = newList[a].movieNm;
			document.getElementById("watched_date").innerHTML = newDate[a].booking_date;
			$("#watched_tbody").empty();
			for(var i=0; i<newScore.length; i++){
				var str=newScore[i];
				var star="";
				switch (str.score) {
				case 2:
					star="★☆☆☆☆ 2";
					break;
				case 4:
					star="★★☆☆☆ 4";
					break;
				case 6:
					star="★★★☆☆ 6";
					break;
				case 8:
					star="★★★★☆ 8";
					break;
				case 10:
					star="★★★★★ 10";
					break;

				default:
					break;
				}
				$("#watched_tbody").append(
						"<tr>" +
						"<td class='td1'>" + str.mem_id + 
						"</td>" +                  
						"<td class='td2'>" + star +  
						"</td>" +                  
						"<td class='td3'>" + str.scomment +  
						"</td>" + 
						"</tr>"	);
			}
		},
        error: function(e) {
        	alert("마지막 영화입니다.");
        	a--;
        }
	});
}
function beforeMovie(mem_id){
	var id = mem_id;
	a--;
	$.ajax({
		type : "post",
		url : "./newspeedAjax.do",
		data : {id : id, a : a},
		async : false,
		success : function(data){
			var newDate = data.changeDate;
			var newList = data.changeMovie;
			var newScore = data.changeScore;
  			document.getElementById("change_img").src = newList[a].image;
  			document.getElementById("changeOpen_img").href = "javascript:openWin("+newList[a].moviecd+")";
  			document.getElementById("changeOpen_name").href = "javascript:openWin("+newList[a].moviecd+")";
			document.getElementById("watched_name").innerHTML = newList[a].movieNm;
			document.getElementById("watched_date").innerHTML = newDate[a].booking_date;
			$("#watched_tbody").empty();
			for(var i=0; i<newScore.length; i++){
				var str=newScore[i];
				var star="";
				switch (str.score) {
				case 2:
					star="★☆☆☆☆ 2";
					break;
				case 4:
					star="★★☆☆☆ 4";
					break;
				case 6:
					star="★★★☆☆ 6";
					break;
				case 8:
					star="★★★★☆ 8";
					break;
				case 10:
					star="★★★★★ 10";
					break;

				default:
					break;
				}
				$("#watched_tbody").append(
						"<tr>" +
						"<td class='td1'>" + str.mem_id + 
						"</td>" +                  
						"<td class='td2'>" + star +  
						"</td>" +                  
						"<td class='td3'>" + str.scomment +  
						"</td>" + 
						"</tr>"	);
			}
		},
        error: function(e) {
        	alert("첫번째 영화입니다.");
        	a++;
        }
	});
}
function frd_movie(mem_id){
	var id=mem_id;
	$.ajax({
		type : "post",
		url : "./friendAjax.do",
		data : {id : id},
		async : false,
		success : function(data){
			var gr = data.listsGenre;
			var date = data.bookMyMovie; //날짜와 코드
			var img = data.viewMovie; //이미지와 이름
			
			$("#frd_social").css("display","block");
			var aa = "<img src='./images/squarex.png' class='img_btn_size' id='frd_x' onclick='exit()'>"+ id+"님의 선호장르<br> : "+gr[0].genre_1 + gr[0].genre_2 + gr[0].genre_3 + "<br>"
			+"<div id='frd_movie'><div id='frd_box'>";
			for(var i=0; i<img.length; i++){
				var d=date[i];
				var a=img[i];
				aa=aa+"<div class='frd_content'><a href='javascript:openWin("+d.moviecd+")'><img src='"+a.image+"' width='150px' height='200px' margin-top='0px'><br>"+
				a.movieNm+"</a><br>관람일 : "+d.booking_date+"<br></div>";
			}
			aa+="</div><img src='./images/left.png' class='img_btn_size' id='frd_left_btn' onclick='frd_left()'>"+
			"<img src='./images/right.png' class='img_btn_size' id='frd_right_btn' onclick='frd_right()')></div>";
			document.getElementById("frd_social").innerHTML=aa;
		},
        error: function(e) {
        	alert("통신실패!!");
        }
	});
}

</script>
<script type="text/javascript">
$(document).ready(function() {
    $("#fav_right_btn").click(function() {
            $("#fav_box>div").first().appendTo("#fav_box");
    });
    $("#fav_left_btn").click(function() {
            $("#fav_box>div").last().prependTo("#fav_box");
    });
    $(".fav_content").mouseover(function(){
    	$(this).children().css("display","block");
    	
    });
    $(".fav_content").mouseout(function(){
    	$(".fav_del_btn").css("display","none");
    	$(".fav_wrt_btn").css("display","none");
    	
    });
    $("#frd_social").mouseover(function(){
    	$("#frd_left_btn").css("display","block");
    	$("#frd_x").css("display","block");
    	$("#frd_right_btn").css("display","block");
    	
    });
    $("#frd_social").mouseout(function(){
    	$("#frd_left_btn").css("display","none");
    	$("#frd_x").css("display","none");
    	$("#frd_right_btn").css("display","none");
    	
    });
    $("#updown").click(function(){
    	var a = $("#updown").val();
    	if($("#updown").val()=="▼"){
    		$("#slide_Area").slideDown();
    		$("#updown").val("▲");
    	}else{
    		$("#slide_Area").slideUp();
    		$("#updown").val("▼");
    	}
    	
    });
    $(".frd_dd").mouseover(function(){
    	$(this).children(".frd_del").css("display","block");
    	
    });
    $(".frd_dd").mouseout(function(){
    	$(".frd_del").css("display","none");
    });
});
function frd_left(){
	$("#frd_box>div").last().prependTo("#frd_box");
}
function frd_right(){
	$("#frd_box>div").first().appendTo("#frd_box");
}


function updateScore(code){
//	document.getElementbody.style.background="gray";
	document.getElementById("write_form").style.display="block";
	document.getElementById("emptyCode").value=code;

}
function closeForm(){
	document.getElementById("write_form").style.display="none";
}
function closeWin(){
	document.getElementById("write_form").style.display="none";
	document.body.style.background="white";

}
function deleteScore(seq, id) {
	location.href = "./deleteSC.do?seq="+seq+"&id="+id;
}
function removeScore(code, id){
	location.href = "./removieCmd.do?code="+code+"&id="+id;
}
function exit(){
	$("#frd_social").empty();
}
</script>
<script type="text/javascript">
$(function() {
	$(".frd_open_btn").click(function(){
		$("#frd_list").animate({right:"0px"},1000 ).removeClass("frd_open_btn");
	});
	$(".frd_close_btn").click(function(){
		$("#frd_list").animate({right:"-320px"},1000 );
		$(".frd_del").css("display","none");
	});
});
$(function(){
	$(".starRev span").click(function(){
	  $(this).parent().children("span").removeClass("on").click(function(){
	  	$("#score").val($(".on").length*2);
	  });
	  $(this).addClass("on").prevAll("span").addClass("on");
	  return false;
	});
});


function delete_one(id, frd){
	location.href = "./deleteFriend.do?mem_id="+id+"&frd_id="+frd;
}
//영화 상세 팝업
function openWin(cd) {
	var url = "./movie_like.do?moviecd=" + cd;
	var title = "상세";
	var prop = "top=100px, left=400px, width=470px, "
			+ "height=500px, scrollbars=no, resizeable=no";
	window.open(url, title, prop);
}

</script>

<%@include file = "./Header.jsp"%>
<div class="main">
<info class="user">
<div id="userpage"><%@include file="userPage.jsp"%></div>
</info>
<div class="contents"> <!-- 센터 화면 -->

<!-- 1. 최근 관람 영화 목록 -->
   <h3># 최근 관람한 영화</h3>
<div id="watched_movie">
	<a href="javascript:openWin(${viewMovie.get(0).moviecd});" id="changeOpen_name"><span id="watched_name">${viewMovie.get(0).movieNm}</span></a>
	<span style="color:white; text-align: right;" id="watched_date">${bookMyMovie.get(0).booking_date}</span>
  		<input type="button" class="slide_btn" style="float: left;" value="◀" onclick="beforeMovie('${id}')">
  	<input type="button" class="slide_btn" style="float: right;" value="▶" onclick="nextMovie('${id}')">
	<div id="watched_img">
	<a href="javascript:openWin(${viewMovie.get(0).moviecd});" id="changeOpen_img">
		<img src="${viewMovie.get(0).image}" id="change_img">
		</a><br>
	</div>
	<div id="watched_score">
		<table><tbody id="watched_tbody">
		<c:forEach items="${viewMovieScore}" var="watched">
			<tr><td class="td1">${watched.mem_id}</td>
			<td class="td2"><c:choose>
	<c:when test="${watched.score==2}">★☆☆☆☆ 2</c:when>
	<c:when test="${watched.score==4}">★★☆☆☆ 4</c:when>
	<c:when test="${watched.score==6}">★★★☆☆6</c:when>
	<c:when test="${watched.score==8}">★★★★☆ 8</c:when>
	<c:when test="${watched.score==10}">★★★★★ 10</c:when>
	</c:choose></td>
			<td class="td3">${watched.scomment}</td></tr>
		</c:forEach>
		</tbody></table>
	</div>
</div>
<br>
<h3># 나의 관심 영화 리스트</h3>
<div id="fav_movie">
	<input type="button" class="slide_btn" style="float: left;" id="fav_left_btn" value="◀">
	<div id="fav_box">
		<c:forEach items="${likeMovie}" var="l" varStatus="lm">
			<div class="fav_content">
		<a href="javascript:openWin(${l.moviecd});">
			<img src="${l.image}"><br>
			<c:choose>
			<c:when test="${fn:length(l.movieNm) > 12}">
			${fn:substring(l.movieNm, 0,12)}..
			</c:when>
			<c:otherwise>${l.movieNm}</c:otherwise>
			</c:choose> </a>
			<img src="./images/squarex.png" align="middle" class="fav_del_btn" onclick="deleteScore('${seq.get(lm.index).scm_seq}', '${id}')"> 
			<img src="./images/squarewrite.png" align="middle" class="fav_wrt_btn" onclick="updateScore(${l.moviecd})"><br></div>
	</c:forEach>
</div>
<input type="button" class="slide_btn" style="float: right;" id="fav_right_btn" value="▶">
</div>
	
	<div id = "write_form">
	<form action="./updateSC.do" method="post">
	<input type="hidden" name="mem_id" value="${id}">
	<input type="hidden" id="emptyCode" name="moviecd">
	<div class="frd_close_btn" onclick="closeForm()"></div>
	<table width="100%">
	<caption style="height: 50px; background-color:#fff5ee;">평점과 댓글 작성하기</caption>
	<tr>
	<td>score</td>
	<td><div class="starRev">
  <span class="star on">별1</span>
  <span class="star">별2</span>
  <span class="star">별3</span>
  <span class="star">별4</span>
  <span class="star">별5</span>
<input type="text" size="1" name="score" id="score" readonly="readonly" value="2">점</td>
</div>
	</tr>
	<tr>
	<td>comment</td>
	<td><input type="text" size="20" name="scomment"></td>
	</tr>
	<tr>
	<td colspan="2" align="center">
		<input type="submit" value="확인" onclick="closeWin()">
	</td>
	</tr>
	</table>
	</form>
	</div>


<div id="my_comment">
	<h3># 나의 댓글 보기
	<input type="button" id="updown" value="▼"></h3>
<div id="slide_Area" style="display: none">
<table><tbody>
	<c:forEach items="${myWrite}" var="write" varStatus="status">
	<tr>
	<td width="120px"><a href="javascript:openWin(${write.moviecd});">${myWriteName.get(status.index).movieNm}</a></td>
	<td width="120px">
	<c:choose>
	<c:when test="${write.score==2}">★☆☆☆☆ 2</c:when>
	<c:when test="${write.score==4}">★★☆☆☆ 4</c:when>
	<c:when test="${write.score==6}">★★★☆☆6</c:when>
	<c:when test="${write.score==8}">★★★★☆ 8</c:when>
	<c:when test="${write.score==10}">★★★★★ 10</c:when>
	</c:choose></td>
	<td width="480px">${write.scomment}</td>
	<td width="80px">
	<img src="./images/squarex.png" align="middle" class="img_btn_size" onclick="removeScore('${write.moviecd}','${id}')"> 
	<img src="./images/squarewrite.png" align="middle" class="img_btn_size" onclick="updateScore('${write.moviecd}')"> <br/>
	</td></tr>
	</c:forEach>
</tbody></table></div>
</div>
</div>

<div class="frd_open_btn"></div> <!-- slide open button -->

<div id="frd_list">
	<div class="frd_close_btn"></div>
	<h3 style="margin:-10px; padding:10px;">친구 목록</h3>
	<form action="./addFriend.do" method="POST">
	<input type="hidden" name="mem_id" value="${id}">
		<h4>ID : <input type="text" size="12" name="frd_id" required="required">
		<input type="submit" value="등록"></h4>
	</form>
	<dl>
	<c:forEach items="${FList}" var="flist">
		<dd class="frd_dd"><img src="./images/person.png" class="person" align="middle"/>
		<a style="cursor:pointer" onclick="frd_movie('${flist.frd_id}')">${flist.frd_id}</a>
		<img src="./images/squarex.png" align="middle" class="frd_del" onclick="delete_one('${id}','${flist.frd_id}')">
		</dd>
	</c:forEach>
	</dl>
	<div id="frd_social"></div>
</div>


</div>
<%@include file = "./Footer.jsp"%> 
