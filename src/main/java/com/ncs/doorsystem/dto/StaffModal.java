package com.ncs.doorsystem.dto;

import java.util.Date;
import java.util.List;
import java.util.Set;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.ncs.doorsystem.entity.StaffGroupManytoMany;

public class StaffModal
{
	
    private long staffid;
	
	private long customerid;
	
	private String firstname;
	
	private String lastname;
	
	private String payrollno;
	@JsonFormat(pattern="yyyy-MM-dd HH:mm:ss")
	private Date expiraydate;
	@JsonFormat(pattern="yyyy-MM-dd HH:mm:ss")
	private Date createdDate;
	
	private String createdBy;
	
	private List<StaffGroupMainModal> staffgroup;
	
	private List<StaffSchedulemodal> staffschedule;
	
	

	public List<StaffSchedulemodal> getStaffschedule() {
		return staffschedule;
	}

	public void setStaffschedule(List<StaffSchedulemodal> staffschedule) {
		this.staffschedule = staffschedule;
	}

	public long getStaffid() {
		return staffid;
	}

	public void setStaffid(long staffid) {
		this.staffid = staffid;
	}

	public long getCustomerid() {
		return customerid;
	}

	public void setCustomerid(long customerid) {
		this.customerid = customerid;
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

	public List<StaffGroupMainModal> getStaffgroup() {
		return staffgroup;
	}

	public void setStaffgroup(List<StaffGroupMainModal> list) {
		this.staffgroup = list;
	}

	@Override
	public String toString() {
		return "StaffModal [staffid=" + staffid + ", customerid=" + customerid + ", firstname=" + firstname
				+ ", lastname=" + lastname + ", payrollno=" + payrollno + ", expiraydate=" + expiraydate
				+ ", createdDate=" + createdDate + ", createdBy=" + createdBy + ", staffgroup=" + staffgroup
				+ ", staffschedule=" + staffschedule + "]";
	}

	

}
