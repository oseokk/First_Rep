package seok.yun.na.controller;



import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import seok.yun.na.dtos.MembershipDto;
import seok.yun.na.model.Membership_IService;

@Controller
public class MembershipCtrl {

   private static final Logger logger = LoggerFactory.getLogger(MembershipCtrl.class);

   @Autowired
   private Membership_IService service;

   @RequestMapping(value = "/regForm.do", method = RequestMethod.GET)
   public String regForm() {
      logger.info("MembershipCtrl regForm 회원등록 화면");
      return "regForm";
   }

   @RequestMapping(value = "/duplicate.do", method = RequestMethod.GET)
   public String duplicate() {
      logger.info("MembershipCtrl duplicate 중복 팝업");
      return "duplicate";
   }

   @SuppressWarnings("unused")
   @RequestMapping(value = "/regist.do", method = RequestMethod.POST)
   public String regist(MembershipDto MembershipDto, HttpServletRequest request) {
      System.out.println(MembershipDto);
      logger.debug("MembershipCtrl regist = {}", MembershipDto.toString());
      boolean isc = service.user_join(MembershipDto);
      if (isc == false) {
         return "redirect:/regForm.do"; // redirect통해서 다시 dispatcher
      } else {
         // return "boardList"; // dispatcher에서 Resolver를 통해 화면
         return "redirect:/ac.do";
      }

   }

   
   /*@RequestMapping(value = "/login.do",method = RequestMethod.POST)
   public String login(Model model,HttpSession session, String mem_id, String mem_pw, MembershipDto dto, String mem_del) {
      // System.out.println(id+":"+password);
      MembershipDto lDto = service.user_login(new MembershipDto(mem_id, mem_pw));
      session.setAttribute("lDto", lDto);
      System.out.println(lDto);
      if (lDto == null) {
         return "redirect:/main.do";
      } else {
         if ("admin".equals(mem_id)) {
            return "redirect:/adminMain.do";
         } else {
            return "redirect:/ac.do"; // 이쪽으로 가겠다
         }
      }
   }*/

   @RequestMapping(value = "/logout.do", method = RequestMethod.GET)
   public String logout(HttpSession session) {
      MembershipDto dto = (MembershipDto) session.getAttribute("lDto");
      if (dto != null) {
         session.removeAttribute("lDto");
      }
      return "redirect:/ac.do";
   }

   // 유저 페이지로
   @RequestMapping(value = "/userPage.do", method = RequestMethod.GET)
   public String userPage(Model model) {
      return "userPage";
   }

   // 관리자 페이지로
   @RequestMapping(value = "/adminMain.do", method = RequestMethod.GET)
   public String manageMenu(Model model) {
      return "adminMain";
   }

   // 나의페이지로
      @RequestMapping(value = "/mypage.do", method = RequestMethod.GET)
      public String mypage(Model model) {
         return "mypage";
      }
   
   
   
   // 마이페이지회원상세정보조회
   @RequestMapping(value = "/myinfo.do", method = RequestMethod.GET)
   public String myinfo(Model model, HttpSession session, String mem_id) {

      List<MembershipDto> kDto = service.user_confirm(mem_id);
      model.addAttribute("kDto", kDto);
      if (kDto != null) {
         session.removeAttribute("kDto");
      }
      return "myinfo2";

   }
   
   // 정보수정페이지로
   @RequestMapping(value = "/myedit.do", method = RequestMethod.GET)
   public String myedit(Model model, HttpSession session, String mem_id) {
      List<MembershipDto> kDto = service.user_confirm(mem_id);
      model.addAttribute("kDto", kDto);
      if (kDto != null) {
         session.removeAttribute("kDto");
      }
      return "myinfo";
   }
   
   
   

   // 마이페이지에서 상세정보 조회 후 수정
   @RequestMapping(value = "/modify.do", method = RequestMethod.POST)
   public String modify(MembershipDto MembershipDto, HttpServletRequest request) {
      // String id = request.getParameter("mem_id");
      // System.out.println(id+"request 처리 방식");
      System.out.println(MembershipDto);
      logger.debug("MembershipCtrl modify = {}", MembershipDto.toString());
      boolean isc = service.user_edit(MembershipDto);

      if (isc == false) {
         return "redirect:/myedit.do?mem_id=" + MembershipDto.getMem_id(); // redirect통해서 다시 dispatcher
      } else {
         // return "boardList"; // dispatcher에서 Resolver를 통해 화면
         return "redirect:/myinfo.do?mem_id=" + MembershipDto.getMem_id();
      }

   }

   // 회원 탈퇴
   @RequestMapping(value = "/user_delete.do", method = RequestMethod.POST)
   public String user_delete(String mem_id, MembershipDto MembershipDto, Model model) {
      // logger.debug("MembershipCtrl user_delete = {}",mem_id.toString());
      boolean isc = service.user_delete(mem_id);
      // model.addAttribute("mem_id",mem_id);
      // if(isc==false) {
      // return "redirect:/myinfo.do?mem_id="+MembershipDto.getMem_id();
      // }
      return "redirect:/ac.do";
   }

}// class