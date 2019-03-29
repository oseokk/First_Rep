package seok.yun.na.dtos;

import java.io.Serializable;

public class MovieDto implements Serializable{

	
	
	private static final long serialVersionUID = 5909348049214849550L;
///////////////////////////////////////////////naver
	private String title;// 검색 결과 영화의 제목을 나타낸다. 제목에서 검색어와 일치하는 부분은 태그로 감싸져 있다.
	private String link;// 검색 결과 영화의 하이퍼텍스트 link를 나타낸다.
	private String image; // 검색 결과 영화의 썸네일 이미지의 URL이다. 이미지가 있는 경우만 나타난다.
	private String subtitle; // 검색 결과 영화의 영문 제목이다.
	private String pubdate; // 검색 결과 영화의 제작년도이다.
	private String director; // 검색 결과 영화의 감독이다.
	private String actor;// 검색 결과 영화의 출연 배우이다.
	private String rss;
///////////////////////////////////////////////kobis
	private String moviecd;	//영화코드
	private String movieNm;	//영화명
	private String movieNmEn;//영화영문명
	private String showTm; //상영시간
	private String prdtYear;//제작년도
	private String openDt;//개봉일
	private String rank;	//순위
	private String audicnt;	//관객수
/////////////////////스케쥴 table 
	private String startDate; //개봉일 OPEN_DATE alias
	private String previewdate;
	private String endDate; //개봉일 2 open_datec alias
	private String scheduleContent; //title alias
//////////////////////////영화검색
	private String nationAlt;
	private String genreAlt;
	
	public MovieDto() {
		super();
		// TODO Auto-generated constructor stub
	}

	public MovieDto(String title, String link, String image, String subtitle, String pubdate, String director,
			String actor, String rss, String moviecd, String movieNm, String movieNmEn, String showTm, String prdtYear,
			String openDt, String rank, String audicnt, String startDate, String previewdate, String endDate,
			String scheduleContent, String nationAlt, String genreAlt) {
		super();
		this.title = title;
		this.link = link;
		this.image = image;
		this.subtitle = subtitle;
		this.pubdate = pubdate;
		this.director = director;
		this.actor = actor;
		this.rss = rss;
		this.moviecd = moviecd;
		this.movieNm = movieNm;
		this.movieNmEn = movieNmEn;
		this.showTm = showTm;
		this.prdtYear = prdtYear;
		this.openDt = openDt;
		this.rank = rank;
		this.audicnt = audicnt;
		this.startDate = startDate;
		this.previewdate = previewdate;
		this.endDate = endDate;
		this.scheduleContent = scheduleContent;
		this.nationAlt = nationAlt;
		this.genreAlt = genreAlt;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getLink() {
		return link;
	}

	public void setLink(String link) {
		this.link = link;
	}

	public String getImage() {
		return image;
	}

	public void setImage(String image) {
		this.image = image;
	}

	public String getSubtitle() {
		return subtitle;
	}

	public void setSubtitle(String subtitle) {
		this.subtitle = subtitle;
	}

	public String getPubdate() {
		return pubdate;
	}

	public void setPubdate(String pubdate) {
		this.pubdate = pubdate;
	}

	public String getDirector() {
		return director;
	}

	public void setDirector(String director) {
		this.director = director;
	}

	public String getActor() {
		return actor;
	}

	public void setActor(String actor) {
		this.actor = actor;
	}

	public String getRss() {
		return rss;
	}

	public void setRss(String rss) {
		this.rss = rss;
	}

	public String getMoviecd() {
		return moviecd;
	}

	public void setMoviecd(String moviecd) {
		this.moviecd = moviecd;
	}

	public String getMovieNm() {
		return movieNm;
	}

	public void setMovieNm(String movieNm) {
		this.movieNm = movieNm;
	}

	public String getMovieNmEn() {
		return movieNmEn;
	}

	public void setMovieNmEn(String movieNmEn) {
		this.movieNmEn = movieNmEn;
	}

	public String getShowTm() {
		return showTm;
	}

	public void setShowTm(String showTm) {
		this.showTm = showTm;
	}

	public String getPrdtYear() {
		return prdtYear;
	}

	public void setPrdtYear(String prdtYear) {
		this.prdtYear = prdtYear;
	}

	public String getOpenDt() {
		return openDt;
	}

	public void setOpenDt(String openDt) {
		this.openDt = openDt;
	}

	public String getRank() {
		return rank;
	}

	public void setRank(String rank) {
		this.rank = rank;
	}

	public String getAudicnt() {
		return audicnt;
	}

	public void setAudicnt(String audicnt) {
		this.audicnt = audicnt;
	}

	public String getStartDate() {
		return startDate;
	}

	public void setStartDate(String startDate) {
		this.startDate = startDate;
	}

	public String getPreviewdate() {
		return previewdate;
	}

	public void setPreviewdate(String previewdate) {
		this.previewdate = previewdate;
	}

	public String getEndDate() {
		return endDate;
	}

	public void setEndDate(String endDate) {
		this.endDate = endDate;
	}

	public String getScheduleContent() {
		return scheduleContent;
	}

	public void setScheduleContent(String scheduleContent) {
		this.scheduleContent = scheduleContent;
	}

	public String getNationAlt() {
		return nationAlt;
	}

	public void setNationAlt(String nationAlt) {
		this.nationAlt = nationAlt;
	}

	public String getGenreAlt() {
		return genreAlt;
	}

	public void setGenreAlt(String genreAlt) {
		this.genreAlt = genreAlt;
	}

	@Override
	public String toString() {
		return "MovieDto [title=" + title + ", link=" + link + ", image=" + image + ", subtitle=" + subtitle
				+ ", pubdate=" + pubdate + ", director=" + director + ", actor=" + actor + ", rss=" + rss + ", moviecd="
				+ moviecd + ", movieNm=" + movieNm + ", movieNmEn=" + movieNmEn + ", showTm=" + showTm + ", prdtYear="
				+ prdtYear + ", openDt=" + openDt + ", rank=" + rank + ", audicnt=" + audicnt + ", startDate="
				+ startDate + ", previewdate=" + previewdate + ", endDate=" + endDate + ", scheduleContent="
				+ scheduleContent + ", nationAlt=" + nationAlt + ", genreAlt=" + genreAlt + "]";
	}

	
	
}