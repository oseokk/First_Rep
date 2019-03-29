package seok.yun.na.model;

import java.util.List;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import seok.yun.na.dtos.BookingDto;
import seok.yun.na.dtos.CinemaDto;

@Service
public class Booking_Service implements Booking_IService {
	private Logger logger = LoggerFactory.getLogger(Booking_Service.class);
	
	@Autowired
	private Booking_IDao dao;
	
	// 예매내역 조회
	@Override
	public List<BookingDto> bookingList(String mem_id) {
		logger.debug("Booking_Service bookingList()");
		return dao.bookingList(mem_id);
	}
	
	// 예매하기
	@Override
	@Transactional
	public boolean book_select(BookingDto dto) {
		logger.debug("Booking_Service book_select()");
		boolean bs = dao.book_insert(dto);
		boolean bss = dao.bookseat_insert(dto);
		return (bs&&bss)?true:false;
	}

	// 예매취소
	@Override
	@Transactional
	public boolean book_delete(Map<String, String[]> map) {
		logger.debug("Booking_Service book_delete()");
		boolean bs = dao.book_delete(map);
		boolean bss = dao.bookseat_delete(map);
		return (bs&&bss)?true:false;
	}
	
	// 예매내역 결제
	@Override
	public boolean pay_book(String booking_num) {
		logger.debug("Booking_Service pay_book()");
		return dao.pay_book(booking_num);
	}
	
	// 영화관 위치 찍는 기능
	@Override
	public List<CinemaDto> map_loc(Map<String, String> map) {
		logger.debug("Booking_Service map_loc()");
		return dao.map_loc(map);
	}

	@Override
	public List<BookingDto> book_movie(String cin_cd) {
		logger.debug("Booking_Service book_movie()");
		return dao.book_movie(cin_cd);
	}
	
	@Override
	public List<BookingDto> book_play(BookingDto dto) {
		logger.debug("Booking_Service book_play()");
		return dao.book_play(dto);
	}

	@Override
	public List<BookingDto> book_seat(BookingDto dto) {
		logger.debug("Booking_Service book_seat()");
		return dao.book_seat(dto);
	}

	
	
}
