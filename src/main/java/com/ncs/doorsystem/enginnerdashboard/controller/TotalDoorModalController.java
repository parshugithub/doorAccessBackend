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
import com.ncs.doorsystem.enginnerdashboard.service.TotalDoorModalService;

@RestController
@RequestMapping("/totaldoor")
public class TotalDoorModalController 
{
	@Autowired
	TotalDoorModalService service;
	
	@PostMapping(value = "/create", produces = "application/json")
	public @ResponseBody TotalDoorModal createDoors(@RequestBody TotalDoorModal doormodal ,@RequestParam("custid") long custid,@RequestParam("siteid") long siteid) throws Exception
	{
		TotalDoorModal response = service.createDoors(doormodal,custid,siteid);
		
		return response;
		
	}
	
	@GetMapping(value = "/getall", produces = "application/json")
	public @ResponseBody List<TotalDoorModal> getDoors(@RequestParam("custid") long custid,@RequestParam("siteid") long siteid) throws Exception
	{
		List<TotalDoorModal> response = service.getDoors(custid,siteid);
		
		return response;
		
	}
	

}
