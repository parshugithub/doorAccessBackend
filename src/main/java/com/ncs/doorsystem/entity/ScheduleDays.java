package com.ncs.doorsystem.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class ScheduleDays 
{
	@Id
   @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
 
    private String day;

//	public int getId() {
//		return id;
//	}
//
//	public void setId(int id) {
//		this.id = id;
//	}

	public String getDay() {
		return day;
	}

	public void setDay(String day) {
		this.day = day;
	}

	public ScheduleDays(int id, String day) {
		super();
		this.id = id;
		this.day = day;
	}

	public ScheduleDays() {
		super();
		// TODO Auto-generated constructor stub
	}

	@Override
	public String toString() {
		return "ScheduleDays [id=" + id + ", day=" + day + "]";
	}
	
	
    
    

}
