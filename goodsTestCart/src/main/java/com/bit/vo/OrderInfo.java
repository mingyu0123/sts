package com.bit.vo;

import java.util.List;

public class OrderInfo {
	private String id;
	private int total;
	private String addr;
	private List<OrderDetail> items;
	public OrderInfo(String id, int total, String addr, List<OrderDetail> items) {
		super();
		this.id = id;
		this.total = total;
		this.addr = addr;
		this.items = items;
	}
	public OrderInfo() {
		super();
		// TODO Auto-generated constructor stub
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public int getTotal() {
		return total;
	}
	public void setTotal(int total) {
		this.total = total;
	}
	public String getAddr() {
		return addr;
	}
	public void setAddr(String addr) {
		this.addr = addr;
	}
	public List<OrderDetail> getItems() {
		return items;
	}
	public void setItems(List<OrderDetail> items) {
		this.items = items;
	}
	
	
	
}
