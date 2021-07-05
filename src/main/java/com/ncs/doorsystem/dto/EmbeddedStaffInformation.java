package com.ncs.doorsystem.dto;

import java.util.Date;

public class EmbeddedStaffInformation 
{
	private long staffid;
	private String staffName;
	private Date expireDate;
	private long tagCode;
	private long door;
	
	
	
	public long getDoor() {
		return door;
	}
	public void setDoor(long door) {
		this.door = door;
	}
	public long getStaffid() {
		return staffid;
	}
	public void setStaffid(long staffid) {
		this.staffid = staffid;
	}
	public String getStaffName() {
		return staffName;
	}
	public void setStaffName(String staffName) {
		this.staffName = staffName;
	}
	public Date getExpireDate() {
		return expireDate;
	}
	public void setExpireDate(Date expireDate) {
		this.expireDate = expireDate;
	}
	public long getTagCode() {
		return tagCode;
	}
	public void setTagCode(long tagCode) {
		this.tagCode = tagCode;
	}
	@Override
	public String toString() {
		return "EmbeddedStaffInformation [staffid=" + staffid + ", staffName=" + staffName + ", expireDate="
				+ expireDate + ", tagCode=" + tagCode + ", door=" + door + "]";
	}
	
	
	

}
