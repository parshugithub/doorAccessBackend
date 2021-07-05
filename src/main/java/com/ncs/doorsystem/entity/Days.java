package com.ncs.doorsystem.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Days
{
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	private String day;
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public String getDay() {
		return day;
	}
	public void setDay(String day) {
		this.day = day;
	}
	@Override
	public String toString() {
		return "Days [id=" + id + ", day=" + day + "]";
	}
	public Days() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Days(long id, String day) {
		super();
		this.id = id;
		this.day = day;
	}
	
	
	

}
