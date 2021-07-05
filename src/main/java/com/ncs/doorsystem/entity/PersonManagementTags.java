package com.ncs.doorsystem.entity;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonFormat;

@Entity
@Table(name = "personmanagemet_tags")
public class PersonManagementTags 
{
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long tagid;
	private long pid;
	private String tagcode;
	private String tagcolor;
	@JsonFormat(pattern="dd-m-yyyy hh:mm:ss")
	private Date tagExpiray;
	public long getTagid() {
		return tagid;
	}
	public void setTagid(long tagid) {
		this.tagid = tagid;
	}
	public long getPid() {
		return pid;
	}
	public void setPid(long pid) {
		this.pid = pid;
	}
	public String getTagcode() {
		return tagcode;
	}
	public void setTagcode(String tagcode) {
		this.tagcode = tagcode;
	}
	public String getTagcolor() {
		return tagcolor;
	}
	public void setTagcolor(String tagcolor) {
		this.tagcolor = tagcolor;
	}
	public Date getTagExpiray() {
		return tagExpiray;
	}
	public void setTagExpiray(Date tagExpiray) {
		this.tagExpiray = tagExpiray;
	}
	@Override
	public String toString() {
		return "PersonManagementTags [tagid=" + tagid + ", pid=" + pid + ", tagcode=" + tagcode + ", tagcolor="
				+ tagcolor + ", tagExpiray=" + tagExpiray + "]";
	}
	public PersonManagementTags(long tagid, long pid, String tagcode, String tagcolor, Date tagExpiray) {
		super();
		this.tagid = tagid;
		this.pid = pid;
		this.tagcode = tagcode;
		this.tagcolor = tagcolor;
		this.tagExpiray = tagExpiray;
	}
	public PersonManagementTags() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	

}
