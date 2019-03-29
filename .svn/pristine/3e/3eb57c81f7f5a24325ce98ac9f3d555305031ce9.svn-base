package seok.yun.na.model;

import java.util.List;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import seok.yun.na.dtos.FriendDto;
@Service
public class Friend_Service implements Friend_IService {

	private Logger logger = LoggerFactory.getLogger(Friend_Service.class);
	@Autowired
	private Friend_IDao dao;
	
	@Override
	public List<FriendDto> frd_view(String mem_id) {
		logger.debug("SCMovie_Service frd_view()");
		return dao.frd_view(mem_id);
	}

	@Override
	public boolean frd_add(FriendDto dto) {
		logger.debug("SCMovie_Service frd_add()");
		return dao.frd_add(dto);
	}

	@Override
	public boolean frd_delete(Map<String, String> map) {
		logger.debug("SCMovie_Service frd_delete()");
		return dao.frd_delete(map);
	}

	

}
