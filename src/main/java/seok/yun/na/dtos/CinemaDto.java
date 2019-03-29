package seok.yun.na.dtos;

public class CinemaDto {
	private String cin_cd       ;
	private String sub_title    ;
	private String title        ;
	private String address      ;
	private String road_address ;
	private float latitude     ;
	private float longitude    ;
	private String availability;
	
	private String playhall_cd;
	private String playhall_name;
	
	private String seat_cd;
	private String seatrow;
	private String seatcol;
	public CinemaDto() {
		super();
		// TODO Auto-generated constructor stub
	}
	public CinemaDto(String cin_cd, String sub_title, String title, String address, String road_address, float latitude,
			float longitude, String availability, String playhall_cd, String playhall_name, String seat_cd,
			String seatrow, String seatcol) {
		super();
		this.cin_cd = cin_cd;
		this.sub_title = sub_title;
		this.title = title;
		this.address = address;
		this.road_address = road_address;
		this.latitude = latitude;
		this.longitude = longitude;
		this.availability = availability;
		this.playhall_cd = playhall_cd;
		this.playhall_name = playhall_name;
		this.seat_cd = seat_cd;
		this.seatrow = seatrow;
		this.seatcol = seatcol;
	}
	
	/**
	 * 지도에 영화관 정보 뿌릴 dto
	 * @param sub_title
	 * @param title
	 * @param address
	 * @param road_address
	 * @param latitude
	 * @param longitude
	 */
	public CinemaDto(String sub_title, String title, String address, String road_address, float latitude, float longitude) {
		super();
		this.sub_title = sub_title;
		this.title = title;
		this.address = address;
		this.road_address = road_address;
		this.latitude = latitude;
		this.longitude = longitude;
	}
	
	@Override
//	public String toString() {
//		return "CinemaDto [cin_cd=" + cin_cd + ", sub_title=" + sub_title + ", title=" + title + ", address=" + address
//				+ ", road_address=" + road_address + ", latitude=" + latitude + ", longitude=" + longitude
//				+ ", availability=" + availability + ", playhall_cd=" + playhall_cd + ", playhall_name=" + playhall_name
//				+ ", seat_cd=" + seat_cd + ", seatrow=" + seatrow + ", seatcol=" + seatcol + "]";
//	}
	
	public String toString() {
		return String.format("[%s]\t%s\t%s\n%s :\t%s\t%s", sub_title, address, title, road_address, longitude, latitude);
	}
	
	public String getCin_cd() {
		return cin_cd;
	}
	public void setCin_cd(String cin_cd) {
		this.cin_cd = cin_cd;
	}
	public String getSub_title() {
		return sub_title;
	}
	public void setSub_title(String sub_title) {
		this.sub_title = sub_title;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getRoad_address() {
		return road_address;
	}
	public void setRoad_address(String road_address) {
		this.road_address = road_address;
	}
	public float getLatitude() {
		return latitude;
	}
	public void setLatitude(float latitude) {
		this.latitude = latitude;
	}
	public float getLongitude() {
		return longitude;
	}
	public void setLongitude(float longitude) {
		this.longitude = longitude;
	}
	public String getAvailability() {
		return availability;
	}
	public void setAvailability(String availability) {
		this.availability = availability;
	}
	public String getPlayhall_cd() {
		return playhall_cd;
	}
	public void setPlayhall_cd(String playhall_cd) {
		this.playhall_cd = playhall_cd;
	}
	public String getPlayhall_name() {
		return playhall_name;
	}
	public void setPlayhall_name(String playhall_name) {
		this.playhall_name = playhall_name;
	}
	public String getSeat_cd() {
		return seat_cd;
	}
	public void setSeat_cd(String seat_cd) {
		this.seat_cd = seat_cd;
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
	
	
}
