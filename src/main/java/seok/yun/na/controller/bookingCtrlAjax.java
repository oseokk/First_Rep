package seok.yun.na.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import seok.yun.na.dtos.BookingDto;
import seok.yun.na.dtos.CinemaDto;
import seok.yun.na.model.Booking_IService;

@Controller
public class bookingCtrlAjax {
	
	private Logger logger = LoggerFactory.getLogger(bookingCtrlAjax.class);
	
	@Autowired
	private Booking_IService service;
	
	
	@RequestMapping(value="/getMoviecdAjax.do", 
			produces="application/json;charset=UTF-8" ,
			method={RequestMethod.GET, RequestMethod.POST})
	
	@ResponseBody
	public Map <String, List<BookingDto>> getMoviecd(String cin_cd) {
		Map<String, List<BookingDto>> map= new HashMap<String, List<BookingDto>>();
		logger.info("bookingCtrl getMoviecd");
		List<BookingDto> lists = service.book_movie(cin_cd);
		map.put("lists", lists);
		System.out.println(lists);
		return map;
	}
	
	
	@RequestMapping(value="/book_playAjax.do", 
			produces="application/json;charset=UTF-8" ,
			method={RequestMethod.GET, RequestMethod.POST})
	
	// 날짜, 시간, 상영관 출력
	@ResponseBody
	public Map<String, List<BookingDto>> book_play(BookingDto dto){
		Map<String, List<BookingDto>> map= new HashMap<String, List<BookingDto>>();
		logger.info("bookingCtrlAjax  book_play");
			 List<BookingDto> lists = service.book_play(dto);
			 map.put("lists", lists);
			 System.out.println(lists);
			 return map;
	}
	
	@RequestMapping(value="/book_seatAjax.do", 
			produces="application/json;charset=UTF-8" ,
			method={RequestMethod.GET, RequestMethod.POST})
	
	// 좌석 출력
	@ResponseBody
	public Map<String, List<BookingDto>> book_seat(BookingDto dto){
		Map<String, List<BookingDto>> map= new HashMap<String, List<BookingDto>>();
		logger.info("bookingCtrlAjax  book_seat");
			 List<BookingDto> lists = service.book_seat(dto);
			 map.put("lists", lists);
			 System.out.println(lists);
			 return map;
	}
	
//	@RequestMapping(value="/mapdetailAjax.do", 
//			produces="application/json;charset=UTF-8" ,
//			method={RequestMethod.GET, RequestMethod.POST})
//	
//	// 영화관 정보를 보여주는 기능 -- 완료
//	@ResponseBody
//	public  Map<String, List<CinemaDto>> map_detail(CinemaDto cDto) {
//		Map<String, List<CinemaDto>> map = new HashMap<String, List<CinemaDto>>();
//		logger.debug("bookingCtrl map_detail");
//			List<CinemaDto> cLists =  service.map_loc(cDto);
//			map.put("val", cLists);
//			System.out.println(cLists);
//			return map;
//	}

}
