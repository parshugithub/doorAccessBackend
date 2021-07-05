package com.ncs.doorsystem.enginnerdashboard.entity;

import java.util.Date;

import javax.annotation.Generated;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonFormat;

@Entity
@Table(name = "customer_profile")
public class CustomerProfile 
{
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long custID;
	private String customerID;
	private String customerEmail;
	private long engId;
	
	@JsonFormat(pattern="yyyy-MM-dd HH:mm:ss")
	private Date createdDate;
	
	
	public long getEngId() {
		return engId;
	}
	public void setEngId(long engId) {
		this.engId = engId;
	}
	public long getCustID() {
		return custID;
	}
	public void setCustID(long custID) {
		this.custID = custID;
	}
	public String getCustomerID() {
		return customerID;
	}
	public void setCustomerID(String customerID) {
		this.customerID = customerID;
	}
	public String getCustomerEmail() {
		return customerEmail;
	}
	public void setCustomerEmail(String customerEmail) {
		this.customerEmail = customerEmail;
	}
	
	public Date getCreatedDate() {
		return createdDate;
	}
	public void setCreatedDate(Date createdDate) {
		this.createdDate = createdDate;
	}
	public CustomerProfile(long custID, String customerID, String customerEmail) {
		super();
		this.custID = custID;
		this.customerID = customerID;
		this.customerEmail = customerEmail;
	}
	public CustomerProfile() {
		super();
		// TODO Auto-generated constructor stub
	}
	@Override
	public String toString() {
		return "CustomerProfile [custID=" + custID + ", customerID=" + customerID + ", customerEmail=" + customerEmail
				+ "]";
	}
	
	

}
