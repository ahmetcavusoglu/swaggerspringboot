package com.ahmetcavusoglu.swaggerspringboot.model;

import java.util.Date;

import io.swagger.annotations.ApiModelProperty;

public class Customers {

	@ApiModelProperty(notes="TcNo")
	private String id;
	
	@ApiModelProperty(notes = "name")
	private String name;
	
	@ApiModelProperty(notes = "surname")
	private String surname;
	
	@ApiModelProperty(notes = "phonenumber")
	private String phonenumber;
	
	@ApiModelProperty(notes = "address")
	private String address;
	
	@ApiModelProperty(notes = "date")
	private Date createdDate;
	
	public Customers() {
	}
	
	public Customers(String id, String name, String surname, String phonenumber,String address, Date createdDate) {
		super();
		this.id = id;
		this.name = name;
		this.surname = surname;
		this.phonenumber= phonenumber;
		this.address=address;
		this.createdDate = createdDate;
	}

	public String getTcNo() {
		return id;
	}
	public void setTcNo(String tcId) {
		this.id = tcId;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public void setSurname(String surname) {
		this.surname=surname;
	}
	public String getSurname() {
		return surname;
	}
	public void setPhoneNumber(String phonenumber) {
		this.phonenumber=phonenumber;
	}
	public String getPhoneNumber() {
		return phonenumber;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	
	
	public Date getCreatedDate() {
		return createdDate;
	}
	public void setCreatedDate(Date createdDate) {
		this.createdDate = createdDate;
	}
	
}
