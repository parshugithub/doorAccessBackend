package com.ncs.doorsystem.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "voice_operator")
public class VoiceOperatorModal 
{
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long vid;
	private String userName;
	private String firstName;
	private String lastName;
	private String address;
	private String email;
	private long isVoiceOperatot;
	private long siteid;
	private long custid;
	
	
	
	public long getCustid() {
		return custid;
	}
	public void setCustid(long custid) {
		this.custid = custid;
	}
	public long getSiteid() {
		return siteid;
	}
	public void setSiteid(long siteid) {
		this.siteid = siteid;
	}
	public long getVid() {
		return vid;
	}
	public void setVid(long vid) {
		this.vid = vid;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	
	public long getIsVoiceOperatot() {
		return isVoiceOperatot;
	}
	public void setIsVoiceOperatot(long isVoiceOperatot) {
		this.isVoiceOperatot = isVoiceOperatot;
	}
	public VoiceOperatorModal() {
		super();
		// TODO Auto-generated constructor stub
	}
	public VoiceOperatorModal(long vid, String userName, String firstName, String lastName, String address,
			String email, long isVoiceOperatot) {
		super();
		this.vid = vid;
		this.userName = userName;
		this.firstName = firstName;
		this.lastName = lastName;
		this.address = address;
		this.email = email;
		this.isVoiceOperatot = isVoiceOperatot;
	}
	@Override
	public String toString() {
		return "VoiceOperatorModal [vid=" + vid + ", userName=" + userName + ", firstName=" + firstName + ", lastName="
				+ lastName + ", address=" + address + ", email=" + email + ", isVoiceOperatot=" + isVoiceOperatot + "]";
	}
	
	
	

}
