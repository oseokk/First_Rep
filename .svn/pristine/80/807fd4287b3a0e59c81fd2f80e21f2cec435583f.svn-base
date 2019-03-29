package seok.yun.na.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import seok.yun.na.dtos.BookingDto;
import seok.yun.na.dtos.CinemaDto;
import seok.yun.na.model.Booking_IService;

@Controller
public class bookingCtrl {

	private Logger logger = LoggerFactory.getLogger(bookingCtrl.class);

	@Autowired
	private Booking_IService service;

	// 예매 내역을 출력하는 기능 -- 완료
	@RequestMapping(value="/booking.do", method={RequestMethod.GET, RequestMethod.POST})
	public String bookingList(Model model, String mem_id) {
		logger.debug("bookingCtrl bookingList");
		List<BookingDto> lists =  service.bookingList(mem_id); // mem_id
		System.out.println(lists);
		model.addAttribute("lists", lists);
		return "bookingList"; //bookingList
	}


	//영화관 찾는 화면으로 이동 -- 완료
	@RequestMapping(value="/mapgo.do", method={RequestMethod.GET, RequestMethod.POST})
	public String map(String mem_id,CinemaDto cDto) {
		logger.info("bookingCtrl map 영화관찾기");
		return "maptest";
	}
	
	
	
	
	//영화관 정보 출력
	@RequestMapping(value="/mapdetail.do", method={RequestMethod.GET, RequestMethod.POST})
	public  String map_detail(String address, String title, Model model) {
		Map<String, String> map = new HashMap<String, String>();
		logger.debug("bookingCtrl map_detail");
		map.put("address", address);
		map.put("title", title);
		List<CinemaDto> cLists =  service.map_loc(map);
		model.addAttribute("cLists",cLists);
		return "maptest";
		
	}

	
	
	
	
	
	//예매하는 화면으로 이동
	@RequestMapping(value="/bookinggo.do", method= {RequestMethod.GET, RequestMethod.POST})
	public String mapbook(Model model, String cin_cd,String mem_id) {
		logger.info("bookingCtrl mapbook 예매화면이동");
		model.addAttribute("cin_cd", cin_cd);
		List<BookingDto> lists = service.book_movie(cin_cd);
		System.out.println(lists);
		model.addAttribute("lists", lists);
		return "bookingnew";
	}

	// 예매 하기 기능 
	@RequestMapping(value="/bookinsert.do", method={RequestMethod.POST, RequestMethod.GET })
	public String book_insert(BookingDto dto,String booking_num ,@RequestParam("moivecd_obj") String moviecd, String[] seat_cd ,HttpServletRequest request, String mem_id) { //@RequestParam("seat_cd")
		logger.debug("bookingCtrl book_insert = {}", dto.toString());
		System.out.println(seat_cd.length+":"+moviecd);
		//		dto.setSeat_cd(seat_cd) // 배열로 받아야함;
		System.out.println(dto);
		dto.setMoviecd(moviecd);
		dto.setBooking_num(booking_num);
		boolean isc =  service.book_select(dto); 
		System.out.println("-------------" + isc);
		if(isc== false) {
			// redirect통해서 다시 dispatcher
			return "redirect:/mapgo.do";
		}else {
			return "redirect:/booking.do?mem_id="+mem_id;
		}
	}

	//예매내역 결제화면으로이동하는 기능 -- 완료
	@RequestMapping(value="/bookpaygo.do", method= {RequestMethod.GET, RequestMethod.POST})
	public String payForm(Model model, String booking_num) {
		logger.info("bookingCtrl payForm 결제화면이동");
		//		Object bookingnum = service.bookingList(booking_num);
		model.addAttribute("booking_num", booking_num);
		return "payFormNew";
	}

	//예매내역이 결제되는 기능 -- 완료
	@RequestMapping(value="/bookpay.do",method= {RequestMethod.POST, RequestMethod.GET })
	public String pay_book(Model model, String booking_num, String mem_id) {
		System.out.println(booking_num);
		logger.debug("bookingCtrl pay_book");
		boolean chk = service.pay_book(booking_num);
		if(chk==true) {
			return "redirect:/booking.do?mem_id="+mem_id;
		}else {
			return "redirect:/booking.do?mem_id="+mem_id;
		}
	}

	// 예매내역이 취소/삭제 되는 기능 -- 완료
	@RequestMapping(value="/bookdelete.do", method={RequestMethod.POST, RequestMethod.GET })
	public String book_delete(String[] chk, String mem_id) {
		logger.debug("예매취소 : {}", chk);
		Map<String, String[]>map = new HashMap<String,String[]>();
		map.put("booking_num_", chk);
		boolean isc = service.book_delete(map);
		if(isc) {
			return "redirect:/booking.do?mem_id="+mem_id;
		}else {
			return "redirect:/booking.do?mem_id="+mem_id;
		}
	}



}
