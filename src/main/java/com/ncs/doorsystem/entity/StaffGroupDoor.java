package com.ncs.doorsystem.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "staffgroup_door_table")
public class StaffGroupDoor 
{
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long doorid;

	private long doorName;

	
	
	@ManyToOne
	 private StaffGroupManytoMany staffGroup;

	public long getDoorid() {
		return doorid;
	}

	public void setDoorid(long doorid) {
		this.doorid = doorid;
	}

	public long getDoorName() {
		return doorName;
	}

	public void setDoorName(long doorName) {
		this.doorName = doorName;
	}

	

	public StaffGroupManytoMany getStaffGroup() {
		return staffGroup;
	}

	public void setStaffGroup(StaffGroupManytoMany staffGroup) {
		this.staffGroup = staffGroup;
	}

	@Override
	public String toString() {
		return "StaffGroupDoor [doorid=" + doorid + ", doorName=" + doorName + ",  staffGroup=" + staffGroup + "]";
	}

	public StaffGroupDoor(long doorid, long doorName, long customerid, StaffGroupManytoMany staffGroup) {
		super();
		this.doorid = doorid;
		this.doorName = doorName;
		
		this.staffGroup = staffGroup;
	}

	public StaffGroupDoor() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	

}
