package seok.yun.na.controller;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.xml.parsers.ParserConfigurationException;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;
import org.xml.sax.SAXException;

import seok.yun.na.dtos.BookingDto;
import seok.yun.na.dtos.CinemaDto;
import seok.yun.na.dtos.MembershipDto;
import seok.yun.na.dtos.MovieDto;
import seok.yun.na.dtos.SCMovieDto;
import seok.yun.na.model.Cinema_IService;
import seok.yun.na.model.Cinema_Service;
import seok.yun.na.model.Dailybox_Kobis;
import seok.yun.na.model.DetailMovie_Kobis;
import seok.yun.na.model.SCMoive_IService;
import seok.yun.na.model.SCMovie_Kobis;
import seok.yun.na.model.Search_Kobis;
import seok.yun.na.model.Weeklybox_Kobis;

@Controller
public class cinemaCtrl {

	private Logger logger = LoggerFactory.getLogger(cinemaCtrl.class);

	@Autowired
	private Cinema_IService service;
	@Autowired
	private DetailMovie_Kobis dservice;
	@Autowired
	private Dailybox_Kobis dayservice;
	@Autowired
	private Weeklybox_Kobis wservice;
	@Autowired
	private Search_Kobis sservice;

	//영화관 리스트 출력
	@RequestMapping(value="/cinemaList.do", method=RequestMethod.GET)
	public String cinemaList(Model model) {
		logger.debug("cinemaCtrl cinemaList");
		List<CinemaDto> lists =  service.cinemaList();
		//		System.out.println(lists);
		model.addAttribute("lists", lists);
		return "cinemaList";
	}
	//영화관 등록버튼 클릭시 등록화면으로 이동
	@RequestMapping(value="/cinemaregForm.do", method=RequestMethod.GET)
	public String regForm() {
		logger.info("cinemaCtrl cinregForm 영화관등록 화면 이동");
		return "cinregForm";
	}
	//상영관 등록버튼 클릭시 등록화면으로 이동
	@RequestMapping(value="/phallregForm.do", method=RequestMethod.GET)
	public String phallregForm(Model model, String cin_cd) {
		logger.info("cinemaCtrl phallregForm 상영관등록 화면 이동");
		List<CinemaDto> lists =  service.cin_Detail(cin_cd);
		model.addAttribute("lists",lists);
		model.addAttribute("cin_cd", cin_cd);
		return "phallregForm";
	}
	//좌석 등록버튼 클릭시 등록화면으로 이동
	@RequestMapping(value="/seatregForm.do", method=RequestMethod.GET)
	public String seatregForm(Model model, String playhall_cd) {
		logger.info("cinemaCtrl seatregForm 좌석등록 화면 이동");
		List<CinemaDto> lists =  service.phall_Detail(playhall_cd);
		model.addAttribute("lists",lists);
		model.addAttribute("playhall_cd", playhall_cd);
		return "seatregForm";
	}
	//영화관 등록
	@RequestMapping(value="/cinema_add.do", method=RequestMethod.POST)
	public String cinema_add(CinemaDto CinemaDto ,HttpServletRequest request) {
		//		String id = request.getParameter("mem_id");
		//		System.out.println(id+"request 처리 방식");
		System.out.println(CinemaDto);
		logger.debug("cinemaCtrl cinema_add = {}", CinemaDto.toString());
		boolean isc =  service.cinema_add(CinemaDto); 
		System.out.println("-------------" + isc);
		if(isc == false) {
			return "redirect:/cinemaregForm.do"; // redirect통해서 다시 dispatcher
		}else {
			//			return "boardList"; // dispatcher에서 Resolver를 통해 화면
			return "redirect:/cinemaList.do";
		}
	}
	//상영관 등록
	@RequestMapping(value="/playhall_add.do", method=RequestMethod.POST)
	public String playhall_add(CinemaDto CinemaDto ,HttpServletRequest request) {
		//		String id = request.getParameter("mem_id");
		//		System.out.println(id+"request 처리 방식");
		System.out.println(CinemaDto);
		logger.debug("cinemaCtrl playhall_add = {}", CinemaDto.toString());
		boolean isc =  service.playhall_add(CinemaDto); 
		System.out.println("-------------" + isc);
		if(isc == false) {
			return "redirect:/phallregForm.do"; // redirect통해서 다시 dispatcher
		}else {
			//			return "boardList"; // dispatcher에서 Resolver를 통해 화면
			return "redirect:/cinemaList.do";
		}	

	}
	//좌석 등록
	@RequestMapping(value="/seat_add.do", method=RequestMethod.POST)
	public String seat_add(CinemaDto CinemaDto ,HttpServletRequest request) {
		//		String id = request.getParameter("mem_id");
		//		System.out.println(id+"request 처리 방식");
		System.out.println(CinemaDto);
		logger.debug("cinemaCtrl seat_add = {}", CinemaDto.toString());
		boolean isc =  service.seat_add(CinemaDto); 
		System.out.println("-------------" + isc);
		if(isc == false) {
			return "redirect:/seatregForm.do"; // redirect통해서 다시 dispatcher
		}else {
			//			return "boardList"; // dispatcher에서 Resolver를 통해 화면
			return "redirect:/cinemaList.do";
		}
	}
	@RequestMapping(value="/cinemaupdate.do", method=RequestMethod.POST)
	public String update(@ModelAttribute CinemaDto CinemaDto){
		return "redirect:list.do";
	}
	@RequestMapping(value="/muldel.do", method=RequestMethod.POST)
	public String muldel(String[] chk) {
		Map<String, String[]>map = new HashMap<String,String[]>();
		map.put("cin_cd_",chk);
		boolean isc = service.muldel(map);
		if(isc) {
			return "redirect:/cinemaList.do";
		}else {
			return "redirect:/cinemaList.do";
		}
		//		System.out.println(chk);
		// String[] chk = request.getParameterValues("chk");
	}
	//영화 평점 출력하는 기능
	@RequestMapping(value="/movie_like.do", method=RequestMethod.GET)
	public String movie_like(Model model,String moviecd, HttpSession session, MembershipDto lDto) throws IOException, ParserConfigurationException, SAXException {
		logger.debug("bookingCtrl movie_like");
		SCMovieDto dto = new SCMovieDto();
		MembershipDto mdto =  (MembershipDto)session.getAttribute("lDto");
		System.out.println(mdto+"----------------------");
		
		if(mdto != null) {
			dto.setMem_id(mdto.getMem_id());
			dto.setMoviecd(moviecd);
			boolean isc = service.like_dupl(dto);
			model.addAttribute("isc", isc);
			
		}
		List<SCMovieDto> lists =  service.movie_score(moviecd);	
		model.addAttribute("lists", lists);
		model.addAttribute("dm", dservice.searchMovie(moviecd));
		
		return "scoreList";
	}
	//영화관 상세정보
	@RequestMapping(value="/cin_Detail.do", method=RequestMethod.GET)
	public String cin_Detail(Model model, String cin_cd) {
		logger.debug("cinemaCtrl cin_Detail");
		List<CinemaDto> lists =  service.cin_Detail(cin_cd);
		//  		System.out.println(lists);
		model.addAttribute("lists", lists);
		model.addAttribute("cin_cd", cin_cd);
		
		return "cinDetail";
	}
	//상영관 상세정보
	@RequestMapping(value="/phall_Detail.do", method=RequestMethod.GET)
	public String phall_Detail(Model model, String playhall_cd) {
		logger.debug("cinemaCtrl phall_Detail");
		List<CinemaDto> lists =  service.phall_Detail(playhall_cd);
		//  		System.out.println(lists);
		model.addAttribute("lists", lists);
		model.addAttribute("playhall_cd", playhall_cd);
		return "phallDetail";
	}
	//일별박스오피스 출력하는 기능
	@RequestMapping(value="/dayboxList.do", method=RequestMethod.GET)
	public String dayboxList (Model model) throws ParserConfigurationException, SAXException{
		model.addAttribute("dm", dayservice.searchMovie());
		return "DayboxList";
	}
	//주간박스오피스 출력하는 기능
	@RequestMapping(value="/weekboxList.do", method=RequestMethod.GET)
	public String weekboxList (Model model) throws ParserConfigurationException, SAXException{
		model.addAttribute("dm", wservice.searchMovie());
		return "WeekboxList";
	}
	//영화 검색버튼 누르면 정보 출력하는 기능
	@RequestMapping(value="/msearch.do", method=RequestMethod.GET)
	public String msearch(Model model,String keyword) throws IOException, ParserConfigurationException, SAXException {
		logger.debug("cinemaCtrl msearch");
		
		model.addAttribute("SR", sservice.searchMovie(keyword));
	        
		return "SearchMovie";
	        }
	//관심리스트 등록
		@RequestMapping(value="/like.do", method={RequestMethod.GET, RequestMethod.POST})
		public String like(SCMovieDto SCMovieDto ,HttpServletRequest request, HttpServletResponse response) throws IOException {
			System.out.println(SCMovieDto);
			logger.debug("cinemaCtrl like = {}", SCMovieDto.toString()); 
			logger.debug("DTO ID", SCMovieDto.getMem_id().toString());
				boolean isc =  service.movie_like(SCMovieDto);
			System.out.println("-------------" + isc);
			 if(isc == false) {
				return "redirect:/movie_like.do?moviecd="+SCMovieDto.getMoviecd(); // redirect통해서 다시 dispatcher
			}else {
				//			return "boardList"; // dispatcher에서 Resolver를 통해 화면
				return "redirect:/movie_like.do?moviecd="+SCMovieDto.getMoviecd();
			      }
			
		}
	}