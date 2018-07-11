package com.bit.db;

import java.io.InputStream;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import com.bit.vo.GoodsVo;
import com.bit.vo.OrderDetail;
import com.bit.vo.OrderInfo;


public class GoodsManager {
	private static SqlSessionFactory factory;
	static {
		try {
			String resource = "com/bit/db/mabatisConfig.xml";
			InputStream inputStream = Resources.getResourceAsStream(resource);
			factory =
			  new SqlSessionFactoryBuilder().build(inputStream);
			
		}catch (Exception e) {
			// TODO: handle exception
			System.out.println(e.getMessage());
		}
		
	}
	
	public static int insertOrder(OrderInfo info)
	{
		int re = -1;
		
		int cnt = 0;
		int okCnt = info.getItems().size()*2+1;
		
		SqlSession session= factory.openSession();
		
		//새로운 주문을 위한 주문번호
		//주문상세에서 참조된다.
		int no = session.selectOne("goods.nextOrdersNo");
		
		HashMap orderMap = new HashMap();
		orderMap.put("no", no);		
		orderMap.put("id", info.getId());		
		orderMap.put("total", info.getTotal());		
		orderMap.put("addr", info.getAddr());		
		
		cnt = cnt + session.insert("goods.insertOrders",orderMap);
		
		for( OrderDetail od  :info.getItems())
		{
			HashMap detail = new HashMap();
			detail.put("gno", od.getNo());
			detail.put("qty", od.getQty());
			detail.put("ono", no);
			
			cnt = cnt+ session.insert("goods.insertDetail",detail);
			cnt = cnt+ session.update("goods.downQty",detail);
		}
		
		
		if(cnt == okCnt)
		{
			session.commit();
			re = 1;
		}
		else
		{
			session.rollback();
		}
		
		session.close();
		return re;
	}
	
	
	public static int delete(int no)
	{
		Map map = new HashMap();
		map.put("no", no);
		int re =  -1;
		SqlSession session = factory.openSession();
		re = session.update("goods.delete", map);
		System.out.println("re:"+re);
		session.commit();
		session.close();
		return re;
	}
	
	public static int update(GoodsVo g)
	{
		int re =  -1;
		SqlSession session = factory.openSession();
		re = session.update("goods.update", g);
		session.commit();
		session.close();
		return re;
	}
	
	public static int insert(GoodsVo g)
	{
		int re =  -1;
		SqlSession session = factory.openSession();
		re = session.insert("goods.insert", g);
		session.commit();
		session.close();
		return re;
	}
	
	public static GoodsVo getGoods(int no)
	{
		Map map = new HashMap();
		map.put("no", no);
		GoodsVo g = null;
		SqlSession session = factory.openSession();
		g= session.selectOne("goods.getGoods", map);
		session.close();
		return g;
	}
	
	public static List<GoodsVo> list()
	{
		List<GoodsVo> list = null;
		SqlSession session = factory.openSession();
		list= session.selectList("goods.selectAll");
		session.close();
		return list;
	}

	
}














