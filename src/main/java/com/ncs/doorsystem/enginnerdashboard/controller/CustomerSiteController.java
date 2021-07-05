package com.ncs.doorsystem.enginnerdashboard.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.ncs.doorsystem.enginnerdashboard.entity.CustomerSiteModal;
import com.ncs.doorsystem.enginnerdashboard.entity.TotalDoorModal;
import com.ncs.doorsystem.enginnerdashboard.service.CustomerSiteService;

@RestController
@RequestMapping("/customersite")
public class CustomerSiteController 
{
	@Autowired
	CustomerSiteService service; 
	
	@PostMapping(value = "/create", produces = "application/json")
	public @ResponseBody CustomerSiteModal createCustomerSite(@RequestBody CustomerSiteModal sitemodal ,@RequestParam("custid") long custid) throws Exception
	{
		CustomerSiteModal response = service.createCustomerSite(sitemodal,custid);
		
		return response;
		
	}
	
	@GetMapping(value = "/getall", produces = "application/json")
	public @ResponseBody List<CustomerSiteModal> getSites(@RequestParam("custid") long custid) throws Exception
	{
		List<CustomerSiteModal> response = service.getSites(custid);
		
		return response;
		
	}
	
	@GetMapping(value = "/sendmqtt", produces = "application/json")
	public @ResponseBody String sendMQTT(@RequestParam("custid") long custid,@RequestParam("siteid") long siteid) throws Exception
	{
		String response = service.sendMQTT(custid, siteid);
		
		return response;
		
	}
	

}
