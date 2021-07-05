package com.ncs.doorsystem.entity;

import java.io.Serializable;
import java.util.Calendar;
import java.util.Date;
import java.util.HashSet;
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
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import org.codehaus.jackson.annotate.JsonBackReference;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonManagedReference;

@Entity
@Table(name ="staffgroupManagement")

public class StaffGroupManagementModal implements Serializable
{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long groupid;
	private String staffGroupName;
	private String createdBy;
	@JsonFormat(pattern="yyyy-MM-dd HH:mm:ss")
	private Date createdDate;
	
	private long customerid;
	
	
	@OneToMany(mappedBy = "staffGroup", cascade = CascadeType.ALL)
    private Set<StaffManagementModal> staff = new HashSet<>();
	
	public long getCustomerid() {
		return customerid;
	}

	public void setCustomerid(long customerid) {
		this.customerid = customerid;
	}

	public long getGroupid() {
		return groupid;
	}

	public void setGroupid(long groupid) {
		this.groupid = groupid;
	}

	public String getStaffGroupName() {
		return staffGroupName;
	}

	public void setStaffGroupName(String staffGroupName) {
		this.staffGroupName = staffGroupName;
	}

	public String getCreatedBy() {
		return createdBy;
	}

	public void setCreatedBy(String createdBy) {
		this.createdBy = createdBy;
	}

	public Date getCreatedDate() {
		return createdDate;
	}

	public void setCreatedDate(Date createdDate) {
		this.createdDate = createdDate;
	}

	public Set<StaffManagementModal> getStaff() {
		return staff;
	}

	public void setStaff(Set<StaffManagementModal> staff) {
		this.staff = staff;
		for(StaffManagementModal b : staff) {
            b.setStaffGroup(this);
        }
	}

	public StaffGroupManagementModal() {
		super();
		// TODO Auto-generated constructor stub
	}

	
	@Override
	public String toString() {
		return "StaffFGroupModal [groupid=" + groupid + ", staffGroupName=" + staffGroupName + ", createdBy="
				+ createdBy + ", createdDate=" + createdDate + ", customerid=" + customerid + ", staff=" + staff + "]";
	}

	
	
	

	
	

	
	
	

}
