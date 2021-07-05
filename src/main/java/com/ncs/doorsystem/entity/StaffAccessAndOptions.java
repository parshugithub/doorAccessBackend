package com.ncs.doorsystem.entity;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonFormat;

@Entity
@Table(name = "Staff_access_options")
public class StaffAccessAndOptions 
{
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long staffaccessid;
	private String accessLevel;
	private long passnumber;
	@JsonFormat(pattern="yyyy-MM-dd HH:mm:ss")
	@Column(name = "updated_date")
	private Date updatedDate;
	private long customerid;
	
	private long staff;
	private long siteid;
	
	
	
	
	public long getSiteid() {
		return siteid;
	}
	public void setSiteid(long siteid) {
		this.siteid = siteid;
	}
	public long getStaff() {
		return staff;
	}
	public void setStaff(long staff) {
		this.staff = staff;
	}
	public long getCustomerid() {
		return customerid;
	}
	public void setCustomerid(long customerid) {
		this.customerid = customerid;
	}
	public long getStaffaccessid() {
		return staffaccessid;
	}
	public void setStaffaccessid(long staffaccessid) {
		this.staffaccessid = staffaccessid;
	}
	public String getAccessLevel() {
		return accessLevel;
	}
	public void setAccessLevel(String accessLevel) {
		this.accessLevel = accessLevel;
	}
	public long getPassnumber() {
		return passnumber;
	}
	public void setPassnumber(long passnumber) {
		this.passnumber = passnumber;
	}
	public Date getUpdatedDate() {
		return updatedDate;
	}
	public void setUpdatedDate(Date updatedDate) {
		this.updatedDate = updatedDate;
	}
	public StaffAccessAndOptions() {
		super();
		// TODO Auto-generated constructor stub
	}
	public StaffAccessAndOptions(long staffaccessid, String accessLevel, long passnumber, Date updatedDate,long customerid,
			long staff) {
		super();
		this.staffaccessid = staffaccessid;
		this.accessLevel = accessLevel;
		this.passnumber = passnumber;
		this.updatedDate = updatedDate;
		this.customerid=customerid;
		this.staff=staff;
	}
	@Override
	public String toString() {
		return "StaffAccessAndOptions [staffaccessid=" + staffaccessid + ", accessLevel=" + accessLevel
				+ ", passnumber=" + passnumber + ", updatedDate=" + updatedDate + "]";
	}
	
	
	
	

}
