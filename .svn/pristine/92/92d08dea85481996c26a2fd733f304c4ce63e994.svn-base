<%@page import="java.util.List"%>
<%@page import="seok.yun.na.dtos.BookingDto"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
   pageEncoding="UTF-8"%>
<!DOCTYPE html>
<meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
<title>KOKOA</title>
<link href="css/singlePageTemplate.css" rel="stylesheet" type="text/css">
<script>var __adobewebfontsappname__ = "dreamweaver"
</script>
<script src="http://use.edgefonts.net/source-sans-pro:n2:default.js"
   type="text/javascript"></script>
<script type="text/javascript">
   function returnView() {
      //      location.href="./booking.do";
      history.go(-1);
   }
   
   function pointtt(){
      var myPoint =  document.getElementById("myPoint").value;
      var IHavePoint = document.getElementById("IHavePoint").value;
      var changePoint = 0;
//       alert(myPoint);
      if(myPoint > IHavePoint){
         alert("가용 포인트 내에서 사용 가능합니다^.^;");
      }else{
         document.getElementById("discountWon").value = "(-)  "+myPoint;
         document.getElementById("IHavePoint").value = IHavePoint-myPoint;
      }
   }
   
//    function checkValue(val){
//       var selectCard = document.getElementById("selectCard").value
//       var cardnumber = document.getElementsByName("cardnumber").value
//       var date = document.getElementsByName("date").value
//       var cvc = document.getElementsByName("cvc").value
//       var pw = document.getElementsByName("pw").value
//       var birth = document.getElementsByName("birth").value
      
//        if(selectCard===""){
//            alert("카드 종류를 선택하세요.");
//        } else if(cardnumber===""){
//            alert("카드번호를 전부 입력하세요.");
//        } else if(date===""){
//            alert("유효기간을 입력하세요.");
//        }  else if(cvc===""){
//            alert("CVC를 입력하세요.");
//        } else if(pw===""){
//            alert("비밀번호를 입력하세요.");
//        } else if(birth===""){
//            alert("생년월일을 입력하세요.");
//        }else{
// //          var mem_id = document.getElementById("mem_id").value;
//          location.href = "./bookpay.do?booking_num="+${booking_num}//+"&mem_id=" + mem_id;
//        }
//    }
   
   
</script>

<!-- Main Container -->
<div class="container">
   <%@include file="Header.jsp"%>
   <div class="maincontents">
      <div class="title_box_bk">
         <div class="booking_title">
            <p>예매내역</p>
         </div>
      </div>
      <form action="./bookpay.do" method="post">
      <input type="hidden" readonly="readonly" name="booking_num"  value="${booking_num}">
      <input type="hidden" readonly="readonly" name="mem_id"  value="${lDto.mem_id}">
         <div class="booking_contents_box">
            <div class="list_box" id="left" >
               <div class="pay_list_title">
                  <li>&nbsp;&nbsp;</li>포인트
               </div>
               <div class="pay_list_con">
                  <div class="pay_kind_list">
                     <div class="pay_kind">차감포인트</div>
                     <div class="input_flex">
                     <input class="pay_input_1" id="myPoint" value="">
                     <input type="button" onclick="pointtt()" value="적용" style="border: 1px solid gray;">
                     </div>
                  </div>
                  <div class="pay_kind_list">
                     <div class="pay_kind">가용포인트</div>
                     <div class="input_flex">
                     <input class="pay_input_1" readonly="readonly" id="IHavePoint" value="${lDto.mem_point}" >
                     </div>
                  </div>
               </div>
               <div class="pay_list_title">
                  <li>&nbsp;&nbsp;</li>카드정보
               </div>
               <div class="pay_list_con">
                  <div class="pay_kind_list">
                     <div class="pay_kind">카드종류</div>
                     <div class="input_flex">
                     <select class="pay_input_1" id="selectCard" required="required">
                        <option value="">카드종류선택</option>
                        <option>신용/체크카드</option>
                        <option>기타</option>
                        <option>기타</option>
                     </select>
                     </div>
                  </div>
                  <div class="pay_kind_list">
                     <div class="pay_kind">카드번호</div>
                     <div class="input_flex">
                        <input class="pay_input_4" id="cardnumber1" name="cardnumber" placeholder="****" required="required"><input
                           class="pay_input_4" id="cardnumber2" name="cardnumber" placeholder="****" required="required"><input
                           class="pay_input_4" id="cardnumber3" name="cardnumber" placeholder="****" required="required"><input
                           class="pay_input_4" id="cardnumber4" name="cardnumber" placeholder="****" required="required">
                     </div>
                  </div>
                  <div class="pay_kind_list">
                     <div class="pay_kind">유효기간</div>
                     <div class="input_flex">
                        <input class="pay_input_2" name="date" placeholder="월"><input class="pay_input_2"  name="date"  placeholder="년" required="required">
                     </div>
                  </div>
                  <div class="pay_kind_list">
                     <div class="pay_kind">CVC</div>
                     <div class="input_flex">
                        <input  type="password" class="pay_input_2" name="cvc" placeholder="3자리" required="required">
                     </div>
                  </div>
                  <div class="pay_kind_list">
                     <div class="pay_kind">비밀번호</div>
                     <div class="input_flex">
                        <input type="password" class="pay_input_2" name="pw" placeholder="앞 2자리" required="required"><a>**</a>
                     </div>
                  </div>
                  <div class="pay_kind_list">
                     <div class="pay_kind">생년월일</div>
                     <div class="input_flex">
                        <input class="pay_input_2" placeholder="YYMMDD"  name="birth"  required="required">
                     </div>
                  </div>
               </div>

            </div>
            <div class="list_box" id="right">
               <div class="bkng_list_title" id="pay_empty"></div>
               <div class="pay_list_title">
                  <li>&nbsp;&nbsp;</li>총결제금액
               </div>
               <div class="bkng_info">
                  <input class="num" name="finalWon" readonly="readonly" value="" required="required">
                  <div class="num" id="won">원</div>
               </div>
               <div class="pay_detail">
                  <ul class="dtldBrkdw_left_box">
                     <li>예매총액</li>
                     <li>할인금액</li>
                  </ul>
                  <ul class="dtldBrkdw_right_box">
                     <li><input class="dtl_input" id="totalWon" name="totalWon" value=""></li>
                     <li><input class="dtl_input" id="discountWon" name="discountWon" value=""></li>
                  </ul>
               </div>
            </div>
         </div>
      <div class="booking_contents_box">
         <div class="list_box">
            <div class="bkng_btn" id="pay_bottom">
               <input value="결제" type="submit" class="btn"> 
<!--                <input value="결제" type="button" class="btn" onclick="checkValue()">  -->
               <input value="취소" type="button" class="btn_gray" onclick="returnView()">
            </div>
         </div>
      </div>
      </form>
   </div>
   <%@include file="Footer.jsp"%>
</div>
<!-- Main Container Ends -->
