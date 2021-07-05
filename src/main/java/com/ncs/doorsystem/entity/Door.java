package com.ncs.doorsystem.entity;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonProperty;

@Entity
@Table(name = "channel_door_table")
public class Door
{
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long doorid;

	private long doorName;

	private long customerid;

	@ManyToOne
	private ChannelsModal channels;
	public long getDoorid() {
		return doorid;
	}
	public void setDoorid(long doorid) {
		this.doorid = doorid;
	}
	
	
	public long getDoorName() {
		return doorName;
	}
	public void setDoorName(long doorName) {
		this.doorName = doorName;
	}
	public long getCustomerid() {
		return customerid;
	}
	public void setCustomerid(long customerid) {
		this.customerid = customerid;
	}
	public ChannelsModal getChannels() {
		return channels;
	}
	public void setChannels(ChannelsModal channels) {
		this.channels = channels;
	}
	@Override
	public String toString() {
		return "Door [doorid=" + doorid + ", door=" + doorName + ", customerid=" + customerid + ", channels=" + channels
				+ "]";
	}

	
}
