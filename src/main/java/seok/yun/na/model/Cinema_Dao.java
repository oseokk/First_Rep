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
import seok.yun.na.dtos.MembershipDto;
import seok.yun.na.dtos.SCMovieDto;

@Repository
public class Cinema_Dao implements Cinema_IDao {

	private Logger logger = LoggerFactory.getLogger(Cinema_Dao.class);
	private final String NS = "seok.yun.na.";
	
	@Autowired
	private SqlSessionTemplate sqlSession;
	
	@Override
	public List<CinemaDto> cinemaList() {
		return sqlSession.selectList(NS+"cinemaList");
	}

	@Override
	public boolean cinema_add(CinemaDto CinemaDto) {
		logger.debug("Cinema_Dao cinemaInsert() 영화관등록");
		Integer n = sqlSession.insert(NS+"cinema_add", CinemaDto);
		return (n>0)?true:false;
	}

	@Override
	public boolean playhall_add(CinemaDto CinemaDto) {
		logger.debug("Cinema_Dao playhall_add() 상영관등록");
		Integer n = sqlSession.insert(NS+"playhall_add", CinemaDto);
		return (n>0)?true:false;
	}

	@Override
	public boolean seat_add(CinemaDto CinemaDto) {
		logger.debug("Cinema_Dao seat_add() 좌석등록");
		Integer n = sqlSession.insert(NS+"seat_add", CinemaDto);
		return (n>0)?true:false;
	}

	@Override
	public boolean muldel(Map<String, String[]> map) {
		logger.debug("Cinema_Dao cinema_delete");
		int n= sqlSession.delete(NS+"cinema_delete",map);
		logger.debug("Cinema_Dao muldel 결과 : {}",n); // slf4j의 문법
		return (n>0)?true:false;
	}
	//좋아요 기능
	@Override
	public boolean movie_like(SCMovieDto SCMovieDto) {
		logger.debug("SCMovie_Dao movie_like");
		int n = sqlSession.update(NS+"movie_like", SCMovieDto);
		return (n>0)?true:false;
	}

	@Override
	public boolean movie_like2(SCMovieDto dto) {
		logger.debug("SCMovie_Dao movie_like2");
		int n = sqlSession.update(NS+"movie_like2", dto);
		return (n>0)?true:false;
	}

	//영화 상세정보+평점 출력
	@Override
	public List<SCMovieDto> movie_score(String moviecd) {
		List<SCMovieDto> lists = sqlSession.selectList(NS+"movie_score", moviecd);
		return lists;
	}
     
	@Override
	public List<CinemaDto> cin_Detail(String cin_cd) {
		logger.debug("Cinema_Dao cin_Detail");
		List<CinemaDto> lists = sqlSession.selectList(NS+"cin_Detail", cin_cd);
		return lists;
	}

	@Override
	public List<CinemaDto> phall_Detail(String playhall_cd) {
		logger.debug("Cinema_Dao phall_Detail");
		List<CinemaDto> lists = sqlSession.selectList(NS+"phall_Detail", playhall_cd);
		return lists;
	}

	@Override
	public CinemaDto cin_Detail2(String cin_cd) {
		logger.debug("Cinema_Dao cin_Detail2");
		CinemaDto dto = sqlSession.selectOne(NS+"cin_Detail", cin_cd);
		return dto;
	}

	@Override
	public CinemaDto phall_Detail2(String playhall_cd) {
		logger.debug("Cinema_Dao phall_Detail2");
		CinemaDto dto = sqlSession.selectOne(NS+"phall_Detail", playhall_cd);
		return dto;
	}

	@Override
	public boolean like_dupl(SCMovieDto SCMovieDto) {
		logger.debug("Cinema_Dao like_dupl() 관심영화 중복 검사");
		Integer n = sqlSession.selectOne(NS+"like_dupl", SCMovieDto);
		return (n>0)?false:true;
	}



	
}