package seok.yun.na.model;

import java.util.List;
import java.util.Map;

import org.mybatis.spring.SqlSessionTemplate;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import seok.yun.na.dtos.MovieDto;


@Repository
public class Schedule_Dao implements Schedule_IDao {

	private final String NAME = "seok.yun.na.";
	private Logger logger = LoggerFactory.getLogger(Schedule_Dao.class);
	@Autowired
	private SqlSessionTemplate sqlSession;
	
	@Override
	public List<MovieDto> sch_view(MovieDto MovieDto) {
	logger.debug("Cinema_Dao sch_view() 영화개봉일시사회조회");
	return sqlSession.selectList(NAME+"sch_view",MovieDto);
	}
	
	@Override
	public boolean sch_add(MovieDto MovieDto) {
		logger.debug("Schedule_Dao sch_add() 시사회개봉일일정추가");
		int n =  sqlSession.insert(NAME+"sch_add", MovieDto);
		return (n>0)?true:false;
	}

	@Override
	public boolean sch_delete(MovieDto MovieDto) {
		logger.debug("Schedule_Dao sch_delete() 시사회개봉일일정삭제");
		int n =  sqlSession.update(NAME+"sch_delete", MovieDto);
		return (n>0)?true:false;
	}


	

	
	
	
	
}
