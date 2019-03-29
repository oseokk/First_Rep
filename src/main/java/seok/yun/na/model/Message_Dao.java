package seok.yun.na.model;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.inject.Inject;

import org.apache.ibatis.session.SqlSession;
import org.mybatis.spring.SqlSessionTemplate;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import seok.yun.na.dtos.CinemaDto;
import seok.yun.na.dtos.MessageDto;
import seok.yun.na.dtos.SCMovieDto;

@Repository
public class Message_Dao implements Message_IDao {

	private Logger logger = LoggerFactory.getLogger(Message_Dao.class);
	private final String NS = "seok.yun.na.";
	
	@Autowired
	private SqlSessionTemplate sqlSession;

	@Override
	public List<MessageDto> msg_list(String mem_id) {
		logger.debug("Message_Dao msg_list");
		List<MessageDto> lists = sqlSession.selectList(NS+"msg_list", mem_id);
		return lists;
	}

	@Override
	public List<MessageDto> msg_nlist(String mem_id) {
		logger.debug("Message_Dao msg_nlist");
		List<MessageDto> lists = sqlSession.selectList(NS+"msg_nlist", mem_id);
		return lists;
	}

	@Override
	public List<MessageDto> msg_slist(String mem_id) {
		logger.debug("Message_Dao msg_slist");
		List<MessageDto> lists = sqlSession.selectList(NS+"msg_slist", mem_id);
		return lists;
	}

	@Override
	public boolean msg_send(MessageDto MessageDto) {
		logger.debug("Message_Dao msg_send() 영화관등록");
		Integer n = sqlSession.insert(NS+"msg_send", MessageDto);
		return (n>0)?true:false;
	}

	@Override
	public boolean msg_delete(Map<String, String[]> map) {
		logger.debug("Message_Dao msg_delete");
		int n= sqlSession.delete(NS+"msg_delete",map);
		logger.debug("Message_Dao msg_delete 결과 : {}",n); // slf4j의 문법
		return (n>0)?true:false;
	}

	
}