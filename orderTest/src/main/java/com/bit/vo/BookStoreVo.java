package com.bit.vo;

import java.util.Date;

public class BookStoreVo {
	
	private String bookname;
	private String publisher;
	private int price;
	private int profit;
	private Date orderdate;
	private String address;
	private String phone;
	public BookStoreVo(String bookname, String publisher, int price, int profit, Date orderdate, String address,
			String phone) {
		super();
		this.bookname = bookname;
		this.publisher = publisher;
		this.price = price;
		this.profit = profit;
		this.orderdate = orderdate;
		this.address = address;
		this.phone = phone;
	}
	public BookStoreVo() {
		super();
		// TODO Auto-generated constructor stub
	}
	public String getBookname() {
		return bookname;
	}
	public void setBookname(String bookname) {
		this.bookname = bookname;
	}
	public String getPublisher() {
		return publisher;
	}
	public void setPublisher(String publisher) {
		this.publisher = publisher;
	}
	public int getPrice() {
		return price;
	}
	public void setPrice(int price) {
		this.price = price;
	}
	public int getProfit() {
		return profit;
	}
	public void setProfit(int profit) {
		this.profit = profit;
	}
	public Date getOrderdate() {
		return orderdate;
	}
	public void setOrderdate(Date orderdate) {
		this.orderdate = orderdate;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	
}
