package com.ncs.doorsystem.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude;

@Entity
@Table(name="Site_table")
public class CreateSiteModal 
{
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "siteid")
	private long siteid;
	
	@Column(name = "cust_id")
	private Long custId;
	
	@Column(name = "site_name")
	private String siteName;
	
	@Column(name = "device_id")
	private String deviceId;
	
	@Column(name = "site_reference")
	private String siteReference;
	
	@Column(name = "customer_name")
	private String customerName;
	
	@Column(name = "customer_address")
	private String customerAddress;
	
	@Column(name = "customer_phone")
	private String customerPhone;
	
	@Column(name = "address2")
	private String address2;
	
	@Column(name = "country")
	private String country;
	
	@Column(name = "area")
	private String area;
	
	@Column(name = "town")
	private String town;
	
	@Column(name = "city")
	private String city;
	
	
	
	public long getSiteid() {
		return siteid;
	}
	public void setSiteid(long siteid) {
		this.siteid = siteid;
	}
	public Long getCustId() {
		return custId;
	}
	public void setCustId(Long custId) {
		this.custId = custId;
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
		return address2;
	}
	public void setAddress2(String address2) {
		this.address2 = address2;
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
	
	
	public CreateSiteModal(long id,long custid, String siteName, String deviceId, String siteReference, String customerName,
			String customerAddress, String customerPhone, String address2, String country, String area, String town,
			String city) {
		this.siteid=id;
		this.custId=custid;
		this.siteName = siteName;
		this.deviceId = deviceId;
		this.siteReference = siteReference;
		this.customerName = customerName;
		this.customerAddress = customerAddress;
		this.customerPhone = customerPhone;
		this.address2 = address2;
		this.country = country;
		this.area = area;
		this.town = town;
		this.city = city;
	}
	@Override
	public String toString() {
		return "CreateSiteModal [id=" + siteid + ",custId=" + custId + ",, siteName=" + siteName + ", deviceId=" + deviceId + ", siteReference="
				+ siteReference + ", customerName=" + customerName + ", customerAddress=" + customerAddress
				+ ", customerPhone=" + customerPhone + ", Address2=" + address2 + ", country=" + country + ", area="
				+ area + ", town=" + town + ", city=" + city + "]";
	}
	public CreateSiteModal() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	

}
