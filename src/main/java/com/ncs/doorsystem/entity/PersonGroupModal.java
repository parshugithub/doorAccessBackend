package com.ncs.doorsystem.entity;

import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;

@Entity
@Table(name = "person_group_table")
@JsonIdentityInfo(
		scope = PersonGroupModal.class,
        generator = ObjectIdGenerators.IntSequenceGenerator.class,
        property = "persongroupid"
        )
//@JsonIdentityInfo(generator = ObjectIdGenerators.IntSequenceGenerator.class, property = "@persongroupid", scope = PersonGroupModal.class)
public class PersonGroupModal {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long persongroupid;
	private String personGroupName;
	@JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
	private Date expirydate;

	@JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
	private Date createddate;
	
	private long webappPerosnId;// logged customer or user id
	private long siteid;


//	@ManyToMany(targetEntity = PersonModal.class, cascade = CascadeType.ALL, fetch = FetchType.EAGER )
//  @JoinTable(
//          name="t_person_persongroup_mapping_table",
//          joinColumns=
//          @JoinColumn( name="persongroup_id", referencedColumnName="persongroupid"),
//          inverseJoinColumns=@JoinColumn(name="person_id", referencedColumnName="personid"))
//  private List<PersonModal> person;

//
	@ManyToMany(targetEntity = PersonModal.class, mappedBy = "persongroup", cascade = { CascadeType.PERSIST,
			CascadeType.DETACH, CascadeType.MERGE, CascadeType.REFRESH })
	private List<PersonModal> person;

//	public List<PersonModal> getPerson() {
//		return person;
//	}
//
//	public void setPerson(List<PersonModal> person) {
//		this.person = person;
//	}

	
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

	public long getWebappPerosnId() {
		return webappPerosnId;
	}

	public void setWebappPerosnId(long webappPerosnId) {
		this.webappPerosnId = webappPerosnId;
	}

	public long getSiteid() {
		return siteid;
	}

	public void setSiteid(long siteid) {
		this.siteid = siteid;
	}

	public PersonGroupModal() {
		super();
		// TODO Auto-generated constructor stub
	}

	@Override
	public String toString() {
		return "PersonGroupModal [persongroupid=" + persongroupid + ", personGroupName=" + personGroupName
				+ ", expirydate=" + expirydate + ", createddate=" + createddate 
				+ ", webappPerosnId=" + webappPerosnId + ", siteid=" + siteid + "]";
	}

	public PersonGroupModal(long persongroupid, String personGroupName, Date expirydate, Date createddate,
			List<PersonModal> person, long webappPerosnId, long siteid) {
		super();
		this.persongroupid = persongroupid;
		this.personGroupName = personGroupName;
		this.expirydate = expirydate;
		this.createddate = createddate;
	//	this.person = person;
		this.webappPerosnId = webappPerosnId;
		this.siteid = siteid;
	}

}
