package seok.yun.na.controller;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.xml.parsers.ParserConfigurationException;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.xml.sax.SAXException;

import seok.yun.na.dtos.MembershipDto;
import seok.yun.na.dtos.SCMovieDto;
import seok.yun.na.model.SCMoive_IService;
import seok.yun.na.model.SCMovie_Kobis;

@Controller
public class SocialAjaxCtrl {
	private static final Logger logger 
	= LoggerFactory.getLogger(SocialAjaxCtrl.class);
	
	@Autowired
	private SCMoive_IService SCMService;
    @Autowired
    private SCMovie_Kobis service;
	
	@RequestMapping(value="/newspeedAjax.do", 
			produces="application/json;charset=UTF-8" ,
			method=RequestMethod.POST)
	@ResponseBody
	public Map<String, List<SCMovieDto>> socialMovieAjax(String id, int a) throws IOException, ParserConfigurationException, SAXException{
		logger.debug("socialMovieAjax 컨트롤러 시작");
		Map<String, List<SCMovieDto>> map = new HashMap<String, List<SCMovieDto>>();
		//관람 영화의 날짜와 코드-bookMyMovie 
		List<SCMovieDto> bookMyMovie = SCMService.social_movie(id);
		map.put("changeDate", bookMyMovie);	
		// 관람영화의 이미지, 이름-viewMovie
		map.put("changeMovie", service.searchMovie(bookMyMovie));
		//관람 영화의 친구들 코멘트!
		Map<String, String> map2nd = new HashMap<String, String>();
		map2nd.put("mem_id", id);
		map2nd.put("moviecd", bookMyMovie.get(a).getMoviecd());
		List<SCMovieDto> viewMovieScore = SCMService.social_frdCm(map2nd);
		map.put("changeScore", viewMovieScore);
		return map;
	}
	@RequestMapping(value="/friendAjax.do", 
			produces="application/json;charset=UTF-8" ,
			method=RequestMethod.POST)
	@ResponseBody
	public Map<String, List<SCMovieDto>> friendAjax(String id) throws IOException, ParserConfigurationException, SAXException{
		Map<String, List<SCMovieDto>> map = new HashMap<String, List<SCMovieDto>>();
		List<SCMovieDto> listsGenre = SCMService.social_genre(id);
		map.put("listsGenre", listsGenre);
		//===================================================================
		//관람 영화의 날짜와 코드-bookMyMovie 
		List<SCMovieDto> bookMyMovie = SCMService.social_movie(id);
		map.put("bookMyMovie", bookMyMovie);
		// 관람영화의 이미지, 이름-viewMovie
		map.put("viewMovie", service.searchMovie(bookMyMovie));
		return map;
	}
}
