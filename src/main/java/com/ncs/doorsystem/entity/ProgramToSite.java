package com.ncs.doorsystem.entity;

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
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "staffgroup_program_to_site")
public class ProgramToSite 
{
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	private long staffid;
	private String staffName;
	private long tagNumber;
	private long siteid;
	private String siteName;
	
	@OneToMany(cascade ={CascadeType.PERSIST, CascadeType.MERGE}, fetch=FetchType.LAZY)
    @JoinTable(
            name = "t_program_site_door",
            joinColumns = @JoinColumn(name = "id"),
            inverseJoinColumns = @JoinColumn(name = "door_id")
            )
	private Set<TotalDoorsModal> doors;

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public long getStaffid() {
		return staffid;
	}

	public void setStaffid(long staffid) {
		this.staffid = staffid;
	}

	public String getStaffName() {
		return staffName;
	}

	public void setStaffName(String staffName) {
		this.staffName = staffName;
	}

	public long getTagNumber() {
		return tagNumber;
	}

	public void setTagNumber(long tagNumber) {
		this.tagNumber = tagNumber;
	}

	public long getSiteid() {
		return siteid;
	}

	public void setSiteid(long siteid) {
		this.siteid = siteid;
	}

	public String getSiteName() {
		return siteName;
	}

	public void setSiteName(String siteName) {
		this.siteName = siteName;
	}

	public Set<TotalDoorsModal> getDoors() {
		return doors;
	}

	public void setDoors(Set<TotalDoorsModal> doors) {
		this.doors = doors;
	}

	@Override
	public String toString() {
		return "ProgramToSite [id=" + id + ", staffid=" + staffid + ", staffName=" + staffName + ", tagNumber="
				+ tagNumber + ", siteid=" + siteid + ", siteName=" + siteName + ", doors=" + doors + "]";
	}

	public ProgramToSite() {
		super();
		// TODO Auto-generated constructor stub
	}

	public ProgramToSite(long staffid, String staffName, long tagNumber, long siteid, String siteName,
			Set<TotalDoorsModal> doors) {
		super();
		this.staffid = staffid;
		this.staffName = staffName;
		this.tagNumber = tagNumber;
		this.siteid = siteid;
		this.siteName = siteName;
		this.doors = doors;
	}
	
	 
	 

}
