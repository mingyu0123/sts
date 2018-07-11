package com.bit.dao;

import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Repository;

import com.bit.db.BookStoreManager;
import com.bit.vo.BookStoreVo;

@Repository
public class BookStoreDao {

	public List<BookStoreVo> order(Map map)
	{
		return BookStoreManager.order(map);
	}
}
