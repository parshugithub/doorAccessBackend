package com.ncs.doorsystem.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.ncs.doorsystem.entity.SchedulesValuesModal;
import com.ncs.doorsystem.entity.TagModal;
import com.ncs.doorsystem.service.SchedulesService;

@RestController
@RequestMapping("/schedules")
public class SchedulesController 
{
	@Autowired
	SchedulesService service;
	
	@GetMapping(value = "/allhours")
	public @ResponseBody List<Object> getAllHours()
	{	
	List<Object> list=service.findAllHours();
		
		return list;
		
	}
	
	@GetMapping(value = "/allminutes")
	public @ResponseBody List<Object> getAllMinutes()
	{	
	List<Object> list=service.getAllMinutes();
		
		return list;
		
	}
	
	@GetMapping(value = "/alldays")
	public @ResponseBody List<Object> getAllDays()
	{	
	List<Object> list=service.getAllDays();
		
		return list;
		
	}
	
	@GetMapping(value = "/days")
	public @ResponseBody String getDay(@RequestParam("day") String day)
	{	
		String list=service.getDay(day);
		System.out.println("res "+list);
		
		return list;
		
	}
	
	
	@PostMapping(value="/create",produces = "application/json")
	public ResponseEntity<Object>  createSchedules() throws Exception
	{
		
		return service.createSchedules();
		
	}
	
	

}
