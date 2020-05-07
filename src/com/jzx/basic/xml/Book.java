package com.sdsc.basic.xml;

import java.util.Date;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlRootElement(name = "book-jzx")
@XmlType(propOrder = { "author", "calender", "price", "id" })
public class Book {
	@XmlElement(required = true)
	private String author;
	@XmlElement(name = "proce", required = true)
	private float price;

	@XmlElement
	private Date calender;
	@XmlElement
	private Integer id;
	@XmlAttribute(name = "user")
	private String user;

	public String getUser() {
		return user;
	}

	public void setUser(String user) {
		this.user = user;
	}

	public String getAuthor() {
		return author;
	}

	public void setAuthor(String author) {
		this.author = author;
	}

	public float getPrice() {
		return price;
	}

	public void setPrice(float price) {
		this.price = price;
	}

	public Date getCalender() {
		return calender;
	}

	public void setCalender(Date calender) {
		this.calender = calender;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

}
