package seok.yun.na.controller;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import seok.yun.na.dtos.MembershipDto;
import seok.yun.na.model.Membership_IService;


@Controller
public class MembershipCtrlAjax {
   private static final Logger logger 
   = LoggerFactory.getLogger(MembershipCtrlAjax.class);
   
   @Autowired
   private Membership_IService service;
   
   //아이디중복검사
   @RequestMapping(value="/duplicateAjax.do", 
         produces="application/json;charset=UTF-8" ,
         method=RequestMethod.POST)
   @ResponseBody
   public Map<String, Boolean> duplicationAjax(String chkId){
      logger.info("MembershipCtrlAjax 아이디중복 검사 id={}", chkId);
      Map<String, Boolean> map = new HashMap<String, Boolean>();
      boolean isc = service.user_dupl(chkId);
      System.out.println(isc+"------------중복검사 확인");
      map.put("isc", isc);
      return map;
   }
   //로그인 아작스처리
   @RequestMapping(value="/login.do", 
            produces="application/json;charset=UTF-8" ,
            method=RequestMethod.POST)
      @ResponseBody
      public Map<String, MembershipDto> loginAjax(HttpSession session, String id, String pw) throws IOException{
         Map<String, MembershipDto> map = new HashMap<String, MembershipDto>();
         MembershipDto lDto = new MembershipDto();
         //화면에서 입력 받은 id와 pw
         lDto.setMem_id(id);
         lDto.setMem_pw(pw);
         lDto = service.user_login(lDto);
         session.setAttribute("lDto", lDto);
         map.put("lDto", lDto);
         return map;
      }
}//class