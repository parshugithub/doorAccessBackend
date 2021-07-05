package com.ncs.doorsystem.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "access_levels")
public class AccessLevels 
{
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long accessid;
	private String accesslevel;
	
	
	public long getAccessid() {
		return accessid;
	}
	public void setAccessid(long accessid) {
		this.accessid = accessid;
	}
	public String getAccesslevel() {
		return accesslevel;
	}
	public void setAccesslevel(String accesslevel) {
		this.accesslevel = accesslevel;
	}
	@Override
	public String toString() {
		return "AccessLevels [accessid=" + accessid + ", accesslevel=" + accesslevel + "]";
	}
	public AccessLevels(long accessid, String accesslevel) {
		super();
		this.accessid = accessid;
		this.accesslevel = accesslevel;
	}
	public AccessLevels() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
	

}
