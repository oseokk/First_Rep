package seok.yun.na.dtos;

import java.io.Serializable;

public class MembershipDto implements Serializable {

	 
private static final long serialVersionUID = -3288606438413431816L;
		//회원 
	private String mem_id;
	private String mem_pw;
	private String nickname;
	private String mem_bday;
	private String mem_phone;
	private	int mem_point;
	private String mem_level;
	private String mem_del;
	private String nowPw; //db에는 없지만 dto에 임의로 nowPw 파싱해서 넘어가게 함
		//장르,선호장르
	private String genre_1;
	private String genre_2;
	private String genre_3;
	
	
	public MembershipDto() {
		super();
	}


	public String getMem_id() {
		return mem_id;
	}


	public void setMem_id(String mem_id) {
		this.mem_id = mem_id;
	}


	public String getMem_pw() {
		return mem_pw;
	}


	public void setMem_pw(String mem_pw) {
		this.mem_pw = mem_pw;
	}


	public String getNickname() {
		return nickname;
	}


	public void setNickname(String nickname) {
		this.nickname = nickname;
	}


	public String getMem_bday() {
		return mem_bday;
	}


	public void setMem_bday(String mem_bday) {
		this.mem_bday = mem_bday;
	}


	public String getMem_phone() {
		return mem_phone;
	}


	public void setMem_phone(String mem_phone) {
		this.mem_phone = mem_phone;
	}


	public int getMem_point() {
		return mem_point;
	}


	public void setMem_point(int mem_point) {
		this.mem_point = mem_point;
	}


	public String getMem_level() {
		return mem_level;
	}


	public void setMem_level(String mem_level) {
		this.mem_level = mem_level;
	}


	public String getMem_del() {
		return mem_del;
	}


	public void setMem_del(String mem_del) {
		this.mem_del = mem_del;
	}


	public String getNowPw() {
		return nowPw;
	}


	public void setNowPw(String nowPw) {
		this.nowPw = nowPw;
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


	@Override
	public String toString() {
		return "MembershipDto [mem_id=" + mem_id + ", mem_pw=" + mem_pw + ", nickname=" + nickname + ", mem_bday="
				+ mem_bday + ", mem_phone=" + mem_phone + ", mem_point=" + mem_point + ", mem_level=" + mem_level
				+ ", mem_del=" + mem_del + ", nowPw=" + nowPw + ", genre_1=" + genre_1 + ", genre_2=" + genre_2
				+ ", genre_3=" + genre_3 + "]";
	}

	
}