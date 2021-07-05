package com.ncs.doorsystem.entity;

import java.util.Date;
import java.util.List;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
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

@Entity
@Table(name = "doormanagement_door_table")
public class DoorManagementModal 
{
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long doorid;
	private String doorname;
	private String tradecode;
	private String locktime;
	private String accessType;
	private long custid;
	private long siteid;
	@JsonFormat(pattern="yyyy-MM-dd HH:mm:ss")
	@Column(name = "createddate")
	private Date createddate;
	
	@JsonFormat(pattern="yyyy-MM-dd HH:mm:ss")
	@Column(name = "updateddate")
	private Date updateddate;

	@ManyToMany(cascade = { CascadeType.PERSIST, CascadeType.MERGE })
	@JoinTable(name = "t_doormanagement_persongroup_mapping_table", 
	joinColumns = @JoinColumn(name = "doorid", referencedColumnName = "doorid"), 
	inverseJoinColumns = @JoinColumn(name = "pgroupid", referencedColumnName = "pgroupid"))

	private List<PersonManagementPersonGroup> persongroup;

	@ManyToMany(cascade = { CascadeType.PERSIST, CascadeType.MERGE })
	@JoinTable(name = "t_doormanagement_person_mapping_table",
	joinColumns = @JoinColumn(name = "doorid", referencedColumnName = "doorid"), 
	inverseJoinColumns = @JoinColumn(name = "pid", referencedColumnName = "pid"))

	private List<PersonMangementPersonModal> person;

	@ManyToMany(targetEntity = ScheduleMainModal.class, fetch = FetchType.EAGER, cascade = { CascadeType.MERGE,
			CascadeType.REFRESH })
	@JoinTable(name = "t_doormanagement_schedule_mapping_table",
	joinColumns = @JoinColumn(name = "doorid",referencedColumnName = "doorid"),
	inverseJoinColumns = @JoinColumn(name = "schedule_id", referencedColumnName = "scheduleId"))

	private Set<ScheduleMainModal> schedule;
	
	@OneToMany(targetEntity = DoorDescriptionModal.class,cascade = CascadeType.ALL)
	@JoinColumn(name = "doorid")
	private List<DoorDescriptionModal> doordesc;

	public long getDoorid() {
		return doorid;
	}

	public void setDoorid(long doorid) {
		this.doorid = doorid;
	}

	public String getDoorname() {
		return doorname;
	}

	public void setDoorname(String doorname) {
		this.doorname = doorname;
	}

	public String getTradecode() {
		return tradecode;
	}

	public void setTradecode(String tradecode) {
		this.tradecode = tradecode;
	}

	public String getLocktime() {
		return locktime;
	}

	public void setLocktime(String locktime) {
		this.locktime = locktime;
	}

	public String getAccessType() {
		return accessType;
	}

	public void setAccessType(String accessType) {
		this.accessType = accessType;
	}

	public List<PersonManagementPersonGroup> getPersongroup() {
		return persongroup;
	}

	public void setPersongroup(List<PersonManagementPersonGroup> persongroup) {
		this.persongroup = persongroup;
	}

	public List<PersonMangementPersonModal> getPerson() {
		return person;
	}

	public void setPerson(List<PersonMangementPersonModal> person) {
		this.person = person;
	}

	public Set<ScheduleMainModal> getSchedule() {
		return schedule;
	}

	public void setSchedule(Set<ScheduleMainModal> schedule) {
		this.schedule = schedule;
	}

	public List<DoorDescriptionModal> getDoordesc() {
		return doordesc;
	}

	public void setDoordesc(List<DoorDescriptionModal> doordesc) {
		this.doordesc = doordesc;
	}

	
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

	@Override
	public String toString() {
		return "DoorManagementModal [doorid=" + doorid + ", doorname=" + doorname + ", tradecode=" + tradecode
				+ ", locktime=" + locktime + ", accessType=" + accessType + ", persongroup=" + persongroup + ", person="
				+ person + ", schedule=" + schedule + ", doordesc=" + doordesc + "]";
	}

	public DoorManagementModal(long doorid, String doorname, String tradecode, String locktime, String accessType,
			List<PersonManagementPersonGroup> persongroup, List<PersonMangementPersonModal> person,
			Set<ScheduleMainModal> schedule, List<DoorDescriptionModal> doordesc) {
		super();
		this.doorid = doorid;
		this.doorname = doorname;
		this.tradecode = tradecode;
		this.locktime = locktime;
		this.accessType = accessType;
		this.persongroup = persongroup;
		this.person = person;
		this.schedule = schedule;
		this.doordesc = doordesc;
	}

	public DoorManagementModal() {
		super();
		// TODO Auto-generated constructor stub
	}

	
}
