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

		model.addAttribute("serverTime", formattedDate);

		return "index";
	}

	@RequestMapping(value = "AjaxHome")
	public ModelAndView AjaxHome(HttpServletRequest request) throws Exception {
		ModelAndView mv = new ModelAndView();
		mv.setViewName("ajax_test");
		return mv;
	}

	// 이게 폼!!!
//    @RequestMapping(value="requestObject", method=RequestMethod.POST)
//    @ResponseBody
//    public String simpleWithObject(Jamong jamong) {
//        //필요한 로직 처리
//    	System.out.println("돼냐고");
//    	System.out.println("이름 : "+jamong.getName());
//        return jamong.getName() + jamong.getAge();
//    }

	// 이게 일반 데이터
	@RequestMapping(value = "requestObject", method = RequestMethod.POST)
	@ResponseBody
	public Map<String, Object> ajax(HttpServletRequest request) throws Exception {
		String fA = request.getParameter("test1");
		String sA = request.getParameter("test2");
		System.out.println(fA + " / : " + sA);
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("test1", fA);
		map.put("test2", sA);
		return map;
	}

	@RequestMapping(value = "AjaxHome1")
	public ModelAndView AjaxHome1(HttpServletRequest request) throws Exception {
		ModelAndView mv = new ModelAndView();
		mv.setViewName("ajax_test1");
		return mv;
	}

	// serialize
	@RequestMapping(value = "serialize", method = RequestMethod.POST)
	@ResponseBody
	public String simpleWithObject(Jamong jamong) {
		// 필요한 로직 처리
		System.out.println("돼냐고");
		System.out.println("이름 : " + jamong.getName());
		return jamong.getName() + jamong.getAge();
	}

}
