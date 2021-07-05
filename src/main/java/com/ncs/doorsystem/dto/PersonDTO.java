package com.ncs.doorsystem.dto;

import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.ncs.doorsystem.entity.PersonClassModal;
import com.ncs.doorsystem.entity.PersonGroupModal;
import com.ncs.doorsystem.entity.Property;

public class PersonDTO 
{
	private long personid;
	private long webappPerosnId;//logged customer or user id
	private long siteid;
	private String firstName;
	private String lastName;
	private String mobileNumber;
//	private String gender;
	private String address1;
	//private String address2;
	private String city;
	private  String state;
	private  String country;
	//private long zipcode;
	
	@JsonFormat(pattern="yyyy-MM-dd HH:mm:ss")
	@Column(name = "expiraydate")
	private Date expiraydate;
	private long tradeCode;
	private List<Property> propery;
    private List<PersonClassDTO> personclass;
    private List<PersonGroupDTO> persongroup;
	public long getPersonid() {
		return personid;
	}
	public void setPersonid(long personid) {
		this.personid = personid;
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
	public String getMobileNumber() {
		return mobileNumber;
	}
	public void setMobileNumber(String mobileNumber) {
		this.mobileNumber = mobileNumber;
	}
	public String getAddress1() {
		return address1;
	}
	public void setAddress1(String address1) {
		this.address1 = address1;
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
	public long getTradeCode() {
		return tradeCode;
	}
	public void setTradeCode(long tradeCode) {
		this.tradeCode = tradeCode;
	}
	public List<Property> getPropery() {
		return propery;
	}
	public void setPropery(List<Property> propery) {
		this.propery = propery;
	}
	public List<PersonClassDTO> getPersonclass() {
		return personclass;
	}
	public void setPersonclass(List<PersonClassDTO> list) {
		this.personclass = list;
	}
	public List<PersonGroupDTO> getPersongroup() {
		return persongroup;
	}
	public void setPersongroup(List<PersonGroupDTO> list) {
		this.persongroup = list;
	}
    
    

}
