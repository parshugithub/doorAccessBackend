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
@Table(name = "Tradecode_door_table")
public class TradeCodeWithDoorModal
{
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long tdid;
	private long lockTime;
	@JsonFormat(pattern="yyyy-MM-dd HH:mm:ss")
	@Column(name = "created_date")
	private Date createdDate;
	private long doorNumber;
	private long customerid;
	private long siteid;
	private long scheduleno;
	
	
	
	public long getScheduleno() {
		return scheduleno;
	}
	public void setScheduleno(long scheduleno) {
		this.scheduleno = scheduleno;
	}
	public long getTdid() {
		return tdid;
	}
	public void setTdid(long tdid) {
		this.tdid = tdid;
	}
	public long getLockTime() {
		return lockTime;
	}
	public void setLockTime(long lockTime) {
		this.lockTime = lockTime;
	}
	public Date getCreatedDate() {
		return createdDate;
	}
	public void setCreatedDate(Date createdDate) {
		this.createdDate = createdDate;
	}
	public long getDoorNumber() {
		return doorNumber;
	}
	public void setDoorNumber(long doorNumber) {
		this.doorNumber = doorNumber;
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
	@Override
	public String toString() {
		return "TradeCodeWithDoorModal [tdid=" + tdid + ", lockTime=" + lockTime + ", createdDate=" + createdDate
				+ ", doorNumber=" + doorNumber + ", customerid=" + customerid + ", siteid=" + siteid + "]";
	}
	public TradeCodeWithDoorModal() {
		super();
		// TODO Auto-generated constructor stub
	}
	public TradeCodeWithDoorModal(long tdid, long lockTime, Date createdDate, long doorNumber, long customerid,
			long siteid) {
		super();
		this.tdid = tdid;
		this.lockTime = lockTime;
		this.createdDate = createdDate;
		this.doorNumber = doorNumber;
		this.customerid = customerid;
		this.siteid = siteid;
	}
	
	
	
	
	

}
