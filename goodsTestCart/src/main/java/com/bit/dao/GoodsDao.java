package com.bit.dao;

import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Repository;

import com.bit.db.GoodsManager;
import com.bit.vo.GoodsVo;
import com.bit.vo.OrderInfo;

@Repository
public class GoodsDao {
	
	public int insertOrder(OrderInfo info)
	{
		return GoodsManager.insertOrder(info);
	}
	
	public int delete(int no)
	{
		return GoodsManager.delete(no);
	}
	
	public int update(GoodsVo g)
	{
		return GoodsManager.update(g);
	}
	
	public GoodsVo getGoods(int no)
	{
		return GoodsManager.getGoods(no);
	}
	
	public int insert(GoodsVo g)
	{
		return GoodsManager.insert(g);
	}
	
	public List<GoodsVo> listAll()
	{
		return GoodsManager.list();
	}
}
