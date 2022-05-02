package com.ahmetcavusoglu.swaggerspringboot.model;


import java.util.Date;

import io.swagger.annotations.ApiModelProperty;


public class Orders {

	@ApiModelProperty(notes="id")
	private String id;
	
	@ApiModelProperty(notes="customerTckNo")
	private String customerTcknNo;
	
	@ApiModelProperty(notes = "orderdate")
	private Date orderDate;
	
	@ApiModelProperty(notes = "salesTax")
	private double salesTax;
	
	@ApiModelProperty(notes = "total")
	private double total;
	
	@ApiModelProperty(notes="bookid")
	private String bookId;
	

	public Orders() {
	}

	public Orders(String id) {
		super();
		this.id = id;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}
	
	public Date getOrderDate() {
		return orderDate;
	}

	public void setOrderDate(Date orderDate) {
		this.orderDate = orderDate;
	}
	
	public String getCustomerTcknNo() {
		return customerTcknNo;
	}

	public void setCustomerTcknNo(String customerTcknNo) {
		this.customerTcknNo = customerTcknNo;
	}
	
	public double getSalesTax() {
		return salesTax;
	}

	public void setSalesTax(double salesTax) {
		this.salesTax = salesTax;
	}

	public double getTotal() {
		return total;
	}

	public void setTotal(double total) {
		this.total = total;
	}
	
	public String getBookId() {
		return bookId;
	}

	public void setBookId(String bookId) {
		this.bookId = bookId;
	}
	
}
