package seok.yun.na.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import seok.yun.na.dtos.JSONResult;
import seok.yun.na.dtos.MovieDto;
import seok.yun.na.model.Schedule_IService;

@Controller
public class ScheduleAjaxCtrl {

	private static final Logger logger 
	= LoggerFactory.getLogger(ScheduleAjaxCtrl.class);
	
	@Autowired
	private Schedule_IService service;
	
	
	//일정리스트
		@RequestMapping(value="/schedule_list.do",
		produces="application/json;charset=UTF-8",
		method = RequestMethod.POST)
		@ResponseBody
		public JSONResult sch_view(@ModelAttribute MovieDto MovieDto) {
			logger.debug("sch_view schedule_list = {}",MovieDto.toString());
			List<MovieDto> list = service.sch_view(MovieDto);
			System.out.println(list);
			return JSONResult.success(list);
		
		}
	
	
	
	
	
	
	
}
