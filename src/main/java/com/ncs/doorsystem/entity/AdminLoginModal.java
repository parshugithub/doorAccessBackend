package com.ncs.doorsystem.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

@Entity
@Table(name = "AdminLoginModal")
public class AdminLoginModal implements Serializable
{
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id", unique = true, nullable = false)
	private Long id;
	
	@Column(name = "user_name",nullable = false, unique = true)
	private String user_name;
	
	@Column(name = "email",nullable = false, unique = true)
	private String email;
	
	
	@Column(name="password",nullable = false)
	private String password;
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getUserName() {
		return user_name;
	}
	public void setUserName(String userName) {
		this.user_name = userName;
	}
	public String getEmailId() {
		return email;
	}
	public void setEmailId(String emailId) {
		email = emailId;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	
	
	public AdminLoginModal() {
		
		super();
		// TODO Auto-generated constructor stub
	}
	public AdminLoginModal(String userName, String email_id, String password) {
		super();
		this.user_name = userName;
		this.email = email_id;
		this.password = password;
	}
	@Override
	public String toString() {
		return "AdminLoginModal [id=" + id + ", userName=" + user_name + ", EmailId=" + email + ", password="
				+ password + "]";
	}
	
	
	
	

}
