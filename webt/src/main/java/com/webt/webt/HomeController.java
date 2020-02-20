package com.webt.webt;

import java.text.DateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Locale;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;


@Controller
public class HomeController {
	
	private static final Logger logger = LoggerFactory.getLogger(HomeController.class);
	
	/**
	 * Simply selects the home view to render by returning its name.
	 */
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String home(Locale locale, Model model) {
		logger.info("Welcome home! The client locale is {}.", locale);
		
		Date date = new Date();
		DateFormat dateFormat = DateFormat.getDateTimeInstance(DateFormat.LONG, DateFormat.LONG, locale);
		
		String formattedDate = dateFormat.format(date);
		
		model.addAttribute("serverTime", formattedDate );
		
		return "index";
	}
	
	
	@RequestMapping("AjaxHome")
	public ModelAndView AjaxHome(HttpServletRequest request) throws Exception{
		ModelAndView mv = new ModelAndView();
		mv.setViewName("ajax_test");
		return mv;
	}
	
	
	@RequestMapping("ajax")
	@ResponseBody
	public ModelAndView ajax(HttpServletRequest request) throws Exception{
		String firstArg = request.getParameter("test1");
		String secondArg = request.getParameter("test2");
		System.out.println("여기 /ajax안!");
		System.out.println(firstArg+" / "+secondArg);
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("test1", firstArg);
		map.put("test2", secondArg);
		System.out.println(map.get("test1"));
		ModelAndView mv = new ModelAndView();
		mv.setViewName("ajax_test");
		mv.addObject("map",map);
		return mv;
	}

}
