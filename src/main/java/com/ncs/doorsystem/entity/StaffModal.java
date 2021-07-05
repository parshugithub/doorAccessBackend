package com.ncs.doorsystem.entity;

import java.util.Date;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonFormat;

@Entity
@Table(name = "Staff_table1")
public class StaffModal 
{
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String firstName;
	private String LastName;
	private String payrollNo;
	@JsonFormat(pattern="yyyy-MM-dd HH:mm:ss")
	private Date dateExpire;
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public String getLastName() {
		return LastName;
	}
	public void setLastName(String lastName) {
		LastName = lastName;
	}
	public String getPayrollNo() {
		return payrollNo;
	}
	public void setPayrollNo(String payrollNo) {
		this.payrollNo = payrollNo;
	}
	public Date getDateExpire() {
		return dateExpire;
	}
	public void setDateExpire(Date dateExpire) {
		this.dateExpire = dateExpire;
	}
	@Override
	public String toString() {
		return "StaffModal [id=" + id + ", firstName=" + firstName + ", LastName=" + LastName + ", payrollNo="
				+ payrollNo + ", dateExpire=" + dateExpire + "]";
	}
	public StaffModal(Long id, String firstName, String lastName, String payrollNo, Date dateExpire) {
		super();
		this.id = id;
		this.firstName = firstName;
		LastName = lastName;
		this.payrollNo = payrollNo;
		this.dateExpire = dateExpire;
	}
	public StaffModal() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	

}
