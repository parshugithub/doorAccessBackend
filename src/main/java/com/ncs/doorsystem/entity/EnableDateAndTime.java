package com.ncs.doorsystem.entity;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonFormat;

@Entity
@Table(name = "enable_date_time")
public class EnableDateAndTime 
{
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	@JsonFormat(pattern="yyyy-MM-dd HH:mm:ss")
	@Column(name = "enableDateAndTime")
	private Date enableDateAndTime;
	
	@JsonFormat(pattern="yyyy-MM-dd HH:mm:ss")
	@Column(name = "enableDateAndTimeUK")
	private Date enableDateAndTimeUK;
	@JsonFormat(pattern="yyyy-MM-dd HH:mm:ss")
	@Column(name = "enableDateAndTimeindia")
	private Date enableDateAndTimeindia;
	private long customerid;
	private long siteid;
	
	
	
	
	public Date getEnableDateAndTimeindia() {
		return enableDateAndTimeindia;
	}
	public void setEnableDateAndTimeindia(Date enableDateAndTimeindia) {
		this.enableDateAndTimeindia = enableDateAndTimeindia;
	}
	public Date getEnableDateAndTimeUK() {
		return enableDateAndTimeUK;
	}
	public void setEnableDateAndTimeUK(Date enableDateAndTimeUK) {
		this.enableDateAndTimeUK = enableDateAndTimeUK;
	}
	public long getCustomerid() {
		return customerid;
	}
	public void setCustomerid(long customerid) {
		this.customerid = customerid;
	}
	public long getSiteid() {
		return siteid;
	}
	public void setSiteid(long siteid) {
		this.siteid = siteid;
	}
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public Date getEnableDateAndTime() {
		return enableDateAndTime;
	}
	public void setEnableDateAndTime(Date enableDateAndTime) {
		this.enableDateAndTime = enableDateAndTime;
	}
	@Override
	public String toString() {
		return "EnableDateAndTime [id=" + id + ", enableDateAndTime=" + enableDateAndTime + "]";
	}
	public EnableDateAndTime() {
		super();
		// TODO Auto-generated constructor stub
	}
	public EnableDateAndTime(long id, Date enableDateAndTime,long customerid,long siteid) {
		super();
		this.id = id;
		this.enableDateAndTime = enableDateAndTime;
		this.customerid=customerid;
		this.siteid=siteid;
	}
	
	
	
	

}
