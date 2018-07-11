package com.bit.goodsjson;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class MainController {

	@RequestMapping("/main.do")
	public ModelAndView main()
	{		
		ModelAndView mav = new ModelAndView();
		mav.addObject("title", "비트몰에 오신것을 환영합니다.");
		return mav;
	}
}
