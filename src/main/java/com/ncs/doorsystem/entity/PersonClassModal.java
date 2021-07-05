package com.ncs.doorsystem.entity;

import java.util.Collection;
import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;

@Entity
@Table(name = "person_class_table")
@JsonIdentityInfo(generator = ObjectIdGenerators.IntSequenceGenerator.class, property = "@personclassid", scope = PersonClassModal.class)
public class PersonClassModal {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long personclassid;
	private long webAppPersonClassid;

	private long siteid;

	private String personClassName;

	@JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
	private Date expirydate;

	@JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
	private Date createddate;

//	@ManyToMany(targetEntity = PersonModal.class, cascade = CascadeType.ALL, fetch = FetchType.EAGER)
//	@JoinTable(name = "t_person_personclass_mapping_table", joinColumns = @JoinColumn(name = "personclass_id", referencedColumnName = "personclassid"), inverseJoinColumns = @JoinColumn(name = "person_id", referencedColumnName = "personid"))
//	private List<PersonModal> person;

	public Date getCreateddate() {
		return createddate;
	}

	public void setCreateddate(Date createddate) {
		this.createddate = createddate;
	}

	public Date getExpirydate() {
		return expirydate;
	}

	public void setExpirydate(Date expirydate) {
		this.expirydate = expirydate;
	}

//	public List<PersonModal> getPerson() {
//		return person;
//	}
//
//	public void setPerson(List<PersonModal> person) {
//		this.person = person;
//	}

	public long getSiteid() {
		return siteid;
	}

	public void setSiteid(long siteid) {
		this.siteid = siteid;
	}

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

	public String getPersonClassName() {
		return personClassName;
	}

	public void setPersonClassName(String personClassName) {
		this.personClassName = personClassName;
	}

	public PersonClassModal() {
		super();
		// TODO Auto-generated constructor stub
	}

	public PersonClassModal(long personclassid, long webAppPersonClassid, List<PersonModal> person, long siteid,
			String personClassName, Date expirydate, Date createddate) {
		super();
		this.personclassid = personclassid;
		this.webAppPersonClassid = webAppPersonClassid;
		//this.person = person;
		this.siteid = siteid;
		this.personClassName = personClassName;
		this.expirydate = expirydate;
		this.createddate = createddate;
	}

	@Override
	public String toString() {
		return "PersonClassModal [personclassid=" + personclassid + ", webAppPersonClassid=" + webAppPersonClassid
				+ ", siteid=" + siteid + ", personClassName=" + personClassName + ", expirydate=" + expirydate
				+ ", createddate=" + createddate + "]";
	}
	

}
