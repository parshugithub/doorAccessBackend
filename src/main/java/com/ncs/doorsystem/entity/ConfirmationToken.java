package com.ncs.doorsystem.entity;

import java.util.Date;
import java.sql.Timestamp;
import java.time.format.DateTimeFormatter;
import java.util.Calendar;
import java.util.UUID;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonFormat;




@Entity
@Table(name = "Confrirmation_token")
public class ConfirmationToken 
{
	private static final int EXPIRATION = 10 * 1;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long tokenid;
	private String token;
	@OneToOne(targetEntity = Customer.class)
    @JoinColumn(nullable = false, name = "id")
	private Customer customer;
	@JsonFormat(pattern="yyyy-MM-dd HH:mm:ss")
	private Date createdDate;
	@JsonFormat(pattern="yyyy-MM-dd HH:mm:ss")
	private Date expirdDate;


	public Long getTokenid() {
		return tokenid;
	}
	public void setTokenid(Long token_id) {
		this.tokenid = token_id;
	}
	public String getToken() {
		return token;
	}
	public void setToken(String token) {
		this.token = token;
	}
	public Customer getCustomer() {
		return customer;
	}
	public void setCustomer(Customer customer) {
		this.customer = customer;
	}
	public Date getCreatedDate() {
		return createdDate;
	}
	public void setCreatedDate(Date createdDate) {
		this.createdDate = createdDate;
	}
	public Date getExpirdDate() {
		return expirdDate;
	}
	public void setExpirdDate(Date expirdDate) {
		this.expirdDate = expirdDate;
	}

	public ConfirmationToken() {
		super();
	}

	public ConfirmationToken(final String token) {
		super();

		this.token = token;
		this.expirdDate = calculateExpiryDate(EXPIRATION);
	}

	private Date calculateExpiryDate(int expiryTimeInMinutes) {
		Calendar calendar = Calendar.getInstance();
		calendar.setTime(new Timestamp(calendar.getTime().getTime()));
		// calendar.add(Calendar.MINUTE, expiryTimeInMinutes);
		// calendar.setTimeInMillis(new Date().getTime());
		calendar.add(Calendar.MINUTE, expiryTimeInMinutes);
		return new Date(calendar.getTime().getTime());
	}
	public ConfirmationToken( final Customer customer) {
		super();
		Calendar calendar = Calendar.getInstance();

		this.token = UUID.randomUUID().toString();;
		this.customer = customer;
		this.createdDate = new Date(calendar.getTime().getTime());
		this.expirdDate = calculateExpiryDate(EXPIRATION);
	}
	@Override
	public String toString() {
		return "ConfirmationToken [token_id=" + tokenid + ", token=" + token + ", customer=" + customer
				+ ", createdDate=" + createdDate + ", expirdDate=" + expirdDate + "]";
	}
	public ConfirmationToken(Long token_id, String token, Customer customer, Date createdDate, Date expirdDate) {
		super();
		this.tokenid = token_id;
		this.token = token;
		this.customer = customer;
		this.createdDate = createdDate;
		this.expirdDate = expirdDate;
	}
	
	


}



