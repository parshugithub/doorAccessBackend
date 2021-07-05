package com.ncs.doorsystem.entity;

import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;

@Entity
@Table(name = "person_management_group_table")
@JsonIdentityInfo(
		scope = PersonManagementPersonGroup.class,
        generator = ObjectIdGenerators.IntSequenceGenerator.class,
        property = "pgroupid"
        )
public class PersonManagementPersonGroup 
{
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long pgroupid;
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
	@ManyToMany(targetEntity = PersonMangementPersonModal.class, mappedBy = "persongroup", cascade = { CascadeType.PERSIST,
			CascadeType.DETACH, CascadeType.MERGE, CascadeType.REFRESH })
	private List<PersonMangementPersonModal> person;


	


	public long getPgroupid() {
		return pgroupid;
	}


	public void setPgroupid(long pgroupid) {
		this.pgroupid = pgroupid;
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


	public List<PersonMangementPersonModal> getPerson() {
		return person;
	}


	public void setPerson(List<PersonMangementPersonModal> person) {
		this.person = person;
	}


	@Override
	public String toString() {
		return "PersonManagementPersonGroup [pgroupid=" + pgroupid + ", personGroupName=" + personGroupName
				+ ", expirydate=" + expirydate + ", createddate=" + createddate + ", webappPerosnId=" + webappPerosnId
				+ ", siteid=" + siteid + ", person=" + person + "]";
	}


	public PersonManagementPersonGroup(long pgroupid, String personGroupName, Date expirydate, Date createddate,
			long webappPerosnId, long siteid, List<PersonMangementPersonModal> person) {
		super();
		this.pgroupid = pgroupid;
		this.personGroupName = personGroupName;
		this.expirydate = expirydate;
		this.createddate = createddate;
		this.webappPerosnId = webappPerosnId;
		this.siteid = siteid;
		this.person = person;
	}


	public PersonManagementPersonGroup() {
		super();
		// TODO Auto-generated constructor stub
	}


	
	
	

}
