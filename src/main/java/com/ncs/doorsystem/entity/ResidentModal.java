package com.ncs.doorsystem.entity;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonFormat;

@Entity
@Table(name = "resident_table")
public class ResidentModal 
{
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long residentid;
	private String personName;
	private long flatNumber;
	private long homeTelephone;
	private String emial;
	private String sipurl;
	private long mobileNumber;
	private String tagCode;
	private long tagNumber;
	@JsonFormat(pattern="yyyy-MM-dd HH:mm:ss")
	private Date createdDate;
	private String createdBy;
	private long customerid;
	private long siteid;
	
	
	
	
	
	
	public long getSiteid() {
		return siteid;
	}
	public void setSiteid(long siteid) {
		this.siteid = siteid;
	}
	public long getResidentid() {
		return residentid;
	}
	public void setResidentid(long residentid) {
		this.residentid = residentid;
	}
	public String getPersonName() {
		return personName;
	}
	public void setPersonName(String personName) {
		this.personName = personName;
	}
	public long getFlatNumber() {
		return flatNumber;
	}
	public void setFlatNumber(long flatNumber) {
		this.flatNumber = flatNumber;
	}
	public long getHomeTelephone() {
		return homeTelephone;
	}
	public void setHomeTelephone(long homeTelephone) {
		this.homeTelephone = homeTelephone;
	}
	public String getEmial() {
		return emial;
	}
	public void setEmial(String emial) {
		this.emial = emial;
	}
	public String getSipurl() {
		return sipurl;
	}
	public void setSipurl(String sipurl) {
		this.sipurl = sipurl;
	}
	public long getMobileNumber() {
		return mobileNumber;
	}
	public void setMobileNumber(long mobileNumber) {
		this.mobileNumber = mobileNumber;
	}
	public String getTagCode() {
		return tagCode;
	}
	public void setTagCode(String tagCode) {
		this.tagCode = tagCode;
	}
	public long getTagNumber() {
		return tagNumber;
	}
	public void setTagNumber(long tagNumber) {
		this.tagNumber = tagNumber;
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
	public long getCustomerid() {
		return customerid;
	}
	public void setCustomerid(long customerid) {
		this.customerid = customerid;
	}
	@Override
	public String toString() {
		return "ResidentModal [residentid=" + residentid + ", personName=" + personName + ", flatNumber=" + flatNumber
				+ ", homeTelephone=" + homeTelephone + ", emial=" + emial + ", sipurl=" + sipurl + ", MobileNumber="
				+ mobileNumber + ", tagCode=" + tagCode + ", tagNumber=" + tagNumber + ", createdDate=" + createdDate
				+ ", createdBy=" + createdBy + ", customerid=" + customerid + "]";
	}
	public ResidentModal() {
		super();
		// TODO Auto-generated constructor stub
	}
	public ResidentModal(long residentid, String personName, long flatNumber, long homeTelephone, String emial,
			String sipurl, long mobileNumber, String tagCode, long tagNumber, Date createdDate, String createdBy,
			long customerid,long siteid) {
		super();
		this.residentid = residentid;
		this.personName = personName;
		this.flatNumber = flatNumber;
		this.homeTelephone = homeTelephone;
		this.emial = emial;
		this.sipurl = sipurl;
		this.mobileNumber = mobileNumber;
		this.tagCode = tagCode;
		this.tagNumber = tagNumber;
		this.createdDate = createdDate;
		this.createdBy = createdBy;
		this.customerid = customerid;
		this.siteid=siteid;
	}
	
	
	
	

}
