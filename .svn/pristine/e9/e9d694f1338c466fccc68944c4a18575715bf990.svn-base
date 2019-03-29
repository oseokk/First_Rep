<%@page import="seok.yun.na.dtos.MembershipDto"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>

<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<script type="text/javascript" src="https://code.jquery.com/jquery-3.3.1.js"></script>
<title>마이페이지</title>
<style type="text/css">

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
</head>
<%
//    MembershipDto lDto 
//    =  (MembershipDto)session.getAttribute("lDto");
%>
<script type="text/javascript">

   function logout(){
      location.href = "./logout.do";
   }
   function social(mem_id){
      location.href = "./social.do?id="+mem_id;
   }
   function message(mem_id){
      location.href = "./message.do?id="+mem_id;
   }
</script>


      
<body>
<div class="ssession">
   <div class="panel-title">
               <h2>Social Network<br/> Movie Service</h2>
            </div>
   <div>${lDto.nickname}님 환영합니다!</div>
<form action="./myinfo.do">
      <input type="hidden" name="mem_id" id="loginId" value="${lDto.mem_id}">
      <div class="homebtn">
      <input type="submit" value="MYINFO" id="infobtn">
      <input type="button" value="LOGOUT" onclick="logout()" id="logoutbtn">
      </div>
</form>
      <div><img src="./images/message.png" onclick="message()" style="width: 60px; height:60px;"></div>
</div>


</body>

</html>
