package seok.yun.na.model;

import java.util.List;
import java.util.Map;

import seok.yun.na.dtos.CinemaDto;
import seok.yun.na.dtos.SCMovieDto;

public interface Cinema_IService {

	//영화관 리스트
	public List<CinemaDto> cinemaList();
	//영화관 입력
	public boolean cinema_add(CinemaDto CinemaDto);
	//상영관 입력
	public boolean playhall_add(CinemaDto CinemaDto);
	//좌석 입력
	public boolean seat_add(CinemaDto CinemaDto);	
	//영화관 다중 삭제
	public boolean muldel(Map<String, String[]> map);
	//영화 '좋아요'버튼 선택 기능
	public boolean movie_like(SCMovieDto SCMovieDto);
	//영화 '좋아요'버튼 취소 기능
	public boolean movie_like2(SCMovieDto dto);
	//영화 평점을 출력하는 기능
	public List<SCMovieDto> movie_score(String moviecd);
	//영화관 상세정보 기능
	public List<CinemaDto> cin_Detail(String cin_cd);
	//영화관 상세정보 기능DTO
	public CinemaDto cin_Detail2(String cin_cd);
	//상영관 상세정보 기능
	public List<CinemaDto> phall_Detail(String playhall_cd);
	//상영관 상세정보 기능
	public CinemaDto phall_Detail2(String playhall_cd);
	//관심영화 중복체크 기능	
	public boolean like_dupl(SCMovieDto SCMovieDto);
}
