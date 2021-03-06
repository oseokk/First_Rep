package seok.yun.na.controller;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import seok.yun.na.dtos.MembershipDto;
import seok.yun.na.dtos.MessageDto;
import seok.yun.na.model.Message_IService;

@Controller
public class MessageCtrl {

	private Logger logger = LoggerFactory.getLogger(MessageCtrl.class);
	
	@Autowired
	private Message_IService service;
	
	//수신메세지
  	@RequestMapping(value="/msg_list.do", method=RequestMethod.GET)
  	public String msg_list(Model model,MessageDto MessageDto,String mem_id,HttpSession session) {
  		logger.debug("MessageCtrl msg_list");
  		 session.getAttribute("lDto");
  		 session.getMaxInactiveInterval();
		List<MessageDto> lists = service.msg_list(MessageDto.getMem_id());
		System.out.println(lists);
		model.addAttribute("lists", lists);
		return "Msglist";
  	}
  	
//  	//확인안한 메세지 리스트 구현 안할거임
//  	@RequestMapping(value="/msg_nlist.do", method=RequestMethod.GET)
//  	public String msg_nlist(Model model,String mem_id,HttpSession session) {
//  		logger.debug("MessageCtrl msg_nlist");
//  		session.getAttribute("lDto");
//		List<MessageDto> lists =  service.msg_nlist("lDto");
//		System.out.println(lists);
//		model.addAttribute("lists", lists);
//		return "Msgnlist";
//  	}
  	//보낸메세지
  	@RequestMapping(value="/msg_slist.do", method=RequestMethod.GET)
  	public String msg_slist(Model model,String mem_id,MessageDto MessageDto,HttpSession session) {
  		logger.debug("MessageCtrl msg_slist");
		List<MessageDto> lists =  service.msg_slist(MessageDto.getMem_id());
		System.out.println(lists);
		model.addAttribute("lists", lists);
		return "Msgslist";
  	}
	//메세지 작성 버튼 클릭시 등록화면으로 이동
	@RequestMapping(value="/msgregForm.do", method=RequestMethod.GET)
	public String msgregForm() {
		logger.info("MessageCtrl msgregForm");
		return "MsgregForm";
	}
	//메세지페이지로
	@RequestMapping(value="/message.do", method=RequestMethod.GET)
	public String message(HttpSession session ,MessageDto MessageDto, Model model) {
		session.getAttribute("lDto");
		logger.info("MessageCtrl message");
		List<MessageDto> lists = service.msg_list("lDto");
		System.out.println(lists);
		model.addAttribute("lists", lists);
		return "Msglist";
	}
	
	//메세지  보내기 
	@RequestMapping(value="/msg_send.do", method=RequestMethod.POST)
	public String msg_send(MessageDto MessageDto ,HttpServletRequest request,HttpSession session) {
//		String id = request.getParameter("mem_id");
//		System.out.println(id+"request 처리 방식");
		System.out.println(MessageDto);
		logger.debug("MessageCtrl msg_send = {}", MessageDto.toString());
		boolean isc =  service.msg_send(MessageDto);
		System.out.println("-------------" + MessageDto);
		System.out.println("-------------" + isc);
		if(isc == false) {
			return "redirect:/msgregForm.do"; // redirect통해서 다시 dispatcher
		}else {
//			return "boardList"; // dispatcher에서 Resolver를 통해 화면
			return "redirect:/msg_list.do?mem_id="+MessageDto.getMem_id();
		}
		
	}

    @RequestMapping(value="/msg_delete.do", method= {RequestMethod.POST, RequestMethod.GET})
	public String msg_delete(String[] msg_seq,MessageDto MessageDto,HttpSession session,String[] mem_id) {

		Map<String, String[]>map = new HashMap<String,String[]>();
		map.put("msg_seq_",msg_seq);
//		map.put("mem_id",mem_id);
		boolean isc = service.msg_delete(map);
		System.out.println(MessageDto);
		if(isc) {
			return "redirect:/msg_list.do?mem_id="+MessageDto.getMem_id();
		}else {
			System.out.println(isc);
			return "redirect:/msg_list.do?mem_id="+MessageDto.getMem_id();
		}
		//		System.out.println(chk);
		// String[] chk = request.getParameterValues("chk");
	}
   

    @RequestMapping(value="/msg_sdelete.do", method= {RequestMethod.POST, RequestMethod.GET})
	public String msg_sdelete(String[] msg_seq,MessageDto MessageDto,HttpSession session,String[] mem_id) {

		Map<String, String[]>map = new HashMap<String,String[]>();
		map.put("msg_seq_",msg_seq);
//		map.put("mem_id",mem_id);
		boolean isc = service.msg_delete(map);
		System.out.println(MessageDto);
		if(isc) {
			return "redirect:/msg_slist.do?mem_id="+MessageDto.getMem_id();
		}else {
			System.out.println(isc);
			return "redirect:/msg_slist.do?mem_id="+MessageDto.getMem_id();
		}
		//		System.out.println(chk);
		// String[] chk = request.getParameterValues("chk");
	}
    
    
    
    
    
    
    
    
}