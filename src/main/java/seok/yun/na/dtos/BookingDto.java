package seok.yun.na.dtos;

import java.io.Serializable;
import java.util.Date;

public class BookingDto implements Serializable{

	private static final long serialVersionUID = 1656439744746454792L;
	
	private String booking_num  ;
	private String seat_cd;
	private String mem_id;
	private String play_cd;
	private String moviecd;
	private String playhall_cd;
	private String cin_name;
	private Date booking_date ;
	private String tic_pay;
	
	 private String play_date;
	 private String start_time;
	 private String end_time;
	 private String playhall_name;
	 private String cin_cd;
	 private String title;
	 private String sub_title;
	 private String seatrow;
	 private String seatcol;
	
	public BookingDto() {
		super();
	}
	
	public BookingDto(String booking_num, String seat_cd, String mem_id, String play_cd, String moviecd,
			String playhall_cd, String cin_name, Date booking_date, String tic_pay, String play_date, String start_time,
			String end_time, String playhall_name, String cin_cd, String title, String sub_title, String seatcol, String seatrow) {
		super();
		this.booking_num = booking_num;
		this.seat_cd = seat_cd;
		this.mem_id = mem_id;
		this.play_cd = play_cd;
		this.moviecd = moviecd;
		this.playhall_cd = playhall_cd;
		this.cin_name = cin_name;
		this.booking_date = booking_date;
		this.tic_pay = tic_pay;
		this.play_date = play_date;
		this.start_time = start_time;
		this.end_time = end_time;
		this.playhall_name = playhall_name;
		this.cin_cd = cin_cd;
		this.title = title;
		this.sub_title = sub_title;
		this.seatcol = seatcol;
		this.seatrow = seatrow;
	}

	public String getBooking_num() {
		return booking_num;
	}

	public void setBooking_num(String booking_num) {
		this.booking_num = booking_num;
	}

	public String getSeat_cd() {
		return seat_cd;
	}

	public void setSeat_cd(String seat_cd) {
		this.seat_cd = seat_cd;
	}

	public String getMem_id() {
		return mem_id;
	}

	public void setMem_id(String mem_id) {
		this.mem_id = mem_id;
	}

	public String getPlay_cd() {
		return play_cd;
	}

	public void setPlay_cd(String play_cd) {
		this.play_cd = play_cd;
	}

	public String getMoviecd() {
		return moviecd;
	}

	public void setMoviecd(String moviecd) {
		this.moviecd = moviecd;
	}

	public String getPlayhall_cd() {
		return playhall_cd;
	}

	public void setPlayhall_cd(String playhall_cd) {
		this.playhall_cd = playhall_cd;
	}

	public String getCin_name() {
		return cin_name;
	}

	public void setCin_name(String cin_name) {
		this.cin_name = cin_name;
	}

	public Date getBooking_date() {
		return booking_date;
	}

	public void setBooking_date(Date booking_date) {
		this.booking_date = booking_date;
	}

	public String getTic_pay() {
		return tic_pay;
	}

	public void setTic_pay(String tic_pay) {
		this.tic_pay = tic_pay;
	}

	public String getPlay_date() {
		return play_date;
	}

	public void setPlay_date(String play_date) {
		this.play_date = play_date;
	}

	public String getStart_time() {
		return start_time;
	}

	public void setStart_time(String start_time) {
		this.start_time = start_time;
	}

	public String getEnd_time() {
		return end_time;
	}

	public void setEnd_time(String end_time) {
		this.end_time = end_time;
	}

	public String getPlayhall_name() {
		return playhall_name;
	}

	public void setPlayhall_name(String playhall_name) {
		this.playhall_name = playhall_name;
	}

	public String getCin_cd() {
		return cin_cd;
	}

	public void setCin_cd(String cin_cd) {
		this.cin_cd = cin_cd;
	}
	
	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}
	
	public String getSub_title() {
		return sub_title;
	}

	public void setSub_title(String sub_title) {
		this.sub_title = sub_title;
	}
	
	public String getSeatrow() {
		return seatrow;
	}

	public void setSeatrow(String seatrow) {
		this.seatrow = seatrow;
	}

	public String getSeatcol() {
		return seatcol;
	}

	public void setSeatcol(String seatcol) {
		this.seatcol = seatcol;
	}

	@Override
	public String toString() {
		return "BookingDto [booking_num=" + booking_num + ", seat_cd=" + seat_cd + ", mem_id=" + mem_id + ", play_cd="
				+ play_cd + ", moviecd=" + moviecd + ", playhall_cd=" + playhall_cd + ", cin_name=" + cin_name
				+ ", booking_date=" + booking_date + ", tic_pay=" + tic_pay + ", play_date=" + play_date
				+ ", start_time=" + start_time + ", end_time=" + end_time + ", playhall_name=" + playhall_name
				+ ", cin_cd=" + cin_cd + ", title=" + title + ", sub_title=" + sub_title + "]";
	}



}
