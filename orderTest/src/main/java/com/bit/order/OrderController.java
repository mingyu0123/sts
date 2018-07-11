package com.bit.order;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.bit.dao.BookStoreDao;

@Controller
public class OrderController {

	@Autowired
	private BookStoreDao dao;

	public void setDao(BookStoreDao dao) {
		this.dao = dao;
	}

	@RequestMapping("/order.do")
	public ModelAndView order(String name)
	{
		ModelAndView mav = new ModelAndView();
		Map map = new HashMap();
		map.put("name", name);
		mav.addObject("list", dao.order(map));
		System.out.println(name);
		return mav;
	}

}
