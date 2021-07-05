package com.ncs.doorsystem.enginnerdashboard.entity;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonFormat;

@Entity
@Table(name = "engneer_profile")
public class EngineerEntity 
{
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long engID;
	private String engineerName;
	private String employeeID;
	private String userName;
	private String password;
	
	@JsonFormat(pattern="yyyy-MM-dd HH:mm:ss")
	private Date createdDate;
	public long getEngID() {
		return engID;
	}
	public void setEngID(long engID) {
		this.engID = engID;
	}
	public String getEngineerName() {
		return engineerName;
	}
	public void setEngineerName(String engineerName) {
		this.engineerName = engineerName;
	}
	public String getEmployeeID() {
		return employeeID;
	}
	public void setEmployeeID(String employeeID) {
		this.employeeID = employeeID;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	
	
	public Date getCreatedDate() {
		return createdDate;
	}
	public void setCreatedDate(Date createdDate) {
		this.createdDate = createdDate;
	}
	@Override
	public String toString() {
		return "EngineerEntity [engID=" + engID + ", engineerName=" + engineerName + ", employeeID=" + employeeID
				+ ", userName=" + userName + ", password=" + password + "]";
	}
	public EngineerEntity() {
		super();
		// TODO Auto-generated constructor stub
	}
	public EngineerEntity(long engID, String engineerName, String employeeID, String userName, String password) {
		super();
		this.engID = engID;
		this.engineerName = engineerName;
		this.employeeID = employeeID;
		this.userName = userName;
		this.password = password;
	}
	
	
	
	
	

}
