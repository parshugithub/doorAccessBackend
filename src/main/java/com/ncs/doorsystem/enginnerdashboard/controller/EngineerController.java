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
import com.ncs.doorsystem.enginnerdashboard.entity.EngineerEntity;
import com.ncs.doorsystem.enginnerdashboard.service.EngineerService;

@RestController
@RequestMapping("engineer")
public class EngineerController
{
	@Autowired
	EngineerService service;
	
	@PostMapping(value = "/create", produces = "application/json")
	public @ResponseBody EngineerEntity createEngineer(@RequestBody EngineerEntity enginner) throws Exception
	{
		EngineerEntity response = service.createEngineer(enginner); 
		if(response!=null)
		{
			return response;
		}
		
		else
		{
			throw new Exception("Engineer already exists");
		}
		
	}
	
	
	@GetMapping(value = "/getallengineer", produces = "application/json")
	public @ResponseBody List<EngineerEntity> getAllEngineer() throws Exception
	{
		List<EngineerEntity> response = service.getAllEngineer(); 
		if(response!=null)
		{
			return response;
		}
		return response;
		
		
		
	}
	
	
	@GetMapping(value = "/getengineer", produces = "application/json")
	public @ResponseBody EngineerEntity getEngineer(@RequestParam("id") long id) throws Exception
	{
		EngineerEntity response = service.getEngineer(id); 
		if(response!=null)
		{
			return response;
		}
		return response;
		
		
		
	}
	
	@PutMapping(value = "/update", produces = "application/json")
	public @ResponseBody EngineerEntity updateEngineer(@RequestBody EngineerEntity enginner,@RequestParam("id") long id) throws Exception
	{
		EngineerEntity  response = service.updateEngineer(enginner,id); 
		if(response!=null)
		{
			return response;
		}
		return response;
		
		
		
	}
	
	@DeleteMapping(value = "/delete")
	public @ResponseBody String deleteEngineer(@RequestParam("id") long id) throws Exception
	{
		String  response = service.deleteEngineer(id); 
		if(response!=null)
		{
			return response;
		}
		else
		{
			return "Engineer delete unsuccessful";
		}
		
		
		
		
	}
	
	

}
