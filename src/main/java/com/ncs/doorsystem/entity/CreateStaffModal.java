package com.ncs.doorsystem.entity;

import java.util.Calendar;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import com.fasterxml.jackson.annotation.JsonFormat;

@Entity
@Table(name = "CreateStaffModal")
public class CreateStaffModal 
{
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	
	@Column(name = "staffid")
	private long staffid;
	
	@Column(name = "customer_id")
	private long customerId;
	
	@Column(name = "firstname")
	private String firstname;
	
	@Column(name = "lastname")
	private String lastname;
	
	@Column(name = "payrollno")
	private String payrollno;
	
	
	@JsonFormat(pattern="yyyy-MM-dd HH:mm:ss")
	@Column(name = "expiraydate")
	private Date expiraydate;
	
	@Column(name = "created_date")
	@JsonFormat(pattern="yyyy-MM-dd HH:mm:ss")
	private Date createdDate;
	
	@Column(name = "created_by")
	private String createdBy;

	public long getStaffid() {
		return staffid;
	}

	public void setStaffid(long staffid) {
		this.staffid = staffid;
	}

	public long getCustomerId() {
		return customerId;
	}

	public void setCustomerId(long customerId) {
		this.customerId = customerId;
	}

	public String getFirstname() {
		return firstname;
	}

	public void setFirstname(String firstname) {
		this.firstname = firstname;
	}

	public String getLastname() {
		return lastname;
	}

	public void setLastname(String lastname) {
		this.lastname = lastname;
	}

	public String getPayrollno() {
		return payrollno;
	}

	public void setPayrollno(String payrollno) {
		this.payrollno = payrollno;
	}

	public Date getExpiraydate() {
		return expiraydate;
	}

	public void setExpiraydate(Date expiraydate) {
		this.expiraydate = expiraydate;
	}

	public Date getCreatedDate() {
		return createdDate;
	}

	public void setCreatedDate(Date createdDate) {
		this.createdDate = createdDate;
	}

	public String getCreatedBy() {
		return createdBy;
	}

	public void setCreatedBy(String createdBy) {
		this.createdBy = createdBy;
	}

	public CreateStaffModal() {
		super();
		// TODO Auto-generated constructor stub
	}

	public CreateStaffModal(long staffid, long customerId, String firstname, String lastname, String payrollno,
			Date expiraydate, Date createdDate, String createdBy) {
		
		super();
		Calendar calendar = Calendar.getInstance();
		this.staffid = staffid;
		this.customerId = customerId;
		this.firstname = firstname;
		this.lastname = lastname;
		this.payrollno = payrollno;
		this.expiraydate = new Date(calendar.getTime().getTime());;
		this.createdDate = new Date(calendar.getTime().getTime());;
		this.createdBy = createdBy;
	}

	@Override
	public String toString() {
		return "CreateStaffModal [staffid=" + staffid + ", customerId=" + customerId + ", firstname=" + firstname
				+ ", lastname=" + lastname + ", payrollno=" + payrollno + ", expiraydate=" + expiraydate
				+ ", createdDate=" + createdDate + ", createdBy=" + createdBy + "]";
	}
	
	
	 
	 
}
