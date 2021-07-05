package com.ncs.doorsystem.entity;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonFormat;

@Entity
@Table(name = "CreateStaffgroupModal")
public class CreateStaffgroupModal 
{
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long groupid;
	private String staffGroupName;
	
	private String createdBy;
	@JsonFormat(pattern="yyyy-MM-dd HH:mm:ss")
	private Date createdDate;
	private long customerid;
	public long getGroupid() {
		return groupid;
	}
	public void setGroupid(long groupid) {
		this.groupid = groupid;
	}
	public String getStaffGroupName() {
		return staffGroupName;
	}
	public void setStaffGroupName(String staffGroupName) {
		this.staffGroupName = staffGroupName;
	}
	public String getCreatedBy() {
		return createdBy;
	}
	public void setCreatedBy(String createdBy) {
		this.createdBy = createdBy;
	}
	public Date getCreatedDate() {
		return createdDate;
	}
	public void setCreatedDate(Date createdDate) {
		this.createdDate = createdDate;
	}
	public long getCustomerid() {
		return customerid;
	}
	public void setCustomerid(long customerid) {
		this.customerid = customerid;
	}
	public CreateStaffgroupModal(long groupid, String staffGroupName, String createdBy, Date createdDate,
			long customerid) {
		super();
		this.groupid = groupid;
		this.staffGroupName = staffGroupName;
		this.createdBy = createdBy;
		this.createdDate = createdDate;
		this.customerid = customerid;
	}
	public CreateStaffgroupModal() {
		super();
		// TODO Auto-generated constructor stub
	}
	@Override
	public String toString() {
		return "CreateStaffgroupModal [groupid=" + groupid + ", staffGroupName=" + staffGroupName + ", createdBy="
				+ createdBy + ", createdDate=" + createdDate + ", customerid=" + customerid + "]";
	}
	
	
	
	

}
