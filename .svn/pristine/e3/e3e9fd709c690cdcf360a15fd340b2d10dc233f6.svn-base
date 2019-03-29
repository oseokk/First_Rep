package seok.yun.na.model;

import java.util.List;
import java.util.Map;

import org.mybatis.spring.SqlSessionTemplate;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import seok.yun.na.dtos.BookingDto;
import seok.yun.na.dtos.MembershipDto;
import seok.yun.na.dtos.SCMovieDto;

@Repository
public class SCMovie_Dao implements SCMoive_IDao {

	private Logger logger = LoggerFactory.getLogger(SCMovie_Dao.class);
	private final String NS = "seok.yun.na.";
	@Autowired
	private SqlSessionTemplate sqlSession;
	
	@Override
	public boolean scr_update(SCMovieDto dto) {
		logger.debug("SCMovie_Dao scr_update");
		int n = sqlSession.update(NS+"scr_update", dto);
		return (n>0)?true:false;
	}

	@Override
	public boolean scr_delete(SCMovieDto dto) {
		logger.debug("SCMovie_Dao scr_delete");
		int n = sqlSession.delete(NS+"scr_delete", dto);
		System.out.println("%%%%%%%%%%%%%%%%"+n+"%%%%%%%%%%%%%%%%");
		return (n>0)?true:false;
	}

	@Override
	public List<SCMovieDto> social_frdCm(Map<String, String> map) {
		logger.debug("SCMovie_Dao social_frdCm");
		List<SCMovieDto> lists = sqlSession.selectList(NS+"social_frdCm", map);
		return lists;
	}

	@Override
	public List<SCMovieDto> social_movie(String mem_id) {
		logger.debug("SCMovie_Dao social_movie");
		List<SCMovieDto> lists = sqlSession.selectList(NS+"social_movie", mem_id);
		return lists;
	}

	@Override
	public List<SCMovieDto> social_like(String mem_id) {
		logger.debug("SCMovie_Dao social_like");
		List<SCMovieDto> lists = sqlSession.selectList(NS+"social_like", mem_id);
		return lists;
	}

	@Override
	public List<SCMovieDto> social_write(String mem_id) {
		logger.debug("SCMovie_Dao social_write");
		List<SCMovieDto> lists = sqlSession.selectList(NS+"social_write", mem_id);
		return lists;
	}

	@Override
	public List<SCMovieDto> social_genre(String mem_id) {
		logger.debug("SCMovie_Dao social_genre");
		List<SCMovieDto> lists = sqlSession.selectList(NS+"social_genre", mem_id);
		return lists;
	}

	

}
