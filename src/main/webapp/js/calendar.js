$(function(){
	init();
	$("#startDate,#endDate").datepicker({
		dateFormat : "yy-mm-dd"
	});
});
//DB에 있는 개봉일 일정 화면으로 가져온다
function getSchedule() {
	
	var data = new Object();
	data.title = $("#Mtitle").val();
	JSON.stringify(data);
	$.ajax({
		url : './schedule_list.do',
		type : 'POST',
		data : data,
		contentType : 'application/x-www-form-urlencoded; charset=UTF-8',
		dataType : 'json',
		success : function(responseData, status) {
					for(var i=0;i<responseData.data.length;i++){
							//open_date의 데이터를 가져옴
							responseData.data[i].start = responseData.data[i].startDate;
							//open_datec의 데이터를 가져옴
							responseData.data[i].end = responseData.data[i].endDate;
							//개봉영화 이름을 가져옴
							responseData.data[i].title = responseData.data[i].scheduleContent;
					}
					makeCalendar(responseData.data);
		},
		error : function() {
			   alert("통신실패");
		}
	});
};
// Fullcalendar를 이용한 달력을 화면에 그려줌 
	function makeCalendar(event){
//	ID가 calendar인 곳에 달력을 그리겠다.
		$('#calendar').fullCalendar({
			height : 500,
			width : 300,
			header : {
				left : 'prev,next',
				center : 'title',
				right : 'today,month'
			},
			navLinks : false, // 달력에서 날짜 클릭시 해당날짜의 상세 일정으로 바뀜
			editable : false, // 해당일정 '바'로 된 부분을 다른날짜로 일정 이동 할 수 있게 함. 
			eventLimit : true, // allow "more" link when too many events
			dayNames: ['일요일', '월요일', '화요일', '수요일', '목요일', '금요일', '토요일'],
	 		dayNamesShort: ['일', '월', '화', '수', '목', '금', '토'],
	 		buttonText: {today: '오늘', month: '월'},
	 		events : event
		});
	};

//브라우저 판별해서 호환성 있는 스크립트를 실행시키기 위한 펑션
function init() {
	jQuery.browser = {};	
	(function() {
		jQuery.browser.msie = false;
		jQuery.browser.version = 0;
		if (navigator.userAgent.match(/MSIE ([0-9]+)\./)) {
			jQuery.browser.msie = false;
			jQuery.browser.version = RegExp.$1;
		}
	})();	
	getSchedule();
}