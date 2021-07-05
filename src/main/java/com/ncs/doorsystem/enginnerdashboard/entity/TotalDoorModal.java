package com.ncs.doorsystem.enginnerdashboard.entity;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonFormat;

@Entity
@Table(name = "customer_site_door_table")
public class TotalDoorModal 
{
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long doorid;
	private long doorDeviceId;
	private long doorNo;
	private String doorType;
	private String locktime;
	@JsonFormat(pattern="yyyy-MM-dd HH:mm:ss")
	private Date createdDate;
	private long customerid;
	private long siteid;
	
	
	public long getSiteid() {
		return siteid;
	}
	public void setSiteid(long siteid) {
		this.siteid = siteid;
	}
	public long getDoorid() {
		return doorid;
	}
	public void setDoorid(long doorid) {
		this.doorid = doorid;
	}
	public long getDoorDeviceId() {
		return doorDeviceId;
	}
	public void setDoorDeviceId(long doorDeviceId) {
		this.doorDeviceId = doorDeviceId;
	}
	public long getDoorNo() {
		return doorNo;
	}
	public void setDoorNo(long doorNo) {
		this.doorNo = doorNo;
	}
	public String getDoorType() {
		return doorType;
	}
	public void setDoorType(String doorType) {
		this.doorType = doorType;
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
	
	public String getLocktime() {
		return locktime;
	}
	public void setLocktime(String locktime) {
		this.locktime = locktime;
	}
	@Override
	public String toString() {
		return "TotalDoorModal [doorid=" + doorid + ", doorDeviceId=" + doorDeviceId + ", doorNo=" + doorNo
				+ ", doorType=" + doorType + ", locktime=" + locktime + ", createdDate=" + createdDate + ", customerid="
				+ customerid + "]";
	}
	public TotalDoorModal(long doorid, long doorDeviceId, long doorNo, String doorType, String locktime,
			Date createdDate, long customerid) {
		super();
		this.doorid = doorid;
		this.doorDeviceId = doorDeviceId;
		this.doorNo = doorNo;
		this.doorType = doorType;
		this.locktime = locktime;
		this.createdDate = createdDate;
		this.customerid = customerid;
	}
	public TotalDoorModal() {
		super();
		// TODO Auto-generated constructor stub
	}
	

}
