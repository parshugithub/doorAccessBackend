package com.ncs.doorsystem.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.ncs.doorsystem.service.AdminDashBoardMainService;

@RestController
@RequestMapping("/admindashboard")
public class AdminDashBoardMainController 
{
	@Autowired
	AdminDashBoardMainService service;
	
	@RequestMapping(value = "/getCustomer", method = { RequestMethod.GET,RequestMethod.POST }, produces = "application/json")
	public @ResponseBody int getCustomer()
	{
		int noOFCustomers = service.getCustomer();
		System.out.println("The ");
		return noOFCustomers;
		
	}
	@RequestMapping(value = "/getsites", method = { RequestMethod.GET,RequestMethod.POST }, produces = "application/json")
	public @ResponseBody int getSites()
	{
		int noOFCustomers = service.getSites();
		System.out.println("The ");
		return noOFCustomers;
		
	}

}
