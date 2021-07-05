package com.ncs.doorsystem.entity;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonFormat;



@Entity
@Table(name = "Customer_table")
public class Customer {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id ;
	
	@Column(name = "userval")
	private String userval;
	
	@Column(name = "firstname")
	private String firstname;
	
	@Column(name = "lastname")
	private String lastname;
	
	@Column(name = "mobileNo")
	private String mobileNo;
	
	@Column(name = "address")
	private String address;
	
	@Column(name = "emailId")
	private String emailId;
	
	@Column(name = "password")
	private String password;
	
	@Column(name = "confirmPassword")
	private String confirmPassword;
	
	@Column(name = "isEnable")
	private boolean isEnable;
	
	@JsonFormat(pattern="yyyy-MM-dd HH:mm:ss")
	private Date createdDate;
	
	
	
	public Date getCreatedDate() {
		return createdDate;
	}
	public void setCreatedDate(Date createdDate) {
		this.createdDate = createdDate;
	}
	public String getFirstname() {
		return firstname;
	}
	public void setFirstname(String firstname) {
		this.firstname = firstname;
	}
	public String getLastname() {
		return lastname;
	}
	public void setLastname(String lastname) {
		this.lastname = lastname;
	}
	public String getMobileNo() {
		return mobileNo;
	}
	public void setMobileNo(String mobileNo) {
		this.mobileNo = mobileNo;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	
	public boolean isEnable() {
		return isEnable;
	}
	public String getUserval() {
		return userval;
	}
	public void setUserval(String useridval) {
		this.userval = useridval;
	}
	public void setEnable(boolean isEnable) {
		this.isEnable = isEnable;
	}
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	
	public String getEmailId() {
		return emailId;
	}
	public void setEmailId(String emailId) {
		this.emailId = emailId;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getConfirmPassword() {
		return confirmPassword;
	}
	public void setConfirmPassword(String confirmPassword) {
		this.confirmPassword = confirmPassword;
	}
	
	
	public Customer() {
		super();
	}
	@Override
	public String toString() {
		return "Customer [id=" + id + ", userval=" + userval + ", firstname=" + firstname + ", lastname=" + lastname
				+ ", mobileNo=" + mobileNo + ", address=" + address + ", emailId=" + emailId + ", password=" + password
				+ ", confirmPassword=" + confirmPassword + ", isEnable=" + isEnable + ", createdDate=" + createdDate
				+ "]";
	}
	public Customer(long id, String userval, String firstname, String lastname, String mobileNo, String address,
			String emailId, String password, String confirmPassword, boolean isEnable, Date createdDate) {
		super();
		this.id = id;
		this.userval = userval;
		this.firstname = firstname;
		this.lastname = lastname;
		this.mobileNo = mobileNo;
		this.address = address;
		this.emailId = emailId;
		this.password = password;
		this.confirmPassword = confirmPassword;
		this.isEnable = isEnable;
		this.createdDate = createdDate;
	}
	
	
	
}
