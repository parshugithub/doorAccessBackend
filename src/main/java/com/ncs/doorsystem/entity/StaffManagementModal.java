package com.ncs.doorsystem.entity;

import java.io.Serializable;
import java.util.Calendar;
import java.util.Date;

import javax.annotation.Generated;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;

import com.fasterxml.jackson.annotation.JsonProperty;

@Entity
@Table(name="StaffManagement")
//@JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class,property = "staffId")
public class StaffManagementModal implements Serializable
{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	
	@Column(name = "staff_id")
	private long staffId;
	
	@Column(name = "customer_id")
	private long customerId;
	
	@Column(name = "firstname")
	private String firstname;
	
	@Column(name = "lastname")
	private String lastname;
	
	@Column(name = "payrollno")
	private String payrollno;
	
	@JsonFormat(pattern="yyyy-MM-dd HH:mm:ss")
	@Column(name = "expiraydate")
	private Date expiraydate;
	
	@JsonFormat(pattern="yyyy-MM-dd HH:mm:ss")
	@Column(name = "created_date")
	 @JoinColumn(name = "created_dates")
	private Date createdDate;
	
	 @JoinColumn(name = "created_by")
	@Column(name = "created_by")
	private String createdBy;
	
	@ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "groupid")
    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    private StaffGroupManagementModal staffGroup;
	
	public long getStaffId() {
		return staffId;
	}
	public void setStaffId(long staffId) {
		this.staffId = staffId;
	}
	public long getCustomerId() {
		return customerId;
	}
	public void setCustomerId(long customerId) {
		this.customerId = customerId;
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
	public String getPayrollno() {
		return payrollno;
	}
	public void setPayrollno(String payrollno) {
		this.payrollno = payrollno;
	}
	public Date getExpiraydate() {
		return expiraydate;
	}
	public void setExpiraydate(Date expiraydate) {
		this.expiraydate = expiraydate;
	}
	public Date getCreatedDate() {
		return createdDate;
	}
	public void setCreatedDate(Date createdDate) {
		this.createdDate = createdDate;
	}
	public String getCreatedBy() {
		return createdBy;
	}
	public void setCreatedBy(String createdBy) {
		this.createdBy = createdBy;
	}
	
	
	
	public StaffGroupManagementModal getStaffGroup() {
		return staffGroup;
	}
	public void setStaffGroup(StaffGroupManagementModal staffGroup) {
		this.staffGroup = staffGroup;
	}
	public StaffManagementModal(long staffId, long customerId, String firstname, String lastname, String payrollno, String createdBy) {
		
		Calendar calendar = Calendar.getInstance();
		
		this.staffId = staffId;
		this.customerId = customerId;
		this.firstname = firstname;
		this.lastname = lastname;
		this.payrollno = payrollno;
		this.expiraydate = new Date(calendar.getTime().getTime());
		this.createdDate =new Date(calendar.getTime().getTime());
		this.createdBy = createdBy;
	}
	public StaffManagementModal() {
		super();
		// TODO Auto-generated constructor stub
	}
	@Override
	public String toString() {
		return "StaffManagementModal [staffId=" + staffId + ", customerId=" + customerId + ", firstName=" + firstname
				+ ", lastName=" + lastname + ", payrollNo=" + payrollno + ", expiraydate=" + expiraydate
				+ ", createddDate=" + createdDate + ", createdBy=" + createdBy + "]";
	}
	public StaffManagementModal(String firstname, String lastname, String payrollno) {
		
		this.firstname = firstname;
		this.lastname = lastname;
		this.payrollno = payrollno;
	}
	public StaffManagementModal(long custid, String customerFullname, Date createdDate2) 
	{
		this.customerId=custid;
		this.createdBy=customerFullname;
		this.createdDate=createdDate2;
		
	}
	
	
	
	

}
