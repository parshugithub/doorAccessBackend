package com.ncs.doorsystem.entity;

import java.util.Collection;
import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonFormat;

@Entity
@Table(name="schedule_values_table")
public class SchedulesValuesModal 
{
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long scheduleid;
	
	@Column(name="hours")
	@ElementCollection
	private Collection<Integer> hours;
	
	@Column(name="minutes")
	@ElementCollection
	private Collection<Integer> minutes;
	
	@Column(name="days")
	@ElementCollection
	private Collection<String> days;
	
//	@JsonFormat(pattern="yyyy-MM-dd HH:mm:ss")
//	@Column(name = "created_date")
//	 @JoinColumn(name = "created_dates")
//	private Date createdDate;
//	
//	@JsonFormat(pattern="yyyy-MM-dd HH:mm:ss")
//	@Column(name = "updated_date")
//	 @JoinColumn(name = "updated_dates")
//	private Date updatedDate;
//	

//	public Date getUpdatedDate() {
//		return updatedDate;
//	}
//	public void setUpdatedDate(Date updatedDate) {
//		this.updatedDate = updatedDate;
//	}
//	public Date getCreatedDate() {
//		return createdDate;
//	}
//	public void setCreatedDate(Date createdDate) {
//		this.createdDate = createdDate;
//	}
	public void setHours(Collection<Integer> hours) {
		this.hours = hours;
	}
	public void setMinutes(Collection<Integer> minutes) {
		this.minutes = minutes;
	}
	public void setDays(Collection<String> days) {
		this.days = days;
	}
	public long getScheduleid() {
		return scheduleid;
	}
	public void setScheduleid(long scheduleid) {
		this.scheduleid = scheduleid;
	}
	public Collection<Integer> getHours() {
		return hours;
	}
	public void setHours(List<Integer> hours) {
		this.hours = hours;
	}
	public Collection<Integer> getMinutes() {
		return minutes;
	}
	public void setMinutes(List<Integer> minutes) {
		this.minutes = minutes;
	}
	public Collection<String> getDays() {
		return days;
	}
	public void setDays(List<String> days) {
		this.days = days;
	}
	@Override
	public String toString() {
		return "SchedulesModal [scheduleid=" + scheduleid + ", hours=" + hours + ", minutes=" + minutes + ", days="
				+ days + "]";
	}
	public SchedulesValuesModal() {
		super();
		// TODO Auto-generated constructor stub
	}
	public SchedulesValuesModal(long scheduleid, Collection<Integer> hours, Collection<Integer> minutes,
			Collection<String> days) {
		super();
		this.scheduleid = scheduleid;
		this.hours = hours;
		this.minutes = minutes;
		this.days = days;
		
	}
	
	
	
}
