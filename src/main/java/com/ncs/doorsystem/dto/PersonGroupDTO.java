package com.ncs.doorsystem.dto;

import java.util.Date;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.ncs.doorsystem.entity.PersonModal;

public class PersonGroupDTO 
{
	private long persongroupid;
	private String personGroupName;
	@JsonFormat(pattern="yyyy-MM-dd HH:mm:ss")
	private Date expirydate;
	
	@JsonFormat(pattern="yyyy-MM-dd HH:mm:ss")
	private Date createddate;
	 private List<PersonModal> person;
	public long getPersongroupid() {
		return persongroupid;
	}
	public void setPersongroupid(long persongroupid) {
		this.persongroupid = persongroupid;
	}
	public String getPersonGroupName() {
		return personGroupName;
	}
	public void setPersonGroupName(String personGroupName) {
		this.personGroupName = personGroupName;
	}
	public Date getExpirydate() {
		return expirydate;
	}
	public void setExpirydate(Date expirydate) {
		this.expirydate = expirydate;
	}
	public Date getCreateddate() {
		return createddate;
	}
	public void setCreateddate(Date createddate) {
		this.createddate = createddate;
	}
	public List<PersonModal> getPerson() {
		return person;
	}
	public void setPerson(List<PersonModal> person) {
		this.person = person;
	}
	 
	 

}
