package com.ncs.doorsystem.entity;

import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonFormat;

@Entity
@Table(name = "doormanagement_door_group_table")
public class DoorManagementDoorGroupModal 
{
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long dgroupid;
	private String doorGroupName;
	@JsonFormat(pattern="yyyy-MM-dd HH:mm:ss")
	@Column(name = "expiraydate")
	private Date expiraydate;
	private long siteid;
	private long custid;
	
	@JsonFormat(pattern="yyyy-MM-dd HH:mm:ss")
	@Column(name = "createdate")
	private Date createdDate;
	
	@ManyToMany(cascade={CascadeType.PERSIST,CascadeType.MERGE,CascadeType.DETACH,CascadeType.REMOVE})
	@JoinTable(name = "t_doormanagementdoorgroup_door_mapping_table",
	joinColumns = @JoinColumn(name = "dgroupid", unique=false),
	inverseJoinColumns = @JoinColumn(name = "door_id", unique=false))
	private List<TotalDoorsModal> doors;

	public long getDgroupid() {
		return dgroupid;
	}

	public void setDgroupid(long dgroupid) {
		this.dgroupid = dgroupid;
	}

	public String getDoorGroupName() {
		return doorGroupName;
	}

	public void setDoorGroupName(String doorGroupName) {
		this.doorGroupName = doorGroupName;
	}

	public Date getExpiraydate() {
		return expiraydate;
	}

	public void setExpiraydate(Date expiraydate) {
		this.expiraydate = expiraydate;
	}

	public long getSiteid() {
		return siteid;
	}

	public void setSiteid(long siteid) {
		this.siteid = siteid;
	}

	public long getCustid() {
		return custid;
	}

	public void setCustid(long custid) {
		this.custid = custid;
	}

	public Date getCreatedDate() {
		return createdDate;
	}

	public void setCreatedDate(Date createdDate) {
		this.createdDate = createdDate;
	}

	public List<TotalDoorsModal> getDoors() {
		return doors;
	}

	public void setDoors(List<TotalDoorsModal> doors) {
		this.doors = doors;
	}

	@Override
	public String toString() {
		return "DoorManagementDoorGroupModal [dgroupid=" + dgroupid + ", doorGroupName=" + doorGroupName
				+ ", expiraydate=" + expiraydate + ", siteid=" + siteid + ", custid=" + custid + ", createdDate="
				+ createdDate + ", doors=" + doors + "]";
	}

	public DoorManagementDoorGroupModal(long dgroupid, String doorGroupName, Date expiraydate, long siteid, long custid,
			Date createdDate, List<TotalDoorsModal> doors) {
		super();
		this.dgroupid = dgroupid;
		this.doorGroupName = doorGroupName;
		this.expiraydate = expiraydate;
		this.siteid = siteid;
		this.custid = custid;
		this.createdDate = createdDate;
		this.doors = doors;
	}

	public DoorManagementDoorGroupModal() {
		super();
		// TODO Auto-generated constructor stub
	}

	
	
}
