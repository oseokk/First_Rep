package seok.yun.na.controller;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpSession;
import javax.xml.parsers.ParserConfigurationException;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import org.springframework.web.bind.annotation.ResponseBody;

import org.xml.sax.SAXException;

import seok.yun.na.dtos.MovieDto;
import seok.yun.na.model.Dailybox_Kobis;

import seok.yun.na.model.Weeklybox_Kobis;

@Controller
public class cinemaCtrlAjax {

	private Logger logger = LoggerFactory.getLogger(cinemaCtrlAjax.class);

	@Autowired
	private Dailybox_Kobis dayservice;
	@Autowired
	private Weeklybox_Kobis wservice;
	
	

	//일별박스오피스 출력하는 기능
	 @RequestMapping(value="/dayboxListAjax.do", 
     produces="application/json;charset=UTF-8" ,
     method={RequestMethod.GET, RequestMethod.POST})
	 	@ResponseBody
	    public  Map<String,List<MovieDto>> dayboxList (HttpSession session) throws ParserConfigurationException, SAXException{
    	 Map<String,List<MovieDto>> map = new HashMap<String,List<MovieDto>>();
		 map.put("dm", dayservice.searchMovie());
//		 model.addAttribute("dm", dayservice.searchMovie());
		 return map;
		 
		 
		}
	 
	 @RequestMapping(value="/weekboxListAjax.do", 
		     produces="application/json;charset=UTF-8" ,
		     method={RequestMethod.GET, RequestMethod.POST})
	//주간박스오피스 출력하는 기능
	 	@ResponseBody
		public Map<String,List<MovieDto>> weekboxList () throws ParserConfigurationException, SAXException{
		 Map<String,List<MovieDto>> map = new HashMap<String,List<MovieDto>>();	
		 map.put("dm", wservice.searchMovie());
		 return map;
			}
}