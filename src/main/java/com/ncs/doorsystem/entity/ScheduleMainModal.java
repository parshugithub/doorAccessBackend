package com.ncs.doorsystem.entity;

import java.util.Collection;
import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonFormat;

@Entity
@Table(name = "schedule_main")
public class ScheduleMainModal 
{
	@Id
	@GeneratedValue(strategy =GenerationType.IDENTITY)
	private long scheduleId;
	private String startTime;
	private String endTime;
	private String createdBy;
	private long customerid;
	private long siteid;
	private long schedule;
	
	
	@OneToMany(targetEntity = ScheduleDays.class, cascade = CascadeType.ALL)
    @JoinColumn(name = "schedule_id")
	private List<ScheduleDays> days;
	
	
	@JsonFormat(pattern="yyyy-MM-dd HH:mm:ss")
	@Column(name = "created_date")
	 @JoinColumn(name = "created_dates")
	private Date createdDate;
	
	private long tagNo;
	
	
	
	public long getSchedule() {
		return schedule;
	}
	public void setSchedule(long schedule) {
		this.schedule = schedule;
	}
	public long getSiteid() {
		return siteid;
	}
	public void setSiteid(long siteid) {
		this.siteid = siteid;
	}
	public long getTagNo() {
		return tagNo;
	}
	public void setTagNo(long tagNo) {
		this.tagNo = tagNo;
	}
	public List<ScheduleDays> getDays() {
		return days;
	}
	public void setDays(List<ScheduleDays> collection) {
		this.days = collection;
	}
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
	public Date getCreatedDate() {
		return createdDate;
	}
	public void setCreatedDate(Date createdDate) {
		this.createdDate = createdDate;
	}
	@Override
	public String toString() {
		return "ScheduleMainModal [scheduleId=" + scheduleId + ", startTime=" + startTime + ", endTime=" + endTime
				+ ", createdBy=" + createdBy + ", customerid=" + customerid + ", days=" + days + ", createdDate="
				+ createdDate + ", getDays()=" + getDays() + ", getScheduleId()=" + getScheduleId()
				+ ", getStartTime()=" + getStartTime() + ", getEndTime()=" + getEndTime() + ", getCreatedBy()="
				+ getCreatedBy() + ", getCustomerid()=" + getCustomerid() + ", getCreatedDate()=" + getCreatedDate()
				+ ", getClass()=" + getClass() + ", hashCode()=" + hashCode() + ", toString()=" + super.toString()
				+ "]";
	}
	public ScheduleMainModal() {
		super();
		// TODO Auto-generated constructor stub
	}
	public ScheduleMainModal(long scheduleId, String startTime, String endTime, String createdBy, long customerid,
			List<ScheduleDays> days, Date createdDate,long tagNo,long siteid) {
		super();
		this.scheduleId = scheduleId;
		this.startTime = startTime;
		this.endTime = endTime;
		this.createdBy = createdBy;
		this.customerid = customerid;
		this.days = days;
		this.createdDate = createdDate;
		this.tagNo=tagNo;
		this.siteid=siteid;
	}
	
	
	
	
	
	

}
