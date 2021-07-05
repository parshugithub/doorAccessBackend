package com.ncs.doorsystem.entity;

import javax.annotation.Generated;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "Dashboard_table")
public class DashBoardmodal
{
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	private String siteName;
	private String deviceId;
	private String siteReference;
	private String siteControllerName;
	private String sitControllerPhone;
	private String siteAddress;
	private String area;
	private String town;
	private String city;
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public String getSiteName() {
		return siteName;
	}
	public void setSiteName(String siteName) {
		this.siteName = siteName;
	}
	public String getDeviceId() {
		return deviceId;
	}
	public void setDeviceId(String deviceId) {
		this.deviceId = deviceId;
	}
	public String getSiteReference() {
		return siteReference;
	}
	public void setSiteReference(String siteReference) {
		this.siteReference = siteReference;
	}
	public String getSiteControllerName() {
		return siteControllerName;
	}
	public void setSiteControllerName(String siteControllerName) {
		this.siteControllerName = siteControllerName;
	}
	public String getSitControllerPhone() {
		return sitControllerPhone;
	}
	public void setSitControllerPhone(String sitControllerPhone) {
		this.sitControllerPhone = sitControllerPhone;
	}
	public String getSiteAddress() {
		return siteAddress;
	}
	public void setSiteAddress(String siteAddress) {
		this.siteAddress = siteAddress;
	}
	public String getArea() {
		return area;
	}
	public void setArea(String area) {
		this.area = area;
	}
	public String getTown() {
		return town;
	}
	public void setTown(String town) {
		this.town = town;
	}
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	public DashBoardmodal(long id, String siteName, String deviceId, String siteReference, String siteControllerName,
			String sitControllerPhone, String siteAddress, String area, String town, String city) {
		super();
		this.id = id;
		this.siteName = siteName;
		this.deviceId = deviceId;
		this.siteReference = siteReference;
		this.siteControllerName = siteControllerName;
		this.sitControllerPhone = sitControllerPhone;
		this.siteAddress = siteAddress;
		this.area = area;
		this.town = town;
		this.city = city;
	}
	public DashBoardmodal() {
		super();
		
	}
	@Override
	public String toString() {
		return "DashBoardmodal [id=" + id + ", siteName=" + siteName + ", deviceId=" + deviceId + ", siteReference="
				+ siteReference + ", siteControllerName=" + siteControllerName + ", sitControllerPhone="
				+ sitControllerPhone + ", siteAddress=" + siteAddress + ", area=" + area + ", town=" + town + ", city="
				+ city + "]";
	}
	
	
	

}
