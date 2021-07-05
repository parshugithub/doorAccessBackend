package com.ncs.doorsystem.entity;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;

@Entity
@Table(name = "person_management_class_table")
@JsonIdentityInfo(generator = ObjectIdGenerators.IntSequenceGenerator.class, property = "@pclassid", scope = PersonManagementPersonClassModal.class)

public class PersonManagementPersonClassModal 
{
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long pclassid;
	private long webAppPersonClassid;

	private long siteid;

	private String personClassName;

	@JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
	private Date expirydate;

	@JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
	private Date createddate;

	

	public long getPclassid() {
		return pclassid;
	}

	public void setPclassid(long pclassid) {
		this.pclassid = pclassid;
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

	@Override
	public String toString() {
		return "PersonManagementPersonClassModal [pclassid=" + pclassid + ", webAppPersonClassid=" + webAppPersonClassid
				+ ", siteid=" + siteid + ", personClassName=" + personClassName + ", expirydate=" + expirydate
				+ ", createddate=" + createddate + "]";
	}

	public PersonManagementPersonClassModal(long pclassid, long webAppPersonClassid, long siteid,
			String personClassName, Date expirydate, Date createddate) {
		super();
		this.pclassid = pclassid;
		this.webAppPersonClassid = webAppPersonClassid;
		this.siteid = siteid;
		this.personClassName = personClassName;
		this.expirydate = expirydate;
		this.createddate = createddate;
	}

	public PersonManagementPersonClassModal() {
		super();
		// TODO Auto-generated constructor stub
	}

	

}
