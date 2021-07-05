package com.ncs.doorsystem.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "door_description")
public class DoorDescriptionModal 
{
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long doorDesId;
	private String description;
	private long door;
	private String telephoneNUmber;
	private String sip_url;
	private String dtmf;
	private String cameraStream;
	private long siteid;
	
	
	
	
	public String getSip_url() {
		return sip_url;
	}
	public void setSip_url(String sip_url) {
		this.sip_url = sip_url;
	}
	public String getDtmf() {
		return dtmf;
	}
	public void setDtmf(String dtmf) {
		this.dtmf = dtmf;
	}
	public long getDoor() {
		return door;
	}
	public void setDoor(long door) {
		this.door = door;
	}
	public long getSiteid() {
		return siteid;
	}
	public void setSiteid(long siteid) {
		this.siteid = siteid;
	}
	public long getDoorDesId() {
		return doorDesId;
	}
	public void setDoorDesId(long doorDesId) {
		this.doorDesId = doorDesId;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public String getTelephoneNUmber() {
		return telephoneNUmber;
	}
	public void setTelephoneNUmber(String telephoneNUmber) {
		this.telephoneNUmber = telephoneNUmber;
	}
	
	public String getCameraStream() {
		return cameraStream;
	}
	public void setCameraStream(String cameraStream) {
		this.cameraStream = cameraStream;
	}
	
	public DoorDescriptionModal() {
		super();
		// TODO Auto-generated constructor stub
	}
	@Override
	public String toString() {
		return "DoorDescriptionModal [doorDesId=" + doorDesId + ", description=" + description + ", door=" + door
				+ ", telephoneNUmber=" + telephoneNUmber + ", sip_url=" + sip_url + ", dtmf=" + dtmf + ", cameraStream="
				+ cameraStream + ", siteid=" + siteid + "]";
	}
	public DoorDescriptionModal(long doorDesId, String description, long door, String telephoneNUmber, String sip_url,
			String dtmf, String cameraStream, long siteid) {
		super();
		this.doorDesId = doorDesId;
		this.description = description;
		this.door = door;
		this.telephoneNUmber = telephoneNUmber;
		this.sip_url = sip_url;
		this.dtmf = dtmf;
		this.cameraStream = cameraStream;
		this.siteid = siteid;
	}
	public DoorDescriptionModal(DoorDescriptionModal doorDescriptionModal) {
		
	}
	
	
	
	

}
