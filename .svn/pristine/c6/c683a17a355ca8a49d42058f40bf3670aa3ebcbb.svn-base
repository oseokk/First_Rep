package seok.yun.na.controller;



import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import seok.yun.na.dtos.MovieDto;
import seok.yun.na.model.Schedule_IService;

@Controller
//@RequestMapping("/calendar.do")
public class ScheduleCtrl {

	private static final Logger logger 
	= LoggerFactory.getLogger(ScheduleCtrl.class);
	
	@Autowired
	private Schedule_IService service;
	
	//캘린더 페이지로
	@RequestMapping(value="/calendar.do", method=RequestMethod.GET)
	public String write() {
		return "schedule_list";
	}

	
	
	//일정추가/삭제 페이지로
	@RequestMapping(value="/schedulemanage.do", method=RequestMethod.GET)
	public String manageMenu(Model model){
		return "schedulemanage";
	}
	
	//일정추가
		@RequestMapping(value="/schedule_add.do", method=RequestMethod.POST)
		public String sch_add(MovieDto MovieDto) {
			logger.debug("sch_add schedule_add = {}",MovieDto.toString());
			boolean isc =service.sch_add(MovieDto);
			if(isc == false) {
				//추가 실패시
				return "redirect:/schedulemanage.do";
			}else {
				//추가 성공시
				return "redirect:/schedulemanage.do";
			}
		
		}
		
		//일정삭제 
		@RequestMapping(value="/schedule_del.do", method=RequestMethod.POST)
		public String sch_delete(MovieDto MovieDto,String title){
			logger.debug("MovieDto update = {}", MovieDto.toString());
			boolean isc =  service.sch_delete(MovieDto);
			
			if(isc == false) {
				//추가 실패시
				return "redirect:/schedulemanage.do"+MovieDto.getTitle();
			}else {
				//추가 성공시
				return "redirect:/schedulemanage.do"+MovieDto.getTitle();
			}
		}
		
		
}
