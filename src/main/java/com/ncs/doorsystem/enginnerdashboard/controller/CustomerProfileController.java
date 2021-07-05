package com.ncs.doorsystem.enginnerdashboard.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.ncs.doorsystem.enginnerdashboard.entity.CustomerProfile;
import com.ncs.doorsystem.enginnerdashboard.service.CustomerProfileService;

@RestController
@RequestMapping("/customerprofile")
public class CustomerProfileController 
{
	@Autowired
	CustomerProfileService servcie;
	
	@PostMapping(value = "/create", produces = "application/json")
	public @ResponseBody CustomerProfile createCustomerProfile(@RequestBody CustomerProfile customer,@RequestParam("engid") long engid) throws Exception
	{
		CustomerProfile response = servcie.createCustomerProfile(customer,engid); 
		if(response!=null)
		{
			return response;
		}
		
		else
		{
			throw new Exception("Customer already exists");
		}
		
	}
	
	@PutMapping(value = "/update", produces = "application/json")
	public @ResponseBody CustomerProfile updateCustomerProfile(@RequestBody CustomerProfile customer,@RequestParam("custid") long custid) throws Exception
	{
		CustomerProfile response = servcie.updateCustomerProfile(customer,custid); 
		if(response!=null)
		{
			return response;
		}
		
		else
		{
			throw new Exception("Customer already exists");
		}
		
	}
	@DeleteMapping(value = "/delete")
	public @ResponseBody String deleteCustomerProfile(@RequestParam("custid") long custid) throws Exception
	{
		String response = servcie.deleteCustomerProfile(custid); 
		if(response==null)
		{
			return "Failed to delete Customer Profile";
		}
		return response;
		
		
		
	}
	
	@GetMapping(value = "/all", produces = "application/json")
	public List<CustomerProfile> getAllCustomers(@RequestParam("engid") long engid)
	{
		return servcie.getAllCustomers(engid);
		
	}
	
	@GetMapping(value = "/allforadmin", produces = "application/json")
	public List<CustomerProfile> getAllCustomersForAdmin()
	{
		return servcie.getAllCustomersForAdmin();
		
	}
	@GetMapping(value = "/singleall", produces = "application/json")
	public CustomerProfile  getCustomers( @RequestParam("custID") long custID)
	{
		return servcie.getCustomers(custID);
		
	}

}
