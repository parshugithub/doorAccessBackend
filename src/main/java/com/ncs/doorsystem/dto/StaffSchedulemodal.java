package com.ncs.doorsystem.dto;

import java.util.Date;
import java.util.List;

import com.ncs.doorsystem.entity.ScheduleDays;

public class StaffSchedulemodal 
{
	private long scheduleId;
	private String startTime;
	private String endTime;
	private String createdBy;
	private long customerid;
	private long siteid;
	private List<ScheduleDays> days;
	private Date createdDate;
	public long getScheduleId() {
		return scheduleId;
	}
	public void setScheduleId(long scheduleId) {
		this.scheduleId = scheduleId;
	}
	public String getStartTime() {
		return startTime;
	}
	public void setStartTime(String startTime) {
		this.startTime = startTime;
	}
	public String getEndTime() {
		return endTime;
	}
	public void setEndTime(String endTime) {
		this.endTime = endTime;
	}
	public String getCreatedBy() {
		return createdBy;
	}
	public void setCreatedBy(String createdBy) {
		this.createdBy = createdBy;
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
	public List<ScheduleDays> getDays() {
		return days;
	}
	public void setDays(List<ScheduleDays> days) {
		this.days = days;
	}
	public Date getCreatedDate() {
		return createdDate;
	}
	public void setCreatedDate(Date createdDate) {
		this.createdDate = createdDate;
	}
	
	

}
