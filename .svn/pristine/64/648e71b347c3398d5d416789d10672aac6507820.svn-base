package seok.yun.na.model;

import java.util.List;
import java.util.Map;

import seok.yun.na.dtos.CinemaDto;
import seok.yun.na.dtos.MessageDto;
import seok.yun.na.dtos.SCMovieDto;

public interface Message_IDao {
	
	//받은 메세지 전체리스트
	public List<MessageDto> msg_list(String mem_id);
	//받은 메세지 안읽은리스트
	public List<MessageDto> msg_nlist(String mem_id);
	//보낸 메세지 리스트
	public List<MessageDto> msg_slist(String mem_id);
	//메세지 보내기
	public boolean msg_send(MessageDto MessageDto);
	//메세지 다중 삭제
	public boolean msg_delete(Map<String, String[]> map);

}
