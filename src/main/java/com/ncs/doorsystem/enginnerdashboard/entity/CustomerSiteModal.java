package com.ncs.doorsystem.enginnerdashboard.entity;

import java.util.Date;
import java.util.List;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonFormat;

@Entity
@Table(name = "customer_site_table")
public class CustomerSiteModal
{
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long siteid;
	private String siteName;
	private long deviceID;
//	@ManyToMany(cascade={CascadeType.ALL},fetch = FetchType.EAGER)
//	@JoinTable(
//            name="t_customer_site_door_mapping_table",
//            joinColumns=
//            @JoinColumn( name="siteid", referencedColumnName="siteid"),
//            inverseJoinColumns=@JoinColumn(name="doorid", referencedColumnName="doorid"))
//    private List<TotalDoorModal> doors;
	
	@JsonFormat(pattern="yyyy-MM-dd HH:mm:ss")
	private Date createdDate;
	
	private long customerid;

	public long getSiteid() {
		return siteid;
	}

	public void setSiteid(long siteid) {
		this.siteid = siteid;
	}

	public String getSiteName() {
		return siteName;
	}

	public void setSiteName(String siteName) {
		this.siteName = siteName;
	}

	public long getDeviceID() {
		return deviceID;
	}

	public void setDeviceID(long deviceID) {
		this.deviceID = deviceID;
	}

//	public List<TotalDoorModal> getDoors() {
//		return doors;
//	}
//
//	public void setDoors(List<TotalDoorModal> doors) {
//		this.doors = doors;
//	}

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
		return "CustomerSiteModal [siteid=" + siteid + ", siteName=" + siteName + ", deviceID=" + deviceID + ", createdDate=" + createdDate + ", customerid=" + customerid + "]";
	}

	public CustomerSiteModal(long siteid, String siteName, long deviceID, List<TotalDoorModal> doors, Date createdDate,
			long customerid) {
		super();
		this.siteid = siteid;
		this.siteName = siteName;
		this.deviceID = deviceID;
//		this.doors = doors;
		this.createdDate = createdDate;
		this.customerid = customerid;
	}

	public CustomerSiteModal() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
	
	
	
}
