package seok.yun.na.model;

import java.util.List;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import seok.yun.na.dtos.BookingDto;
import seok.yun.na.dtos.MembershipDto;
import seok.yun.na.dtos.SCMovieDto;
@Service
public class SCMovie_Service implements SCMoive_IService {

	private Logger logger = LoggerFactory.getLogger(SCMovie_Service.class);
	
	@Autowired
	private SCMoive_IDao dao;
	

	@Override
	public boolean scr_update(SCMovieDto dto) {
		logger.debug("SCMovie_Service scr_update()");
		return dao.scr_update(dto);
	}
	
	@Override
	public boolean scr_delete(SCMovieDto dto) {
		logger.debug("SCMovie_Service scr_delete()");
		return dao.scr_delete(dto);
	}

	@Override
	public List<SCMovieDto> social_frdCm(Map<String, String> map) {
		logger.debug("SCMovie_Service social_frdCm()");
		return dao.social_frdCm(map);
	}

	@Override
	public List<SCMovieDto> social_movie(String mem_id) {
		logger.debug("SCMovie_Service social_movie()");
		return dao.social_movie(mem_id);
	}

	@Override
	public List<SCMovieDto> social_like(String mem_id) {
		logger.debug("SCMovie_Service social_like()");
		return dao.social_like(mem_id);
	}

	@Override
	public List<SCMovieDto> social_write(String mem_id) {
		logger.debug("SCMovie_Service social_write()");
		return dao.social_write(mem_id);
	}

	@Override
	public List<SCMovieDto> social_genre(String mem_id) {
		logger.debug("SCMovie_Service social_genre()");
		return dao.social_genre(mem_id);
	}
	
	
	

}
