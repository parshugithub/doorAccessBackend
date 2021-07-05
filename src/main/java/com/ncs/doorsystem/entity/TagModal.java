package com.ncs.doorsystem.entity;

import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonFormat;

@Entity
@Table(name = "tag_table")
public class TagModal 
{
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long tagid;
	private String tagname;
	private long tagRFid;
	private long customerid;
	
	private String hexaval;
	@ManyToOne(cascade=CascadeType.ALL, fetch = FetchType.LAZY)
	private ChannelsModal channels;
	
	@JsonFormat(pattern="yyyy-MM-dd HH:mm:ss")
	private Date createdDate;
	
	@JsonFormat(pattern="yyyy-MM-dd HH:mm:ss")
	private Date updatedDate;
	
	
	
	public ChannelsModal getChannels() {
		return channels;
	}
	public void setChannels(ChannelsModal channels) {
		this.channels = channels;
	}
	public Date getUpdatedDate() {
		return updatedDate;
	}
	public void setUpdatedDate(Date updatedDate) {
		this.updatedDate = updatedDate;
	}
	public Date getCreatedDate() {
		return createdDate;
	}
	public void setCreatedDate(Date createdDate) {
		this.createdDate = createdDate;
	}
	public String getHexaval() {
		return hexaval;
	}
	public void setHexaval(String hexaval) {
		this.hexaval = hexaval;
	}
	public long getCustomerid() {
		return customerid;
	}
	public void setCustomerid(long customerid) {
		this.customerid = customerid;
	}
	public long getTagid() {
		return tagid;
	}
	public void setTagid(long tagid) {
		this.tagid = tagid;
	}
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
	public TagModal() {
		super();
		// TODO Auto-generated constructor stub
	}
	public TagModal(long tagid, String tagname, long tagRFid, long customerid, String hexaval) {
		super();
		this.tagid = tagid;
		this.tagname = tagname;
		this.tagRFid = tagRFid;
		this.customerid = customerid;
		this.hexaval = hexaval;
	}
	public TagModal(String str) 
	{
		this.hexaval=str;
		// TODO Auto-generated constructor stub
	}
	@Override
	public String toString() {
		return "TagModal [tagid=" + tagid + ", tagname=" + tagname + ", tagRFid=" + tagRFid + ", customerid="
				+ customerid + ", hexaval=" + hexaval + ", channels=" + channels + ", createdDate=" + createdDate
				+ ", updatedDate=" + updatedDate + "]";
	}
	
	
	
	

}
