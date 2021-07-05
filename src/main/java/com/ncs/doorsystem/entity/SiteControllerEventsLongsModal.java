package com.ncs.doorsystem.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "sitecontroller_events_logs")
public class SiteControllerEventsLongsModal
{
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long srNo;
	private String dateAndTime;
	private String eventType;
	private String twoDoorcontrollerId;
	private String weigendOrLockChannelNum;
	private String deviceData;
	private String messageSuccess;
	private String weigendDeviceType;
	private String weigendDeviceClassification;
	private String personName;
	//private String personclass;
	//private String tagcolor;
	//private String property;
	private String site;
	private String physicalAccessAuthorised;
	
	
	public long getSrNo() {
		return srNo;
	}
	public void setSrNo(long srNo) {
		this.srNo = srNo;
	}
	public String getDateAndTime() {
		return dateAndTime;
	}
	public void setDateAndTime(String dateAndTime) {
		this.dateAndTime = dateAndTime;
	}
	public String getEventType() {
		return eventType;
	}
	public void setEventType(String eventType) {
		this.eventType = eventType;
	}
	public String getTwoDoorcontrollerId() {
		return twoDoorcontrollerId;
	}
	public void setTwoDoorcontrollerId(String twoDoorcontrollerId) {
		this.twoDoorcontrollerId = twoDoorcontrollerId;
	}
	public String getWeigendOrLockChannelNum() {
		return weigendOrLockChannelNum;
	}
	public void setWeigendOrLockChannelNum(String weigendOrLockChannelNum) {
		this.weigendOrLockChannelNum = weigendOrLockChannelNum;
	}
	public String getDeviceData() {
		return deviceData;
	}
	public void setDeviceData(String deviceData) {
		this.deviceData = deviceData;
	}
	public String getMessageSuccess() {
		return messageSuccess;
	}
	public void setMessageSuccess(String messageSuccess) {
		this.messageSuccess = messageSuccess;
	}
	public String getWeigendDeviceType() {
		return weigendDeviceType;
	}
	public void setWeigendDeviceType(String weigendDeviceType) {
		this.weigendDeviceType = weigendDeviceType;
	}
	public String getWeigendDeviceClassification() {
		return weigendDeviceClassification;
	}
	public void setWeigendDeviceClassification(String weigendDeviceClassification) {
		this.weigendDeviceClassification = weigendDeviceClassification;
	}
	public String getPersonName() {
		return personName;
	}
	public void setPersonName(String personName) {
		this.personName = personName;
	}
//	public String getPersonclass() {
//		return personclass;
//	}
//	public void setPersonclass(String personclass) {
//		this.personclass = personclass;
//	}
//	public String getTagcolor() {
//		return tagcolor;
//	}
//	public void setTagcolor(String tagcolor) {
//		this.tagcolor = tagcolor;
//	}
//	public String getProperty() {
//		return property;
//	}
//	public void setProperty(String property) {
//		this.property = property;
//	}
	public String getSite() {
		return site;
	}
	public void setSite(String site) {
		this.site = site;
	}
	public String getPhysicalAccessAuthorised() {
		return physicalAccessAuthorised;
	}
	public void setPhysicalAccessAuthorised(String physicalAccessAuthorised) {
		this.physicalAccessAuthorised = physicalAccessAuthorised;
	}
	public SiteControllerEventsLongsModal() {
		super();
		// TODO Auto-generated constructor stub
	}
	@Override
	public String toString() {
		return "SiteControllerEventsLongsModal [srNo=" + srNo + ", dateAndTime=" + dateAndTime + ", eventType="
				+ eventType + ", twoDoorcontrollerId=" + twoDoorcontrollerId + ", weigendOrLockChannelNum="
				+ weigendOrLockChannelNum + ", deviceData=" + deviceData + ", messageSuccess=" + messageSuccess
				+ ", weigendDeviceType=" + weigendDeviceType + ", weigendDeviceClassification="
				+ weigendDeviceClassification + ", personName=" + personName + ", physicalAccessAuthorised="
				+ physicalAccessAuthorised + "]";
	}
	public SiteControllerEventsLongsModal(long srNo, String dateAndTime, String eventType, String twoDoorcontrollerId,
			String weigendOrLockChannelNum, String deviceData, String messageSuccess, String weigendDeviceType,
			String weigendDeviceClassification, String personName, String physicalAccessAuthorised) {
		super();
		this.srNo = srNo;
		this.dateAndTime = dateAndTime;
		this.eventType = eventType;
		this.twoDoorcontrollerId = twoDoorcontrollerId;
		this.weigendOrLockChannelNum = weigendOrLockChannelNum;
		this.deviceData = deviceData;
		this.messageSuccess = messageSuccess;
		this.weigendDeviceType = weigendDeviceType;
		this.weigendDeviceClassification = weigendDeviceClassification;
		this.personName = personName;
		this.physicalAccessAuthorised = physicalAccessAuthorised;
	}
	
	
	
	
	
	
	
	
	

}
