package com.ncs.doorsystem.dto;

import java.util.Date;
import java.util.List;
import java.util.Set;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.ncs.doorsystem.entity.CreateSiteModal;
import com.ncs.doorsystem.entity.StaffGroupTags;
import com.ncs.doorsystem.entity.StaffManyToMany;
import com.ncs.doorsystem.entity.TotalDoorsModal;

public class StaffGroupMainModal 
{
	private long groupid;
	private String staffGroupName;
	private String createdBy;
	@JsonFormat(pattern="yyyy-MM-dd HH:mm:ss")
	private Date createdDate;
	private long customerid;
	private List<StaffModal> staffManyToMany;
	private List<CreateSiteModal> sites;
	private List<TotalDoorsModal> doors;
	private List<StaffGroupTags> tags;
	
	
	
	
	public List<StaffGroupTags> getTags() {
		return tags;
	}
	public void setTags(List<StaffGroupTags> list) {
		this.tags = list;
	}
	public List<StaffModal> getStaffManyToMany() {
		return staffManyToMany;
	}
	public void setStaffManyToMany(List<StaffModal> staffManyToMany) {
		this.staffManyToMany = staffManyToMany;
	}
	public List<CreateSiteModal> getSites() {
		return sites;
	}
	public void setSites(List<CreateSiteModal> sites) {
		this.sites = sites;
	}
	public List<TotalDoorsModal> getDoors() {
		return doors;
	}
	public void setDoors(List<TotalDoorsModal> list) {
		this.doors = list;
	}
	public long getGroupid() {
		return groupid;
	}
	public void setGroupid(long groupid) {
		this.groupid = groupid;
	}
	public String getStaffGroupName() {
		return staffGroupName;
	}
	public void setStaffGroupName(String staffGroupName) {
		this.staffGroupName = staffGroupName;
	}
	public String getCreatedBy() {
		return createdBy;
	}
	public void setCreatedBy(String createdBy) {
		this.createdBy = createdBy;
	}
	public Date getCreatedDate() {
		return createdDate;
	}
	public void setCreatedDate(Date createdDate) {
		this.createdDate = createdDate;
	}
	public long getCustomerid() {
		return customerid;
	}
	public void setCustomerid(long customerid) {
		this.customerid = customerid;
	}
	@Override
	public String toString() {
		return "StaffGroupMainModal [groupid=" + groupid + ", staffGroupName=" + staffGroupName + ", createdBy="
				+ createdBy + ", createdDate=" + createdDate + ", customerid=" + customerid + ", staffManyToMany="
				+ staffManyToMany + ", sites=" + sites + ", doors=" + doors + ", tags=" + tags + "]";
	}
	
	
	

}
