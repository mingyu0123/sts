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
// mybatis����
// Manger
// Dao
// Controller �ϼ�
// Ajax��� �ϼ��ϱ�
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
		String msg = "�ֹ�����";
		if(re != 1)
		{
			msg = "�ֹ�����";
		}
		mav.addObject("msg", msg);
		
		
		System.out.println("���̵� : " +info.getId());
		System.out.println("����� : " +info.getAddr());
		System.out.println("�ѱ��űݾ� : " +info.getTotal());
		System.out.println("�ֹ���ǰ��: " +info.getItems().size());
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




