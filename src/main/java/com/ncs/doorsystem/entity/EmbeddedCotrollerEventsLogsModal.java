package com.ncs.doorsystem.entity;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "embeddedcontroller_events_log_table")
public class EmbeddedCotrollerEventsLogsModal
{
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long srNo;
	private long door_id;
	private String dateAndTime;
	private long deviceId;
	private String status;
	
	
	public long getSrNo() {
		return srNo;
	}
	public void setSrNo(long srNo) {
		this.srNo = srNo;
	}
	public long getDoor_id() {
		return door_id;
	}
	public void setDoor_id(long door_id) {
		this.door_id = door_id;
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
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	@Override
	public String toString() {
		return "EmbeddedCotrollerEventsLogsModal [door_id=" + door_id + ", dateAndTime=" + dateAndTime + ", deviceId="
				+ deviceId + ", status=" + status + "]";
	}
	public EmbeddedCotrollerEventsLogsModal() {
		super();
		// TODO Auto-generated constructor stub
	}
	public EmbeddedCotrollerEventsLogsModal(long door_id, String dateAndTime, long deviceId, String status) {
		super();
		this.door_id = door_id;
		this.dateAndTime = dateAndTime;
		this.deviceId = deviceId;
		this.status = status;
	}
	
	
	
	
	
	
	
	
	
	
	

}
