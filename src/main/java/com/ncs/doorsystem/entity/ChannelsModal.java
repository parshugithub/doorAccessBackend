package com.ncs.doorsystem.entity;

import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.annotation.Generated;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonFormat;

@Entity
@Table(name = "channels")
public class ChannelsModal
{
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long channelid;
	private long channel;
	private long flat;
	private long ppp;
	private long customerid;
	private long siteid;
	
	
	
	@JsonFormat(pattern="yyyy-MM-dd HH:mm:ss")
	@Column(name = "created_date")
	 @JoinColumn(name = "created_dates")
	private Date createdDate;
	
	@JoinColumn(name = "created_by")
	@Column(name = "created_by")
	private String createdBy;
	
	@OneToMany(targetEntity = Door.class, cascade = CascadeType.ALL)
    @JoinColumn(name = "channels_id")
    private List<Door> door;
	
	@OneToMany(targetEntity = ChannelTag.class, cascade = CascadeType.ALL)
    @JoinColumn(name = "channels_id")
    private List<ChannelTag> tags;
	
	
	
	
	public List<ChannelTag> getTags() {
		return tags;
	}

	public void setTags(List<ChannelTag> tags) {
		this.tags = tags;
	}

	public long getSiteid() {
		return siteid;
	}

	public void setSiteid(long siteid) {
		this.siteid = siteid;
	}


	public long getChannelid() {
		return channelid;
	}

	public void setChannelid(long channelid) {
		this.channelid = channelid;
	}

	public long getChannel() {
		return channel;
	}

	public void setChannel(long channel) {
		this.channel = channel;
	}

	public long getFlat() {
		return flat;
	}

	public void setFlat(long flat) {
		this.flat = flat;
	}

	public long getPpp() {
		return ppp;
	}

	public void setPpp(long ppp) {
		this.ppp = ppp;
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

	public String getCreatedBy() {
		return createdBy;
	}

	public void setCreatedBy(String createdBy) {
		this.createdBy = createdBy;
	}

	public List<Door> getDoor() {
		return door;
	}

	public void setDoor(List<Door> door) {
		this.door = door;
	}

	@Override
	public String toString() {
		return "ChannelsModal [channelid=" + channelid + ", channel=" + channel + ", flat=" + flat + ", ppp=" + ppp
				+ ", customerid=" + customerid + ", createdDate=" + createdDate + ", createdBy=" + createdBy + ", door="
				+ door + "]";
	}

	public ChannelsModal() {
		super();
		// TODO Auto-generated constructor stub
	}

	public ChannelsModal(long channelid, long channel, long flat, long ppp, long customerid, long siteid,
			Date createdDate, String createdBy, List<Door> door, List<ChannelTag> tags) {
		super();
		this.channelid = channelid;
		this.channel = channel;
		this.flat = flat;
		this.ppp = ppp;
		this.customerid = customerid;
		this.siteid = siteid;
		this.createdDate = createdDate;
		this.createdBy = createdBy;
		this.door = door;
		this.tags = tags;
	}
	
	
	
	

	

}
