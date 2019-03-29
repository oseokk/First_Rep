package seok.yun.na.model;

import java.util.List;
import java.util.Map;

import seok.yun.na.dtos.CinemaDto;
import seok.yun.na.dtos.NoticeDto;
import seok.yun.na.dtos.SCMovieDto;

public interface Notice_IService {

	//공지사항 리스트
	public List<NoticeDto> notice_list();
	//공지사항 입력
	public boolean notice_add(NoticeDto NoticeDto);
	//공지사항 다중 삭제
	public boolean notice_delete(Map<String, String[]> map);
	//공지사항 상세정보 기능
	public NoticeDto notice_Detail(String ntc_seq);
	//공지사항 수정
	public boolean notice_edit(NoticeDto NoticeDto);
	//공지사항 단일삭제
	public boolean notice_sdelete(NoticeDto NoticeDto);

}
