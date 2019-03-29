package seok.yun.na.model;

import java.util.List;
import java.util.Map;

import seok.yun.na.dtos.BookingDto;
import seok.yun.na.dtos.CinemaDto;

public interface Booking_IDao {
	
	// 예매 내역을 출력하는 기능
	public List<BookingDto> bookingList(String mem_id); 
	
	//예매하는 기능
	public boolean book_insert(BookingDto dto);
	
	public boolean bookseat_insert(BookingDto dto);
	
		// 예매 - 영화, 상영정보, 좌석정보 출력하는 기능
		public List<BookingDto> book_movie(String cin_cd); 
		
		public List<BookingDto> book_play(BookingDto dto); 
		
		public List<BookingDto> book_seat(BookingDto dto); 
	
	//예매를 취소 하는 기능
	public boolean book_delete(Map<String, String[]> map);
	
	public boolean bookseat_delete(Map<String, String[]> map);
	
	//예매내역 결제 기능
	public boolean pay_book(String booking_num);
	
	//영화관 위치를 찍는 기능
	public List<CinemaDto> map_loc(Map<String, String> map);

}
