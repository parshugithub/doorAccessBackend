package com.ncs.doorsystem.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "personmanagement_property_table")
public class PersonManagementProperty 
{
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	private long flatnumber;
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
	public PersonManagementProperty(long id, long flatnumber) {
		super();
		this.id = id;
		this.flatnumber = flatnumber;
	}
	public PersonManagementProperty() {
		super();
		// TODO Auto-generated constructor stub
	}
	@Override
	public String toString() {
		return "PersonManagementProperty [id=" + id + ", flatnumber=" + flatnumber + "]";
	}
	
	
	
	

}
