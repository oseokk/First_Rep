package seok.yun.na.model;

import java.util.List;
import java.util.Map;

import org.mybatis.spring.SqlSessionTemplate;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import seok.yun.na.dtos.FriendDto;

@Repository
public class Friend_Dao implements Friend_IDao {

	private Logger logger = LoggerFactory.getLogger(Friend_Dao.class);
	private final String NS = "seok.yun.na.";
	
	@Autowired
	private SqlSessionTemplate sqlSession;
	
	@Override
	public List<FriendDto> frd_view(String mem_id) {
		logger.debug("Friend_Dao frd_view");
		List<FriendDto> lists=sqlSession.selectList(NS+"frd_view", mem_id);
		return lists;
	}

	@Override
	public boolean frd_add(FriendDto dto) {
		logger.debug("SCMovie_Dao frd_add");
		int n = sqlSession.insert(NS+"frd_add", dto);
		System.out.println("====================="+n);
		return (n>0)?true:false;
	}

	@Override
	public boolean frd_delete(Map<String, String> map) {
		logger.debug("SCMovie_Dao frd_delete");
		int n = sqlSession.update(NS+"frd_delete", map);
		return (n>0)?true:false;
	}


}
