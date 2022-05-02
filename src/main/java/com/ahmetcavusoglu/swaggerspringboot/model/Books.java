package com.ahmetcavusoglu.swaggerspringboot.model;


import io.swagger.annotations.ApiModelProperty;

public class Books {

	@ApiModelProperty(notes="id")
	private String id;
	
	@ApiModelProperty(notes = "name")
	private String name;
	
	@ApiModelProperty(notes = "author")
	private String author;
	
	@ApiModelProperty(notes = "publisher")
	private String publisher;
	
	@ApiModelProperty(notes = "stock records")
	private String stockNumber;
	
	@ApiModelProperty(notes = "price")
	private double price;
	
	@ApiModelProperty(notes = "edition")
	private String edition;


	public Books() {
	}

	public Books(String id, String name, String author, String publisher,String stockNumber,double price,String edition) {
		super();
		this.id = id;
		this.name = name;
		this.author = author;
		this.publisher= publisher;
		this.stockNumber=stockNumber;
		this.price=price;
		this.edition=edition;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getAuthor() {
		return author;
	}

	public void setAuthor(String author) {
		this.author = author;
	}

	public String getPublisher() {
		return publisher;
	}

	public void setPublisher(String publisher) {
		this.publisher = publisher;
	}
	
	public String getStockNumber() {
		return stockNumber;
	}

	public void setStockNumber(String stockNumber) {
		this.stockNumber = stockNumber;
	}
		
	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}
	
	public String getEdition() {
		return edition;
	}

	public void setEdition(String edition) {
		this.edition = edition;
	}

	
}
