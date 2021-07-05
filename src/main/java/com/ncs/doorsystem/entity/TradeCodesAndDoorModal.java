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
@Table(name = "trade_schedule_table")
public class TradeCodesAndDoorModal 
{
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long tradid;
	private long tradecode;
	private long scheduleno;
	@JsonFormat(pattern="yyyy-MM-dd HH:mm:ss")
	@Column(name = "created_date")
	private Date createdDate;
	private long tradeNo;
	
//	@JsonFormat(pattern="yyyy-MM-dd HH:mm:ss")
//	@Column(name = "lock_time")
//	private Date locktime;
	private long customerid;
	private long siteid;
	
	
	
	public long getTradeNo() {
		return tradeNo;
	}
	public void setTradeNo(long tradeNo) {
		this.tradeNo = tradeNo;
	}
	public long getSiteid() {
		return siteid;
	}
	public void setSiteid(long siteid) {
		this.siteid = siteid;
	}
	public long getCustomerid() {
		return customerid;
	}
	public void setCustomerid(long customerid) {
		this.customerid = customerid;
	}
	public long getTradid() {
		return tradid;
	}
	public void setTradid(long tradid) {
		this.tradid = tradid;
	}
	public long getTradecode() {
		return tradecode;
	}
	public void setTradecode(long tradecode) {
		this.tradecode = tradecode;
	}
	public long getScheduleno() {
		return scheduleno;
	}
	public void setScheduleno(long scheduleno) {
		this.scheduleno = scheduleno;
	}
	public Date getCreatedDate() {
		return createdDate;
	}
	public void setCreatedDate(Date createdDate) {
		this.createdDate = createdDate;
	}
	
//	public Date getLocktime() {
//		return locktime;
//	}
//	public void setLocktime(Date locktime) {
//		this.locktime = locktime;
//	}
	@Override
	public String toString() {
		return "TradeCodesAndDoorModal [tradid=" + tradid + ", tradecode=" + tradecode + ", scheduleno=" + scheduleno
				+ ", createdDate=" + createdDate +  "]";
	}
	public TradeCodesAndDoorModal(long tradid, long tradecode, long scheduleno, Date createdDate, long doorNumber,
			Date locktime,long customerid,long siteid) {
		super();
		this.tradid = tradid;
		this.tradecode = tradecode;
		this.scheduleno = scheduleno;
		this.createdDate = createdDate;
		
		//this.locktime = locktime;
		this.customerid=customerid;
		this.siteid=siteid;
	}
	public TradeCodesAndDoorModal() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
	
	
	
	

}
