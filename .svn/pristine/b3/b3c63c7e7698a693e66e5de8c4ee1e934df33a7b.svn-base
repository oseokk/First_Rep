package seok.yun.na.model;

import java.util.List;
import java.util.Map;

import seok.yun.na.dtos.BookingDto;
import seok.yun.na.dtos.MembershipDto;
import seok.yun.na.dtos.SCMovieDto;

public interface SCMoive_IDao {

	//영화에 대한 코멘트 및 평점 작성, 수정
	public boolean scr_update(SCMovieDto dto);
	
	//영화에 대한 코멘트 및 평점 삭제
	public boolean scr_delete(SCMovieDto dto);
	
	//친구들이 작성한 영화평을 조회하는 기능
	public List<SCMovieDto> social_frdCm(Map<String, String> map);
	
	//내가 본 영화 리스트 표출 기능
	public List<SCMovieDto> social_movie(String mem_id);
	
	//내가 좋아요한 영화 리스트를 표출하는 기능
	public List<SCMovieDto> social_like(String mem_id);

	//내가 작성한 평점 리스트를 표출하는 기능
	public List<SCMovieDto> social_write(String mem_id);
	
	//나의 선호장르를 표출하는 기능
	public List<SCMovieDto> social_genre(String mem_id);
}
