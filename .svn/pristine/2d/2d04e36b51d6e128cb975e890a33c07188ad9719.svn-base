<%@page import="seok.yun.na.dtos.MembershipDto"%>
<%@page import="seok.yun.na.dtos.SCMovieDto"%>
<%@page import="seok.yun.na.dtos.CinemaDto"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>★★★★★★영화 상세 보기★★★★★★</title>
<script type="text/javascript" src="https://code.jquery.com/jquery-3.2.1.min.js"></script>
<script type="text/javascript">
//중복검사
   function allchk(val){
//       alert(val);
      var obj =  document.getElementsByName("chk");
      for(var i=0;i<obj.length;i++){
         obj[i].checked = val;
      }
   }
   
   //jQuery submit 처리 방식
   
   function regForm(){
      location.href="./cinemaregForm.do";
   }
   $(function(){
//       alert(${isc});
      
      $("#Like").addClass('on');
      
      
       $("#Like").click(function(){
          $("#Like").attr("src","./images/Like.png");
          alert("관심리스트에 등록되었습니다.");
       });
      
   });
   
$(document).ready(function(){
   var a = ${isc};
   if(a==false){
      $("#Like").css("display","none");
   }
   
});


</script>
<style type="text/css">
body{
background-color: #2c2c2c;
color: #FFFFFF;
}

.on{
   display: bolck;
}

#Like{
width: 48px;
height: 48px;
}

.dcontent{
 display:grid;
 grid-template-columns: 180px 90px 180px;
 text-align: center;
 border-bottom: 1px solid white;
}
.movie_detail{
 margin-top: 30px;
 margin-left: 20px;
 text-align: left;
 line-height: 30px
}
.dtable{
 width : 100%;
 text-align: center;
 margin-left: 60px;
}
.noscore{
 margin-left: 75px;
 font-size: 20pt;
 font-family: GODIC;
 font-weight: bold;
}

.dtable tr td{
 border-bottom: 1px solid #ffffff57;
}
</style>
</head>
<%
    MembershipDto lDto 
    =  (MembershipDto)session.getAttribute("lDto");
   List<SCMovieDto> lists = (List<SCMovieDto>)request.getAttribute("lists");
%>
<body>
<div class="dcontent">
<div class="dimage">
<img src="${dm.get(0).image}" style=" width:150px; height:200px; border: 5px solid white;">
<%
if(lDto==null){
%>
<a href="#" onclick="alert('로그인이 필요합니다.')">
<%
}else{
%>
<a href="./like.do?moviecd=${dm.get(0).moviecd}&mem_id=${lDto.mem_id}"> 
<%
}
%>
<img id="Like" src="./images/default.png"/></a>
</div>
<div class="movie_detail">
영화코드<br/>
영화명 <br/>
상영시간<br/>
제작년도<br/>
개봉일 <br/>
</div>
<div class="movie_detail">
 : <${dm.get(0).moviecd}><br/>   
 : <${dm.get(0).movieNm}><br/>  
 : <${dm.get(0).showTm}><br/>    
 : <${dm.get(0).prdtYear}><br/>  
 : <${dm.get(0).openDt}><br/>   
</div>
</div>
    <%
		  if(lists == null ||lists.size() == 0){
         %>
          <div class="noscore">평점과 한줄평을 남겨주세요!</div>
         <%
		  }else{
			  %>
<div class="dtable">
   <table>
      <tr>
         <th>아이디</th>         <th>평점</th>
         <th>한줄평</th>   
      </tr>
<%
         for(SCMovieDto dto : lists){
            %>
            <tr>
               <td width="30%"><%=dto.getMem_id()%></td>
               <%
               if(dto.getScore()==2){
               %>
               <td width="20%" style="color: gold">★☆☆☆☆</td>
               <%
               }else if(dto.getScore()==4){
               %>
               <td width="20%" style="color: gold">★★☆☆☆</td>
               <%
               }else if(dto.getScore()==6){
               %>
               <td width="20%" style="color: gold">★★★☆☆</td>
               <%
               }else if(dto.getScore()==8){
               %>
               <td width="20%" style="color: gold">★★★★☆</td>
               <%
               }else if(dto.getScore()==10){
               %>
               <td width="20%" style="color: gold">★★★★★</td>
               <%
               }
               %>
               <td width="50%"><%=dto.getScomment()%></td>            
            </tr>
            <%
         }
		  }
      %>

   </table>
</div>
 
<%-- ${dml} --%>

<%--    <%=lDto%> --%>
<%--    ${lDto} --%>
</body>
</html>

