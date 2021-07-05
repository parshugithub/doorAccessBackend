package com.ncs.doorsystem.entity;

import java.util.Collection;
import java.util.Date;
import java.util.List;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.ElementCollection;
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

import org.hibernate.annotations.Columns;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;

@Entity
@Table(name = "staff_group_table")

@JsonIdentityInfo(generator=ObjectIdGenerators.IntSequenceGenerator.class,property="@groupid", scope = StaffGroupManytoMany.class)

//@JsonIdentityInfo(
//		scope = StaffGroupManytoMany.class,
//        generator = ObjectIdGenerators.PropertyGenerator.class,
//        property = "@groupid")
public class StaffGroupManytoMany 
{
	 @Id
	 @GeneratedValue(strategy = GenerationType.IDENTITY)
	private long groupid;
	 @Column(name = "staff_group_id")
	private long staffGroupId;
	private String staffGroupName;
	private String createdBy;
	@JsonFormat(pattern="yyyy-MM-dd HH:mm:ss")
	private Date createdDate;
	private long customerid;
		
	@ManyToMany(targetEntity = StaffManyToMany.class, 
			cascade = {CascadeType.ALL})
	@JoinTable(
            name="t_staff_staffgroup_mapping_table",
            joinColumns=
            @JoinColumn( name="staffgroup_id", referencedColumnName="groupid"),
            inverseJoinColumns=@JoinColumn(name="staff_id", referencedColumnName="staffid"))
    private List<StaffManyToMany> staffManyToMany;
	
	
	@ManyToMany(cascade={CascadeType.ALL})
	
	@JoinTable(name = "t_staffgroup_Site_mapping_table",
	joinColumns = @JoinColumn(name = "group_id", unique=false),
	inverseJoinColumns = @JoinColumn(name = "site_id", unique=false))
	private List<CreateSiteModal> sites;
	
	
	@ManyToMany(cascade={CascadeType.ALL})
	@JoinTable(name = "t_staffgroup_door_mapping_table",
	joinColumns = @JoinColumn(name = "group_id", unique=false),
	inverseJoinColumns = @JoinColumn(name = "door_id", unique=false))
	private List<TotalDoorsModal> doors;
	
	@ManyToMany(cascade={CascadeType.ALL})
	@JoinTable(name = "t_staffgroup_Tag_mapping_table",
	joinColumns = @JoinColumn(name = "group_id", unique=false),
	inverseJoinColumns = @JoinColumn(name = "tag_id", unique=false))
	private List<StaffGroupTags> tags;
	
	
	
	
	
	public List<StaffGroupTags> getTags() {
		return tags;
	}

	public void setTags(List<StaffGroupTags> tags) {
		this.tags = tags;
	}

	public List<TotalDoorsModal> getDoors() {
		return doors;
	}

	public void setDoors(List<TotalDoorsModal> doorslist) {
		this.doors = doorslist;
	}

	public List<CreateSiteModal> getSites() {
		return sites;
	}

	public void setSites(List<CreateSiteModal> sites) {
		this.sites = sites;
	}

	public long getStaffGroupId() {
		return staffGroupId;
	}

	public void setStaffGroupId(long staffGroupId) {
		this.staffGroupId = staffGroupId;
	}

	public List<StaffManyToMany> getStaffManyToMany() {
		return staffManyToMany;
	}

	public void setStaffManyToMany(List<StaffManyToMany> staffManyToMany) {
		this.staffManyToMany = staffManyToMany;
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

	public long getCustomerid() {
		return customerid;
	}

	public void setCustomerid(long customerid) {
		this.customerid = customerid;
	}

	
	

	

	public StaffGroupManytoMany(long groupid, String staffGroupName, String createdBy, Date createdDate, long customerid,
			List<StaffManyToMany> staffManyToMany,long staffGroupId ) {
		super();
		//this.groupid = groupid;
		this.staffGroupName = staffGroupName;
		this.createdBy = createdBy;
		this.createdDate = createdDate;
		this.customerid = customerid;
		this.staffManyToMany = staffManyToMany;
		this.staffGroupId = staffGroupId;
	}

	public StaffGroupManytoMany() {
		super();
		// TODO Auto-generated constructor stub
	}

	
	public void addStaff(StaffManyToMany staff) {
        this.staffManyToMany.add(staff);
        staff.getStaffgroup().add(this);
    }
  
    public void removeStaff(StaffManyToMany staff) {
        this.staffManyToMany.remove(staff);
        staff.getStaffgroup().remove(this);
    }

//	@Override
//	public String toString() {
//		return "StaffGroupManytoMany [groupid=" + groupid + ", staffGroupId=" + staffGroupId + ", staffGroupName="
//				+ staffGroupName + ", createdBy=" + createdBy + ", createdDate=" + createdDate + ", customerid="
//				+ customerid + ", staffManyToMany=" + staffManyToMany + ", sites=" + sites + ", doors=" + doors
//				+ ", tags=" + tags + "]";
//	}

//	public StaffGroupManytoMany(List<StaffManyToMany> staff2) {
//		this.staffManyToMany=staff2;
//	}
    
    
    
    
	

}
