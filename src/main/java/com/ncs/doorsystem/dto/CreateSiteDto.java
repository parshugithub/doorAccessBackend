package com.ncs.doorsystem.dto;

import javax.persistence.Column;

public class CreateSiteDto 
{
	private String siteName;
	private String deviceId;
	private String siteReference;
	private String customerName;	
	private String customerAddress;
	private String customerPhone;
	private String Address2;
	private String country;
	private String area;
	private String town;
	private String city;
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
	public String getCustomerName() {
		return customerName;
	}
	public void setCustomerName(String customerName) {
		this.customerName = customerName;
	}
	public String getCustomerAddress() {
		return customerAddress;
	}
	public void setCustomerAddress(String customerAddress) {
		this.customerAddress = customerAddress;
	}
	public String getCustomerPhone() {
		return customerPhone;
	}
	public void setCustomerPhone(String customerPhone) {
		this.customerPhone = customerPhone;
	}
	public String getAddress2() {
		return Address2;
	}
	public void setAddress2(String address2) {
		Address2 = address2;
	}
	public String getCountry() {
		return country;
	}
	public void setCountry(String country) {
		this.country = country;
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
	@Override
	public String toString() {
		return "CreateSiteDto [siteName=" + siteName + ", deviceId=" + deviceId + ", siteReference=" + siteReference
				+ ", customerName=" + customerName + ", customerAddress=" + customerAddress + ", customerPhone="
				+ customerPhone + ", Address2=" + Address2 + ", country=" + country + ", area=" + area + ", town="
				+ town + ", city=" + city + "]";
	}
	public CreateSiteDto(String siteName, String deviceId, String siteReference, String customerName,
			String customerAddress, String customerPhone, String address2, String country, String area, String town,
			String city) {
		super();
		this.siteName = siteName;
		this.deviceId = deviceId;
		this.siteReference = siteReference;
		this.customerName = customerName;
		this.customerAddress = customerAddress;
		this.customerPhone = customerPhone;
		Address2 = address2;
		this.country = country;
		this.area = area;
		this.town = town;
		this.city = city;
	}
	
	
}
