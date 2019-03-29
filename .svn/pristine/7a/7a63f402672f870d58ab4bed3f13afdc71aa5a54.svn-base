package seok.yun.na.model;

import java.util.List;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import seok.yun.na.dtos.CinemaDto;
import seok.yun.na.dtos.MembershipDto;
import seok.yun.na.dtos.MessageDto;
import seok.yun.na.dtos.SCMovieDto;

@Service
public class Message_Service implements Message_IService {

private Logger logger = LoggerFactory.getLogger(Message_Service.class);
	
	@Autowired
	private Message_IDao dao;

	@Override
	public List<MessageDto> msg_list(String mem_id) {
		logger.debug("Message_Service msg_list()");
		return dao.msg_list(mem_id);
	}

	@Override
	public List<MessageDto> msg_nlist(String mem_id) {
		logger.debug("Message_Service msg_nlist()");
		return dao.msg_nlist(mem_id);
	}

	@Override
	public List<MessageDto> msg_slist(String mem_id) {
		logger.debug("Message_Service msg_slist()");
		return dao.msg_slist(mem_id);
	}

	@Override
	public boolean msg_send(MessageDto MessageDto) {
		logger.debug("Message_Service msg_send()");
		return dao.msg_send(MessageDto);
	}

	@Override
	public boolean msg_delete(Map<String, String[]> map) {
		logger.debug("Message_Service msg_delete()");
		return dao.msg_delete(map);
	}


}
