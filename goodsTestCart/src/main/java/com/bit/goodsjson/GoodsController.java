package com.bit.goodsjson;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.bit.dao.GoodsDao;
import com.bit.vo.OrderInfo;
import com.fasterxml.jackson.databind.ObjectMapper;

// vo
// mybatis설정
// Manger
// Dao
// Controller 완성
// Ajax통신 완성하기
@Controller
public class GoodsController {
	
	@Autowired
	private GoodsDao dao;
	
	public void setDao(GoodsDao dao) {
		this.dao = dao;
	}


	@RequestMapping("/insertOrder.do")
	public ModelAndView insertOrder(OrderInfo info)
	{	
		ModelAndView mav = new ModelAndView();
		int re = dao.insertOrder(info);
		String msg = "주문성공";
		if(re != 1)
		{
			msg = "주문실패";
		}
		mav.addObject("msg", msg);
		
		
		System.out.println("아이디 : " +info.getId());
		System.out.println("배송지 : " +info.getAddr());
		System.out.println("총구매금액 : " +info.getTotal());
		System.out.println("주문상품수: " +info.getItems().size());
		return mav;
	}
	
	

	@RequestMapping(value="/listGoods.do", produces="text/plain;charset=utf-8")
	@ResponseBody
	public String listJson()
	{
		String str = "";
		ObjectMapper mapper = new ObjectMapper();
		try {
		str = mapper.writeValueAsString(dao.listAll());
		}catch (Exception e) {
			// TODO: handle exception
			System.out.println(e.getMessage());
		}
		return str;
	}
}




