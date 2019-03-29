package seok.yun.na.controller;

import java.util.Locale;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class HomeController {
	private static final Logger logger 
				= LoggerFactory.getLogger(HomeController.class);
	
	@RequestMapping(value="/main.do", method=RequestMethod.GET)
	public String home(Model model, Locale locale) {
		logger.info("Welcome home {}", locale);
		return "home";
	}
	@RequestMapping(value="/main2.do", method=RequestMethod.GET)
	public String home(Model model, Locale locale, String moviecd) {
		logger.info("Welcome home {}", locale);
		model.addAttribute("moviecd", moviecd);
		return "Poplogin";
	}
	
	
}






