package com.ncs.doorsystem.entity;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonFormat;

@Entity
@Table(name = "user_voiceoperator")
public class UserAsVoiceOperator 
{
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	private long siteid;
	private long custid;
	private String sitename;
	private long isVoiceoperator;
	private long userid;
	@JsonFormat(pattern="yyyy-MM-dd HH:mm:ss")
	private Date createdDate;
	
	@JsonFormat(pattern="yyyy-MM-dd HH:mm:ss")
	private Date updatedDate;
	
	
	
	
	public Date getUpdatedDate() {
		return updatedDate;
	}
	public void setUpdatedDate(Date updatedDate) {
		this.updatedDate = updatedDate;
	}
	public long getUserid() {
		return userid;
	}
	public void setUserid(long userid) {
		this.userid = userid;
	}
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public long getSiteid() {
		return siteid;
	}
	public void setSiteid(long siteid) {
		this.siteid = siteid;
	}
	public long getCustid() {
		return custid;
	}
	public void setCustid(long custid) {
		this.custid = custid;
	}
	public String getSitename() {
		return sitename;
	}
	public void setSitename(String sitename) {
		this.sitename = sitename;
	}
	public long getIsVoiceoperator() {
		return isVoiceoperator;
	}
	public void setIsVoiceoperator(long isVoiceoperator) {
		this.isVoiceoperator = isVoiceoperator;
	}
	public Date getCreatedDate() {
		return createdDate;
	}
	public void setCreatedDate(Date createdDate) {
		this.createdDate = createdDate;
	}
	
	public UserAsVoiceOperator() {
		super();
		// TODO Auto-generated constructor stub
	}
	@Override
	public String toString() {
		return "UserAsVoiceOperator [id=" + id + ", siteid=" + siteid + ", custid=" + custid + ", sitename=" + sitename
				+ ", isVoiceoperator=" + isVoiceoperator + ", userid=" + userid + ", createdDate=" + createdDate + "]";
	}
	public UserAsVoiceOperator(long id, long siteid, long custid, String sitename, long isVoiceoperator, long userid,
			Date createdDate) {
		super();
		this.id = id;
		this.siteid = siteid;
		this.custid = custid;
		this.sitename = sitename;
		this.isVoiceoperator = isVoiceoperator;
		this.userid = userid;
		this.createdDate = createdDate;
	}
	
	
	

}
