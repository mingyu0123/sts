package com.bit.vo;

public class OrderDetail {
	private int no;
	private int qty;
	public int getNo() {
		return no;
	}
	public void setNo(int no) {
		this.no = no;
	}
	public int getQty() {
		return qty;
	}
	public void setQty(int qty) {
		this.qty = qty;
	}
	public OrderDetail(int no, int qty) {
		super();
		this.no = no;
		this.qty = qty;
	}
	public OrderDetail() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
}
