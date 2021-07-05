package com.ncs.doorsystem.entity;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonFormat;

@Entity
@Table(name = "login_events_logs_table")
public class LoginEvenLogsTable 
{
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long loginid;
	private String username;
	private String event;
	private String status;
	private String description;
	private long cutomerid;
	private long userid;;
	
	//@JsonFormat(pattern="yyyy-MM-dd HH:mm:ss")
	private  String updatedDate ;
	private String siteName;
	private String userType;
	
	public String getUserType() {
		return userType;
	}
	public void setUserType(String userType) {
		this.userType = userType;
	}
	public long getUserid() {
		return userid;
	}
	public void setUserid(long userid) {
		this.userid = userid;
	}
	public long getCutomerid() {
		return cutomerid;
	}
	public void setCutomerid(long cutomerid) {
		this.cutomerid = cutomerid;
	}
	public long getLoginid() {
		return loginid;
	}
	public void setLoginid(long loginid) {
		this.loginid = loginid;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getEvent() {
		return event;
	}
	public void setEvent(String event) {
		this.event = event;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public String getUpdatedDate() {
		return updatedDate;
	}
	public void setUpdatedDate(String formattedDate) {
		this.updatedDate = formattedDate;
		
	}
	
	
	public String getSiteName() {
		return siteName;
	}
	public void setSiteName(String siteName) {
		this.siteName = siteName;
	}
	public LoginEvenLogsTable(long loginid, String username, String event, String status, String description,
			String updatedDate) {
		super();
		this.loginid = loginid;
		this.username = username;
		this.event = event;
		this.status = status;
		this.description = description;
		this.updatedDate = updatedDate;
	}
	public LoginEvenLogsTable() {
		super();
		// TODO Auto-generated constructor stub
	}
	@Override
	public String toString() {
		return "LoginEvenLogsTable [loginid=" + loginid + ", username=" + username + ", event=" + event + ", status="
				+ status + ", description=" + description + ", updatedDate=" + updatedDate + "]";
	}
	
	
	

}
