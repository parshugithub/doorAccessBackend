package com.ncs.doorsystem.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.MetaValue;

@Entity
@Table(name = "propery_table")
public class Property 
{
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	private long flatnumber;
	@Override
	public String toString() {
		return "Property [id=" + id + ", flatnumber=" + flatnumber + "]";
	}
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public long getFlatnumber() {
		return flatnumber;
	}
	public void setFlatnumber(long flatnumber) {
		this.flatnumber = flatnumber;
	}
	public Property() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
}
