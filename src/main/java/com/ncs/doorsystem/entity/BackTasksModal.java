package com.ncs.doorsystem.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "backtask_table")
public class BackTasksModal 
{
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long taskId;
	private String taskNo;
	private String taskTime;
	private long priority;
	private String taskDescription;
	private String taskStatus;
	private String dateAndTime;
	private long deviceid;
	
	public long getTaskId() {
		return taskId;
	}
	public void setTaskId(long taskId) {
		this.taskId = taskId;
	}
	public String getTaskNo() {
		return taskNo;
	}
	public void setTaskNo(String taskNo) {
		this.taskNo = taskNo;
	}
	public String getTaskTime() {
		return taskTime;
	}
	public void setTaskTime(String taskTime) {
		this.taskTime = taskTime;
	}
	public long getPriority() {
		return priority;
	}
	public void setPriority(long priority) {
		this.priority = priority;
	}
	public String getTaskDescription() {
		return taskDescription;
	}
	public void setTaskDescription(String taskDescription) {
		this.taskDescription = taskDescription;
	}
	public String getTaskStatus() {
		return taskStatus;
	}
	public void setTaskStatus(String taskStatus) {
		this.taskStatus = taskStatus;
	}
	public String getDateAndTime() {
		return dateAndTime;
	}
	public void setDateAndTime(String dateAndTime) {
		this.dateAndTime = dateAndTime;
	}
	public BackTasksModal() {
		super();
		// TODO Auto-generated constructor stub
	}
	public long getDeviceid() {
		return deviceid;
	}
	public void setDeviceid(long deviceid) {
		this.deviceid = deviceid;
	}
	public BackTasksModal(long taskId, String taskNo, String taskTime, long priority, String taskDescription,
			String taskStatus, String dateAndTime, long deviceid) {
		super();
		this.taskId = taskId;
		this.taskNo = taskNo;
		this.taskTime = taskTime;
		this.priority = priority;
		this.taskDescription = taskDescription;
		this.taskStatus = taskStatus;
		this.dateAndTime = dateAndTime;
		this.deviceid = deviceid;
	}
	@Override
	public String toString() {
		return "BackTasksModal [taskId=" + taskId + ", taskNo=" + taskNo + ", taskTime=" + taskTime + ", priority="
				+ priority + ", taskDescription=" + taskDescription + ", taskStatus=" + taskStatus + ", dateAndTime="
				+ dateAndTime + ", deviceid=" + deviceid + "]";
	}
	
	

}
