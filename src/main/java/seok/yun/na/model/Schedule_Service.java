package seok.yun.na.model;

import java.util.List;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import seok.yun.na.dtos.MovieDto;

@Service
public class Schedule_Service implements Schedule_IService {
	
	private Logger logger = LoggerFactory.getLogger(Schedule_Service.class);
	
	@Autowired
	private Schedule_IDao dao;
	
	
	@Override
	public List<MovieDto> sch_view(MovieDto MovieDto) {
		logger.debug("Schedule_Service sch_view()");
		return dao.sch_view(MovieDto);
	}
	@Override
	public boolean sch_add(MovieDto MovieDto) {
		return dao.sch_add(MovieDto);
	}
	@Override
	public boolean sch_delete(MovieDto MovieDto) {
		return dao.sch_delete(MovieDto);
	}
}
