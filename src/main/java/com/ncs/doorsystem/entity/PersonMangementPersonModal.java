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
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonFormat;

@Entity
@Table(name = "person_management_table")
public class PersonMangementPersonModal 
{
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long pid;
	private long webappPerosnId;//logged customer or user id
	private long siteid;
	private String firstName;
	private String lastName;
	private String email;
	private String mobileNumber;
	private String areaCode;
	private String telnumber;
	private String sipurl;
//	private String gender;
	private String address1;
	private String address2;
	private String city;
	private  String state;
	private  String country;	
	@JsonFormat(pattern="yyyy-MM-dd HH:mm:ss")
	@Column(name = "expiraydate")
	private Date expiraydate;
	
	@JsonFormat(pattern="yyyy-MM-dd HH:mm:ss")
	@Column(name = "createddate")
	private Date createddate;
	
	private long tradeCode;
	@OneToMany(targetEntity = PersonManagementProperty.class, cascade = CascadeType.ALL)
    @JoinColumn(name = "pid")
	private List<PersonManagementProperty> propery;
	
	 @ManyToOne(targetEntity = PersonManagementPersonClassModal.class,fetch = FetchType.EAGER,
		        cascade = {
		                CascadeType.MERGE,
		                CascadeType.REFRESH
		            } )
	  @JoinTable(
	          name="t_personmanagment_personclass_mapping_table",
	          joinColumns=
	          @JoinColumn( name="pid", referencedColumnName="pid"),
	          inverseJoinColumns=@JoinColumn(name="pclassid", referencedColumnName="pclassid"))
    private PersonManagementPersonClassModal personclassone;
	 
	 @ManyToMany(targetEntity = ScheduleMainModal.class,fetch = FetchType.EAGER,
		        cascade = {
		                CascadeType.MERGE,
		                CascadeType.REFRESH
		            } )
	  @JoinTable(
	          name="t_personmanagment_schedule_mapping_table",
	          joinColumns=
	          @JoinColumn( name="pid", referencedColumnName="pid"),
	          inverseJoinColumns=@JoinColumn(name="schedule_id", referencedColumnName="scheduleId"))
	 
	    private Set<ScheduleMainModal> schedule;

	 @ManyToMany(cascade={CascadeType.PERSIST, CascadeType.MERGE})
    @JoinTable(
            name="t_personmanagment_persongroup_mapping_table",
            joinColumns=
            @JoinColumn( name="pid", referencedColumnName="pid"),
            inverseJoinColumns=@JoinColumn(name="pgroupid", referencedColumnName="pgroupid"))
	
    private List<PersonManagementPersonGroup> persongroup;
	
	 @ManyToMany(cascade={CascadeType.ALL},fetch = FetchType.EAGER)
    @JoinTable(
            name="t_personmanagment_totaldoor_mapping_table",
            joinColumns=
            @JoinColumn( name="pid", referencedColumnName="pid"),
            inverseJoinColumns=@JoinColumn(name="doorId", referencedColumnName="doorId"))
	
    private Set<TotalDoorsModal> doors;
	
	
	 @ManyToMany(cascade={CascadeType.PERSIST, CascadeType.MERGE,CascadeType.REMOVE})
    @JoinTable(
            name="t_personmanagment_doorgroup_mapping_table",
            joinColumns=
            @JoinColumn( name="pid", referencedColumnName="pid"),
            inverseJoinColumns=@JoinColumn(name="doorgroupid", referencedColumnName="doorgroupid"))
	
    private List<DoorGroupModal> doorGroup;


	public long getPersonid() {
		return pid;
	}


	public void setPersonid(long personid) {
		this.pid = personid;
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


	public String getEmail() {
		return email;
	}


	public void setEmail(String email) {
		this.email = email;
	}


	public String getMobileNumber() {
		return mobileNumber;
	}


	public void setMobileNumber(String mobileNumber) {
		this.mobileNumber = mobileNumber;
	}


	public String getAreaCode() {
		return areaCode;
	}


	public void setAreaCode(String areaCode) {
		this.areaCode = areaCode;
	}


	public String getTelnumber() {
		return telnumber;
	}


	public void setTelnumber(String telnumber) {
		this.telnumber = telnumber;
	}


	public String getSipurl() {
		return sipurl;
	}


	public void setSipurl(String sipurl) {
		this.sipurl = sipurl;
	}


	public String getAddress1() {
		return address1;
	}


	public void setAddress1(String address1) {
		this.address1 = address1;
	}


	public String getAddress2() {
		return address2;
	}


	public void setAddress2(String address2) {
		this.address2 = address2;
	}


	public String getCity() {
		return city;
	}


	public void setCity(String city) {
		this.city = city;
	}


	public String getState() {
		return state;
	}


	public void setState(String state) {
		this.state = state;
	}


	public String getCountry() {
		return country;
	}


	public void setCountry(String country) {
		this.country = country;
	}


	public Date getExpiraydate() {
		return expiraydate;
	}


	public void setExpiraydate(Date expiraydate) {
		this.expiraydate = expiraydate;
	}


	public Date getCreateddate() {
		return createddate;
	}


	public void setCreateddate(Date createddate) {
		this.createddate = createddate;
	}


	public long getTradeCode() {
		return tradeCode;
	}


	public void setTradeCode(long tradeCode) {
		this.tradeCode = tradeCode;
	}


	

	


	public List<PersonManagementProperty> getPropery() {
		return propery;
	}


	public void setPropery(List<PersonManagementProperty> propery) {
		this.propery = propery;
	}


	public PersonManagementPersonClassModal getPersonclassone() {
		return personclassone;
	}


	public void setPersonclassone(PersonManagementPersonClassModal personclassone) {
		this.personclassone = personclassone;
	}


	public Set<ScheduleMainModal> getSchedule() {
		return schedule;
	}


	public void setSchedule(Set<ScheduleMainModal> schedule) {
		this.schedule = schedule;
	}


	public List<PersonManagementPersonGroup> getPersongroup() {
		return persongroup;
	}


	public void setPersongroup(List<PersonManagementPersonGroup> persongroup) {
		this.persongroup = persongroup;
	}


	public Set<TotalDoorsModal> getDoors() {
		return doors;
	}


	public void setDoors(Set<TotalDoorsModal> doors) {
		this.doors = doors;
	}


	public List<DoorGroupModal> getDoorGroup() {
		return doorGroup;
	}


	public void setDoorGroup(List<DoorGroupModal> doorGroup) {
		this.doorGroup = doorGroup;
	}


	@Override
	public String toString() {
		return "PersonMangementPersonModal [pid=" + pid + ", webappPerosnId=" + webappPerosnId + ", siteid="
				+ siteid + ", firstName=" + firstName + ", lastName=" + lastName + ", email=" + email
				+ ", mobileNumber=" + mobileNumber + ", areaCode=" + areaCode + ", telnumber=" + telnumber + ", sipurl="
				+ sipurl + ", address1=" + address1 + ", address2=" + address2 + ", city=" + city + ", state=" + state
				+ ", country=" + country + ", expiraydate=" + expiraydate + ", createddate=" + createddate
				+ ", tradeCode=" + tradeCode + ", propery=" + propery + ", personclassone=" + personclassone
				+ ", schedule=" + schedule + ", persongroup=" + persongroup + ", doors=" + doors + ", doorGroup="
				+ doorGroup + "]";
	}


	public PersonMangementPersonModal(long personid, long webappPerosnId, long siteid, String firstName,
			String lastName, String email, String mobileNumber, String areaCode, String telnumber, String sipurl,
			String address1, String address2, String city, String state, String country, Date expiraydate,
			Date createddate, long tradeCode, List<PersonManagementProperty> propery, PersonManagementPersonClassModal personclassone,
			Set<ScheduleMainModal> schedule, List<PersonManagementPersonGroup> persongroup, Set<TotalDoorsModal> doors,
			List<DoorGroupModal> doorGroup) {
		super();
		this.pid = personid;
		this.webappPerosnId = webappPerosnId;
		this.siteid = siteid;
		this.firstName = firstName;
		this.lastName = lastName;
		this.email = email;
		this.mobileNumber = mobileNumber;
		this.areaCode = areaCode;
		this.telnumber = telnumber;
		this.sipurl = sipurl;
		this.address1 = address1;
		this.address2 = address2;
		this.city = city;
		this.state = state;
		this.country = country;
		this.expiraydate = expiraydate;
		this.createddate = createddate;
		this.tradeCode = tradeCode;
		this.propery = propery;
		this.personclassone = personclassone;
		this.schedule = schedule;
		this.persongroup = persongroup;
		this.doors = doors;
		this.doorGroup = doorGroup;
	}


	public PersonMangementPersonModal() {
		super();
		// TODO Auto-generated constructor stub
	}
	 
	 
	
	

}
