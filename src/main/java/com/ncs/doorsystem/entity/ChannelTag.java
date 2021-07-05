package com.ncs.doorsystem.entity;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonFormat;

@Entity
@Table(name = "channels_tag_table")
public class ChannelTag 
{
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long tagid;
	private String tagname;
	private long tagRFid;
	private long customerid;
	private String hexaval;
	
	@JsonFormat(pattern="yyyy-MM-dd HH:mm:ss")
	private Date createdDate;
	
	@JsonFormat(pattern="yyyy-MM-dd HH:mm:ss")
	private Date updatedDate;
	
	
	
	
    public Date getCreatedDate() {
		return createdDate;
	}
	public void setCreatedDate(Date createdDate) {
		this.createdDate = createdDate;
	}
	public Date getUpdatedDate() {
		return updatedDate;
	}
	public void setUpdatedDate(Date updatedDate) {
		this.updatedDate = updatedDate;
	}
	//	public long getTagid() {
//		return tagid;
//	}
//	public void setTagid(long tagid) {
//		this.tagid = tagid;
//	}
	public String getTagname() {
		return tagname;
	}
	public void setTagname(String tagname) {
		this.tagname = tagname;
	}
	public long getTagRFid() {
		return tagRFid;
	}
	public void setTagRFid(long tagRFid) {
		this.tagRFid = tagRFid;
	}
	public long getCustomerid() {
		return customerid;
	}
	public void setCustomerid(long customerid) {
		this.customerid = customerid;
	}
	public String getHexaval() {
		return hexaval;
	}
	public void setHexaval(String hexaval) {
		this.hexaval = hexaval;
	}
	
	public ChannelTag() {
		super();
		// TODO Auto-generated constructor stub
	}
	public ChannelTag(long tagid, String tagname, long tagRFid, long customerid, String hexaval, Date createdDate,
			Date updatedDate) {
		super();
		this.tagid = tagid;
		this.tagname = tagname;
		this.tagRFid = tagRFid;
		this.customerid = customerid;
		this.hexaval = hexaval;
		this.createdDate = createdDate;
		this.updatedDate = updatedDate;
	}
	@Override
	public String toString() {
		return "ChannelTag [tagid=" + tagid + ", tagname=" + tagname + ", tagRFid=" + tagRFid + ", customerid="
				+ customerid + ", hexaval=" + hexaval + ", createdDate=" + createdDate + ", updatedDate=" + updatedDate
				+ "]";
	}

}
