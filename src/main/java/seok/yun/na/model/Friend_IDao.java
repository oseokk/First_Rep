package seok.yun.na.model;

import java.util.List;
import java.util.Map;

import seok.yun.na.dtos.FriendDto;

public interface Friend_IDao {

	//등록된 친구ID리스트 조회하는 기능 
	public List<FriendDto> frd_view(String mem_id);
	
	//친구ID를 통해 친구를 추가하는 기능 
	public boolean frd_add(FriendDto dto);
	
	//친구ID를 통해 친구를 삭제하는 기능
	public boolean frd_delete(Map<String, String> map);
}
