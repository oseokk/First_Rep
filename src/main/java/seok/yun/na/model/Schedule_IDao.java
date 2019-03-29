package seok.yun.na.model;

import java.util.List;
import java.util.Map;

import seok.yun.na.dtos.MovieDto;

public interface Schedule_IDao {

	//입력 년 월일에 시사회 일정 리스트 (사용자) 
	public List<MovieDto> sch_view(MovieDto MovieDto);
	//개봉일 시사회 일정 입력 (관리자)
	public boolean sch_add(MovieDto MovieDto);
	//개봉일 시사회 일정 삭제 (관리자)
	public boolean sch_delete(MovieDto MovieDto);
	
	
}
