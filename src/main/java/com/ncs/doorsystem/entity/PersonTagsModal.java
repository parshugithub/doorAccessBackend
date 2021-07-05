package com.ncs.doorsystem.entity;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonFormat;

@Entity
@Table(name = "person_tags_table")
public class PersonTagsModal 
{
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	private long personid;
	private String tagcode;
	private String tagcolor;
	@JsonFormat(pattern="dd-m-yyyy hh:mm:ss")
	private Date tagExpiray;
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public long getPersonid() {
		return personid;
	}
	public void setPersonid(long personid) {
		this.personid = personid;
	}
	public String getTagcode() {
		return tagcode;
	}
	public void setTagcode(String tagcode) {
		this.tagcode = tagcode;
	}
	public String getTagcolor() {
		return tagcolor;
	}
	public void setTagcolor(String tagcolor) {
		this.tagcolor = tagcolor;
	}
	public Date getTagExpiray() {
		return tagExpiray;
	}
	public void setTagExpiray(Date tagExpiray) {
		this.tagExpiray = tagExpiray;
	}
	@Override
	public String toString() {
		return "PersonTagsModal [id=" + id + ", personid=" + personid + ", tagcode=" + tagcode + ", tagcolor="
				+ tagcolor + ", tagExpiray=" + tagExpiray + "]";
	}
	public PersonTagsModal(long id, long personid, String tagcode, String tagcolor, Date tagExpiray) {
		super();
		this.id = id;
		this.personid = personid;
		this.tagcode = tagcode;
		this.tagcolor = tagcolor;
		this.tagExpiray = tagExpiray;
	}
	public PersonTagsModal() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
	
	

}
