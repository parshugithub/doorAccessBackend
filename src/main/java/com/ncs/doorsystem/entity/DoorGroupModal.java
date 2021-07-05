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
import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;

@Entity
@Table(name = "door_group_table")
//@JsonIdentityInfo(
//		scope = DoorGroupModal.class,
//        generator = ObjectIdGenerators.IntSequenceGenerator.class,
//        property = "doorgroupid"
//        )
public class DoorGroupModal
{
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long doorgroupid;
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
	@JoinTable(name = "t_doorgroup_door_mapping_table",
	joinColumns = @JoinColumn(name = "doorgroupid", unique=false),
	inverseJoinColumns = @JoinColumn(name = "door_id", unique=false))
	private List<TotalDoorsModal> doors;

	
	
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

	public long getDoorgroupid() {
		return doorgroupid;
	}

	public void setDoorgroupid(long doorgroupid) {
		this.doorgroupid = doorgroupid;
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
		return "DoorGroupModal [doorgroupid=" + doorgroupid + ", doorGroupName=" + doorGroupName + ", expiraydate="
				+ expiraydate + ", createdDate=" + createdDate + ", doors=" + doors + "]";
	}

	public DoorGroupModal() {
		super();
		// TODO Auto-generated constructor stub
	}

	public DoorGroupModal(long doorgroupid, String doorGroupName, Date expiraydate, Date createdDate,
			List<TotalDoorsModal> doors) {
		super();
	//	this.doorgroupid = doorgroupid;
		this.doorGroupName = doorGroupName;
		this.expiraydate = expiraydate;
		this.createdDate = createdDate;
		this.doors = doors;
	}
	
	
	
	

}
