package seok.yun.na.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import seok.yun.na.dtos.FriendDto;
import seok.yun.na.dtos.SCMovieDto;
import seok.yun.na.model.Friend_IService;

@Controller
public class FriendCtrl {

private Logger logger = LoggerFactory.getLogger(FriendCtrl.class);
	
	@Autowired
	private Friend_IService FService;
	
	
	@RequestMapping(value="/addFriend.do", method=RequestMethod.POST)
	public String addFriend(String mem_id, String frd_id) {
		logger.debug("FriendCtrl addFriend");
		boolean isc = FService.frd_add(new FriendDto(mem_id, frd_id));
		if(isc == true) {
			return "redirect:/social.do?id="+mem_id;
		}else {
			return null;
		}
	}
	@RequestMapping(value="/deleteFriend.do", method=RequestMethod.GET)
	public String deleteFriend(String mem_id, String frd_id) {
		logger.debug("FriendCtrl deleteFriend");
		System.out.println(mem_id+"의 친구 삭제");
		System.out.println("삭제할 친구 아이디 : "+frd_id);
		Map<String, String> map = new HashMap<String, String>();
		map.put("mem_id", mem_id);
		map.put("frd_id", frd_id);
		boolean isc = FService.frd_delete(map);
		if(isc == true) {
			return "redirect:/social.do?id="+mem_id;
		}else {
			return null;
		}
	}
	
}
