package com.ncs.doorsystem.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "error_logs_table")
public class ErrorLogsModal 
{
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long srNo;
	private String dateAndTime ;
	private long deviceId;
	private String errorType;
	private String errorDescription;
	private String status;
	public long getSrNo() {
		return srNo;
	}
	public void setSrNo(long srNo) {
		this.srNo = srNo;
	}
	public String getDateAndTime() {
		return dateAndTime;
	}
	public void setDateAndTime(String dateAndTime) {
		this.dateAndTime = dateAndTime;
	}
	public long getDeviceId() {
		return deviceId;
	}
	public void setDeviceId(long deviceId) {
		this.deviceId = deviceId;
	}
	public String getErrorType() {
		return errorType;
	}
	public void setErrorType(String errorType) {
		this.errorType = errorType;
	}
	public String getErrorDescription() {
		return errorDescription;
	}
	public void setErrorDescription(String errorDescription) {
		this.errorDescription = errorDescription;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public ErrorLogsModal() {
		super();
		// TODO Auto-generated constructor stub
	}
	public ErrorLogsModal(long srNo, String dateAndTime, long deviceId, String errorType, String errorDescription,
			String status) {
		super();
		this.srNo = srNo;
		this.dateAndTime = dateAndTime;
		this.deviceId = deviceId;
		this.errorType = errorType;
		this.errorDescription = errorDescription;
		this.status = status;
	}
	
	
	

}
