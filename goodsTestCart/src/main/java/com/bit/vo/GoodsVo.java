package com.bit.vo;

import org.springframework.web.multipart.MultipartFile;

public class GoodsVo {
	private int no;
	private String item;
	private int price;
	private int qty;
	private MultipartFile uploadFile;
	
	public MultipartFile getUploadFile() {
		return uploadFile;
	}
	public void setUploadFile(MultipartFile uploadFile) {
		this.uploadFile = uploadFile;
	}
	private String fname;
	public int getNo() {
		return no;
	}
	public void setNo(int no) {
		this.no = no;
	}
	public String getItem() {
		return item;
	}
	public void setItem(String item) {
		this.item = item;
	}
	public int getPrice() {
		return price;
	}
	public void setPrice(int price) {
		this.price = price;
	}
	public int getQty() {
		return qty;
	}
	public void setQty(int qty) {
		this.qty = qty;
	}
	public String getFname() {
		return fname;
	}
	public void setFname(String fname) {
		this.fname = fname;
	}
	public GoodsVo(int no, String item, int price, int qty, String fname) {
		super();
		this.no = no;
		this.item = item;
		this.price = price;
		this.qty = qty;
		this.fname = fname;
	}
	public GoodsVo() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
	
}
