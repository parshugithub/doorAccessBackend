package com.ncs.doorsystem.entity;

import java.util.Collection;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;

@Entity
@Table(name="total_doors_table")
//@JsonIdentityInfo(
//		scope = TotalDoorsModal.class,
//        generator = ObjectIdGenerators.IntSequenceGenerator.class,
//        property = "doorId"
//        )
public class TotalDoorsModal 
{
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int doorId;
	
	private long doorName;
	public int getDoorId() {
		return doorId;
	}
	public void setDoorId(int doorId) {
		this.doorId = doorId;
	}
	public long getDoorName() {
		return doorName;
	}
	public void setDoorName(long doorName) {
		this.doorName = doorName;
	}
	public TotalDoorsModal(int doorId, long doorName) {
		super();
		this.doorId = doorId;
		this.doorName = doorName;
	}
	public TotalDoorsModal() {
		super();
		// TODO Auto-generated constructor stub
	}
	@Override
	public String toString() {
		return "TotalDoorsModal [doorId=" + doorId + ", doorName=" + doorName + "]";
	}
	
	

}
