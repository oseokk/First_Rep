package seok.yun.na.model;

import java.util.List;
import java.util.Map;

import org.mybatis.spring.SqlSessionTemplate;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import seok.yun.na.dtos.BookingDto;
import seok.yun.na.dtos.CinemaDto;

@Repository
public class Booking_Dao implements Booking_IDao {
	private Logger logger = LoggerFactory.getLogger(Booking_Dao.class); 
	private final String NAME = "seok.yun.na.";
	
	@Autowired
	private SqlSessionTemplate sqlSession;
	
	// 예매내역 출력
	@Override
	public List<BookingDto> bookingList(String mem_id) {
		logger.debug("Booking_Dao bookingList()");
	 	List<BookingDto> lists = sqlSession.selectList(NAME+"book_view",mem_id);
		return lists;
	}
	
	// 예매하기 - 예매테이블
	@Override
	public boolean book_insert(BookingDto dto) {
		logger.debug("Booking_Dao book_select()");
		Integer n = sqlSession.insert(NAME+"book_select", dto);
		return (n>0)?true:false;
	}
	
	// 예매하기 - 좌석테이블
	@Override
	public boolean bookseat_insert(BookingDto dto) {
		logger.debug("Booking_Dao book_select()");
		Integer n = sqlSession.insert(NAME+"bookseat_select", dto);
		return (n>0)?true:false;
	}
	
	// 예매취소 - 예매테이블
	@Override
	public boolean book_delete(Map<String, String[]> map) {
		int n = sqlSession.delete(NAME+"book_delete", map);
		logger.debug("Booking_Dao book_delete 결과 : {}",n); //slf4j의 문법, {}안에 n을 바인딩
		return (n>0)?true:false;
	}
	
	// 예매취소 - 좌석테이블
	@Override
	public boolean bookseat_delete(Map<String, String[]> map) {
		int n = sqlSession.delete(NAME+"bookseat_delete", map);
		logger.debug("Booking_Dao bookseat_delete 결과 : {}",n); //slf4j의 문법, {}안에 n을 바인딩
		return (n>0)?true:false;
	}
	
	// 예매내역 결제
	@Override
	public boolean pay_book(String booking_num) {
		int n = sqlSession.update(NAME+"pay_book", booking_num);
		logger.debug("Booking_Dao pay_book 결과 : {}",booking_num);
		return (n>0)?true:false;
	}
	
	// 영화관 위치 출력
	@Override
	public List<CinemaDto> map_loc(Map<String, String> map) {
		logger.debug("Booking_Dao bookingList()");
	 	List<CinemaDto> cLists = sqlSession.selectList(NAME+"map_loc",map);
		return cLists;
	}
	
	// 예매 - 상영영화정보
	@Override
	public List<BookingDto> book_play(BookingDto dto) {
		logger.debug("Booking_Dao book_play()");
	 	List<BookingDto> lists = sqlSession.selectList(NAME+"book_play",dto);
		return lists;
	}
	
	// 예매 - 영화
	@Override
	public List<BookingDto> book_movie(String cin_cd) {
		logger.debug("Booking_Dao book_movie()");
	 	List<BookingDto> lists = sqlSession.selectList(NAME+"book_movie",cin_cd);
		return lists;
	}
	
	// 예매 - 좌석
	@Override
	public List<BookingDto> book_seat(BookingDto dto) {
		logger.debug("Booking_Dao book_seat()");
	 	List<BookingDto> lists = sqlSession.selectList(NAME+"book_seat",dto);
		return lists;
	}
	
	
	
}
