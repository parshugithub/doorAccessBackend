package com.ncs.doorsystem.entity;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonFormat;

@Entity
@Table(name = "sip_setting_table")
public class SipSettingEntity 
{
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	private String serverAddress;
	private String registerInterval;
	private long portNumber;
	
	private long custid;
	
	@JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
	private Date createddate;

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getServerAddress() {
		return serverAddress;
	}

	public void setServerAddress(String serverAddress) {
		this.serverAddress = serverAddress;
	}

	public String getRegisterInterval() {
		return registerInterval;
	}

	public void setRegisterInterval(String registerInterval) {
		this.registerInterval = registerInterval;
	}

	public long getPortNumber() {
		return portNumber;
	}

	public void setPortNumber(long portNumber) {
		this.portNumber = portNumber;
	}

	public Date getCreateddate() {
		return createddate;
	}

	public void setCreateddate(Date createddate) {
		this.createddate = createddate;
	}

	public long getCustid() {
		return custid;
	}

	public void setCustid(long custid) {
		this.custid = custid;
	}

	public SipSettingEntity(long id, String serverAddress, String registerInterval, long portNumber, long custid,
			Date createddate) {
		super();
		this.id = id;
		this.serverAddress = serverAddress;
		this.registerInterval = registerInterval;
		this.portNumber = portNumber;
		this.custid = custid;
		this.createddate = createddate;
	}

	public SipSettingEntity() {
		super();
		// TODO Auto-generated constructor stub
	}

	@Override
	public String toString() {
		return "SipSettingEntity [id=" + id + ", serverAddress=" + serverAddress + ", registerInterval="
				+ registerInterval + ", portNumber=" + portNumber + ", custid=" + custid + ", createddate="
				+ createddate + "]";
	}

	

}
