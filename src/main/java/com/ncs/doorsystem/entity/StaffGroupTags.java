package com.ncs.doorsystem.entity;

import javax.annotation.Generated;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "staffgroup_tag")
public class StaffGroupTags 
{
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	private long tagNumber;
	private long staffid;
	
	public long getStaffid() {
		return staffid;
	}
	public void setStaffid(long staffid) {
		this.staffid = staffid;
	}
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public long getTagNumber() {
		return tagNumber;
	}
	public void setTagNumber(long tagNumber) {
		this.tagNumber = tagNumber;
	}
	@Override
	public String toString() {
		return "StaffGroupTags [id=" + id + ", tagNumber=" + tagNumber + ", staffid=" + staffid + "]";
	}
	public StaffGroupTags() {
		super();
		// TODO Auto-generated constructor stub
	}
	public StaffGroupTags(long id, long tagNumber, long staffid) {
		super();
	//	this.id = id;
		this.tagNumber = tagNumber;
		this.staffid = staffid;
	}
	
	
	
	
	
	

}
