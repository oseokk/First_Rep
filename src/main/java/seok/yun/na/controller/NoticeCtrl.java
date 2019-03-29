package seok.yun.na.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import javax.xml.parsers.ParserConfigurationException;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.xml.sax.SAXException;

import seok.yun.na.dtos.CinemaDto;
import seok.yun.na.dtos.NoticeDto;
import seok.yun.na.model.Dailybox_Kobis;
import seok.yun.na.model.Notice_IService;

@Controller
public class NoticeCtrl {

	private Logger logger = LoggerFactory.getLogger(NoticeCtrl.class);

	@Autowired
	private Notice_IService service;
	@Autowired
	private Dailybox_Kobis dayservice;
	@Autowired
	private Dailybox_Kobis wservice;

	//공지사항 리스트 출력
	@RequestMapping(value="/notice_list.do", method=RequestMethod.GET)
	public String notice_list(Model model) {
		logger.debug("NoticeCtrl notice_list");
		List<NoticeDto> lists =  service.notice_list();
		//		System.out.println(lists);
		model.addAttribute("lists", lists);
		return "noticeList";
	}
	//공지사항 작성버튼 클릭시 등록화면으로 이동
	@RequestMapping(value="/notice_addForm.do", method=RequestMethod.GET)
	public String notice_addForm() {
		logger.info("NoticeCtrl notice_addForm 공지사항등록 화면");
		return "notice_addForm";
	}
	//공지사항 정보 등록
	@RequestMapping(value="/notice_add.do", method=RequestMethod.POST)
	public String notice_add(NoticeDto NoticeDto ,HttpServletRequest request) {
		//			String id = request.getParameter("mem_id");
		//			System.out.println(id+"request 처리 방식");
		System.out.println(NoticeDto);
		logger.debug("NoticeCtrl notice_add = {}", NoticeDto.toString());
		boolean isc =  service.notice_add(NoticeDto); 
		System.out.println("-------------" + isc);
		if(isc == false) {
			return "redirect:/notice_addForm.do"; // redirect통해서 다시 dispatcher
		}else {
			//				return "boardList"; // dispatcher에서 Resolver를 통해 화면
			return "redirect:/notice_list.do";
		}
	}

	//공지사항 다중삭제
	@RequestMapping(value="/notice_delete.do", method=RequestMethod.POST)
	public String notice_delete(String[] chk) {
		Map<String, String[]>map = new HashMap<String,String[]>();
		map.put("ntc_seq_",chk);
		boolean isc = service.notice_delete(map);
		if(isc) {
			return "redirect:/notice_list.do";
		}else {
			return "redirect:/notice_list.do";
		}
		//		System.out.println(chk);
		// String[] chk = request.getParameterValues("chk");
	}
	//공지사항 수정버튼 클릭시 수정화면으로 이동
		@RequestMapping(value="/notice_eForm.do", method=RequestMethod.GET)
		public String notice_eForm(Model model, String ntc_seq) {
			logger.info("NoticeCtrl notice_eForm 공지사항 수정 화면 이동");
			NoticeDto dto =  service.notice_Detail(ntc_seq);
			//  		System.out.println(lists);
			model.addAttribute("dto", dto);
			return "notice_eForm";
		}
	//공지사항 상세정보  
	@RequestMapping(value="/notice_Detail.do", method=RequestMethod.GET)
	public String notice_Detail(Model model, String ntc_seq) {
		logger.debug("NoticeCtrl notice_Detail");
		NoticeDto dto =  service.notice_Detail(ntc_seq);
		//  		System.out.println(lists);
		model.addAttribute("dto", dto);
		return "noticeDetail";

	}

	//공지사항 수정 등록
	@RequestMapping(value="/notice_edit.do", method=RequestMethod.POST)
	public String notice_edit(NoticeDto NoticeDto ,HttpServletRequest request) {
		//					String id = request.getParameter("mem_id");
		//					System.out.println(id+"request 처리 방식");
		System.out.println(NoticeDto);
		logger.debug("NoticeCtrl notice_edit = {}", NoticeDto.toString());
		boolean isc =  service.notice_edit(NoticeDto); 
		System.out.println("-------------" + isc);
		if(isc == false) {
			return "redirect:/notice_eForm.do"; // redirect통해서 다시 dispatcher
		}else {
			//						return "boardList"; // dispatcher에서 Resolver를 통해 화면
			return "redirect:/notice_list.do";
		}
	}
	//공지사항 단일 삭제
	@RequestMapping(value="/notice_sdelete.do", method=RequestMethod.GET)
		public String notice_sdelete(NoticeDto NoticeDto ,HttpServletRequest request) {
			//					String id = request.getParameter("mem_id");
			//					System.out.println(id+"request 처리 방식");
			System.out.println(NoticeDto);
			logger.debug("NoticeCtrl notice_sdelete = {}", NoticeDto.toString());
			boolean isc =  service.notice_sdelete(NoticeDto); 
			System.out.println("-------------" + isc);
			if(isc == false) {
				return "redirect:/notice_list.do"; // redirect통해서 다시 dispatcher
			}else {
				//						return "boardList"; // dispatcher에서 Resolver를 통해 화면
				return "redirect:/notice_list.do";
			}
		}
	//메인 리스트 출력
		@RequestMapping(value="/ac.do", method=RequestMethod.GET)
		public String ac(Model model,HttpSession session) throws ParserConfigurationException, SAXException{
			logger.debug("NoticeCtrl notice_list");
			
			//공지사항 리스트 불러오기
			List<NoticeDto> lists =  service.notice_list();
			//		System.out.println(lists);
			//공지사항 모델에 담기
			model.addAttribute("lists", lists);
			System.out.println(session.getAttribute("dm")+"--------------------------");
			//일별박스오피스
				session.setAttribute("dm", dayservice.searchMovie());
/*			//주간박스오피스
				session.setAttribute("dm2", wservice.searchMovie());		*/		
			return "index2";

			
		}
}




