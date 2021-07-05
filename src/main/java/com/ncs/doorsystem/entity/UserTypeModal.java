package com.ncs.doorsystem.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "user_type")
public class UserTypeModal 
{
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "user_id")
	private Long user_id;
	
	@Column(name = "user_type")
	private String user_type;

	public Long getUserId() {
		return user_id;
	}

	public void setUserId(Long userId) {
		user_id = userId;
	}

	public String getUserType() {
		return user_type;
	}

	public void setUserType(String userType) {
		user_type = userType;
	}

	public UserTypeModal() {
		super();
		// TODO Auto-generated constructor stub
	}

	public UserTypeModal(Long userId, String userType) {
		
		user_id = userId;
		user_type = userType;
	}

	@Override
	public String toString() {
		return "UserTypeModal [UserId=" + user_id + ", UserType=" + user_type + "]";
	}
	
	
	

}
