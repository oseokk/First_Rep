package seok.yun.na.dtos;


public class SCMovieDto {

	private int scm_seq;
	private String mem_id;
	private String moviecd;
	private int score;
	private String scomment;
	private String likey;
	private String image;
	private String movieNm;
	private String booking_date;
	private String genre_1;
	private String genre_2;
	private String genre_3;
	
	
	public int getScm_seq() {
		return scm_seq;
	}
	public void setScm_seq(int scm_seq) {
		this.scm_seq = scm_seq;
	}
	public String getMem_id() {
		return mem_id;
	}
	public void setMem_id(String mem_id) {
		this.mem_id = mem_id;
	}
	public String getMoviecd() {
		return moviecd;
	}
	public void setMoviecd(String moviecd) {
		this.moviecd = moviecd;
	}
	public int getScore() {
		return score;
	}
	public void setScore(int score) {
		this.score = score;
	}
	public String getScomment() {
		return scomment;
	}
	public void setScomment(String scomment) {
		this.scomment = scomment;
	}
	public String getLikey() {
		return likey;
	}
	public void setLikey(String likey) {
		this.likey = likey;
	}
	public String getImage() {
		return image;
	}
	public void setImage(String image) {
		this.image = image;
	}
	public String getMovieNm() {
		return movieNm;
	}
	public void setMovieNm(String movieNm) {
		this.movieNm = movieNm;
	}
	public String getBooking_date() {
		return booking_date;
	}
	public void setBooking_date(String booking_date) {
		this.booking_date = booking_date;
	}
	public String getGenre_1() {
		return genre_1;
	}
	public void setGenre_1(String genre_1) {
		this.genre_1 = genre_1;
	}
	public String getGenre_2() {
		return genre_2;
	}
	public void setGenre_2(String genre_2) {
		this.genre_2 = genre_2;
	}
	public String getGenre_3() {
		return genre_3;
	}
	public void setGenre_3(String genre_3) {
		this.genre_3 = genre_3;
	}
	public SCMovieDto() {
		super();
	}
	public SCMovieDto(int scm_seq, String mem_id, String moviecd, int score, String scomment, String likey,
			String image, String movieNm, String booking_date, String genre_1, String genre_2, String genre_3) {
		super();
		this.scm_seq = scm_seq;
		this.mem_id = mem_id;
		this.moviecd = moviecd;
		this.score = score;
		this.scomment = scomment;
		this.likey = likey;
		this.image = image;
		this.movieNm = movieNm;
		this.booking_date = booking_date;
		this.genre_1 = genre_1;
		this.genre_2 = genre_2;
		this.genre_3 = genre_3;
	}
	@Override
	public String toString() {
		return "SCMovieDto [scm_seq=" + scm_seq + ", mem_id=" + mem_id + ", moviecd=" + moviecd + ", score=" + score
				+ ", scomment=" + scomment + ", likey=" + likey + ", image=" + image + ", movieNm=" + movieNm
				+ ", booking_date=" + booking_date + ", genre_1=" + genre_1 + ", genre_2=" + genre_2 + ", genre_3="
				+ genre_3 + "]";
	}

	
}
