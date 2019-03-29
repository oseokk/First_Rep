package seok.yun.na.model;

import java.util.List;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import seok.yun.na.dtos.CinemaDto;
import seok.yun.na.dtos.SCMovieDto;

@Service
public class Cinema_Service implements Cinema_IService {

private Logger logger = LoggerFactory.getLogger(Cinema_Service.class);
	
	@Autowired
	private Cinema_IDao dao;
	
	@Override
	public List<CinemaDto> cinemaList() {
		logger.debug("Cinema_Service cinemaList()");
		return dao.cinemaList();
	}

	@Override
	@Transactional 
	public boolean cinema_add(CinemaDto CinemaDto) {
		logger.debug("Cinema_Service cinema_add()");
		return dao.cinema_add(CinemaDto);
	}
	@Override
	public boolean playhall_add(CinemaDto CinemaDto) {
		logger.debug("Cinema_Service playhall_add()");
		return dao.playhall_add(CinemaDto);
	}

	@Override
	public boolean seat_add(CinemaDto CinemaDto) {
		logger.debug("Cinema_Service seat_add()");
		return dao.seat_add(CinemaDto);
	}

	@Override
	public boolean muldel(Map<String, String[]> map) {
		logger.debug("Cinema_Service muldel()");	
		return dao.muldel(map);
	}
	@Override
	public boolean movie_like(SCMovieDto SCMovieDto) {
		logger.debug("SCMovie_Service movie_like()");
		return dao.movie_like(SCMovieDto);
	}

	@Override
	public boolean movie_like2(SCMovieDto dto) {
		logger.debug("SCMovie_Service movie_like2()");
		return dao.movie_like2(dto);
	}

	@Override
	public List<SCMovieDto> movie_score(String moviecd) {
		logger.debug("SCMovie_Service movie_score()");
		return dao.movie_score(moviecd);
	}

	@Override
	public List<CinemaDto> cin_Detail(String cin_cd) {
		logger.debug("Cinema_Service cin_Detail()");
		return dao.cin_Detail(cin_cd);
	}

	@Override
	public List<CinemaDto> phall_Detail(String playhall_cd) {
		logger.debug("Cinema_Service phall_Detail()");
		return dao.phall_Detail(playhall_cd);
	}

	@Override
	public CinemaDto cin_Detail2(String cin_cd) {
		logger.debug("Cinema_Service cin_Detail2()");
		return dao.cin_Detail2(cin_cd);
	}

	@Override
	public CinemaDto phall_Detail2(String playhall_cd) {
		logger.debug("Cinema_Service phall_Detail2()");
		return dao.phall_Detail2(playhall_cd);
	}

	@Override
	public boolean like_dupl(SCMovieDto SCMovieDto) {
		logger.debug("Cinema_Service like_dupl()");
		return dao.like_dupl(SCMovieDto);
	}

	


}
