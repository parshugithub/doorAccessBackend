package com.ncs.doorsystem.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.springframework.data.mapping.AccessOptions.GetOptions.GetNulls;

@Entity
@Table(name = "user_table")
public class CreateUserModal implements Serializable
{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long user_id;
	
	@Column(name = "user_name",nullable = false)
	private String userName;
	
	
	@Column(name="first_name",nullable = false)
	private String firstName;
	
	@Column(name="last_name",nullable = false)
	private String lastName;
	
	@Column(name="address",nullable = false)
	private String address;
	
	@Column(name="user_type",nullable = false)
	private String user_type;
	
	@Column(name="phone_number",nullable = false)
	private String phone_number;
	
	@Column(name="email",nullable = false)
	private String email;
	
	@Column(name="sip_username")
	private String sip_username;
	
	@Column(name="sip_password")
	private String sip_password;
	
	
	@Column(name = "cust_id")
	private long custId;
	
	
	
	public long getUser_id() {
		return user_id;
	}
	public void setUser_id(long user_id) {
		this.user_id = user_id;
	}
	public long getCustId() {
		return custId;
	}
	public void setCustId(long custId) {
		this.custId = custId;
	}
	public String getSip_username() {
		return sip_username;
	}
	public void setSip_username(String sip_username) {
		this.sip_username = sip_username;
	}
	public String getSip_password() {
		return sip_password;
	}
	public void setSip_password(String sip_password) {
		this.sip_password = sip_password;
	}
	public Long getId() {
		return user_id;
	}
	public void setId(Long id) {
		this.user_id = id;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
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
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getUser_type() {
		return user_type;
	}
	public void setUser_type(String user_type) {
		this.user_type = user_type;
	}
	public String getPhone_number() {
		return phone_number;
	}
	public void setPhone_number(String phone_number) {
		this.phone_number = phone_number;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public CreateUserModal() {
		super();
		// TODO Auto-generated constructor stub
	}
	public CreateUserModal( String userName, String firstName, String lastName, String address,
			String user_type, String phone_number, String email,String sip_username,String sip_password ,long custId) {
		super();
		this.custId=custId;
		this.userName = userName;
		this.firstName = firstName;
		this.lastName = lastName;
		this.address = address;
		this.user_type = user_type;
		this.phone_number = phone_number;
		this.email = email;
		this.sip_username=sip_username;
		this.sip_password=sip_password;
	}
	@Override
	public String toString() {
		return "CreateUserModal [user_id=" + user_id + ", userName=" + userName + ", firstName=" + firstName
				+ ", lastName=" + lastName + ", address=" + address + ", user_type=" + user_type + ", phone_number="
				+ phone_number + ", email=" + email + ", sip_username=" + sip_username + ", sip_password="
				+ sip_password + "]";
	}
	
	
	
	
	
	
	
	

}
