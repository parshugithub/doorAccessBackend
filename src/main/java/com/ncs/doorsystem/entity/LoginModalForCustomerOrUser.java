package com.ncs.doorsystem.entity;

public class LoginModalForCustomerOrUser 
{
	private Customer customer;
	private CreateUserModal createuser;
	public Customer getCustomer() {
		return customer;
	}
	public void setCustomer(Customer customer) {
		this.customer = customer;
	}
	public CreateUserModal getCreateuser() {
		return createuser;
	}
	public void setCreateuser(CreateUserModal createuser) {
		this.createuser = createuser;
	}
	@Override
	public String toString() {
		return "LoginModalForCustomerOrUser [customer=" + customer + ", createuser=" + createuser + "]";
	}
	public LoginModalForCustomerOrUser(Customer customer, CreateUserModal createuser) {
		super();
		this.customer = customer;
		this.createuser = createuser;
	}
	public LoginModalForCustomerOrUser() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	

}
