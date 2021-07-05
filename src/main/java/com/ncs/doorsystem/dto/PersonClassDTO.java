package com.ncs.doorsystem.dto;

import java.util.Date;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.ncs.doorsystem.entity.PersonModal;

public class PersonClassDTO 
{

	private long personclassid;
	private long webAppPersonClassid;
	private long siteid;

	private String personClassName;

	@JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
	private Date expirydate;

	@JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
	private Date createddate;
	
	private List<PersonDTO> person;

	public long getPersonclassid() {
		return personclassid;
	}

	public void setPersonclassid(long personclassid) {
		this.personclassid = personclassid;
	}

	public long getWebAppPersonClassid() {
		return webAppPersonClassid;
	}

	public void setWebAppPersonClassid(long webAppPersonClassid) {
		this.webAppPersonClassid = webAppPersonClassid;
	}

	public long getSiteid() {
		return siteid;
	}

	public void setSiteid(long siteid) {
		this.siteid = siteid;
	}

	public String getPersonClassName() {
		return personClassName;
	}

	public void setPersonClassName(String personClassName) {
		this.personClassName = personClassName;
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

	public List<PersonDTO> getPerson() {
		return person;
	}

	public void setPerson(List<PersonDTO> list) {
		this.person = list;
	}
	
	
}
