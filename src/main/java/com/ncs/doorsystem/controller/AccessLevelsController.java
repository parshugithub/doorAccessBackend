package com.ncs.doorsystem.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.ncs.doorsystem.entity.AccessLevels;
import com.ncs.doorsystem.service.AccessLevelsService;

@RestController
@RequestMapping("/accesslevels")
public class AccessLevelsController 
{
	@Autowired
	AccessLevelsService service;
	
	
	@GetMapping(path="/getall")
	public List<AccessLevels> getAccessLevels()
	{
		List<AccessLevels> result = service.getAccessLevels();
		return result;
		
	}
	
	@PostMapping(path = "/create")
	public AccessLevels createAccessLevels(@RequestBody AccessLevels access)
	{
		
		return service.createAccessLevels(access);
		
	}

}
