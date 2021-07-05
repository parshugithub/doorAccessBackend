package com.ncs.doorsystem.enginnerdashboard.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class FireInputModel {
	
	
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int doorid;
	private int activatedondoor;
	private String lockrelay1;
	private String lockrelay2;
	private long siteid;
	public int getDoorid() {
		return doorid;
	}
	public void setDoorid(int doorid) {
		this.doorid = doorid;
	}
	public int getActivatedondoor() {
		return activatedondoor;
	}
	public void setActivatedondoor(int activatedondoor) {
		this.activatedondoor = activatedondoor;
	}
	public String getLockrelay1() {
		return lockrelay1;
	}
	public void setLockrelay1(String lockrelay1) {
		this.lockrelay1 = lockrelay1;
	}
	public String getLockrelay2() {
		return lockrelay2;
	}
	public void setLockrelay2(String lockrelay2) {
		this.lockrelay2 = lockrelay2;
	}
	public long getSiteid() {
		return siteid;
	}
	public void setSiteid(long siteid) {
		this.siteid = siteid;
	}
	public FireInputModel(int doorid, int activatedondoor, String lockrelay1, String lockrelay2, long siteid) {
		super();
		this.doorid = doorid;
		this.activatedondoor = activatedondoor;
		this.lockrelay1 = lockrelay1;
		this.lockrelay2 = lockrelay2;
		this.siteid = siteid;
	}
	public FireInputModel() {
		super();
		// TODO Auto-generated constructor stub
	}
	@Override
	public String toString() {
		return "FireInputModel [doorid=" + doorid + ", activatedondoor=" + activatedondoor + ", lockrelay1="
				+ lockrelay1 + ", lockrelay2=" + lockrelay2 + ", siteid=" + siteid + "]";
	}
	
	
}
