package seok.yun.na.controller;

import java.io.IOException;
import java.util.ArrayList;
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

import seok.yun.na.dtos.BookingDto;
import seok.yun.na.dtos.FriendDto;
import seok.yun.na.dtos.MembershipDto;
import seok.yun.na.dtos.SCMovieDto;
import seok.yun.na.model.SCMovie_Kobis;
import seok.yun.na.model.Friend_IService;
import seok.yun.na.model.SCMoive_IService;

@Controller
public class SocialCtrl {

   private Logger logger = LoggerFactory.getLogger(SocialCtrl.class);
   
   @Autowired
   private SCMoive_IService SCMService;
    @Autowired
    private SCMovie_Kobis service;
   @Autowired
   private Friend_IService FService;
   
   @RequestMapping(value="/social.do", method={RequestMethod.POST, RequestMethod.GET})
   public String socialMain(String id, Model model) throws IOException, ParserConfigurationException, SAXException {
      logger.debug("socialCtrl socialMain");
      model.addAttribute("id",id);
      //장르를 리스트로 담음
      List<SCMovieDto> listsGenre = SCMService.social_genre(id);
      model.addAttribute("listsGenre", listsGenre);
      
      //===================================================================
      //관람 영화의 날짜와 코드-bookMyMovie 
      List<SCMovieDto> bookMyMovie = SCMService.social_movie(id);
      model.addAttribute("bookMyMovie", bookMyMovie);
      // 관람영화의 이미지, 이름-viewMovie
      if(bookMyMovie!=null) {
      model.addAttribute("viewMovie", service.searchMovie(bookMyMovie));
      
      //관람 영화의 친구들 코멘트!
      Map<String, String> map = new HashMap<String, String>();
      map.put("mem_id", id);
      map.put("moviecd", bookMyMovie.get(0).getMoviecd());
      List<SCMovieDto> viewMovieScore = SCMService.social_frdCm(map);
      model.addAttribute("viewMovieScore", viewMovieScore);
      //=========================================================================
      //관심영화 이미지와 이름-likeMovie
      List<SCMovieDto> likeMovie= SCMService.social_like(id);
      model.addAttribute("seq", likeMovie);
      model.addAttribute("likeMovie", service.searchMovie(likeMovie));
      //내가 작성한 평점 
      List<SCMovieDto> myWrite= SCMService.social_write(id);
      model.addAttribute("myWrite", myWrite);
      model.addAttribute("myWriteName", service.searchMovie(myWrite));
      }
      logger.debug("FriendCtrl friendsView");
      List<FriendDto> lists = FService.frd_view(id);
      model.addAttribute("FList", lists);
      return "socialMain";
   }
   
   @RequestMapping(value="/updateSC.do", method={RequestMethod.POST, RequestMethod.GET})
   public String updateSC(SCMovieDto dto) {
      logger.debug("socialCtrl writeSC");
      boolean isc = SCMService.scr_update(dto);
      String id=dto.getMem_id();
      if(isc == true) {
         return "redirect:/social.do?id="+id;
      }else {
         return "Error";
      }
   }
   @RequestMapping(value="/removieCmd.do", method={RequestMethod.POST, RequestMethod.GET})
   public String removieCmd(String code, String id) {
      logger.debug("socialCtrl writeSC");
      SCMovieDto NEWdto = new SCMovieDto();
      NEWdto.setScore(-1);
      NEWdto.setScomment("");
      NEWdto.setMoviecd(code);
      NEWdto.setMem_id(id);
      boolean isc = SCMService.scr_update(NEWdto);
      if(isc == true) {
         return "redirect:/social.do?id="+id;
      }else {
         return "Error";
      }
   }
   
   @RequestMapping(value="/deleteSC.do", method={RequestMethod.POST, RequestMethod.GET})
   public String deleteSC(int seq, String id) {
      logger.debug("socialCtrl DeleteComment");
      SCMovieDto dto = new SCMovieDto();
      dto.setScm_seq(seq);
      boolean isc = SCMService.scr_delete(dto);
      if(isc == true) {
         return "redirect:/social.do?id"+id;
      }else {
         return "Error";
      }
   }

   
   

}