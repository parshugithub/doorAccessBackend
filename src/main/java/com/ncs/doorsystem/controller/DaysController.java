package com.ncs.doorsystem.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.ncs.doorsystem.entity.Days;
import com.ncs.doorsystem.entity.TotalDoorsModal;
import com.ncs.doorsystem.service.DaysService;

@RestController
@RequestMapping("/days")
public class DaysController 
{
	@Autowired
	DaysService service;
	
	@GetMapping(value = "/getday")
	public @ResponseBody Days findDoor(@RequestParam("day") String day)
	{	
		Days list=service.findDay(day);
		
		return list;
		
	}
	@PostMapping(value="/create",produces = "application/json")
	public @ResponseBody Days createDoor(@RequestBody Days modal ) throws Exception
	{
		
		return service.createDoor(modal);
		
	}

}
