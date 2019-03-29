<%@ page language="java" contentType="text/html; charset=UTF-8"
   pageEncoding="UTF-8"%>
<%@page import="java.util.List"%>
<%@page import="seok.yun.na.dtos.MembershipDto"%>
<!DOCTYPE html>

<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>로그인</title>


<script type="text/javascript"
   src="https://code.jquery.com/jquery-3.3.1.js"></script>
<style>
#fmField>div {
   margin: 15px 0;
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
   margin-bottom: 100px;
}


.login{
text-align: center;
    width: 100%;
    margin-left: auto;
    margin-right: auto;
    background-color: #fff;
    
}
#login_btn{
   background-color: #4c7c83;
   border-radius: 5px;
   font-family: Godic;
   color: #fff; 
   border-color:#4c7c83;

}
#reg_btn{
   background-color: #4c7c83;
   border-radius: 5px;
   font-family: Godic;
   color: #fff;
   border-color:#4c7c83; 
}
#login_btn:hover{
 background-color: #dcedc2;
 border-color:#dcedc2; 
 color: black;
}
#reg_btn:hover{
   background-color: #dcedc2;
   border-color:#dcedc2; 
   color: black;
}
.homebtn{
margin-top: 10px;
}
</style>
<script type="text/javascript">
   
   function regForm(){
      location.href="./regForm.do";
   }
   
   
   var input = document.getElementsById("loginId");
    input.addEventListener("keyup", function(event) {
    event.preventDefault();
    if (event.keyCode === 13) {
        document.getElementById("login_btn").click();
    }
});
</script>

<div class="login">
      <div class="col-md-6 col-md-offset-3 col-sm-8 col-sm-offset-2">
      <div class="panel panel-success">
         <div class="panel-heading">
            <div class="panel-title">
               <h2>Social Network<br/> Movie Service</h2>
            </div>
         </div>
         <div class="panel-body">
               <div>
                  <input type="text" placeholder="ID"
                     required="required" id="loginId" name="login" style="background-color: ivory; box-shadow: 2px 2px grey;">
               </div>
               <div>
                  <input type="password" placeholder="Password"
                     required="required" id="userPw" name="login" style="background-color: ivory; box-shadow: 2px 2px grey;">
               </div>
               <div class=homebtn>
                  <input type="button" value="로그인" id="login_btn">
                  <input type="button" value="회원가입" id="reg_btn" onclick="regForm()">
               </div>
         </div>
      </div>
   </div>
</div>




