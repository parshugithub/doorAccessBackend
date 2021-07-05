package com.ncs.doorsystem.entity;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

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
import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;

@Entity
@Table(name = "staff_table")
@JsonIdentityInfo(
		scope = StaffManyToMany.class,
        generator = ObjectIdGenerators.PropertyGenerator.class,
        property = "staffid"
        )
public class StaffManyToMany 
{
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long staffid;
	
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
	private Date createdDate;
	
	@Column(name = "created_by")
	private String createdBy;
	
	
	@ManyToMany(targetEntity = ScheduleMainModal.class,fetch = FetchType.EAGER,
	        cascade = {
	                CascadeType.MERGE,
	                CascadeType.REFRESH
	            } )
  @JoinTable(
          name="t_staff_schedule_mapping_table",
          joinColumns=
          @JoinColumn( name="staff_id", referencedColumnName="staffid"),
          inverseJoinColumns=@JoinColumn(name="schedule_id", referencedColumnName="scheduleId"))
    private List<ScheduleMainModal> schedule;
	
	@ManyToMany(targetEntity = StaffGroupManytoMany.class,mappedBy = "staffManyToMany")
	
//    @JoinTable(
//            name="t_staff_staffgroup_mapping_table",
//            joinColumns=
//            @JoinColumn( name="staff_id", referencedColumnName="staffid"),
//            inverseJoinColumns=@JoinColumn(name="staffgroup_id", referencedColumnName="groupid"))
    private List<StaffGroupManytoMany> staffgroup=new ArrayList<StaffGroupManytoMany>();;
	
	
	

	public List<ScheduleMainModal> getSchedule() {
		return schedule;
	}

	public void setSchedule(List<ScheduleMainModal> schedule) {
		this.schedule = schedule;
	}

	public long getStaffid() {
		return staffid;
	}

	public void setStaffid(long staffid) {
		this.staffid = staffid;
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

	public List<StaffGroupManytoMany> getStaffgroup() {
		return staffgroup;
	}

	public void setStaffgroup(List<StaffGroupManytoMany> staffgroup) {
		this.staffgroup = staffgroup;
	}

	

	

	

	@Override
	public String toString() {
		return "StaffManyToMany [staffid=" + staffid + ", customerId=" + customerId + ", firstname=" + firstname
				+ ", lastname=" + lastname + ", payrollno=" + payrollno + ", expiraydate=" + expiraydate
				+ ", createdDate=" + createdDate + ", createdBy=" + createdBy + ", schedule=" + schedule
				+ ", staffgroup=" + staffgroup + "]";
	}

	public StaffManyToMany(long staffid, long customerId, String firstname, String lastname, String payrollno,
			Date expiraydate, Date createdDate, String createdBy, List<ScheduleMainModal> schedule,
			List<StaffGroupManytoMany> staffgroup) {
		super();
		this.staffid = staffid;
		this.customerId = customerId;
		this.firstname = firstname;
		this.lastname = lastname;
		this.payrollno = payrollno;
		this.expiraydate = expiraydate;
		this.createdDate = createdDate;
		this.createdBy = createdBy;
		this.schedule = schedule;
		this.staffgroup = staffgroup;
	}

	public StaffManyToMany() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
	
	public void addStaffGroup(StaffGroupManytoMany staffgroup) {
        this.staffgroup.add(staffgroup);
        staffgroup.getStaffManyToMany().add(this);
    }
  
    public void removeStaffGroup(StaffGroupManytoMany staffgroup ) {
        this.staffgroup.remove(staffgroup);
        staffgroup.getStaffManyToMany().remove(this);
    }

	

}
